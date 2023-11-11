import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
//TODO: Список фигур и начальное положение всех фигур
    public Figure fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public boolean move_figure(int row1, int col1, int row2, int col2){

        Figure figure =  this.fields[row1][col1];

        if (figure.canMove(row1, col1, row2, col2, figure) && this.fields[row2][col2]==null){
            System.out.println("move");
            this.fields[row2][col2] = figure;
            this.fields[row1][col1] = null;
            return true;
        } else if (figure.canAttack(row1, col1, row2, col2, figure) && this.fields[row2][col2] != null && this.fields[row2][col2].getColor() != this.fields[row1][col1].getColor() ){
            System.out.println("attack");
            switch (this.fields[row2][col2].getColor()) {
                case 'w' -> this.takeWhite.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
                case 'b' -> this.takeBlack.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
            }
            this.fields[row2][col2] = figure;
            this.fields[row1][col1] = null;
            return true;
        }
        return false;
    }
    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
             }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }


    }

    public boolean isCheck(char color) {
        int kingRow = -1;
        int kingCol = -1;

        // Найдем координаты короля заданного цвета
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fields[i][j] instanceof King && fields[i][j].getColor() == color) {
                    kingRow = i;
                    kingCol = j;
                    break;
                }
            }
        }

        if (kingRow == -1 || kingCol == -1) {
            return false; // Король заданного цвета не найден
        }

        // Проверим, может ли какая-либо фигура атаковать короля
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fields[i][j] != null && fields[i][j].getColor() != color) {
                    if (fields[i][j].canAttack(i, j, kingRow, kingCol, fields[i][j])) {
                        return true; // Король под шахом
                    }
                }
            }
        }
        return false; // Король не под шахом
    }

    public boolean isCheckmate(char color) {
        if (!isCheck(color)) {
            return false; // Король не под шахом, нет мата
        }

        // Найдем все фигуры того же цвета, что и король под шахом
        ArrayList<Figure> myFigures = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (fields[i][j] != null && fields[i][j].getColor() == color) {
                    myFigures.add(fields[i][j]);
                }
            }
        }

        // Проверим, есть ли возможные ходы для всех фигур под шахом
        for (Figure figure : myFigures) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (figure.canMove(row, col, row, col, figure) &&
                            moveAndCheck(row, col, figure, color)) {
                        return false; // Есть возможный ход для фигуры под шахом
                    }
                }
            }
        }

        // Если нет возможных ходов для любой фигуры под шахом, то это мат
        return true;
    }

    // Метод для проверки возможности хода и отмены его, если король после этого остается под шахом
    private boolean moveAndCheck(int row, int col, Figure figure, char color) {
        Figure temp = fields[row][col];
        fields[row][col] = figure;
        fields[figure.getRow(String.valueOf(row))][figure.getCol(String.valueOf(col))] = null;

        boolean result = isCheck(color);

        fields[figure.getRow(String.valueOf(row))][figure.getCol(String.valueOf(col))] = fields[row][col];
        fields[row][col] = temp;

        return result;
    }
}
