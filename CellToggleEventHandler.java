package gol;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * Event handler for toggling each cell
 * @author Rellik-X200s
 */
public class CellToggleEventHandler implements EventHandler<MouseEvent>
{
    
    private Grid gameGrid;
    private int xIndex;
    private int yIndex;
    
    /**
     * Initialise the event handler with the model of the grid, and the cell
     * that the handler is responsible for
     * @param gameGrid
     * @param xIndex
     * @param yIndex 
     */
    public CellToggleEventHandler(Grid gameGrid, int xIndex, int yIndex)
    {
        this.gameGrid = gameGrid;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }
    
    /**
     * Handles a mouse click event by toggling the corresponding cell and 
     * updating its visual representation accordingly
     * @param event 
     */
    @Override
    public void handle(MouseEvent event)
    {
        if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
        {
            gameGrid.toggle(xIndex, yIndex);

            Object source = event.getSource();

            // Check that the event source is a rectangle
            if (source instanceof Rectangle)
            {
                if( gameGrid.grid[xIndex][yIndex] )
                { ((Rectangle) source).setFill(ViewRectangleCell.aliveColor); }
                else
                { ((Rectangle) source).setFill(ViewRectangleCell.deadColor); }
            }
            else 
            { System.out.println("CellToggleEventHandler called by an object that is not a Rectangle"); }

            event.consume();
        }

    }
    
}
