package com.si.igame.entity.projectile;

import static com.badlogic.gdx.math.MathUtils.cos;
import static com.badlogic.gdx.math.MathUtils.sin;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.contact.Contact;
import com.si.igame.entity.MovingEntity;

public class Bullet extends MovingEntity implements Contact
{
    private Vector2 direction;
    
    
    public Bullet(Vector2 pos, float angle)
    {
        super();
        m_sprite.setPosition(pos.x, pos.y);
        m_speed = 100;
        direction = new Vector2(cos(angle), sin(angle));
    }

    public void update(float delta)
    {
        move(new Vector2(direction.x * delta, direction.y * delta));
    }
    
    @Override
    public void onContact(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isContact(Entity e) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
