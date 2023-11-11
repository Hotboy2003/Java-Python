package Figures;

public class Rook extends Figure{
    public Rook(String name, char color) {
        super(name, color);
    }

    public boolean canMove(int row, int col, int row1, int col1, Figure fields[][]) {
        if (row == row1 || col == col1) {
            if (row == row1) {
                int j = Math.min(col, col1) + 1;
                int endJ = Math.max(col, col1);
                for (; j < endJ; j++) {
                    if (fields[row][j] != null) {
                        return false; // Есть препятствие на пути
                    }
                }
                return true; // Нет препятствий
            } else {
                int i = Math.min(row, row1) + 1;
                int endI = Math.max(row, row1);
                for (; i < endI; i++) {
                    if (fields[i][col] != null) {
                        return false; // Есть препятствие на пути
                    }
                }
                return true; // Нет препятствий
            }
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, Figure figure) {

        if (figure instanceof King) {
            return false; // Король не может быть съеден
        }
        return this.canMove(row, col, row1, col1, figure);
    }
}
