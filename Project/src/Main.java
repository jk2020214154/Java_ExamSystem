import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Create with IntelliJ IDEA.
 * Description:
 * User: SDTBU_LY
 * Date: 2022-12-09
 * Time: 9:52
 */
public class Main {
    public static void main(String[] args) {
        new GUI_Login().setVisible(true);

    }
    public static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

}


class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer {
    public TableCellTextAreaRenderer()
    {
        //将表格设为自动换行
        setLineWrap(true); //利用JTextArea的自动换行方法
        setWrapStyleWord(true);

    }
    public Component getTableCellRendererComponent(JTable jtable, Object obj, //obj指的是单元格内容
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (row % 2 == 0)
            setBackground(Color.ORANGE);
        else if (row % 2 == 1)
            setBackground(Color.white);
        setText(obj == null ? "" : obj.toString()); //利用JTextArea的setText设置文本方法
        return this;
    }
}
