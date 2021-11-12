import javax.swing.*;

public class DrawingRunner
{
    public static void main(String[] args)
    {

        final int DEBUG_MODE_TEST_RECT_IN_ISOLATION = 0;
        final int DEBUG_MODE_TEST_RECT_PANEL = 1;
        final int DEBUG_MODE_TEST_DRAWING_PANEL_NO_GRAPHICS = 2;
        final int DEBUG_MODE_FULL_RUN = 3;

        int debugMode = DEBUG_MODE_TEST_RECT_IN_ISOLATION; // change this, based on what you are ready to test.

        switch(debugMode)
        {
            case DEBUG_MODE_TEST_RECT_IN_ISOLATION:

                Rect r0 = new Rect();
                System.out.println("Generic Rect: "+r0);
                System.out.println("\n==========================\n");
                String[] arr = {"Rect","test1","12","0","255","0","200","0","255","100","200","30","40"};
                Rect r1 = new Rect(arr);
                System.out.println("r1's toString:\n"+r1);
                System.out.println("\n==========================\n");
                System.out.println("r1's toStringForFile:\n"+r1.toStringForFile());
                System.out.println("\n==========================\n");

                System.out.println("Duplicating r1 -> r2");
                Shape r2 = r1.duplicate();
                System.out.println(r2);
                System.out.println("\n==========================\n");

                break;

            case DEBUG_MODE_TEST_RECT_PANEL:

                Rect r3 = new Rect();
                System.out.println("Rect before panel: "+r3);
                RectPanel rpanel = new RectPanel();
                System.out.println("\n==========================\n");
                int result = rpanel.displayDialog(r3);
                System.out.println("Response from display dialog was: "+result);
                if (JOptionPane.OK_OPTION == result)
                {
                    rpanel.updateShapeFromUI(r3);
                    System.out.println("Now Rect is: "+r3);
                }
                System.out.println("\n==========================\n");
                break;

            case DEBUG_MODE_TEST_DRAWING_PANEL_NO_GRAPHICS:
                DrawingPanel dPanel = new DrawingPanel();
                String[][] rects = {{"Rect","test1","1","0","255","0","200","0","255","100","200","130","140"},
                        {"Rect","test2","2","255","255","0","200","0","255","130","220","30","40"},
                        {"Rect","test3","3","255","0","0","200","0","255","200","20","80","90"},
                        {"Rect","test4","4","255","0","255","200","0","255","180","150","30","40"},
                        {"Rect","test5","5","0","0","255","200","0","255","200","500","130","140"}};
                for (String[] partsFromFile: rects)
                {

                    Rect rr = new Rect(partsFromFile);
                    System.out.println("Adding: "+rr);
                    dPanel.addShape(rr);
                }
                System.out.println("\n==========================\n");

                System.out.println("DrawingPanel description:");
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("List of names:");
                String[] nameList = dPanel.getListOfNames();
                for (String s: nameList)
                    System.out.println(s);
                System.out.println("\n==========================\n");

                System.out.println("Deleting #2");
                dPanel.deleteItem(2);
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("Duplicating #3");
                dPanel.duplicateItem(3);
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("Shifting 4 up");
                dPanel.shiftUp(4);
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("Shifting 1 down");
                dPanel.shiftDown(1);
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("Editing item 0");
                dPanel.editItem(0);
                System.out.println(dPanel);
                System.out.println("\n==========================\n");

                System.out.println("Clearing all shapes");
                dPanel.clearAllShapes();
                System.out.println(dPanel);
                System.out.println("\n==========================\n");
                break;

            case DEBUG_MODE_FULL_RUN:
                DrawingFrame app = new DrawingFrame();
                break;
        }

    }
}
