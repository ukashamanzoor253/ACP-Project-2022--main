import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage extends JFrame implements ActionListener {
    //Username and password must be
    String un= "BSSE/F20";
    String pa="4158";

    JLabel userLael, PassowrdLabel;
    JButton submittButtun;
    JTextField userName, passord;

    JPanel myPanel;

    AdminLoginPage() {

    // create labels
        userLael = new JLabel("User Name");
        PassowrdLabel = new JLabel("Password");
        // create textFields
        userName = new JTextField(15);
        passord = new JTextField(5);


        //Create submit buttun
        submittButtun = new JButton("Submitt");
        submittButtun.setFocusable(false);
        submittButtun.addActionListener(this);
        //submittButtun.setEnabled(false);
        //myPanel
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(4, 2));
        //add all componetn to the panel
        myPanel.add(userLael);
        myPanel.add(userName);
        myPanel.add(PassowrdLabel);
        myPanel.add(passord);
        myPanel.add(submittButtun);


        //This is myFrame
        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(myPanel);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Administrator Page");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userName.getText().toUpperCase();
        String pass = passord.getText();



        if (username.equals(un) && pass.equals(pa))
        {
                this.setVisible(false);
                AdministratorGui administratorGui = new AdministratorGui();

        }
       else
        {
            JOptionPane.showMessageDialog(null,"Please Enter Valid User Name AND Passowrd!!");
            JOptionPane.showMessageDialog(null,"User Name= BSSE/F20");
            JOptionPane.showMessageDialog(null,"Passwor = 4158");
        }




    }



    public boolean checkForGust() {
        return false;
    }
    public boolean checkForAddmin(String uu, String pp){
        System.out.println("you are to check for addmin");
        return true;
    }

}

