package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 * Created by kubik on 12.05.2017.
 */

public class activeBall extends objectGame {

    private int size_radius = 20;

    public activeBall(float x, float y, float density, float restitution, World world) {
        super(world);

        setPosition(x, y);
        CircleShape shape = new CircleShape();
        shape.setRadius(size_radius);
        createBody(shape, BodyDef.BodyType.DynamicBody, density, restitution);

        sprite = new Sprite(Resource.atl.findRegion("ball1"));
        sprite.setBounds(-size_radius * 2, -size_radius * 2, size_radius * 2, size_radius * 2);

        body.setUserData("activBall");
    }

    public float getRadius(){
        return size_radius;
    }

}
