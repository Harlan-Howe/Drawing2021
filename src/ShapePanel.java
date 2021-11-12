import javax.swing.*;
import java.awt.*;

/**
 * This is a panel that has inputs describing your shape that can be used to edit the shape or to make a new one.
 * It is an abstract class, so you'll want to mnake custom ShapePanels for each of your shapes.
 */
public abstract class ShapePanel extends JPanel
{

    public ShapePanel()
    {
        super();
        buildUI();
    }

    public abstract void buildUI();

    public int displayDialog(Shape shapeToDisplay)
    {
        copyDataToUI(shapeToDisplay);
        int result = JOptionPane.showConfirmDialog(null,this);
        return result;
    }

    /**
     * copy the information in the "inShape" into the input controls in the layouts. To do this, you can use the following
     * methods:
     * - for JTextFields and JLabels, use setText(String). (Note: for id, you'll need to convert the int to a string, so
     *             use something like "idLabel.setText(""+shapeToDisplay.getId());"
     * - for ColorWells, use setColor(Color).
     * - for JSpinners, use setValue(int) or setValue(double).
     *
     * @param inShape - the shape whose data you are putting into the user interface.
     */
    public abstract void copyDataToUI(Shape inShape);

    /**
     * copy the information out of the input controls and into the shapeToUpdate (except for the id). To get
     * information from the various controls, you can use the following methods:
     * - for JTextFields, use getText() --> String.
     * - for ColorWells, use getColor() --> Color.
     * - for JSpinners, use (Integer)spinnerName.getValue() or (Double)spinnerName.getValue().
     * @param shapeToUpdate
     */
    public abstract void updateShapeFromUI(Shape shapeToUpdate);

}
