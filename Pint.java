
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import java.util.ArrayList;

/**
 * Basic demonstration of mouse events in action.
 * 
 * @author sam scott, Anaharisohn King
 *  
 *  V25
 */
public class Pint extends Application {

    //Colors!!!!
    private Color UiColor = Color.LIGHTGRAY;
    private Color backgroundColor = Color.WHITE;//WHITE
    
    private Color Ccircle = Color.BLACK;
    private Color Cstorke = Color.BLACK;

    // TODO: Instance Variables for View Components and Model
    private GeometricObject currentshapes;
    private GraphicsContext gc;

    int shapNum = 66;

    int storkeLine = 15;

    int radius = 30;

    int height = 100;
    int width = 100;
    //private final static int 
    private final static int MAXROWS = 800;
    private final static int MAXCOLS = 1200;

    boolean mode = false;

    //Shaps
    //private Square square;

    private ArrayList<GeometricObject> shapes;

    //GUI Buttons
    private Button clearButton;
    private Button rectButton;
    private Button circleButton;
    private Button moreButton;
    private Button lessButton;
    private Button eraceButton;

    //GUI Text Fields
    private TextField storke;
    private TextField cRadius;

    private TextField sHeight;
    private TextField sWidth;

    //GUI CheckBox
    private CheckBox checkbox;

    //GUI Labels
    private Label tHeight;
    private Label tWidth;
    private Label lRadius;

    // TODO: Private Event Handlers and Helper Methods
    private void pressHandler(MouseEvent me) {

        inputMent();

        gc.setFill(UiColor);
        gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);

        gc.setStroke(Cstorke);
        gc.setLineWidth( storkeLine / 4 );

        Square square = new Square(width, height, Color.LIGHTBLUE, 600, 600);

        if (me.getButton() == MouseButton.PRIMARY && shapNum == 1){
            Circle circle = new Circle(radius, 100, 100, Ccircle);
            circle.setX( me.getX() );
            circle.setY( me.getY() );

            circle.draw(gc);

            shapes.add(circle);
            //System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        }
        else if (me.getButton() == MouseButton.PRIMARY && shapNum == 2){
            square.setX( me.getX() );

            square.setY( me.getY() );

            square.draw(gc);

            shapes.add(square);
            //System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        }
        else if (me.getButton() == MouseButton.PRIMARY && shapNum == 0){
            Circle circle = new Circle(radius, 100, 100, backgroundColor);
            circle.setX( me.getX() );
            circle.setY( me.getY() );

            gc.setFill(backgroundColor);
            gc.setStroke(backgroundColor);
            circle.draw(gc);
        }
    }


    private void draggeHandler(MouseEvent me) {

        inputMent();
        gc.setFill(UiColor);
        gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);

        if (me.getButton() == MouseButton.PRIMARY && shapNum == 0){
            Circle circle = new Circle(radius, 100, 100, backgroundColor);
            circle.setX( me.getX() );
            circle.setY( me.getY() );

            gc.setFill(backgroundColor);
            gc.setStroke(backgroundColor);
            circle.draw(gc);
        }

        if ( mode == true ){

            if ( storkeLine > 0 ){
                gc.setStroke(Cstorke);
                gc.setLineWidth( storkeLine / 4 );
            }

            Square square = new Square(width, height, Color.LIGHTBLUE, 600, 600);
            if (me.getButton() == MouseButton.PRIMARY && shapNum == 1){
                Circle circle = new Circle(radius, 100, 100, Ccircle);
                circle.setX( me.getX() );
                circle.setY( me.getY() );

                circle.draw(gc);

                shapes.add(circle);
            }
            else if (me.getButton() == MouseButton.PRIMARY && shapNum == 2){

                //square.setLength( me.getX() );
                square.setX( me.getX() );

                //square.setHeight( me.getY() );
                square.setY( me.getY() );

                //gc.setLineWidth( storkeLine / 4 );
                square.draw(gc);

                shapes.add(square);
                //System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
            }

        }
    }

    
    private void releaseHandler(MouseEvent me) {
        //System.out.println("Released " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        // System.out.println();
        gc.setFill(UiColor);
        gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);
    }

    
    private void inputMent(){
        //gets input from the user for the square height
        String inputHeight = sHeight.getText();  // getting input from GUI
        double height = Double.parseDouble(inputHeight);  // parse string to double

        //gets input from the user for the square width
        String inputWidth = sWidth.getText();  // getting input from GUI
        double width = Double.parseDouble(inputWidth);  // parse string to double

        //gets input from the user for the circle radius
        String input2 = cRadius.getText();  // getting input from GUI
        double radius = Double.parseDouble(input2);  // parse string to double

        //gets input from the user for the outline thickness
        String input = storke.getText();  // getting input from GUI
        double storkeLine = Double.parseDouble(input);  // parse string to double
    }


    private void clearButtonHandler(ActionEvent me) {
        //System.out.println("clearButton pressed");
        gc.setFill(backgroundColor);
        gc.fillRect(0,0, MAXCOLS,MAXROWS-200);

        gc.setFill(UiColor);
        gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);

        shapes.removeAll(shapes);
    }


    private void circleButtonHandler(ActionEvent me) {
        shapNum = 1;
        relocate();
    }


    private void rectButtonHandler(ActionEvent me) {
        shapNum = 2;
        relocate();
    }


    private void eraceButtonHandler(ActionEvent me) {
        shapNum = 0;
        relocate();
    }


    private void moreButtonHandler(ActionEvent me) {
        storkeLine ++;
        storke.setText( "" + storkeLine );
    }


    private void lessButtonHandler(ActionEvent me) {
        storkeLine --;
        storke.setText( "" + storkeLine );
    }


    private void checkBoxHandler( ActionEvent me ){
        if ( checkbox.isSelected() == true ){
            mode = true;
            UiColor = Color.LIGHTBLUE;
            gc.setFill(UiColor);
            gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);
        } else {
            mode = false;
            UiColor = Color.LIGHTGRAY;
            gc.setFill(UiColor);
            gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);
        }
    }


    public void drawEverything(){
        for(int i = 0; i< shapes.size(); i++){
            (shapes.get(i)).draw(gc);
        }
    }

    
    public void relocate(){
        if (shapNum == 1 || shapNum == 0){
            cRadius.relocate(MAXCOLS - 350, MAXROWS - 100);

            lRadius.relocate(MAXCOLS - 325, MAXROWS - 130);
        } else{
            cRadius.relocate(MAXCOLS + 880, MAXROWS - 100);

            lRadius.relocate(MAXCOLS + 880, MAXROWS - 100);
        }

        if ( shapNum == 2 ){
            sHeight.relocate(MAXCOLS - 400, MAXROWS - 100);
            tHeight.relocate(MAXCOLS - 378, MAXROWS - 130);

            sWidth.relocate(MAXCOLS - 250, MAXROWS - 100);
            tWidth.relocate(MAXCOLS - 225, MAXROWS - 130);
        } else{
            sHeight.relocate(MAXCOLS + 880, MAXROWS - 100);
            tHeight.relocate(MAXCOLS + 880, MAXROWS - 100);

            sWidth.relocate(MAXCOLS + 880, MAXROWS - 100);
            tWidth.relocate(MAXCOLS + 880, MAXROWS - 100);
        }
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, MAXCOLS,MAXROWS); // set the size here
        stage.setTitle("A8"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model

        //gc.setLineWidth(storkeLine);

        // 2. Create the GUI components
        Canvas c = new Canvas(MAXCOLS,MAXROWS);

        clearButton = new Button("Clear");
        circleButton = new Button("Circle");
        rectButton = new Button("Square");

        moreButton = new Button("+");
        lessButton = new Button("-");

        eraceButton = new Button("Erace");

        storke = new TextField("" +storkeLine);

        cRadius = new TextField("" +radius);

        sHeight = new TextField("" +height);
        sWidth = new TextField("" +width);

        shapes = new ArrayList<>();

        tHeight = new Label("Height");
        tWidth = new Label("Width");

        lRadius = new Label("Radius");

        checkbox = new CheckBox("DRAW");

        // 3. Add components to the root
        root.getChildren().addAll(
            c,
            clearButton,
            circleButton,
            rectButton,
            storke,
            moreButton,
            lessButton,
            eraceButton,
            cRadius,
            sHeight,
            sWidth,
            tWidth,
            tHeight,
            lRadius,
            checkbox
        );

        // 4. Configure the components (colors, fonts, size, location)
        gc = c.getGraphicsContext2D();

        gc.setFill(UiColor);
        gc.fillRect(0, MAXROWS - 200,MAXCOLS,200);

        gc.setFill(backgroundColor);
        gc.fillRect(0,0, MAXCOLS,MAXROWS-200);

        //Clear Button
        clearButton.relocate(MAXCOLS - 300, MAXROWS - 180);
        clearButton.setPrefHeight(40);
        clearButton.setFont(new Font("System",20));

        //erace Button
        eraceButton.relocate(MAXCOLS - 450, MAXROWS - 180);
        eraceButton.setPrefHeight(40);
        eraceButton.setFont(new Font("System",20));

        //Circle Button
        circleButton.relocate(MAXCOLS - 1100, MAXROWS - 180);
        circleButton.setPrefHeight(40);
        circleButton.setFont(new Font("System",20));

        //Rect Button
        rectButton.relocate(MAXCOLS - 900, MAXROWS - 180);
        rectButton.setPrefHeight(40);
        rectButton.setFont(new Font("System",20));

        //Outline
        storke.relocate(MAXCOLS - 880, MAXROWS - 100);
        storke.setPrefWidth(120);
        storke.setPrefHeight(50);
        storke.setFont(new Font("System",25));

        //Circle Radius
        cRadius.relocate(MAXCOLS + 880, MAXROWS - 100);
        cRadius.setPrefWidth(120);
        cRadius.setPrefHeight(50);
        cRadius.setFont(new Font("System",25));

        lRadius.relocate(MAXCOLS + 880, MAXROWS - 100);
        lRadius.setFont(new Font("System",25));

        //Square Height
        sHeight.relocate(MAXCOLS + 880, MAXROWS - 100);
        sHeight.setPrefWidth(120);
        sHeight.setPrefHeight(50);
        sHeight.setFont(new Font("System",25));

        tHeight.relocate(MAXCOLS + 880, MAXROWS - 100);
        tHeight.setFont(new Font("System",25));

        //Square Width
        sWidth.relocate(MAXCOLS + 880, MAXROWS - 100);
        sWidth.setPrefWidth(120);
        sWidth.setPrefHeight(50);
        sWidth.setFont(new Font("System",25));

        tWidth.relocate(MAXCOLS + 880, MAXROWS - 100);
        tWidth.setFont(new Font("System",25));

        //More Button
        moreButton.relocate(MAXCOLS - 760, MAXROWS - 100);
        moreButton.setPrefHeight(50);
        moreButton.setFont(new Font("System",25));

        //Less Button
        lessButton.relocate(MAXCOLS - 925, MAXROWS - 100);
        lessButton.setPrefHeight(50);
        lessButton.setFont(new Font("System",25));

        //CheckBox
        checkbox.relocate(MAXCOLS - 150, MAXROWS - 180);
        checkbox.setFont(new Font("System",25));

        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::draggeHandler);
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);

        clearButton.setOnAction( this::clearButtonHandler );
        circleButton.setOnAction( this::circleButtonHandler );
        rectButton.setOnAction( this::rectButtonHandler );

        moreButton.setOnAction( this::moreButtonHandler );
        lessButton.setOnAction( this::lessButtonHandler );

        eraceButton.setOnAction( this::eraceButtonHandler );

        checkbox.setOnAction( this::checkBoxHandler );
        //storke.setOnAction( this::storkeHandler );

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

