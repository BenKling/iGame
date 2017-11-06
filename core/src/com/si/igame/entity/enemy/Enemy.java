package com.si.igame.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.entity.MovingEntity;
import com.si.igame.contact.Contact;

public class Enemy extends MovingEntity implements Contact 
{
    //public Weapon weapon;
    
    public Enemy()
    {
        move(new Vector2(100, 100));
    }
    
    //Methods
    public void update(float delta)
    {
        //AI things
    }
    
    @Override
    public void onContact(Entity e) 
    {
            e.addHealth(-1);
            System.out.println(e.getHealth());    
    }

    @Override
    public boolean isContact(Entity e) 
    {
        return e.getBounds().overlaps(this.getBounds());
    }
    
}
