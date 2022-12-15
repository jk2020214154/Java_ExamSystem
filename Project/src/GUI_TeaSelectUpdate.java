import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 18:41:15 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaSelectUpdate extends JDialog {

    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaSelectUpdate(Window owner) {
        super(owner);
        GUI_TeaSelect.GUI_TeaSelectflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaSelect.GUI_TeaSelectflag=0;
            }
        });
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaSelect.GUI_TeaSelectflag=0;
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String temp=textField1.getText();
        if ((temp != null && !temp.trim().equals(""))){
            if(Main.isNumeric(temp))
            {
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    System.out.println("数据库驱动已成功启动!");
                }
                catch (Exception ex){
                    System.out.println(ex.toString());
                }
                try {
                    con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
                    System.out.println("数据库已成功连接!");
                    String sql = "select * from 选择题 where id=?";
                    int cnt=0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset=preparedstatement.executeQuery();
                    SelectProblem selected=new SelectProblem();
                    while(resultset.next())
                    {
                        cnt++;
                        selected.setId(resultset.getInt("id"));
                        selected.setDescription(resultset.getString("描述"));
                        selected.setSelect_A(resultset.getString("A"));
                        selected.setSelect_B(resultset.getString("B"));
                        selected.setSelect_C(resultset.getString("C"));
                        selected.setSelect_D(resultset.getString("D"));
                        selected.setAnswer(resultset.getString("答案"));
                    }
                    if(cnt==0)
                    {
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");textField2.setText("");
                        textArea1.setText("");textArea2.setText("");textArea3.setText("");textArea4.setText("");textArea5.setText("");
                    }
                    else{
                        textField2.setText(selected.getAnswer());
                        textArea1.setText(selected.getDescription());textArea2.setText(selected.getSelect_A());textArea3.setText(selected.getSelect_B());
                        textArea4.setText(selected.getSelect_C());textArea5.setText(selected.getSelect_D());
                        JOptionPane.showMessageDialog(null, "同步原数据成功!", "选择题修改记录", JOptionPane.PLAIN_MESSAGE);
                    }
                    con.close();
                    System.out.println("数据库已关闭!");
                }
                catch (SQLException eve) {
                    System.out.println(eve);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "原序号应为数字,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");textField2.setText("");
                textArea1.setText("");textArea2.setText("");textArea3.setText("");textArea4.setText("");textArea5.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField1.setText("");textField2.setText("");
            textArea1.setText("");textArea2.setText("");textArea3.setText("");textArea4.setText("");textArea5.setText("");
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        int flag[] = new int[8], flagg = 0;
        String temp = textField4.getText();
        if ((temp != null && !temp.trim().equals(""))) {
            if (Main.isNumeric(temp)) {
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    System.out.println("数据库驱动已成功启动!");
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
                try {
                    con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
                    System.out.println("数据库已成功连接!");
                    String sql = "select * from 选择题 where id=?";
                    int cnt = 0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset = preparedstatement.executeQuery();
                    SelectProblem selected = new SelectProblem();
                    while (resultset.next()) {
                        cnt++;
                        selected.setId(resultset.getInt("id"));
                        selected.setDescription(resultset.getString("描述"));
                        selected.setSelect_A(resultset.getString("A"));
                        selected.setSelect_B(resultset.getString("B"));
                        selected.setSelect_C(resultset.getString("C"));
                        selected.setSelect_D(resultset.getString("D"));
                        selected.setAnswer(resultset.getString("答案"));
                    }
                    con.close();
                    System.out.println("数据库已关闭!");
                    if (cnt == 1 && !temp.equals(textField1.getText())) {
                        flagg = -1;
                        JOptionPane.showMessageDialog(null, "该新序号已在数据库中存在，请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField4.setText("");
                        textField3.setText("");
                        textArea6.setText("");
                        textArea7.setText("");
                        textArea8.setText("");
                        textArea9.setText("");
                        textArea10.setText("");
                    } else if (!temp.equals(textField1.getText())) {
                        flag[1] = 1;
                        flagg++;
                    }
                } catch (SQLException eve) {
                    System.out.println(eve);
                }
            } else {
                flagg = -1;
                JOptionPane.showMessageDialog(null, "新序号应为数字,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                textField4.setText("");
                textField3.setText("");
                textArea6.setText("");
                textArea7.setText("");
                textArea8.setText("");
                textArea9.setText("");
                textArea10.setText("");
            }
        }
        if (flagg >= 0) {
            temp = textField3.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (temp.equals("A") || temp.equals("B") || temp.equals("C") || temp.equals("D")) {
                    if (!temp.equals(textField2.getText())) {
                        flagg++;
                        flag[7] = 1;
                    }
                } else {
                    flagg = -1;
                    JOptionPane.showMessageDialog(null, "新选项应为A,B,C,D四项中的一个,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                    textField4.setText("");
                    textField3.setText("");
                    textArea6.setText("");
                    textArea7.setText("");
                    textArea8.setText("");
                    textArea9.setText("");
                    textArea10.setText("");
                }
            }
        }
        if (flagg >= 0) {
            temp = textArea6.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea1.getText())) {
                    flagg++;
                    flag[2] = 1;
                }
            }
            temp = textArea7.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea2.getText())) {
                    flagg++;
                    flag[3] = 1;
                }
            }
            temp = textArea8.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea3.getText())) {
                    flagg++;
                    flag[4] = 1;
                }
            }
            temp = textArea9.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea4.getText())) {
                    flagg++;
                    flag[5] = 1;
                }
            }
            temp = textArea10.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea5.getText())) {
                    flagg++;
                    flag[6] = 1;
                }
            }
        }
        if (flagg > 0) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                System.out.println("数据库驱动已成功启动!");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            try {
                con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
                System.out.println("数据库已成功连接!");
                for (int i = 1; i <= 7; i++) {
                    if (flag[i] == 1) {
                        if (i == 1) {
                            String sql = "update 选择题 set id=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setInt(1, Integer.valueOf(textField4.getText()));
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textField1.setText(textField4.getText());
                            textField4.setText("");
                        } else if (i == 2) {
                            String sql = "update 选择题 set 描述=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea6.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea1.setText(textArea6.getText());
                            textArea6.setText("");
                        } else if (i == 3) {
                            String sql = "update 选择题 set A=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea7.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea2.setText(textArea7.getText());
                            textArea7.setText("");
                        } else if (i == 4) {
                            String sql = "update 选择题 set B=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea8.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea3.setText(textArea8.getText());
                            textArea8.setText("");
                        } else if (i == 5) {
                            String sql = "update 选择题 set C=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea9.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea4.setText(textArea9.getText());
                            textArea9.setText("");
                        } else if (i == 6) {
                            String sql = "update 选择题 set D=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea10.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea5.setText(textArea10.getText());
                            textArea10.setText("");
                        } else if (i == 7) {
                            String sql = "update 选择题 set 答案=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textField3.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textField2.setText(textField3.getText());
                            textField3.setText("");
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "修改成功!", "选择题修改记录", JOptionPane.PLAIN_MESSAGE);
                statement = con.createStatement();
                String sql1 = "select * from 选择题";
                resultset = statement.executeQuery(sql1);
                System.out.println("查询成功!");
                GUI_TeaSelect.data.clear();
                while (resultset.next()) {
                    SelectProblem tempp = new SelectProblem();
                    tempp.setId(resultset.getInt("id"));
                    tempp.setDescription(resultset.getString("描述"));
                    tempp.setSelect_A(resultset.getString("A"));
                    tempp.setSelect_B(resultset.getString("B"));
                    tempp.setSelect_C(resultset.getString("C"));
                    tempp.setSelect_D(resultset.getString("D"));
                    tempp.setAnswer(resultset.getString("答案"));
                    GUI_TeaSelect.data.add(tempp);
                }
                GUI_TeaSelect.tableinit();
                con.close();
                System.out.println("数据库已关闭!");

            } catch (SQLException eve) {
                System.out.println(eve);
            }
        } else if (flagg == 0) {
            JOptionPane.showMessageDialog(null, "当前状态不进行修改!", "选择题修改记录", JOptionPane.PLAIN_MESSAGE);
            textField4.setText("");textField3.setText("");textArea6.setText("");textArea7.setText("");textArea8.setText("");textArea9.setText("");textArea10.setText("");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        label6 = new JLabel();
        scrollPane4 = new JScrollPane();
        textArea4 = new JTextArea();
        label7 = new JLabel();
        scrollPane5 = new JScrollPane();
        textArea5 = new JTextArea();
        label8 = new JLabel();
        textField3 = new JTextField();
        label9 = new JLabel();
        label10 = new JLabel();
        scrollPane6 = new JScrollPane();
        textArea6 = new JTextArea();
        label11 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        scrollPane7 = new JScrollPane();
        textArea7 = new JTextArea();
        label12 = new JLabel();
        scrollPane8 = new JScrollPane();
        textArea8 = new JTextArea();
        label13 = new JLabel();
        scrollPane9 = new JScrollPane();
        textArea9 = new JTextArea();
        label14 = new JLabel();
        scrollPane10 = new JScrollPane();
        textArea10 = new JTextArea();
        label15 = new JLabel();
        textField4 = new JTextField();

        //======== this ========
        setTitle(bundle.getString("this.title_19"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_22"));
        label1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label1);
        label1.setBounds(10, 15, 60, 35);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(75, 15, 115, 35);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_21"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(210, 15, 100, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_11"));
        label2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label2);
        label2.setBounds(10, 55, 60, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setEditable(false);
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.blue);
            textArea1.setBackground(SystemColor.text);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(75, 55, 875, 95);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_8"));
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(10, 155, 95, 35);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setLineWrap(true);
            textArea2.setEditable(false);
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.blue);
            textArea2.setBackground(SystemColor.text);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(75, 160, 170, 80);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_5"));
        label4.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label4);
        label4.setBounds(335, 15, 60, 35);

        //---- textField2 ----
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        textField2.setEditable(false);
        textField2.setForeground(Color.blue);
        contentPane.add(textField2);
        textField2.setBounds(388, 15, 115, 35);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text"));
        label5.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label5);
        label5.setBounds(245, 155, 95, 35);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setEditable(false);
            textArea3.setLineWrap(true);
            textArea3.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea3.setForeground(Color.blue);
            textArea3.setBackground(SystemColor.text);
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(308, 160, 170, 80);

        //---- label6 ----
        label6.setText(bundle.getString("label6.text"));
        label6.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label6);
        label6.setBounds(478, 155, 95, 35);

        //======== scrollPane4 ========
        {

            //---- textArea4 ----
            textArea4.setEditable(false);
            textArea4.setLineWrap(true);
            textArea4.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea4.setForeground(Color.blue);
            textArea4.setBackground(SystemColor.text);
            scrollPane4.setViewportView(textArea4);
        }
        contentPane.add(scrollPane4);
        scrollPane4.setBounds(545, 160, 170, 80);

        //---- label7 ----
        label7.setText(bundle.getString("label7.text"));
        label7.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label7);
        label7.setBounds(718, 155, 95, 35);

        //======== scrollPane5 ========
        {

            //---- textArea5 ----
            textArea5.setEditable(false);
            textArea5.setLineWrap(true);
            textArea5.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea5.setForeground(Color.blue);
            textArea5.setBackground(SystemColor.text);
            scrollPane5.setViewportView(textArea5);
        }
        contentPane.add(scrollPane5);
        scrollPane5.setBounds(784, 160, 170, 80);

        //---- label8 ----
        label8.setText(bundle.getString("label8.text"));
        label8.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label8);
        label8.setBounds(523, 15, 60, 35);

        //---- textField3 ----
        textField3.setFont(new Font("sansserif", Font.BOLD, 14));
        textField3.setForeground(Color.magenta);
        contentPane.add(textField3);
        textField3.setBounds(577, 15, 115, 35);

        //---- label9 ----
        label9.setText(bundle.getString("label9.text"));
        label9.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label9);
        label9.setBounds(10, 260, 60, 35);

        //---- label10 ----
        label10.setText(bundle.getString("label10.text"));
        label10.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label10);
        label10.setBounds(815, 360, 190, 120);

        //======== scrollPane6 ========
        {

            //---- textArea6 ----
            textArea6.setLineWrap(true);
            textArea6.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea6.setForeground(Color.magenta);
            scrollPane6.setViewportView(textArea6);
        }
        contentPane.add(scrollPane6);
        scrollPane6.setBounds(15, 295, 320, 170);

        //---- label11 ----
        label11.setText(bundle.getString("label11.text"));
        label11.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label11);
        label11.setBounds(342, 260, 95, 35);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_17"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(830, 270, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_12"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(830, 320, 100, 36);

        //======== scrollPane7 ========
        {

            //---- textArea7 ----
            textArea7.setLineWrap(true);
            textArea7.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea7.setForeground(Color.magenta);
            scrollPane7.setViewportView(textArea7);
        }
        contentPane.add(scrollPane7);
        scrollPane7.setBounds(410, 260, 395, 55);

        //---- label12 ----
        label12.setText(bundle.getString("label12.text"));
        label12.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label12);
        label12.setBounds(342, 318, 95, 35);

        //======== scrollPane8 ========
        {

            //---- textArea8 ----
            textArea8.setLineWrap(true);
            textArea8.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea8.setForeground(Color.magenta);
            scrollPane8.setViewportView(textArea8);
        }
        contentPane.add(scrollPane8);
        scrollPane8.setBounds(410, 318, 395, 55);

        //---- label13 ----
        label13.setText(bundle.getString("label13.text"));
        label13.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label13);
        label13.setBounds(342, 376, 95, 35);

        //======== scrollPane9 ========
        {

            //---- textArea9 ----
            textArea9.setLineWrap(true);
            textArea9.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea9.setForeground(Color.magenta);
            scrollPane9.setViewportView(textArea9);
        }
        contentPane.add(scrollPane9);
        scrollPane9.setBounds(410, 376, 395, 55);

        //---- label14 ----
        label14.setText(bundle.getString("label14.text"));
        label14.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label14);
        label14.setBounds(342, 433, 95, 35);

        //======== scrollPane10 ========
        {

            //---- textArea10 ----
            textArea10.setLineWrap(true);
            textArea10.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea10.setForeground(Color.magenta);
            scrollPane10.setViewportView(textArea10);
        }
        contentPane.add(scrollPane10);
        scrollPane10.setBounds(410, 433, 395, 55);

        //---- label15 ----
        label15.setText(bundle.getString("label15.text"));
        label15.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label15);
        label15.setBounds(717, 15, 60, 35);

        //---- textField4 ----
        textField4.setFont(new Font("sansserif", Font.BOLD, 14));
        textField4.setForeground(Color.magenta);
        contentPane.add(textField4);
        textField4.setBounds(770, 15, 115, 35);

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
        setSize(1037, 544);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JLabel label6;
    private JScrollPane scrollPane4;
    private JTextArea textArea4;
    private JLabel label7;
    private JScrollPane scrollPane5;
    private JTextArea textArea5;
    private JLabel label8;
    private JTextField textField3;
    private JLabel label9;
    private JLabel label10;
    private JScrollPane scrollPane6;
    private JTextArea textArea6;
    private JLabel label11;
    private JButton button2;
    private JButton button3;
    private JScrollPane scrollPane7;
    private JTextArea textArea7;
    private JLabel label12;
    private JScrollPane scrollPane8;
    private JTextArea textArea8;
    private JLabel label13;
    private JScrollPane scrollPane9;
    private JTextArea textArea9;
    private JLabel label14;
    private JScrollPane scrollPane10;
    private JTextArea textArea10;
    private JLabel label15;
    private JTextField textField4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
