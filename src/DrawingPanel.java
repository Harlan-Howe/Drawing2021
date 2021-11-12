import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
{
    public ArrayList<Shape> myShapes;


    public DrawingPanel()
    {
        super();
        setBackground(Color.lightGray);
        myShapes = new ArrayList<Shape>();
    }

    /**
     * draws all the shapes in myShapes
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("No content yet - you'll need to fill in DrawingPanel's paintComponent.", 20, 20); // temp code for stub function.

        // TODO: you write this. You are telling each of the shapes in myShapes to draw themselves.

    }

    /**
     * adds the given shape to myShapes.
     * @param shapeToAdd
     */
    public void addShape(Shape shapeToAdd)
    {
        // TODO: you write this.



        repaint(); // easy to forget to do this, so I'll add it here for you.
    }

    /**
     * gets rid of all the shapes in myShapes, typically in preparation to load a file.
     */
    public void clearAllShapes()
    {
        // TODO: you write this.


        repaint(); // easy to forget to do this, so I'll add it here for you.
    }

    /**
     * essentially an accessor for the myShapes variable.
     * @return - an ArrayList of all the shapes in this panel.
     */
    public ArrayList<Shape> getShapeList()
    {
        return myShapes;
    }

    /**
     * gets an array of just the names for the shapes, in the same order as the objects.
     * (This is used to populate the list on the left side of the screen.)
     * @return - an array of strings consisting of the "name" variables for all the shapes.
     */
    public String[] getListOfNames()
    {
        // TODO: you write this.
        String[] result = {"Not","written","yet"}; // temp code for stub function




        return result;
    }

    /**
     * deselect everything, then tell the ith item that it is selected.
     * @param i - the index of the item to select, or -1 if none should be.
     */
    public void setSelectedItem(int i)
    {
        System.out.println("setting Selected item: "+i); // temp code
        //TODO: you write this.


        repaint(); // easy to forget to do this, so I'll add it here for you.
    }

    /**
     * deletes the item at index i in the list. Note: i is not necessarily the id.
     * @param i - which item in the list to delete.
     */
    public void deleteItem(int i)
    {
        //TODO: you write this



        repaint(); // easy to forget to do this, so I'll add it here for you.
    }

    /**
     * makes a duplicate of this shape and puts it at location i+1 on the list. Note: i is not necessarily the id.
     * @param i- which item in the list to duplicate.
     */
    public void duplicateItem(int i)
    {
        if (i!= -1)
        //TODO: you write this


        repaint(); // easy to forget to do this, so I'll add it here for you.
    }


    /**
     * invites the user to make changes to the parameters for this item
     * @param i - which item to edit
     */
    public void editItem(int i)
    {
        Shape selectedShape = null;
        int result = JOptionPane.CANCEL_OPTION;
        // TODO: selectedShape = the shape at location i in your list.... (one line)



        String type = selectedShape.getType();
        ShapePanel editPanel = null;
        if (type.equals("Rect"))
        {
            editPanel = new RectPanel();

        }
        // TODO: eventually, you'll add more "if"s here for the other types, once they exist.

        if (editPanel != null)
        {
            result = editPanel.displayDialog(selectedShape);
            editPanel.updateShapeFromUI(selectedShape);
            repaint();
        }
    }

    /**
     * raises this item on the list of items
     * @param i - which item to shift
     */
    public void shiftUp(int i)
    {
        //TODO: you write this


        repaint(); // easy to forget to do this, so I'll add it here for you.
    }

    /**
     * lowers this item on the list of items
     * @param i - which item to shift.
     */
    public void shiftDown(int i)
    {
        //TODO: you write this


        repaint(); // easy to forget to do this, so I'll add it here for you.

    }

    /**
     * prints the list of Shapes
     * @return
     */
    public String toString()
    {
        String result = "Drawing Panel\n---------";

        //TODO - you write this.


        result += "-------";
        return result;
    }

}
