package StudentDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
public class Myupdate extends JFrame{
    public Myupdate(JTextArea textArea){
        textArea.setText("请输入你要修改的数据的学生学号:");
        Label label1= new Label("sno");
        label1.setSize(20,10);
        Label label2= new Label("name");
        label2.setSize(20,10);
        Label label3= new Label("sex");
        label3.setSize(20,10);
        Label label4= new Label("age");
        label4.setSize(20,10);
        Label label5= new Label("sdept");
        label5.setSize(20,10);
        TextField mysno=new TextField(10);
        TextField mysname=new TextField(10);
        TextField mysex=new TextField(10);
        TextField myage=new TextField(10);
        TextField mysdept=new TextField(10);
        Button button=new Button("certain");
        button.addActionListener(new UpdateListener(textArea,mysno,mysname,mysex,myage,mysdept));
        setLayout(new FlowLayout());
        add(label1);
        add(mysno);
        add(label2);
        add(mysname);
        add(label3);
        add(mysex);
        add(label4);
        add(myage);
        add(label5);
        add(mysdept);
        add(button);
        pack();
        setVisible(true);
    }

    class UpdateListener implements ActionListener{
        public TextField my_sno,my_sname,my_sex,my_age,my_sdept;
        public JTextArea textArea;
        public UpdateListener(JTextArea textArea,TextField sno,TextField sname,TextField sex,TextField age,TextField sdept){
            this.textArea=textArea;
            my_sno=sno;
            my_sname=sname;
            my_sex=sex;
            my_age=age;
            my_sdept=sdept;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql="update student set ";
            Student stu=new Student();
            Connection c=stu.stu_connect();
            if(!my_sname.getText().isEmpty()){//姓名
                sql=sql+"sname='"+my_sname.getText()+"'";
            }
            if(sql!=null&&!my_sex.getText().isEmpty()){
                sql=sql+",";
            }
            if(!my_sex.getText().isEmpty()){//性别
                sql=sql+"ssex='"+my_sex.getText()+"'";
            }
            if(sql!=null&&!my_age.getText().isEmpty()){
                sql=sql+",";
            }
            if(!my_age.getText().isEmpty()){//年龄
                sql=sql+"sage='"+my_age.getText()+"'";
            }
            if(sql!=null&&!my_sdept.getText().isEmpty()){
                sql=sql+",";
            }
            if(!my_sdept.getText().isEmpty()){//学院
                sql=sql+"sdept='"+my_sdept.getText()+"'";
            }
            sql=sql+" where sno='"+my_sno.getText()+"'";
            sql=sql+";";

            System.out.println(sql);
            stu.stu_update(c,sql);
            //num3显示
            textArea.setText("插入成功");
            //num3.setText(""+(n1+n2));
            //清除
            my_sno.setText("");
            my_sname.setText("");
            my_sex.setText("");
            my_age.setText("");
            my_sdept.setText("");
            setVisible(false);
        }
    }
}
