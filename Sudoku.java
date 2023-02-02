/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import static java.lang.String.valueOf;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author andrewy.lin
 * 
 */

/** 
 * This class creates a Sudoku game. It extends the class JFrame. 
 * @since 2023-01-28 
 * @version 1.0
 * @author Andrew Lin 
 */
public class Sudoku extends JFrame{
    private Button[][] buttonGrid;
    private static int ROWS = 9;    
    private static int COLS = 9;
    private int userInput;
    private boolean gameWin; 
    private JLabel message; 
    
    /** Getter method gets the gameWin boolean which determines whether the game has been won or not. 
     * 
     * @return the gameWin boolean
     */
    public boolean getgameWin(){
        return gameWin; 
    }
    
    /** Setter method sets the gameWin boolean. 
     * 
     * @param setWin is the boolean for whether game won or not. 
     */
    public void setgameWin(boolean setWin){
        this.gameWin = setWin; 
    }
    
    /** Getter method gets the user input. 
     * 
     * @return the userInput integer value. 
     */
    public int getuserInput(){
        return userInput; 
    }
    
    /** Setter method sets the user input value. 
     * @param setvalue is the new value of user input. 
     */
    public void setuserInput(int setvalue){
        this.userInput = setvalue; 
        System.out.println(setvalue);
    }
    
    /** Creates a 2D array for the SudokuNumbers
     * 
     */
    static int SudokuNumbers [][] =     {{9,6,2,4,5,1,3,7,8},
                                         {3,7,4,9,8,2,5,6,1},
                                         {1,8,5,7,3,6,4,2,9},
                                         {4,9,6,1,7,5,8,3,2},
                                         {2,1,8,3,6,9,7,4,5},
                                         {7,5,3,2,4,8,1,9,6},
                                         {5,3,1,6,2,7,9,8,4},
                                         {6,4,9,8,1,3,2,5,7},
                                         {8,2,7,5,9,4,6,1,3}};
    
    /** The 2D boolean array for whether to show the numbers on Sudoku game grids or not. 
     * 
     */
    static boolean SudokuGridShowOrNot [][] = {{true,true,false,true,false,true,true,false,false},
                                               {false,true,false,true,false,false,true,true,false},
                                               {false,false,false,true,false,false,false,true,false},
                                               {true,false,true,true,false,false,false,false,false},
                                               {false,false,true,false,true,false,false,false,false},
                                               {false,false,false,false,true,true,true,false,true},
                                               {true,false,false,true,false,true,true,false,false},
                                               {false,false,false,false,false,false,true,false,true},
                                               {true,true,false,false,false,false,true,false,true}};
    
    
//        static boolean SudokuGridShowOrNot [][] = {{true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,true,true},
//                                               {true,true,true,true,true,true,true,false,true}};
    
    
    /** The Sudoku game constructor. 
     * 
     */
    public Sudoku(){ 
        setuserInput(1); 
        buttonGrid = new Button[ROWS][COLS];
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        JPanel everythingButtons = new JPanel();
        JPanel ThreeByThree = new JPanel(); 
        
        JPanel messagePanel = new JPanel(); 
        message = new JLabel("Sudoku!"); 
        messagePanel.setBackground(new java.awt.Color(229,241,241,255));
        message.setForeground(new java.awt.Color(28,123,167,255));
        message.setFont(new Font(Font.SERIF, Font.ITALIC, 36));
        messagePanel.add(message);
        
        ThreeByThree.setLayout(new GridLayout(3,3));
        ThreeByThree.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel buttonPadGrid = new JPanel(); 
        buttonPadGrid.setLayout(new GridLayout(9,1)); 
        buttonPadGrid.setBorder(BorderFactory.createLineBorder(Color.black)); 
        ActionListenerSudoku ALS = new ActionListenerSudoku(this); 
         for (int k = 1; k < 10; k++){
                ButtonPad buttonPad = new ButtonPad(k); 
                buttonPadGrid.add(buttonPad); 
                buttonPad.addActionListener(ALS);
                }
        
        for (int i = 0; i < 3; i ++){ 
            for (int j = 0; j < 3; j++){
                JPanel grids = new JPanel();
                grids.setBorder(BorderFactory.createLineBorder(Color.black));
                grids.setLayout(new GridLayout(3,3));
                
                for (int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){ 
                         int localDisplayVal = SudokuNumbers[i*3+k][j*3+l];
                        if(SudokuGridShowOrNot[i*3+k][j*3+l] ==false){
                            localDisplayVal = 0; 
                        }
                        Button button = new Button(SudokuNumbers[i*3+k][j*3+l],SudokuGridShowOrNot[i*3+k][j*3+l], 
                                localDisplayVal); 
                        
                        buttonGrid[i*3+k][j*3+l] = button;
                        
                        button.addActionListener(ALS);
                        grids.add(button);
                        ThreeByThree.add(grids);
                        }
                    }
                }
            }
        everythingButtons.add(buttonPadGrid, BorderLayout.EAST);
        everythingButtons.add(ThreeByThree, BorderLayout.WEST);
        
        this.add(messagePanel, BorderLayout.NORTH);
        this.add(everythingButtons); 
       
        this.pack();  
     
    }
    /** Method that checks whether the game has been won.
     * 
     */
    public boolean checkWin(Sudoku game){
        gameWin = true; 
        for (int i = 0; i < ROWS; i ++){ 
            for (int j = 0; j < COLS; j++){
             
                if (SudokuNumbers [i][j] !=  buttonGrid [i][j].getdisplayVal()){
                    gameWin = false; 
                    System.out.println(valueOf(gameWin));
                    return gameWin;
                }
              }
            }
        return gameWin = true;    
    }
    /** Method that changes button colour and message once game has been won.  
     * 
     */
    public void gameWon(Sudoku game){
        if(gameWin == true){
            for (int i = 0; i < ROWS; i ++){ 
            for (int j = 0; j < COLS; j++){
                    game.buttonGrid[i][j].setBackground(Color.decode("#c76e44"));
                    
                    message.setForeground(new java.awt.Color(199,110,68,255));
                    message.setText("GREAT JOB!!!");
                    System.out.println(valueOf(gameWin));
            }
        }
        }
    }
    
    /** This method prints out the starting value of the Sudoku grids.  
     * 
     */
    public static void arrayPrinter(){
        for (int i = 0; i < 9; i ++){ 
            for (int j = 0; j < 9; j++){
                if(SudokuGridShowOrNot[i][j] == false){
                    System.out.print(" "); 
                }
                else{
                    System.out.print(SudokuNumbers[i][j]); 
                }
            }
            System.out.println();
    }
    }
    
    /** The main method which calls the Sudoku constructor to make a game. 
     * @param args  
     */
    public static void main(String[] args) {   
        arrayPrinter(); 
        
        Sudoku game = new Sudoku();
        
    } 
}  
    
