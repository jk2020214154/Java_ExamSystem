import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 16:11:48 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Student extends JFrame {
    public static int visited[]=new int[3];
    public static int score[]=new int[3];
    public static int problemnum[]=new int[3];
    public GUI_Student() {
        initComponents();
        textField2.setText(" "+GUI_Login.username);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Date date = new Date();
                    textField1.setText(" "+date.toString());
                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }






    private void button5(ActionEvent e) {
        // TODO add your code here
        new GUI_StuHelp(this).setVisible(true);
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
    }

    private void menuItem9(ActionEvent e) {
        // TODO add your code here
            JOptionPane.showMessageDialog(null, "在线考试系统退出成功！", "退出系统", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
    }
    private void menuItem8(ActionEvent e) {
        // TODO add your code here
            this.dispose();
            JOptionPane.showMessageDialog(null, "学生端注销登录成功！", "注销登录", JOptionPane.PLAIN_MESSAGE);
            new GUI_Login().setVisible(true);
    }

    private void menuItem1(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==0)
            new GUI_StuSelect(this).setVisible(true);
        else{
            JOptionPane.showMessageDialog(null, "当前已完成选择题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem2(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==0)
            new GUI_StuJudge(this).setVisible(true);
        else if(visited[1]==1) {
            JOptionPane.showMessageDialog(null, "当前已完成判断题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else if(visited[1]==0){
            JOptionPane.showMessageDialog(null, "请先完成选择题后再进行判断题。", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem3(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==1&&visited[2]==0)
            new GUI_StuQuestion(this).setVisible(true);
        else if(visited[2]==1)
        {
            JOptionPane.showMessageDialog(null, "当前已完成简答题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else if(visited[2]==0)
        {
            JOptionPane.showMessageDialog(null, "请先完成选择题和判断题后再进行简答题。", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==1&&visited[2] == 1)
        {
            int res=score[0]+score[1]+score[2];
            int tot=5*(problemnum[0]+problemnum[1]+problemnum[2]);
            String temp="";
            temp="选择题："+score[0]+"分，判断题："+score[1]+"分，简答题："+score[2] + "分\n总分："+res+"分，题目总分："+tot+"分";
            JOptionPane.showMessageDialog(null, temp, "获取总分", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "请先完成所有题型后再获取总分！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==0)
            new GUI_StuSelect(this).setVisible(true);
        else{
            JOptionPane.showMessageDialog(null, "当前已完成选择题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==0)
            new GUI_StuJudge(this).setVisible(true);
        else if(visited[1]==1) {
            JOptionPane.showMessageDialog(null, "当前已完成判断题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else if(visited[1]==0){
            JOptionPane.showMessageDialog(null, "请先完成选择题后再进行判断题。", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button9(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==1&&visited[2]==0)
            new GUI_StuQuestion(this).setVisible(true);
        else if(visited[2]==1)
        {
            JOptionPane.showMessageDialog(null, "当前已完成简答题，不可再进行访问！", "警告", JOptionPane.ERROR_MESSAGE);
        }
        else if(visited[2]==0)
        {
            JOptionPane.showMessageDialog(null, "请先完成选择题和判断题后再进行简答题。", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem11(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1){
            JOptionPane.showMessageDialog(null, "选择题题目数："+problemnum[0]+"道", "选择题题目数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行选择题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void menuItem4(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1){
            JOptionPane.showMessageDialog(null, "选择题分数："+score[0]+"分", "选择题分数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行选择题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem12(ActionEvent e) {
        // TODO add your code here
        if(visited[1]==1){
            JOptionPane.showMessageDialog(null, "判断题题目数："+problemnum[1]+"道", "判断题题目数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行判断题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem5(ActionEvent e) {
        // TODO add your code here
        if(visited[1]==1){
            JOptionPane.showMessageDialog(null, "判断题分数："+score[1]+"分", "判断题分数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行判断题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem13(ActionEvent e) {
        // TODO add your code here
        if(visited[2]==1){
            JOptionPane.showMessageDialog(null, "简答题题目数："+problemnum[2]+"道", "简答题题目数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行简答题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem6(ActionEvent e) {
        // TODO add your code here
        if(visited[2]==1){
            JOptionPane.showMessageDialog(null, "简答题分数："+score[2]+"分", "简答题分数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "当前未进行简答题作答，无法展示结果！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem7(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==1&&visited[2] == 1)
        {
            int res=score[0]+score[1]+score[2];
            int tot=5*(problemnum[0]+problemnum[1]+problemnum[2]);
            String temp="";
            temp="选择题："+score[0]+"分，判断题："+score[1]+"分，简答题："+score[2] + "分\n总分："+res+"分，题目总分："+tot+"分";
            JOptionPane.showMessageDialog(null, temp, "获取总分", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "请先完成所有题型后再获取总分！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem14(ActionEvent e) {
        // TODO add your code here
        if(visited[0]==1&&visited[1]==1&&visited[2] == 1)
        {
            int res=problemnum[0]+problemnum[1]+problemnum[2];
            String temp="";
            temp="选择题："+problemnum[0]+"道，判断题："+problemnum[1]+"道，简答题："+problemnum[2] + "道\n总题数："+res+"道";
            JOptionPane.showMessageDialog(null, temp, "获取总题数", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "请先完成所有题型后再获取总题数！", "警告", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void menuItem10(ActionEvent e) {
        // TODO add your code here
        new GUI_StuHelp(this).setVisible(true);
    }






    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu4 = new JMenu();
        menuItem11 = new JMenuItem();
        menuItem12 = new JMenuItem();
        menuItem13 = new JMenuItem();
        menuItem14 = new JMenuItem();
        menu5 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu3 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem10 = new JMenuItem();
        menuItem9 = new JMenuItem();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button5 = new JButton();
        button4 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        button6 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        //======== this ========
        setTitle(bundle.getString("this.title_6"));
        setIconImage(new ImageIcon(getClass().getResource("/favicon.gif")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text_2"));

                //---- menuItem1 ----
                menuItem1.setText(bundle.getString("menuItem1.text_2"));
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText(bundle.getString("menuItem2.text_2"));
                menuItem2.addActionListener(e -> menuItem2(e));
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText(bundle.getString("menuItem3.text_2"));
                menuItem3.addActionListener(e -> menuItem3(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu4 ========
            {
                menu4.setText(bundle.getString("menu4.text"));

                //---- menuItem11 ----
                menuItem11.setText(bundle.getString("menuItem11.text"));
                menuItem11.addActionListener(e -> menuItem11(e));
                menu4.add(menuItem11);

                //---- menuItem12 ----
                menuItem12.setText(bundle.getString("menuItem12.text"));
                menuItem12.addActionListener(e -> menuItem12(e));
                menu4.add(menuItem12);

                //---- menuItem13 ----
                menuItem13.setText(bundle.getString("menuItem13.text"));
                menuItem13.addActionListener(e -> menuItem13(e));
                menu4.add(menuItem13);

                //---- menuItem14 ----
                menuItem14.setText(bundle.getString("menuItem14.text"));
                menuItem14.addActionListener(e -> menuItem14(e));
                menu4.add(menuItem14);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText(bundle.getString("menu5.text"));

                //---- menuItem4 ----
                menuItem4.setText(bundle.getString("menuItem4.text_2"));
                menuItem4.addActionListener(e -> menuItem4(e));
                menu5.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText(bundle.getString("menuItem5.text_2"));
                menuItem5.addActionListener(e -> menuItem5(e));
                menu5.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText(bundle.getString("menuItem6.text"));
                menuItem6.addActionListener(e -> menuItem6(e));
                menu5.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText(bundle.getString("menuItem7.text"));
                menuItem7.addActionListener(e -> menuItem7(e));
                menu5.add(menuItem7);
            }
            menuBar1.add(menu5);

            //======== menu3 ========
            {
                menu3.setText(bundle.getString("menu3.text"));

                //---- menuItem8 ----
                menuItem8.setText(bundle.getString("menuItem8.text"));
                menuItem8.addActionListener(e -> menuItem8(e));
                menu3.add(menuItem8);

                //---- menuItem10 ----
                menuItem10.setText(bundle.getString("menuItem10.text"));
                menuItem10.addActionListener(e -> menuItem10(e));
                menu3.add(menuItem10);

                //---- menuItem9 ----
                menuItem9.setText(bundle.getString("menuItem9.text"));
                menuItem9.addActionListener(e -> menuItem9(e));
                menu3.add(menuItem9);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_9"));
        label1.setFont(new Font("sansserif", Font.BOLD, 18));
        label1.setForeground(Color.magenta);
        contentPane.add(label1);
        label1.setBounds(150, 25, 275, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_3"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.setForeground(Color.black);
        contentPane.add(label2);
        label2.setBounds(126, 137, 95, 30);

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setBackground(Color.lightGray);
        textField1.setFont(new Font("sansserif", Font.BOLD, 14));
        textField1.setForeground(Color.white);
        contentPane.add(textField1);
        textField1.setBounds(211, 137, 220, 30);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text_2"));
        button5.addActionListener(e -> button5(e));
        contentPane.add(button5);
        button5.setBounds(441, 174, 100, button5.getPreferredSize().height);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_4"));
        button4.addActionListener(e -> {
			button4(e);
			button4(e);
		});
        contentPane.add(button4);
        button4.setBounds(441, 204, 100, button4.getPreferredSize().height);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_3"));
        label3.setBackground(new Color(0x99ff99));
        label3.setForeground(Color.red);
        label3.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label3);
        label3.setBounds(15, 196, label3.getPreferredSize().width, 26);

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setBackground(Color.lightGray);
        textField2.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(textField2);
        textField2.setBounds(120, 196, 105, 27);

        //---- button6 ----
        button6.setText(bundle.getString("button6.text"));
        button6.setFont(new Font("sansserif", Font.BOLD, 14));
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6);
        button6.setBounds(441, 110, 100, 35);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_8"));
        label4.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label4);
        label4.setBounds(155, 50, 305, 21);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_5"));
        label5.setFont(new Font("sansserif", Font.BOLD, 14));
        contentPane.add(label5);
        label5.setBounds(465, 70, 75, 30);

        //---- button7 ----
        button7.setText(bundle.getString("button7.text"));
        button7.setFont(new Font("sansserif", Font.BOLD, 16));
        button7.setForeground(Color.blue);
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7);
        button7.setBounds(135, 75, 85, 40);

        //---- button8 ----
        button8.setText(bundle.getString("button8.text"));
        button8.setFont(new Font("sansserif", Font.BOLD, 16));
        button8.setForeground(Color.blue);
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8);
        button8.setBounds(235, 75, 85, 40);

        //---- button9 ----
        button9.setText(bundle.getString("button9.text"));
        button9.setFont(new Font("sansserif", Font.BOLD, 16));
        button9.setForeground(Color.blue);
        button9.addActionListener(e -> button9(e));
        contentPane.add(button9);
        button9.setBounds(340, 75, 85, 40);

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
        setSize(562, 300);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu4;
    private JMenuItem menuItem11;
    private JMenuItem menuItem12;
    private JMenuItem menuItem13;
    private JMenuItem menuItem14;
    private JMenu menu5;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu3;
    private JMenuItem menuItem8;
    private JMenuItem menuItem10;
    private JMenuItem menuItem9;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button5;
    private JButton button4;
    private JLabel label3;
    private JTextField textField2;
    private JButton button6;
    private JLabel label4;
    private JLabel label5;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
