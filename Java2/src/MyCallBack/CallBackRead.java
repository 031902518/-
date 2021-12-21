package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class CallBackRead implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTable jTable;
    public CallBackRead(ArrayList<myThing> a,JTable j){
        this.arrayList=a;
        this.jTable=j;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        File file=new File("D:\\example\\Java2\\src\\MyCallBack\\data.txt");
        try {
            String string =null;
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            int flag=0;
            myThing asd=new myThing();
            Vector vData =new Vector();
            Vector vName=new Vector();
            vName.add("ID");
            vName.add("商品名称");
            vName.add("商品单价");
            vName.add("商品数量");
            Vector vRow=new Vector();
            while((string=br.readLine())!=null){
                if(flag%4==0){
                    int myno=Integer.parseInt(string);
                    asd.no=myno;
                }
                else if(flag%4==1){
                    asd.name=string;
                }
                else if(flag%4==2){
                    Double myprice=Double.parseDouble(string);
                    asd.price=myprice;
                }
                else if(flag%4==3){
                    Double mynumber=Double.parseDouble(string);
                    asd.number=mynumber;
                    arrayList.add(asd);
                    vRow.add(asd.no);
                    vRow.add(asd.name);
                    vRow.add(asd.price);
                    vRow.add(asd.number);
                    vData.add(vRow.clone());
                    vRow.clear();
                    System.out.println(asd.no+" "+asd.name+" "+asd.price+" "+asd.number);
                }
                flag++;
            }
            br.close();
            fr.close();
            DefaultTableModel model=new DefaultTableModel(vData,vName);
            jTable.setModel(model);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
