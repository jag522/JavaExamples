package com.jag.thread.ThreadLocalVariable;

public class SequenceNumber {

	// ��ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// �ڻ�ȡ��һ������ֵ
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber();

		// �� 3���̹߳���sn�����Բ������к�
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
	}

	private static class TestClient extends Thread {
		private SequenceNumber sn;

		public TestClient(SequenceNumber sn) {
			this.sn = sn;
			start();
		}

		public void run() {
			for (int i = 0; i < 3; i++) { // ��ÿ���̴߳��3������ֵ
				System.out.println("thread[" + Thread.currentThread().getName()
						+ "] sn[" + sn.getNextNum() + "]");
			}
		}
	}
}