import java.util.Scanner;

class CricketPlayer {
    String name;
    int no_of_innings;
    int no_times_notout;
    int total_runs;
    double bat_avg;

    // Constructor
    CricketPlayer(String name, int innings, int notout, int runs) {
        this.name = name;
        this.no_of_innings = innings;
        this.no_times_notout = notout;
        this.total_runs = runs;
        this.bat_avg = 0;
    }

    // Static method to calculate average
    static double avg(CricketPlayer p) {
        int timesOut = p.no_of_innings - p.no_times_notout;

        if (timesOut <= 0) {
            throw new ArithmeticException("Cannot calculate average: player was never out.");
        }

        return (double) p.total_runs / timesOut;
    }

    // Static method to sort players by average
    static void sortPlayer(CricketPlayer[] players) {
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = i + 1; j < players.length; j++) {

                if (players[i].bat_avg > players[j].bat_avg) {
                    CricketPlayer temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }
            }
        }
    }

    // Display player details
    void display() {
        System.out.println(
            name + "\t" +
            no_of_innings + "\t" +
            no_times_notout + "\t" +
            total_runs + "\t" +
            String.format("%.2f", bat_avg)
        );
    }
}

public class CricketPlayers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        CricketPlayer[] players = new CricketPlayer[n];

        // Input player details
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Player " + (i + 1));

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Number of innings: ");
            int innings = sc.nextInt();

            System.out.print("Number of times not out: ");
            int notout = sc.nextInt();

            System.out.print("Total runs: ");
            int runs = sc.nextInt();

            players[i] = new CricketPlayer(name, innings, notout, runs);

            // Calculate average with exception handling
            try {
                players[i].bat_avg = CricketPlayer.avg(players[i]);
            }
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                players[i].bat_avg = 0;
            }
        }

        // Sort players according to batting average
        CricketPlayer.sortPlayer(players);

        // Display sorted details
        System.out.println("\nPlayers sorted by Batting Average:");
        System.out.println("Name\tInnings\tNotOut\tRuns\tAverage");

        for (int i = 0; i < n; i++) {
            players[i].display();
        }

        sc.close();
    }
}

