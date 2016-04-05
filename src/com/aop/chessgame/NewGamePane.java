package com.aop.chessgame;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewGamePane extends JPanel {

	private ChessGameApplication chessGameApplication;

	public NewGamePane(ChessGameApplication chessGameApplication) {
		this.chessGameApplication = chessGameApplication;
		String userName = null;
		int port = 0;
		final JTextField userText = new JTextField(10);
		// final JTextField portText = new JTextField(10);
		this.add(userText);
		JButton jb = new JButton("Cancle");
		this.add(jb);
		// set some layout
		// create required controls
		// create two buttons, cancel, create
		// on create call

		// chessGameApplication.onNewGame(port, userName);
	}
}
