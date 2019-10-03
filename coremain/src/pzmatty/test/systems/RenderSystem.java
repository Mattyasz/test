package pzmatty.test.systems;

import java.util.logging.Logger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pzmatty.test.components.GraphicComponent;
import pzmatty.test.components.Mappers;
import pzmatty.test.components.PositionComponent;

public class RenderSystem extends EntitySystem {
    private static final Logger LOG = Logger.getLogger(RenderSystem.class.getSimpleName());
    private ImmutableArray<Entity> entities;
    private SpriteBatch batch;

    public RenderSystem() {
        this.batch = new SpriteBatch();
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(PositionComponent.class, GraphicComponent.class).get());
        LOG.info("Added entities to RenderSystem");
    }

    @Override
    public void update(float deltaTime) {
        batch.begin();
        for (Entity ent : entities) {
            GraphicComponent graphic = Mappers.graphic.get(ent);
            PositionComponent position = Mappers.position.get(ent);

            batch.draw(graphic.sprite.getTexture(), position.x, position.y);
        }
        batch.end();
    }

}
