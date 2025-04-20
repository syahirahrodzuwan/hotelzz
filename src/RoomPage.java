import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomPage extends JFrame implements ActionListener {
    Container cp;
    JPanel pnl2, pnl3, pnl4, pnl5, pnl6, desc, put, pic, rc;
    JLabel logo, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, room1, room2, room3;
    JButton bt1,bt2;

    public static void main(String[] args) {
        RoomPage rd = new RoomPage();
    }

    public RoomPage() {
        cp = super.getContentPane();
        cp.setLayout(new BorderLayout());

        setTitle("ROOM CATALOGUE");
        setSize(700, 550);
        setLocation(360,140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        infoPanel();
        roomDisp();
        actionPanel();
        setVisible(true);

        cp.setBackground(new Color(247, 248, 223));
    }
    public void infoPanel(){
        pnl2 = new JPanel(new BorderLayout());
        pnl3 = new JPanel(new FlowLayout());
        pnl4 = new JPanel(new GridLayout(2,1));

        lbl1 = new JLabel("HOTEL ZZZ", JLabel.CENTER);
        lbl2 = new JLabel("ROOM CATALOG", JLabel.CENTER);
        logo = new JLabel(new ImageIcon("logoHotel.jpg"));

        pnl3.add(logo);
        pnl4.add(lbl1);
        pnl4.add(lbl2);
        pnl2.add(pnl3,BorderLayout.NORTH);
        pnl2.add(pnl4,BorderLayout.SOUTH);
        cp.add(pnl2, BorderLayout.NORTH);

        fontColor(lbl1);
        fontColor(lbl2);
        lbl1.setFont(new Font("Kristen ITC", Font.BOLD, 25));
        lbl2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        pnl2.setBackground(new Color(247, 248, 223));
        pnl3.setBackground(new Color(247, 248, 223));
        pnl4.setBackground(new Color(247, 248, 223));
    }
    public void roomDisp(){
        pnl5 = new JPanel(new BorderLayout());
        rc = new JPanel(new GridLayout(2,1));
        pic = new JPanel(new GridLayout(1,3));
        desc = new JPanel(new GridLayout(3,3));

        lbl3 = new JLabel("   CHOOSE YOUR IDEAL ROOM !");
        room1 = new JLabel(new ImageIcon("twin.jpg"));
        room2 = new JLabel(new ImageIcon("queen.jpg"));
        room3 = new JLabel(new ImageIcon("family.jpg"));
        lbl4 = new JLabel("STANDARD TWIN", JLabel.CENTER);
        lbl5 = new JLabel("STANDARD QUEEN", JLabel.CENTER);
        lbl6 = new JLabel("FAMILY ROOM", JLabel.CENTER);
        lbl7 = new JLabel("RM200/NIGHT", JLabel.CENTER);
        lbl8 = new JLabel("RM250/NIGHT", JLabel.CENTER);
        lbl9 = new JLabel("RM650/NIGHT", JLabel.CENTER);
        lbl10 = new JLabel("2 single beds for 2 adults", JLabel.CENTER);
        lbl11 = new JLabel("1 queen bed for 2 adults", JLabel.CENTER);
        lbl12 = new JLabel("3 queen bed for 6 adults", JLabel.CENTER);

        pic.add(room1);
        pic.add(room2);
        pic.add(room3);
        desc.add(lbl4);
        desc.add(lbl5);
        desc.add(lbl6);
        desc.add(lbl7);
        desc.add(lbl8);
        desc.add(lbl9);
        desc.add(lbl10);
        desc.add(lbl11);
        desc.add(lbl12);
        rc.add(pic);
        rc.add(desc);
        pnl5.add(lbl3, BorderLayout.NORTH);
        pnl5.add(rc, BorderLayout.CENTER);
        cp.add(pnl5, BorderLayout.CENTER);

        fontColor(lbl3);
        fontColor(lbl4);
        fontColor(lbl5);
        fontColor(lbl6);
        fontColor(lbl7);
        fontColor(lbl8);
        fontColor(lbl9);
        fontColor(lbl10);
        fontColor(lbl11);
        fontColor(lbl12);

        pnl5.setBackground(new Color(247, 248, 223));
        rc.setBackground(new Color(247, 248, 223));
        desc.setBackground(new Color(247, 248, 223));
        pic.setBackground(new Color(247, 248, 223));
    }

    public void actionPanel(){
        pnl6 = new JPanel(new FlowLayout());
        bt1 = new JButton("START ORDER");
        bt2 = new JButton("LOGOUT");

        pnl6.add(bt1);
        pnl6.add(bt2);
        cp.add(pnl6, BorderLayout.SOUTH);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        pnl6.setBackground(new Color(247, 248, 223));
        bt1.setBackground(new Color(247, 248, 223));
        bt2.setBackground(new Color(247, 248, 223));
        bt1.setForeground(new Color(13, 32, 110));
        bt2.setForeground(new Color(13, 32, 110));
    }

    public void fontColor(JLabel v){
        v.setForeground(new Color(13, 32, 110));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1){
            setVisible(false);
            new ReservationPage().setVisible(true);
        }
        else if (e.getSource() == bt2) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }
}