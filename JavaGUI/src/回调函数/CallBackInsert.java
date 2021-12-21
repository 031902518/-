package 回调函数;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CallBackInsert implements ActionListener{
    public HashMap<Integer, Integer> hasMap;
    public HashSet<Integer> hashSet;
    public ArrayList<Integer> arrayList;
    public TextField sno;
    public TextField grade;
    public CallBackInsert(HashMap<Integer, Integer> hasMap, HashSet<Integer> hashSet,
     ArrayList<Integer> arrayList,TextField sno,TextField grade){
        this.hashSet=hashSet;
        this.hasMap=hasMap;
        this.arrayList=arrayList;
        this.sno=sno;
        this.grade=grade;
    }

    public void actionPerformed(ActionEvent e){
           String stringsno=sno.getText();
           int intsno=Integer.parseInt(stringsno);
           String stringgrade=grade.getText();
           int intgrade=Integer.parseInt(stringgrade);
           hashSet.add(intsno);
           hasMap.put(intsno,intgrade);
        //遍历
            arrayList.add(intsno);
        for(int j=0;j<arrayList.size();j++){
            System.out.println(j+"   "+arrayList.get(j)+"     "+hasMap.get(arrayList.get(j)));
        }
        System.out.println("*******************************"+arrayList.size());
        Iterator<Map.Entry<Integer,Integer>> iterator =hasMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry =iterator.next();
            System.out.println("key="+entry.getKey()+"    val="+entry.getValue());
        }
        sno.setText(null);
        grade.setText(null);
    }



}
