package com.fevs.quickbooks;

import com.intuit.oauth2.config.OAuth2Config;
import org.json.JSONArray;

import java.util.Map;

public interface QuickbooksService {
  /**
   * Return a token from the service. If the last time a token was requested is > the token timeout, a new token is
   * requested.
   *
   * @return a token from the service
   * @since 10.10
   */
  OAuth2Config getOAuth2Config();

  /**
   * Return the list of Customers
   *
   * @param someParam
   * @return an array of template(s)
   * @since 10.10
   */
  JSONArray getCustomerList(String someParam);

}
