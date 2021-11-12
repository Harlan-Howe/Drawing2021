import java.awt.*;

public class Rect extends Shape
{

    private int w, h;

    public Rect()
    {
        super();
        setType("Rect");
        setName("rect" + getId());
        setX(0);
        setY(0);
        setW(50);
        setH(50);
    }

    public Rect(String[] data)
    {
        super(data);
    }

    public int getW()
    {
        return w;
    }

    public void setW(int w)
    {
        this.w = w;
    }

    public int getH()
    {
        return h;
    }

    public void setH(int h)
    {
        this.h = h;
    }

    /**
     * takes a list of strings (e.g., {"Rect","body","17","0","255","0","0","0","0", "100","200","50","40",}) and
     * fills in the member variables for this class. This may require parsing some of these strings as numbers.
     *
     * @param itemsToLoad - an array of Strings to parse and put into the member variables of this class.
     */
    @Override
    public void fillInData(String[] itemsToLoad)
    {
        super.fillInData(itemsToLoad); // start with the variables everybody has....

        //TODO: you handle the rest. The above line got this started, but now you need to pull the stuff in Rect that
        // isn't in Shape.
        // Hint: look at how the superclass did it.



    }



    @Override
    /**
     * create a string that represents one row of the file for this drawing, consisting of the values for this shape,
     * separated by tabs.
     * @return - a string with the data about this object in a format that can be saved and loaded again.
     */
    public String toStringForFile()
    {
        String result = super.toStringForFile(); // start with the common stuff....
        // TODO: you write this... add the additional information specific to Rect, since the above line built the
        //  first part of the line.
        //  Hint: look at how the superclass did it.



        return result;

    }

    @Override
    /**
     * create a human-readable description of this object
     */
    public String toString()
    {
        return super.toString()+"\tW = "+this.getW()+"\tH = "+this.getH();
    }
}
