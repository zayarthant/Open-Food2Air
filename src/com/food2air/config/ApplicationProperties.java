package com.food2air.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("applicationProperties")
@PropertySource("classpath:setting.properties")
public class ApplicationProperties {

	@Value("${mediaServer}")
	private String mediaServer;

	public String getMediaServer() {
		return mediaServer;
	}

	public void setMediaServer(String mediaServer) {
		this.mediaServer = mediaServer;
	}

}
