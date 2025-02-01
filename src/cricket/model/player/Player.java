package cricket.model.player;

public class Player {
    private String id;
    private String name;
    private String runs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return "Player [ID=" + id + ", Name=" + name + ", Runs=" + runs + "]";
    }
}
