package com.si.igame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.drawable.Drawable;

public abstract class Entity implements Drawable
{
    private Texture m_texture;
    protected Sprite m_sprite;
    protected int m_health;
    
    public Entity()
    {
        m_health = 1;
        m_texture = new Texture("missing.png");
        m_sprite = new Sprite(m_texture );
    }
    
    //Getters
    public int getHealth()
    {
        return m_health;
    }
    
    public Rectangle getBounds()
    {
        return m_sprite.getBoundingRectangle();
    }
    
    //Setters
    public void setPosition(Vector2 pos)
    {
        m_sprite.setPosition(pos.x, pos.y);
    }
    
    public void setTexture(String file)
    {
        m_texture.dispose();
        m_texture = new Texture(file);
        m_sprite.setTexture(m_texture);
    }
    
    public void setHealth(int health)
    {
        m_health = health;
    }
    
    //Methods    
    public void update(float delta)
    {
        
    }
    
    public void addHealth(int healthToAdd)
    {
        m_health += healthToAdd;
        
    }

    @Override
    public void draw(Batch batch)
    {
        batch.draw(m_sprite.getTexture(), m_sprite.getX(), m_sprite.getY(),
                m_sprite.getWidth() * m_sprite.getScaleX(),
                m_sprite.getHeight() * m_sprite.getScaleY());
    }
}
