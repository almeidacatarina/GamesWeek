package org.academiadecodigo.bootcamp;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Actions extends Player{

    // A minha lógica seria os valores andarem entre 0 e 200;
    // Souts representam as frases que dariam display na janela do jogo
    // Diferentes ações influenciam as stats com pesos diferentes
    private int hunger;
    private int stress;
    private int sleepiness=50;
    private int sanity;
    private int programmingSkills;
    private int happiness;

    public Actions(Position position, Picture playerPicture) {
        super(position, playerPicture);
    }

    public void work(){

        if(sleepiness>150){
            System.out.println("I can't work right now, must either drink coffee or sleep..");
        }
        if(sleepiness<=150 && sleepiness > 0){
        this.sleepiness=sleepiness+30;}

        this.programmingSkills=programmingSkills+40;
        this.stress=stress+30;
        if(sanity>0 && sanity <200){ this.sanity=sanity - 40;}

        //Exemplo de algo que poderia fazer display
        System.out.println("I've programmed for 2 hours! Time for a break!");
        //A de cima seria a fala na 1a pessoa e em baixo seria um display do jogo dado para o jogador
        System.out.println("---- Your sleepiness is now at " + "-"+ sleepiness +"-"+ " out of 200!----");
        System.out.println("I should probably drink some coffee..");
    }

    public void playPingPong(){
        this.happiness=happiness+25;
        this.sanity=sanity+30;
        this.stress=stress-40;
        System.out.println("I feel like I cleared my head for now. Time to work!");
        this.hunger=hunger + 10;
    }

    public void drinkCoffee(){
        if(sleepiness==0){
            System.out.println("I'm fully awake! Can't drink anymore coffee!");
            return;
        }
        if(sleepiness>0 && sleepiness<200) {
            this.sleepiness = sleepiness - 50;
            this.stress=stress+3;
            System.out.println("I'm feeling more awake right now!");
        }
    }

    public void eat(){
        if(hunger>0 && hunger < 200){
            this.hunger=hunger-50;
            System.out.println("I have more energy now!");
            this.happiness=happiness + 10;
        }
    }

    public void sleep(){
        if (sleepiness>100){
            this.sleepiness=sleepiness-70;
            this.sanity=sanity + 10;
            this.stress=stress-30;
            this.happiness = happiness + 5;
            System.out.println("I feel more rested now! Ready to do something!");
        }
    }

    public void presentation(){
        this.stress=stress+70;
        System.out.println("");
    }

    public void talkToMC(){
        switch ((int)Math.floor(Math.random()*2)){
            case 0:
                System.out.println("MC USED METHOD CONFUSE!");
                this.programmingSkills=programmingSkills-20;
            case 1:
                System.out.println("");
                this.programmingSkills=programmingSkills+10;
        }
    }

    //podíamos acrescentar uma cena tipo "Morrer" que acontecia caso deixássemos a hunger chegar a 200 ou a sanidade chegar a 0




}
