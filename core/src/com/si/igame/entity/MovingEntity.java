package com.si.igame.entity;

import com.badlogic.gdx.math.Vector2;


public abstract class MovingEntity extends Entity
{
    protected float m_speed = 1.0f;
    
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
        m_sprite.translate(direction.x * m_speed , direction.y * m_speed);
    }
}
