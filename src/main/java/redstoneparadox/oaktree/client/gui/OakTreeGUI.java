package redstoneparadox.oaktree.client.gui;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.container.Container;
import redstoneparadox.oaktree.client.gui.control.Control;

import java.util.Optional;

public interface OakTreeGUI {

    Optional<Container> getScreenContainer();

    boolean mouseButtonHeld(String mouseButton);

    boolean mouseButtonJustClicked(String mouseButton);

    Optional<Character> getLastChar();

    boolean isKeyPressed(String key);

    TextRenderer getTextRenderer();
}