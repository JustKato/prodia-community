package com.danlegt.containers;

import com.danlegt.enums.ProdiaAspectRatio;
import com.danlegt.enums.ProdiaModel;
import com.danlegt.enums.ProdiaSampler;

public record TextToImageRequest(
	ProdiaModel model,
	String prompt,
	String negative_prompt,
	int steps,
	float cfg_scale,
	float seed,
	boolean upscale,
	ProdiaSampler sampler,
	ProdiaAspectRatio aspect_ratio
) {

}
