package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder qb = new QueryBuilder();
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        printPlayers(stats,m);
        m = qb.hasAtLeast(10,"goals").hasAtLeast(10, "assists").playsIn("PHI").build();
        printPlayers(stats,m);
        m = qb.oneOf(
                        qb.playsIn("PHI")
                             .hasAtLeast(10, "goals")
                             .hasFewerThan(15, "assists").build(),

                        qb.playsIn("EDM")
                             .hasAtLeast(50, "points").build()
                       ).build();
        printPlayers(stats,m);
    }
    private static void printPlayers(Statistics stats, Matcher m ){
        System.out.println("---");
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
