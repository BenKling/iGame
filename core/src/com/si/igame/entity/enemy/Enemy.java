package com.si.igame.entity.enemy;

import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.Entity;
import com.si.igame.entity.MovingEntity;
import com.si.igame.entity.player.Player;

public class Enemy extends MovingEntity
{
    //public Weapon weapon;
    
    public Enemy()
    {
        move(new Vector2(100, 100));
    }
    
    //Methods
    public void update(Player player)
    {
        //AI things
    }
    
    public void applyContact(Entity entity)
    {
        //Damage
    }
    
}
