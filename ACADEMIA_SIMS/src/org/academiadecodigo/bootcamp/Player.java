package org.academiadecodigo.bootcamp;
import org.academiadecodigo.bootcamp.Detectors.ColisionDetSpartans;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player{

    private Position position;

    private Picture playerPicture;

    private int energy;

    private int happiness;

    private int hunger;

    private int[] necessities;

    public Player(Position position, Picture playerPicture) {
        this.position = position;
        this.playerPicture = playerPicture;

        energy = 100;

        happiness = 100;

        hunger = 0;

        necessities = new int[]{energy, happiness, hunger};
    }

    public Picture getPlayerPicture(){
        return this.playerPicture;
    }

    public void setPosition(int x, int y){
        this.position.setX(x);
        this.position.setY(y);

    }

    public Position getPosition() {

        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHunger() {
        return hunger;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int[] getNecessities() {
        return necessities;
    }

    public void setNecessities(int[] necessities) {
        this.necessities = necessities;
    }
    public void drawNecessities(){


        Rectangle rectangle = new Rectangle(10,10, 240,30);
        rectangle.setColor(Color.YELLOW);
        rectangle.fill();

        Integer energyVal = necessities[0];
        Integer happinessVal = necessities[1];
        Integer hungerVal = necessities[2];
        System.out.println("ESTOU AQUII");
        //Text energy
        Picture energyPic = new Picture(45, 12, "resources/energy.png");
        energyPic.draw();
        Text energy = new Text(25, 25, energyVal.toString());
        energy.setColor(Color.RED);
        energy.draw();

        //Text happiness
        Picture happyPic = new Picture(105, 15, "resources/smile.png");
        happyPic.draw();
        Text happiness = new Text(85, 25, happinessVal.toString());
        happiness.setColor(Color.ORANGE);
        happiness.draw();

        //Text hunger
        Picture hungerPic = new Picture(175, 15, "resources/meat.png");
        hungerPic.draw();
        Text hunger = new Text(155, 25, hungerVal.toString());
        hunger.setColor(Color.BLUE);
        hunger.draw();
        System.out.println("SAAIII");

    }
}

