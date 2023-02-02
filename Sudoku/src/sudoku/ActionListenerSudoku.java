/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andrewy.lin
 */

 /** ActionListenerSudoku class implements ActionListener and enables the input of numbers into Sudoku grids.  
* 
*/
public class ActionListenerSudoku implements ActionListener{
    
    Sudoku game; 
    
    @Override
     /** actionPerformed method allows inputting of numbers into Sudoku game grids. 
     * 
     */
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() instanceof Button){
            
            Button button  = (Button)ae.getSource();
            if (button.getshowBool() == false && game.getgameWin() == false){
                    button.setText(String.valueOf(game.getuserInput())); 
                    //button.displayVal = game.getuserInput(); 
                    button.setdisplayVal(game.getuserInput());
                    game.checkWin(game); 
                    game.gameWon(game);
            }
        
        }if (ae.getSource() instanceof ButtonPad){
            
            ButtonPad buttonPad = (ButtonPad)ae.getSource(); 
           
            game.setuserInput(buttonPad.getbuttonInput()); 
            
            System.out.println(buttonPad.getbuttonInput());
        }
        
        System.out.println(game.getuserInput());       
    }
     /**  ActionListenerSudoku takes in a Sudoku game. 
     * 
     */
    public ActionListenerSudoku(Sudoku game){
        this.game = game;   
        }
}
