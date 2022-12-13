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
 * Created by JFormDesigner on Sat Dec 10 15:12:32 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaJudge extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;

    ArrayList<JudgeProblem> data=new ArrayList<JudgeProblem>();
    public String[][] to_list(ArrayList<JudgeProblem> data){

        String tempbody[][]=new String[data.size()][3];
        for(int i=0;i<data.size();i++){
            JudgeProblem temp=data.get(i);
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
            String sql1="select * from 判断题";
            resultset=statement.executeQuery(sql1);
            System.out.println("查询成功!");
            data.clear();
            while(resultset.next()){
                JudgeProblem temp=new JudgeProblem();
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
    public GUI_TeaJudge(Window owner) {
        super(owner);
        GUI_Teacher.GUI_Teacherflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Teacher.GUI_Teacherflag=0;
            }
        });
        initComponents();
        sqlinit();
        String thead[]={"序号","描述","答案"};
        String tbody[][]=to_list(data);
        table1.setRowHeight(50);
        TableModel model = new DefaultTableModel(tbody,thead);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableCellRenderer cr1 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cr2 = new DefaultTableCellRenderer();
        cr1.setHorizontalAlignment(JLabel.CENTER);
        cr2.setHorizontalAlignment(JLabel.CENTER);
        table1.setModel(model);

        table1.setDefaultRenderer(Object.class,new TableCellTextAreaRenderer());
        for(int i=0;i<=2;i++) {
            TableColumn column = table1.getColumnModel().getColumn(i);
            if (i == 1){
                column.setPreferredWidth(520);
                column.setMaxWidth(530);
            }
            else{
                if(i==0){
                    cr1.setBackground(Color.pink);column.setPreferredWidth(40);column.setCellRenderer(cr1);}
                else if(i==2){
                    cr2.setBackground(Color.green);column.setPreferredWidth(40);column.setMaxWidth(100);column.setCellRenderer(cr2);}
            }
        }
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
        setTitle(bundle.getString("this.title_3"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_5"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(200, 15, 275, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_8"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(530, 365, 100, 36);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 50, 615, 235);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
