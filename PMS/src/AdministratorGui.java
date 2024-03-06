import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorGui extends JFrame implements ActionListener {
    JMenuBar myMenue;
    JMenu ManageRecord, SearchRecord, Help;

    // JToolBar
    JToolBar myTollBar;
    JButton ANPatient,  SPRecord, ANDoctor, Print;
    // ManageRecord items
    JMenuItem AddNewPatient,AddNewDoctor,AddNewDisease,DeletePatienRecord,UpdateRecord;
   //sub menu
    JMenu updateRecordMenue;
    JMenuItem UpdatePatient,UpdateDoctor;


    // Search Record
    JMenuItem SPBName,SPBId,SPBAge,SPBDisease,SPBDoctor,SDBName,SDBDSpecialization;

    // Help
    JMenuItem AboutUs,ChangePassword;
    AdministratorGui(){
        //Create The menu Bar

        myMenue = new JMenuBar();

        // Create Every menu Sperataly
        ManageRecord = new JMenu("Manage Record ");
        SearchRecord = new JMenu("Search Recordd ");
        Help = new JMenu("Help ");


        // Create Every Item of Manage Record

        AddNewPatient = new JMenuItem("Add New Patient");
        AddNewDoctor = new JMenuItem("Add New Doctor");
        AddNewDisease = new JMenuItem("Add New Disease");
        DeletePatienRecord = new JMenuItem("Delete Patien Record");
        UpdateRecord = new JMenuItem("Update Record");


        // sub menue items
        updateRecordMenue = new JMenu("update Record Menu");
        UpdatePatient = new JMenuItem("Update Patient");
        UpdateDoctor = new JMenuItem("Update Doctor");
        // Create Every Item of Search Record
        SPBName = new JMenuItem("search Patient by Name");
        SPBId = new JMenuItem("search Patient by ID");
        SPBAge = new JMenuItem("search Patient by Age");
        SPBDisease = new JMenuItem("search Patient by Disease");
        SPBDoctor = new JMenuItem("search Patient by Doctor");
        SDBName = new JMenuItem("search Doctor by name");
        SDBDSpecialization = new JMenuItem("search Doctor by Specialization");

        // Create Every item of Help

        AboutUs= new JMenuItem("About Us");
        ChangePassword= new JMenuItem("Change Password");



    // ADD All ManageRecord items to corrosponding menu
        ManageRecord.add(AddNewPatient);
        ManageRecord.add(AddNewDoctor);
        ManageRecord.add(AddNewDisease);
        ManageRecord.add(DeletePatienRecord);
        ManageRecord.add(updateRecordMenue);


        // ADD sub menu to its postion
        updateRecordMenue.add(UpdatePatient);
        updateRecordMenue.add(UpdateDoctor);

        // ADD All SearchRecord items to corrosponding menu
        SearchRecord.add(SPBName);
        SearchRecord.add(SPBId);
        SearchRecord.add(SPBAge);
        SearchRecord.add(SPBDisease);
        SearchRecord.add(SPBDoctor);
        SearchRecord.add(SDBName);
        SearchRecord.add(SDBDSpecialization);

        // ADD All Help items to corrosponding menu
        Help.add(AboutUs);
        Help.add(ChangePassword);

        // add every menu to MENU BAR
        //myMenue.add(updateRecordMenue);
        myMenue.add(ManageRecord);
        myMenue.add(SearchRecord);
        myMenue.add(Help);

        //Create ToolBar
         myTollBar = new JToolBar("Tool Bar");
          myTollBar.setFloatable(false);
         myTollBar.setRollover(true);
        //crete Buttuns for toolBar
        ANPatient= new JButton("ADD Patient");
        SPRecord= new JButton("Search Record");
        ANDoctor= new JButton("ADD Doctor");
        Print= new JButton("Print");
        ANPatient.setFocusable(false);
        SPRecord.setFocusable(false);
        ANDoctor.setFocusable(false);
        Print.setFocusable(false);




        // add all buttun to ToolBar
        myTollBar.add(ANPatient);
        myTollBar.add(SPRecord);
        myTollBar.add(ANDoctor);
        myTollBar.add(Print);

        // adding ActionListener to my items:
        AddNewDisease.addActionListener(this);
        AddNewDoctor.addActionListener(this);
        AddNewPatient.addActionListener(this);
        UpdatePatient.addActionListener(this);

        //Jframe for Administrator
         this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
         this.add(myMenue);
         this.add(myTollBar);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Administrator Page");
        this.setLayout(new GridLayout(16,8));
       // this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==AddNewDisease)
        {

            AdNewDise addNewDisease = new  AdNewDise();

        }
        else if (e.getSource()==AddNewDoctor)
        {
            AdNewDoc adNewDoc= new  AdNewDoc();
        }
        else if (e.getSource()== AddNewPatient)
        {
            AdNewPat adNewPat = new AdNewPat();
        }
        else if (e.getSource()== UpdatePatient)
        {
            UpdatePat updatePatient= new UpdatePat();

        }
    }
}
