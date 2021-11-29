package StudentDatabase;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Student {


    //连接数据库
    public Connection stu_connect(){
        Connection c = null;
        Statement stmt = null;
        try {
            //连接数据库
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://119.3.249.134:26000/postgres","wjm","wjm886652@");
            c.setAutoCommit(false);
            System.out.println("连接数据库成功！");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("连接数据库失败");
            System.exit(0);
        }
        return c;
    }


  //插入数据
    public void stu_insert(Connection c,String sno,String sname,String sex,String age,String sdept){
        try {
            Statement stmt = null;
            stmt = c.createStatement();
//            String sno,sname,sex,age,sdept;
//            Scanner str = new Scanner(System.in);
//           System.out.println("请输入新增同学的学号：");sno=str.next(); //   12316
//            System.out.println("请输入新增同学的名字：");sname=str.next();//  '王佳明'
//            System.out.println("请输入新增同学的性别：");sex=str.next();//   ’男‘
//            System.out.println("请输入新增同学的年龄：");age=str.next();//   '20'
//            System.out.println("请输入新增同学的学院：");sdept=str.next();//  '计算机学院'
            String sql = "INSERT INTO student (sno,sname,ssex,sage,sdept) "
					+ "VALUES('"+sno+ "','"  +sname+   "','"  +sex+  "','"   +age+  "','"  +sdept+  "');";

            stmt.executeUpdate(sql);
            c.commit();
            System.out.println("新增数据成功！");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("插入错误");
            System.exit(0);
        }
    }

    //更新数据
    public void stu_update(Connection c,String sql){
        try {
            Statement stmt = null;
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.commit();
            System.out.println("更新数据成功！");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("更新错误");
            System.exit(0);
        }
    }

    //删除数据
    public void stu_delete(Connection c,String sql){
        try {
            Statement stmt = null;
            stmt = c.createStatement();
            System.out.println("请输入删除信息的学生学号：");
            stmt.executeUpdate(sql);
            c.commit();
            System.out.println("删除数据成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("删除错误");
            System.exit(0);
        }
    }


    //查询数据
    public void stu_search(Connection c, JTextArea tex){

        try {
            Statement stmt = null;
            stmt = c.createStatement();
            String sql="select * from student ;";
            ResultSet rs = stmt.executeQuery(sql);
            tex.setText("");
            while(rs.next()){
                String sno = rs.getString("Sno");
                String sname = rs.getString("sname");
                String sex = rs.getString("ssex");
                int sage = rs.getInt("sage");
                String sdept = rs.getString("sdept");
                tex.append("\n"+"学号:"+sno+"姓名:"+sname+"性别:"+sex+"年龄:"+sage+"学院:"+sdept);
                System.out.println("学号："+sno+"姓名:"+sname+"性别："+sex+"年龄："+sage+"学院："+sdept);
            }
            System.out.println("查询数据成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("查询错误");
            System.exit(0);
        }
    }
}
