package MyCallBack;
import MyThing.myThing;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
public class CallBackEmpty implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTable table;
    public CallBackEmpty(ArrayList<myThing> arrayList,JTable jTable){
        this.arrayList=arrayList;
        this.table=jTable;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        arrayList.clear();
        Vector vData =new Vector();
        Vector vName=new Vector();
        vName.add("0");
        vName.add("全部清除");
        vName.add("0");
        vName.add("0");
        Vector vRow=new Vector();
        vRow.add("0");
        vRow.add("全部清除");
        vRow.add("0");
        vRow.add("0");
        vData.add(vRow.clone());
        DefaultTableModel model=new DefaultTableModel(vData,vName);
        table.setModel(model);
    }
}
