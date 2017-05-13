package com.mygdx.game.sprites;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kubik on 12.05.2017.
 */

public class activeBall extends objectGame {

    public activeBall(int x, int y, float density, float restitution, World world) {
        super(world);

        setPosition(x, y);
        CircleShape shape = new CircleShape();
        shape.setRadius(20);
        createBody(shape, BodyDef.BodyType.DynamicBody, density, restitution);
    }
}
