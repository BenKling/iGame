package com.si.igame.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;


public abstract class Entity implements Drawable
{
    private Texture m_texture;
    protected Sprite m_sprite;
    protected int m_health;
    
    public Entity()
    {
        m_texture = new Texture("enemy.png");
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
    public void draw(Batch batch, float x, float y, float width, float height)
    {
        batch.draw(m_sprite.getTexture(), m_sprite.getX(), m_sprite.getY());
    }

    
    @Override
    public float getLeftWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLeftWidth(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getRightWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRightWidth(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getTopHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTopHeight(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getBottomHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBottomHeight(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getMinWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMinWidth(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getMinHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMinHeight(float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
