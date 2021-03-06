package io.github.redstoneparadox.oaktree.client.gui.control;

import io.github.redstoneparadox.oaktree.client.gui.ControlGui;
import io.github.redstoneparadox.oaktree.client.math.Vector2;

//TODO: Make fields protected and replace with getters.
public abstract class PaddingControl<C extends PaddingControl<C>> extends Control<C> {
	protected int topPadding = 0;
	protected int bottomPadding = 0;
	protected int leftPadding = 0;
	protected int rightPadding = 0;

	/**
	 * Sets the padding for all 4 sides.
	 *
	 * @param padding The padding value.
	 * @return The control itself.
	 */
	public C padding(int padding) {
		this.topPadding = padding;
		this.bottomPadding = padding;
		this.leftPadding = padding;
		this.rightPadding = padding;
		return (C) this;
	}

	/**
	 * Sets the padding for the top.
	 *
	 * @param topPadding The padding value.
	 * @return The control itself.
	 */
	public C topPadding(int topPadding) {
		this.topPadding = topPadding;
		return (C) this;
	}

	public int getTopPadding() {
		return topPadding;
	}

	/**
	 * Sets the padding for the bottom.
	 *
	 * @param bottomPadding The padding value.
	 * @return The control itself.
	 */
	public C bottomPadding(int bottomPadding) {
		this.bottomPadding = bottomPadding;
		return (C) this;
	}

	public int getBottomPadding() {
		return bottomPadding;
	}

	/**
	 * Sets the padding for the left side.
	 *
	 * @param leftPadding The padding value.
	 * @return The control itself.
	 */
	public C leftPadding(int leftPadding) {
		this.leftPadding = leftPadding;
		return (C) this;
	}

	public int getLeftPadding() {
		return leftPadding;
	}

	/**
	 * Sets the padding for the right side.
	 *
	 * @param rightPadding The padding value.
	 * @return The control itself.
	 */
	public C rightPadding(int rightPadding) {
		this.rightPadding = rightPadding;
		return (C) this;
	}

	public int getRightPadding() {
		return rightPadding;
	}

	@Override
	public void preDraw(ControlGui gui, int offsetX, int offsetY, int containerWidth, int containerHeight, int mouseX, int mouseY) {
		super.preDraw(gui, offsetX, offsetY, containerWidth, containerHeight, mouseX, mouseY);
	}

	Vector2 innerDimensions(int spaceWidth, int spaceHeight) {
		int innerWidth = spaceWidth - leftPadding - rightPadding;
		int innerHeight = spaceHeight - topPadding - bottomPadding;

		return new Vector2(innerWidth, innerHeight);
	}

	Vector2 innerPosition(int spaceX, int spaceY) {
		int innerX = spaceX + leftPadding;
		int innerY = spaceY + topPadding;

		return new Vector2(innerX, innerY);
	}
}
