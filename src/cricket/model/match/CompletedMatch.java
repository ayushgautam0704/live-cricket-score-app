package cricket.model.match;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cricket.Constants;

public class CompletedMatch extends Match {
    public CompletedMatch() {
        current = "complete";
    }

    private String manOfTheMatch;

    public String getManOfTheMatch() {
        return manOfTheMatch;
    }

    public void setManOfTheMatch(String manOfTheMatch) {
        this.manOfTheMatch = manOfTheMatch;
    }

    @Override
    public void printSpecificDetails() {
        System.out.println("Man Of the Match = " + manOfTheMatch);
    }

    @Override
    public void populateSpecificDetails(Node matchNode) {
        Element matchElement = (Element) matchNode;
        Element momElement = (Element) matchElement.getElementsByTagName(Constants.MATCH_XML.MOM_PARENT).item(0);
        if (null != momElement) {
            Element momChild = (Element) momElement.getElementsByTagName(Constants.MATCH_XML.MOM_CHILD).item(0);
            if (null != momChild) {
                this.setManOfTheMatch(momChild.getAttribute("Name"));
            }
        }
    }
}