import javax.swing.*;
import java.awt.*;

public class GustGui extends JFrame {

    JMenuBar myMenue;
    JMenu print, SearchRecord, Help;
    // JToolBar
    JToolBar myTollBar;
    JButton search,Print;

    // SearchRecord items
    JMenuItem SPBName,SPBId,SPBAge;
    // Help
    JMenuItem AboutUs,ChangePassword;


    GustGui(){
        myMenue = new JMenuBar();
        // Create Every menu Sperataly
        SearchRecord = new JMenu("Search Recordd ");
        print = new JMenu("Print Record ");
        Help = new JMenu("Help ");

        // Create Every Item of Search Record
        SPBName = new JMenuItem("search by Name");
        SPBId = new JMenuItem("search by ID");
        SPBAge = new JMenuItem("search by Age");

        // Create Every item of Help
        AboutUs= new JMenuItem("About Us");
        ChangePassword= new JMenuItem("Change Password");


        // ADD All SearchRecord items to corrosponding menu
        SearchRecord.add(SPBName);
        SearchRecord.add(SPBId);
        SearchRecord.add(SPBAge);

        // ADD All Help items to corrosponding menu
        Help.add(AboutUs);
        Help.add(ChangePassword);

        // add every menu to MENU BAR
        myMenue.add(SearchRecord);
        myMenue.add(Help);
        myMenue.add(print);

        //Create ToolBar
        myTollBar = new JToolBar("Tool Bar");
        myTollBar.setFloatable(false);
        myTollBar.setRollover(true);

        //crete Buttuns for toolBar
        search= new JButton("Search Record");
        Print= new JButton("Print");
        search.setFocusable(false);
        Print.setFocusable(false);

        // add all buttun to ToolBar
        myTollBar.add(search);
        myTollBar.add(Print);
        //Jframe for Administrator
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(myMenue);
        this.add(myTollBar);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Gust Page");
        this.setLayout(new GridLayout(15,2));
        // this.setLayout(new FlowLayout(FlowLayout.LEFT));


    }
}
