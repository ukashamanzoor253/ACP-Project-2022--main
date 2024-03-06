import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class UpdatePat extends JFrame  implements ActionListener {
    DataBase db = new DataBase();
    Connection con= null;
    JButton submittButtun;
    JLabel massage;
    JComboBox selectId;
   //String ID[]={"Dr Usman","Dr Saeed","Dr Ali"};
    JPanel myPanel;
    Vector v;
    UpdatePat (){
    int id;
         v = new Vector();
        try {
            con = db.receiveConecction();
            Statement statement= con.createStatement();
            String q= "select * from Patient";
            CallableStatement callableStatement = con.prepareCall(q);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next())
            {
                 id = resultSet.getInt("Patient ID");
                 v.add(String.valueOf(id));
                System.out.println(id);
            }
            /*else
                System.out.println("some thing wrong");*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        submittButtun = new JButton("Submitt");
        submittButtun.setFocusable(false);
        submittButtun.addActionListener(this);

        selectId= new JComboBox(v);
        selectId.addActionListener(this);

        selectId.setBounds(50, 100,50,20);

        massage = new JLabel("Select ID");

        //myPanel
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 6));
        myPanel.add(massage);
        myPanel.add(selectId);
        myPanel.add(submittButtun);

        //myframe
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(myPanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Select ID");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submittButtun)
        {
            JFrame frame = new JFrame();
            System.out.println(selectId.getSelectedItem());

//panel
            JPanel panel = new JPanel();
            myPanel = new JPanel();
            myPanel.setLayout(new GridLayout(6, 6));

            //add labels to panel

        /*    panel.add(label0);
            panel.add(label_0);*/
//frame
            frame.setTitle("Dispaly");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(panel);
            frame.setBackground(Color.LIGHT_GRAY);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        }
    }







    }


