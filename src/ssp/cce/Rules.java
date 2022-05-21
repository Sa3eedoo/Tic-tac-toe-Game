package ssp.cce;

import static java.lang.System.exit;

public class Rules {

    private byte rowsNumber;
    private byte columnsNumber;
    private byte cellsNumber;
    private String[][] cells = new String[rowsNumber][columnsNumber];
    private Board board;

    public Rules(byte rowsNumber, byte columnsNumber, byte cellsNumber, String[][] cells, Board board) {

        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
        this.cellsNumber = cellsNumber;
        this.cells = cells;
        this.board = board;

    }

    public void applyRules() {
        xCheck();
        oCheck();
        drawCheck();
    }

    private void drawCheck() {

        int counter = 0;
        for(int i = 0; i < rowsNumber; i++) {
            for(int j = 0; j < columnsNumber; j++) {
                if (cells[i][j] != "   ")
                    counter++;
            }
        }
        if (counter == cellsNumber){
            board.printBoard();
            System.out.println("DRAW.\nGAME OVER!!!");
            exit(0);
        }
    }

    private void oCheck() {

        //Horizontal check
        for (int j = 0; j < rowsNumber; j++ ) {
            for (int k = 0; k < columnsNumber - 2 ; k++ ) {
                if ( (cells[j][k] == " O ")&&
                        (cells[j][k + 1] == " O ")&&
                        (cells[j][k + 2] == " O ") ) {
                    oWins();
                }
            }
        }

        //Vertical check
        for (int j = 0; j < columnsNumber; j++ ) {
            for (int k = 0; k < rowsNumber - 2 ; k++ ) {
                if ( (cells[k][j] == " O ")&&
                        (cells[k+1][j] == " O ")&&
                        (cells[k+2][j] == " O ") ) {
                    oWins();
                }
            }
        }

        //Diagonal left to right check
        for (int i = 0; i <= (rowsNumber - 3) ; i++) {
            for (int j = (columnsNumber - 3); j >= 0 ; j--) {
                if ( (cells[i][j] == " O ")&&
                        (cells[i+1][j+1] == " O ")&&
                        (cells[i+2][j+2] == " O ") ) {
                    oWins();
                }
            }
        }

        //Diagonal right to left check
        for (int i = 0; i <= (rowsNumber - 3) ; i++) {
            for (int j = 2; j <= (columnsNumber - 1) ; j++) {
                if ( (cells[i][j] == " O ")&&
                        (cells[i+1][j-1] == " O ")&&
                        (cells[i+2][j-2] == " O ") ) {
                    oWins();
                }
            }
        }

    }

    private void oWins() {

        board.printBoard();
        System.out.println("O WINS.\nGAME OVER!!!");
        exit(0);

    }

    private void xCheck() {

        //Horizontal check
        for (int j = 0; j < rowsNumber; j++ ) {
            for (int k = 0; k < columnsNumber - 2 ; k++ ) {
                if ( (cells[j][k] == " X ")&&
                        (cells[j][k + 1] == " X ")&&
                        (cells[j][k + 2] == " X ") ) {
                    xWins();
                }
            }
        }

        //Vertical check
        for (int j = 0; j < columnsNumber; j++ ) {
            for (int k = 0; k < rowsNumber - 2 ; k++ ) {
                if ( (cells[k][j] == " X ")&&
                        (cells[k+1][j] == " X ")&&
                        (cells[k+2][j] == " X ") ) {
                    xWins();
                }
            }
        }

        //Diagonal left to right check
        for (int i = 0; i <= (rowsNumber - 3) ; i++) {
            for (int j = (columnsNumber - 3); j >= 0 ; j--) {
                if ( (cells[i][j] == " X ")&&
                        (cells[i+1][j+1] == " X ")&&
                        (cells[i+2][j+2] == " X ") ) {
                    xWins();
                }
            }
        }

        //Diagonal right to left check
        for (int i = 0; i <= (rowsNumber - 3) ; i++) {
            for (int j = 2; j <= (columnsNumber - 1) ; j++) {
                if ( (cells[i][j] == " X ")&&
                        (cells[i+1][j-1] == " X ")&&
                        (cells[i+2][j-2] == " X ") ) {
                    xWins();
                }
            }
        }

    }

    private void xWins() {

        board.printBoard();
        System.out.println("X WINS.\nGAME OVER!!!");
        exit(0);

    }

}