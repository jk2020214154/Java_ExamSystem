import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 16:11:48 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Student extends JFrame {
    public static int GUI_Studentflag=0;
    public static int visited[]=new int[3];
    public static int score[]=new int[3];
    public GUI_Student() {
        initComponents();
        textField2.setText(GUI_Login.username);
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

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuSelect(this).setVisible(true);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuJudge(this).setVisible(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuQuestion(this).setVisible(true);
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0) {
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    private void menuItem9(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0) {
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }
    private void menuItem8(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "学生端注销登录成功！", "注销登录", JOptionPane.PLAIN_MESSAGE);
            new GUI_Login().setVisible(true);
        }
    }

    private void menuItem1(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuSelect(this).setVisible(true);
    }

    private void menuItem2(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuJudge(this).setVisible(true);
    }

    private void menuItem3(ActionEvent e) {
        // TODO add your code here
        if(GUI_Studentflag==0)
            new GUI_StuQuestion(this).setVisible(true);
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
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu3 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menuItem9 = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        button6 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_6"));
        setIconImage(new ImageIcon(getClass().getResource("/favicon.gif")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text_2"));

                //---- menuItem1 ----
                menuItem1.setText(bundle.getString("menuItem1.text_2"));
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText(bundle.getString("menuItem2.text_2"));
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText(bundle.getString("menuItem3.text_2"));
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText(bundle.getString("menu2.text_2"));

                //---- menuItem4 ----
                menuItem4.setText(bundle.getString("menuItem4.text_2"));
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText(bundle.getString("menuItem5.text_2"));
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText(bundle.getString("menuItem6.text"));
                menu2.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText(bundle.getString("menuItem7.text"));
                menu2.add(menuItem7);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText(bundle.getString("menu3.text"));

                //---- menuItem8 ----
                menuItem8.setText(bundle.getString("menuItem8.text"));
                menuItem8.addActionListener(e -> menuItem8(e));
                menu3.add(menuItem8);

                //---- menuItem10 ----
                menuItem10.setText(bundle.getString("menuItem10.text"));
                menu3.add(menuItem10);

                //---- menuItem9 ----
                menuItem9.setText(bundle.getString("menuItem9.text"));
                menuItem9.addActionListener(e -> menuItem9(e));
                menu3.add(menuItem9);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_9"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(150, 25, 275, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_3"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.black);
        contentPane.add(label2);
        label2.setBounds(126, 137, 95, 30);

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setBackground(Color.lightGray);
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.white);
        contentPane.add(textField1);
        textField1.setBounds(211, 137, 215, 30);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_5"));
        button1.setFont(new Font("sansserif", Font.BOLD, 16));
        button1.setForeground(Color.blue);
        button1.addActionListener(e -> {
			button1(e);
			button1(e);
		});
        contentPane.add(button1);
        button1.setBounds(135, 75, 85, 40);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
        button2.setFont(new Font("sansserif", Font.BOLD, 16));
        button2.setForeground(Color.blue);
        button2.addActionListener(e -> {
			button2(e);
			button2(e);
		});
        contentPane.add(button2);
        button2.setBounds(235, 75, 85, 40);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_4"));
        button3.setFont(new Font("sansserif", Font.BOLD, 16));
        button3.setForeground(Color.blue);
        button3.addActionListener(e -> {
			button3(e);
			button3(e);
		});
        contentPane.add(button3);
        button3.setBounds(340, 75, 85, 40);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text_2"));
        button5.addActionListener(e -> button5(e));
        contentPane.add(button5);
        button5.setBounds(441, 174, 100, button5.getPreferredSize().height);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_4"));
        button4.addActionListener(e -> {
			button4(e);
			button4(e);
		});
        contentPane.add(button4);
        button4.setBounds(441, 204, 100, button4.getPreferredSize().height);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_3"));
        label3.setBackground(new Color(0x99ff99));
        label3.setForeground(Color.red);
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(15, 196, label3.getPreferredSize().width, 26);

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setBackground(Color.lightGray);
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField2);
        textField2.setBounds(120, 196, 105, 27);

        //---- button6 ----
        button6.setText(bundle.getString("button6.text"));
        button6.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(button6);
        button6.setBounds(441, 110, 100, 35);

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
        setSize(562, 300);
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
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu3;
    private JMenuItem menuItem8;
    private JMenuItem menuItem10;
    private JMenuItem menuItem9;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button4;
    private JLabel label3;
    private JTextField textField2;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
