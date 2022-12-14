import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 17:41:22 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaQuestionSearch extends JDialog {

    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;

    public GUI_TeaQuestionSearch(Window owner) {
        super(owner);
        GUI_TeaQuestion.GUI_TeaQuestionflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaQuestion.GUI_TeaQuestionflag=0;
            }
        });
    }

    private void button4(ActionEvent e) {
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
                    GUI_TeaQuestion.data.clear();
                    while(resultset.next())
                    {
                        cnt++;
                        QuestionProblem questioned=new QuestionProblem();
                        questioned.setId(resultset.getInt("id"));
                        questioned.setDescription(resultset.getString("描述"));
                        questioned.setAnswer(resultset.getString("答案"));
                        GUI_TeaQuestion.data.add(questioned);
                    }
                    if(cnt==0)
                    {
                        GUI_TeaQuestion.tableinit();
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");
                    }
                    else{
                        GUI_TeaQuestion.tableinit();
                        JOptionPane.showMessageDialog(null, "查询成功!", "简答题查询记录", JOptionPane.PLAIN_MESSAGE);
                        textField1.setText("");
                    }
                    con.close();
                    System.out.println("数据库已关闭!");
                }
                catch (SQLException eve) {
                    System.out.println(eve);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "序号应为数字,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField1.setText("");
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        String temp=textField2.getText();
        if ((temp != null && !temp.trim().equals(""))){
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
                String sql = "select * from 简答题 where 描述 like ? ";
                int cnt=0;
                temp="%"+temp+"%";
                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaQuestion.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    QuestionProblem questioned=new QuestionProblem();
                    questioned.setId(resultset.getInt("id"));
                    questioned.setDescription(resultset.getString("描述"));
                    questioned.setAnswer(resultset.getString("答案"));
                    GUI_TeaQuestion.data.add(questioned);
                }
                if(cnt==0)
                {
                    GUI_TeaQuestion.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该关键词的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField2.setText("");
                }
                else{
                    GUI_TeaQuestion.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "简答题查询记录", JOptionPane.PLAIN_MESSAGE);
                    textField2.setText("");
                }
                con.close();
                System.out.println("数据库已关闭!");
            }
            catch (SQLException eve) {
                System.out.println(eve);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField2.setText("");
        }
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        String temp=textField3.getText();
        if ((temp != null && !temp.trim().equals(""))){
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
                String sql = "select * from 简答题 where 答案 like ? ";
                int cnt=0;
                temp="%"+temp+"%";
                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaQuestion.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    QuestionProblem questioned=new QuestionProblem();
                    questioned.setId(resultset.getInt("id"));
                    questioned.setDescription(resultset.getString("描述"));
                    questioned.setAnswer(resultset.getString("答案"));
                    GUI_TeaQuestion.data.add(questioned);
                }
                if(cnt==0)
                {
                    GUI_TeaQuestion.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该关键词的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField3.setText("");
                }
                else{
                    GUI_TeaQuestion.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "简答题查询记录", JOptionPane.PLAIN_MESSAGE);
                    textField3.setText("");
                }
                con.close();
                System.out.println("数据库已关闭!");
            }
            catch (SQLException eve) {
                System.out.println(eve);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
            textField3.setText("");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label2 = new JLabel();
        textField1 = new JTextField();
        label1 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_18"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_10"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        contentPane.add(label2);
        label2.setBounds(10, 10, 460, 95);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.magenta);
        contentPane.add(textField1);
        textField1.setBounds(125, 110, 225, 40);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_21"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(50, 110, 65, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_7"));
        label3.setFont(new Font("sansserif", Font.BOLD, 16));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(10, 165, 105, 40);

        //---- textField2 ----
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        textField2.setForeground(Color.magenta);
        contentPane.add(textField2);
        textField2.setBounds(125, 165, 225, 40);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_4"));
        label4.setFont(new Font("sansserif", Font.BOLD, 16));
        label4.setForeground(Color.red);
        contentPane.add(label4);
        label4.setBounds(10, 215, 105, 40);

        //---- textField3 ----
        textField3.setFont(new Font("sansserif", Font.BOLD, 14));
        textField3.setForeground(Color.magenta);
        contentPane.add(textField3);
        textField3.setBounds(125, 215, 225, 40);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_20"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(375, 112, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_16"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(375, 167, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_11"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(375, 217, 100, 36);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_11"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(375, 270, 100, 36);

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
        setSize(500, 350);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label2;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
