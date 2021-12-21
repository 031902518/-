package JavaGUI;

import 回调函数.CallBackInsert;
import 回调函数.CallBackSearch;
import 回调函数.CallBackSort;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class MainInit extends JFrame {
    public HashMap<Integer, Integer> hasMap;
    public HashSet<Integer> hashSet;
    public ArrayList<Integer> arrayList;
     public MainInit(HashMap<Integer, Integer> hasMap, HashSet<Integer> hashSet, ArrayList<Integer> arrayList){
         this.hashSet=hashSet;
         this.hasMap=hasMap;
         this.arrayList=arrayList;
     }

    public void Init(){
        Object name[]={"sno","grade"};
        Object a[][]=new Object[1][2];
        //插入成绩栏目
        Container container =this.getContentPane();//容器，放东西
        JTabbedPane tabP =new JTabbedPane();

        Panel panel=new Panel();
            panel.setLayout(null);
        JLabel label = new JLabel("学生学号");
        label.setBounds(150,5,50,20);
        TextField mysno=new TextField(10);
        mysno.setBounds(230,5,100,20);
        panel.add(label);
        panel.add(mysno);

        JLabel label2 = new JLabel("学生成绩");
        label2.setBounds(150,35,50,20);
        TextField mygrade=new TextField(10);
        mygrade.setBounds(230,35,100,20);
        panel.add(label2);
        panel.add(mygrade);

        Button button=new Button("insert");
        button.setBounds(350,28,50,20);
        CallBackInsert myInsert=new CallBackInsert(hasMap,hashSet,arrayList,mysno,mygrade);
        button.addActionListener(myInsert);
        panel.add(button);
        container.add(tabP);
        tabP.add("插入成绩", panel);



        //成绩查询栏目
        Panel panel1=new Panel();
        panel1.setLayout(null);
        JLabel jLabel=new JLabel("查询成绩，请输入学生学号");
        jLabel.setBounds(80,5,150,20);
        TextField textField=new TextField(10);
        textField.setBounds(250,5,100,20);
        JTable jTable=new JTable(a,name);
        jTable.setBounds(100,50,300,150);

        Button button1=new Button("search");
        button1.setBounds(380,5,50,20);
        CallBackSearch mySearch=new CallBackSearch(hasMap,hashSet,arrayList,textField,jTable);
        button1.addActionListener(mySearch);
        panel1.add(jLabel);
        panel1.add(textField);
        panel1.add(jTable);
        panel1.add(button1);
        tabP.add("成绩查询",panel1);
        container.add(tabP);

        //成绩排序
        Panel panel2=new Panel();
        panel2.setLayout(null);
        JLabel jLabel1=new JLabel("点击排序");
        jLabel1.setBounds(130,5,90,20);
        Button button2=new Button("sort");
        JTable jTable1=new JTable(a,name);
        jTable1.setBounds(100,50,300,150);

        button2.setBounds(230,5,50,20);
        CallBackSort sort=new CallBackSort(hasMap,hashSet,arrayList,jTable1);
        button2.addActionListener(sort);
        panel2.add(jLabel1);
        panel2.add(button2);
        panel2.add(jTable1);
        tabP.add("成绩排序",panel2);
        container.add(tabP);

        setResizable(false);
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}