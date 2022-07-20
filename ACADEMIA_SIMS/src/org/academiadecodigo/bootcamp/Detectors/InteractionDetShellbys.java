package org.academiadecodigo.bootcamp.Detectors;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class InteractionDetShellbys {
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    private String text;

    private Actions action;


    public InteractionDetShellbys(int xMin, int xMax, int yMin, int yMax, String text, Actions action){
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.text = text;
        this.action=action;
    }

    public boolean interactionWith (int x, int y){
        if ((x >= this.xMin && x <= this.xMax) && (y >= yMin && y <= yMax) ) {
            Text text = new Text(50, 40, this.text);
            text.draw();
            return true;
        } else {
            Rectangle newRectangle = new Rectangle(10, 10, 240, 50);
            newRectangle.setColor(Color.GREEN);
            newRectangle.fill();
            return false;
        }
    }
    public int[] setNecessitiesS(int[] necessities) throws InterruptedException {

        int energy = necessities[0];
        int happiness = necessities[1];
        int hunger = necessities[2];
        System.out.println("1energy: " + energy + " 1happiness: " + happiness + " 1hunger: " + hunger);
        boolean b = energy > 0 && happiness > 0 && energy <= 100 && happiness <= 100 && hunger < 100 && hunger > 0;

        switch (action) {
            case EATING_FOOD:
                if (hunger >= 10) {
                    hunger -= 10;
                    if(hunger < 0){
                        hunger = 0;
                    }
                    break;
                }
                break;

            case PROGRAMMING:
                //for (int i = 0; i < 2; i++) {
                    if(energy > 0 && happiness > 0 && energy <= 100 && happiness <= 100 && hunger <= 95 && hunger >= 0){
                        energy -= 10;
                        happiness -= 10;
                        hunger += 10;
                        if(hunger < 0){
                            hunger = 0;
                        }
                        //Thread.sleep(500);
                        //continue;
                    //}
                    break;
                }
                break;

            case SLEEPING:
                System.out.println("A DORMIIIIR");
                //for (int i = 0; i < 3; i++) {
                    if (energy > 0 && happiness > 0 && energy <= 95 && happiness <= 95 && hunger <= 100 && hunger >= 0) {
                        energy += 10;
                        happiness += 10;

                        if(hunger < 0){
                            hunger = 0;
                        }
                        System.out.println("NO FOOOOR");
                        //Thread.sleep(500);
                   // }
                    break;
                }
                break;

            case PRESENTING:
                //for (int i = 0; i < 3; i++) {
                    if (energy > 0 && happiness > 0 && energy <= 100 && happiness <= 100) {
                        energy -= 10;
                        happiness -= 10;
                        hunger += 10;
                        if(hunger < 0){
                            hunger = 0;
                        }
                        //Thread.sleep(500);
                   // }
                    break;
                }
                break;

            case NEEDING_HELP:
                for (int i = 0; i < 3; i++) {
                    if (energy > 0 && happiness > 0 && energy <= 97 && happiness <= 97) {
                        energy += 3;
                        happiness += 3;
                        if(hunger < 0){
                            hunger = 0;
                        }
                        //Thread.sleep(500);
                    }
                    break;
                }
                break;

            case PLAYING_TENNIS:
                for (int i = 0; i < 3; i++) {
                    if (energy > 0 && happiness > 0 && energy <= 100 && happiness <= 97 && hunger <= 95 && hunger > 0) {
                        energy -= 3;
                        happiness += 3;
                        hunger+=5;
                        if(hunger < 0){
                            hunger = 0;
                        }
                        // Thread.sleep(500);
                    }
                    break;
                }
                break;
        }
        necessities[0] = energy;
        necessities[1] = happiness;
        necessities[2] = hunger;
        System.out.println("1energy: " + energy + " 1happiness: " + happiness + " 1hunger: " + hunger);

        return necessities;
    }
}
