import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AdNewDise extends JFrame implements ActionListener {
    DataBase db = new DataBase();
    Connection con= null;
    JLabel DiseaseName , DiseaseDescription;
    JButton Save, Cancel;
    JTextField DisName, DisDescription;

    JPanel myPanel;



    AdNewDise ()
   {
       // create labels
       DiseaseName = new JLabel("Disease Name");
       DiseaseDescription = new JLabel("Disease Description");

       // create textFields
       DisName = new JTextField(15);
       DisDescription = new JTextField(30);
       DisDescription.setPreferredSize(new Dimension(30,30));

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
       myPanel.add(DiseaseName);
       myPanel.add(DisName);

       myPanel.add(DiseaseDescription);
       myPanel.add(DisDescription);

       myPanel.add(Save);
       myPanel.add(Cancel);





       //myJframe
       this.setSize(500, 250);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
        this.add(myPanel);
       this.setBackground(Color.LIGHT_GRAY);
       this.setTitle("Add New Disease");
     //  this.setLayout(new GridLayout(15,2));
      // this.setLayout(new FlowLayout(FlowLayout.LEFT));
       this.setLayout(new FlowLayout(FlowLayout.CENTER));

   }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Save)
        {
            con = db.receiveConecction();
            String q= "insert into Disease(DiseaseName,DiseaseDescription) values (?,?)";

            try {
                PreparedStatement preparedStatement = con.prepareStatement(q);
                preparedStatement.setString(1,DisName.getText());
                preparedStatement.setString(2,DisDescription.getText());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Saved");
                Save.setEnabled(false);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    }
}

