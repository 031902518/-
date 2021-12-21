package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class CallBackSearch implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTextField NO;
    public JTable table;
    public CallBackSearch(ArrayList<myThing> arrayList, JTextField NO,JTable jTable){
        this.arrayList=arrayList;
        this.NO=NO;
        this.table=jTable;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=NO.getText();
        NO.setText(null);
        int intno = Integer.parseInt(str);
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).no==intno){
                Vector vData =new Vector();
                Vector vName=new Vector();
                vName.add("ID");
                vName.add("商品名称");
                vName.add("商品单价");
                vName.add("商品数量");
                Vector vRow=new Vector();
                vRow.add(arrayList.get(i).no);
                vRow.add(arrayList.get(i).name);
                vRow.add(arrayList.get(i).price);
                vRow.add(arrayList.get(i).number);
                vData.add(vRow.clone());
                DefaultTableModel model=new DefaultTableModel(vData,vName);
                table.setModel(model);
                break;
            }


        }
    }
}
