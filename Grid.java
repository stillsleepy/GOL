package gol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rellik-X200s
 */
public abstract class Grid
{
    public int width = 100;
    public int height = 100;
    public boolean grid[][] = new boolean[width][height];
    
    // TODO: Add fields here (e.g. height and width of grid, the array 
    // representing the grid, etc)
    

    
    public abstract void toggle(int x, int y);
    public abstract void update();
    //public abstract Position[] getNeighbours(int x, int y);
    public abstract void print();
    //public abstract int getHeight();
    //public abstract int getWidth();
}
