package gol;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ViewRectangleCell extends View 
{
    public static Color aliveColor = Color.WHITE;
    public static Color deadColor = Color.BLACK;
    
    private Group cells;
    
    public ViewRectangleCell(Grid gameGridModel)
    {
        super(gameGridModel);
    }
    
    
    @Override
    public void createScene()
    {
        // Title text of the scene
        Text scenetitle = new Text("Game of Life");
        scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

        // Group of cells in the game
        cells = new Group();
        int cellWidth = 40;
        int cellHeight = 40;
                
        for( int i = 0; i < getGameGrid().width; i++ )
        {
            for( int j = 0; j < getGameGrid().height; j++ )
            {
                RectangleCell rec = new RectangleCell(cellWidth, cellHeight);
                
                if(getGameGrid().grid[i][j])
                { rec.setFill(aliveColor); }
                else
                { rec.setFill(deadColor); }
                               
                rec.setX(i * cellWidth);
                rec.setY(j * cellHeight);
                rec.setStrokeType(StrokeType.OUTSIDE);
                rec.setStroke(Color.GRAY);
                rec.setStrokeWidth(1);
                
                CellToggleEventHandler toggleEvent;
                toggleEvent = new CellToggleEventHandler(getGameGrid(), i, j);
                
                rec.setOnMouseClicked(toggleEvent);
                                
                cells.getChildren().add(rec);
            }
        }
        
        GridPane gridTitlePane = new GridPane();
        gridTitlePane.setAlignment(Pos.CENTER);
        gridTitlePane.setHgap(10);
        gridTitlePane.setVgap(10);
        gridTitlePane.setPadding(new Insets(25, 25, 25, 25));
        
        // Button for starting and stoping game
        Button playButton = new Button();
        playButton.setText("Start");
        playButton.setOnMouseClicked(new GameLoopEventHandler());
        
        // Layout all scene elements to the grid
        gridTitlePane.add(scenetitle, 0, 0, 3, 1);
        gridTitlePane.add(cells, 1, 2, getGameGrid().width, getGameGrid().height);
        gridTitlePane.add(playButton, Math.round((getGameGrid().width + 3) / 2), getGameGrid().height + 3, 2 , 1 );
        
        setScene(new Scene(gridTitlePane, 800, 600, Color.BLACK));
    }
    
    @Override
    public void update()
    {
        ObservableList<Node> nodes = cells.getChildren();
        
        for(Node n: nodes)
        {
            if(n instanceof RectangleCell)
            {
                RectangleCell cell = (RectangleCell) n;
                
                if(getGameGrid().grid[cell.xIndex][cell.yIndex])
                { cell.setFill(aliveColor); }
                else
                { cell.setFill(deadColor); }
            }
        }
    }
    
}
