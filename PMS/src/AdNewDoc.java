import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdNewDoc extends JFrame implements ActionListener {
    //database instance and connection
    DataBase db = new DataBase();
    Connection con= null;

    JLabel DoctoerName , field;
    JButton Save, Cancel;
    JTextField DocName;
    JComboBox fieldSpecalization;
    String fields[]={"Allergies","Appendicitis","Insomnia","Asthma"};


    JPanel myPanel;
    AdNewDoc (){
        // create labels
        DoctoerName = new JLabel("Doctore Name");
        field = new JLabel("Doctore Specialization ");

        // create textFields
        DocName = new JTextField(15);
       fieldSpecalization = new JComboBox(fields);
        fieldSpecalization.setBounds(50, 100,90,20);



        //Create Save buttun
        Save = new JButton("Save");
        Save.setFocusable(false);
        Save.addActionListener(this);
        //Create Save Cancel
        Cancel = new JButton("Cancel");
        Cancel.setFocusable(false);
        Cancel.addActionListener(e -> this.dispose());


        //myPanel
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 6));
        //add all componetn to the panel
        myPanel.add(DoctoerName);
        myPanel.add(DocName);

        myPanel.add(field);
        myPanel.add(fieldSpecalization);

        myPanel.add(Save);
        myPanel.add(Cancel);





        //myJframe
        this.setSize(500, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(myPanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Add New Doctore");
        //  this.setLayout(new GridLayout(15,2));
        // this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        con = db.receiveConecction();

        /*if (con!=null)
            System.out.println("conectec");

        */
        String q= "insert into Doctor(DoctorName,Field) values (?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1,DocName.getText());
            preparedStatement.setString(2, (String) fieldSpecalization.getSelectedItem());
            JOptionPane.showMessageDialog(null,"Saved");
            int row = preparedStatement.executeUpdate();

            Save.setEnabled(false);
          /*  if (row>0)
            {
                System.out.println("Done");
            }*/

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }
}
