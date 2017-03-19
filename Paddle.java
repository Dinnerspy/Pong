/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 *
 * @author Nicholas
 */
public class Paddle implements ActionListener{
    
     int Padley,x,y;
     final int Padlex;
    public Paddle(int Px, int Py){
        Padlex=Px;
        Padley=Py;
        x=10;
        y=125;
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
