package com.fevs.quickbooks;

import com.intuit.oauth2.config.Environment;
import com.intuit.oauth2.config.OAuth2Config;
import org.json.JSONArray;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.model.ComponentContext;
import org.nuxeo.runtime.model.ComponentInstance;
import org.nuxeo.runtime.model.DefaultComponent;

public class QuickbooksServiceImpl extends DefaultComponent implements QuickbooksService {

    protected static OAuth2Config oauth2Config;

    private String clientId;
    private String clientSecret;

    public static final String LOCK = "QuickbooksServiceLock";

    /**
     * Component activated notification.
     * Called when the component is activated. All component dependencies are resolved at that moment.
     * Use this method to initialize the component.
     *
     * @param context the component context.
     */
    @Override
    public void activate(ComponentContext context) {
        super.activate(context);
    }

    /**
     * Component deactivated notification.
     * Called before a component is unregistered.
     * Use this method to do cleanup if any and free any resources held by the component.
     *
     * @param context the component context.
     */
    @Override
    public void deactivate(ComponentContext context) {
        super.deactivate(context);
    }

    @Override
    public void registerContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Add some logic here to handle contributions
    }

    @Override
    public void unregisterContribution(Object contribution, String extensionPoint, ComponentInstance contributor) {
        // Logic to do when unregistering any contribution
    }

    @Override
    public OAuth2Config getOAuth2Config() {
        synchronized (LOCK) {
            generateOauth2Config();
        }

        return oauth2Config;
    }

    @Override
    public JSONArray getCustomerList(String someParam) {
        return null;
    }

    /*
     * Must be called form synchronized code.
     */
    protected void generateOauth2Config() {
        clientId = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_ID);
        clientSecret = Framework.getProperty(QuickBooksConstants.PROPERTY_CLIENT_SECRET);

        oauth2Config = new OAuth2Config.OAuth2ConfigBuilder(clientId, clientSecret) //set client id, secret
                .callDiscoveryAPI(Environment.SANDBOX) // call discovery API to populate urls
                .buildConfig();
    }
}
