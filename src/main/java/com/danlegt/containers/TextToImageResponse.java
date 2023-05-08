package com.danlegt.containers;

public record TextToImageResponse( String job, Object params, String imageUrl ) {

	// TODO: Implement this

	/**
	 * Download the image from the URL into a byte array
	 * @return The image data in a byte array
	 */
	public byte[] getImageData() {
		return new byte[0];
	}

}
