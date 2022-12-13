import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Dec 13 20:11:36 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaQuestionDel extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    public GUI_TeaQuestionDel(Window owner) {
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
        //System.out.println(temp+"|");
        if(GUI_TeaQuestion.data.size()==0){
            JOptionPane.showMessageDialog(null,"该简答题题库为空,请勿删除!","警告",JOptionPane.ERROR_MESSAGE);
            textField1.setText("");
        }
        else {
            if ((temp != null && !temp.trim().equals(""))) {
                int flag = 0;
                for (int i = 0; i < GUI_TeaQuestion.data.size(); i++) {

                    if(Main.isNumeric(temp)&&Integer.valueOf(temp)==GUI_TeaQuestion.data.get(i).getId()) {
                        flag=1;
                        textField1.setText("");
                        GUI_TeaQuestion.data.remove(i);
                        GUI_TeaQuestion.tableinit();
                        try{
                            con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
                            System.out.println("数据库已成功连接!");
                            String sql = "delete from 简答题 where id=?";
                            preparedstatement = con.prepareStatement(sql);
                            preparedstatement.setInt(1, Integer.valueOf(temp));
                            preparedstatement.executeUpdate();
                            con.close();
                            System.out.println("数据库已关闭!");
                        } catch (SQLException eve) {
                            System.out.println(eve);
                        }
                        JOptionPane.showMessageDialog(null, "删除成功!", "简答题删除记录", JOptionPane.PLAIN_MESSAGE);
                    }
                }

                if (flag == 0) {
                    textField1.setText("");
                    JOptionPane.showMessageDialog(null, "该条记录不存在,请重新输入!", "警告", JOptionPane.ERROR_MESSAGE);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "无效输入,请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_12"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_15"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(Color.red);
        contentPane.add(label1);
        label1.setBounds(25, 37, 200, 35);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField1);
        textField1.setBounds(225, 37, 145, 35);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_14"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(90, 87, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_10"));
        button2.addActionListener(e -> {
			button2(e);
			button2(e);
			button2(e);
		});
        contentPane.add(button2);
        button2.setBounds(210, 87, 100, 36);

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
        setSize(400, 200);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
