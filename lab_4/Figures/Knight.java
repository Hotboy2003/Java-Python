package Figures;

public class Knight extends Figure{
    public Knight(String name, char color) {
        super(name, color);
    }

    public boolean canMove(int row, int col, int row1, int col1, Figure fields[][]) {
        if ((Math.abs(row - row1) == 1 && Math.abs(col - col1) == 2) || (Math.abs(row - row1) == 2 && Math.abs(col - col1) == 1)) {
            if (fields[row1][col1] == null) { // Проверяем, что целевая клетка пуста
                return true;
            }
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
