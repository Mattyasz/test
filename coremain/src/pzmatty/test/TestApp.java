package pzmatty.test;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;

import pzmatty.test.screens.MainScreen;

public class TestApp extends Game {
    private Engine engine;

    // SCREENS
    private MainScreen mainScreen;

    @Override
    public void create() {
        this.engine = new Engine();
        this.mainScreen = new MainScreen(engine);
        this.setScreen(mainScreen);
    }

    @Override
    public void dispose() {
        mainScreen.dispose();
    }
}
