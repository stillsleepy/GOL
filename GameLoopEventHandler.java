package gol;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Rellik-X200s
 */
public class GameLoopEventHandler implements EventHandler<MouseEvent>
{
    //Grid gameGrid;
    //boolean isRunning = false;

    @Override
    public void handle(MouseEvent event)
    {
        if( event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
        {
            Object source = event.getSource();

            // Check that the event source is a rectangle
            if (source instanceof Button)
            {
                GOL.isRunning = !GOL.isRunning;
                
                if(GOL.isRunning)
                { ((Button) source).setText("Stop"); }
                else
                { ((Button) source).setText("Start"); }
            }
            else 
            { System.out.println("GameLoopEventHandler called by an object that is not a Button"); }

            event.consume();
        }
    }    
}
