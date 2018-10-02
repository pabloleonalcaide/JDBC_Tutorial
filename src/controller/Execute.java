package controller;

import javax.swing.JFrame;

import view.FrameApp;

public class Execute {

	public static void main(String[] args) {
		FrameApp frameApp = new FrameApp();
		frameApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameApp.setVisible(true);
	}
}
