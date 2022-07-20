package org.academiadecodigo.bootcamp.Detectors;

public class CollisionDetShellbys {
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    private String string;
    boolean status;
    int counter = 0;


    public CollisionDetShellbys() {
        /*this.xMin=xMin;
        this.xMax=xMax;
        this.yMin=yMin;
        this.yMax=yMax;
        this.string = string;*/
        status = true;
    }


    public boolean colisionDetetor(int x, int y) throws InterruptedException {
        //System.out.println(status);

         //limite laterais
        if (x <= -15 || x >= 730 ) {
            System.out.println("colisão lateral");
            return true;
        } //limites de topo
        if (y <= 15 || y >= 740) {
            System.out.println("colisão topo");
            return true;
        } //secretária MCs
        if ((x <= 185) && (y <= 205)) {
            System.out.println("colisão secretária");
            return true;
        } //programming
        if ((x >= 180 && x <= 565) && (y >= 160 && y <= 580)) {
            System.out.println("colisão programming");
            return true;
        } //comida e cafe
        if ((x >= -10 && x <= 30) && (y >= 430 && y <= 625)) {
            System.out.println("colisão comida e cafe");
            return true;
        } //projetor
        if ((x >= 190 && x <= 560) && (y >= 25 && y <= 10)) {
            System.out.println("colisão projetor");
            return true;
        } //wc
        if ((x >= 605 && x <= 715) && (y >= 625 && y <= 720)) {
            System.out.println(x);
            System.out.println(y);
            System.out.println("colisão wc");
            return true;
        } //tv relvinha
        if ((x >= -10 && x <= 95) && (y >= 730)) {
            System.out.println("colisão tv relvinha");
            return true;
        } /* //display - por fazer
        if ((x >= 0 && x <= 230) && (y <= 45 && y >= 20)) {
            System.out.println("colisão louça");
            return true;
        } */
        return false;

    }
}

    /*public boolean interaction(int x, int y) throws InterruptedException {

        System.out.println("status interaction" + status);

            if ((x >= 400 && x <= 570) && (y >= 320 && y <= 350) && !status) {
                Text text = new Text(130, 25, "DRINKING COFFEE");
                text.draw();
                status = true;
                System.out.println("final: " + status);
                return true;
            }
        return false;
    }

        //this.player.getPosition().getX() + incr, this.player.getPosition().getY()) == true
        return false;
    }*/

