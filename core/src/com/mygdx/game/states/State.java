package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kubik on 10.05.2017.
 */

public abstract class State {
    protected OrthographicCamera camera;
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;

        camera = new OrthographicCamera();

    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
