package com.mygdx.game.sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kubik on 12.05.2017.
 */

public class Wall extends objectGame {

    public Wall(int x, int y, int height, int wight, World world) {
        super(world);

        setBounds(x, y, x + height, y + wight);
        ChainShape shape = new ChainShape();
        shape.createChain(new Vector2[]{new Vector2(x,y + height), new Vector2(x,y), new Vector2(x + wight, y), new Vector2(x + wight, y + height), new Vector2(x,y + height)});
        createBody(shape, BodyDef.BodyType.StaticBody, 0.5f, 0.4f);
    }
}
