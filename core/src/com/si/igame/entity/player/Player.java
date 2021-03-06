package com.si.igame.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import static com.badlogic.gdx.math.MathUtils.atan2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.si.igame.entity.MovingEntity;
import com.si.igame.weapon.Weapon;

public class Player extends MovingEntity 
{
    private float interval = 0;
    private Weapon m_weapon = null;
    
    
    public Player()
    {
        super();
        setHealth(100);
        m_speed = 50;
        setTexture("player.png");
        m_sprite.setScale(2);
        m_team = 2;
    }
    
    //Methods
    @Override
    public void onDeath()
    {
        setPosition(0, 0);
        setHealth(100);
        setDead(false);
    }
    
    public void update(float delta)
    {
        if(getHealth() <= 0)
        {
            setDead(true);
        }
    }
    
    public void setWeapon(Weapon weapon)
    {
        m_weapon = weapon;
    }
    
    public void updateInput(Camera camera, float delta)
    {
        interval += delta;
        
        
        
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            move(new Vector2(-1,0), delta);
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            move(new Vector2(0,-1), delta);
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            move(new Vector2(0,1), delta);
        }
        
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            move(new Vector2(1,0), delta);
        }
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && interval >= 0.2f)
        {
            Vector2 screenCoords = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            Vector3 cameraCoords = camera.unproject(new Vector3(screenCoords.x, screenCoords.y, 0.0f));

            Vector2 cameraCoords2D = new Vector2(cameraCoords.x, cameraCoords.y);
            cameraCoords2D.sub( new Vector2(m_sprite.getX(), m_sprite.getY()) );

            float angle = atan2(cameraCoords2D.y, cameraCoords2D.x);

            m_weapon.shoot(new Vector2(m_sprite.getX(), m_sprite.getY()), angle, m_team);

            interval = 0;
        }
    }
}
