package com.si.igame.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.MovingEntity;
import com.si.igame.entity.projectile.Bullet;
import com.si.igame.weapon.Weapon;

public class Player extends MovingEntity
{
    private Weapon m_weapon = null;
    
    public Player()
    {
        super();
        setHealth(100);
        setSpeed(2);
    }
    
    //Methods
    public void update(float delta)
    {
        this.updateInput();
    }
    
    public void setWeapon(Weapon weapon)
    {
        m_weapon = weapon;
    }
    
    private void updateInput()
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
        
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            m_weapon.shoot(new Vector2(m_sprite.getX(), m_sprite.getY()), (float) (Math.PI/2));
        }
        
    }
}
