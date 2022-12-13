import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
/*
 * Created by JFormDesigner on Sat Dec 10 15:15:57 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaQuestion extends JDialog {
    int GUI_TeaQuestionflag=0;
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;

    ArrayList<QuestionProblem> data=new ArrayList<QuestionProblem>();

    public String[][] to_list(ArrayList<QuestionProblem> data){

        String tempbody[][]=new String[data.size()][3];
        for(int i=0;i<data.size();i++){
            QuestionProblem temp=data.get(i);
            tempbody[i][0]=Integer.toString(temp.getId());
            tempbody[i][1] = temp.getDescription();
            tempbody[i][2] = temp.getAnswer();
        }
        return tempbody;
    }
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
            String sql1="select * from 简答题";
            resultset=statement.executeQuery(sql1);
            System.out.println("查询成功!");
            data.clear();
            while(resultset.next()){
                QuestionProblem temp=new QuestionProblem();
                temp.setId(resultset.getInt("id"));
                temp.setDescription(resultset.getString("描述"));
                temp.setAnswer(resultset.getString("答案"));
                data.add(temp);
                System.out.println(temp.getId()+"|"+temp.getDescription()+"|"+temp.getAnswer());
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void tableinit(){
        String thead[]={"序号","描述","答案"};
        String tbody[][]=to_list(data);
        table1.setRowHeight(120);
        TableModel model = new DefaultTableModel(tbody,thead);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableCellRenderer cr1 = new DefaultTableCellRenderer();
        cr1.setHorizontalAlignment(JLabel.CENTER);
        table1.setModel(model);

        table1.setDefaultRenderer(Object.class,new TableCellTextAreaRenderer());
        for(int i=0;i<=2;i++) {
            TableColumn column = table1.getColumnModel().getColumn(i);
            if (i == 1||i==2){
                if(i==1) {
                    column.setPreferredWidth(180);
                    column.setMaxWidth(2000);
                }
                else {
                    column.setPreferredWidth(320);
                    column.setMaxWidth(340);
                }
            }
            else{
                cr1.setBackground(Color.pink);column.setPreferredWidth(40);column.setCellRenderer(cr1);}
        }
    }
    public GUI_TeaQuestion(Window owner) {
        super(owner);
        GUI_Teacher.GUI_Teacherflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Teacher.GUI_Teacherflag=0;
            }
        });
        initComponents();
        sqlinit();
        tableinit();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Teacher.GUI_Teacherflag=0;
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        if(GUI_TeaQuestionflag==0) {
            sqlinit();
            tableinit();
            JOptionPane.showMessageDialog(null, "简答题数据刷新成功！", "简答题--刷新", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button6 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_4"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_7"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(200, 15, 275, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_11"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(530, 365, 100, 36);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 50, 615, 235);

        //---- button6 ----
        button6.setText(bundle.getString("button6.text_5"));
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6);
        button6.setBounds(35, 330, 100, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_7"));
        contentPane.add(button2);
        button2.setBounds(180, 300, 100, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_8"));
        contentPane.add(button3);
        button3.setBounds(180, 360, 100, 36);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_8"));
        contentPane.add(button4);
        button4.setBounds(350, 300, 100, 36);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text_6"));
        contentPane.add(button5);
        button5.setBounds(350, 360, 100, 36);

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
        setSize(650, 450);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button6;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
