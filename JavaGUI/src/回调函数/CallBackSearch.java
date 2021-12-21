package 回调函数;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CallBackSearch implements ActionListener {
    public HashMap<Integer, Integer> hasMap;
    public HashSet<Integer> hashSet;
    public ArrayList<Integer> arrayList;
    public TextField sno;
    public JTable jTable;
    public CallBackSearch(HashMap<Integer, Integer> hasMap, HashSet<Integer> hashSet,
                          ArrayList<Integer> arrayList,TextField sno,JTable j){
        this.hashSet=hashSet;
        this.hasMap=hasMap;
        this.arrayList=arrayList;
        this.sno=sno;
        this.jTable=j;
    }
    public void actionPerformed(ActionEvent e){
        String stringsno=sno.getText();
        int intsno=Integer.parseInt(stringsno);
        ///////////////////////////////////////////////////
        Vector vData =new Vector();
        Vector vName=new Vector();
        vName.add("sno");
        vName.add("grade");
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i)==intsno){
                Vector vRow=new Vector();
                vRow.add(arrayList.get(i));
                vRow.add(hasMap.get(arrayList.get(i)));
                vData.add(vRow.clone());
                break;
            }
        }
        DefaultTableModel model=new DefaultTableModel(vData,vName);
        jTable.setModel(model);
    }
}
