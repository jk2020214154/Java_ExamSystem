import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 14 10:21:26 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaSelectAdd extends JDialog {
    public ButtonGroup buttonGroup1 = new ButtonGroup();
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaSelectAdd(Window owner) {
        super(owner);
        GUI_TeaSelect.GUI_TeaSelectflag=1;
        initComponents();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_TeaSelect.GUI_TeaSelectflag=0;
            }
        });
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_TeaSelect.GUI_TeaSelectflag=0;
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(radioButton1.isSelected()||radioButton2.isSelected()||radioButton3.isSelected()||radioButton4.isSelected())
        {
            String temp=textField1.getText();
            SelectProblem selected=new SelectProblem();
            if ((temp != null && !temp.trim().equals(""))){
                int flag = 0;
                for (int i = 0; i < GUI_TeaSelect.data.size(); i++) {
                    if(Main.isNumeric(temp)&&Integer.valueOf(temp)==GUI_TeaSelect.data.get(i).getId()) {
                        flag=1;
                        break;
                    }
                }
                if(flag==1) {
                    JOptionPane.showMessageDialog(null, "该条记录序号已存在,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField1.setText("");
                    textArea1.setText("");textArea2.setText("");
                    textArea3.setText("");textArea4.setText("");
                    buttonGroup1.clearSelection();
                }
                else if(Main.isNumeric(temp)){

                    selected.setId(Integer.valueOf(temp));
                    selected.setDescription(textArea1.getText());
                    selected.setSelect_A(textArea2.getText());
                    selected.setSelect_B(textArea3.getText());
                    selected.setSelect_C(textArea4.getText());
                    selected.setSelect_D(textArea5.getText());
                    if(radioButton1.isSelected())
                        selected.setAnswer("A");
                    else if(radioButton2.isSelected())
                        selected.setAnswer("B");
                    else if(radioButton3.isSelected())
                        selected.setAnswer("C");
                    else if(radioButton4.isSelected())
                        selected.setAnswer("D");
                    GUI_TeaSelect.data.add(selected);
                    GUI_TeaSelect.tableinit();
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
                        String sql = "Insert into 选择题 values(?,?,?,?,?,?,?)";
                        preparedstatement=con.prepareStatement(sql);
                        preparedstatement.setInt(1,selected.getId());
                        preparedstatement.setString(2,selected.getDescription());
                        preparedstatement.setString(3,selected.getSelect_A());
                        preparedstatement.setString(4,selected.getSelect_B());
                        preparedstatement.setString(5,selected.getSelect_C());
                        preparedstatement.setString(6,selected.getSelect_D());
                        preparedstatement.setString(7,selected.getAnswer());
                        preparedstatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "添加成功!", "选择题添加记录", JOptionPane.PLAIN_MESSAGE);
                        con.close();
                        System.out.println("数据库已关闭!");
                    } catch (SQLException eve) {
                        System.out.println(eve);
                    }
                    textField1.setText("");
                    textArea1.setText("");textArea2.setText("");
                    textArea3.setText("");textArea4.setText("");textArea5.setText("");
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
                textArea1.setText("");textArea2.setText("");
                textArea3.setText("");textArea4.setText("");textArea5.setText("");
                buttonGroup1.clearSelection();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"未选择正确答案,请进行选择!","警告",JOptionPane.ERROR_MESSAGE);
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
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        scrollPane4 = new JScrollPane();
        textArea4 = new JTextArea();
        scrollPane5 = new JScrollPane();
        textArea5 = new JTextArea();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_13"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_16"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(20, 20, 56, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_5"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.red);
        contentPane.add(label2);
        label2.setBounds(20, 60, 56, 35);

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
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.blue);
            textArea1.setToolTipText("\u8bf7\u8f93\u5165\u63cf\u8ff0(\u4e0d\u591a\u4e8e150\u5b57)");
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(76, 60, 389, 105);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setLineWrap(true);
            textArea2.setTabSize(4);
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.green);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(93, 173, 140, 60);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setLineWrap(true);
            textArea3.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea3.setForeground(Color.green);
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(328, 173, 140, 60);

        //======== scrollPane4 ========
        {

            //---- textArea4 ----
            textArea4.setLineWrap(true);
            textArea4.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea4.setForeground(Color.green);
            scrollPane4.setViewportView(textArea4);
        }
        contentPane.add(scrollPane4);
        scrollPane4.setBounds(93, 245, 140, 60);

        //======== scrollPane5 ========
        {

            //---- textArea5 ----
            textArea5.setLineWrap(true);
            textArea5.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea5.setForeground(Color.green);
            scrollPane5.setViewportView(textArea5);
        }
        contentPane.add(scrollPane5);
        scrollPane5.setBounds(328, 245, 140, 60);

        //---- radioButton1 ----
        radioButton1.setText(bundle.getString("radioButton1.text_2"));
        radioButton1.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton1.setForeground(Color.magenta);
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(20, 176), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText(bundle.getString("radioButton2.text_2"));
        radioButton2.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton2.setForeground(Color.magenta);
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(255, 176), radioButton2.getPreferredSize()));

        //---- radioButton3 ----
        radioButton3.setText(bundle.getString("radioButton3.text"));
        radioButton3.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton3.setForeground(Color.magenta);
        contentPane.add(radioButton3);
        radioButton3.setBounds(new Rectangle(new Point(20, 249), radioButton3.getPreferredSize()));

        //---- radioButton4 ----
        radioButton4.setText(bundle.getString("radioButton4.text"));
        radioButton4.setFont(new Font("sansserif", Font.BOLD, 16));
        radioButton4.setForeground(Color.magenta);
        contentPane.add(radioButton4);
        radioButton4.setBounds(new Rectangle(new Point(255, 248), radioButton4.getPreferredSize()));

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_11"));
        button2.addActionListener(e -> {
			button2(e);
		});
        contentPane.add(button2);
        button2.setBounds(265, 315, 100, 36);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_15"));
        button1.addActionListener(e -> {
			button1(e);
		});
        contentPane.add(button1);
        button1.setBounds(145, 315, 100, 36);

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
        ButtonGroup buttonGroup1 = new ButtonGroup();
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
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JScrollPane scrollPane4;
    private JTextArea textArea4;
    private JScrollPane scrollPane5;
    private JTextArea textArea5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
