package com.fevs.quickbooks;

import static org.junit.Assert.assertNotNull;

import com.intuit.oauth2.config.OAuth2Config;
import org.json.JSONArray;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import javax.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({ PlatformFeature.class })
@Deploy("com.fevs.practicemanager.quickbooks.fevs-practicemanager-quickbooks-core")
public class TestQuickbooksService {

    @Inject
    protected QuickbooksService quickbooksservice;

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
