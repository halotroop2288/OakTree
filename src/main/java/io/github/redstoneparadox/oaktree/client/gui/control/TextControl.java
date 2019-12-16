package io.github.redstoneparadox.oaktree.client.gui.control;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import io.github.redstoneparadox.oaktree.client.gui.OakTreeGUI;
import io.github.redstoneparadox.oaktree.client.gui.util.ControlAnchor;
import io.github.redstoneparadox.oaktree.client.gui.util.RGBAColor;
import io.github.redstoneparadox.oaktree.client.gui.util.ScreenVec;
import io.github.redstoneparadox.oaktree.mixin.client.gui.screen.ScreenAccessor;

public interface TextControl<TC extends TextControl> {

    default void drawString(String string, OakTreeGUI gui, float x, float y, ControlAnchor alignment, boolean withShadow, RGBAColor fontColor) {
        int redInt = (int) fontColor.redChannel * 255;
        int greenInt = (int) fontColor.greenChannel * 255;
        int blueInt = (int) fontColor.blueChannel * 255;

        int colorInt = redInt << 16 | greenInt << 8 | blueInt;

        if (gui instanceof Screen) {
            TextRenderer font = gui.getTextRenderer();

            if (withShadow) font.drawWithShadow(string, x + 2, y + 2, colorInt);
            else font.draw(string, x + 2, y + 2, colorInt);
        }
    }

    default void drawHighlights(String string, OakTreeGUI gui, float x, float y, RGBAColor highlightColor) {
        TextRenderer font = ((ScreenAccessor)gui).getFont();
        int width = font.getStringWidth(string);
        int height = font.fontHeight;

        ScreenVec vert1 = new ScreenVec(x + 1, y + 1);
        ScreenVec vert2 = new ScreenVec(x + 1, y + 3 + height);
        ScreenVec vert3 = new ScreenVec(x + 3 + width, y + 3 + height);
        ScreenVec vert4 = new ScreenVec(x + 3 + width, y + 1);

        float red = highlightColor.redChannel * 255;
        float green = highlightColor.greenChannel * 255;
        float blue = highlightColor.blueChannel * 255;
        float alpha = highlightColor.alphaChannel * 255;

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder builder = tessellator.getBuffer();
        RenderSystem.color4f(red, green, blue, alpha);
        RenderSystem.disableTexture();
        RenderSystem.enableColorLogicOp();
        RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
        builder.begin(7, VertexFormats.POSITION);
        builder.vertex(vert1.x, vert1.y, 0.0).next();
        builder.vertex(vert2.x, vert2.y, 0.0).next();
        builder.vertex(vert3.x, vert3.y, 0.0).next();
        builder.vertex(vert4.x, vert4.y, 0.0).next();
        tessellator.draw();
        RenderSystem.disableColorLogicOp();
        RenderSystem.enableTexture();
    }
}