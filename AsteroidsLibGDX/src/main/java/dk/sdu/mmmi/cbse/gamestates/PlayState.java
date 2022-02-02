package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private Enemy enemy;
	private ArrayList<Bullet> bullets;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		
		player = new Player();
		enemy = new Enemy();
		bullets = new ArrayList<Bullet>();
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		enemy.update(dt);
		for (Bullet b : bullets) {
			b.update(dt);
		}

		if (bullets.size() >= 1) {
			if (bullets.get(0).getTick() > 100) {
				bullets.remove(0);
			}
		}
	}
	
	public void draw() {
		player.draw(sr);
		enemy.draw(sr);
		for (Bullet b : bullets) {
			b.draw(sr);
		}
		System.out.println(bullets.size());
	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));

		if (GameKeys.isDown(GameKeys.SPACE)) {
			Bullet b = new Bullet(player.getX(),player.getY(),player.getRad());
			bullets.add(b);
		}

		enemy.setLeft(true);
		enemy.setUp(true);
	}
	
	public void dispose() {}
	
}









