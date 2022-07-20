package org.academiadecodigo.bootcamp.Detectors;

public class ColisionDetSpartans {

    private int xMin;

    private int yMin;

    private int xMax;

    private int yMax;

    private String string;

    boolean status;
    int counter = 0;


    public ColisionDetSpartans() {
        /*this.xMin=xMin;
        this.xMax=xMax;
        this.yMin=yMin;
        this.yMax=yMax;
        this.string = string;*/
        status = true;
    }


    public boolean colisionDetetor(int x, int y) throws InterruptedException {

        //limite laterais
        if (x <= 10 || x >= 730) {
            System.out.println("colisão lateral");
            return true;
        }//limite cima
        if (y <= 20 || y >= 730) {
            System.out.println("colisão cima");
            return true;
        } //mesa
        if ((x >= 550 && x <= 730) && (y <= 150 && y >= -230)) {
            System.out.println("colisão mesa");
            return true;
        } //ping pong superior
        if ((x >= 540 && x <= 730) && (y >= 545 && y <= 700)) {
            System.out.println("colisão ping1");
            return true;
        }
        //ping pong inferior
        if ((x >= 540 && x <= 730) && (y >= 720 && y <= 750)) {
            System.out.println("colisão ping2");
            return true;
        }

        //comida
        if ((x >= 55 && x <= 220) && (y >= 705 && y <= 750)) {
            System.out.println("colisão inf");
            return true;
        }
        //display
        if ((x >= 0 && x <= 230) && (y <= 45 && y >= 20)) {
            System.out.println("colisão louça");
            return true;
        }

        //projetor
        if ((x >= 145 && x <= 610) && (y >= 120 && y <= 490)) {
            System.out.println("colisão projetor");
            return true;
        }
        return false;

    }
}

