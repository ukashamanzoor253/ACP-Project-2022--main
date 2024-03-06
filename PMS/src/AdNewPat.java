import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdNewPat extends JFrame implements ActionListener {
    DataBase db = new DataBase();
    Connection con= null;
    JLabel PatienName , FatherName,DisesHistory,Prescription;
    //dateBirth
    JButton Save, Cancel;
    JTextField pName,fName,dHistory,Dprescription;
    JComboBox DocName;
    String Dname[]={"Dr Ukasha","Dr Saeed","Dr Ali"};
    JRadioButton Male, Female;
    ButtonGroup sex;

    JPanel myPanel,secndpanel;


    AdNewPat (){
        //create labels
        PatienName = new JLabel("Patien Name");
        FatherName = new JLabel("Father Name ");
        DisesHistory = new JLabel("Dises History");
        Prescription = new JLabel("Prescription ");

        // create textFields
        pName = new JTextField(15);
        fName = new JTextField(15);
        dHistory = new JTextField(30);
        Dprescription = new JTextField(30);
        //docter as comoBox
        DocName = new JComboBox(Dname);
       DocName.setBounds(50, 100,90,20);

        // create sex
        Male = new JRadioButton("Male ");
        Male.addActionListener(this);

        Female = new JRadioButton("Female");
        Female.addActionListener(this);

        //Group them
        sex = new ButtonGroup();
        sex.add(Male);
        sex.add(Female);



        //Create Save buttun
        Save = new JButton("Save");
        Save.setFocusable(false);
        Save.addActionListener(this);
        //Create Save Cancel
        Cancel = new JButton("Cancel");
        Cancel.setFocusable(false);
        Cancel.addActionListener(e -> this.dispose());
        //create panel
        myPanel = new JPanel();
         myPanel.setLayout(new GridLayout(12,0));
         secndpanel= new JPanel();
         secndpanel.setLayout(new GridLayout(6,6));
        //add all componetn to the panel


        myPanel.add(PatienName);
        myPanel.add(pName);


        myPanel.add(FatherName);
        myPanel.add(fName);


        myPanel.add(DisesHistory);
        myPanel.add(dHistory);


        myPanel.add(Prescription);
        myPanel.add(Dprescription);

        myPanel.add(DocName);

        secndpanel.add(Male);
        secndpanel.add(Female);
        secndpanel.add(Save);
        secndpanel.add(Cancel);
        /*myPanel.add(Male);
        myPanel.add(Female);



        myPanel.add(Save);
        myPanel.add(Cancel);*/



        //myJframe
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(myPanel);
        this.add(secndpanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Add New Doctore");
        //  this.setLayout(new GridLayout(15,2));
        // this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Save)
        {
            con = db.receiveConecction();
            String q= "insert into Patient(PatientName,PatientFName," +
                    "Sex,DoctorName,DiseasesHistory,Precscription)" +
                    " values (?,?,?,?,?,?)";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(q);
                preparedStatement.setString(1,pName.getText());
                preparedStatement.setString(2,fName.getText());
                preparedStatement.setString(3, String.valueOf(sex.getSelection()));
                preparedStatement.setString(4, (String) DocName.getSelectedItem());
                preparedStatement.setString(5,DisesHistory.getText());
                preparedStatement.setString(6,Prescription.getText());

                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null,"Saved");
                Save.setEnabled(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }

    }
}
