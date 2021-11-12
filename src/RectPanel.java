import javax.swing.*;
import java.awt.*;

public class RectPanel extends ShapePanel
{

    private int width, height;

    private JTextField nameField;
    private JLabel idLabel;
    private JSpinner xSpinner, ySpinner, wSpinner, hSpinner;
    private ColorWell fillWell, strokeWell;


    public void buildUI()
    {
        setLayout(new GridLayout(8,2));


        add(new JLabel("Name"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("id"));
        idLabel = new JLabel("");
        add(idLabel);

        add(new JLabel("Fill"));
        fillWell = new ColorWell();
        add(fillWell);

        add(new JLabel("Stroke"));
        strokeWell = new ColorWell();
        add(strokeWell);

        add(new JLabel("X"));
        xSpinner = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        add(xSpinner);

        add(new JLabel("Y"));
        ySpinner = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        add(ySpinner);

        add(new JLabel("W"));
        wSpinner = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        add(wSpinner);

        add(new JLabel("H"));
        hSpinner = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        add(hSpinner);

    }



}
