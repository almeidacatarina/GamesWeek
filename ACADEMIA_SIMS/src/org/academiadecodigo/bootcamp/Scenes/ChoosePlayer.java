package org.academiadecodigo.bootcamp.Scenes;

import org.academiadecodigo.bootcamp.Teams;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ChoosePlayer implements KeyboardHandler {

    Picture picture;
    private static Teams teams;

    private boolean init = false;

    public ChoosePlayer(){
         init = false;
    }

    public void init() {
        //background
        Rectangle myRectangle = new Rectangle(10, 10, 800, 800);
        myRectangle.setColor(Color.PINK);
        myRectangle.fill();

        //picture Player
        Picture picturePlayer = new Picture(10, 10, "resources/Choose Player.png");
        picturePlayer.draw();

        keyboardInit();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if(keyboardEvent.getKey() == keyboardEvent.KEY_LEFT && !init){
            GameSceneShellbys gameSceneShellbys = new GameSceneShellbys();
            init = true;
            teams = Teams.SHELLBYS;
            gameSceneShellbys.backgroundShellby();

        }

        if(keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT && !init){
            GameSceneSpartans gameSceneSpartans1 = new GameSceneSpartans();
            init = true;
            teams = Teams.SPARTANS;
            gameSceneSpartans1.backgroundSpartans();

        }


    }
    public void keyboardInit() {

        Keyboard myKeyboard = new Keyboard(this);
        // Press LEFT to select Shellbys
        KeyboardEvent LeftPress = new KeyboardEvent();
        LeftPress.setKey(KeyboardEvent.KEY_LEFT);
        LeftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(LeftPress);

        //Press RIGHT to select Spartans
        KeyboardEvent RightPress = new KeyboardEvent();
        RightPress.setKey(KeyboardEvent.KEY_RIGHT);
        RightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        myKeyboard.addEventListener(RightPress);


    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //
    }

    public static final Teams getPlayers() {
        return teams;
    }
}
