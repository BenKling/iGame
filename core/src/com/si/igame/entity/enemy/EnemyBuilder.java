package com.si.igame.entity.enemy;

public class EnemyBuilder 
{
    protected String m_textureFile;
    protected float m_scale;
    protected float m_speed;
    protected float m_attackSpeed;
    protected float m_damage;
    protected int m_health;

    public EnemyBuilder()
    {
        
    }

    //Methods
    public Enemy build()
    {
        return new Enemy(this);
    }
    
    public EnemyBuilder setTextureFile(String file)
    {
        m_textureFile = file;
        return this;
    }

    public EnemyBuilder setScale(float scale) 
    {
        m_scale = scale;
        return this;
    }

    public EnemyBuilder setSpeed(float speed) 
    {
        m_speed = speed;
        return this;
    }

    public EnemyBuilder setAttackSpeed(float attackSpeed) 
    {
        m_attackSpeed = attackSpeed;
        return this;
    }

    public EnemyBuilder setDamage(float damage) 
    {
        m_damage = damage;
        return this;
    }

    public EnemyBuilder setHealth(int health) 
    {
        m_health = health;
        return this;
    }
}
