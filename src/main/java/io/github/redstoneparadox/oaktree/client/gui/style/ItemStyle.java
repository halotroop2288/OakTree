package io.github.redstoneparadox.oaktree.client.gui.style;

import io.github.redstoneparadox.oaktree.client.RenderHelper;
import io.github.redstoneparadox.oaktree.client.gui.ControlGui;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemStyle extends Style {

    private ItemStack stack;

    public ItemStyle(Identifier identifier, int count) {
        this.stack = new ItemStack(Registry.ITEM.get(identifier), count);
    }

    public ItemStyle(Identifier identifier) {
        this(identifier, 1);
    }

    public ItemStyle(String identifier) {
        this(new Identifier(identifier), 1);
    }

    public ItemStyle(String identifier, int count) {
        this(new Identifier(identifier), count);
    }

    public int getCount() {
        return stack.getCount();
    }

    public void setCount(int count) {
        stack.setCount(count);
    }

    public Item getItem() {
        return stack.getItem();
    }

    public void setItem(Item item) {
        stack = new ItemStack(item, stack.getCount());
    }

    @Override
    public void draw(int x, int y, int width, int height, ControlGui gui, boolean mirroredHorizontal, boolean mirroredVertical) {
        if (!stack.isEmpty()) {
            RenderHelper.drawItemStackCentered(x, y, width, height, stack);
        }
    }
}