package games;
import board.BoardGames;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class Sudoku extends BoardGames {
    private char[][] boardValues;

    public Sudoku(){
        super(9);
        game = "Sudoku";
        textfield.setText(game);
    }

    public boolean isValidSudoku() { //checks to see if all the numbers in the board are valid
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(boardValues[i][j] != '.'){
                    //add() is a method that returns true if a value was successfully added
                    if(!seen.add(boardValues[i][j] + "in row" + i) || 
                       !seen.add(boardValues[i][j] + "in column" + j) || 
                       !seen.add(boardValues[i][j] + "in sub-square" + i/3 + " row and " + j/3 + " col")){
                        return false;
                    }
                }
            }
        }
        return true;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
