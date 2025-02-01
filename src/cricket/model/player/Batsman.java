package cricket.model.player;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cricket.Constants;

public class Batsman extends Player {
    private String balls;
    private String fours;
    private String sixes;

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public String getFours() {
        return fours;
    }

    public void setFours(String fours) {
        this.fours = fours;
    }

    public String getSixes() {
        return sixes;
    }

    public void setSixes(String sixes) {
        this.sixes = sixes;
    }

    public static Batsman getFromXML(Node batsmanNode) {
        Element e = (Element) batsmanNode;
        Batsman bats = new Batsman();
        bats.setId(e.getAttribute(Constants.PLAYER.ID));
        bats.setName(e.getAttribute(Constants.PLAYER.NAME));
        bats.setRuns(e.getAttribute(Constants.PLAYER.RUNS));
        bats.setBalls(e.getAttribute(Constants.BATSMAN.BALLS));
        bats.setFours(e.getAttribute(Constants.BATSMAN.FOURS));
        bats.setSixes(e.getAttribute(Constants.BATSMAN.SIXES));
        return bats;
    }

    @Override
    public String toString() {
        return "Batsman [balls=" + balls + ", fours=" + fours + ", sixes=" + sixes + 
               ", ID=" + getId() + ", Name=" + getName() + ", Runs=" + getRuns() + "]";
    }
}
