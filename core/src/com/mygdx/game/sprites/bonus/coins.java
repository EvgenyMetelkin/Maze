package com.mygdx.game.sprites.bonus;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.sprites.Resource;
import com.mygdx.game.sprites.activeBall;
import com.mygdx.game.sprites.objectGame;

/**
 * Created by kubik on 19.05.2017.
 */

public class coins extends objectGame {

    private int size_radius = 8;


    public coins(float x, float y, float density, float restitution, World world) {
        super(world);

        setPosition(x, y);
        CircleShape shape = new CircleShape();
        createBody(shape, BodyDef.BodyType.StaticBody, density, restitution);

        sprite = new Sprite(Resource.atl.findRegion("ball1"));
        sprite.setBounds(x - size_radius, y - size_radius, size_radius * 2, size_radius * 2);

        body.setUserData("coins");;

    }
}