package construction_6_gui;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) { // 程序入口
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testwinbuilder frame = new Testwinbuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
