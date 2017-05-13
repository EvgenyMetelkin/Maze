package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by kubik on 12.05.2017.
 */

public class objectGame extends Actor{

    protected Sprite sprite;
    protected Body body;

    float accelX;
    float accelY;

    World world;

    public objectGame(World world){
        this.world = world;
    }


    protected  void createBody(Shape shape, BodyDef.BodyType type, float density, float restitution){

        BodyDef bDef = new BodyDef();
        bDef.position.set(getX(), getY());
        bDef.type = type;

        body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.restitution = restitution;
        fDef.density = density;
        fDef.friction = 0.5f;

        body.createFixture(fDef);
    }

    public  void updete(){
        accelY = Gdx.input.getAccelerometerY();
        accelX = Gdx.input.getAccelerometerX();

        body.applyForceToCenter(new Vector2(accelY*10000,-accelX*10000), true);
    }
}
