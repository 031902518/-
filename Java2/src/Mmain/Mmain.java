package Mmain;

import MyThing.myThing;

import javax.swing.*;
import java.util.ArrayList;

public class Mmain extends JFrame {

    public static void main(String[] args) {
        ArrayList<myThing> arrayList =new ArrayList<>();
        MyInitInsert mainInit=new MyInitInsert(arrayList);
        mainInit.InitInsert(true);
    }
}
