package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements Runnable {


    public int[][] grid = new int[80][80];
    private static com.company.gui gui;
    private static Boolean running = false;

    public static void main(String[] args){
        gui = new gui();
        Main m = new Main();
        gui.setMain(m);
        new Thread(m).start();
    }

    @Override
    public void run() {
        while(true) {
            Point newCell = gui.mousePoint();
            if(newCell != null) {
                grid[newCell.x][newCell.y] = 1;
            }else if(running) {
               this.runSim();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gui.repaint();

        }
    }

    /**
     * This controls the logic for the sim
     * TODO: add more detailed commenting
     */
    public void runSim(){
        int[][] nextGrid = new int[80][80];
        for(int i = 0; i<80; i++){
           for(int j = 0; j<80; j++) {

               if(i == 0 && j == 0){ //Top left corner condition
                    int current = grid[i][j];
                    int cellCount = 0;
                    if(grid[i+1][j] >= 1){ cellCount++;}
                    if(grid[i+1][j+1] >= 1){ cellCount++;}
                    if(grid[i][j+1] >= 1){ cellCount++;}

                    if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                    else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                    else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                    else{ nextGrid[i][j] = 0;}

               }else if(i == 0 && j == grid.length-1){ //Bottom left corner
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i+1][j] >= 1){ cellCount++;}
                   if(grid[i+1][j-1] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(i == grid.length-1 && j == grid.length-1){ //Bottom right corner
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i-1][j] >= 1){ cellCount++;}
                   if(grid[i-1][j-1] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(i == grid.length-1 && j == 0){//Top left corner
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i-1][j] >= 1){ cellCount++;}
                   if(grid[i-1][j+1] >= 1){ cellCount++;}
                   if(grid[i][j+1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(i == 0){
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i+1][j] >= 1){ cellCount++;}
                   if(grid[i][j+1] >= 1){ cellCount++;}
                   if(grid[i+1][j+1] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}
                   if(grid[i+1][j-1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(j == 0){
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i+1][j] >= 1){ cellCount++;}
                   if(grid[i][j+1] >= 1){ cellCount++;}
                   if(grid[i+1][j+1] >= 1){ cellCount++;}
                   if(grid[i-1][j] >= 1){ cellCount++;}
                   if(grid[i-1][j+1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(i == grid.length-1){
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i][j+1] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}
                   if(grid[i-1][j+1] >= 1){ cellCount++;}
                   if(grid[i-1][j-1] >= 1){ cellCount++;}
                   if(grid[i-1][j] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else if(j == grid.length-1){
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i+1][j] >= 1){ cellCount++;}
                   if(grid[i-1][j] >= 1){ cellCount++;}
                   if(grid[i+1][j-1] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}
                   if(grid[i-1][j-1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}

               }else{
                   int current = grid[i][j];
                   int cellCount = 0;
                   if(grid[i+1][j] >= 1){ cellCount++;}
                   if(grid[i][j+1] >= 1){ cellCount++;}
                   if(grid[i+1][j+1] >= 1){ cellCount++;}
                   if(grid[i-1][j] >= 1){ cellCount++;}
                   if(grid[i][j-1] >= 1){ cellCount++;}
                   if(grid[i-1][j-1] >= 1){ cellCount++;}
                   if(grid[i+1][j-1] >= 1){ cellCount++;}
                   if(grid[i-1][j+1] >= 1){ cellCount++;}

                   if(current == 0 && cellCount == 3){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount >= 2 && cellCount < 4){ nextGrid[i][j] = 1;}
                   else if(current == 1 && cellCount < 2 || cellCount > 4){ nextGrid[i][j] = 0;}
                   else{ nextGrid[i][j] = 0;}
               }
           }
        }
        this.grid = nextGrid;
    }

    public static class startListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            running = true;
        }
    }
}
