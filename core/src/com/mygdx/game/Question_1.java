package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Question_1 extends ScreenAdapter{
	Game game;
	SpriteBatch batch;
	Texture question_1;
	Lives lives;
	Skip skip;
	
	Rectangle ans1,ans2,ans3,ans4,skipButton;
	Vector2 touchPoint;
	
	public Question_1(Game game) 
	{
		this.game = game;
		batch = new SpriteBatch();
		question_1 = new Texture("question_1.png");
		lives = new Lives();
		skip = new Skip();
		
		touchPoint = new Vector2();
		ans1 = new Rectangle( 130, 400 - 120, 300, 120);
		ans2 = new Rectangle( 625, 400 - 120, 300, 120);
		ans3 = new Rectangle( 130, 400 - 120 + 175, 300, 120);
		ans4 = new Rectangle( 625, 400 - 120 + 175, 300, 120);
		skipButton = new Rectangle(180 + 700,720 - 60 - 20 ,150 ,60);
	}
	
	@Override
	public void render(float delta)
	{
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		render();
	}
	
	private void update()
	{
		if(Gdx.input.justTouched())
		{
			touchPoint.x = Gdx.input.getX();
			touchPoint.y = Gdx.input.getY();
			
//			System.out.println(touchPoint);
			
			
			if(ans1.contains(touchPoint))
			{
				lives.wrong();
			}
			
			if(ans2.contains(touchPoint))
			{
				lives.wrong();
			}
			
			if(ans3.contains(touchPoint))
			{
				lives.wrong();
			}
			
			if(ans4.contains(touchPoint))
			{
				game.setScreen(new Question_2(game));
			}
			
			if(skipButton.contains(touchPoint) && skip.canSkip())
			{
				skip.useSkip();
				game.setScreen(new Question_2(game));
			}
			
//			System.out.println(lives.hp);
//			System.out.println(lives.getLives());
//			System.out.println(lives.isLive());
		}
		if(!lives.isLive())
		{
			game.setScreen(new Fail(game));
		}
	}
	
	private void render()
	{
		batch.begin();
		batch.draw(question_1, 0, 0);
		batch.end();
		lives.renderLives();
		skip.renderSkip();
	}
	
	

}
