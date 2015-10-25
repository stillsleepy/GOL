package gol;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * 
 */
public class GOL extends Application 
{
    public static boolean isRunning = false;
    private int delay = 3; // Delay for updating the grid in seconds
    private Grid gameGrid;
    private View gui;
    
    @Override
    // Annotation to indicate that the method of the superclass is overridden
    
    /**
    * This is the main entry point for JavaFX application.
    * A Stage is the top level container for the user interface, and a Scene is 
    * the container for all (visual and control) content.
    */
    public void start(Stage primaryStage)
    {
        
        gameGrid = new ConwayGrid(10, 10);
//        Toggle cell - blinker pattern
        //grid.print();
        //System.out.println();
        gameGrid.toggle(5,5);
        gameGrid.toggle(5,4);
        gameGrid.toggle(5,6);
        gameGrid.toggle(4,5);
        gameGrid.toggle(4,7);
        gameGrid.toggle(4,6);

        // TODO: Loop through input, grid and view updates
                
        gui = new ViewRectangleCell(gameGrid);
        primaryStage.setScene(gui.getScene());
        
//        Timeline timeline = new Timeline(new KeyFrame(
//        Duration.millis(delay*1000),
//        ae -> update()));
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play(); //plays animation
//        timeline.pause(); //pause animation

        
        
        primaryStage.show();
        
        
    }
    
    /**
     * This should not be called in a JavaFX application, but if it is called 
     * then the command line arguments are passed to the application
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
