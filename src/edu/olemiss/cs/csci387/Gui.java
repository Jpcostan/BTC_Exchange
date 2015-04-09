package edu.olemiss.cs.csci387;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
	
	private JLabel title;
	private JLabel acc1Label;
	private JLabel acc2Label;
	private JLabel acc1balanceUSD;
	private JLabel acc2balanceUSD;
	private JLabel acc1balanceBTC;
	private JLabel acc2balanceBTC;
	private JLabel AccHeader;
	private JLabel USDHeader;
	private JLabel BTCHeader;
	private final int height= 300;
    private final int length=400;
    private JPanel top, left, right, bottom;
    private JButton refresh;
    SimpleAccount acc1;
    SimpleAccount acc2;
    CSCI387Exchange exch1;
    CSCI387Exchange exch2;
    //took out , CSCI387Exchange exchange1
    public Gui(SimpleAccount account1){
    	acc1 = account1;
    	//exch1 = exchange1;
    	setTitle("Arbitrage");
        setSize(length,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        top = new JPanel(new FlowLayout());
        title = new JLabel("Arbitrage");
        top.add(title);
        add(top,BorderLayout.PAGE_START);
        left = new JPanel(new GridLayout(2,3));
        acc1Label = new JLabel("1st account");
        acc1balanceUSD = new JLabel(Double.toString(acc1.getUSDBalance()));
        acc1balanceBTC = new JLabel(Double.toString(acc1.getBTCBalance()));
        USDHeader = new JLabel("USD");
        BTCHeader = new JLabel("BTC");
        AccHeader = new JLabel("Account");
        left.add(AccHeader);
        left.add(USDHeader);
        left.add(BTCHeader);
        left.add(acc1Label);
        left.add(acc1balanceUSD);
        left.add(acc1balanceBTC);
        add(left);
        bottom = new JPanel(new GridLayout(1,1));
        refresh = new JButton("Refresh");
        bottom.add(refresh);
        add(bottom, BorderLayout.SOUTH);
        refresh.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		acc1balanceUSD.setText(Double.toString(acc1.getUSDBalance()));
        		acc1balanceBTC.setText(Double.toString(acc1.getBTCBalance()));
        	}});
        
        setVisible(true);
        
    }
	// took out ,CSCI387Exchange exchange1,CSCI387Exchange exchange2
	public Gui(SimpleAccount account1, SimpleAccount account2){
		acc1 = account1;
		acc2 = account2;
		//exch1 = exchange1;
		//exch2 = exchange2;
		setTitle("Arbitrage");
        setSize(length,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        top = new JPanel(new FlowLayout());
        title = new JLabel("Accounts");
        top.add(title);
        add(top,BorderLayout.PAGE_START);
        left = new JPanel(new GridLayout(2,3));
        acc1Label = new JLabel("1st account");
        acc2Label= new JLabel("2nd account");
        acc1balanceUSD = new JLabel(Double.toString(acc1.getUSDBalance()));
        acc2balanceUSD = new JLabel(Double.toString(acc2.getUSDBalance()));
        acc1balanceBTC = new JLabel(Double.toString(acc1.getBTCBalance()));
        acc2balanceBTC= new JLabel(Double.toString(acc2.getBTCBalance()));
        left.add(acc1Label);
        left.add(acc1balanceUSD);
        left.add(acc1balanceBTC);
        left.add(acc2Label);
        left.add(acc2balanceUSD);
        left.add(acc2balanceBTC);
        add(left);
        bottom = new JPanel(new GridLayout(1,1));
        refresh = new JButton("Refresh");
        bottom.add(refresh);
        add(bottom,BorderLayout.SOUTH);
        refresh.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		acc1balanceUSD.setText(Double.toString(acc1.getUSDBalance()));
        		acc1balanceBTC.setText(Double.toString(acc1.getBTCBalance()));
        		acc2balanceUSD.setText(Double.toString(acc2.getUSDBalance()));
        		acc2balanceBTC.setText(Double.toString(acc2.getBTCBalance()));
        	}});
        setVisible(true);

        
        
	}


}
