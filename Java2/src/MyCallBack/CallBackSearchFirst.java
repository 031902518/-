package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CallBackSearchFirst implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTable table;
    public CallBackSearchFirst(ArrayList<myThing> arrayList,JTable jTable){
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
            vRow.add(arrayList.get(0).no);
            vRow.add(arrayList.get(0).name);
            vRow.add(arrayList.get(0).price);
            vRow.add(arrayList.get(0).number);
            vData.add(vRow.clone());
            DefaultTableModel model=new DefaultTableModel(vData,vName);
            table.setModel(model);
    }
}
