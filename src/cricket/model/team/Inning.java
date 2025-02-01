package cricket.model.team;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import cricket.Constants;

/**
 * Class representing a cricket inning detail
 * The major attributes are runs, overs, wickets and description (if any- first innings/second innings)
 *
 */
public class Inning implements Comparable<Inning> {

    private int runs;
    private String overs;
    private int wickets;
    private String description;

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s ===> runs=%s, overs=%s, wickets=%s", description, runs, overs, wickets);
    }

    /**
     * Static function to create a Inning object by parsing the XML Node
     * @param node
     * @return
     */
    public static Inning getInningFromXML(Node node) {
        Element e = (Element) node;
        Inning inning = new Inning();
        inning.runs = Integer.valueOf(e.getAttribute(Constants.INNING_XML.RUNS));
        inning.description = e.getAttribute(Constants.INNING_XML.DESC);
        inning.overs = e.getAttribute(Constants.INNING_XML.OVERS);
        inning.wickets = Integer.valueOf(e.getAttribute(Constants.INNING_XML.WICKETS));
        return inning;
    }

    /**
     * CompareTo is used to define natural ordering of elements in a collection
     * A team can have multiple innings (Eg : for a test match)
     * In this case, we need to order the innings
     *
     * Here innings will be sorted by their description
     *
     * Eg : we have multiple Inning objects in a List with desc as (Inn1, Inn3, Inn2)
     *
     * On calling #{Collections.sort(innings);}, the order of objects will be [Inn1, Inn2, Inn3]
     *
     */
    @Override
    public int compareTo(Inning o) {
        return this.description.compareTo(o.description);
    }
}