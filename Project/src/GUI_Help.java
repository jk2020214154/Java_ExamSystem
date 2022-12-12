import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        GUI_Login.GUIflag = 1;
        addWindowListener(new WindowAdapter() {//设置关闭监视器
            public void windowClosing(WindowEvent eve) {
                GUI_Login.GUIflag = 0;
            }
        });
        initComponents();
        label2.setForeground(Color.yellow);
        label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label2.setToolTipText("https://github.com/jk2020214154/Java_ExamSystem");

    }
    private void button1(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        GUI_Login.GUIflag=0;
    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/jk2020214154/Java_ExamSystem"));
            }
            catch(IOException ey){
                System.out.println(ey.toString());
            }

        }
        catch (URISyntaxException ex) {
            System.out.println(ex.toString());
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Form");
        label1 = new JLabel();
        button1 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u7cfb\u7edf\u5e2e\u52a9(\u4f5c\u8005:SDTBU_LY)");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_2"));
        label1.setFont(new Font("sansserif", Font.BOLD, 16));
        label1.setForeground(new Color(0xff5d00));
        contentPane.add(label1);
        label1.setBounds(35, 5, 325, 85);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(170, 120, 65, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_4"));
        label2.setFont(new Font("sansserif", Font.BOLD, 16));
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label2MouseClicked(e);
            }
        });
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(110, 90), label2.getPreferredSize()));

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
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
