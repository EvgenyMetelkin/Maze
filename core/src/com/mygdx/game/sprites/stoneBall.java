package com.mygdx.game.sprites;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by kubik on 11.05.2017.
 */

public class stoneBall extends objectGame {

    public stoneBall(int x, int y, World world) {
        super(world);

        setPosition(x, y);
        CircleShape shape = new CircleShape();
        shape.setRadius(20);
        createBody(shape, BodyDef.BodyType.DynamicBody, 0.4f, 0.4f);
    }

      /*Body rect;
        public World world;

        float accelX;
        float accelY;

        public stoneBall (int x, int y){
        world = new World(new Vector2(0, 0), true);

        BodyDef bDef = new BodyDef();
        bDef.type = BodyDef.BodyType.DynamicBody;
        bDef.position.set(x, y);

        rect = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();

        CircleShape shape = new CircleShape();
        shape.setRadius(10);

        fDef.shape = shape;
        fDef.density = 0.4f;
        fDef.restitution = 0.5f;
        fDef. = 0.2f;

        rect.createFixture(fDef);

        }

        public  void updete(){
        accelY = Gdx.input.getAccelerometerY();
        accelX = Gdx.input.getAccelerometerX();

        rect.applyForceToCenter(new Vector2(accelY*10000,-accelX*10000), true);
        }

        public World getWorld(){
        return world;
        }

        public void dispose() {
        }
        */

}

