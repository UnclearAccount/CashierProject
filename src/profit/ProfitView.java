package profit;


import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Catur Rahmat
 */
public class ProfitView {
    JFrame layout = new JFrame("Profit Company");
    //LAYOUT
    JPanel homeBackground = new JPanel();
    JPanel header = new JPanel();
    JPanel content = new JPanel();
    JPanel plogo = new JPanel();
    JPanel pback = new JPanel();
    JSeparator JSLogo = new JSeparator();
    JSeparator JSInput = new JSeparator();
    JSeparator JSClock = new JSeparator();
    JSeparator JSProfit = new JSeparator();
    JSeparator JSProfit2 = new JSeparator();
    JLabel Llogo = new JLabel();
    JLabel Lback = new JLabel();
    JPanel ptime = new JPanel();
    
    JLabel Llist = new JLabel("PROFIT COMPANY");
    JLabel LKlist = new JLabel("Modal Min, Profit Max, Happy...Muachh");
    JLabel lclock = new JLabel();
    JLabel ldate = new JLabel();
    JLabel Lprofit = new JLabel();
    JLabel LRp = new JLabel("Rp. ");
    JLabel LThanks = new JLabel("Thanks For Using This Application ");
    JLabel Lrate = new JLabel();
    ImageIcon ILogo = new ImageIcon(getClass().getResource("/img/logo.png"));
    ImageIcon IBack = new ImageIcon(getClass().getResource("/img/back.png"));
    ImageIcon IProfit = new ImageIcon(getClass().getResource("/img/profitView.png"));
    ImageIcon IRate = new ImageIcon(getClass().getResource("/img/rate.png"));
    ProfitView(){
        Thread clock = new Thread(){
        @Override
        public void run(){
            while(true){
                DateFormat Date = new SimpleDateFormat("dd - MM - yyyy");
                String theDate = Date.format(new Date()).toString();
                DateFormat Clock = new SimpleDateFormat("hh : mm : ss");
                String theClock = Clock.format(new Date()).toString();
                lclock.setText(theClock);
                ldate.setText(theDate);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            }   
        }
        };
        clock.start();
        initComponents();
        layout.setSize(1100,650);
        layout.setDefaultCloseOperation(EXIT_ON_CLOSE);
        layout.setVisible(true);
        layout.setLocationRelativeTo(null);
        layout.setResizable(false); 
    }
    public void initComponents(){
        layout.add(homeBackground);
        Llogo.setBounds(50,10,200,100);
        Llogo.setIcon(ILogo);
        layout.add(Llogo);
        
        Lback.setBounds(7,0,40,25);
        Lback.setIcon(IBack);
        layout.add(Lback);
        
        pback.setBounds(0,0,40,25);
        pback.setBackground(new Color(64,224,208));
        layout.add(pback);
        
        plogo.setSize(200, 120);
        plogo.setBounds(0,0,300,120);
        plogo.setBackground(new Color(64,224,208));
        layout.add(plogo);
        
        lclock.setFont(new Font("DS-Digital",Font.CENTER_BASELINE,40));
        lclock.setForeground(new Color(0,0,0));
        lclock.setBounds(885,0,200,70);
        layout.add(lclock);
        
        ldate.setFont(new Font("DS-Digital",Font.CENTER_BASELINE,24));
        ldate.setForeground(new Color(0,0,0));
        ldate.setBounds(905,50,200,70);
        layout.add(ldate);
        
        JSLogo.setBounds(865,60,205,10);
        layout.add(JSLogo);
        
        ptime.setSize(200, 120);
        ptime.setBounds(850,0,300,120);
        ptime.setBackground(new Color(64,224,208));
        layout.add(ptime);
        
        Llist.setFont(new Font("Stencil",Font.CENTER_BASELINE,28));
        Llist.setForeground(Color.WHITE);
        Llist.setBounds(440,0,290,80);
        layout.add(Llist);
        
        JSInput.setBounds(400,60,350,10);
        layout.add(JSInput);
        LKlist.setFont(new Font("Agency FB",Font.CENTER_BASELINE,16));
        LKlist.setForeground(Color.WHITE);
        LKlist.setBounds(475,70,340,15);
        layout.add(LKlist);
        
        Lprofit.setBounds(514,180,128,128);
        Lprofit.setIcon(IProfit);
        layout.add(Lprofit);
        
        JSProfit.setBounds(380,330,400,10);
        layout.add(JSProfit);
        
        LRp.setFont(new Font("DS-Digital",Font.CENTER_BASELINE,70));
        LRp.setForeground(Color.WHITE);
        LRp.setBounds(420,340,450,80);
        layout.add(LRp);
        
        JSProfit2.setBounds(380,420,400,10);
        layout.add(JSProfit2);
        
        LThanks.setFont(new Font("Agency FB",Font.CENTER_BASELINE,24));
        LThanks.setForeground(Color.WHITE);
        LThanks.setBounds(450,440,340,30);
        layout.add(LThanks);
        
        Lrate.setBounds(480,460,200,100);
        Lrate.setIcon(IRate);
        layout.add(Lrate);
        //setBounds(KIRI,ATAS,KANAN,BAWAH);
        header.setSize(1100, 200);
        header.setBounds(0,0,1100,120);
        header.setBackground(new Color(0,153,255));
        layout.add(header);
        content.setBounds(0,120,430,1100);
        content.setBackground(new Color(0, 188, 242));
        layout.add(content);
        
    }

    public void setLRp(String LRp) {
        this.LRp.setText("Rp " + LRp);
    }
    
    
}
