/*
Ean McGilvery
Assignment 1
Purpose of this Assignment is to create Tic Tac Toe using O.O priciples and a 2d Array
 */

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

        //initialize board to contain empty chars
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board_[i][j] = ' ';
            }
        }
    }

    //Function to display the Welcome message to the screen
    private void welcomeMessage(){
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("=======================");
    }

    //Function to print out the tic tac toe board
    private void printGameBoard() {
        System.out.print(board_[0][0] + " | " + board_[0][1] +  " | " + board_[0][2] + "\n" +
                         " -------\n" +
                         board_[1][0] + " | " + board_[1][1] +  " | " + board_[1][2] + "\n" +
                         " -------\n" +
                         board_[2][0] + " | " + board_[2][1] +  " | " + board_[2][2] + "\n");
    }

    //Function to take turns
    private void turn(){
        boolean legal = false;

        //Statement that tell s whose turn it is
        System.out.println("Player " + player_ + " turn " + x_or_o_);
        printGameBoard();

        //Keep asking user to input until given a legal move
        while (!legal) {
            //Gather user Choice
            System.out.println("Which Row would you like?");
            row_ = input.nextInt();
            System.out.println("Which Column would you like?");
            column_ = input.nextInt();

            if (!(board_[row_][column_] == ' ')){
                legal = false;
                System.out.println("Illegal Move. Try Again.");
            }
            else {
                break;
            }
        }
        board_[row_][column_] = x_or_o_;

    }

    //Update whose turn it is
    private void updateTurn() {
        if (player_ == 1){
            player_= 2;
            x_or_o_ = 'O';
        }
        else {
            player_ = 1;
            x_or_o_ = 'X';
        }
    }

    //Check if Diagonals are the same
    private boolean checkDiagonals(){
        return ((board_[0][0] == x_or_o_ && board_[1][1] == x_or_o_ && board_[2][2] == x_or_o_) ||
                (board_[0][2] == x_or_o_ && board_[1][1] == x_or_o_ && board_[2][0] == x_or_o_));
    }
    //Check to see if Rows are the same
    private boolean checkRow(){
        return ((board_[0][0] == x_or_o_ && board_[0][1] == x_or_o_ && board_[0][2] == x_or_o_) ||
                (board_[1][0] == x_or_o_ && board_[1][1] == x_or_o_ && board_[1][2] == x_or_o_) ||
                (board_[2][0] == x_or_o_ && board_[2][1] == x_or_o_ && board_[2][2] == x_or_o_));
    }
    //Check to see if Columns are the same
    private boolean checkColumn(){
        return ((board_[0][0] == x_or_o_ && board_[1][0] == x_or_o_ && board_[2][0] == x_or_o_) ||
                (board_[0][1] == x_or_o_ && board_[1][1] == x_or_o_ && board_[2][1] == x_or_o_) ||
                (board_[0][2] == x_or_o_ && board_[1][2] == x_or_o_ && board_[2][2] == x_or_o_));
    }
    //Check to see if board is full and nobody won
    private boolean catsGame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board_[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    private void gameLoop(){
        boolean winner = false;
        boolean cats = false;
        //Keep taking turns until a winner if found or it's a cats game
        while(!winner){
            turn();
            if(checkDiagonals() || checkRow() || checkColumn() || catsGame())
                if(catsGame()) {
                    //Cats game! We set winner to true just to break out of the game loop
                    winner = true;
                    cats = true;
                    System.out.println("Cat's Game!\n");
                    printGameBoard();
                }
                 else {
                    winner = true;
                    System.out.println(x_or_o_ + " Player Wins!\n");
                    printGameBoard();
                }
            updateTurn();
        }
    }


    //Function to determine if the user wishes to play again.
    private void playAgain(){
        //Gather user input
        System.out.println("Would you like to play Again? (Enter Y or N)");
        char answer_ = input.next().charAt(0);
        //Check answer
        play_ = answer_ == 'Y' || answer_ == 'y';
        if(play_){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    board_[i][j] = ' ';
                }
            }
        }
    }


    //Main Event handling function that brings together all game functions
    public void mainGame(){
        while(play_){
            welcomeMessage();
            gameLoop();
            playAgain();
        }
    }
}
