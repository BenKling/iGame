package com.si.igame.entity.projectile;

import static com.badlogic.gdx.math.MathUtils.cos;
import static com.badlogic.gdx.math.MathUtils.sin;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.entity.MovingEntity;
import com.si.igame.entity.player.Player;

public class Bullet extends MovingEntity
{
    private Vector2 m_direction;
    private float m_maxTravelTime;
    private float m_currentTravelTime;
    
    
    public Bullet(Vector2 pos, float angle, float maxTravelTime, int team)
    {
        super();
        m_maxTravelTime = maxTravelTime;
        m_currentTravelTime = 0.0f;
        m_sprite.setPosition(pos.x, pos.y);
        m_speed = 200;
        m_direction = new Vector2(cos(angle), sin(angle));
        setTexture("bullet.png");
        m_sprite.scale(0.25f);
        m_team = team;
    }

    public void update(float delta)
    {
        m_currentTravelTime += delta;
        
        if(m_currentTravelTime >= m_maxTravelTime)
        {
            m_isDead = true;
        }
        
        move(new Vector2(m_direction.x, m_direction.y), delta);
    }
    
    @Override
    public void onContact(Entity e) 
    {
        if(e.getTeam() != getTeam())
        {
            e.addHealth(-20);
            setDead(true);
        }
    }
}