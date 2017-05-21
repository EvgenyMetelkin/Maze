package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.MazeActivity.CAMERAHEIGHT;
import static com.mygdx.game.MazeActivity.CAMERAWIDTH;

/**
 * Created by kubik on 12.05.2017.
 */

public class sideWall extends objectGame {

    public sideWall(int x, int y, World world) {
        super(world);

        setBounds(0, 0, 480, 800);
        ChainShape shape = new ChainShape();
        shape.createChain(new Vector2[]{new Vector2(0,CAMERAWIDTH), new Vector2(0,0), new Vector2(CAMERAHEIGHT, 0), new Vector2(CAMERAHEIGHT, CAMERAWIDTH), new Vector2(0,CAMERAWIDTH)});
        createBody(shape, BodyDef.BodyType.StaticBody, 0.5f, 0.4f);

        sprite = new Sprite(Resource.atl.findRegion("backgroundStandart"));
       // sprite.setBounds(0, 0, CAMERAHEIGHT, CAMERAWIDTH);
    }
}
