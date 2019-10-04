package pzmatty.test.components;

import com.badlogic.ashley.core.ComponentMapper;

public class Mappers {
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<GraphicComponent> graphic = ComponentMapper.getFor(GraphicComponent.class);
	public static final ComponentMapper<TextComponent> text = ComponentMapper.getFor(TextComponent.class);
}
