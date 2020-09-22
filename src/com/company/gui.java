package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class gui extends JFrame{

    public static final int HEIGHT = 900;
    public static final int WIDTH = 900;
    private Main m = new Main();
    public int mx = 0;
    public int my = 0;

    public boolean clicked = false;

    public gui(){
        this.setTitle("Conways game of life");
        this.setSize(HEIGHT,WIDTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        Board board = new Board();
        this.setContentPane(board);

        JButton startButton = new JButton("Start");
        startButton.setBounds(400,10,50,25);
        startButton.addActionListener(new Main.startListener());

        this.add(startButton);
        this.addMouseMotionListener(new mouseMove());
        this.addMouseListener(new mouseClick());


    }

    public void setMain(Main newM){
        this.m = newM;
    }
    public Point mousePoint(){
        for(int i = 0; i<80; i++){
            for(int j = 0; j<80; j++){
                if(clicked == true && mx > 50+(i*10) && my > 65+(j*10) && mx < 50+(i*10)+10 && my < 65+(j*10)+10 ) {
                    return new Point(i,j);
                }
            }
        }
        return null;
    }



    public class mouseMove implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mx = e.getX();
            my = e.getY();
        }
    }

    public class mouseClick implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            clicked = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            clicked = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class Board extends JPanel {

        public void paintComponent(Graphics g){
            g.setColor(Color.BLACK);
            for(int i = 0; i<80; i++){
                for(int j = 0; j<80; j++){
                    if(m.grid[i][j]>0) {
                        g.fillRect(40 + (i * 10), 35 + (j * 10), 10, 10);
                    }
                        g.drawRect(40 + (i * 10), 35 + (j * 10), 10, 10);

                }
            }
        }
    }

}


