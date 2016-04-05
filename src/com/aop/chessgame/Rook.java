package com.aop.chessgame;

public class Rook extends Coin {

	public Rook(boolean isWhite) {
		super(CoinType.ROOK, isWhite);
	}

	@Override
	public boolean canMove(int dest, ChessGame game) {
		if (isStraightAndFree(getPosition(), dest, game)) {
			return true;
			// TODO Auto-generated method stub
		}
		return false;
	}

	private boolean isStraightAndFree(int position, int dest, ChessGame game) {
		// TODO Auto-generated method stub
		int currentRow = getRow(position);
		int currentColumn = getColumn(position);
		int destRow = getRow(dest);
		int destColumn = getColumn(dest);
		if (currentRow == destRow) {
			for (int x = Math.min(currentColumn, destColumn) + 1; x < Math.max(currentColumn, destColumn) - 1; x++) {
				// make sure all are free
				if (game.getCoin(getIndex(currentRow, x)) != null) {
					return false;
				}

			}
			return true;
		} else
			return false;
	}

	private int getIndex(int row, int column) {
		return row * 8 + column;
	}
}
