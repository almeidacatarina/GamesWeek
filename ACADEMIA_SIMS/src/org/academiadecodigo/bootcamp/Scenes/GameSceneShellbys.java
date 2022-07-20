package org.academiadecodigo.bootcamp.Scenes;

import org.academiadecodigo.bootcamp.Detectors.Actions;
import org.academiadecodigo.bootcamp.Detectors.CollisionDetShellbys;
import org.academiadecodigo.bootcamp.Detectors.InteractionDet;
import org.academiadecodigo.bootcamp.Detectors.InteractionDetShellbys;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.bootcamp.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class GameSceneShellbys implements KeyboardHandler {
    private Player player;
    private Picture shellbyPicture;
    private Position position;
    private Picture picture1;
    private int incr;
    private CollisionDetShellbys colisionDet;
    private ArrayList<InteractionDetShellbys> interactions = new ArrayList<InteractionDetShellbys>();


    public GameSceneShellbys() {
        shellbyPicture = new Picture(10, 350, "resources/shellby_game.png");
        position = new Position(10, 350);
        incr = 5;
        colisionDet = new CollisionDetShellbys();
        //interação cafe
        interactions.add(new InteractionDetShellbys(230, 255, 650, 700, "TAKING A NAP!", Actions.SLEEPING));
        interactions.add(new InteractionDetShellbys(35, 50, 490, 545, "I NEED SOME FOOD!", Actions.EATING_FOOD));
        interactions.add(new InteractionDetShellbys(630, 725, 640, 735, "I'M IN THE BATHROOM!", Actions.BATHROOM));
        interactions.add(new InteractionDetShellbys(365, 385, 145, 155, "LET'S GO PROGRAMMING!", Actions.PROGRAMMING));
        interactions.add(new InteractionDetShellbys(360, 385, 20, 35, "PRESENTING THE SUMMARIZER!", Actions.PRESENTING));
        interactions.add(new InteractionDetShellbys(190, 205, 65, 110, "I NEED HELP!", Actions.NEEDING_HELP));
    }

    public void init() {
        /*while(true) {
            for (InteractionDet interaction : interactions){
                interaction.interactionWith(player.getPosition().getX(), player.getPosition().getY());
            }
        }*/
    }

    public void backgroundShellby() {
        //picture shellbys
        picture1 = new Picture(10, 10, "resources/classroomshellbysfinal.jpg");
        player = new Player(position, shellbyPicture);
        picture1.draw();
        player.getPlayerPicture().draw();
        mainDisplay();
        keyboardInit();
    }

    public void mainDisplay() {
        org.academiadecodigo.simplegraphics.graphics.Rectangle rectangle = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 10, 240, 50);
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

        System.out.println("posição do player em x: " + player.getPosition().getX() + "posição do player em y: " + player.getPosition().getY());

        //interactions detection
        for (InteractionDetShellbys interaction : interactions) {
            if (interaction.interactionWith(position.getX(), position.getY())) {

                try {
                    player.setNecessities(interaction.setNecessitiesS(player.getNecessities()));
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

                    if (colisionDet.colisionDetetor(this.player.getPosition().getX() + incr, this.player.getPosition().getY())) {
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
                    if (colisionDet.colisionDetetor(this.player.getPosition().getX(), this.player.getPosition().getY() + incr) == true) {
                        return;
                    } else {
                        this.player.setPosition(this.player.getPosition().getX(), this.player.getPosition().getY() + incr);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //Increments player position on Y by "incr"*/if (this.player.getPosition().getY() + incr > 10) {
                this.player.getPlayerPicture().translate(0, incr);

            }


            if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {

                try {
                    if (colisionDet.colisionDetetor(this.player.getPosition().getX(), this.player.getPosition().getY() - incr) == true) {
                        return;
                    } else {
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
                    if (colisionDet.colisionDetetor(this.player.getPosition().getX() - incr, this.player.getPosition().getY()) == true) {
                        return;
                    } else {
                        this.player.setPosition(this.player.getPosition().getX() - incr, this.player.getPosition().getY());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //Decrements player position on X by "incr"
                this.player.getPlayerPicture().translate(-incr, 0);
            }

        }



        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
            //
        }


    }

