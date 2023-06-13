import javafx.scene.canvas.GraphicsContext;
/**
 * Abstract class Geomactobject - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class GeometricObject
{
    protected double x;
    protected double y;
    
    
    public void draw(GraphicsContext gc){}
    
    
    public void setX( double x ){
        this.x = x; 
    }

    public void setY( double y ){
        this.y = y; 
    }
}
