package gol;

public abstract class Grid
{
    public int width = 100;
    public int height = 100;
    public boolean grid[][] = new boolean[width][height];
    
    // TODO: Add fields here (e.g. height and width of grid, the array 
    // representing the grid, etc)
    

    
    public abstract void toggle(int x, int y);
    public abstract void update();
    public abstract void print();
}
