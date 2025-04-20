import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;

public class ReservationPage extends JFrame implements ActionListener {
    DecimalFormat df = new DecimalFormat(".###");
    Container cp;
    String qty [] = {"", "1","2","3"};
    JLabel l1,l2,logo,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5;
    JPanel p0,p1,p2,p3,p4,p5,p6;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JComboBox q;
    JButton b1,b2,b3,b4;
    FileWriter fw;
    PrintWriter pw;
    double roomPrice, total, tax = 0.06;

    public static void main(String[] args) {
        ReservationPage rp = new ReservationPage();
    }

    public ReservationPage (){
        cp = super.getContentPane();
        cp.setLayout(new BorderLayout());
        p5 = new JPanel(new GridLayout(2,1));

        setTitle("HOTEL ZZZ BOOKING SYSTEM");
        setSize(700, 550);
        setLocation(360,140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        clearFile();
        infoPanel();
        customerPanel();
        roomPanel();
        actionPanel();

        cp.setBackground(new Color(247, 248, 223));

        setVisible(true);
    }

    public void infoPanel(){
        p6 = new JPanel(new BorderLayout());
        p0 = new JPanel(new FlowLayout());
        p1 = new JPanel(new GridLayout(2,1));

        l1 = new JLabel("HOTEL ZZZ", JLabel.CENTER);
        l2 = new JLabel("RESERVATION PAGE", JLabel.CENTER);
        logo = new JLabel(new ImageIcon("logoHotel.jpg"));

        p0.add(logo);
        p1.add(l1);
        p1.add(l2);
        p6.add(p0,BorderLayout.NORTH);
        p6.add(p1,BorderLayout.SOUTH);
        cp.add(p6, BorderLayout.NORTH);

        bgColor(p6);
        bgColor(p0);
        bgColor(p1);
        fontColor(l1);
        fontColor(l2);
        l1.setFont(new Font("Kristen ITC", Font.BOLD, 25));
        l2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
    }

    public void customerPanel(){
        p2 = new JPanel(new GridLayout(2,1));
        JPanel pCont1 = new JPanel(new BorderLayout());
        JPanel pLabel = new JPanel(new GridLayout(4,1));
        JPanel pTF = new JPanel(new GridLayout(4,1));

        l3 = new JLabel("  CUSTOMER'S INFORMATION");
        l4 = new JLabel("  NAME :");
        l5 = new JLabel("  ID : ");
        l6 = new JLabel("  NUMBER : ");
        l7 = new JLabel("  EMAIL :");
        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);

        p2.add(l3);
        pLabel.add(l4);
        pLabel.add(l5);
        pLabel.add(l6);
        pLabel.add(l7);
        pTF.add(t1);
        pTF.add(t2);
        pTF.add(t3);
        pTF.add(t4);
        pCont1.add(pLabel,BorderLayout.WEST);
        pCont1.add(pTF,BorderLayout.CENTER);
        p2.add(pCont1);
        p5.add(p2);

        bgColor(p2);
        bgColor(pCont1);
        bgColor(pTF);
        bgColor(pLabel);
        fontColor(l3);
        fontColor(l4);
        fontColor(l5);
        fontColor(l6);
        fontColor(l7);

        t1.setFont(new Font("LFT Etica Mono", Font.PLAIN, 12));
        t2.setFont(new Font("LFT Etica Mono", Font.PLAIN, 12));
        t3.setFont(new Font("LFT Etica Mono", Font.PLAIN, 12));
        t4.setFont(new Font("LFT Etica Mono", Font.PLAIN, 12));
    }

    public void roomPanel(){
        p3 = new JPanel(new GridLayout(3,1));
        bg = new ButtonGroup();
        q = new JComboBox(qty);
        JPanel emp = new JPanel();
        JPanel pCont2 = new JPanel(new GridLayout(2,4));
        JPanel pCont3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        l8 = new JLabel("  ROOM'S INFORMATION");
        l9 = new JLabel("  ROOM TYPE : ");
        l10 = new JLabel("  QUANTITY : ");
        l11 = new JLabel("TOTAL : RM");
        r1 = new JRadioButton("STANDARD TWIN");
        r2 = new JRadioButton("STANDARD QUEEN");
        r3 = new JRadioButton("FAMILY ROOM");
        b4 = new JButton("ADD ROOM");
        t5 = new JTextField(10);

        this.r1.setActionCommand("STANDARD TWIN");
        this.r2.setActionCommand("STANDARD QUEEN");
        this.r3.setActionCommand("FAMILY ROOM");
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        pCont2.add(l9);
        pCont2.add(r1);
        pCont2.add(r2);
        pCont2.add(r3);
        pCont2.add(l10);
        pCont2.add(q);
        pCont2.add(emp);
        pCont2.add(b4);
        pCont3.add(l11);
        pCont3.add(t5);

        p3.add(l8);
        p3.add(pCont2);
        p3.add(pCont3);
        p5.add(p3);
        cp.add(p5, BorderLayout.CENTER);

        b4.addActionListener(this);

        bgColor(p5);
        bgColor(p3);
        bgColor(pCont2);
        bgColor(pCont3);
        bgColor(emp);
        fontColor(l8);
        fontColor(l9);
        fontColor(l10);
        fontColor(l11);
        q.setBackground(new Color(247, 248, 223));
        r1.setBackground(new Color(247, 248, 223));
        r2.setBackground(new Color(247, 248, 223));
        r3.setBackground(new Color(247, 248, 223));
        b4.setBackground(new Color(247, 248, 223));
        r1.setForeground(new Color(13, 32, 110));
        r2.setForeground(new Color(13, 32, 110));
        r3.setForeground(new Color(13, 32, 110));
        b4.setForeground(new Color(13, 32, 110));
        t5.setFont(new Font("LFT Etica Mono", Font.PLAIN, 12));
    }

    public void actionPanel(){
        p4 = new JPanel(new FlowLayout());

        b1 = new JButton("RESET");
        b2 = new JButton("SUBMIT");
        b3 = new JButton("EXIT");

        p4.add(b1);
        p4.add(b2);
        p4.add(b3);
        cp.add(p4,BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        bgColor(p4);
        b1.setBackground(new Color(247, 248, 223));
        b2.setBackground(new Color(247, 248, 223));
        b3.setBackground(new Color(247, 248, 223));
        b1.setForeground(new Color(13, 32, 110));
        b2.setForeground(new Color(13, 32, 110));
        b3.setForeground(new Color(13, 32, 110));
    }

    public void clearFile(){
        try{
            fw = new FileWriter("Room.txt", false);
            pw = new PrintWriter(fw,false);
            pw.flush();
            pw.close();
            fw.close();
        }
        catch (Exception e){
            System.out.println("Exception" + e.toString());
        }
    }

    public void bgColor(JPanel u){
        u.setBackground(new Color(247, 248, 223));
    }

    public void fontColor(JLabel v){
        v.setForeground(new Color(13, 32, 110));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            JOptionPane.showConfirmDialog(null,"Reset all info ?");
            int ch1 = JOptionPane.YES_OPTION;

            if (ch1 == 1){
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                bg.clearSelection();
                q.setSelectedIndex(0);
            }

        }

        else if (e.getSource() == b2){
            try {
                pw = new PrintWriter("Customer.txt");

                pw.println(t1.getText() + ";" + t2.getText() + ";" + t3.getText() + ";" + t4.getText() + ";" + t5.getText());
                pw.close();
            }
            catch(IOException ioe) {
                System.out.println("File not found, " + ioe.toString());
            }
            catch(Exception ee) {
                System.out.println("Error, " + e.toString());
            }

            JOptionPane.showMessageDialog(null,"RESERVATION SUCCESS !!");
            setVisible(false);
            new Receipt().setVisible(true);
        }

        else if (e.getSource() == b3){
            setVisible(false);
            new RoomPage().setVisible(true);
        }

        if (e.getSource() == b4){
            try{
                fw = new FileWriter("Room.txt",true);
                pw = new PrintWriter("FinalPrice.txt");
                String roomType = this.bg.getSelection().getActionCommand();
                String quantity = (String)q.getSelectedItem();

                if(roomType.equals("STANDARD TWIN"))
                    roomPrice = 200.00 * (Double.parseDouble(quantity));
                else if(roomType.equals("STANDARD QUEEN"))
                    roomPrice = 250.00 * (Double.parseDouble(quantity));
                else if (roomType.equals("FAMILY ROOM"))
                    roomPrice = 650.00 * (Double.parseDouble(quantity));

                total = total + roomPrice;
                df.format(total);

                t5.setText(String.valueOf(total));

                fw.write(roomType + ';' + quantity +"\n");
                pw.println(total + (total*tax));
                bg.clearSelection();
                q.setSelectedIndex(0);

                fw.close();
                pw.close();
            }
            catch(IOException ioe) {
                System.out.println("File not found, " + ioe.toString());
            }
            catch(Exception ee) {
                System.out.println("Error, " + e.toString());
            }
        }
    }
}