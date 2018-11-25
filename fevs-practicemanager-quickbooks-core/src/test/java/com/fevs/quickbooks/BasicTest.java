package com.fevs.quickbooks;

import com.intuit.oauth2.config.Environment;
import com.intuit.oauth2.config.OAuth2Config;
import com.intuit.oauth2.http.MethodType;
import com.intuit.oauth2.http.Request;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicTest {

    OAuth2Config oauth2Config;
    // These credentials are already public on github at
    // https://github.com/intuit/QuickBooks-V3-Java-SDK/blob/develop/oauth2-platform-api/src/test/java/com/intuit/oauth2/http/RequestTest.java
    private static final String clientId = "Q05MIy6oCjARUBablYbLLth6D7xh3dpMwWxOLnHYKM4WIqWBDP";
    private static final String clientSecret = "8dFUOx16fwJ4ZLNN7onJQ0vFG8ybkHf05uaz6T4b";

    @Before
    public void setUp() {

        oauth2Config = new OAuth2Config.OAuth2ConfigBuilder(clientId, clientSecret) //set client id, secret
                .callDiscoveryAPI(Environment.SANDBOX) // call discovery API to populate urls
                .buildConfig();
    }

    @Test
    public void testConstructorWithDomain() {
        Request request = new Request.RequestBuilder(MethodType.GET, oauth2Config.getIntuitBearerTokenEndpoint()).build();
        assertNotNull(request);
        assertEquals(MethodType.GET, request.getMethod());
        assertEquals(oauth2Config.getIntuitBearerTokenEndpoint(), request.getUrl());
    }
}