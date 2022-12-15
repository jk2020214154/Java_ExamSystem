import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 15:33:53 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaSelectSearch extends JDialog {

    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaSelectSearch(Window owner) {
        super(owner);
        GUI_TeaSelect.GUI_TeaSelectflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaSelect.GUI_TeaSelectflag=0;
            }
        });
    }

    private void button4(ActionEvent e) {
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
                    GUI_TeaSelect.data.clear();
                    while(resultset.next())
                    {
                        cnt++;
                        SelectProblem selected=new SelectProblem();
                        selected.setId(resultset.getInt("id"));
                        selected.setDescription(resultset.getString("描述"));
                        selected.setSelect_A(resultset.getString("A"));
                        selected.setSelect_B(resultset.getString("B"));
                        selected.setSelect_C(resultset.getString("C"));
                        selected.setSelect_D(resultset.getString("D"));
                        selected.setAnswer(resultset.getString("答案"));
                        GUI_TeaSelect.data.add(selected);
                    }
                    if(cnt==0)
                    {
                        GUI_TeaSelect.tableinit();
                        JOptionPane.showMessageDialog(null, "不存在该序号的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                        textField1.setText("");
                    }
                    else{
                        GUI_TeaSelect.tableinit();
                        JOptionPane.showMessageDialog(null, "查询成功!", "选择题查询记录", JOptionPane.PLAIN_MESSAGE);
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
                String sql = "select * from 选择题 where 描述 like ? or A like ? or B like ? or C like ? or D like ? ";
                int cnt=0;
                temp="%"+temp+"%";
                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                preparedstatement.setString(2,temp);
                preparedstatement.setString(3,temp);
                preparedstatement.setString(4,temp);
                preparedstatement.setString(5,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaSelect.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    SelectProblem selected=new SelectProblem();
                    selected.setId(resultset.getInt("id"));
                    selected.setDescription(resultset.getString("描述"));
                    selected.setSelect_A(resultset.getString("A"));
                    selected.setSelect_B(resultset.getString("B"));
                    selected.setSelect_C(resultset.getString("C"));
                    selected.setSelect_D(resultset.getString("D"));
                    selected.setAnswer(resultset.getString("答案"));
                    GUI_TeaSelect.data.add(selected);
                }
                if(cnt==0)
                {
                    GUI_TeaSelect.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该关键词的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField2.setText("");
                }
                else{
                    GUI_TeaSelect.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "选择题查询记录", JOptionPane.PLAIN_MESSAGE);
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
        if(radioButton1.isSelected()||radioButton2.isSelected()||radioButton3.isSelected()||radioButton4.isSelected())
        {
            if(radioButton1.isSelected())
                temp="A";
            else if(radioButton2.isSelected())
                temp="B";
            else if(radioButton3.isSelected())
                temp="C";
            else if(radioButton4.isSelected())
                temp="D";
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
                String sql = "select * from 选择题 where 答案=?";
                int cnt=0;
                
                preparedstatement = con.prepareStatement(sql);
                preparedstatement.setString(1,temp);
                resultset=preparedstatement.executeQuery();
                GUI_TeaSelect.data.clear();
                while(resultset.next())
                {
                    cnt++;
                    SelectProblem selected=new SelectProblem();
                    selected.setId(resultset.getInt("id"));
                    selected.setDescription(resultset.getString("描述"));
                    selected.setSelect_A(resultset.getString("A"));
                    selected.setSelect_B(resultset.getString("B"));
                    selected.setSelect_C(resultset.getString("C"));
                    selected.setSelect_D(resultset.getString("D"));
                    selected.setAnswer(resultset.getString("答案"));
                    GUI_TeaSelect.data.add(selected);
                }
                if(cnt==0)
                {
                    GUI_TeaSelect.tableinit();
                    JOptionPane.showMessageDialog(null, "不存在该选项的结果,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    buttonGroup1.clearSelection();
                }
                else{
                    GUI_TeaSelect.tableinit();
                    JOptionPane.showMessageDialog(null, "查询成功!查询共"+cnt+"条", "选择题查询记录", JOptionPane.PLAIN_MESSAGE);
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
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        button4 = new JButton();
        buttonGroup1 = new ButtonGroup();

        //======== this ========
        setTitle(bundle.getString("this.title_16"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_19"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(35, 90, 65, 40);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_8"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        contentPane.add(label2);
        label2.setBounds(30, 0, 460, 95);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.magenta);
        contentPane.add(textField1);
        textField1.setBounds(110, 90, 225, 40);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_18"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(365, 92, 100, 36);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_5"));
        label3.setFont(new Font("sansserif", Font.BOLD, 16));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(30, 145, 70, 40);

        //---- textField2 ----
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        textField2.setForeground(Color.magenta);
        contentPane.add(textField2);
        textField2.setBounds(110, 145, 225, 40);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_14"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(365, 147, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_9"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(365, 198, 100, 36);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_2"));
        label4.setFont(new Font("sansserif", Font.BOLD, 16));
        label4.setForeground(Color.red);
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(15, 207), label4.getPreferredSize()));

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("radioButton1.text_4"));
        radioButton1.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton1.setForeground(Color.blue);
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(125, 193), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("radioButton2.text_4"));
        radioButton2.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton2.setForeground(Color.blue);
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(225, 193), radioButton2.getPreferredSize()));

        //---- radioButton3 ----
        radioButton3.setText(bundle.getString("radioButton3.text_3"));
        radioButton3.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton3.setForeground(Color.blue);
        contentPane.add(radioButton3);
        radioButton3.setBounds(new Rectangle(new Point(125, 238), radioButton3.getPreferredSize()));

        //---- radioButton4 ----
        radioButton4.setText(bundle.getString("radioButton4.text_3"));
        radioButton4.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton4.setForeground(Color.blue);
        contentPane.add(radioButton4);
        radioButton4.setBounds(new Rectangle(new Point(225, 238), radioButton4.getPreferredSize()));

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_9"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(365, 265, 100, 36);

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
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JButton button4;
    public ButtonGroup buttonGroup1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
