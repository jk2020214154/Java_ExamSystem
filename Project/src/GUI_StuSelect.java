import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Dec 11 16:20:42 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_StuSelect extends JDialog {
    Connection con;
    Statement statement;
    PreparedStatement preparedstatement;
    ResultSet resultset;


    public int tempnum=-1;
    public int tempscore=0;
    public int tot=0;

    String answer;
    ArrayList<SelectProblem> data=new ArrayList<SelectProblem>();
    int vis[];
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
    public GUI_StuSelect(Window owner) {
        super(owner);
        initComponents();
        sqlinit();
        vis=new int[data.size()];
    }


    private void button3(ActionEvent e) {
        // TODO add your code here
        if(tempnum>=0) {

            String tempanswer="";
            if(radioButton1.isSelected()||radioButton2.isSelected()||radioButton3.isSelected()||radioButton4.isSelected())
            {
                if(radioButton1.isSelected())
                    tempanswer="A";
                else if(radioButton2.isSelected())
                    tempanswer="B";
                else if(radioButton3.isSelected())
                   tempanswer="C";
                else if(radioButton4.isSelected())
                    tempanswer="D";
                if(answer.equals(tempanswer))
                    tempscore+=5;
            }
            this.dispose();
            GUI_Student.visited[0] = 1;
            GUI_Student.problemnum[0] = tempnum;
            GUI_Student.score[0]=tempscore;
            JOptionPane.showMessageDialog(null, "选择题已作答完毕，获得分数为"+tempscore+"分！", "选择题确认题目数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "未确定题目数时不能进行提交操作！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        String temp=textField1.getText();
        if(tempnum<=-1) {
            if (Main.isNumeric(temp)) {
                if(Integer.parseInt(temp)<=data.size()) {
                    JOptionPane.showMessageDialog(null, "选择题目数已确定！", "选择题确认题目数", JOptionPane.PLAIN_MESSAGE);
                    tempnum = Integer.parseInt(temp);
                }
                else{
                    JOptionPane.showMessageDialog(null, "题目数应小于选择题题目数"+data.size()+"!", "警告", JOptionPane.ERROR_MESSAGE);
                    textField1.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "题目数应为数字！", "警告", JOptionPane.ERROR_MESSAGE);
                textField1.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "当前题目数已确定,若想重新确定答题数需关闭选择题答题界面(不可提交)！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        if(tempnum<=-1){
            JOptionPane.showMessageDialog(null, "题目数未确定,请先确定题目数！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else if(tempnum==0) {
            JOptionPane.showMessageDialog(null, "题目数为0，不会显示题目！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else{
            tot++;
            Random rand=new Random();
            int num=rand.nextInt(data.size());
            vis[num]=1;
            label4.setText("第"+tot+"题/共"+tempnum+"题");
            textArea1.setText(data.get(num).getDescription());
            textArea2.setText(data.get(num).getSelect_A());
            textArea3.setText(data.get(num).getSelect_B());
            textArea4.setText(data.get(num).getSelect_C());
            textArea5.setText(data.get(num).getSelect_D());
            answer=data.get(num).getAnswer();
            textField2.setText("选择题分数："+tempscore+"分");
            JOptionPane.showMessageDialog(null, "选择题已生成，请开始答题！", "选择题开始答题", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(tot==tempnum)
        {
            JOptionPane.showMessageDialog(null, "当前为最后一题，无法跳转下一题!", "警告", JOptionPane.ERROR_MESSAGE);

        }
        else {
            if (radioButton1.isSelected() || radioButton2.isSelected() || radioButton3.isSelected() || radioButton4.isSelected()) {
                String tempanswer="";
                if(radioButton1.isSelected())
                    tempanswer="A";
                else if(radioButton2.isSelected())
                    tempanswer="B";
                else if(radioButton3.isSelected())
                    tempanswer="C";
                else if(radioButton4.isSelected())
                    tempanswer="D";
                if(answer.equals(tempanswer))
                {
                    textField3.setText("上一题回答正确！");
                    tempscore+=5;
                    textField2.setText("选择题分数："+tempscore+"分");
                }
                else{
                    textField3.setText("上一题回答错误！");
                }
                tot++;
                Random rand=new Random();
                int num;
                while(true)
                {
                    num=rand.nextInt(data.size());
                    if(vis[num]==0)
                        break;
                }
                vis[num]=1;
                buttonGroup1.clearSelection();
                label4.setText("第"+tot+"题/共"+tempnum+"题");
                textArea1.setText(data.get(num).getDescription());
                textArea2.setText(data.get(num).getSelect_A());
                textArea3.setText(data.get(num).getSelect_B());
                textArea4.setText(data.get(num).getSelect_C());
                textArea5.setText(data.get(num).getSelect_D());
                answer=data.get(num).getAnswer();
                JOptionPane.showMessageDialog(null, "下一题已生成，请开始答题！", "选择题下一题", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "当前选择题未进行选择，无法跳入下一题!", "警告", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        panel1 = new JPanel();
        label4 = new JLabel();
        button1 = new JButton();
        textArea1 = new JTextArea();
        radioButton1 = new JRadioButton();
        textArea2 = new JTextArea();
        radioButton2 = new JRadioButton();
        textArea3 = new JTextArea();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        textArea4 = new JTextArea();
        textArea5 = new JTextArea();
        buttonGroup1 = new ButtonGroup();

        //======== this ========
        setTitle(bundle.getString("this.title_7"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_10"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(200, 15, 275, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_14"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.red);
        contentPane.add(label2);
        label2.setBounds(25, 49, 80, 36);

        //---- textField1 ----
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.blue);
        contentPane.add(textField1);
        textField1.setBounds(95, 49, 105, 36);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_20"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(205, 49, 115, 36);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_15"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(530, 360, 100, 36);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_12"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(345, 50, 100, 36);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_11"));
        label3.setFont(new Font("sansserif", Font.BOLD, 16));
        label3.setForeground(Color.red);
        contentPane.add(label3);
        label3.setBounds(25, 360, label3.getPreferredSize().width, 36);

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setForeground(Color.green);
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField2);
        textField2.setBounds(110, 360, 195, 36);

        //---- textField3 ----
        textField3.setFont(new Font("sansserif", Font.BOLD, 14));
        textField3.setForeground(Color.black);
        contentPane.add(textField3);
        textField3.setBounds(315, 360, 195, 35);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x99ffff));
            panel1.setLayout(null);

            //---- label4 ----
            label4.setFont(new Font("sansserif", Font.BOLD, 14));
            label4.setForeground(Color.black);
            label4.setBackground(new Color(0x9999ff));
            panel1.add(label4);
            label4.setBounds(15, 10, 120, 30);

            //---- button1 ----
            button1.setText(bundle.getString("button1.text_6"));
            button1.addActionListener(e -> button1(e));
            panel1.add(button1);
            button1.setBounds(525, 15, 100, 36);

            //---- textArea1 ----
            textArea1.setEditable(false);
            textArea1.setLineWrap(true);
            textArea1.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea1.setForeground(Color.magenta);
            panel1.add(textArea1);
            textArea1.setBounds(15, 55, 610, 80);

            //---- radioButton1 ----
            radioButton1.setText(bundle.getString("radioButton1.text_6"));
            panel1.add(radioButton1);
            radioButton1.setBounds(new Rectangle(new Point(20, 150), radioButton1.getPreferredSize()));

            //---- textArea2 ----
            textArea2.setEditable(false);
            textArea2.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea2.setForeground(Color.red);
            textArea2.setLineWrap(true);
            panel1.add(textArea2);
            textArea2.setBounds(55, 150, textArea2.getPreferredSize().width, 90);

            //---- radioButton2 ----
            radioButton2.setText(bundle.getString("radioButton2.text_6"));
            panel1.add(radioButton2);
            radioButton2.setBounds(new Rectangle(new Point(170, 150), radioButton2.getPreferredSize()));

            //---- textArea3 ----
            textArea3.setEditable(false);
            textArea3.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea3.setForeground(Color.red);
            textArea3.setLineWrap(true);
            panel1.add(textArea3);
            textArea3.setBounds(205, 150, textArea3.getPreferredSize().width, 90);

            //---- radioButton3 ----
            radioButton3.setText(bundle.getString("radioButton3.text_4"));
            panel1.add(radioButton3);
            radioButton3.setBounds(new Rectangle(new Point(325, 150), radioButton3.getPreferredSize()));

            //---- radioButton4 ----
            radioButton4.setText(bundle.getString("radioButton4.text_4"));
            panel1.add(radioButton4);
            radioButton4.setBounds(new Rectangle(new Point(475, 150), radioButton4.getPreferredSize()));

            //---- textArea4 ----
            textArea4.setEditable(false);
            textArea4.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea4.setForeground(Color.red);
            textArea4.setLineWrap(true);
            panel1.add(textArea4);
            textArea4.setBounds(360, 150, textArea4.getPreferredSize().width, 90);

            //---- textArea5 ----
            textArea5.setEditable(false);
            textArea5.setFont(new Font("sansserif", Font.BOLD, 14));
            textArea5.setForeground(Color.red);
            textArea5.setLineWrap(true);
            panel1.add(textArea5);
            textArea5.setBounds(510, 150, textArea5.getPreferredSize().width, 90);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 90, 650, 260);

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
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel panel1;
    private JLabel label4;
    private JButton button1;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JTextArea textArea2;
    private JRadioButton radioButton2;
    private JTextArea textArea3;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JTextArea textArea4;
    private JTextArea textArea5;
    public ButtonGroup buttonGroup1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
