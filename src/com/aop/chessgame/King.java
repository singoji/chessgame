package com.aop.chessgame;

public class King extends Coin {
	public King(boolean isWhite) {
		super(CoinType.KING, isWhite);
	}

	@Override
	public boolean canMove(int dest, ChessGame game) {
		// TODO Auto-generated method stub
		if (isStrightAndFree(getPosition(), dest, game) || isDiagnalAndFree(getPosition(), dest, game)) {
			return true;
		}
		return false;
	}

	private boolean isStrightAndFree(int position, int dest, ChessGame game) {
		// TODO Auto-generated method stub
		int currentRow = getRow(position);
		int currentColumn = getColumn(position);
		int destRow = getRow(dest);
		int destColumn = getColumn(dest);
		if (currentRow == destRow) {

			if (game.getCoin(getIndex(currentRow, destColumn)) != null) {
				return false;
			}

			// nothing in between
			return true;
		} else if (currentColumn == destColumn) {

			if (game.getCoin(getIndex(currentRow, currentColumn)) != null) {
				return false;
			}
			// nothing in between
			return true;
		} else
			return false;
	}

	private int getIndex(int row, int column) {
		return row * 8 + column;
	}

	private boolean isDiagnalAndFree(int position, int dest, ChessGame game) {
		int currentRow = getRow(position);
		int currentColumn = getColumn(position);
		int destRow = getRow(dest);
		int destColumn = getColumn(dest);
		if (Math.abs(currentRow - destRow) == Math.abs(currentColumn - destColumn)) {

			if (game.getCoin(getIndex(destRow, destColumn)) != null) {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

}
