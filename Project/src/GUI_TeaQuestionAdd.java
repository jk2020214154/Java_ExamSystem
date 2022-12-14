import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 12:51:51 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaQuestionAdd extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaQuestionAdd(Window owner) {
        super(owner);
        GUI_TeaQuestion.GUI_TeaQuestionflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaQuestion.GUI_TeaQuestionflag=0;
            }
        });
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaQuestion.GUI_TeaQuestionflag=0;
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String temp=textField1.getText();
        QuestionProblem questioned=new QuestionProblem();
        if ((temp != null && !temp.trim().equals(""))) {
            int flag = 0;
            for (int i = 0; i < GUI_TeaQuestion.data.size(); i++) {
                if (Main.isNumeric(temp) && Integer.valueOf(temp) == GUI_TeaQuestion.data.get(i).getId()) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "该条记录序号已存在,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
                textArea1.setText("");
                textArea2.setText("");
            } else if (Main.isNumeric(temp)) {
                questioned.setId(Integer.valueOf(temp));
                questioned.setDescription(textArea1.getText());
                questioned.setAnswer(textArea2.getText());

                GUI_TeaQuestion.data.add(questioned);
                GUI_TeaQuestion.tableinit();
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    System.out.println("数据库驱动已成功启动!");
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
                try {
                    con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
                    System.out.println("数据库已成功连接!");
                    String sql = "Insert into 简答题 values(?,?,?)";
                    preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setInt(1, questioned.getId());
                    preparedstatement.setString(2, questioned.getDescription());
                    preparedstatement.setString(3, questioned.getAnswer());
                    preparedstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "添加成功!", "简答题添加记录", JOptionPane.PLAIN_MESSAGE);
                    con.close();
                    System.out.println("数据库已关闭!");
                } catch (SQLException eve) {
                    System.out.println(eve);
                }
                textField1.setText("");
                textArea1.setText("");
                textArea2.setText("");
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
            textArea2.setText("");
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
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();

        //======== this ========
        setTitle(bundle.getString("this.title_15"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_18"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(20, 20, label1.getPreferredSize().width, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_7"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.red);
        contentPane.add(label2);
        label2.setBounds(20, 65, label2.getPreferredSize().width, 35);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 16));
        textField1.setForeground(Color.orange);
        contentPane.add(textField1);
        textField1.setBounds(76, 20, 229, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.green);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(76, 65, 389, 120);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_4"));
        label3.setFont(new Font("sansserif", Font.BOLD, 16));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(20, 190, 56, 35);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.blue);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(76, 190, 389, 120);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_17"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(145, 320, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_13"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(290, 320, 100, 36);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setText(bundle.getString("textArea3.text"));
            textArea3.setLineWrap(true);
            textArea3.setFont(new Font("sansserif", Font.BOLD, 12));
            textArea3.setEditable(false);
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(310, 10, 175, 50);

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
        setSize(501, 407);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
