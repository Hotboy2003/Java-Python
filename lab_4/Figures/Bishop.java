package Figures;

public class Bishop extends Figure{
    public Bishop(String name, char color) {
        super(name, color);
    }


    public boolean canMove(int row, int col, int row1, int col1, Figure fields[][]) {
        if (Math.abs(row - row1) == Math.abs(col - col1)) {
            // Проверяем препятствия на пути движения фигуры
            int dx = (col1 > col) ? 1 : -1;
            int dy = (row1 > row) ? 1 : -1;
            int i = row + dy;
            int j = col + dx;
            while (i != row1 && j != col1) {
                if (fields[i][j] != null) {
                    return false; // Есть препятствие на пути
                }
                i += dy;
                j += dx;
            }
            return true; // Нет препятствий
        }
        return false;
    }

    public boolean canAttack(int row, int col, int row1, int col1, Figure figure) {
        if (figure instanceof King) {
            return false; // Король не может быть съеден
        }

        return this.canMove(row, col, row1, col1, figure);
    }
}