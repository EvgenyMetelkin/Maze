package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kubik on 12.05.2017.
 */

public class activeWall extends objectGame {


    private ChainShape shape;

    public activeWall(int x, int y, int wight, int height, int shift, World world) {
        super(world);
        sprite = new Sprite(Resource.atl.findRegion("black"));
        sprite.setBounds(x, y, wight, height);

        //setBounds(x, y, x + height, y + wight);
        shape = new ChainShape();
        shape.createChain(new Vector2[]{new Vector2(x,y + height), new Vector2(x,y), new Vector2(x + wight, y), new Vector2(x + wight, y + height), new Vector2(x,y + height)});
        createBody(shape, BodyDef.BodyType.StaticBody, 0.5f, 0.4f);

        body.setUserData("activWall");
    }

    public void dispose(World world){
        sprite.setPosition(body.getPosition().x , body.getPosition().y );

        body.setActive(false);

        world.destroyBody(body);
    }
}
