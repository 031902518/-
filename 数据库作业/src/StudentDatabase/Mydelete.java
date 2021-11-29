package StudentDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Mydelete extends JFrame {
    public Mydelete(JTextArea textArea){
        textArea.setText("请输入你需要删除的数据，所具备的条件");
        Label label1= new Label("sno");
               label1.setSize(20,10);
        Label label2= new Label("sname");
              label2.setSize(20,10);
        Label label3= new Label("sex");
              label3.setSize(20,10);
        Label label4= new Label("sage");
               label4.setSize(20,10);
        Label label5= new Label("sdept");
               label5.setSize(20,10);
        TextField mysno=new TextField(10);
        TextField mysname=new TextField(10);
        TextField mysex=new TextField(10);
        TextField myage=new TextField(10);
        TextField mysdept=new TextField(10);
        Button button=new Button("certain");
        button.addActionListener(new DeleteListener(textArea,mysno,mysname,mysex,myage,mysdept));
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


    class DeleteListener implements ActionListener {
        public TextField my_sno,my_sname,my_sex,my_age,my_sdept;
        public JTextArea textArea;
        public DeleteListener(JTextArea textArea,TextField sno,TextField sname,TextField sex,TextField age,TextField sdept){
            this.textArea=textArea;
            my_sno=sno;
            my_sname=sname;
            my_sex=sex;
            my_age=age;
            my_sdept=sdept;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Student stu=new Student();
            Connection c=stu.stu_connect();
            String sql="delete from student where ";
            if(!my_sno.getText().isEmpty()){//学号
                sql=sql+"sno='"+my_sno.getText()+"'";
            }
            if(sql!=null&&!my_sname.getText().isEmpty()){
                sql=sql+" and ";
            }
            if(!my_sname.getText().isEmpty()){//姓名
                sql=sql+"sname='"+my_sname.getText()+"'";
            }
            if(sql!=null&&!my_sex.getText().isEmpty()){
                sql=sql+" and ";
            }
            if(!my_sex.getText().isEmpty()){//性别
                sql=sql+"ssex='"+my_sex.getText()+"'";
            }
            if(sql!=null&&!my_age.getText().isEmpty()){
                sql=sql+" and ";
            }
            if(!my_age.getText().isEmpty()){//年龄
                sql=sql+"sage='"+my_age.getText()+"'";
            }
            if(sql!=null&&!my_sdept.getText().isEmpty()){
                sql=sql+" and ";
            }
            if(!my_sdept.getText().isEmpty()){//学院
                sql=sql+"sdept='"+my_sdept.getText()+"'";
            }
            sql=sql+";";
            System.out.println(sql);
            System.out.println(sql);
            stu.stu_delete(c,sql);
            //num3显示
            textArea.setText("删除成功");
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
