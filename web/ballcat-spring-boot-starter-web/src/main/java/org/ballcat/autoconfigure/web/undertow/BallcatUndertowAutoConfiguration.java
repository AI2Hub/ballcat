package org.ballcat.autoconfigure.web.undertow;

import io.undertow.server.DefaultByteBufferPool;
import io.undertow.servlet.api.Deployment;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.spec.ServletContextImpl;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import java.io.File;

/**
 * @author lingting 2023-06-12 16:07
 */
@AutoConfiguration
public class BallcatUndertowAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowServletWebServerFactoryCustomization() {
		return factory -> factory.addDeploymentInfoCustomizers(deploymentInfo -> {
			WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
			webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 4096, -1, 24, 0));
			deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo",
					webSocketDeploymentInfo);
		});
	}


}
