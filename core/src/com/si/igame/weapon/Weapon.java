package com.si.igame.weapon;

import com.badlogic.gdx.math.Vector2;
import com.si.igame.contact.ContactManager;
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
    
    public void shoot(Vector2 pos, float angle, int team)
    {
        Bullet b = new Bullet(pos, angle, 1.0f, team);
        m_bullets.add(b);
        ContactManager.getContactManager().addEntity(b);
    }
}
