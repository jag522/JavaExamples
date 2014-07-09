package com.jag.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JProgressOK extends JPanel {
	private BorderLayout borderLayout1 = new BorderLayout();

	private static JProgressBar bar = new JProgressBar();

	private JButton btn = new JButton();

	private final void doWork() {
		final SwingWorker worker = new SwingWorker() {
			public Object construct() {
				try {
					int total = 100;
					bar.setMaximum(total);
					bar.setMinimum(0);
					for (int i = 0; i < total; i++) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
						}
						bar.setValue(i);
					}
				} catch (Exception e) {
				}
				return null;
			}

			public void finished() {
			}
		};
		worker.start();
	}

	public JProgressOK() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(borderLayout1);
		this.setDoubleBuffered(false);
		bar.setDoubleBuffered(false);
		btn.setDoubleBuffered(false);
		btn.setText("import");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doWork();
			}
		});
		this.add(bar, BorderLayout.SOUTH);
		this.add(btn, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JProgressOK me = new JProgressOK();
		javax.swing.JFrame frame = new javax.swing.JFrame();
		frame.getContentPane().add(me, java.awt.BorderLayout.CENTER);
		frame.pack();
		frame.setSize(500, 100);
		frame.setLocation(300, 600);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
