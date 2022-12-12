import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 13:32:33 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Teacher extends JFrame {
    public static int GUI_Teacherflag=0;
    public GUI_Teacher() {
        initComponents();
        textField2.setText(" "+GUI_Login.username);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Date date = new Date();
                    textField1.setText(" "+date.toString());
                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            }
        });

    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaJudge(this).setVisible(true);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        if (GUI_Teacherflag == 0) {
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }



    private void menuItem4(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaHelp(this).setVisible(true);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaSelect(this).setVisible(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaQuestion(this).setVisible(true);
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaHelp(this).setVisible(true);
    }

    private void menuItem1(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaSelect(this).setVisible(true);
    }

    private void menuItem2(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaJudge(this).setVisible(true);
    }

    private void menuItem3(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0)
            new GUI_TeaQuestion(this).setVisible(true);
    }

    private void menuItem5(ActionEvent e) {
        // TODO add your code here
        if(GUI_Teacherflag==0) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "教师端注销登录成功！", "注销登录", JOptionPane.PLAIN_MESSAGE);
            new GUI_Login().setVisible(true);
        }
    }

    private void menuItem6(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }


    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem6 = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        setTitle("\u5728\u7ebf\u8003\u8bd5\u7cfb\u7edf\u6559\u5e08\u7aef");
        setIconImage(new ImageIcon(getClass().getResource("/favicon.gif")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text"));

                //---- menuItem1 ----
                menuItem1.setText(bundle.getString("menuItem1.text"));
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText(bundle.getString("menuItem2.text"));
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText(bundle.getString("menuItem3.text"));
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText(bundle.getString("menu2.text"));

                //---- menuItem5 ----
                menuItem5.setText(bundle.getString("menuItem5.text"));
                menuItem5.addActionListener(e -> menuItem5(e));
                menu2.add(menuItem5);

                //---- menuItem4 ----
                menuItem4.setText(bundle.getString("menuItem4.text"));
                menuItem4.addActionListener(e -> menuItem4(e));
                menu2.add(menuItem4);

                //---- menuItem6 ----
                menuItem6.setText(bundle.getString("menuItem6.text_2"));
                menuItem6.addActionListener(e -> menuItem6(e));
                menu2.add(menuItem6);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_3"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(143, 21, 275, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_2"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.black);
        contentPane.add(label2);
        label2.setBounds(120, 125, 95, 30);

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setBackground(Color.lightGray);
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.white);
        contentPane.add(textField1);
        textField1.setBounds(205, 125, 220, 30);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        button1.setFont(new Font("sansserif", Font.BOLD, 16));
        button1.setForeground(Color.blue);
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(125, 67, 85, 40);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.setFont(new Font("sansserif", Font.BOLD, 16));
        button2.setForeground(Color.blue);
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(225, 67, 85, 40);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_3"));
        button3.setFont(new Font("sansserif", Font.BOLD, 16));
        button3.setForeground(Color.blue);
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(330, 67, 85, 40);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_3"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(430, 205, 100, 26);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text"));
        button5.addActionListener(e -> button5(e));
        contentPane.add(button5);
        button5.setBounds(430, 175, 100, 26);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_2"));
        label3.setBackground(new Color(0x99ff99));
        label3.setForeground(Color.red);
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(20, 192, label3.getPreferredSize().width, 26);

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setBackground(Color.lightGray);
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField2);
        textField2.setBounds(125, 192, 105, textField2.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(550, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem5;
    private JMenuItem menuItem4;
    private JMenuItem menuItem6;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
