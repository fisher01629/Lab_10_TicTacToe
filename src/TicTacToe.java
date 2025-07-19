import java.util.Scanner;


public class TicTacToe
{
    //format of the board
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    // game being played and asks if continue when game is over
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String playAgain;
        do
        {
            clearBoard();
            playerMoves();
            playAgain = SafeInput.getNonZeroLenString(in,"Enter Y to quit or any other key to play again ");
            if(playAgain.equalsIgnoreCase("Y")){
                done = false;
            }
        }while(!done);
    }
    // this clears the board
    private static void clearBoard(){
        for(int row=0;row<ROWS;row++){
            for(int col=0;col<COLS;col++){
                board[row][col] = " ";
            }
        }
    }
    // this print the board with the moves on it if any
    private static void printBoard(){
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
    // this checks if the move is valid whether the move already exists by anothe player
    private static boolean isValidMove(int row, int col){
        boolean retVal = false;
        if(board[row][col].equals(" ")){
            retVal = true;
        }
        return retVal;
    }
    // this check to see if any has won
    private static boolean isWin(String player){
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player)){
            return true;
        }
        return false;
        // this checks if someone has a horizontal win
    }private static boolean isRowWin(String player)
{
    for (int row = 0; row < ROWS; row++)
    {
        if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
        {
            return true;
        }
    }
    return false; //no row win
    // this checks if someone has a vertical win
}private static boolean isColWin(String player)
{
    for (int col = 0; col < COLS; col++)
    {
        if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
        {
            return true;
        }
    }
    return false; //no row win
    // this checks if someone has a vertical win
}private static boolean isDiagonalWin(String player)
{
    if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
    {
        return true;
    }


    else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
    {
        return true;
    }
    return false;
    // this checks if all the spaces has been filled
}private static boolean isBoardFull() {
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLS; col++) {
            if (board[row][col].equals(" ")) {
                return false;
            }
        }
    }
    return true;
}
    // this checks if the game is over when all spaces is covered and no winner
    private static boolean isTie(){
        if (isBoardFull()) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }
    // this asks players for a valid move and displays the board after the move and checks for ties or wins.
    private static void playerMoves(){
        Scanner in = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int turns = 0;
        String playerAMove = "X";
        String playerBMove = "O";
        boolean gameOver = false;
        boolean done = false;
        do{
            do{
                System.out.println("Player A's turn.");
                row = SafeInput.getRangedInt(in, "Enter the row you want to select. ", 1, 3)-1;
                col = SafeInput.getRangedInt(in, "Enter the column you want to select. ", 1, 3)-1;
                if(isValidMove(row,col)){
                    board[row][col] = playerAMove;
                    printBoard();
                    done = true;
                    turns += 1;
                }else{
                    System.out.println("Invalid move. Try again.");
                }
                if(turns >=5){
                    if(isWin(playerAMove)){
                        System.out.println("Player A wins!");
                        gameOver = true;
                    }
                    else if(isTie()){
                        gameOver = true;
                    }
                }
            }while(!done);
            done = false;
            if(!gameOver){
                do{
                    System.out.println("Player B's turn.");
                    row = SafeInput.getRangedInt(in, "Enter the row you want to select. ", 1, 3)-1;
                    col = SafeInput.getRangedInt(in, "Enter the column you want to select. ", 1, 3)-1;
                    if(isValidMove(row,col)){
                        board[row][col] = playerBMove;
                        printBoard();
                        done = true;
                        turns += 1;
                    }else{
                        System.out.println("Invalid move. Try again.");
                    }
                    if(turns >=5){
                        if(isWin(playerBMove)){
                            System.out.println("Player B wins!");
                            gameOver = true;
                        }
                        else if(isTie()){
                            gameOver = true;


                        }
                    }
                }while(!done);
            }
        }while(!gameOver);






    }






}
