import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class DrawingFrame extends JFrame implements ActionListener, ListSelectionListener
{
    private DrawingPanel mainPanel;
    private Box toolPanel;
    private JPanel nameListPanel;
    private JLabel message;
    private JList nameList;
    private JMenuBar theMenubar;
    private File currentFile;

    public DrawingFrame()
    {
        super("Drawing!");
        setSize(1000,800);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        setVisible(true);
    }

    //region GUI setupMethods
    // =====================================================================  GUI setup methods
    public void setupUI()
    {
        getContentPane().setLayout(new BorderLayout());

        mainPanel = new DrawingPanel();
        toolPanel = Box.createHorizontalBox();
        nameListPanel = new JPanel();
        message = new JLabel();

        getContentPane().add(toolPanel,BorderLayout.NORTH);
        getContentPane().add(nameListPanel, BorderLayout.WEST);
        getContentPane().add(mainPanel,BorderLayout.CENTER);
        getContentPane().add(message,BorderLayout.SOUTH);

        setupToolPanel();
        setupNameListPanel();
        setupMainPanel();
        setupMenubar();

    }

    public void setupToolPanel()
    {
        JButton addRectButton = new JButton(new ImageIcon("icons/AddRect.png","Add New Rect"));
        addRectButton.addActionListener(this);
        addRectButton.setActionCommand("Add New Rect");
        toolPanel.add(addRectButton);

        JButton addOvalButton = new JButton(new ImageIcon("icons/AddOval.png","Add New Oval"));
        addOvalButton.addActionListener(this);
        addOvalButton.setActionCommand("Add New Oval");
        toolPanel.add(addOvalButton);

        JButton addLineButton = new JButton(new ImageIcon("icons/AddLine.png","Add New Line"));
        addLineButton.addActionListener(this);
        addLineButton.setActionCommand("Add New Line");
        toolPanel.add(addLineButton);

        JButton addArcButton = new JButton(new ImageIcon("icons/AddArc.png","Add New Arc"));
        addArcButton.addActionListener(this);
        addArcButton.setActionCommand("Add New Arc");
        toolPanel.add(addArcButton);

        JButton addTextButton = new JButton(new ImageIcon("icons/AddText.png","Add New Text"));
        addTextButton.addActionListener(this);
        addTextButton.setActionCommand("Add New Text");
        toolPanel.add(addTextButton);

        // Note: I've also made icons for round rect, polygon and group, if you wish to add buttons for them.

        JButton deleteButton = new JButton(new ImageIcon("icons/Delete.png","Add New Text"));
        deleteButton.addActionListener(this);
        deleteButton.setActionCommand("Delete");
        toolPanel.add(deleteButton);

        JButton duplicateButton = new JButton(new ImageIcon("icons/Duplicate.png","Add New Text"));
        duplicateButton.addActionListener(this);
        duplicateButton.setActionCommand("Duplicate");
        toolPanel.add(duplicateButton);

        JButton editButton = new JButton(new ImageIcon("icons/Edit.png","Add New Text"));
        editButton.addActionListener(this);
        editButton.setActionCommand("Edit");
        toolPanel.add(editButton);

        JButton shiftUpButton = new JButton(new ImageIcon("icons/ShiftUp.png","Add New Text"));
        shiftUpButton.addActionListener(this);
        shiftUpButton.setActionCommand("Shift Up");
        toolPanel.add(shiftUpButton);

        JButton shiftDownButton = new JButton(new ImageIcon("icons/ShiftDown.png","Add New Text"));
        shiftDownButton.addActionListener(this);
        shiftDownButton.setActionCommand("Shift Down");
        toolPanel.add(shiftDownButton);
    }

    public void setupNameListPanel()
    {
        nameList = new JList<String>();
        nameListPanel.setLayout(new GridLayout(1,1));
        nameListPanel.add(new JScrollPane(nameList));
        nameList.setListData(mainPanel.getListOfNames());
        nameList.addListSelectionListener(this);
    }


    public void setupMainPanel()
    {
        newFile();
    }

    public void setupMenubar()
    {
        theMenubar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        theMenubar.add(fileMenu);
        // ----------------------------
        JMenuItem newFileItem = new JMenuItem("New");
        newFileItem.addActionListener(this);
        fileMenu.add(newFileItem);

        JMenuItem openFileItem = new JMenuItem("Open");
        openFileItem.addActionListener(this);
        fileMenu.add(openFileItem);

        JMenuItem  saveFileItem = new JMenuItem("Save");
        saveFileItem.addActionListener(this);
        fileMenu.add(saveFileItem);

        JMenuItem saveAsFileItem = new JMenuItem("Save As");
        saveAsFileItem.addActionListener(this);
        fileMenu.add(saveAsFileItem);
        // ---------------------------
        JMenu selectionMenu = new JMenu("Selection");
        theMenubar.add(selectionMenu);

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(this);
        selectionMenu.add(deleteItem);

        JMenuItem duplicateItem = new JMenuItem("Duplicate");
        duplicateItem.addActionListener(this);
        selectionMenu.add(duplicateItem);

        JMenuItem editItem = new JMenuItem("Edit");
        editItem.addActionListener(this);
        selectionMenu.add(editItem);

        JMenuItem shiftUpItem = new JMenuItem("Shift Up");
        shiftUpItem.addActionListener(this);
        selectionMenu.add(shiftUpItem);

        JMenuItem shiftDownItem = new JMenuItem("Shift Down");
        shiftDownItem.addActionListener(this);
        selectionMenu.add(shiftDownItem);




        this.setJMenuBar(theMenubar);
    }
    //endregion
    // ===========================================================

    //region Menubar responses
    // =========================================================== Menubar (and some button) responses
    public void newFile()
    {
        currentFile = null;
        mainPanel.clearAllShapes();
    }

    public void loadFile()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(currentFile);
        int result = chooser.showOpenDialog(this);
        if (JFileChooser.APPROVE_OPTION == result)
        {
            currentFile = chooser.getSelectedFile();

            try
            {
                mainPanel.clearAllShapes();
                BufferedReader reader = new BufferedReader(new FileReader(currentFile));

                String headerLine = reader.readLine(); // stripping this line from the file; we'll ignore it.
                String dataLine = reader.readLine();
                while (dataLine != null)
                {
                    System.out.println(dataLine);
                    String[] parts = dataLine.split("\t"); // parts is now an array of strings holding the column's data for this row.
                    String type = parts[0];
                    System.out.println(type);
                    Shape shapeToAdd = null;
                    if (type.equals("Rect"))
                    {
                        shapeToAdd = new Rect(parts); // deactivated until you create a Rect class.
                    }
                    //TODO: add similar "if" statement blocks here to the four preceeding lines to make other shape
                    //    types, once you've made those classes.

                    System.out.println(shapeToAdd);
                    if (shapeToAdd != null)
                        mainPanel.addShape(shapeToAdd);
                    dataLine = reader.readLine();
                }
                reader.close();
            }
            catch (FileNotFoundException fnfExp)
            {
                System.out.println("File not found.");
                fnfExp.printStackTrace();
            }
            catch (IOException ioExp)
            {
                System.out.println("Problem reading the file.");
                ioExp.printStackTrace();
            }


        }
        mainPanel.repaint();
        nameList.setListData(mainPanel.getListOfNames());
    }

    public void saveFileAs()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(currentFile);

        int result = chooser.showSaveDialog(this);
        if (JFileChooser.APPROVE_OPTION == result)
        {
            currentFile = chooser.getSelectedFile();
            saveFile();
        }
    }


    public void saveFile()
    {
        if (currentFile == null)
        {
            saveFileAs();
            return;
        }
        try
        {
            PrintWriter pw = new PrintWriter(currentFile);
            pw.println("This is the dummy header line. I'll make it look different so you don't think this is the same file as the original!");
            ArrayList<Shape> shapeList = mainPanel.getShapeList();
            for (Shape s: shapeList)
                pw.println(s.toStringForFile());

            pw.close();
        }catch (FileNotFoundException fnfExcp)
        {
            System.out.println("Could not create file.");
            fnfExcp.printStackTrace();
        }
    }

    public void deleteSelection()
    {
        int whichItem = nameList.getSelectedIndex();
        if (whichItem != -1)
        {
            mainPanel.deleteItem(whichItem);
            nameList.setListData(mainPanel.getListOfNames());
        }
    }

    public void duplicateSelection()
    {
        int whichItem = nameList.getSelectedIndex();
        if (whichItem != -1)
        {
            mainPanel.duplicateItem(whichItem);
            nameList.setListData(mainPanel.getListOfNames());
        }
    }

    public void editSelection()
    {
        int whichItem = nameList.getSelectedIndex();
        if (whichItem != -1)
        {
            mainPanel.editItem(whichItem);
            nameList.setListData(mainPanel.getListOfNames());
        }

    }

    public void shiftSelectionUp()
    {
        int whichItem = nameList.getSelectedIndex();
        if (whichItem > 0)
        {
            mainPanel.shiftUp(whichItem);
            nameList.setListData(mainPanel.getListOfNames());
        }
    }


    public void shiftSelectionDown()
    {
        int whichItem = nameList.getSelectedIndex();
        if (whichItem != -1 && whichItem < mainPanel.getListOfNames().length-1)
        {
            mainPanel.shiftDown(whichItem);
            nameList.setListData(mainPanel.getListOfNames());
        }
    }
    //endregion
    // ===========================================================




    //region NewItem Button responses
    // =========================================================== NewItem Button responses

    /**
     * creates a new, generic Rect object and adds it to the mainPanel, also updating the list of data.
     */
    public void addNewRect()
    {
        mainPanel.addShape(new Rect());
        nameList.setListData(mainPanel.getListOfNames());
    }

    // TODO: put other "addNew" Shape methods here.


    //endregion
    // ===========================================================




    //region EventListeners
    // ===========================================================  EventListeners
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Action command: "+e.getActionCommand());
        if (e.getActionCommand().equals("New"))
            newFile();

        if (e.getActionCommand().equals("Open"))
            loadFile();

        if (e.getActionCommand().equals("Save"))
            saveFile();

        if (e.getActionCommand().equals("Save As"))
            saveFileAs();
        // -----------------------------
        if (e.getActionCommand().equals("Delete"))
            deleteSelection();
        if (e.getActionCommand().equals("Duplicate"))
            duplicateSelection();

        if (e.getActionCommand().equals("Edit"))
            editSelection();

        if (e.getActionCommand().equals("Shift Up"))
            shiftSelectionUp();

        if (e.getActionCommand().equals("Shift Down"))
            shiftSelectionDown();
        // -----------------------------
        if (e.getActionCommand().equals("Add New Rect"))
            addNewRect();
        // TODO: eventually, add methods for the other "Add" buttons here, once you have classes for the other shapes.
    }

    /**
     * Called whenever the value of the selection changes. (in the name list....)
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getSource() == nameList) // Not likely to be anything else....
        {
            int selectedIndex =nameList.getSelectedIndex();
            mainPanel.setSelectedItem(selectedIndex);
        }
    }
    //endregion
    // ===========================================================
}
