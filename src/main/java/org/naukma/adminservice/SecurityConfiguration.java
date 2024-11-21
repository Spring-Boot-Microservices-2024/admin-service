package org.naukma.adminservice;

import de.codecentric.boot.admin.server.web.client.HttpHeadersProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SecurityConfiguration {

    @Value("${auth.header}")
    private String authHeader;

    @Value("${auth.key}")
    private String authKey;

    @Bean
    public HttpHeadersProvider customHttpHeadersProvider() {
        return instance -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(authHeader, authKey);
            return httpHeaders;
        };
    }
}
