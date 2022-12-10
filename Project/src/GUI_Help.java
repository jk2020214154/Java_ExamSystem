import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 13:38:26 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_Help extends JDialog {
    public GUI_Help(Window owner) {
        super(owner);
        GUI_Login.GUIflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Login.GUIflag=0;
            }
        });
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Login.GUIflag=0;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setTitle("\u7cfb\u7edf\u5e2e\u52a9(\u4f5c\u8005:SDTBU_LY)");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_2"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(new Color(0xff5d00));
        contentPane.add(label1);
        label1.setBounds(40, 25, 325, 85);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(170, 120, 65, 30);

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
        setSize(400, 212);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
