package ru.croc.school.task7;
import ru.croc.school.task7.IllegalPositionException;

class ChessPosition {

    private static String literalColumn = "abcdefgh";
    private int coordX; // Численная координата
    private int coordY; // Буквенная координата

    ChessPosition(int coordX, int coordY) throws IllegalPositionException {
        if (0 <= coordX && coordX <= 7 && 0 <= coordY && coordY <= 7) {
            this.coordX = coordX;
            this.coordY = coordY;
        } else {
            throw new IllegalPositionException();
        }
    }

    static ChessPosition parse(String position) throws IllegalPositionException {
        return new ChessPosition(Integer.parseInt(position.substring(1, 2)) - 1,
                literalColumn.indexOf(position.substring(0, 1)));
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) throws IllegalPositionException {
        if (0 <= coordX && coordX <= 7) {
            this.coordX = coordX;
        } else {
            throw new IllegalPositionException();
        }
    }

    public void setCoordY(int coordY) throws IllegalPositionException {
        if (0 <= coordY && coordY <= 7) {
            this.coordY = coordY;
        } else {
            throw new IllegalPositionException();
        }
    }

    @Override
    public String toString(){
        return this.literalColumn.substring(this.coordY, this.coordY + 1) + this.coordX;
    }
}