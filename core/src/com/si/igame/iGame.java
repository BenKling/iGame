package com.si.igame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.si.igame.entitymanager.EntityManager;

public class iGame extends ApplicationAdapter {
    SpriteBatch batch;
    EntityManager entityManager;
    Camera camera;
    
    @Override
    public void create()
    {
        camera = new OrthographicCamera(1366,768);
        
        entityManager = new EntityManager();
        
        batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        
        camera.update();
        //camera.translate(0.5f, 0.5f, 0f);
        batch.setProjectionMatrix(camera.combined);
        
        float delta = Gdx.graphics.getDeltaTime();
        
        Gdx.gl.glClearColor(0, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        entityManager.update(camera, delta);
        
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
