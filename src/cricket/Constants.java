package cricket;

public class Constants {

    public static final class MATCH_XML {
        public static final String ID = "id";
        public static final String DESC = "mchdesc";
        public static final String NUMBER = "mnum";
        public static final String SERIES = "srs";
        public static final String GROUND = "grnd";
        public static final String CITY = "vcity";
        public static final String COUNTRY = "vccountry";
        public static final String CURRENT_STATE = "state";
        public static final String STATUS = "status";
        public static final String DATAPATH = "datapath";
        public static final String TEAM_WINNING_TOSS = "TW";
        public static final String DECISION_OF_TEAM_WINNING_TOSS = "decism";
        public static final String CURRENT = "mcbState";
        public static final String MOM_PARENT = "manofthematch";
        public static final String MOM_CHILD = "mom";
        public static final String BATSMEN = "btsmn";
        public static final String BOWLERS = "blrs";
    }

    public static final class INNING_XML {
        public static final String RUNS = "r";
        public static final String WICKETS = "wkts";
        public static final String DESC = "desc";
        public static final String OVERS = "ovrs";
    }

    public static final class TEAM_XML {
        public static final String ID = "id";
        public static final String FULL_NAME = "Name";
        public static final String NAME = "sName";
        public static final String INNINGS = "Inngs";
    }

    public static final class PLAYER {
        public static final String ID = "id";
        public static final String NAME = "sName";
        public static final String RUNS = "r";
    }

    public static final class BATSMAN {
        public static final String BALLS = "b";
        public static final String FOURS = "frs";
        public static final String SIXES = "sxs";
    }

    public static final class BOWLER {
        public static final String WICKETS = "wkts";
        public static final String OVERS = "ovrs";
        public static final String MAIDENS = "mdns";
    }
}