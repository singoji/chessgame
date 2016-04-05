package com.aop.chessgame;

public class Knight extends Coin {
	public Knight(boolean isWhite) {
		super(CoinType.KNIGHT, isWhite);
	}

	@Override
	public boolean canMove(int dest, ChessGame game) {
		// TODO Auto-generated method stub
		if (isStrightAndFree(getPosition(), dest, game)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isStrightAndFree(int position, int dest, ChessGame game) {
		// TODO Auto-generated method stub
		int currentRow = getRow(position);
		int currentColumn = getColumn(position);
		int destRow = getRow(dest);
		int destColumn = getColumn(dest);
		if (currentRow + 1 == destRow || currentRow - 1 == destRow) {
			if (game.getCoin(getIndex(destRow, destColumn)) != null) {
				return false;

			} else {
				// nothing in between
				return true;
			}
		}
		if (currentColumn + 1 == destColumn || currentColumn - 1 == destColumn) {
			if (game.getCoin(getIndex(destRow, destColumn)) != null) {

				return true;
			} else {
				return false;

			}
		}
		return false;

	}

	private int getIndex(int row, int column) {
		return row * 8 + column;
	}
}
