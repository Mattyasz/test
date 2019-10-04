package pzmatty.test.managers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;

import pzmatty.test.components.GraphicComponent;
import pzmatty.test.components.PositionComponent;
import pzmatty.test.components.TextComponent;

public class EntityFactory {
	public static Entity getGraphic(Texture texture, int x, int y) {
		GraphicComponent g = new GraphicComponent();
		PositionComponent p = new PositionComponent();
		g.texture = texture;
		p.x = x;
		p.y = y;
		return new Entity().add(g).add(p);
	}

	public static Entity getText(String text, int x, int y) {
		TextComponent t = new TextComponent();
		PositionComponent p = new PositionComponent();
		t.text = text;
		p.x = x;
		p.y = y;
		return new Entity().add(t).add(p);
	}
}
