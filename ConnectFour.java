import java.util.Scanner;

public class ConnectFour extends AbstractStrategyGame {

    char[][] gameState;

    public ConnectFour(){
        gameState = new char[6][7]; // 6 7 HAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHA!!!!!!!
    }

    @Override
    public String instructions() {
        return "Connect 4 is a game for two people. Each player has their own letter, o or x." +
        "Players take turns dropping a letter into one of the columns on the grid. " +
        "The disc falls down the next avaiable spot. The first player to get four of their "+
        "discs in a row — across, up and down, or diagonally — wins. " +
        "If the grid fills up and no one has four in a row, it's a tie.";
    }

    @Override
    public String toString() {
        String toReturn = "";

        for(int i = 1; i < gameState[0].length; i++){
           toReturn += " " + i + " ";
        }
        toReturn += "\n";

        for(int i = 0; i < gameState.length; i++){
            for(int j = 0; j < gameState[i].length; j++){
                toReturn += String.format("[%c]", gameState[i][j]);
            }
            toReturn += "\n";
        }

        return toReturn;
    }

    @Override
    public int getWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWinner'");
    }

    @Override
    public int getNextPlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextPlayer'");
    }

    @Override
    public String getMove(Scanner input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMove'");
    }

    @Override
    public void makeMove(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }
    
}
