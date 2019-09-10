package com.food2air.config;

import org.springframework.stereotype.Component;

@Component("applicationProperties")
public class ApplicationProperties {
	public String getMediaServer() {
		return mediaServer;
	}

	public void setMediaServer(String mediaServer) {
		this.mediaServer = mediaServer;
	}

	private String mediaServer = "http://localhost/CCMS/";

}
