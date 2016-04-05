package com.aop.chessgame;

public class Pawn extends Coin {

	public Pawn(boolean isWhite) {
		super(CoinType.PAWN, isWhite);
	}

	@Override
	public boolean canMove(int dest, ChessGame game) {

		if (isStrightAndFree(getPosition(), dest, game) || isDiagnalAndFree(getPosition(), dest, game)) {
			return true;
		}

		return false;
	}

	private boolean isDiagnalAndFree(int position, int dest, ChessGame game) {
		// TODO Auto-generated method stub
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

	private boolean isStrightAndFree(int position, int dest, ChessGame game) {
		// TODO Auto-generated method stub
		int currentRow = getRow(getPosition());
		int currentColumn = getColumn(getPosition());
		int destRow = getRow(dest);
		int destColumn = getColumn(dest);
		for (int i = 0; i < 8; i++) {
			if ((game.coins[8 + i] == game.coins[currentRow * currentColumn])
					|| (game.coins[48 + i] == game.coins[currentRow * currentColumn])) {
				destRow = currentRow + 2;
				if (game.getCoin(getIndex(destRow, destColumn)) == null) {
					return true;
				} else {
					return false;
				}
			} else {
				destRow = currentRow;
				if (game.getCoin(getIndex(destRow, destColumn)) == null) {
					return true;
				} else {
					return false;
				}
			}
		}

		// TODO Auto-generated method stub
		return false;
	}

	private int getIndex(int row, int column) {
		return row * 8 + column;
	}

}
