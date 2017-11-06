package com.si.igame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.si.igame.entitymanager.EntityManager;

public class iGame extends ApplicationAdapter {
    SpriteBatch batch;
    EntityManager entityManager;
    
    @Override
    public void create()
    {
        entityManager = new EntityManager();
        
        batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        float delta = Gdx.graphics.getDeltaTime();
        
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        entityManager.update(delta);
        
        batch.begin();
            entityManager.draw(batch);
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
} 
//testing add
