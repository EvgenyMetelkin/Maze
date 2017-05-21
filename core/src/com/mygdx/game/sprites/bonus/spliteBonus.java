package com.mygdx.game.sprites.bonus;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.sprites.Resource;
import com.mygdx.game.sprites.activeBall;
import com.mygdx.game.sprites.objectGame;


/**
 * Created by kubik on 19.05.2017.
 */

public class spliteBonus extends objectBonus {

    private int size_radius = 12;

    private boolean useBonus = false;

    private boolean createBall = false;

    private activeBall aBall_splite;

    private CircleShape shape;

    private int X, Y;

    public spliteBonus(int x, int y, World world) {
        super(world);

        X = x;
        Y = y;

        shape = new CircleShape();
        setPosition(x, y);
        createBody(shape);

        sprite = new Sprite(Resource.atl.findRegion("speedbonus"));
        sprite.setBounds(x - size_radius, y - size_radius, size_radius * 2, size_radius * 2);

        //body.setUserData("incSpeed");
    }

    public void collision(activeBall ball){

        if (!createBall) {
            aBall_splite = new activeBall(X, Y, 0.1f, 0.3f, world);
        }
        createBall = true;
        useBonus = true;
    }

    public activeBall getaBall_splite(){
        return aBall_splite;
    }

    public boolean useBonus(){
        return useBonus;
    }
}