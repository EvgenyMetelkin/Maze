package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import static com.mygdx.game.MazeActivity.CAMERAHEIGHT;
import static com.mygdx.game.MazeActivity.CAMERAWIDTH;

/**
 * Created by kubik on 10.05.2017.
 */

public class footballBall {

    Texture img;
    TextureRegion ballImage;
    Rectangle ball;
    float accelX;
    float accelY;



    public footballBall(int x, int y){
        //position = new Vector3(x, y, 0);
        //velosity = new Vector3(0, 0, 0);

        img = new Texture("footballAtlas.png");
        ballImage = new TextureRegion(img, 0, 0, 42, 42);
        ball = new Rectangle();
        ball.x = x;
        ball.y = y;
        ball.width = 42;
        ball.height = 42;

    }

    public  void updete(){
        accelY = Gdx.input.getAccelerometerY();
        accelX = Gdx.input.getAccelerometerX();

        ball.y += accelY / 2;
        ball.x -= accelX / 2;

        if(ball.x > CAMERAWIDTH - ball.width)    {ball.x = CAMERAWIDTH - ball.width;}
        if(ball.x < 0)                           {ball.x = 0;}
        if(ball.y >  CAMERAHEIGHT - ball.height) {ball.y = CAMERAHEIGHT - ball.height;}
        if(ball.y < 0)    {ball.y = 0;}


        //position.add(ball.y,ball.x,0);
    }

    public float getX(){
        return ball.x;
    }

    public float getY(){
        return ball.y;
    }

    public TextureRegion getBall(){
        return ballImage;
    }

    public void dispose() {
        img.dispose();
    }
}
