package com.si.igame.weapon;

import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.projectile.Bullet;
import java.util.ArrayList;

public class Weapon 
{
    protected float m_attackSpeed;
    protected ArrayList<Bullet> m_bullets;
    
    public Weapon(ArrayList<Bullet> bullets, float attackSpeed)
    {
        m_bullets = bullets;
        m_attackSpeed = attackSpeed;
    }
    
    public void shoot(Vector2 pos, float angle )
    {
        m_bullets.add(new Bullet(pos, angle));
    }
    
    
    
}
