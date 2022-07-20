package org.academiadecodigo.bootcamp;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        Game myGame = new Game();
        myGame.init();

        String resource = "resources/Peaky Blinders.wav";
        InputStream input = Sound.class.getResourceAsStream(resource);
        Sound player = new Sound();
        player.play(resource);

        }
    }

