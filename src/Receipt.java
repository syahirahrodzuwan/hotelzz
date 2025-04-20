import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Receipt extends JFrame implements ActionListener {
    Container cp;
    JTextArea t1;
    JLabel l1,logo;
    JPanel p1,p2;
    JButton b1,b2;
    Scanner sc, sc2, sc3;
    String cusName, cusId, cusNumber, cusEmail, finalPrice;
    String roomType[] = new String[5];
    int roomQuantity[] = new int[5];
    int count = 0;

    public static void main(String[] args) {
        Receipt rpt = new Receipt();
    }
    public Receipt(){
        cp = super.getContentPane();
        cp.setLayout(new BorderLayout());

        setTitle("RECEIPT");
        setSize(720, 550);
        setLocation(300,130);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logoPanel();
        contentPanel();
        actionPanel();

        cp.setBackground(new Color(247, 248, 223));

        setVisible(true);
    }

    public void logoPanel(){
        p1 = new JPanel(new BorderLayout());
        p1.setBackground(new Color(247, 248, 223));

        l1 = new JLabel("HOTEL ZZZ", JLabel.CENTER);
        logo = new JLabel(new ImageIcon("logoHotel.jpg"));
        l1.setFont(new Font("Kristen ITC", Font.BOLD, 18));

        p1.add(l1, BorderLayout.NORTH);
        p1.add(logo, BorderLayout.CENTER);
        cp.add(p1, BorderLayout.NORTH);
    }

    public void contentPanel() {
        t1 = new JTextArea();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        t1.setBackground(new Color(247, 248, 223));
        t1.setFont(new Font("Candara", Font.BOLD, 15));
        t1.setText("\t\t=========================================\n\t\t\t          RECEIPT\n\t\t=========================================");
        t1.append("\n\t\tDATE/TIME\t   : " + date);

        try{
            sc = new Scanner(new File("Customer.txt"));
            sc2 = new Scanner(new File("Room.txt"));
            sc3 = new Scanner(new File("FinalPrice.txt"));

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String data[] = line.split(";");

                cusName = data[0];
                cusId = data[1];
                cusNumber = data[2];
                cusEmail = data[3];
            }
            while (sc2.hasNextLine()){
                count++;
                String line = sc2.nextLine();
                String data[] = line.split(";");

                for(int i = count-1; i < count; i++){
                    roomType[i] = data[0];
                    roomQuantity[i] = Integer.parseInt(data[1]);
                }
            }
            while (sc3.hasNextLine()){
                String line = sc3.nextLine();
                String data[] = line.split(";");

                finalPrice = data[0];
            }

            sc.close();
            sc2.close();
            sc3.close();
        }
        catch(Exception ee) {
            System.out.println("Error, " + ee.toString());
        }

        t1.append("\n\t\tCUSTOMER\t   : " + cusName);
        t1.append("\n\t\tID\t   : " + cusId);
        t1.append("\n\t\tCONTACT\t   : " + cusNumber);
        t1.append("\n\t\tEMAIL\t   : " + cusEmail);
        t1.append("\n\t\tROOM ORDER    : ");

        for(int i = 0; i < count; i++){
            t1.append("\n\t\t\t    " + roomType[i] + "\t" + roomQuantity[i]);
        }

        t1.append("\n\t\tTAX\t\t                         6%");
        t1.append("\n\t\t=========================================");
        t1.append("\n\t\tTOTAL\t\t               RM" + finalPrice);
        t1.append("\n\t\t=========================================");

        cp.add(t1, BorderLayout.CENTER);
    }

    public void actionPanel(){
        p2 = new JPanel(new FlowLayout());
        b1 = new JButton("NEW CUSTOMER");
        b2 = new JButton("EXIT");

        p2.add(b1);
        p2.add(b2);
        cp.add(p2, BorderLayout.SOUTH);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p2.setBackground(new Color(247, 248, 223));
        b1.setBackground(new Color(247, 248, 223));
        b2.setBackground(new Color(247, 248, 223));
        b1.setForeground(new Color(13, 32, 110));
        b2.setForeground(new Color(13, 32, 110));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            setVisible(false);
            new ReservationPage().setVisible(true);
        }
        else if (e.getSource() == b2) {
            setVisible(false);
            new RoomPage().setVisible(true);
        }
    }
}