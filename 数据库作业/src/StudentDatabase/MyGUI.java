package StudentDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MyGUI extends JFrame {
        public void Init(boolean vis){
                Container container =this.getContentPane();//容器，放东西

                //定义变量
                JButton button1=new JButton("插入");
                JButton button2=new JButton("修改");
                JButton button3=new JButton("删除");
                JButton button4=new JButton("查询");
                JTextArea textArea = new JTextArea(20, 50);
                textArea.setText("默认输出框");
                //Scroll面板
                JScrollPane scrollPane = new JScrollPane(textArea);

                //添加
                container.setLayout(null);
                button1.setBounds(20,0,80,40);
                button2.setBounds(120,0,80,40);
                button3.setBounds(220,0,80,40);
                button4.setBounds(320,0,80,40);
                scrollPane.setBounds(50,50,400,300);

                container.add(scrollPane);
                container.add(button1);
                container.add(button2);
                container.add(button3);
                container.add(button4);


                this.setVisible(vis);
                this.setSize(500,500);
                this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                Button1Listener b1=new Button1Listener(textArea);
                button1.addActionListener(b1);

                Button2Listener b2=new Button2Listener(textArea);
                button2.addActionListener(b2);


                Button3Listener b3=new Button3Listener(textArea);
                button3.addActionListener(b3);

                Button4Listener b4=new Button4Listener(textArea);
                button4.addActionListener(b4);
        }

}
class Button1Listener implements ActionListener {
        public  JTextArea tex;
        public Button1Listener( JTextArea textArea){
                this.tex=textArea;
        }
        public void actionPerformed(ActionEvent e){
                new Myinsert(tex);
        }

}

class Button2Listener implements  ActionListener{
        public JTextArea tex;
        public Button2Listener( JTextArea textArea){
                this.tex=textArea;
        }
        public void actionPerformed(ActionEvent e){
                new Myupdate(tex);
        }
}
class Button3Listener implements  ActionListener{
        public  JTextArea tex;
        public Button3Listener( JTextArea textArea){
                this.tex=textArea;
        }
        public void actionPerformed(ActionEvent e){
                new Mydelete(tex);
        }

}
class Button4Listener implements  ActionListener{
        public  JTextArea tex;
        public Button4Listener( JTextArea textArea){
                this.tex=textArea;
        }
        public void actionPerformed(ActionEvent e){
                Student stud=new Student();
                Connection c=stud.stu_connect();
               stud.stu_search(c,tex);
        }
}