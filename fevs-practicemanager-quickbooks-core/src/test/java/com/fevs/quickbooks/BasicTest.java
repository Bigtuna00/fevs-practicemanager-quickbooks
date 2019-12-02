package com.fevs.quickbooks;

import com.intuit.oauth2.config.Environment;
import com.intuit.oauth2.config.OAuth2Config;
import com.intuit.oauth2.http.MethodType;
import com.intuit.oauth2.http.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import static org.junit.Assert.*;

@RunWith(FeaturesRunner.class)
@Features({PlatformFeature.class})
public class BasicTest {

  OAuth2Config oauth2Config;

  private String clientId;
  private String clientSecret;

  @Before
  public void setUp() {

    clientId = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_ID);
    clientSecret = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_SECRET);

    assertNotNull(clientId);
    assertNotNull(clientSecret);

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