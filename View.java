package gol;

import javafx.scene.Scene;

/**
 * A class that uses a grid to construct the user interface. Display the cells
 * whose states can be toggled, and buttons for starting/pausing animation.
 * 
 * Possibly extend later to add options for different grid types and animation
 * speed adjustment.
 */
public class View
{   
    private Scene ui;
    private Grid gameGrid;
    
    public View(Grid grid)
    {
        gameGrid = grid;
    }
    
    public Scene getUI()
    {
        return ui;
    }
}
