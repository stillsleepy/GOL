package gol;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * test
 * 
 */
public class GOL extends Application {
    
    @Override
    // Annotation to indicate that the method of the superclass is overridden
    
    /**
    * This is the main entry point for JavaFX application.
    * A Stage is the top level container for the user interface, and a Scene is 
    * the container for all (visual and control) content.
    */
    public void start(Stage primaryStage)
    {
        
//        Grid grid = new Grid();
        Grid grid = new ConwayGrid(10, 10);
//        Toggle cell - blinker pattern
        //grid.print();
        //System.out.println();
        grid.toggle(5,5);
        grid.toggle(5,4);
        grid.toggle(5,6);
        grid.toggle(4,5);
        grid.toggle(4,7);
        grid.toggle(4,6);
        //grid.print();
        //System.out.println();
//        Update grid
        //grid.update();

        //grid.print();
        //System.out.println();
        
        boolean isRunning = false;
        while(isRunning)
        {
            grid.update();
            Thread.sleep(1000);
        }
      
        View gui = new View(grid);
        primaryStage.setScene(gui.getUI());
        primaryStage.show();
//
        
        
//        primaryStage.setTitle("Game of Life");
//        primaryStage.setScene(view.getUI());
//        primaryStage.show();
        
        // TODO: Loop through input, grid and view updates
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
