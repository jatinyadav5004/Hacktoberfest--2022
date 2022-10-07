import javax.swing.*;
import java.awt.*;

/** An instance is a turtle on a JFrame. All turtles use the same JFrame.<br><br>
 A turtle is a spot on the JFrame that you can move from place
 to place*/
public class Turtle {
    private static JFrame jframe;    // The frame in which all turtles move
    private static JPanel panel;     // The panel in the jframe
    private static Graphics graphics;// The graphics associated with the panel
    
    /** The panel on which the turtle moves is of size (width, height). */
    public static int width= 500; 
    /** The panel on which the turtle moves is of size (width, height). */
    public static int height= 500;
    
    private int x, y;  // Current turtle point is (x,y)
    private double turtleAngle; // Current turtle angle: 0 <= angle < 360
    // 0: east, 90:north, 180: west, 270 south
    private boolean penDown= true; // = "the pen is down"
    private Color turtleColor= Color.black;  // color of the turtle
    
    /** Constructor: a black turtle starting at the middle of the
     panel with angle 0 (looking east).
     East (right) is angle 0; north (left), 90; west (left), 180;
     South (down). 270. The pen is down.*/
    public Turtle() {
        this(width/2, height/2, 0);
    }
    
    /** Constructor: a black turtle starting at (x,y) with angle ang.
     East (right) is angle 0; north (left), 90; west (left), 180;
     South (down), 270. The pen is down. */
    public Turtle(int x, int y, int ang) {
        if (jframe == null) {
            jframe= new JFrame("Turtle window");
            panel= new JPanel();
            panel.setPreferredSize(new Dimension(width, height));
            jframe.getContentPane().add(panel, BorderLayout.CENTER);
            jframe.pack();
            jframe.show();
            graphics= panel.getGraphics();
            clear();
            this.x= x;
            this.y= y;
            clear();
            
        }
        
        this.x= x;
        this.y= y;
        turtleAngle= ang;
    }
    
    /** = x-coordinate of the turtle */
    public int getX() {
        return x;   
    }
    
    /** = y-coordinate of the panel */
    public int getY() {
        return y;   
    }
    
    
    /** = width of panel */
    public int getWidth() {
        return width;   
    }
    
    /** = height of the panel */
    public int getHeight() {
        return height;   
    }
    
    
    /** = angle of the turtle */
    public double getAngle() {
        return turtleAngle;   
    }
    
    /** Set the angle to a */
    public void setAngle(double a) {
        turtleAngle= mod(a, 360);
    }
    
    /** Add a to the angle */
    public void addAngle(double a) {
        turtleAngle= mod (turtleAngle + a, 360);
    }
    
    /** Lift pen */
    public void liftPen() {
        penDown= false;   
    }
    
    /** Put pen down */
    public void putPenDown() {
        penDown= true;   
    }
    
    /** Change the turtle's color to c:
     1 = black, 2 = blue, 3 = cyan, 4 = dark gray, 5 = gray
     6 = green, 7 = light gray, 8 = magenta, 9 = orange
     10 = pink, 11 = red, 12 = white, 13 = yellow
     If see is any other integer, don't change the color
     */
    public void setColor(int c) {
        if (c == 1) setColor(Color.black);
        if (c == 2) setColor(Color.blue);
        if (c == 3) setColor(Color.cyan);
        if (c == 4) setColor(Color.darkGray);
        if (c == 5) setColor(Color.gray);
        if (c == 6) setColor(Color.green);
        if (c == 7) setColor(Color.lightGray);
        if (c == 8) setColor(Color.magenta);
        if (c == 9) setColor(Color.orange);
        if (c == 10) setColor(Color.pink);
        if (c == 11) setColor(Color.red);
        if (c == 12) setColor(Color.white);
        if (c == 13) setColor(Color.yellow);
    }
    
    /** Set the color of the turtle to c */
    public void setColor(Color c) {
        turtleColor= c;
    }
    
    /** = the current color */
    public Color getColor() {
        return turtleColor;
    }
    
    /** Move the turtle to (x,y), without drawing,
     and face it at angle ang */
    public void moveTo(int x, int y, int ang) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        this.x= x;
        this.y= y;
        turtleAngle= mod( ang, 360);
        graphics.setColor(save);
    }
    
    /** Draw a circle with center at current pen position of diameter d */
    public void drawCircle(int d) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.drawOval(x-d/2, y-d/2, d, d);
        graphics.setColor(save);
    }
    
    /** Fill a circle with center at current pen position of diameter d */
    public void fillCircle(int d) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.fillOval(x-d/2, y-d/2, d, d);
        graphics.setColor(save);
    }
    
    /** Draw a rectangle with center at current pen position of width w, height h */
    public void drawRectangle(int w, int h) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.drawRect(x-w/2, y-h/2, w, h);
        graphics.setColor(save);
    }
    
    /** Fill a rectangle with center at current pen position of width w, height h */
    public void fillRectangle(int w, int h) {
        Color save= graphics.getColor();
        graphics.setColor(turtleColor);
        graphics.fillRect(x-w/2, y-h/2, w, h);
        graphics.setColor(save);
    }
    
    /** Move the turtle d units in its current direction.
     If the pen is down, a line will be drawn; if the pen
     is up, it won't be drawn.*/
    public void move(int d) {
        double rAngle= (turtleAngle * Math.PI) / 180;
        int newX= (int) Math.round(x + Math.cos(rAngle) * d);
        int newY= (int) Math.round(y - Math.sin(rAngle) * d);
        if (penDown) {
            Color save= graphics.getColor();
            graphics.setColor(turtleColor);
            graphics.drawLine(x, y, newX, newY);
            graphics.setColor(save);
        }
        x= newX;
        y= newY;
    }
    
    /** = x mod y (for y != 0) */
    private double mod(double x, int y) {
        double ans= x % y;
        if (ans < 0) 
            ans= ans + y;
        return ans;
    }
    
    /** Clear the screen (make it all white) */
    public void clear() {
        Color c= graphics.getColor();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(c);
    }
    
    /** Pause the program for d microseconds */
    public void pause(int d) {
        try { Thread.currentThread().sleep(d); }
        catch (InterruptedException e) { }
    }
}
