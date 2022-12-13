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

    public String[][] to_list(ArrayList<SelectProblem> data){
        String tempbody[][]=new String[data.size()][7];
        for(int i=0;i<data.size();i++){
            SelectProblem temp=data.get(i);
            tempbody[i][0]=Integer.toString(temp.getId());
            tempbody[i][1] = temp.getDescription();
            tempbody[i][2] = temp.getSelect_A();
            tempbody[i][3] = temp.getSelect_B();
            tempbody[i][4] = temp.getSelect_C();
            tempbody[i][5] = temp.getSelect_D();
            tempbody[i][6] = temp.getAnswer();
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
        String thead[]={"序号","描述","选项A","选项B","选项C","选项D","答案"};
        String tbody[][]=to_list(data);
        table1.setRowHeight(100);
        TableModel model = new DefaultTableModel(tbody,thead);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableCellRenderer cr1 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cr2 = new DefaultTableCellRenderer();
        cr1.setHorizontalAlignment(JLabel.CENTER);
        cr2.setHorizontalAlignment(JLabel.CENTER);
        table1.setModel(model);

        table1.setDefaultRenderer(Object.class,new TableCellTextAreaRenderer());
        for(int i=0;i<=6;i++) {
            TableColumn column = table1.getColumnModel().getColumn(i);
            if (i == 1){
                column.setPreferredWidth(150);
                column.setMaxWidth(150);
                column.setMinWidth(150);
            }
            else{
                if(i==0||i==6){
                    cr1.setBackground(Color.pink);column.setPreferredWidth(30);column.setMaxWidth(30);column.setMinWidth(30);column.setCellRenderer(cr1);}
                else {
                    cr2.setBackground(Color.green);column.setCellRenderer(cr2);}
            }
        }


    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Teacher.GUI_Teacherflag=0;
    }


    //public boolean isCellEditable(int row, int column) { return false; }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable(){
            public boolean isCellEditable(int row, int column) { return false; }
        };
        button2 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_2"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_6"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(200, 15, 275, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_7"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(530, 365, 100, 36);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 50, 615, 235);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_4"));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(40, 300), button2.getPreferredSize()));

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
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
