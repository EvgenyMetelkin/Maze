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

    private static float speedBonus = 1;

    private float accelX;
    private float accelY;

    private World world;

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
        fDef.restitution = restitution; // упругость
        fDef.density = density; // плотность
        fDef.friction = 0.5f; // трение
      //  fDef.filter.groupIndex = 5;

        body.createFixture(fDef);
    }

    public  void updetePositionSprite(){
        sprite.setPosition(body.getPosition().x - 20, body.getPosition().y - 20);
        sprite.setRotation(body.getAngle()  * 60);
    }

    public void updetePositionBody(){
        if (this.body.getUserData() == "contactAndDead") {
            sprite.setPosition(-40f , -40f);
            body.setActive(false);

            world.destroyBody(body);
            body.setUserData("non");
            return;
        }
        if (this.body.getUserData() == "activBall") {
            accelY = Gdx.input.getAccelerometerY();
            accelX = Gdx.input.getAccelerometerX();
            body.applyForceToCenter(new Vector2(accelY * 12000 * speedBonus, -accelX * 12000 * speedBonus), true);

            updetePositionSprite();
        }
    }

    public int updeteCoins(){

        if(body.getUserData() == "coinsNon"){
            sprite.setPosition(-40f , -40f);
            body.setActive(false);

            world.destroyBody(body);
            body.setUserData("non");

            return 1;
        }
        return 0;
    }


    public Sprite getSprite(){
        return sprite;
    }

    public void setSpeed(float speed){
        speedBonus = speed;
    }

    public World getWorld(){
        return world;
    }

    public Body getBody(){
        return body;
    }

}
