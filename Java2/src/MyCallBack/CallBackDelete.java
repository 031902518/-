package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CallBackDelete implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTable table;
    public CallBackDelete(ArrayList<myThing> arrayList,JTable jTable){
        this.arrayList=arrayList;
        this.table=jTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel defaultModel = (DefaultTableModel) table.getModel();
//        int rowCount=defaultModel.getRowCount()-1;
        int  w=table.getSelectedRow();
        System.out.println(w+"<——删除的");
        arrayList.remove(w);
        for(int i=0;i<arrayList.size();i++){
            arrayList.get(i).no=i+1;
        }
        CallBackInsert.no--;
        ////
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
        table.setModel(model);
        table.revalidate();//最后这一个方法一定不要忘记，否则可能导致表格内容没有更新。
    }
}
