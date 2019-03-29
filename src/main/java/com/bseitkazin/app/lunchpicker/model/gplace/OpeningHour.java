package com.bseitkazin.app.lunchpicker.model.gplace;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpeningHour {
	@JsonProperty("open_now")
	private boolean openNow;

	public boolean isOpenNow() {
		return openNow;
	}

	public void setOpenNow(boolean openNow) {
		this.openNow = openNow;
	}
}
