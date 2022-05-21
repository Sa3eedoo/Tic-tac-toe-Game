package ssp.cce;

public class TicTacToe {

    private final static byte ROWS_NUMBER = 6;
    private final static byte COLUMNS_NUMBER = 7;
    private final static byte CELLS_NUMBER = ROWS_NUMBER * COLUMNS_NUMBER;
    private String[][] cells = new String[ROWS_NUMBER][COLUMNS_NUMBER];
    private Board board = new Board(ROWS_NUMBER, COLUMNS_NUMBER, cells);
    private Rules rules = new Rules(ROWS_NUMBER, COLUMNS_NUMBER, CELLS_NUMBER, cells, board);

    public TicTacToe() {

        board.startGame();
        do {
            board.printBoard();
            board.setCellIndex();
            rules.applyRules();
        } while (true);

    }

}