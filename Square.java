import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
/**
 * Write a description of class Circle here.
 *
 * @author Anaharisohn King
 * @version V5
 */
public class Square extends GeometricObject
{
    private double length;
    private double height;
    public Color color;


   
    public Square ( ) {

        //this(1.0,1.0);

    }

    // public Square ( double length, double height)
    // {
        // this(length, height, Color.BLUE, x, y);

    // }

   
    public Square ( double length, double height, Color color, double x, double y )
    {
        this.length = length;
        this.height = height;
        this.color = color;
        this.x = x;
        this.y = y;

    }  

    public void setLength ( double amount )
    {
        this.length = amount;
    }

    public double getLength ( ) {
        return length;  
    }
    
    public void setHeight ( double amount )
    {
        this.height = amount;
    }

    public double getHeight ( ) {
        return height;  
    }

    public double area( ) {
        return length * height;
    }


    public String toString()
    {
        return "Rectangle length = " + length + "  at { " + x + " , " + y + " )";
    }

    public void draw( GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(x, y, length, height);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, length, height);

    }
}
