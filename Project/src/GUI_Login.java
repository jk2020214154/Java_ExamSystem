import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Dec 09 12:01:53 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Login extends JFrame {

    public static int GUIflag=0;
    public static String username;
    public GUI_Login() {
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        if(GUIflag==0)
            new GUI_Register(this).setVisible(true);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(GUIflag==0) {
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        username = textField1.getText().toString();
        if (!radioButton1.isSelected() && !radioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "登录端未选择,请选择登录端！", "警告", JOptionPane.ERROR_MESSAGE);
        } else {

            this.dispose();
            if (radioButton1.isSelected() && !radioButton2.isSelected()) {
                new GUI_Teacher().setVisible(true);
            } else if (!radioButton1.isSelected() && radioButton2.isSelected()) {
                new GUI_Student().setVisible(true);
            }
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        if(GUIflag==0)
            new GUI_Help(this).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label4 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/favicon.gif")).getImage());
        setTitle("\u5728\u7ebf\u8003\u8bd5\u7cfb\u7edf\u767b\u5f55\u754c\u9762");
        setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text"));
        label2.setMaximumSize(new Dimension(51, 14));
        label2.setPreferredSize(new Dimension(51, 14));
        label2.setFont(new Font("sansserif", Font.BOLD, 14));
        label2.setForeground(Color.blue);
        contentPane.add(label2);
        label2.setBounds(125, 130, 65, 28);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text"));
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        label3.setForeground(Color.blue);
        contentPane.add(label3);
        label3.setBounds(135, 170, 57, 28);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(195, 130, 165, textField1.getPreferredSize().height);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(passwordField1);
        passwordField1.setBounds(195, 170, 165, passwordField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(155, 80, 200, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(145, 250, 90, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(260, 250, 90, 26);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(380, 300, 90, 26);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(380, 330, 90, 26);

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("radioButton1.text"));
        contentPane.add(radioButton1);
        radioButton1.setBounds(210, 210, radioButton1.getPreferredSize().width, 26);

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("radioButton2.text"));
        contentPane.add(radioButton2);
        radioButton2.setBounds(290, 210, radioButton2.getPreferredSize().width, 26);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));
        label4.setMaximumSize(new Dimension(51, 14));
        label4.setPreferredSize(new Dimension(51, 14));
        label4.setFont(new Font("sansserif", Font.BOLD, 14));
        label4.setForeground(Color.blue);
        contentPane.add(label4);
        label4.setBounds(125, 210, 65, 26);

        contentPane.setPreferredSize(new Dimension(400, 320));
        setSize(500, 400);
        setLocationRelativeTo(null);

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
