package pzmatty.test.systems;

import java.util.logging.Logger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pzmatty.test.components.GraphicComponent;
import pzmatty.test.components.Mappers;
import pzmatty.test.components.PositionComponent;
import pzmatty.test.components.TextComponent;

public class RenderSystem extends EntitySystem {
	private static final Logger LOG = Logger.getLogger(RenderSystem.class.getSimpleName());
	private ImmutableArray<Entity> graphicEntities;
	private ImmutableArray<Entity> textEntities;
	private SpriteBatch batch;
	private BitmapFont font;

	public RenderSystem() {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
	}

	@Override
	public void addedToEngine(Engine engine) {
		graphicEntities = engine.getEntitiesFor(Family.all(PositionComponent.class, GraphicComponent.class).get());
		textEntities = engine.getEntitiesFor(Family.all(TextComponent.class, PositionComponent.class).get());
		LOG.info("Added entities to RenderSystem");
	}

	@Override
	public void update(float deltaTime) {
		batch.begin();
		for (Entity ent : graphicEntities) {
			GraphicComponent graphic = Mappers.graphic.get(ent);
			PositionComponent position = Mappers.position.get(ent);

			batch.draw(graphic.texture, position.x, position.y);
		}
		for (Entity ent : textEntities) {
			TextComponent text = Mappers.text.get(ent);
			PositionComponent position = Mappers.position.get(ent);

			font.draw(batch, text.text, position.x, position.y);
		}
		batch.end();
	}

}
