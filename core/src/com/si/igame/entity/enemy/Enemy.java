package com.si.igame.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.entity.MovingEntity;
import com.si.igame.weapon.Weapon;

public class Enemy extends MovingEntity
{
    protected Enemy(EnemyBuilder enemyBuilder)
    {
        setTexture(enemyBuilder.m_textureFile);
        m_sprite.setScale(enemyBuilder.m_scale);
        m_speed = enemyBuilder.m_speed;
        m_health = enemyBuilder.m_health;
        m_team = 1;
    }
    
    //Methods
    public void update(float delta)
    {
        if(getHealth() <= 0)
        {
            setDead(true);
        }
    }
    
    @Override
    public void onContact(Entity e) 
    {
            e.addHealth(-1);
    }
}
