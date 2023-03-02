import java.util.Scanner;

public class FantasyBasketball {

    public void compareGames() {

        Scanner input = new Scanner(System.in);

        String player = "";
        int numberOfPlayers = 0;
        int rank = 1;
        String realRank = "";
        double fantasyScore = 0;
        String realFantasyScore = "";
        String gameScores[][] = new String[10][3];

        System.out.println("This method allows you to compare certain players' stats in a basketball game and rank them by how many fantasy points they would have gotten. You can add however many players you like to your list, and the stats must all be from the same game.");


        do {

            if (numberOfPlayers > 9) {
                break;
            }

            System.out.println("Would you like to add a player to your list? *Respond with 'yes' in all lowercase if you would like to add a player, or 'done' in all lowercase if you are done making your list.*");
            String proceed = input.nextLine();
            
            if ("yes".equals(proceed)) {
                System.out.println("What is your player's name?");
                player = input.nextLine();
                
                System.out.println("How many points did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int points = Integer.parseInt(input.nextLine());

                System.out.println("How many rebounds did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int rebounds = Integer.parseInt(input.nextLine());

                System.out.println("How many assists did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int assists = Integer.parseInt(input.nextLine());

                System.out.println("How many blocks did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int blocks = Integer.parseInt(input.nextLine());

                System.out.println("How many steals did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int steals = Integer.parseInt(input.nextLine());

                System.out.println("How many turnovers did " + player + " have?");
                while (input.hasNextInt() == false) {
                    input.nextLine();
                    System.out.println("Please enter a positive integer value.");
                }
                int turnovers = Integer.parseInt(input.nextLine());
                
                fantasyScore = points + 1.2*rebounds + 1.5*assists + 2*blocks + 2*steals - turnovers;
                realFantasyScore = String.valueOf(fantasyScore);
                realRank = String.valueOf(rank);
                gameScores[numberOfPlayers][0] = realRank;
                gameScores[numberOfPlayers][1] = player;
                gameScores[numberOfPlayers][2] = realFantasyScore;
                fantasyScore = 0;
                numberOfPlayers += 1;
                rank += 1;
                }

            else if ("done".equals(proceed)) {
                break;
            }

            else {
                System.out.println("Please enter either 'yes' or 'done' in all lowercase. Would you like to add a player to your list?");
            }
        } while (true);
        
        for (int startingRange = 0; startingRange < numberOfPlayers; startingRange++) {
            for (int players = (numberOfPlayers - 1); players > startingRange; players--) {
                if ((Double.valueOf(gameScores[players][2])) > (Double.valueOf(gameScores[startingRange][2]))) {
                    String maxScore = gameScores[startingRange][2];
                    gameScores[startingRange][2] = gameScores[players][2];
                    gameScores[players][2] = maxScore;
                    String maxScoreOwner = gameScores[startingRange][1];
                    gameScores[startingRange][1] = gameScores[players][1];
                    gameScores[players][1] = maxScoreOwner;
                }
            }
        }

        System.out.println("Game Leaderboard:");
        for (int rows = 0; rows < numberOfPlayers; rows++) {
            System.out.println(gameScores[rows][0] + ". " + gameScores[rows][1] + ", " + gameScores[rows][2] + " fantasy points");
        }


        input.close();
    }
}