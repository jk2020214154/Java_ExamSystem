import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 12:27:18 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaJudgeAdd extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaJudgeAdd(Window owner) {
        super(owner);
        GUI_TeaJudge.GUI_TeaJudgeflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaJudge.GUI_TeaJudgeflag=0;
            }
        });
    }


    private void button2(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaJudge.GUI_TeaJudgeflag=0;
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(radioButton1.isSelected()||radioButton2.isSelected())
        {
            String temp=textField1.getText();
            JudgeProblem judged=new JudgeProblem();
            if ((temp != null && !temp.trim().equals(""))){
                int flag = 0;
                for (int i = 0; i < GUI_TeaJudge.data.size(); i++) {
                    if(Main.isNumeric(temp)&&Integer.valueOf(temp)==GUI_TeaJudge.data.get(i).getId()) {
                        flag=1;
                        break;
                    }
                }
                if(flag==1) {
                    JOptionPane.showMessageDialog(null, "该条记录序号已存在,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField1.setText("");
                    textArea1.setText("");
                    buttonGroup1.clearSelection();
                }
                else if(Main.isNumeric(temp)){

                    judged.setId(Integer.valueOf(temp));
                    judged.setDescription(textArea1.getText());
                    if(radioButton1.isSelected())
                        judged.setAnswer("正确");
                    else if(radioButton2.isSelected())
                        judged.setAnswer("错误");
                    GUI_TeaJudge.data.add(judged);
                    GUI_TeaJudge.tableinit();
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
                        String sql = "Insert into 判断题 values(?,?,?)";
                        preparedstatement=con.prepareStatement(sql);
                        preparedstatement.setInt(1,judged.getId());
                        preparedstatement.setString(2,judged.getDescription());
                        preparedstatement.setString(3,judged.getAnswer());
                        preparedstatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "添加成功!", "判断题添加记录", JOptionPane.PLAIN_MESSAGE);
                        con.close();
                        System.out.println("数据库已关闭!");
                    } catch (SQLException eve) {
                        System.out.println(eve);
                    }
                    textField1.setText("");
                    textArea1.setText("");
                    buttonGroup1.clearSelection();
                }
                else{
                    JOptionPane.showMessageDialog(null, "序号应为数字,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                    textField1.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
                textArea1.setText("");
                buttonGroup1.clearSelection();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"未选择答案,请进行选择!","警告",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button1 = new JButton();
        button2 = new JButton();
        buttonGroup1 = new ButtonGroup();

        //======== this ========
        setTitle(bundle.getString("this.title_14"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_17"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(20, 20, label1.getPreferredSize().width, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_6"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.red);
        contentPane.add(label2);
        label2.setBounds(20, 60, label2.getPreferredSize().width, 35);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 16));
        textField1.setForeground(Color.orange);
        contentPane.add(textField1);
        textField1.setBounds(76, 20, 240, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setTabSize(4);
            textArea1.setFont(new Font("sansserif", Font.PLAIN, 14));
            textArea1.setForeground(Color.green);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(76, 70, 379, 155);

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("radioButton1.text_3"));
        radioButton1.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton1.setForeground(Color.magenta);
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(169, 239), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("radioButton2.text_3"));
        radioButton2.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton2.setForeground(Color.magenta);
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(290, 239), radioButton2.getPreferredSize()));

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_16"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(145, 280, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_12"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(280, 280, 100, 36);

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
        setSize(500, 400);
        setLocationRelativeTo(null);

        //---- buttonGroup1 ----
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    private JButton button2;
    public ButtonGroup buttonGroup1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
