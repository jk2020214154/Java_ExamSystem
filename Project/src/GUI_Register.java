import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 13:14:50 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Register extends JDialog {

    public ButtonGroup buttonGroup2 = new ButtonGroup();
    public GUI_Register(Window owner) {
        super(owner);
        GUI_Login.GUIflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Login.GUIflag=0;
            }
        });
        initComponents();

    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Login.GUIflag=0;
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        String username = textField2.getText();
        String password = String.valueOf(passwordField3.getPassword());
        int selectport=0;
        if (radioButton3.isSelected() && !radioButton4.isSelected())
            selectport=1;//教师端
        else if(!radioButton3.isSelected() && radioButton4.isSelected())
            selectport=2;//学生端

        if(selectport==0) {
            JOptionPane.showMessageDialog(null, "未选择身份,请选择身份！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try{
                File file=new File("E:\\大学\\专业课\\3.1Java\\用户数据.txt");
                if(file.createNewFile()){
                    System.out.println("用户登录数据加载成功！");
                }
                else{
                    System.out.println("当前登录文件已存在");
                }
                FileReader fReader=new FileReader("E:\\大学\\专业课\\3.1Java\\用户数据.txt");
                BufferedReader fBufferedReader = new BufferedReader(fReader);
                String lineString;
                System.out.println(username+"|"+password+"|");
                int searchflag = 0;
                if((username!=null&&!username.trim().equals(""))&&(password!=null&&!password.trim().equals(""))) {
                    while ((lineString = fBufferedReader.readLine()) != null) {
                        System.out.println(lineString);
                        Scanner cin = new Scanner(lineString);
                        if(cin.next().equals(username)){
                            searchflag=1;
                            break;
                        }
                    }
                    fBufferedReader.close();
                    if(searchflag==1){
                        JOptionPane.showMessageDialog(null, "该用户名已存在,无法注册,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                        textField2.setText(""); passwordField3.setText("");
                        buttonGroup2.clearSelection();
                    }
                    else{
                        FileWriter fWriter=new FileWriter("E:\\大学\\专业课\\3.1Java\\用户数据.txt",true);
                        String result=username+" "+password+" "+String.valueOf(selectport);
                        BufferedWriter fBufferedWriter=new BufferedWriter(fWriter);
                        fBufferedWriter.write(result);
                        fBufferedWriter.newLine();
                        fBufferedWriter.flush();
                        fBufferedWriter.close();
                        JOptionPane.showMessageDialog(null, "该用户注册成功！", "注册用户", JOptionPane.PLAIN_MESSAGE);
                        textField2.setText("");
                        passwordField3.setText("");
                        buttonGroup2.clearSelection();
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                    textField2.setText(""); passwordField3.setText("");
                    buttonGroup2.clearSelection();
                }




            }
            catch (IOException ex){
                System.out.println(ex.toString());
            }




        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label5 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        passwordField3 = new JPasswordField();
        label7 = new JLabel();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u6ce8\u518c\u7528\u6237");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_2"));
        label5.setMaximumSize(new Dimension(51, 14));
        label5.setPreferredSize(new Dimension(51, 14));
        label5.setFont(new Font("sansserif", Font.BOLD, 14));
        label5.setForeground(Color.blue);
        contentPane.add(label5);
        label5.setBounds(80, 70, 65, 26);
        contentPane.add(textField2);
        textField2.setBounds(150, 70, 165, textField2.getPreferredSize().height);

        //---- label6 ----
        label6.setText(bundle.getString("label6.text_2"));
        label6.setFont(new Font("sansserif", Font.BOLD, 14));
        label6.setForeground(Color.blue);
        contentPane.add(label6);
        label6.setBounds(90, 110, 57, 26);
        contentPane.add(passwordField3);
        passwordField3.setBounds(150, 110, 165, passwordField3.getPreferredSize().height);

        //---- label7 ----
        label7.setText(bundle.getString("label7.text_2"));
        label7.setMaximumSize(new Dimension(51, 14));
        label7.setPreferredSize(new Dimension(51, 14));
        label7.setFont(new Font("sansserif", Font.BOLD, 14));
        label7.setForeground(Color.blue);
        contentPane.add(label7);
        label7.setBounds(93, 149, 60, 26);

        //---- radioButton3 ----
        radioButton3.setText(bundle.getString("radioButton3.text_2"));
        contentPane.add(radioButton3);
        radioButton3.setBounds(165, 150, radioButton3.getPreferredSize().width, 26);

        //---- radioButton4 ----
        radioButton4.setText(bundle.getString("radioButton4.text_2"));
        contentPane.add(radioButton4);
        radioButton4.setBounds(245, 150, radioButton4.getPreferredSize().width, 26);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(100, 195, 90, button3.getPreferredSize().height);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_2"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(215, 195, 90, button4.getPreferredSize().height);

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
        setSize(400, 300);
        setLocationRelativeTo(null);

        //---- buttonGroup2 ----
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(radioButton3);
        buttonGroup2.add(radioButton4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JPasswordField passwordField3;
    private JLabel label7;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
