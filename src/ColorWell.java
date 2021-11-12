import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a custom control that lets the user select a color... basically when you press the button, it calls up
 * swing's ColorChooser.
 */
public class ColorWell extends JButton implements ActionListener
{
    private Color myColor;

    public ColorWell()
    {
        super();
        setPreferredSize(new Dimension(25,25));
        addActionListener(this);
    }


    public Color getColor()
    {
        return myColor;
    }

    public void setColor(Color myColor)
    {
        this.myColor = myColor;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(myColor);
        g.fillRect(10,10,getWidth()-20, getHeight()-20);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(myColor);
        int result = JOptionPane.showConfirmDialog(this, colorChooser);
        if (JOptionPane.OK_OPTION == result)
            setColor(colorChooser.getColor());

    }
}
