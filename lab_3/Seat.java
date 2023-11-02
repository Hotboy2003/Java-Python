class Seat {
    private int row;
    private int column;
    private boolean isOccupied;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}