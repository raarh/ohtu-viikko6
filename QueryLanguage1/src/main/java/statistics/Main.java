package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasFewerThan(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        printPlayers(stats,m);
        m = new Or( new HasFewerThan(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        printPlayers(stats,m);
    }
    private static void printPlayers(Statistics stats, Matcher m ){
        System.out.println("---");
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
