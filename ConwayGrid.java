package gol;

/**
 *
 * @author Guy
 */
public class ConwayGrid extends Grid
{
    // Creates a grid with dimensions (x, y)

    public ConwayGrid(int width, int height)
    {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
    }
    
    // Updates the grid to the subsequent generation
    @Override
    public void update()
    {
        int i;
        int j;
        boolean[][] nextGrid = new boolean[width][height];
        for (i=0; i<width; i++)
                {
                    for (j=0; j<height; j++)
                    {
                        // Counts the number of living neighbours
                        int neighbours = 0;                                     
                        for (int k=i-1; k<i+2 && k>=0 && k<width; k++)
                        {
                            for (int m=j-1; m<j+2 && m>=0 && m<height; m++)
                                    {
                                        if (grid[k][m] && !(k==i && m==j))
                                        {
                                            neighbours++;
                                        }
                                    }
                        }
                        // Neighbour rules:
                        
                        // Any live cell with fewer than two live neighbours dies, as if caused by under-population
                        if (grid[i][j] && neighbours<2)                         
                        {
                            nextGrid[i][j] = false;
                        }
                        // Any live cell with two or three live neighbours lives on to the next generation
                        else if (grid[i][j] && (neighbours==2 || neighbours==3))
                        {
                            nextGrid[i][j] = true;
                        }
                        // Any live cell with more than three live neighbours dies, as if by over-population
                        else if (grid[i][j] && neighbours>3)
                        {
                            nextGrid[i][j] = false;
                        }
                        // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
                        else if (!grid[i][j] && neighbours==3)
                        {
                            nextGrid[i][j] = true;
                        }
                        else
                        {
                            nextGrid[i][j] = grid[i][j];
                        }
                    }
                }
        grid = nextGrid;
    }
    
    @Override
    public void print() 
    {
        for(int i=0; i<10 ; i++)
        {
            for (int j=0; j<10; j++)
            {
                if(grid[i][j])
                {
                    System.out.print("T ");
                }
                else
                {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    // Toggles the value of the cell
    @Override
    public void toggle(int x, int y)
    { grid[x][y] = !grid[x][y]; }
        
}
