package org.academiadecodigo.bootcamp.Scenes;

import org.academiadecodigo.bootcamp.*;
import org.academiadecodigo.bootcamp.Detectors.Actions;
import org.academiadecodigo.bootcamp.Detectors.ColisionDetSpartans;
import org.academiadecodigo.bootcamp.Detectors.InteractionDet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class GameSceneSpartans implements KeyboardHandler {

    private Player player;
    
    private Picture shellbyPicture;

    private Picture spartansPicture;
    private Position position;

    private Rectangle rectangle;
    private Picture picture1;

    private int incr;

    private ColisionDetSpartans colisionDetSpartans;

    private ArrayList<InteractionDet> interactions = new ArrayList<InteractionDet>();

    public GameSceneSpartans() {
        
        shellbyPicture = new Picture(350, 700, "resources/shellby_game.png");
        spartansPicture = new Picture(350, 700, "resources/spartacus_game.png");
        position = new Position(350, 700);
        incr = 5;
        //rectangle = new Rectangle();
        colisionDetSpartans = new ColisionDetSpartans();
        //interação loiça
        interactions.add(new InteractionDet(120, 150, 690, 700, "I NEED SOME FOOD!", Actions.EATING_FOOD));
        interactions.add(new InteractionDet(365, 390, 495, 510, "PROGRAMMING!", Actions.PROGRAMMING));
        interactions.add(new InteractionDet(665, 685, 440, 490, "I'M TAKING A NAP!",Actions.SLEEPING));
        interactions.add(new InteractionDet(365, 385, 25, 35, "PRESENTING!", Actions.PRESENTING));
        interactions.add(new InteractionDet(535, 545, 60, 85, "FEELING LOST!",Actions.NEEDING_HELP));
        interactions.add(new InteractionDet(660, 670, 705, 715, "PLAYING TABLE TENNIS!",Actions.PLAYING_TENNIS));

    }

    public void init() {
        while(true) {
            /*for (InteractionDet interaction : interactions){
                interaction.interactionWith(player.getPosition().getX(), player.getPosition().getY());
            }*/
            //player.drawNecessities();
        }
    }

    public void backgroundSpartans() {
        //picture spartans
        Picture picture1 = new Picture(10, 10, "resources/classroomsshpartans.jpg");
        player = new Player(position, spartansPicture);
        picture1.draw();
        mainDisplay();
        player.getPlayerPicture().draw();
        keyboardInit();

    }

    public void mainDisplay(){
        org.academiadecodigo.simplegraphics.graphics.Rectangle rectangle = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 10, 240, 60);
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_D);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_S);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_A);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_W);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(upPressed);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //System.out.println("posição do player em x: " + player.getPosition().getX() + "posição do player em y: " + player.getPosition().getY());

        //interactions detection
        for (InteractionDet interaction : interactions){
            if(interaction.interactionWith(position.getX(),position.getY())){
                try {
                    player.setNecessities(interaction.setNecessities(player.getNecessities()));

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        player.drawNecessities();


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            //Collision Detector needs to validate the Player's next position,
            //colisionDetetor needs to receive as an argument X + incr and Y

            try {

                if (colisionDetSpartans.colisionDetetor(this.player.getPosition().getX() + incr, this.player.getPosition().getY())) {
                    System.out.println("inside colision detetion");
                    return;
                } else {
                    player.setPosition(this.player.getPosition().getX() + incr, this.player.getPosition().getY());
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

            //Increments player position on X by "incr"
            this.player.getPlayerPicture().translate(incr, 0);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            try {
                if (colisionDetSpartans.colisionDetetor(this.player.getPosition().getX(), this.player.getPosition().getY() + incr) == true) {
                    return;
                } else{
                    this.player.setPosition(this.player.getPosition().getX(), this.player.getPosition().getY() + incr);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Increments player position on Y by "incr"

                this.player.getPlayerPicture().translate(0, incr);
            }


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {

            try {
                if (colisionDetSpartans.colisionDetetor(this.player.getPosition().getX(), this.player.getPosition().getY() - incr) == true) {
                    return;
                }else {
                    this.player.setPosition(this.player.getPosition().getX(), this.player.getPosition().getY() - incr);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Decrements player position on Y by "incr"
            this.player.getPlayerPicture().translate(0, -incr);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            try {
                if (colisionDetSpartans.colisionDetetor(this.player.getPosition().getX() - incr, this.player.getPosition().getY()) == true) {
                    return;
                } else {
                    this.player.setPosition(this.player.getPosition().getX() - incr, this.player.getPosition().getY());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Decrements player position on X by "incr"*/
            this.player.getPlayerPicture().translate(-incr, 0);
        }
                
    }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
            //sdasd
        }

}
