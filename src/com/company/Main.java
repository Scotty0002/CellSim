package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements Runnable {


    public static int[][] grid = new int[80][80];
    private final gui gui = new gui();
    private static Boolean running = false;

    public static void main(String[] args){
        new Thread(new Main()).start();
    }

    @Override
    public void run() {

        while(true) {
            Point newCell = gui.mousePoint();
            if(newCell != null && !running) {
                grid[newCell.x][newCell.y] = 3;
            }else if(running) {
                runSim();
            }
            gui.repaint();
        }
    }

    public static void runSim(){
        int[][] nextGrid = new int[80][80];
        for(int i = 0; i<80; i++){
           for(int j = 0; j<80; j++) {

           }
        }
    }

    public static class startListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            running = true;
        }
    }
}
