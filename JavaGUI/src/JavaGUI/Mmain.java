package JavaGUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Mmain  {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList =new ArrayList<>();
        HashSet<Integer> hasset=new HashSet<>();
        HashMap<Integer,Integer> hasmap=new HashMap<>();
        MainInit init =new MainInit(hasmap,hasset,arrayList);
        init.Init();
    }
}
