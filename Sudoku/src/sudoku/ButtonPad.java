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

/** This class extends JButton to create the Sudoku game button pad. The button pad allows
 * the player to select the integer value that they wish to enter into the Sudoku grids. 
 *
 * 
 */
public class ButtonPad extends JButton{
    
    private int buttonInput;  
    
    /**
    *   Getter gets the integer value being input into the Sudoku grid. 
    * 
    */
    public int getbuttonInput(){
        return buttonInput;
    }
    
    /**
    *   Setter sets the integer sets the integer value being input into the Sudoku grid. 
    * 
    */
    public void setbuttonInput(int buttonsInput){
        this.buttonInput = buttonsInput; 
    }
    
    
    /**
    *   This constructor creates the button pad for the Sudoku game.
    * 
    */
    public ButtonPad(int setValue){ 
    
        Dimension dimensions = new Dimension(69,69);
        this.setPreferredSize(dimensions);
        this.setBackground(new java.awt.Color(255,234,184,255));
    
        Font font = new Font(Font.SERIF, Font.PLAIN, 48); 
        this.setFont(font);
        
        buttonInput = setValue; 
        
        this.setText(String.valueOf(setValue));
        
        
    }
    
}
