package com.si.igame.entitymanager;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.contact.ContactManager;
import com.si.igame.entity.Entity;
import com.si.igame.entity.enemy.*;
import com.si.igame.entity.player.Player;
import com.si.igame.entity.projectile.Bullet;
import com.si.igame.weapon.Weapon;
import java.util.ArrayList;

public class EntityManager 
{
    private ArrayList<Enemy> m_enemies;
    private ArrayList<Bullet> m_bullets;
    private ContactManager m_contact;
    private Player m_player;
    
    public EntityManager()
    {
        m_contact = ContactManager.getContactManager();
        EnemyBuilder enemyBuilder = new EnemyBuilder();
    	m_player = new Player();
    	m_enemies = new ArrayList<Enemy>();
    	m_bullets = new ArrayList<Bullet>();
    	
        Weapon w = new Weapon(m_bullets, 5);
        m_player.setWeapon(w);
        m_contact.addEntity(m_player);
        
        enemyBuilder.setAttackSpeed(.75f).setDamage(20).setTextureFile("enemy.png").setHealth(100).setScale(2).setSpeed(250);
        Enemy e = enemyBuilder.build();
        e.setPosition(new Vector2(200, 250));
        m_enemies.add(e);
        m_contact.addEntity(e);
        
        enemyBuilder.setTextureFile("bossfight.png").setHealth(400);
        e = enemyBuilder.build();
        e.setPosition(new Vector2(150, 150));
        m_enemies.add(e);
        m_contact.addEntity(e);
    }
    
    public void update(Camera camera, float delta)
    {
        ArrayList<Entity> deadEntities = new ArrayList<Entity>();
        
        m_contact.update();
        
        //Handling enemy health
        for(Entity e: m_enemies)
        {
            e.update(delta);
            
            if(e.isDead())
            {
                deadEntities.add(e);
            }
        }
        
        //Handling Bullet Despawning
        for(Bullet bullet: m_bullets)
        {
            bullet.update(delta);
            
            if(bullet.isDead())
            {
                deadEntities.add(bullet);
            }
        }
        
        //Player logic
        m_player.updateInput(camera, delta);
        m_player.update(delta);
        
        if(m_player.isDead())
        {
            m_player.onDeath();
        }
        
        //Removing any dead entities
        for(Entity e: deadEntities)
        {
            e.onDeath();
            m_contact.removeEntity(e);
            m_enemies.remove(e);
            m_bullets.remove(e);
        }
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