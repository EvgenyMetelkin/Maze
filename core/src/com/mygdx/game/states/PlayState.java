package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.sprites.Wall;
import com.mygdx.game.sprites.activeBall;
import com.mygdx.game.sprites.footballBall;
import com.mygdx.game.sprites.sideWall;
import com.mygdx.game.sprites.stoneBall;

import static com.mygdx.game.MazeActivity.CAMERAHEIGHT;
import static com.mygdx.game.MazeActivity.CAMERAWIDTH;

public class PlayState extends State {

    Texture background;
    private footballBall fBall;
    private activeBall aBall1,aBall2,aBall3,aBall4,aBall5,aBall6;
    private sideWall sWall;
    private Wall wall_1, wall_2;

    private World world;

    public Box2DDebugRenderer rend;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        world = new World(new Vector2(0, 0), true);

        background = new Texture("backgroundStandart.jpg");
        fBall = new footballBall(100, 300);
        aBall1 = new activeBall(300, 200, 0.3f, 0.3f, world);
        aBall2 = new activeBall(300, 300, 0.4f, 0.4f, world);
        aBall3 = new activeBall(300, 100, 0.11f, 0.4f, world);
        aBall4 = new activeBall(400, 200, 0.1f, 0.4f, world);
        aBall5 = new activeBall(400, 200, 0.2f, 0.2f, world);
        aBall6 = new activeBall(400, 200, 0.1f, 0.2f, world);
        sWall = new sideWall(0,0,world);

        wall_1 = new Wall(100, 100, 100, 20, world);
        wall_2 = new Wall(100, 100, 20, 100, world);

        camera.setToOrtho(false, CAMERAHEIGHT, CAMERAWIDTH);

        rend = new Box2DDebugRenderer();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        fBall.updete();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(fBall.getBall(), fBall.getY(), fBall.getX());
        sb.end();

        rend.render(world, camera.combined);

        world.step(1 / 60f, 4, 4);

        aBall1.updete();
        aBall2.updete();
        aBall3.updete();
        aBall4.updete();
        aBall5.updete();
        aBall6.updete();
    }

    @Override
    public void dispose() {
        fBall.dispose();
    }
}
