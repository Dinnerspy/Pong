//********************************************************************
//  Rebound.java       Author: Lewis/Loftus Modfided by Nicholas Ouellette & Mitchell Golding
//
//  Demonstrates an animation and the use of the Timer class.
//********************************************************************

import rebound.ReboundPanel;
import javax.swing.*;

public class Rebound
{
    
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {    int End;
        ImageIcon img = new ImageIcon("pong_icon_by_dindresto-d3bm9m6.png");
       JPanel StartUp = new JPanel();
        JLabel PopDownInfo = new JLabel();
        PopDownInfo.setText("Please select player amount.");

        Box box = Box.createVerticalBox();
        StartUp.add(box);
        box.add(PopDownInfo);

        String[] SizeOfGame = {"One", "Two"};
        JComboBox Size = new JComboBox(SizeOfGame);
        box.add(Size);
        JLabel BombAmount = new JLabel();
        BombAmount.setText("Ai Diffculty");
        box.add(BombAmount);
        ButtonGroup BombButtons = new ButtonGroup();

        JRadioButton One = new JRadioButton("Easy");
        JRadioButton Scaled = new JRadioButton("Meduim");
        JRadioButton Random = new JRadioButton("Hard");
        One.setSelected(true);
        BombButtons.add(One);
        BombButtons.add(Scaled);
        BombButtons.add(Random);

        box.add(One);
        box.add(Scaled);
       
        box.add(Random);
        End=JOptionPane.showConfirmDialog(null,StartUp);
       if(End==JOptionPane.NO_OPTION||End ==JOptionPane.CANCEL_OPTION||End==JOptionPane.CLOSED_OPTION){
       System.exit(0);
       }
       
      JFrame frame = new JFrame("Pong");
      
        frame.setIconImage(img.getImage());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      boolean Ai = Size.getSelectedItem().equals("One");
      frame.getContentPane().add(new ReboundPanel(Ai));
      frame.pack();
      frame.setVisible(true);
   }
}