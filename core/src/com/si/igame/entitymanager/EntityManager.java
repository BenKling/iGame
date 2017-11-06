package com.si.igame.entitymanager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.entity.enemy.Enemy;
import com.si.igame.entity.player.Player;
import com.si.igame.entity.projectile.Bullet;
import com.si.igame.weapon.Weapon;
import java.util.ArrayList;

public class EntityManager 
{
    public ArrayList<Enemy> m_enemies = new ArrayList();
    public ArrayList<Bullet> m_bullets = new ArrayList();
    public Player m_player = new Player();
    
    public EntityManager()
    {
        m_enemies.add(new Enemy());
        m_bullets.add(new Bullet(new Vector2(100, 20), (float) (Math.PI/2)));
        m_player = new Player();
        
        Weapon w = new Weapon(m_bullets, 5);
        m_player.setWeapon(w);
    }
    
    public void update(float delta)
    {
        for(Entity e: m_enemies)
        {
            e.update(delta);
        }
        
        for(Entity e: m_bullets)
        {
            e.update(delta);
        }
        
        m_player.update(delta);
    }
    
    public void draw(Batch batch)
    {
        for(Entity e: m_enemies)
        {
            e.draw(batch, 0, 0, 0, 0);
        }        
        
        for(Entity e: m_bullets)
        {
            e.draw(batch, 0, 0, 0, 0);
        }
        
        m_player.draw(batch, 0, 0, 0, 0);
    }
}