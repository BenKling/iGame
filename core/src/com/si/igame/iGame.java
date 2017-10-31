package com.si.igame;

import com.si.igame.entity.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.si.igame.entity.enemy.Enemy;
import com.si.igame.entity.player.Player;

public class iGame extends ApplicationAdapter {
    SpriteBatch batch;
    Player p;
    Enemy e;
    
    @Override
    public void create()
    {
        e = new Enemy();
        p = new Player();
        batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        p.updateInput();
        batch.begin();
        e.draw(batch, 0, 0, 0, 0);
        p.draw(batch, 0, 0, 0, 0);
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
