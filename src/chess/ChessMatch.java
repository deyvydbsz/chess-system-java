package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Hook;
import chess.pieces.King;

public class ChessMatch {

    private static Board board;

    public ChessMatch() {
        board = new Board(8,8);
        initialSetup();}

    public static ChessPiece[][] getPieces() {
        ChessPiece[][]  mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char colunm, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(colunm, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('b', 6, new Hook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
