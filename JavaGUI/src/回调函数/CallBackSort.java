    package 回调函数;

    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.*;

    public class CallBackSort implements ActionListener {
        public HashMap<Integer, Integer> hasMap;
        public HashSet<Integer> hashSet;
        public ArrayList<Integer> arrayList;
        public JTable jTable;
        public CallBackSort(HashMap<Integer, Integer> hasMap, HashSet<Integer> hashSet,
                              ArrayList<Integer> arrayList,JTable jTable){
            this.hashSet=hashSet;
            this.hasMap=hasMap;
            this.arrayList=arrayList;
            this.jTable=jTable;
        }
        public void actionPerformed(ActionEvent e){
            for(int j=0;j<arrayList.size();j++){
                for(int k=j+1;k<arrayList.size();k++){
                    int tmpj= arrayList.get(j);
                    int tmpk=arrayList.get(k);
                    int tempj=hasMap.get(tmpj);
                    int tempk=hasMap.get(tmpk);
                    if(tempj<tempk){
                        arrayList.set(k, tmpj);
                        arrayList.set(j, tmpk);
                    }
                }
            }
            Vector vData =new Vector();
            Vector vName=new Vector();
            vName.add("学生学号");
            vName.add("成绩");
            for(int i=0;i<arrayList.size();i++){
                Vector vRow=new Vector();
                vRow.add(arrayList.get(i));
                vRow.add(hasMap.get(arrayList.get(i)));
                vData.add(vRow.clone());
            }
            DefaultTableModel model=new DefaultTableModel(vData,vName);
            jTable.setModel(model);
        }
    }
