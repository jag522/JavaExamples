package com.jag.gui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotDemo {
	private Robot robot = null;

	public RobotDemo() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void keyBoardDemo() {
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F8);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F8);
	}

	public void mouseDemo() {
		robot.mouseMove(80, 10);
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.mouseMove(600, 600);
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RobotDemo demo = new RobotDemo();
		demo.keyBoardDemo();
//		demo.mouseDemo();
	}
}
