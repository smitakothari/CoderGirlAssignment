// Created by Smita

// Problem statement - Design a Tic Tac Toe game

import java.util.Scanner;

public class TicTacToe
{
    static Scanner scanner = new Scanner(System.in);

    // gameCount - This variable will keep the track of how many games played
    static int gameCount = 1;

    // inputArray - This array will act as board for tic-tac-toe
    static char[][] inputArray = new char[3][3];

    // isXPlayedLast - if player X has taken 1st chance in last game
    static boolean isXPlayedLast = false;

    //which marker won the game
    static String winnerMarker = "";

    static int xScore = 0, oScore = 0;

    // main method
    public static void main(String[] args){
        displayWelcomeText();
        performTaskInSequence();
    }

    // method to display welcome text
    public static void displayWelcomeText(){
        System.out.println("Welcome to Tic Tac Toe! \n");
        System.out.println("To play, enter a number for which box to play in:");
        createBoardWithNumbers();
        System.out.println("\n You'll need a buddy to play with. Ready to begin? \n");
    }

    // method to perform all the task step by step
    public static void performTaskInSequence(){

        if(gameCount == 1){
            System.out.println(whichPlayer() + " moves first");
        }
        else{
            System.out.println(whichPlayer() + " moves first");
        }

        createEmptyBoard();

        while(isNotFull()){

            redrawBoard();
            if(isWin())
                break;
        }

        getScore();

        winnerMarker = "";

        playAgain();
    }

    // method to display board with numbers from 1 to 9
    public static void createBoardWithNumbers(){
        int count=1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(count++ + "  ");
            }
            System.out.println();
        }
    }

    // method to decide which marker to place next
    public static char whichPlayer(){
        boolean isXTurn;
        isXTurn = !isXPlayedLast;
        if(isXTurn){
            return 'X';
        }
        else{
            return '0';
        }
    }

    // method to display board with place holder "."
    public static void createEmptyBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                inputArray[i][j] ='.';
                if(j<2)
                    System.out.print(". | ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    // method returns true if the board is not full
    public static boolean isNotFull( ){
        
        boolean emptyArrayFlag=false;
        for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if (inputArray[i][j] == '.' )  {
                        emptyArrayFlag = true;
                        break;
                    } 
                    else{
                            emptyArrayFlag = false;
                    }
                }
                if(emptyArrayFlag)
                    break;
            }
            return emptyArrayFlag;
    }
    
    // method to redraw board after placing marker on the number chosen by user
    public static void redrawBoard(){

        // input a position to place marker
        System.out.print("?  ");
        int number = scanner.nextInt();

        int count=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                count++;
                if(count == number){
                    if( inputArray[i][j] != '.'  ){
                        System.out.println("Sorry, " + count + " is already full. Try again.");
                    }
                    else{
                        inputArray[i][j] = whichPlayer();
                        isXPlayedLast = !isXPlayedLast;
                    }
                }

                if(j<2)
                    System.out.print(inputArray[i][j] + " | ");
                else
                    System.out.print(inputArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    // method to identify if there is a winner
    public static boolean isWin(){
        boolean winner = false;
        if(checkHorizontal() != null){
            System.out.println(checkHorizontal() + " is winner");
            winner = true;
            winnerMarker = checkHorizontal();
        }
        if(checkVertical() != null){
            System.out.println(checkVertical() + " is winner");
            winner = true;
            winnerMarker = checkVertical();
        }
        if(checkDiagonal() != null){
            System.out.println(checkDiagonal() + " is winner");
            winner = true;
            winnerMarker = checkDiagonal();
        }

        return winner;
    }

    // method to check board horizontally for winner
    public static String checkHorizontal(){
        String winner=null;
        for(int i=0; i<3; i++){
            if((inputArray[0][i] == inputArray[1][i]) ){
                if(inputArray[1][i] == inputArray[2][i])
                    if(inputArray[0][i] != '.')
                        winner = inputArray[0][i] + "";
                break;
            }
            if(winner != null)
                break;
        }
        return winner;
    }

    // method to check board vertically for winner
    public static String checkVertical(){
        //boolean winVertical = false;
        String winner=null;
        for(int i=0; i<3; i++){
            if((inputArray[i][0] == inputArray[i][1]) ){
                if(inputArray[i][1] == inputArray[i][2])
                    if(inputArray[i][0] != '.')
                        winner = inputArray[i][0] + "";
                break;
            }
            if(winner != null)
                break;
        }
        return winner;
        //System.out.println(inputArray[i][j] + "is winner");
    }

    // method to check board diagonally for winner
    public static String checkDiagonal(){
        String winner=null;

        if((inputArray[0][0] == inputArray[1][1]) ){
            if(inputArray[1][1] == inputArray[2][2]){
                if(inputArray[0][0] != '.')
                    winner = inputArray[0][0] + "";
            }
        }

        if((inputArray[0][2] == inputArray[1][1]) ){
            if(inputArray[1][1] == inputArray[2][0]){
                if(inputArray[0][2] != '.')
                    winner = inputArray[2][0] + "";
            }
        }

        return winner;
    }

    // method to check if the user wishes to play again
    public static void playAgain(){
        System.out.println("Would you like to play again? (yes or no)");
        String playAgain = scanner.next();
        if(playAgain.equals("yes")){
            gameCount++;
            performTaskInSequence();
        }
    }

    // method to keep track of score
    public static void getScore(){

        if(winnerMarker.equals("X"))
            xScore ++ ;
        else if(winnerMarker.equals("0"))
            oScore ++ ;
        else if(!isNotFull()){
            System.out.println("The game is a draw! Nobody wins.");
        }
        System.out.println("Score: X = " + xScore + " 0 = " + oScore);
    }

}