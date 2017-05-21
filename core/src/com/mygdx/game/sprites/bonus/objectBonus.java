package com.mygdx.game.sprites.bonus;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.sprites.activeBall;

/**
 * Created by kubik on 19.05.2017.
 */

public class objectBonus extends Actor {
    protected Sprite sprite;
    protected Body body;
    World world;

    public objectBonus(World world) {
        this.world = world;
    }


    protected void createBody(Shape shape) {

        BodyDef bDef = new BodyDef();
        bDef.position.set(getX(), getY());
        bDef.type = BodyDef.BodyType.StaticBody;

        body = world.createBody(bDef);

        FixtureDef fDef = new FixtureDef();
        fDef.shape = shape;
        fDef.filter.categoryBits = 0x0004;
        fDef.filter.maskBits = 0;

        body.createFixture(fDef);

    }

    public Sprite getSprite(){
        return sprite;
    }

    public boolean checkCollision(activeBall ball){
        if((ball.getBody().getPosition().x + ball.getRadius() >= this.getX()) && (ball.getBody().getPosition().x <= this.getX()) && (ball.getBody().getPosition().y + ball.getRadius() >= this.getY()) && (ball.getBody().getPosition().y <= this.getY())){
            return true;
        }
        return false;
    }

}