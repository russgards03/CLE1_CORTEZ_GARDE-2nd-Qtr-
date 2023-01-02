import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Main extends Compute{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Forever Gems");
        ImageIcon icon = null;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLogo = new JPanel(new FlowLayout());
        JPanel panelTitle = new JPanel(new FlowLayout());
        JPanel panelOne = new JPanel(new GridLayout(3, 2, 1, 1));
        JPanel panelTwo = new JPanel(new FlowLayout());
        JButton button = new JButton("Check Out");

        JButton button1 = new JButton("Price Details");

        JPanel panelThree = new JPanel(new FlowLayout());
        panelThree.setBackground(new Color(0,0,0,0));
        panelThree.setBounds(380, 300, 90, 50);
        //Price Details

        panelLogo.setBounds(125, 20, 250, 50);
        panelTitle.setBounds(125, 70, 250, 50);
        panelOne.setBounds(5, 130, 485, 100);
        panelTwo.setBounds(60, 250, 380, 40);

        java.net.URL imgURL = Main.class.getResource("pearl.png");
        if (imgURL != null) {
            icon = new ImageIcon(imgURL);
            frame.setIconImage(icon.getImage());
        } else {
            JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }


        panelLogo.setBackground(new Color(241, 239, 239, 255));
        panelTitle.setBackground(new Color(241, 239, 239, 255));
        panelOne.setBackground(new Color(221, 221, 239, 255));
        panelTwo.setBackground(new Color(241, 239, 239, 255));

        JLabel labelLogo, labelOne, labelTwo, labelThree, labelTitle;

        labelLogo = new JLabel("FOREVER GEMS", JLabel.CENTER);
        labelTitle = new JLabel("Jewelry Accessory Calculator", JLabel.CENTER);
        labelOne = new JLabel(" Accessory Type: ");
        labelTwo = new JLabel(" Material: ");
        labelThree = new JLabel(" Type of Service: ");

        labelLogo.setFont(new Font("Serif", Font.ITALIC, 20));
        labelOne.setFont(new Font("Serif", Font.PLAIN, 20));
        labelTwo.setFont(new Font("Serif", Font.PLAIN, 20));
        labelThree.setFont(new Font("Serif", Font.PLAIN, 20));

        String[] JewelType = {"Necklace", "Earrings", "Cuff links", "Bracelet", "Ring"};
        final JComboBox box1 = new JComboBox(JewelType);
        box1.setBounds(100,140,20,25);

        String[] Material1 = {"Gold", "Silver"};
        final JComboBox box2 = new JComboBox(Material1);
        box2.setBounds(100,140,80,25);

        String[] Service = {"Wholesale", "Retail"};
        final JComboBox box3 = new JComboBox(Service);
        box2.setBounds(100,140,80,25);

        labelTitle.setForeground(Color.BLACK);

        labelLogo.setBounds(10,10,90,20);
        labelTitle.setBounds(10,10,90,20);
        labelOne.setBounds(10,10,80,20);
        labelTwo.setBounds(10,10,80,20);

        box1.setFont(new Font("Serif", Font.ITALIC, 20));
        box2.setFont(new Font("Serif", Font.ITALIC, 20));
        box3.setFont(new Font("Serif", Font.ITALIC, 20));

        panelLogo.add(labelLogo);
        panelTitle.add(labelTitle);

        panelOne.add(labelOne);
        panelOne.add(box1);
        panelOne.add(labelTwo);
        panelOne.add(box2);
        panelOne.add(labelThree);
        panelOne.add(box3);

        button.setBounds(10,10,90,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = PriceComputation((String) box1.getSelectedItem(),(String) box2.getSelectedItem(),(String) box3.getSelectedItem());
                displayResult(String.valueOf(result));

            }
        });

        button1.setBounds(0,0,10,40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                JOptionPane.showMessageDialog( null, "Jewelry Prices:\n\nAccessory base prices:\nNecklace: 900\nEarrings: 675\nCuff links: 350\nBracelet: 490\nRing: 595 ","Price Information" , JOptionPane.INFORMATION_MESSAGE );
            }
        });

        panelTwo.add(button);

        panelThree.add(button1);

        frame.add(panelLogo);
        frame.add(panelTitle);
        frame.add(panelOne);
        frame.add(panelTwo);
        frame.add(panelThree);
        frame.setSize(510,410);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

abstract class Methods {
    public void displayResult(){
        System.out.println("Your Total Price:");
    }
}
class Compute extends Methods{
    public static int PriceComputation(String value1, String value2, String value3){

        String[] box1 ={"Necklace", "Earrings", "Cuff links", "Bracelet", "Ring"};
        String[] box2 ={"Gold", "Silver"};
        String[] box3 ={"Wholesale", "Retail"};

        int[] box1price ={900, 675, 350, 490, 595};
        int[] box2price ={3, 2};
        int[] box3price ={(int) 2.4, (int) 3.2};

        int labor = 200;
        int price1, price2, price3;

        String jewelryType = value1;
        String mainMaterial = value2;
        String service = value3;

        ///if else
        if (jewelryType==box1[0]){
            price1 = box1price[0];
        }
        else if (jewelryType==box1[1]){
            price1 = box1price[1];
        }
        else if (jewelryType==box1[2]){
            price1 = box1price[2];
        }
        else{
            price1 = box1price[3];
        }

        if (mainMaterial==box2[0]){
            price2 = box2price[0];
        }
        else{
            price2 = box2price[1];
        }

        if (service==box3[0]){
            price3 = box3price[0];
        }
        else if (service==box3[1]){
            price3 = box3price[1];
        }
        else{
            price3 = box3price[2];
        }
        ///if else
        int profit = (price1 * price2 * price3);
        int itemprice = (profit) + labor ;
        return itemprice;
    }
    public static void displayResult(String itemprice){
        int fprice = Integer.parseInt(itemprice);

        ImageIcon Gems = new ImageIcon("pearl.png");
        JOptionPane.showMessageDialog( null, "Item Price: Php " + fprice, "Total" , JOptionPane.INFORMATION_MESSAGE, Gems);
    }
}
