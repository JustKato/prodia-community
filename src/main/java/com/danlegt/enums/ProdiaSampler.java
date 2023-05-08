package com.danlegt.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProdiaSampler {

	EULER("Euler"),
	HEUN("Heun"),
	EULERA("Euler a"),
	DPM_PP_2M_K("DPM++ 2M Karras");

	private final String id;

	private ProdiaSampler( String id ) {
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
