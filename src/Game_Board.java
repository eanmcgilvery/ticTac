import java.util.Scanner;

class Game_Board {

    //Intialize a 2d array that will keep track of the player positions
    private char [][] board_ = new char[3][3];
    private boolean play_;
    private int player_;
    private char x_or_o_;
    private int row_;
    private int column_;
    private Scanner input = new Scanner(System.in);

    Game_Board(){
        player_ = 1;
        x_or_o_ = 'X';
        play_ = true;
    }

    //Function to display the Welcome message to the screen
    private void welcomeMessage(){
        System.out.println("Welcome to Tic-Tac-Toe\n");
        System.out.println("=======================");
    }

    //Function to print out the tic tac toe board
    private void printGameBoard() {

    }

    //Function to take turns
    private void turn(){
        //Statement that tell s whose turn it is
        System.out.println("Player " + player_ + " turn " + x_or_o_);
        printGameBoard();

        //Gather user Choice
        System.out.println("Which Row would you like?");
        row_ = input.nextInt();
        System.out.println("Which Column would you like?");
        column_ = input.nextInt();

        board_[row_][column_] = x_or_o_;

    }

    //Function to determine if the user wishes to play again.
    private void playAgain(){
        //Gather user input
        System.out.println("Would you like to play Again? (Enter Y or N)");
        char answer_ = input.next().charAt(0);
        //Check answer
        play_ = answer_ == 'Y' || answer_ == 'y';
    }


    //Main Event handling function that brings together all game functions
    public void gameLoop(){
        while(play_){
            welcomeMessage();

            playAgain();
        }

    }

}
