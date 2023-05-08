package com.danlegt.enums;

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

	public String getId() {
		return this.toString();
	}

}
