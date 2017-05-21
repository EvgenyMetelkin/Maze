package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.sprites.Resource;
import com.mygdx.game.sprites.Wall;
import com.mygdx.game.sprites.activeBall;
import com.mygdx.game.sprites.activeWall;
import com.mygdx.game.sprites.bonus.coins;
import com.mygdx.game.sprites.bonus.speedBonus;
import com.mygdx.game.sprites.bonus.spliteBonus;
import com.mygdx.game.sprites.sideWall;

import static com.mygdx.game.MazeActivity.CAMERAHEIGHT;
import static com.mygdx.game.MazeActivity.CAMERAWIDTH;

public class PlayState extends State {

    private activeBall aBall_1,  aBall_2;
    private sideWall sWall;
    private Wall wall_1, wall_2, wall_3, wall_4, wall_5, wall_6, wall_7, wall_8, wall_9, wall_10, wall_11, wall_12, wall_13, wall_14;
    private activeWall aWall_1;

    private speedBonus incSpeed_1, incSpeed_2, decSpeed_1;
    private spliteBonus splite_1, splite_2;

    private coins coins_1, coins_2;
    private int coin_pocket = 0;

    private  int wall_width = 10;

    private World world;

    public Box2DDebugRenderer rend;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        /////////////////магия///////////////////////
        world = new World(new Vector2(0, 0), true);//
        world.setContactListener(new MyContact()); //
        rend = new Box2DDebugRenderer();           //
        /////////////////////////////////////////////

        aBall_1 = new activeBall(200, 0, 0.4f, 0.4f, world);
        aBall_2 = new activeBall(300, 0, 0.4f, 0.4f, world);


        incSpeed_1 = new speedBonus(50, 30, world);
        incSpeed_2 = new speedBonus(150, 30, world);
        decSpeed_1 = new speedBonus(30, 300, world);

        splite_1 = new spliteBonus(30, 130, world);
        splite_2 = new spliteBonus(30, 200, world);

        coins_1 = new coins(100, 20, 0, 0, world);
        coins_2 = new coins(400, 20, 0, 0, world);


        sWall = new sideWall(0, 0, world);

        wall_1  = new Wall(50, 50, 350, wall_width, world);
        wall_2  = new Wall(450, 50, 300, wall_width, world);
        //wall_3 = new activeWall(50, 50, wall_width, 350, world);
       // wall_3  = new Wall(50, 50, wall_width, 350, world);
        wall_4  = new Wall(725, 50, wall_width, 350, world);
        wall_5  = new Wall(50, 375, 700, wall_width, world);
        wall_6  = new Wall(125, 125, 550, wall_width, world);
        wall_7  = new Wall(125, 125, wall_width, 200, world);
        wall_8  = new Wall(200, 200, wall_width, 200, world);
        wall_9  = new Wall(275, 125, wall_width, 200, world);
        wall_10 = new Wall(350, 200, wall_width, 200, world);
        wall_11 = new Wall(425, 125, wall_width, 200, world);
        wall_12 = new Wall(500, 200, wall_width, 200, world);
        wall_13 = new Wall(575, 125, wall_width, 200, world);
        wall_14 = new Wall(650, 200, wall_width, 200, world);

        camera.setToOrtho(false, CAMERAHEIGHT, CAMERAWIDTH);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

        aBall_1.updetePositionBody();
        aBall_2.updetePositionBody();
//        aBall_3.updetePositionSprite();
//        aBall_4.updetePositionSprite();
//        aBall_5.updetePositionBody();
//        aBall_6.updetePositionBody();


        if (incSpeed_1.checkCollision(aBall_1)) {incSpeed_1.collision(aBall_1, 2f);}
        if (incSpeed_2.checkCollision(aBall_1)) {incSpeed_2.collision(aBall_1, 4f);}
        if (decSpeed_1.checkCollision(aBall_1)) {decSpeed_1.collision(aBall_1, 0.24f);}

        if (splite_1.checkCollision(aBall_1)) {splite_1.collision(aBall_1);}
        if (splite_2.checkCollision(aBall_1)) {splite_2.collision(aBall_1);}

        coin_pocket += coins_1.updeteCoins();
        coin_pocket += coins_2.updeteCoins();
        //incSpeed_1.checkCollision(2f);
       // incSpeed_2.checkCollision(4f);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();

        aWall_1 = new activeWall(50, 50, wall_width, 350, 100, world);

        sWall.getSprite().draw(sb); //  фон

        //////////////////счет и время//////////////////////////////////////////////////////////////////
        Resource.font.draw(sb, "coins", CAMERAHEIGHT - 300, CAMERAWIDTH - 5);
        Resource.font.draw(sb, Integer.toString(coin_pocket) , CAMERAHEIGHT - 170, CAMERAWIDTH - 5);
        ////////////////////////////////////////////////////////////////////////////////////////////////

        aBall_1.getSprite().draw(sb);
        aBall_2.getSprite().draw(sb);


        //////////////////бонусы//////////////////////
        if (!incSpeed_1.useBonus()) {
            incSpeed_1.getSprite().draw(sb);
        }
        if (!incSpeed_2.useBonus()) {
            incSpeed_2.getSprite().draw(sb);
        }
        if (!decSpeed_1.useBonus()) {
            decSpeed_1.getSprite().draw(sb);
        }


        if (!splite_1.useBonus()) {
            splite_1.getSprite().draw(sb);
        }
        else {
            splite_1.getaBall_splite().updetePositionBody();
            splite_1.getaBall_splite().getSprite().draw(sb);
        }

        if (!splite_2.useBonus()) {
            splite_2.getSprite().draw(sb);
        }
        else {
            splite_2.getaBall_splite().updetePositionBody();
            splite_2.getaBall_splite().getSprite().draw(sb);
        }

        coins_1.getSprite().draw(sb);
        coins_2.getSprite().draw(sb);

        /////////////////////////////////////////////////////////

//        aBall_2.getSprite().draw(sb);
//        aBall_3.getSprite().draw(sb);
//        aBall_4.getSprite().draw(sb);
//        aBall_5.getSprite().draw(sb);
//        aBall_6.getSprite().draw(sb);

        sb.end();

        ///////////////магия//////////////////////
        world.step(1 / 60f, 4, 4);
        sb.setProjectionMatrix(camera.combined);
        rend.render(world, camera.combined);
        //////////////////////////////////////////

        sb.begin();

        wall_1.getSprite().draw(sb);
        wall_2.getSprite().draw(sb);
//        wall_3.getSprite().draw(sb);
        wall_4.getSprite().draw(sb);
        wall_5.getSprite().draw(sb);
        wall_6.getSprite().draw(sb);
        wall_7.getSprite().draw(sb);
        wall_8.getSprite().draw(sb);
        wall_9.getSprite().draw(sb);
        wall_10.getSprite().draw(sb);
        wall_11 .getSprite().draw(sb);
        wall_12 .getSprite().draw(sb);
        wall_13 .getSprite().draw(sb);
        wall_14 .getSprite().draw(sb);

        aWall_1.dispose(world);

        sb.end();

    }

    @Override
    public void dispose() {

    }
}
