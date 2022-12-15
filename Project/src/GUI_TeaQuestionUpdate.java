import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Dec 15 15:04:29 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaQuestionUpdate extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaQuestionUpdate(Window owner) {
        super(owner);
        GUI_TeaQuestion.GUI_TeaQuestionflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaQuestion.GUI_TeaQuestionflag=0;
            }
        });
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaQuestion.GUI_TeaQuestionflag=0;
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
                    String sql = "select * from 简答题 where id=?";
                    int cnt=0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset=preparedstatement.executeQuery();
                    QuestionProblem questioned=new QuestionProblem();
                    while(resultset.next())
                    {
                        cnt++;
                        questioned.setId(resultset.getInt("id"));
                        questioned.setDescription(resultset.getString("描述"));
                        questioned.setAnswer(resultset.getString("答案"));
                    }
                    if(cnt==0)
                    {
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");textArea2.setText("");textArea1.setText("");
                    }
                    else{
                        textArea2.setText(questioned.getAnswer());
                        textArea1.setText(questioned.getDescription());
                        JOptionPane.showMessageDialog(null, "同步原数据成功!", "简答题修改记录", JOptionPane.PLAIN_MESSAGE);
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
                textField1.setText("");textArea2.setText("");textArea1.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField1.setText("");textArea2.setText("");textArea1.setText("");
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
                    String sql = "select * from 简答题 where id=?";
                    int cnt = 0;
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, Integer.valueOf(temp));
                    resultset = preparedstatement.executeQuery();
                    QuestionProblem questioned = new QuestionProblem();
                    while (resultset.next()) {
                        cnt++;
                        questioned.setId(resultset.getInt("id"));
                        questioned.setDescription(resultset.getString("描述"));
                        questioned.setAnswer(resultset.getString("答案"));
                    }
                    con.close();
                    System.out.println("数据库已关闭!");
                    if (cnt == 1 && !temp.equals(textField1.getText())) {
                        flagg = -1;
                        JOptionPane.showMessageDialog(null, "该新序号已在数据库中存在，请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField4.setText("");
                        textArea4.setText("");
                        textArea3.setText("");
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
                textField4.setText("");textArea4.setText("");textArea3.setText("");
            }
        }
        if (flagg >= 0) {
            temp = textArea4.getText();
            if ((temp != null && !temp.trim().equals(""))) {
                if (!temp.equals(textArea2.getText())) {
                    flagg++;
                    flag[3] = 1;
                }
            }
        }
        if (flagg >= 0) {
            temp = textArea3.getText();
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
                            String sql = "update 简答题 set id=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setInt(1, Integer.valueOf(textField4.getText()));
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textField1.setText(textField4.getText());
                            textField4.setText("");
                        } else if (i == 2) {
                            String sql = "update 简答题 set 描述=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea3.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea1.setText(textArea3.getText());
                            textArea3.setText("");
                        } else if (i == 3) {
                            String sql = "update 简答题 set 答案=? where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setString(1, textArea4.getText());
                            preparedstatement.setInt(2, Integer.valueOf(textField1.getText()));
                            preparedstatement.executeUpdate();
                            textArea2.setText(textArea4.getText());
                            textArea4.setText("");
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "修改成功!", "简答题修改记录", JOptionPane.PLAIN_MESSAGE);
                statement = con.createStatement();
                String sql1 = "select * from 简答题";
                resultset = statement.executeQuery(sql1);
                System.out.println("查询成功!");
                GUI_TeaQuestion.data.clear();
                while (resultset.next()) {
                    QuestionProblem tempp = new QuestionProblem();
                    tempp.setId(resultset.getInt("id"));
                    tempp.setDescription(resultset.getString("描述"));
                    tempp.setAnswer(resultset.getString("答案"));
                    GUI_TeaQuestion.data.add(tempp);
                }
                GUI_TeaQuestion.tableinit();
                con.close();
                System.out.println("数据库已关闭!");
            } catch (SQLException eve) {
                System.out.println(eve);
            }
        } else if (flagg == 0) {
            JOptionPane.showMessageDialog(null, "当前状态不进行修改!", "简答题修改记录", JOptionPane.PLAIN_MESSAGE);
            textField4.setText("");textArea4.setText("");textArea3.setText("");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label15 = new JLabel();
        textField4 = new JTextField();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        label5 = new JLabel();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        scrollPane4 = new JScrollPane();
        textArea4 = new JTextArea();
        label10 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_21"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(75, 15, 115, 35);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_24"));
        label1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label1);
        label1.setBounds(10, 15, 60, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_13"));
        label2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label2);
        label2.setBounds(10, 55, 60, 35);

        //---- label15 ----
        label15.setText(bundle.getString("label15.text_3"));
        label15.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label15);
        label15.setBounds(10, 153, 60, 35);

        //---- textField4 ----
        textField4.setFont(new Font("sansserif", Font.BOLD, 14));
        textField4.setForeground(Color.magenta);
        contentPane.add(textField4);
        textField4.setBounds(75, 153, 115, 35);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_10"));
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(10, 193, 60, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.blue);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(75, 55, 240, 90);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_7"));
        label4.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label4);
        label4.setBounds(319, 55, 60, 35);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setLineWrap(true);
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.blue);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(375, 55, 375, 90);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_4"));
        label5.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label5);
        label5.setBounds(319, 193, 60, 35);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setLineWrap(true);
            textArea3.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea3.setForeground(Color.magenta);
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(75, 193, 240, 90);

        //======== scrollPane4 ========
        {

            //---- textArea4 ----
            textArea4.setLineWrap(true);
            textArea4.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea4.setForeground(Color.magenta);
            scrollPane4.setViewportView(textArea4);
        }
        contentPane.add(scrollPane4);
        scrollPane4.setBounds(375, 193, 375, 90);

        //---- label10 ----
        label10.setText(bundle.getString("label10.text_3"));
        label10.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label10);
        label10.setBounds(5, 275, 360, 120);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_23"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(205, 15, 115, 35);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_19"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(449, 320, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_14"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(569, 320, 100, 36);

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
        setSize(800, 419);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label15;
    private JTextField textField4;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JLabel label5;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JScrollPane scrollPane4;
    private JTextArea textArea4;
    private JLabel label10;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
