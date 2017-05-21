package com.mygdx.game.sprites.bonus;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.sprites.Resource;
import com.mygdx.game.sprites.activeBall;

/**
 * Created by kubik on 19.05.2017.
 */

public class speedBonus extends objectBonus {

    private int size_radius = 12;

    private boolean useBonus = false;

    public speedBonus(int x, int y, World world) {
        super(world);

        CircleShape shape = new CircleShape();
        setPosition(x, y);
        createBody(shape);

        sprite = new Sprite(Resource.atl.findRegion("speedbonus"));
        sprite.setBounds(x - size_radius, y - size_radius, size_radius * 2, size_radius * 2);

    }

    public void collision(activeBall ball, float addSpeed){
        ball.setSpeed(addSpeed);
        useBonus = true;
    }

    public boolean useBonus(){
        return useBonus;
    }
}
