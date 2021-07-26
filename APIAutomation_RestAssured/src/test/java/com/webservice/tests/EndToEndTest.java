package com.webservice.tests;

import com.webservice.helper.WebServiceHelper;
import com.webservice.utils.PropertyReader;
import org.testng.annotations.Test;

public class EndToEndTest {
    WebServiceHelper webServiceHelper = new WebServiceHelper();
    PropertyReader util = new PropertyReader();

    @Test
    public void fetchReposFromgithub(){
        webServiceHelper.getRepos(util.getUsername() ,util.getAccessToken());
    }
}
