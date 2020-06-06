package io.github.redstoneparadox.oaktree.client;

import java.util.List;

import net.minecraft.class_5348;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class TextHelper {
	public static int getFontHeight() {
		return MinecraftClient.getInstance().textRenderer.fontHeight;
	}

	public static int getWidth(Text text) {
		return MinecraftClient.getInstance().textRenderer.getWidth(text);
	}

	public static Text combine(List<Text> texts, boolean newline) {
		if (texts.isEmpty()) return new LiteralText("");

		MutableText text = texts.get(0).shallowCopy();

		for (int index = 1; index < texts.size(); index += 1) {
			if (newline) text.append(new LiteralText("\n"));
			text.append(texts.get(index));
		}

		return text;
	}

	public static List<class_5348> wrapText(class_5348 text, int width, int start, int max, boolean shadow, boolean pastEnd) {
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

		List<class_5348> lines;

		if (shadow) {
			lines = textRenderer.wrapLines(text, width - 1);
		} else {
			lines = textRenderer.wrapLines(text, width);
		}

		if (!pastEnd && start + max >= lines.size()) {
			start = lines.size() - max;
		}

		if (start + max <= lines.size()) {
			return lines.subList(start, max);
		} else if (start < lines.size()) {
			return lines.subList(start, lines.size());
		}

		return lines;
	}
}
