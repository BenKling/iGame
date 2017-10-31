package com.si.igame.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.MovingEntity;

public class Player extends MovingEntity
{
    //private Weapon m_weapon;
    
    public Player()
    {
        super();
        setHealth(100);
        setSpeed(5);
        
    }
    
    //Methods
    public void updateInput()
    {        
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            move(new Vector2(-1,0));
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            move(new Vector2(0,-1));
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            move(new Vector2(0,1));
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            move(new Vector2(1,0));
        }
        
    }
}
