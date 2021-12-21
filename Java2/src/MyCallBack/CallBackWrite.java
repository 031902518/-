package MyCallBack;

import MyThing.myThing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CallBackWrite implements ActionListener {
    public ArrayList<myThing> arrayList;
    public CallBackWrite(ArrayList<myThing> a){
        this.arrayList=a;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        File file=new File("D:\\example\\Java2\\src\\MyCallBack\\data.txt");
        try {
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            for(int i=0;i<arrayList.size();i++){
                bw.write(String.valueOf(arrayList.get(i).no));
                bw.newLine();
                bw.write(String.valueOf(arrayList.get(i).name));
                bw.newLine();
                bw.write(String.valueOf(arrayList.get(i).price));
                bw.newLine();
                bw.write(String.valueOf(arrayList.get(i).number));
                bw.newLine();
                System.out.println(arrayList.get(i).no+" "+arrayList.get(i).name
                        +" "+arrayList.get(i).price+" "+arrayList.get(i).number);
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
