import java.util.Scanner;

public class ConnectFour extends AbstractStrategyGame {

    public static final char PLAYER_1_TOKEN = 'X';
    public static final char PLAYER_2_TOKEN = 'O';
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;
    public static final int TIE = 0;
    public static final int GAME_IS_OVER = 1;
    public static final int GAME_NOT_OVER = -1;

    private char[][] gameState;
    private boolean isXTurn;
    private boolean isGameOver;

    public ConnectFour() {
        isXTurn = false;
        isGameOver = false;
        gameState = new char[7][6];
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[i].length; j++) {
                gameState[i][j] = ' ';  // loads the game state with empty chars
            }
        }
    }

    @Override
    public String instructions() {
        return "Connect 4 is a game for two people. Each player has their own letter, o or x.\n" +
                "Players take turns dropping a letter into one of the columns on the grid.\n" +
                "The disc falls down the next avaiable spot. The first player to get four of their " +
                "discs in a row — across, up and down, or diagonally — wins. \n" +
                "If the grid fills up and no one has four in a row, it's a tie.\n";
    }

    @Override
    public String toString() {
        String toReturn = "";

        for (int i = 1; i <= gameState.length; i++) {
            toReturn += " " + i + " ";
        }
        toReturn += "\n";

        for (int i = gameState[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < gameState.length; j++) {
                toReturn += String.format("[%c]", gameState[j][i]);
            }
            toReturn += "\n";
        }

        return toReturn;
    }

    @Override
    public int getWinner() {
        if (isGameOver) {
            return getNextPlayer();
        } else {
            return GAME_NOT_OVER;
        }

    }

    @Override
    public int getNextPlayer() {
        isXTurn = !isXTurn;
        if (isXTurn) {
            return PLAYER_1;
        } else {
            return PLAYER_2;
        }
    }

    @Override
    public String getMove(Scanner input) {

        if (input == null) {
            throw new IllegalArgumentException("The Scanner given was null");
        }

        System.out.print("What coloum would you like to place your charactor (1-7): ");

        while (!input.hasNextInt()) {
            System.out.println("That was not a number\n");
            input.next();
            System.out.print("What coloum would you like to place your charactor (1-7): ");
        }

        return input.next();

    }

    @Override
    public void makeMove(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String given was null");
        }
        if (Integer.parseInt(input) > gameState.length || Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("The number was not in the acceptiable range\n");
        }
        if (gameState[Integer.parseInt(input) - 1][gameState.length - 2] != ' ') {
            throw new IllegalArgumentException("This column is full");
        }

        int column = Integer.parseInt(input);

        for (int i = 0; i < gameState[column - 1].length; i++) {
            if (gameState[column - 1][i] == ' ') {
                if (isXTurn) {
                    gameState[column - 1][i] = PLAYER_1_TOKEN;
                } else {
                    gameState[column - 1][i] = PLAYER_2_TOKEN;
                }
                winChecker(column - 1, i);
                i += gameState.length;
            }

        }

    }

    private void winChecker(int index1, int index2) {

        int[][] directions = {
            {1, 0}, {0, 1}, {1, 1}, {1, -1},
            {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}
        };

        for (int[] dir : directions) {
            int count = 1;

            for (int sign = -1; sign <= 1; sign += 2) { // counts the negative steps after positive incase 
                                                        // a piece was placed in middle of a winning row
                for (int step = 1; step < 4; step++) {
                    int newX = index1 + dir[1] * step * sign;
                    int newY = index2 + dir[0] * step * sign;

                    if (newX < 0 || newX >= gameState.length ||
                            newY < 0 || newY >= gameState[0].length ||
                            gameState[newX][newY] != gameState[index1][index2]) {
                        step += 4; // breaks out of the for loop
                    } else {
                        count++;
                    }
                }
            }

            if (count >= 4) {
                isGameOver = true;

            }
        }

    }

}
