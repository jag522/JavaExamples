package com.jag.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

//import com.bruceeckel.swing.*;

public class JProgressSimple extends JApplet {
	private int min = 0, max = 100;

	private JProgressBar pb = new JProgressBar();

	private Timer t;

	private int i;

	JPanel panel = new JPanel();

	public JProgressSimple() {
	}

	public synchronized void resetValue() {
		i = 0;
	}

	public synchronized int getValue() {
		return i;
	}

	public synchronized void addValue() {
		i++;
	}

	public void setMin() {
		this.min = min;
	}

	public int getMin() {
		return min;
	}

	public void setMax() {
		this.max = max;
	}

	public int getMax() {
		return max;
	}

	public void init() {
		Container cp = getContentPane();
		pb.setMinimum(min);
		pb.setMaximum(max);
		pb.setBackground(Color.white);
		pb.setForeground(Color.red);
		pb.setStringPainted(true);
		cp.add(panel.add(pb), BorderLayout.PAGE_START);
	}

	public void start() {
		t = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (getValue() < getMax()) {
					addValue();
					pb.setValue(getValue());
				} else {
					resetValue();
					t.stop();
				}
			}
		});
		t.start();
	}

	public void doSomething() {
		try {
			for (int i = 0; i < 5;) {
				// Thread.sleep(1000);
				System.out.println("processing " + ++i);
				addValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final JProgressSimple pg = new JProgressSimple();
		JFrame frame = new JFrame("JProgressEx");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pg);
		frame.setSize(300, 200);
		pg.init();
		frame.setVisible(true);
		// pg.doSomething();
		pg.start();
	}
}
