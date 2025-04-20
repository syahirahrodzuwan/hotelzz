import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {
    JButton Loginbtn;
    JButton Resetbtn;
    JButton Exitbtn;
    JTextField nameTF;
    JPasswordField pwTF;
    JLabel namelbl;
    JLabel pwlbl;
    JLabel WlcLbl;
    JLabel lblLogo;
    ImageIcon logo;
    JPanel titlePanel;
    JPanel namePanel;
    JPanel pwPanel;
    JPanel btnPanel;
    String name,password;
    JPanel PWlc;
    JPanel Plogo;
    JPanel Paneltop;
    JPanel EmptyPanel = new JPanel(new FlowLayout());

    public LoginPage(){
        setTitle("LOGIN PAGE");
        setSize(650, 380);
        setLocation(360,140);

        Container cp= super.getContentPane();
        cp.setBackground(new Color(247, 248, 223));
        cp.setLayout(new BorderLayout());

        //row 1
        titlePanel=new JPanel();
        titlePanel.setLayout(new BorderLayout());
        PWlc = new JPanel(new FlowLayout());
        Plogo =new JPanel(new FlowLayout());
        WlcLbl=new JLabel("WELCOME TO ZZZ HOTEL",SwingConstants.CENTER);
        WlcLbl.setFont(new Font("Kristen ITC",Font.BOLD,25));
        logo=new ImageIcon("logoHotel.jpg");
        lblLogo=new JLabel(logo,JLabel.CENTER);
        titlePanel.setBackground(new Color(247, 248, 223));
        PWlc.setBackground(new Color(247, 248, 223));
        Plogo.setBackground(new Color(247, 248, 223));
        PWlc.add(WlcLbl);
        Plogo.add(lblLogo);
        titlePanel.add(PWlc,BorderLayout.NORTH);
        titlePanel.add(Plogo,BorderLayout.SOUTH);
        cp.add(titlePanel, BorderLayout.NORTH);
        WlcLbl.setForeground(new Color(13, 32, 110));

        //row 1
        Paneltop=new JPanel(new GridLayout(5,1));
        namePanel=new JPanel();
        namePanel.setLayout(new FlowLayout());
        namelbl= new JLabel("NAME: ");
        namelbl.setFont(new Font("Arial",Font.BOLD,15));
        nameTF= new JTextField(30);

        namePanel.add(namelbl);
        namePanel.add(nameTF);
        namePanel.setBackground(new Color(247, 248, 223));
        Paneltop.add(EmptyPanel);
        Paneltop.add(EmptyPanel);
        Paneltop.add(namePanel);
        EmptyPanel.setBackground(new Color(247, 248, 223));
        namelbl.setForeground(new Color(13, 32, 110));
        nameTF.setFont(new Font("LFT Etica Mono",Font.BOLD,12));

        //row 2
        pwPanel= new JPanel();
        pwPanel.setLayout(new FlowLayout());
        pwlbl=new JLabel("PASSWORD: ");
        pwlbl.setFont(new Font("Arial",Font.BOLD,15));
        pwTF = new JPasswordField(30);

        pwPanel.add(pwlbl);
        pwPanel.add(pwTF);
        pwPanel.setBackground(new Color(247, 248, 223));
        Paneltop.add(pwPanel);
        Paneltop.add(EmptyPanel);
        cp.add(Paneltop,BorderLayout.CENTER);
        EmptyPanel.setBackground(new Color(247, 248, 223));
        Paneltop.setBackground(new Color(247, 248, 223));
        pwlbl.setForeground(new Color(13, 32, 110));

        //row3
        btnPanel=new JPanel();
        btnPanel.setLayout(new FlowLayout());
        Loginbtn=new JButton("LOGIN");
        Loginbtn.setFont(new Font("Arial",Font.BOLD,15));
        Resetbtn= new JButton("RESET");
        Resetbtn.setFont(new Font("Arial",Font.BOLD,15));
        Exitbtn= new JButton("EXIT");
        Exitbtn.setFont(new Font("Arial",Font.BOLD,15));

        btnPanel.add(Loginbtn);
        btnPanel.add(Resetbtn);
        btnPanel.add(Exitbtn);
        cp.add(btnPanel,BorderLayout.SOUTH);

        btnPanel.setBackground(new Color(247, 248, 223));
        Loginbtn.setBackground(new Color(247, 248, 223));
        Resetbtn.setBackground(new Color(247, 248, 223));
        Exitbtn.setBackground(new Color(247, 248, 223));
        Loginbtn.setForeground(new Color(13, 32, 110));
        Resetbtn.setForeground(new Color(13, 32, 110));
        Exitbtn.setForeground(new Color(13, 32, 110));

        //setListener to button
        Loginbtn.addActionListener(this);
        Resetbtn.addActionListener(this);
        Exitbtn.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        LoginPage lg=new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = nameTF.getText();
        password = pwTF.getText();

        if(e.getSource() == Loginbtn) {
            if ((name.equals("Safia") || name.equals("Izzah") || name.equals("Syahirah")) && password.equals("hotelz")) {
                JOptionPane.showMessageDialog(null, "login success");
                setVisible(false);
                new RoomPage().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "login error");
                nameTF.setText("");
                pwTF.setText("");
            }
        }

        else if (e.getSource() == Resetbtn){
            nameTF.setText("");
            pwTF.setText("");
        }

        else if (e.getSource() == Exitbtn){
            setVisible(false);
        }
    }
}