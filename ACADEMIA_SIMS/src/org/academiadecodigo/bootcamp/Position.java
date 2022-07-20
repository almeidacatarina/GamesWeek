package org.academiadecodigo.bootcamp;

public class Position {

    private int y;
    private int x;

    public Position(int x, int y){
        this.y = y;
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /*public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }*/
}

