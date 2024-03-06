import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Choise extends JFrame implements ActionListener {
    JRadioButton administrator, gust;
    ButtonGroup group;
    JPanel myPanel;

    Choise(){

        //Create Radio Buttun
        administrator = new JRadioButton("Administrator ");
        administrator.addActionListener(this);

        gust = new JRadioButton("Gust");
        gust.addActionListener(this);

        //Group them
        group = new ButtonGroup();
        group.add(administrator);
        group.add(gust);

        JLabel jLabel1 = new JLabel("This System Devoloped by");
        JLabel jlabel2 = new JLabel(" 4162/FBAS/BSSE/F20");
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jlabel2.setHorizontalAlignment(JLabel.CENTER);



        // Create panel
        myPanel= new JPanel();
      //  myPanel.setLayout(new GridLayout(2,2));
        myPanel.add(administrator);
        myPanel.add(gust);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,2));

        jPanel.add(jLabel1);
        jPanel.add(jlabel2);
        //This is myFrame
        this.setSize(300, 300);
       // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.add(myPanel);
        this.add(jPanel);

        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Choice Page");
       // this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(4,3));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==administrator)
        {
            this.setVisible(false);
            // Create an instance of Admin Login Page
            AdminLoginPage adminLoginPage= new  AdminLoginPage();
        }
        else
        {
            this.setVisible(false);
            // Create an instance of Gust Login Page
            GustLoginPage gustLoginPage = new GustLoginPage();
        }


    }
}
