package StudentDatabase;//  MyTry
import javax.swing.*;
import java.awt.*;
public class MyTry extends JFrame {
    public MyTry() {
        Container container = this.getContentPane();
        //文本域
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText("换统一阿文阿文啊额奖学金王佳明");
        //Scroll面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);
        this.setVisible(true);
        this.setBounds(100, 100, 300, 350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyTry();
    }
}