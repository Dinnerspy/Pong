package rebound;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ReboundPanel extends JPanel {

    private final int w = 640, h = 480;
    private final int DELAY = 17;
    int Score1, Score2;
    private final Timer timer;
    Rectangle Padle1, Padle2;
    private int x, y, moveX, moveY, Padle1y, Padle2y;
    private final int Padle1x, Padle2x;
    private boolean AI;
    //-----------------------------------------------------------------
    //  Sets up the panel, including the timer for the animation.
    //-----------------------------------------------------------------

    public ReboundPanel(boolean UserData) {

        timer = new Timer(DELAY, new ReboundListener());
        Score1 = 0;
        Score2 = 0;
        Padle1x = 10;
        Padle2x = 640 - 20;
        Padle1y = h / 2 - 125 / 2;
        Padle2y = h / 2 - 125 / 2;
        x = w / 2;
        y = h / 2;
        moveX = 9;
        moveY = (int) ((Math.random() * 6) - 3);
        setPreferredSize(new Dimension(w, h));
        AI = UserData;

        timer.start();

        this.setFocusable(true);
        this.addKeyListener(new DirectionListener());
        this.addKeyListener(new DirectionListenerOp());

    }

    @Override
    public void paint(final Graphics g) {
        super.paint(g);
        Font myFont = new Font("Courier New", 1, 50);
        g.setFont(myFont);
        setBackground(Color.black);
        g.setColor(Color.white);
        g.drawString(String.valueOf(Score1), 640 / 2 - 50, 35);
        g.drawString(String.valueOf(Score2), 640 / 2 + 50, 35);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.white);
        Paddle hi = new Paddle(Padle1x, Padle1y);
        g.fillRect(hi.Padlex, hi.Padley, 10, 125);
        Padle1 = new Rectangle(hi.Padlex, hi.Padley, 10, 125);
        Paddle lol = new Paddle(Padle2x, Padle2y);
        g.setColor(Color.white);
        g.fillRect(lol.Padlex, lol.Padley, 10, 125);
        Padle2 = new Rectangle(lol.Padlex, lol.Padley, 10, 125);

    }

    //   -----------------------------------------------------------
    //  Draws the image in the current location.
    //-----------------------------------------------------------------
    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);

    }

    private class DirectionListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_UP && !AI) {

                if (Padle2y > 0) {
                    Padle2y -= 30;

                    repaint();
                }

            }
            if (event.getKeyCode() == KeyEvent.VK_DOWN && !AI) {

                if (Padle2y < h - 125) {
                    Padle2y += 30;
                    repaint();
                }
            }

//            if (event.getKeyCode() == KeyEvent.VK_W) {
//
//                if (Padle1y > 125) {
//                    Padle1y -= 30;
//
//                    repaint();
//                }
//
//            }
//            if (event.getKeyCode() == KeyEvent.VK_S) {
//
//                if (Padle1y < h - 125) {
//                    Padle1y += 30;
//                    repaint();
//                }
//            }
        }

        @Override
        public void keyTyped(KeyEvent event) {
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }
    }

    private class DirectionListenerOp implements KeyListener {

        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_W) {

                if (Padle1y > 10) {
                    Padle1y -= 30;

                    repaint();
                }

            } else if (event.getKeyCode() == KeyEvent.VK_S) {

                if (Padle1y < h - 125) {
                    Padle1y += 30;
                    repaint();
                }
            }

        }

        @Override
        public void keyTyped(KeyEvent event) {
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }
    }

    //*****************************************************************
    //  Represents the action listener for the timer.
    //*****************************************************************
    private class ReboundListener implements ActionListener {
        //--------------------------------------------------------------
        //  Updates the position of the image and possibly the direction
        //  of movement whenever the timer fires an action event.
        //--------------------------------------------------------------

        @Override
        public void actionPerformed(ActionEvent event) {
            x += moveX;
            y += moveY;

            //AI
            if (AI) {
                if (y <= Padle2y + 20) {
                    Padle2y -= 2;
                    repaint();
                } else if (y >= Padle2y + 105) {
                    Padle2y += 2;
                    repaint();
                }
            }

            if (Score1 == 5) {

                JOptionPane.showMessageDialog(null, "Plaer One won! \n\nReseting game.");
                Score1 = 0;
                Score2 = 0;
                Padle1y = h / 2 - 125 / 2;
                Padle2y = h / 2 - 125 / 2;
                x = w / 2;
                y = h / 2;
                moveX = 9;
                moveY = (int) ((Math.random() * 6) - 3);

            }

            if (Score2 == 5) {

                JOptionPane.showMessageDialog(null, "Plaer Two won! \n\nReseting game.");

                Score1 = 0;
                Score2 = 0;
                Padle1y = h / 2 - 125 / 2;
                Padle2y = h / 2 - 125 / 2;
                x = w / 2;
                y = h / 2;
                moveX = 9;
                moveY = (int) ((Math.random() * 6) - 3);

            }

            if (x <= Padle1x + 10 && x >= Padle1x && y + 20 >= Padle1y && y <= Padle1y + 125) {
                moveX = moveX * -1;
               moveY = (int) ((Math.random() * 6) - 3);
                moveY = moveY * -1;

            }

            if (x + 20 <= Padle2x + 10 && x + 20 >= Padle2x && y + 20 >= Padle2y && y + 20 <= Padle2y + 125) {
               moveY = (int) ((Math.random() * 6) - 3);
               moveY = moveY * -1; 
               moveX = moveX * -1;

            }
            //If X exceeds bounds reset to centre and add point to other side
            if (x >= w || x < 0) {

                if (x < 0) {
                    Score2++;

                }

                if (x >= w) {
                    Score1++;
                }
                // System.out.println(Score1 + " " + Score2);
                moveY = (int) ((Math.random() * 6) - 3);
                if (x < 0) {
                    moveX = 9;
                } else {

                    moveX = -9;
                }
                x = w / 2;
                y = h / 2;

            } else if (x <= 0 || x >= w + 1) {
                moveX = moveX * -1;

                
            } else if (y <= 0 || y >= h - 20) {
                moveY = moveY * -1;
            }

            repaint();
        }
    }
}
