package String_Processing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PROMPT:
 * VALID SUDOKU
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * 
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 * 
 */
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        
        HashSet<String> rowCheckSet = new HashSet<String>();
        HashMap<Integer,Set<String>> colCheckMap = new HashMap<Integer,Set<String>>();
        HashMap<Integer,Set<String>> boxCheckMap = new HashMap<Integer,Set<String>>();
        
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                String number = String.valueOf(board[i][j]);
                
                // Check the row set
                if(!rowCheckSet.contains(number)){
                    if(!number.equals(".")){
                        rowCheckSet.add(number);
                        // Check the col set
                        if(colCheckMap.get(j) == null){
                            HashSet<String> colSet = new HashSet<String>();
                            colSet.add(number);
                            colCheckMap.put(j,colSet);
                        }else{
                            if(!colCheckMap.get(j).contains(number)){
                                HashSet<String> oldColSet = new HashSet<String>(colCheckMap.get(j));
                                oldColSet.add(number);
                                colCheckMap.put(j,oldColSet);
                            }else{
                                return false;
                            }
                        }
                        
                        int boxRow = i / 3;
                        int boxCol = j / 3;
                        int boxIndex = boxRow * 3 + boxCol;
                        
                        // Check the box set
                        if(boxCheckMap.get(boxIndex) == null){
                            HashSet<String> boxSet = new HashSet<String>();
                            boxSet.add(number);
                            boxCheckMap.put(boxIndex,boxSet);
                        }else{
                            if(!boxCheckMap.get(boxIndex).contains(number)){
                                HashSet<String> oldBoxSet = new HashSet<String>(boxCheckMap.get(boxIndex));
                                oldBoxSet.add(number);
                                boxCheckMap.put(boxIndex,oldBoxSet);
                            }else{
                                return false;
                            }
                        }
                        
                    }
                    
                }else{
                    return false;
                }
                
                                        
            }
            rowCheckSet.clear();
        }
        
        return true;
    }
}