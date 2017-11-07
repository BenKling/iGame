package com.si.igame.entitymanager;

import com.badlogic.gdx.graphics.Camera;
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
    public ArrayList<Enemy> m_enemies;
    public ArrayList<Bullet> m_bullets;
    public Player m_player;
    
    public EntityManager()
    {
    	m_player = new Player();
    	
    	m_enemies = new ArrayList<Enemy>();
    	m_bullets = new ArrayList<Bullet>();
    	
        m_enemies.add(new Enemy());
        m_bullets.add(new Bullet(new Vector2(100, 20), (float) (Math.PI/2)));
        m_player = new Player();
        
        Weapon w = new Weapon(m_bullets, 5);
        m_player.setWeapon(w);
    }
    
    public void update(Camera camera, float delta)
    {
        ArrayList<Entity> deadEntities = new ArrayList<Entity>();
        
        
        for(Entity e: m_enemies)
        {
            e.update(delta);
            
            if(e.getHealth() <= 0)
            {
                deadEntities.add(e);
            }
        }
        
        for(Bullet bullet: m_bullets)
        {
            bullet.update(delta);
            
            for(Enemy enemy: m_enemies)
            {
                if(bullet.isContact(enemy))
                {
                    bullet.onContact(enemy);
                    deadEntities.add(bullet);
                }
            }
        }
        
        for(Entity e: deadEntities)
        {
            m_enemies.remove(e);
            m_bullets.remove(e);
        }
        
        m_player.updateInput(camera, delta);
        
        m_player.update(delta);
    }
    
    public void draw(Batch batch)
    {
        for(Entity e: m_enemies)
        {
            e.draw(batch);
        }        
        
        for(Entity e: m_bullets)
        {
            e.draw(batch);
        }
        
        m_player.draw(batch);
    }
}