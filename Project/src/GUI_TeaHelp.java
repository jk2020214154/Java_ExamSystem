import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 10 14:33:58 CST 2022
 */



/**
 * @author Brainrain
 */
public class GUI_TeaHelp extends JDialog {
    public GUI_TeaHelp(Window owner) {
        super(owner);
        GUI_Teacher.GUI_Teacherflag=1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve){
                GUI_Teacher.GUI_Teacherflag=0;
            }
        });
        initComponents();
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

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_4"));
        label1.setForeground(new Color(0xef08a3));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        contentPane.add(label1);
        label1.setBounds(10, 0, 435, 95);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_4"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(190, 85, 60, 30);

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
        setSize(450, 162);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
