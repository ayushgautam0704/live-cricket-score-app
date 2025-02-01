package cricket.model.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cricket.Constants;

/**
 * Class representing a cricket team
 * For simplicity it contains
 * 1. Name of the team
 * 2. List of innings played by the team
 *
 */
public class Team {

    private String id;
    private String name;
    private String fullName;
    private List<Inning> innings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public void setInnings(List<Inning> innings) {
        this.innings = innings;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name : " + name).append("\n");
        for (Inning inn : innings) {
            builder.append(inn.toString()).append("\n");
        }
        return builder.toString();
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
        Team other = (Team) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * Static function to create a Team object by parsing the XML Node
     *
     * @param node
     * @return
     */
    public static Team generateTeamObject(Node teamNode) {
        Element e = (Element) teamNode;
        Team team = new Team();

        team.setId(e.getAttribute(Constants.TEAM_XML.ID));
        team.setName(e.getAttribute(Constants.TEAM_XML.NAME));
        team.setFullName(e.getAttribute(Constants.TEAM_XML.FULL_NAME));
        return team;
    }

    public void setInnings(Node teamNode) {
        Element e = (Element) teamNode;
        NodeList inningNodes = e.getElementsByTagName(Constants.TEAM_XML.INNINGS);

        for (int i = 0; i < inningNodes.getLength(); i++) {
            Node inningNode = inningNodes.item(i);
            this.innings.add(Inning.getInningFromXML(inningNode));
        }
        Collections.sort(this.innings);
    }
}