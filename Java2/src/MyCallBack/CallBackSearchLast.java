package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CallBackSearchLast implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTable table;
    public CallBackSearchLast(ArrayList<myThing> arrayList,JTable jTable){
        this.arrayList=arrayList;
        this.table=jTable;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Vector vData =new Vector();
        Vector vName=new Vector();
        vName.add("ID");
        vName.add("商品名称");
        vName.add("商品单价");
        vName.add("商品数量");
        Vector vRow=new Vector();
        myThing myThing=new myThing();
        myThing=arrayList.get(arrayList.size()-1);
        vRow.add(myThing.no);
        vRow.add(myThing.name);
        vRow.add(myThing.price);
        vRow.add(myThing.number);
        vData.add(vRow.clone());
        DefaultTableModel model=new DefaultTableModel(vData,vName);
        table.setModel(model);
    }
}
