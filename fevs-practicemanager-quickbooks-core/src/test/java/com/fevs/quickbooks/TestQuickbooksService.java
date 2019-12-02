package com.fevs.quickbooks;

import com.intuit.oauth2.config.OAuth2Config;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy("com.fevs.practicemanager.quickbooks.fevs-practicemanager-quickbooks-core")
public class TestQuickbooksService {

    @Inject
    protected QuickbooksService quickbooksservice;

    @Before
    public void setUp() {
        // This is probably the wrong way to do this, but I want to make sure I have values...
        String clientId = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_ID);
        String clientSecret = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_SECRET);

        assertNotNull(clientId);
        assertNotNull(clientSecret);
    }

    @Test
    public void testService() {
        assertNotNull(quickbooksservice);
    }

    @Test
    public void CanGetOAuth2Config() {
        OAuth2Config token = quickbooksservice.getOAuth2Config();
        assertNotNull(token);
    }

    @Test
    public void CanGetCustomerList(){
        JSONArray list = quickbooksservice.getCustomerList(null);
        assertNotNull(list);
    }
}
