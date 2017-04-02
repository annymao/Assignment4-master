package com.sslab.pokemon;

import com.sslab.pokemon.guicomponent.PokemonLabel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jerry on 2017/3/26.
 */
public class GameThread implements Runnable {
    ArrayList<PokemonLabel> pokemons;
        public GameThread(ArrayList<PokemonLabel> pokemonLabels){
            //TODO create and start the thread
            pokemons=pokemonLabels;
            Thread gameThread = new Thread(this);
            gameThread.start();

        }



        @Override
        public void run() {
            while(true)
            {
                //TODO Update the pokemonLabels
                Random random = new Random();

                    pokemons.get(random.nextInt(5)).Update();

                //TODO use Thread.sleep to make the loop go slower
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

}
