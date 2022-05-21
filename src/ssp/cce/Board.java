package ssp.cce;

import java.util.Random;
import java.util.Scanner;

public class Board {

    private byte rowsNumber;
    private byte columnsNumber;
    private boolean playerOneTurn;
    private String[][] cells = new String[rowsNumber][columnsNumber];
    private Scanner input = new Scanner(System.in);

    public Board(byte rowsNumber, byte columnsNumber, String[][] cells) {

        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
        this.cells = cells;

    }

    public void startGame() {
        initializeBoard();
        firstTurn();
    }

    private void initializeBoard() {

        for(int i = 0; i < rowsNumber; i++) {
            for(int j = 0; j < columnsNumber; j++) {
                cells[i][j] = "   ";
            }
        }

    }

    public void printBoard() {

        String strBoard = "";
        for(int i = 0; i < rowsNumber; i++) {
            for(int j = 0; j < columnsNumber; j++) {
                if(j == columnsNumber -1)
                    strBoard += cells[i][j];
                else
                    strBoard += cells[i][j] + "|";
            }
            if(i != rowsNumber -1) {
                strBoard += "\n---+";
                for (int k = 0; k < columnsNumber - 2; k++) {
                    strBoard += "---+";
                }
                strBoard += "---\n";
            }
        }
        System.out.println(strBoard);

    }

    public void setCellIndex() {

        int row;
        int column;
        boolean taken;

        if(playerOneTurn) {
            System.out.println("X Turn");

            do {
                taken = false;
                do {
                    System.out.print("Enter Row Index(1:" + rowsNumber + "):");
                    row = input.nextInt();
                    if (row < 1 || row > rowsNumber)
                        System.out.println("Wrong Row Index!!!");
                }while (row < 1 || row > rowsNumber);

                do {
                    System.out.print("Enter column Index(1:" + columnsNumber + "):");
                    column = input.nextInt();
                    if (column < 1 || column > rowsNumber)
                        System.out.println("Wrong column Index!!!");
                }while (column < 1 || column > columnsNumber);

                row--;
                column--;

                if (cells[row][column] != "   ") {
                    taken = true;
                    System.out.println("Index is taken!!!");
                }
            }while (taken);

            cells[row][column] = " X ";
            playerOneTurn = false;
        } else {
            System.out.println("O Turn");

            do {
                taken = false;
                do {
                    System.out.print("Enter Row Index(1:" + rowsNumber + "):");
                    row = input.nextInt();
                    if (row < 1 || row > rowsNumber)
                        System.out.println("Wrong Row Index!!!");
                }while (row < 1 || row > rowsNumber);

                do {
                    System.out.print("Enter column Index(1:" + columnsNumber + "):");
                    column = input.nextInt();
                    if (column < 1 || column > rowsNumber)
                        System.out.println("Wrong column Index!!!");
                }while (column < 1 || column > columnsNumber);

                row--;
                column--;

                if (cells[row][column] != "   ") {
                    taken = true;
                    System.out.println("Index is taken!!!");
                }
            }while (taken);

            cells[row][column] = " O ";
            playerOneTurn = true;
        }

    }

    private void firstTurn() {

        Random random = new Random();
        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
        }
        else {
            playerOneTurn = false;

        }

    }

}
