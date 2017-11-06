package com.si.igame;

import com.si.igame.entity.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.si.igame.entity.enemy.Enemy;
import com.si.igame.entity.player.Player;
import com.si.igame.entity.projectile.Bullet;
import com.si.igame.entitymanager.EntityManager;

public class iGame extends ApplicationAdapter {
    SpriteBatch batch;
    EntityManager eMan;
    
    @Override
    public void create()
    {
        eMan = new EntityManager();
        
        batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        float delta = Gdx.graphics.getDeltaTime();
        
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        eMan.update(delta);
        
        batch.begin();
            eMan.draw(batch);
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
} 
//testing add
