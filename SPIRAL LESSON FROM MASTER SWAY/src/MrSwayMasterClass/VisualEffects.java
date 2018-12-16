package MrSwayMasterClass;

import sun.security.util.Length;
import java.awt.*;
//If you put in event.*; it doesn't work?? why
//connors answer was just it is just java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.JPanel;


public class VisualEffects extends JPanel implements KeyListener, ActionListener{

    private Timer timer;
    int lineDiet;
    int[][] positions = new int[1000][2];
    int colourNumber;
    double direction = 0;
    double length;
    double previousDirection;
    double totalLength = 500;
    double patternChanging = 3.14159;
    boolean pause = false;
    boolean colorToggle = false;
    int colourChangeNumber = 1;

    public VisualEffects() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer (20, this);
        timer.start();
    }

    public void paint(Graphics g){

        // Anti aliasing
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //background
        g.setColor(Color.BLACK);
        g.fillRect(1,1,2000, 2000);

        //spiral
        lineDiet=6;
        colourNumber = 1;
        for (int i = 0; i < positions.length-6; i++) {
            if (i%200==0 && lineDiet>1){
                lineDiet--;
            }
            if (i%colourChangeNumber==0){
                colourNumber++;
                if (colourNumber > 4){
                    colourNumber = 1;
                }

            }
            if(colourNumber == 1){
                g.setColor(Color.getHSBColor(0.900333f,1,0.5f));
            } else if (colourNumber == 2){
                g.setColor(Color.getHSBColor(0.899333f,1,0.6f));
            } else if (colourNumber == 3){
                g.setColor(Color.getHSBColor(0.755333f,1,0.7f));
            } else if (colourNumber == 4){
                g.setColor(Color.getHSBColor(0.655555f,1,0.8f));
            }

            ((Graphics2D) g).setStroke(new BasicStroke(1));
            g.drawLine(600+positions[i][0], 350-positions[i][1],600+positions[i+1][0], 350-positions[i+1][1]);

        }

        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString(""+patternChanging, 10, 30);
        g.drawString(""+direction, 10, 60);

        g.dispose();

    }

    void spiral(){
        previousDirection = direction;
        for (int i = 0; i < positions.length; i++) {
            positions[i][0] = (int)(length*Math.cos(direction));
            positions[i][1] = (int)(length*Math.sin(direction));

            length -= totalLength/positions.length;
            direction += patternChanging;
        }

        direction = previousDirection+0.05;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        length = totalLength;
        if (!pause){
            //patternChanging -= 0.0002;


        }
        if (!colorToggle){
            colourChangeNumber++;
            if (colourChangeNumber>250){
                colorToggle=true;
            }
        }else{
            colourChangeNumber--;
            if (colourChangeNumber<1){
                colorToggle=false;
            }
        }
        direction += patternChanging;
        spiral();

        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_SPACE){
            pause = true;
        }
        if (e.getKeyCode()== KeyEvent.VK_E){
            patternChanging+=0.01;
        }
        if (e.getKeyCode()== KeyEvent.VK_R){
            patternChanging-=0.01;
        }
        if (e.getKeyCode()== KeyEvent.VK_D){
            patternChanging+=0.001;
        }
        if (e.getKeyCode()== KeyEvent.VK_F){
            patternChanging-=0.001;
        }
        if (e.getKeyCode()== KeyEvent.VK_1){
            patternChanging=-3.307;
        }
        if (e.getKeyCode()== KeyEvent.VK_2){
            patternChanging=-3.166;
        }
        if (e.getKeyCode()== KeyEvent.VK_3){
            patternChanging=-3.384;
        }
        if (e.getKeyCode()== KeyEvent.VK_4){
            patternChanging=-5.037;
        }
        if (e.getKeyCode()== KeyEvent.VK_5){
            patternChanging=-3.487;
        }
        if (e.getKeyCode()== KeyEvent.VK_6){
            patternChanging=-3.773;
        }
        if (e.getKeyCode()== KeyEvent.VK_7){
            patternChanging=-4.203;
        }
        if (e.getKeyCode()== KeyEvent.VK_8){
            patternChanging=-4.723;
        }
        if (e.getKeyCode()== KeyEvent.VK_9){
            patternChanging=-0.09;
        }
        if (e.getKeyCode()== KeyEvent.VK_0){
            patternChanging=-3.317;
        }
        if (e.getKeyCode()== KeyEvent.VK_P){
            patternChanging=-4.887;
        }
        if (e.getKeyCode()== KeyEvent.VK_O){
            patternChanging=-2.199;
        }
        if (e.getKeyCode()== KeyEvent.VK_S){
            patternChanging=0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_SPACE){
            pause = false;
        }

    }
}
