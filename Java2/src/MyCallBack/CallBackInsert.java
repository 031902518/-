package MyCallBack;

import MyThing.myThing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CallBackInsert implements ActionListener {
    public ArrayList<myThing> arrayList;
    public JTextField name;
    public JTextField price;
    public JTextField num;
    public static int no=0;
    public CallBackInsert(ArrayList<myThing> arrayList,JTextField name,JTextField price,JTextField num){
        this.arrayList=arrayList;
        this.name=name;
        this.price=price;
        this.num=num;
    }
    public void actionPerformed(ActionEvent e){
        String str=name.getText();
        String myname=str;
        str=price.getText();
        double myprice=Double.parseDouble(str);
        str=num.getText();
        int mynum=Integer.parseInt(str);
        myThing mything=new myThing();
        mything.name=myname;
        mything.price=myprice;
        mything.number=mynum;
        no++;
        mything.no=this.no;
        arrayList.add(mything);
        System.out.println(mything.no+"   "+mything.name+"   "+mything.price+"   "+mything.number);
        name.setText(null);
        price.setText(null);
        num.setText(null);
    }

}
