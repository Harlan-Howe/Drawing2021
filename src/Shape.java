import java.awt.*;

public abstract class Shape
{

    private String type, name;
    private int id, x, y;
    private Color fill, stroke;
    private boolean isSelected;


    private static int highestID = 0; // this is the largest ID number that we are aware of in this run of the program.
                                      // "Static" means that this single variable is shared by all shapes.

    public Shape()
    {
        name = "None";
        x = 0;
        y = 0;
        fill = Color.WHITE;
        stroke = Color.BLACK;
        highestID++;
        id = highestID;
    }

    public Shape(String[] data)
    {
        fillInData(data);
    }

    /**
     * takes a list of strings (e.g., {"Rect","body","17","0","255","0","0","0","0","100","200","50","40"}) and
     * fills in the member variables for this class. This may require parsing some of these strings as numbers.
     * @param itemsToLoad - an array of Strings to parse and put into the member variables of this class.
     */
    public void fillInData(String[] itemsToLoad)
    {
        type = itemsToLoad[0];
        name = itemsToLoad[1];
        id = Integer.parseInt(itemsToLoad[2]);
        if (id > highestID)
            highestID = id; // if we ever make a new Shape, we'll want to be sure it doesn't have an id that matches another one.

        int r1 = Integer.parseInt(itemsToLoad[3]);
        int g1 = Integer.parseInt(itemsToLoad[4]);
        int b1 = Integer.parseInt(itemsToLoad[5]);
        fill = new Color(r1,g1,b1);

        int r2 = Integer.parseInt(itemsToLoad[6]);
        int g2 = Integer.parseInt(itemsToLoad[7]);
        int b2 = Integer.parseInt(itemsToLoad[8]);
        stroke = new Color(r2,g2,b2);

        x = Integer.parseInt(itemsToLoad[9]);
        y = Integer.parseInt(itemsToLoad[10]);

    }


    /**
     * draw this shape in the given graphics context. Note: this might be different if this object is selected...
     * e.g., you might put small boxes at the corners of a rectangle.
     * For many shapes, you'll need to fill the shape to get the fill and then draw the shape to get the stroke.
     * @param g
     */
    public abstract void drawSelf(Graphics g);


    /**
     * makes a copy of this shape, except with a different id number.
     * Specifically, create another variable of the same type as this one (Shape or a subclass), and then copy over all
     * the data from this shape to that one (except for the id). Then return the other shape.
     * @return another Shape (of the same class as this one.)
     */
    public abstract Shape duplicate();


    // ACCESSORS & MODIFIERS --------------------------------------------
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Color getFill()
    {
        return fill;
    }

    public void setFill(Color fill)
    {
        this.fill = fill;
    }

    public Color getStroke()
    {
        return stroke;
    }

    public void setStroke(Color stroke)
    {
        this.stroke = stroke;
    }

    public boolean isSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean selected)
    {
        isSelected = selected;
    }
    // ---------------------------------------------------------------

    // TO STRING METHODS ---------------------------------------------
    /**
     * makes a human-readable description of this Shape.
     * @return
     */
    public String toString()
    {
        return ("A "+type+" called '"+name+"' with id "+id+", located at ("+x+", "+y+") with fill "+fill.toString()+" and stroke "+stroke.toString());
    }

    /**
     * makes a tab-delimited string of the member variables of this shape, suitable to print to a saved file. (So this
     *       needs to be in the same format as this class would expect the data when loading it.)
     * @return - a tab-delimited string, one line long, with no closing carriage return.
     */
    public String toStringForFile()
    {
        String result = type + "\t" + name+"\t"+ id + "\t";
        result += fill.getRed() + "\t" + fill.getGreen() + "\t" + fill.getBlue() + "\t";
        result += stroke.getRed() + "\t" + stroke.getGreen() + "\t" + stroke.getBlue() + "\t";
        result += x + "\t" + y + "\t";
        return result;
    }
    // ---------------------------------------------------------------

}
