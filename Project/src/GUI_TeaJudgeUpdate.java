import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Dec 15 14:24:24 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaJudgeUpdate extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaJudgeUpdate(Window owner) {
        super(owner);
        GUI_TeaJudge.GUI_TeaJudgeflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaJudge.GUI_TeaJudgeflag=0;
            }
        });
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaJudge.GUI_TeaJudgeflag=0;
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
                    String sql = "select * from 判断题 where id=?";
                    int cnt=0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset=preparedstatement.executeQuery();
                    JudgeProblem judged=new JudgeProblem();
                    while(resultset.next())
                    {
                        cnt++;
                        judged.setId(resultset.getInt("id"));
                        judged.setDescription(resultset.getString("描述"));
                        judged.setAnswer(resultset.getString("答案"));
                    }
                    if(cnt==0)
                    {
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");textField2.setText("");textArea1.setText("");
                    }
                    else{
                        textField2.setText(judged.getAnswer());
                        textArea1.setText(judged.getDescription());
                        JOptionPane.showMessageDialog(null, "同步原数据成功!", "判断题修改记录", JOptionPane.PLAIN_MESSAGE);
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
                textField1.setText("");textField2.setText("");textArea1.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField1.setText("");textField2.setText("");textArea1.setText("");
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        int flag[] = new int[4], flagg = 0;
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
                    String sql = "select * from 判断题 where id=?";
                    int cnt = 0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset = preparedstatement.executeQuery();
                    JudgeProblem judged = new JudgeProblem();
                    while (resultset.next()) {
                        cnt++;
                        judged.setId(resultset.getInt("id"));
                        judged.setDescription(resultset.getString("描述"));
                        judged.setAnswer(resultset.getString("答案"));
                    }
                    con.close();
                    System.out.println("数据库已关闭!");
                    if (cnt == 1 && !temp.equals(textField1.getText())) {
                        flagg = -1;
                        JOptionPane.showMessageDialog(null, "该新序号已在数据库中存在，请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField4.setText("");
                        textField3.setText("");
                        textArea2.setText("");
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
                textField4.setText("");textField3.setText("");textArea2.setText("");
            }
        }
        if (flagg >= 0) {
            temp = textField3.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (temp.equals("正确") || temp.equals("错误")) {
                    if (!temp.equals(textField2.getText())) {
                        flagg++;
                        flag[3] = 1;
                    }
                } else {
                    flagg = -1;
                    JOptionPane.showMessageDialog(null, "新选项应为正确或错误中的一个,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                    textField4.setText("");
                    textField3.setText("");
                    textArea2.setText("");
                }
            }
        }
        if (flagg >= 0) {
            temp = textArea2.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea1.getText())) {
                    flagg++;
                    flag[2] = 1;
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
                for (int i = 1; i <= 3; i++) {
                    if (flag[i] == 1) {
                        if (i == 1) {
                            String sql = "update 判断题 set id=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setInt(1, Integer.valueOf(textField4.getText()));
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textField1.setText(textField4.getText());
                            textField4.setText("");
                        } else if (i == 2) {
                            String sql = "update 判断题 set 描述=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea2.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea1.setText(textArea2.getText());
                            textArea2.setText("");
                        } else if (i == 3) {
                            String sql = "update 判断题 set 答案=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textField3.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textField2.setText(textField3.getText());
                            textField3.setText("");
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "修改成功!", "判断题修改记录", JOptionPane.PLAIN_MESSAGE);
                statement = con.createStatement();
                String sql1 = "select * from 判断题";
                resultset = statement.executeQuery(sql1);
                System.out.println("查询成功!");
                GUI_TeaJudge.data.clear();
                while (resultset.next()) {
                    JudgeProblem tempp = new JudgeProblem();
                    tempp.setId(resultset.getInt("id"));
                    tempp.setDescription(resultset.getString("描述"));
                    tempp.setAnswer(resultset.getString("答案"));
                    GUI_TeaJudge.data.add(tempp);
                }
                GUI_TeaJudge.tableinit();
                con.close();
                System.out.println("数据库已关闭!");
            } catch (SQLException eve) {
                System.out.println(eve);
            }
        } else if (flagg == 0) {
            JOptionPane.showMessageDialog(null, "当前状态不进行修改!", "判断题修改记录", JOptionPane.PLAIN_MESSAGE);
            textField2.setText(textField3.getText());
            textField3.setText("");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        label4 = new JLabel();
        textField2 = new JTextField();
        label15 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        label5 = new JLabel();
        textField3 = new JTextField();
        label10 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_20"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_23"));
        label1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label1);
        label1.setBounds(10, 15, 60, 35);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(75, 15, 115, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_12"));
        label2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label2);
        label2.setBounds(10, 55, 60, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.blue);
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(75, 60, 475, 90);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_22"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(205, 15, 100, 35);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_6"));
        label4.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label4);
        label4.setBounds(325, 15, 60, 35);

        //---- textField2 ----
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        textField2.setForeground(Color.blue);
        textField2.setEditable(false);
        contentPane.add(textField2);
        textField2.setBounds(375, 15, 115, 35);

        //---- label15 ----
        label15.setText(bundle.getString("label15.text_2"));
        label15.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label15);
        label15.setBounds(10, 165, 60, 35);

        //---- textField4 ----
        textField4.setFont(new Font("sansserif", Font.BOLD, 14));
        textField4.setForeground(Color.magenta);
        contentPane.add(textField4);
        textField4.setBounds(75, 165, 115, 35);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_9"));
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(10, 207, 60, 35);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setLineWrap(true);
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.magenta);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(75, 207, 475, 90);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_3"));
        label5.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label5);
        label5.setBounds(325, 165, 60, 35);

        //---- textField3 ----
        textField3.setFont(new Font("sansserif", Font.BOLD, 14));
        textField3.setForeground(Color.magenta);
        contentPane.add(textField3);
        textField3.setBounds(375, 165, 115, 35);

        //---- label10 ----
        label10.setText(bundle.getString("label10.text_2"));
        label10.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label10);
        label10.setBounds(10, 290, 245, 120);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_18"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(260, 340, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_13"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(405, 340, 100, 36);

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
        setSize(582, 450);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label15;
    private JTextField textField4;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label10;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
