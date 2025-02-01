package cricket;
import cricket.model.match.Match;
import cricket.model.match.UpcomingMatch;
import cricket.model.team.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CricBuzz {
    private static final String LIVE_MATCHES_URL = "http://synd.cricbuzz.com/j2me/1.0/livematches.xml";

    public List<Match> getLiveMatches() throws IOException {
        List<Match> matches = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
            Document doc = dbuilder.parse(LIVE_MATCHES_URL);
            NodeList nList = doc.getElementsByTagName("match");

            for (int i = 0; i < nList.getLength(); i++) {
                Node matchNode = nList.item(i);
                matches.add(Match.getMatchObjectFromXML(matchNode));
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error in fetching LIVE_MATCHES");
        }
        return matches;
    }

    public Match getMatchById(String matchID) throws IOException {
        List<Match> liveMatches = getLiveMatches();
        for (Match m : liveMatches) {
            if (m.getId().equals(matchID)) {
                return m;
            }
        }
        throw new IllegalArgumentException(String.format("No match found for ID : %s", matchID));
    }

    public Match getMatchDetails(String matchID) throws Exception {
        Match match = getMatchById(matchID);
        final String commentaryURL = match.getCommentaryURL();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
        Document doc = dbuilder.parse(commentaryURL);
        Node matchNode = doc.getElementsByTagName("match").item(0);
        Element matchElement = (Element) matchNode;

        setTeams(match, matchElement);
        match.populateSpecificDetails(matchNode);
        return match;
    }

    private void setTeams(final Match match, Element matchElement) {
        Element scores = (Element) matchElement.getElementsByTagName("mscr").item(0);
        Node team1Node = matchElement.getElementsByTagName("Tm").item(0);
        Node team2Node = matchElement.getElementsByTagName("Tm").item(1);

        Team team1 = Team.generateTeamObject(team1Node);
        Team team2 = Team.generateTeamObject(team2Node);
        if (match instanceof UpcomingMatch) {
            match.setBattingTeam(team1);
            match.setBowlingTeam(team2);
            return;
        }

        Node battingTeamNode = scores.getElementsByTagName("btTm").item(0);
        Node bowlingTeamNode = scores.getElementsByTagName("blgTm").item(0);

        if (match.getTossWonBy().equalsIgnoreCase(team1.getFullName())) {
            if (match.getDecisionOfTeamWinningToss().equalsIgnoreCase("Fielding")) {
                match.setBattingTeam(team2);
                match.setBowlingTeam(team1);
            } else {
                match.setBattingTeam(team1);
                match.setBowlingTeam(team2);
            }
        } else {
            if (match.getDecisionOfTeamWinningToss().equalsIgnoreCase("Fielding")) {
                match.setBattingTeam(team1);
                match.setBowlingTeam(team2);
            } else {
                match.setBattingTeam(team2);
                match.setBowlingTeam(team1);
            }
        }
        team1.setInnings(battingTeamNode);
        team2.setInnings(bowlingTeamNode);
    }

    public void printScoreOfSelectedMatch(String matchId) throws Exception {
        Match m = getMatchDetails(matchId);
        m.printMatchDetails();
    }

    public void printLiveMatches() throws IOException {
        System.out.println("---LIVE MATCHES---");
        List<Match> matches = getLiveMatches();
        int i = 1;
        for (Match m : matches) {
            m.printMatchSummary(i++);
        }
        System.out.println("---");
    }
}