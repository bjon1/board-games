import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends BoardGames{ 

    private char[] movesData = new char[9];
    private boolean player1_turn;
    private int numOfMoves;

    public TicTacToe(){
        this(true);
    }

    public TicTacToe(boolean p){
        super(3);
        game = "Tic-Tac-Toe";
        numOfMoves = 0;
        textfield.setText(game);
        this.player1_turn = p;  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < buttons.length; i++){ //check each of our 9 buttons
            if(e.getSource() == buttons[i]){ //if the action event was performed on button[i]...
                if(player1_turn){ //if it is player1's turn, check to see if there is already text assigned to this button
                    if(buttons[i].getText() == "" && movesData[i] == 0){ 
                        updateMovesData(i, 'X');
                        buttons[i].setForeground(new Color(255,0,0)); //change the foreground
                        setTurn(false); //make it player1's turn
                        checkWin("X wins");
                    } 
                } else {
                    if(buttons[i].getText() == ""){ //if there is no text on the button...
                        updateMovesData(i, 'O');
                        buttons[i].setForeground(new Color(0,0,255)); //change the foreground
                        setTurn(true); //make it player2's turn
                        checkWin("O wins");
                    }                 
                }
            }
        }
    }
    
    public void updateMovesData(int i, char c){ 
        movesData[i] = c;
        numOfMoves++;
        if(c == 'X'){
            buttons[i].setText("X"); //put an X
        } else {
            buttons[i].setText("O"); //put an O
        }
    }

    public boolean getTurn(){
        return player1_turn;
    }

    public void setTurn(boolean val){
        if(val){
            textfield.setText("X turn"); //change the text to X-turn
        } else {
            textfield.setText("O turn"); //change the text to O-turn
        }
        player1_turn = val;
    }

    public void checkWin(String winner){
        if(numOfMoves == 9){
            closeButtons();
            textfield.setText("Draw!");
        }

        char sym = winner.charAt(0);

        if(movesData[0] == sym && movesData[1] == sym && movesData[2] == sym){
            wins(0, 1, 2, winner);
        } else if(movesData[3] == sym && movesData[4] == sym && movesData[5] == sym){
            wins(3, 4, 5, winner);
        } else if(movesData[6] == sym && movesData[7] == sym && movesData[8] == sym){
            wins(6, 7, 8, winner);
        } else if(movesData[0] == sym && movesData[3] == sym && movesData[6] == sym){
            wins(0, 3, 6, winner);
        } else if(movesData[1] == sym && movesData[4] == sym && movesData[7] == sym){
            wins(1, 4, 7, winner);
        } else if(movesData[2] == sym && movesData[5] == sym && movesData[8] == sym){
            wins(2, 5, 8, winner);
        } else if(movesData[0] == sym && movesData[4] == sym && movesData[8] == sym){
            wins(0, 4, 8, winner);
        } else if(movesData[2] == sym && movesData[4] == sym && movesData[6] == sym){
            wins(2, 4, 6, winner);
        } 
    }

    public void wins(int a, int b, int c, String winner){
        if(winner.equals("X wins")){
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
            textfield.setText(winner);
        } else {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
            textfield.setText(winner);
        }
        closeButtons();
    }

    public void closeButtons(){
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
    }
    
}
