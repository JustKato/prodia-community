import com.danlegt.ProdiaAPI;
import com.danlegt.containers.TextToImageRequest;
import com.danlegt.enums.ProdiaAspectRatio;
import com.danlegt.enums.ProdiaModel;
import com.danlegt.enums.ProdiaSampler;
import org.junit.Test;

public class StabilityTests {

	private final String apiKey;

	public StabilityTests() {
		this.apiKey = System.getenv("PRODIA_KEY");
	}

	@Test
	public void TextToImageTest() throws Exception {

		int IMAGE_FETCH_TRIES = 15;

		var p = new ProdiaAPI(this.apiKey);

		var response = p.createTextToImage(
			new TextToImageRequest(
				ProdiaModel.ANYTHING_V45_PRUNEDCKPT,
				"A dog jumping up, jump, (dog:1.25), cute, adorable, realistic, 4 legs, corgi",
				"man, human, ugly, bad, distorted, horror, nsfw, nude, porn, humanoid, extra limbs, extra paws",
				50,
				7.5f,
				(int)(Math.random() * 1000000),
				false,
				ProdiaSampler.DPM_PP_2M_K,
				ProdiaAspectRatio.PORTRAIT
			)
		);

		System.out.println("JobID: " + response.job());

		while ( response.imageUrl() == null && IMAGE_FETCH_TRIES > 0 ) {
			response = p.fetchTextToImage(response.job());
			IMAGE_FETCH_TRIES--;
		}

		System.out.println("Image URL: " + response.imageUrl());
		assert( response.imageUrl() != null );

	}

}
