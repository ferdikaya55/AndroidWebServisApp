package com.example.webservisyazma.RestApi;

public class BaseManager {


    protected RestApi getRestApi() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.Url);

        return restApiClient.getRestApi();
    }
}
