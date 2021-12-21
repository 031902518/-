package Mmain;

import MyCallBack.*;
import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

public class MyInitSearch extends JFrame{
    public ArrayList<myThing> arrayList;
    public MyInitSearch(ArrayList<myThing> arrayList){
        this.arrayList=arrayList;
    }
    public void InitSearch(boolean vis){
        Container container =this.getContentPane();//容器，放东西
        JPanel jPanel=new JPanel();
        JPanel  jPanel1=new JPanel();

        Object name[]={"ID","商品名称","商品单价","商品数量"};
        Object a[][]=new Object[1][4];
        JTable jTable=new JTable(a,name);

        JButton jButton=new JButton("删除");
        JButton jButton1=new JButton("查询");
        JTextField jTextField=new JTextField(10);
        jPanel1.add(jTextField);
        jPanel1.add(jButton1);
        jPanel1.add(jButton);

        JButton jButton2=new JButton("清空");
        JButton jButton3=new JButton("第一个购买的商品");
        JButton jButton4=new JButton("最后一个购买的商品");
        JButton jButton5=new JButton("导入到文件");
        JButton jButton6=new JButton("从文件导出");

        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);
        container.add(jPanel,BorderLayout.SOUTH);
        container.add(jPanel1,BorderLayout.NORTH);
        container.add(new JScrollPane(jTable),BorderLayout.CENTER);
        this.pack();
        this.setSize(600,500);
        setResizable(true);
        this.setVisible(vis);


        //初始化表格
        Vector vData =new Vector();
        Vector vName=new Vector();
        vName.add("ID");
        vName.add("商品名称");
        vName.add("商品单价");
        vName.add("商品数量");
        for(int i=0;i<arrayList.size();i++){
            Vector vRow=new Vector();
            vRow.add(arrayList.get(i).no);
            vRow.add(arrayList.get(i).name);
            vRow.add(arrayList.get(i).price);
            vRow.add(arrayList.get(i).number);
            vData.add(vRow.clone());
        }
        DefaultTableModel model=new DefaultTableModel(vData,vName);
        jTable.setModel(model);


        //给按钮添加回调函数
        CallBackSearch callBackSearch=new CallBackSearch(this.arrayList,jTextField,jTable);
        jButton1.addActionListener(callBackSearch);

        CallBackSearchFirst callBackSearchFirst =new CallBackSearchFirst(this.arrayList,jTable);
        jButton3.addActionListener(callBackSearchFirst);

        CallBackSearchLast callBackSearchLast=new CallBackSearchLast(this.arrayList,jTable);
        jButton4.addActionListener(callBackSearchLast);

        CallBackEmpty callBackEmpty=new CallBackEmpty(this.arrayList,jTable);
        jButton2.addActionListener(callBackEmpty);

        CallBackDelete callBackDelete=new CallBackDelete(this.arrayList,jTable);
        jButton.addActionListener(callBackDelete);

        CallBackWrite callBackWrite=new CallBackWrite(this.arrayList);
        jButton5.addActionListener(callBackWrite);

        CallBackRead callBackRead=new CallBackRead(this.arrayList,jTable);
        jButton6.addActionListener(callBackRead);
    }
    protected void processWindowEvent(WindowEvent e)
    {
        //这里需要对进来的WindowEvent进行判断，因为，不仅会有窗口关闭的WindowEvent进来，还可能有其他的WindowEvent进来
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
        {
            int option = JOptionPane.showConfirmDialog(null, "是否返回上一级程序？", "程序返回提示", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                MyInitInsert mainInit=new MyInitInsert(arrayList);
                mainInit.InitInsert(true);
                this.setVisible(false);
            }
            else {
                //用户选择不退出本程序，因此可以继续留在本窗口
            }
        }
    }
}
