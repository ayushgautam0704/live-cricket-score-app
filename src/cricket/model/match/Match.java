package cricket.model.match;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cricket.Constants;
import cricket.model.team.Team;

public abstract class Match {
    private String id;
    private String matchName;
    private String seriesName;
    private String venue;
    private String dataPath;
    private String status;
    protected String current;
    private String tossWonBy;
    private String decisionOfTeamWinningToss;
    private Team battingTeam;
    private Team bowlingTeam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommentaryURL() {
        return dataPath + "commentary.xml";
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getTossWonBy() {
        return tossWonBy;
    }

    public void setTossWonBy(String tossWonBy) {
        this.tossWonBy = tossWonBy;
    }

    public String getDecisionOfTeamWinningToss() {
        return decisionOfTeamWinningToss;
    }

    public void setDecisionOfTeamWinningToss(String decisionOfTeamWinningToss) {
        this.decisionOfTeamWinningToss = decisionOfTeamWinningToss;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Match other = (Match) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Match [id=" + id + ", matchName=" + matchName + ", seriesName=" + seriesName + ", venue=" + venue
                + ", dataPath=" + dataPath + ", status=" + status + "]";
    }

    public static Match getMatchObjectFromXML(Node matchNode) {
        Element e = (Element) matchNode;
        Element state = (Element) e.getElementsByTagName(Constants.MATCH_XML.CURRENT_STATE).item(0);

        String current = state.getAttribute(Constants.MATCH_XML.CURRENT);
        Match match = createSpecificMatch(current);

        match.setId(e.getAttribute(Constants.MATCH_XML.ID));
        match.setMatchName(e.getAttribute(Constants.MATCH_XML.DESC) + "( " + e.getAttribute(Constants.MATCH_XML.NUMBER) + ")");
        match.setSeriesName(e.getAttribute(Constants.MATCH_XML.SERIES));
        match.setVenue(e.getAttribute(Constants.MATCH_XML.GROUND) + ", " + e.getAttribute(Constants.MATCH_XML.CITY) + ", "
                + e.getAttribute(Constants.MATCH_XML.COUNTRY));

        match.setStatus(state.getAttribute(Constants.MATCH_XML.STATUS));
        match.setTossWonBy(state.getAttribute(Constants.MATCH_XML.TEAM_WINNING_TOSS));
        match.setDecisionOfTeamWinningToss(state.getAttribute(Constants.MATCH_XML.DECISION_OF_TEAM_WINNING_TOSS));
        match.setDataPath(e.getAttribute(Constants.MATCH_XML.DATAPATH));
        return match;
    }

    public void printMatchDetails() {
        System.out.println("==================MATCH DETAILS===================");
        System.out.println("Series = " + seriesName);
        System.out.println("Match = " + matchName);
        System.out.println("Status = " + status);
        System.out.println("Current State = " + current);
        System.out.println("Toss Won By = " + tossWonBy);
        System.out.println("Decision of " + tossWonBy + " is " + decisionOfTeamWinningToss);

        System.out.println();
        System.out.println("Batting team");
        System.out.println("---");
        System.out.println(battingTeam);
        System.out.println("---");
        System.out.println("Bowling team");
        System.out.println("---");
        System.out.println(bowlingTeam);
        System.out.println("---");

        printSpecificDetails();
        System.out.println("===================");
    }

    public abstract void populateSpecificDetails(Node matchNode);

    public abstract void printSpecificDetails();

    public void printMatchSummary(int index) {
        System.out.println(String.format("%d. ID = %s, Name: %s %s", index, id, seriesName, matchName));
    }

    private static Match createSpecificMatch(String current) {
        if (current.equalsIgnoreCase("inprogress")) {
            return new LiveMatch();
        } else if (current.equalsIgnoreCase("complete")) {
            return new CompletedMatch();
        } else {
            return new UpcomingMatch();
        }
    }
}