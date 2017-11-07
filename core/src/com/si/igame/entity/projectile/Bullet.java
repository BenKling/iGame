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
        m_speed = 200;
        direction = new Vector2(cos(angle), sin(angle));
        setTexture("bullet.png");
        m_sprite.scale(0.25f);
    }

    public void update(float delta)
    {
        move(new Vector2(direction.x, direction.y), delta);
    }
    
    @Override
    public void onContact(Entity e) 
    {
        e.addHealth(-20);
    }

    @Override
    public boolean isContact(Entity e) 
    {
        if(this.getBounds().overlaps(e.getBounds()))
        {
            return true;
        }
        
        return false;
    }
    
    
    
    
}
