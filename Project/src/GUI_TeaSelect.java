import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 15:11:28 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaSelect extends JDialog {

    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;

    ArrayList<SelectProblem> data=new ArrayList<SelectProblem>();
    public void sqlinit(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("数据库驱动已成功启动!");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        try {
            con = DriverManager.getConnection("jdbc:derby:E:\\大学\\专业课\\3.1Java\\在线考试系统;create=true");
            System.out.println("数据库已成功连接!");

            statement = con.createStatement();
            String sql1="select * from 选择题";
            resultset=statement.executeQuery(sql1);
            System.out.println("查询成功!");
            data.clear();
            while(resultset.next()){
                SelectProblem temp=new SelectProblem();
                temp.setId(resultset.getInt("id"));
                temp.setDescription(resultset.getString("描述"));
                temp.setSelect_A(resultset.getString("A"));
                temp.setSelect_B(resultset.getString("B"));
                temp.setSelect_C(resultset.getString("C"));
                temp.setSelect_D(resultset.getString("D"));
                temp.setAnswer(resultset.getString("答案"));
                data.add(temp);
                System.out.println(temp.getId()+"|"+temp.getDescription()+"|"+temp.getSelect_A()+"|"+temp.getSelect_B() + "|"+temp.getSelect_C() + "|"+temp.getSelect_D() + "|"+temp.getAnswer());
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public GUI_TeaSelect(Window owner) {
        super(owner);
        GUI_Teacher.GUI_Teacherflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Teacher.GUI_Teacherflag=0;
            }
        });
        initComponents();
        sqlinit();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Teacher.GUI_Teacherflag=0;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle(bundle.getString("this.title_2"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_6"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(135, 15, 275, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_7"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(425, 365, 100, 36);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(45, 50, 465, 235);

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
        setSize(550, 450);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
