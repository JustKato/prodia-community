package com.danlegt.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An identifier for the image aspect ratio, this is specifically for Prodia, these are simply resolutions with ids assigned
 */
public enum ProdiaAspectRatio {

	SQUARE("square", 512, 512),
	PORTRAIT("portrait", 512, 768),
	LANDSCAPE("landscape", 768, 512);

	private final String id;
	private final int width, height;

	private ProdiaAspectRatio( String id, int width, int height ) {
		this.id 	= id;
		this.width 	= width;
		this.height = height;
	}

	@Override
	public String toString() {
		return id;
	}

	@JsonValue
	public String getId() {
		return this.toString();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
