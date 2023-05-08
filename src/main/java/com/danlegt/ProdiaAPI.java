package com.danlegt;

import com.danlegt.containers.TextToImageRequest;
import com.danlegt.containers.TextToImageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProdiaAPI {

	private final String PRODIA_TEXT_TO_IMAGE_ENDPOINT = "https://api.prodia.com/v1/job";

	private String apiKey;

	public ProdiaAPI( String apiKey ) {
		this.apiKey = apiKey;
	}

	//#region Text to Image

	/**
	 * Send a request to Prodia to generate an image
	 * @param requestData The request data to send over to Prodia
	 * @return A response from Prodia containing the image URL
	 */
	public TextToImageResponse createTextToImage( TextToImageRequest requestData ) throws Exception {

		// Quick Validations
		if ( requestData.cfg_scale() <= 0 )
			throw new Exception("The CFG Scale can not be lower or equal to 0, please use a valid value");

		return (TextToImageResponse) sendRequest(
			PRODIA_TEXT_TO_IMAGE_ENDPOINT,
			requestData,
			TextToImageResponse.class
		);
	}

	//#endregion


	private <T> Object sendRequest( String urlString, T packet, Class responseType ) throws Exception {
		final var om = new ObjectMapper();
		HttpClient client = HttpClient.newHttpClient();
		String requestBody = om.writeValueAsString(packet);

		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(urlString))
			.POST(HttpRequest.BodyPublishers.ofString(requestBody))
			.header("X-Prodia-Key", this.apiKey)
			.build();


		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if ( response.statusCode() < 200 || response.statusCode() > 299 ) {
			throw new Exception("Error response code: \n" + response.body());
		}

		return om.readValue(response.body(), responseType);
	}

}