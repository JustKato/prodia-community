package com.danlegt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProdiaModel {

	ANALOG_DIFFUSION_10CKPT("analog-diffusion-1.0.ckpt [9ca13f02]"),
	ANYTHINGV3_0_PRUNEDCKPT("anythingv3_0-pruned.ckpt [2700c435]"),
	ANYTHING_V45_PRUNEDCKPT("anything-v4.5-pruned.ckpt [65745d25]"),
	DELIBERATE_V2SAFETENSORS("deliberate_v2.safetensors [10ec4b29]"),
	DREAMLIKE_DIFFUSION_10SAFETENSORS("dreamlike-diffusion-1.0.safetensors [5c9fd6e0]"),
	DREAMLIKE_DIFFUSION_20SAFETENSORS("dreamlike-diffusion-2.0.safetensors [fdcf65e7]"),
	DREAMSHAPER_5BAKEDVAESAFETENSORS("dreamshaper_5BakedVae.safetensors [a3fbf318]"),
	ELLDRETHS_VIVID_MIXSAFETENSORS("elldreths-vivid-mix.safetensors [342d9d26]"),
	LYRIEL_V15SAFETENSORS("lyriel_v15.safetensors [65d547c5]"),
	MEINAMIX_MEINAV9SAFETENSORS("meinamix_meinaV9.safetensors [2ec66ab0]"),
	OPENJOURNEY_V4CKPT("openjourney_V4.ckpt [ca2f377f]"),
	PORTRAIT_10SAFETENSORS("portrait+1.0.safetensors [1400e684]"),
	REVANIMATED_V122SAFETENSORS("revAnimated_v122.safetensors [3f4fefd9]"),
	RIFFUSION_MODEL_V1CKPT("riffusion-model-v1.ckpt [3aafa6fe]"),
	SDV1_4CKPT("sdv1_4.ckpt [7460a6fa]"),
	THEALLYS_MIX_II_CHURNEDSAFETENSORS("theallys-mix-ii-churned.safetensors [5d9225a4]"),
	TIMELESS_10CKPT("timeless-1.0.ckpt [7c4971d4]"),
	V1_5_PRUNED_EMAONLYCKPT("v1-5-pruned-emaonly.ckpt [81761151]");

	private final String id;

	private ProdiaModel(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.id;
	}

	@JsonValue
	public String getId() {
		return this.toString();
	}
}
