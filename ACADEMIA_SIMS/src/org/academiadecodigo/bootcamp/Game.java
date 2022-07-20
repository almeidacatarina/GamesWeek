package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Detectors.ColisionDetSpartans;
import org.academiadecodigo.bootcamp.Scenes.ChoosePlayer;
import org.academiadecodigo.bootcamp.Scenes.GameSceneSpartans;
import org.academiadecodigo.bootcamp.Scenes.MenuScene;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private MenuScene menuScene;

    private ChoosePlayer choosePlayer;

    private GameSceneSpartans gameSceneSpartans;

    private Picture shellby;

    private Picture spartans;

    private ColisionDetSpartans colisionDetSpartans;
    public Game() {
        menuScene = new MenuScene();
        choosePlayer = new ChoosePlayer();
        gameSceneSpartans = new GameSceneSpartans();
    }
    
    public void init() {
       menuScene.init();
    }





    public void goToGamePage() {

    }


}






