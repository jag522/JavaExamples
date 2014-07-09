package com.jag.other;

import java.util.Timer;
import java.util.TimerTask;

class Fork {
	private static int i = 0;
	private int number = i++;
	public String toString() {
		return "Fork" + number;
	}
}

class Philosopher extends Thread {
	private static int i = 0;
	private int ponder = 10;
	private int number = i++;
	private Fork leftFork;
	private Fork rightFork;

	public Philosopher(Fork leftFork, Fork rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		start();
	}

	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	public void think() {
		System.out.println(this + " is thinking");
		try {
			sleep(ponder);
		} catch (InterruptedException e) {
			System.out.println("being interrupted");
		}
	}

	public void eat() {
		synchronized (leftFork) {
			System.out.println(this
					+ " has "+this.leftFork+",waiting for "+this.rightFork);
		}
		synchronized (rightFork) {
			System.out.println(this + " is eating");
		}
	}

	public String toString() {
		return ("philosopher" + number);
	}
}

public class DeadLock {

	public static void main(String[] args) {
		Philosopher ph[] = new Philosopher[2];
		Fork left = new Fork();
		Fork right = new Fork();
		ph[0] = new Philosopher(left, right);
		ph[1] = new Philosopher(right, left);
		new Timer(true).schedule(new TimerTask() {
			public void run() {
				System.out.println("no deadlock");
				System.exit(0);
			}
		}, 10000);
	}

}
