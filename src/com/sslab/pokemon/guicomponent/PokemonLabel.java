package com.sslab.pokemon.guicomponent;

import com.sslab.pokemon.PokemonSprite;

import javax.swing.*;
import java.util.Random;

/**
 * Created by jerry on 2017/3/26.
 */
public class PokemonLabel extends JLabel{
    int id=0;
    public PokemonLabel()
    {
        setIcon(PokemonSprite.bushIcon());
    }

    public void Update()
    {
        //TODO setup a counter, if time up you may want to change to another state
        Random random=new Random();
        int counter = random.nextInt(50)+100;
        int count=0;
        while(count!=counter)
        {
            count++;
        }
        if(state==WhacPokemonState.Hide)
        {
            popPokemon();
        }
        else
        {
            hidePokemon();
        }
    }

    public void popPokemon(){
        //TODO when a pokemon pop up
        Random random = new Random();
        int tmp = random.nextInt(50);
        int showPoke;
        if(tmp%5==0)
        {
            showPoke=tmp%3;
        }
        else if(tmp%47==0)
        {
            showPoke=32;
        }
        else
        {
            if(tmp%2==0)
                showPoke=62;
            else
                showPoke=64;
        }
       ImageIcon img= new ImageIcon(PokemonSprite.getSprite(showPoke));
       setIcon(img);
       state=WhacPokemonState.Show;
       id=showPoke;
    }
    public void hidePokemon()
    {
        //TODO when the pokemon hide into the bushes
        setIcon(PokemonSprite.bushIcon());
        state=WhacPokemonState.Hide;
    }
    public int caught()
    {
        //TODO when player caught the pokemon
        setIcon(PokemonSprite.pokeballIcon());
        state = WhacPokemonState.Caught;
        return id;
    }

    public boolean isCatchable()
    {
        //a beautiful way to write it, no need to use if
        return state == WhacPokemonState.Show;
    }
    WhacPokemonState state = WhacPokemonState.Hide;

}
enum WhacPokemonState{
    Hide,Show,Caught
}
