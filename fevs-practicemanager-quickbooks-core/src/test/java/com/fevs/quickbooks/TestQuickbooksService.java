package com.fevs.quickbooks;

import static org.junit.Assert.assertNotNull;

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
}
