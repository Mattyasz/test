package pzmatty.test.screens;

import java.util.logging.Logger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import pzmatty.test.components.GraphicComponent;
import pzmatty.test.systems.RenderSystem;

public class MainScreen extends ScreenAdapter {
    private static final Logger LOG = Logger.getLogger(MainScreen.class.getSimpleName());
    private Engine engine;

    public MainScreen(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void show() {
        engine.addSystem(new RenderSystem());
        Entity player = new Entity();
        player.add(new GraphicComponent());
        engine.addEntity(player);
    }

    @Override
    public void dispose() {
        engine.removeAllEntities();
    }

}
