package Mmain;
import MyCallBack.CallBackInsert;
import MyThing.myThing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MyInitInsert extends JFrame{
    public ArrayList<myThing> arrayList;

    public MyInitInsert(ArrayList<myThing> arrayList){
        this.arrayList=arrayList;
    }
    public void InitInsert(boolean vis){
        Container container =this.getContentPane();//容器，放东西
        JPanel  jPanel=new JPanel();

        JButton button=new JButton("加入购物车");
        button.setBounds(120,330,100,30);
        ImageIcon icon =new ImageIcon("D:\\example\\Java2\\src\\Mmain\\1.jpg");
        JButton jButton=new JButton();
        jButton.setIcon(icon);
        jButton.setBounds(110,30,127,127);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyInitSearch asd=new MyInitSearch(arrayList);
                asd.InitSearch(true);
            }
        });

        JTextField jTextField =new JTextField();
        jTextField.setBounds(120,200,120,30);
        JLabel jLabel=new JLabel("商品名称");
        jLabel.setBounds(50,200,100,30);

        JTextField jTextField1 =new JTextField();
        jTextField1.setBounds(120,240,120,30);
        JLabel jLabel1=new JLabel("商品单价");
        jLabel1.setBounds(50,240,100,30);

        JTextField jTextField2 =new JTextField();
        jTextField2.setBounds(120,280,120,30);
        JLabel jLabel2=new JLabel("商品数量");
        jLabel2.setBounds(50,280,100,30);


        CallBackInsert callBackInsert=new CallBackInsert(this.arrayList,jTextField,jTextField1,jTextField2);
        button.addActionListener(callBackInsert);

        jPanel.setLayout(null);
        jPanel.add(button);
        jPanel.add(jButton);
        jPanel.add(jTextField);
        jPanel.add(jLabel);
        jPanel.add(jTextField1);
        jPanel.add(jLabel1);
        jPanel.add(jTextField2);
        jPanel.add(jLabel2);

        container.add(jPanel);
        this.setSize(400,500);
        setResizable(true);
        this.setVisible(vis);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    protected void processWindowEvent(WindowEvent e)
    {
        //这里需要对进来的WindowEvent进行判断，因为，不仅会有窗口关闭的WindowEvent进来，还可能有其他的WindowEvent进来
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
        {
            int option = JOptionPane.showConfirmDialog(null, "是否关闭程序？", "程序退出提示", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                super.processWindowEvent(e);

            }
            else {
                //用户选择不退出本程序，因此可以继续留在本窗口
            }
        }
    }

}
