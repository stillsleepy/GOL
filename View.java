package gol;

import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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
    public GridPane pane;
    
    public View(Grid gameGrid)
    {
        this.gameGrid = gameGrid;
        createScene();
    }
    
    public Scene getScene()
    {
        return ui;
    }
    
    public void setScene(Scene s)
    {
        ui = s;
    }
    
    public Grid getGameGrid()
    {
        return gameGrid;
    }
    
    public void createScene()
    {
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25,25,25,25));
        
        for(int i=0; i<gameGrid.grid.length; i++)
        {
            for(int j=0; j<gameGrid.grid[0].length; j++)
            {
                Button cell = new Button();
                pane.add(cell, i, j);
                if(gameGrid.grid[i][j])
                {
                    cell.setText("T");
                }
                else
                {
                    cell.setText("F");
                }
                /**cell.setOnAction(new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent event)
                    {
                        gameGrid.toggle(i, j);
                    }
                });**/
            }
        }
        
        for(int i=0; i<gameGrid.grid.length; i++)
        {
            for(int j=0; j<gameGrid.grid[0].length; j++)
            {
                pane.getChildren();
            }
        }
        
        AnchorPane mainPane = new AnchorPane();
        
        Label title = new Label();
        title.setText("Game of Life");
        
        Button stopgo = new Button();
        stopgo.setText("Start");
        
        mainPane.getChildren().addAll(stopgo, pane, title);
        AnchorPane.setTopAnchor(stopgo, 10.0);
        AnchorPane.setRightAnchor(stopgo, 10.0);        
        AnchorPane.setTopAnchor(title, 10.0);
        AnchorPane.setLeftAnchor(title, 10.0);
        AnchorPane.setTopAnchor(pane, 20.0);
        
        ui = new Scene(mainPane, 800, 600);
        
        // gameGrid = grid;
        
    }
    
    public void update()
    {
        //TODO
    }
    
}
