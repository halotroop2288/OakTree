package net.redstoneparadox.oaktree.client.gui.nodes;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.redstoneparadox.oaktree.client.gui.OakTreeGUI;
import net.redstoneparadox.oaktree.client.gui.style.StyleBox;
import net.redstoneparadox.oaktree.client.gui.util.NodeAlignment;
import net.redstoneparadox.oaktree.client.gui.util.ScreenVec;

/**
 * The base class for all nodes.
 */
public class Node {

    public float x = 0.0f;
    public float y = 0.0f;
    public float width = 0.1f;
    public float height = 0.1f;

    NodeAlignment drawAlignment = NodeAlignment.TOP_LEFT;
    NodeAlignment anchorAlignment = NodeAlignment.TOP_LEFT;

    StyleBox defaultStyle = null;

    boolean expand = false;

    StyleBox currentStyle = null;

    public Node setPosition(float posX, float posY) {
        x = posX;
        y = posY;
        return this;
    }

    public Node setSize(float sizeWidth, float sizeHeight) {
        width = sizeWidth;
        height = sizeHeight;
        return this;
    }

    public Node setExpand(boolean value) {
        expand = value;
        return this;
    }

    public Node setDefaultStyle(StyleBox style) {
        defaultStyle = style;
        return this;
    }

    public Node setDrawAlignment(NodeAlignment newAligment) {
        drawAlignment = newAligment;
        return this;
    }

    public Node setAnchorAlignment(NodeAlignment newAligment) {
        anchorAlignment = newAligment;
        return this;
    }

    public void setup(MinecraftClient minecraftClient_1, int int_1, int int_2, OakTreeGUI gui) {
    }

    public void preDraw(int mouseX, int mouseY, float deltaTime, OakTreeGUI gui, Window window, float offsetX, float offsetY, float containerWidth, float containerHeight) {
        if (expand) {
            width = containerWidth;
            height = containerHeight;
        }
        currentStyle = defaultStyle;
    }

    public void draw(int mouseX, int mouseY, float deltaTime, OakTreeGUI gui, float offsetX, float offsetY, float containerWidth, float containerHeight) {
        if (currentStyle != null) {
            ScreenVec anchorOffset = anchorAlignment.getOffset(containerWidth, containerHeight);
            ScreenVec drawOffset = drawAlignment.getOffset(width, height);

            float trueX = x + anchorOffset.x + offsetX - drawOffset.x;
            float trueY = y + anchorOffset.y + offsetY - drawOffset.y;

            currentStyle.draw(trueX, trueY, width, height, gui, false);
        }
    }

}
