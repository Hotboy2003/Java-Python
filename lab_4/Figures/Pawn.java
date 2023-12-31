package Figures;

public class Pawn extends Figure {

    private boolean isFirstStep = true;

    public Pawn(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, Figure figure) {
        //   if (!super.canMove(row, col, row1, col1)){
        //       return false;
        //   }

        if (this.isFirstStep) {
            if (((((row + 2 == row1) || (row + 1 == row1)) && this.getColor() == 'w') ||
                    (((row - 2 == row1) || (row - 1 == row1)) && this.getColor() == 'b')) && (col == col1)) {
                this.isFirstStep = false;
                return true;
            }

        } else {
            if ((((row + 1 == row1) && (this.getColor() == 'w')) || ((row - 1 == row1) && (this.getColor() == 'b'))) && (col == col1)) {
                return true;
            }

        }
        return false;
    }

    public boolean canAttack(int row, int col, int row1, int col1, Figure figure) {
        if (figure instanceof King) {
                return false; // Король не может быть съеден
            }
        switch (this.getColor()) {
            case 'w':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
            case 'b':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
        }

        return false;
    }
}
