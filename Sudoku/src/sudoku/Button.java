/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author andrewy.lin
 */

/** Button class extends JButtons and creates the buttons for the Sudoku grid. The buttons
 * are added to the Sudoku grid and allows the player to input a value into them. 
* 
*/
public class Button extends JButton{
    Sudoku game; 
    private int displayVal; 
    private int actualVal;
    private boolean showBool; 
    
    /** Getter gets the boolean for whether to show the integer value on the button or not. 
     * 
     */
    public boolean getshowBool(){
        return showBool;
    }
    
     /** Getter gets the integer value being displayed on the button. 
     * 
     */
    public int getdisplayVal(){
        return displayVal; 
    }
    
    /** Setter sets the integer value being displayed on the button. 
     * 
     */
    public void setdisplayVal(int displayVals){
        this.displayVal = displayVals;
    }
    
     /** Button constructor makes the buttons for the Sudoku grids. 
     * 
     */
    public Button(int value, boolean show, int displayedVal){
    Dimension dimensions = new Dimension(69,69);
    this.setPreferredSize(dimensions);
    this.setBackground(Color.WHITE);
    
    Font font = new Font(Font.SERIF, Font.PLAIN, 48); 
    this.setFont(font);
    
    showBool = show; 
    actualVal = value; 
    displayVal = displayedVal;
    
    
    if (show == false){
        this.setText(" ");
    }else{
        this.setText(String.valueOf(actualVal));
        this.setBackground(new java.awt.Color(238,238,228));
    }
    
    
    } 
}