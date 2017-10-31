package com.si.igame.entity;

import com.badlogic.gdx.math.Vector2;


public abstract class MovingEntity extends Entity
{
    private float m_speed;
    
    public MovingEntity()
    {
        super();
    }
    
    //Setters
    public void setSpeed(float speed)
    {
        m_speed = speed;
    }
    
    //Methods
    public void move(Vector2 direction)
    {
        m_sprite.translate(direction.x , direction.y);
    }
}
