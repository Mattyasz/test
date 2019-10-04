package pzmatty.test;

import java.util.logging.Logger;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;

import pzmatty.test.screens.MainScreen;
import pzmatty.test.systems.RenderSystem;

public class TestApp extends Game {
	private static final Logger LOG = Logger.getLogger(Game.class.getSimpleName());
	private Engine engine;

	// SCREENS
	private MainScreen mainScreen;

	// SWITCHES
	private boolean RENDER_ON = true;

	@Override
	public void create() {
		engine = new Engine();
		configureEngine();
		mainScreen = new MainScreen(engine);
		setScreen(mainScreen);
	}

	private void configureEngine() {
		if (RENDER_ON)
			try {
				engine.addSystem(new RenderSystem());
				LOG.info("RenderSystem Loaded");
			} catch (Exception e) {
				LOG.severe("RenderSystem ERROR: " + e.getMessage());
			}
	}

	@Override
	public void dispose() {
		mainScreen.dispose();
	}
}
