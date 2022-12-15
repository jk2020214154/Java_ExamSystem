import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 17:14:59 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaJudgeSearch extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;

    public GUI_TeaJudgeSearch(Window owner) {
        super(owner);
        GUI_TeaJudge.GUI_TeaJudgeflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaJudge.GUI_TeaJudgeflag=0;
            }
        });
    }

    private void button4(ActionEvent e) {
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
                    GUI_TeaJudge.data.clear();
                    while(resultset.next())
                    {
                        cnt++;
                        JudgeProblem judged=new JudgeProblem();
                        judged.setId(resultset.getInt("id"));
                        judged.setDescription(resultset.getString("描述"));
                        judged.setAnswer(resultset.getString("答案"));
                        GUI_TeaJudge.data.add(judged);
                    }
                    if(cnt==0)
                    {
                        GUI_TeaJudge.tableinit();
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");
                    }
                    else{
                        GUI_TeaJudge.tableinit();
                        JOptionPane.showMessageDialog(null, "查询成功!", "判断题查询记录", JOptionPane.PLAIN_MESSAGE);
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
                String sql = "select * from 判断题 where 描述 like ? ";
                int cnt=0;
                temp="%"+temp+"%";
                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaJudge.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    JudgeProblem judeged=new JudgeProblem();
                    judeged.setId(resultset.getInt("id"));
                    judeged.setDescription(resultset.getString("描述"));
                    judeged.setAnswer(resultset.getString("答案"));
                    GUI_TeaJudge.data.add(judeged);
                }
                if(cnt==0)
                {
                    GUI_TeaJudge.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该关键词的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField2.setText("");
                }
                else{
                    GUI_TeaJudge.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "判断题查询记录", JOptionPane.PLAIN_MESSAGE);
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
        String temp="";
        if(radioButton1.isSelected()||radioButton2.isSelected())
        {
            if(radioButton1.isSelected())
                temp="正确";
            else if(radioButton2.isSelected())
                temp="错误";
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
                String sql = "select * from 判断题 where 答案=?";
                int cnt=0;

                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaJudge.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    JudgeProblem judged=new JudgeProblem();
                    judged.setId(resultset.getInt("id"));
                    judged.setDescription(resultset.getString("描述"));
                    judged.setAnswer(resultset.getString("答案"));
                    GUI_TeaJudge.data.add(judged);
                }
                if(cnt==0)
                {
                    GUI_TeaJudge.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该选项的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    buttonGroup1.clearSelection();
                }
                else{
                    GUI_TeaJudge.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "判断题查询记录", JOptionPane.PLAIN_MESSAGE);
                    buttonGroup1.clearSelection();
                }
                con.close();
                System.out.println("数据库已关闭!");
            }
            catch (SQLException eve) {
                System.out.println(eve);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"未选择查询选项,请进行选择!","警告",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label2 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        buttonGroup1 = new ButtonGroup();

        //======== this ========
        setTitle(bundle.getString("this.title_17"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_9"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        contentPane.add(label2);
        label2.setBounds(15, 5, 460, 95);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_20"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(35, 90, 65, 40);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.magenta);
        contentPane.add(textField1);
        textField1.setBounds(110, 90, 225, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_6"));
        label3.setFont(new Font("sansserif", Font.BOLD, 16));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(30, 145, 70, 40);

        //---- textField2 ----
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        textField2.setForeground(Color.magenta);
        contentPane.add(textField2);
        textField2.setBounds(110, 145, 225, 40);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_3"));
        label4.setFont(new Font("sansserif", Font.BOLD, 16));
        label4.setForeground(Color.red);
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 207), label4.getPreferredSize()));

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("radioButton1.text_5"));
        radioButton1.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton1.setForeground(Color.blue);
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(145, 207), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("radioButton2.text_5"));
        radioButton2.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton2.setForeground(Color.blue);
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(240, 207), radioButton2.getPreferredSize()));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_19"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(365, 92, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_15"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(365, 147, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_10"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(365, 198, 100, 36);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_10"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(365, 253, 100, 36);

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

        //---- buttonGroup1 ----
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    public ButtonGroup buttonGroup1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
