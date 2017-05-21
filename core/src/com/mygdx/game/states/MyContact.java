package com.mygdx.game.states;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import com.badlogic.gdx.physics.box2d.WorldManifold;
import com.mygdx.game.sprites.activeBall;


/**
 * Created by kubik on 20.05.2017.
 */

public class MyContact implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Body fixA = contact.getFixtureA().getBody();
        Body fixB = contact.getFixtureB().getBody();

        if(fixA.getUserData() != null && fixB.getUserData() != null) {
            if (fixA.getUserData().equals("activBall") && fixB.getUserData().equals("activWall")) {
                fixA.setUserData("contactAndDead");
            }
            if(fixA.getUserData().equals("activWall") && fixB.getUserData().equals("activBall")) {
                fixB.setUserData("contactAndDead");
            }

            if (fixA.getUserData().equals("activBall") && fixB.getUserData().equals("coins")) {
                fixB.setUserData("coinsNon");
            }
            if(fixA.getUserData().equals("coins") && fixB.getUserData().equals("activBall")) {
                fixA.setUserData("coinsNon");
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
//        activeBall ball = new activeBall();
//        Body fixA = contact.getFixtureA().getBody();
//        Body fixB = contact.getFixtureB().getBody();
//
//        if(fixA.getUserData() != null && fixB.getUserData() != null) {
//            if (fixA.getUserData().equals("activBall") && fixB.getUserData().equals("incSpeed")) {
//                //if(fixA.getClass().equals(activeBall.class) && fixB.getClass().equals(speedBonus.class) || fixB.getClass().equals(activeBall.class) && fixA.getClass().equals(speedBonus.class)){
//                //System.out.print("fasd");
//                ball.setSpeed(100f);
//                useSpeedBonus = true;
//                //fixA.setActive(false);
//                //fixA.getWorld().destroyBody(fixA);
//            }
//            if(fixA.getUserData().equals("incSpeed") && fixB.getUserData().equals("activBall")) {
//                //fixB.setActive(false);
//                //fixB.getWorld().destroyBody(fixB);
//            }
//        }
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
