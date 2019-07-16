package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.auth.AuthParams;
import com.trello.api.models.auth.AuthResp;
import com.trello.ui.core.BrowserFactory;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class TryBrowser extends BrowserFactory {

    TrelloRestClient client = new TrelloRestClient();

    @Test
    public void asdasd() throws IOException {
//        driver().get("https://trello.com");

        AuthParams authParams = new AuthParams();
        Response<AuthResp> authResponse = client.authService.authentication(authParams).execute();

        System.out.println(authResponse.headers());
//        SessionResp sessionResp = client.authService.createSession(authResponse.code).execute().body();
//        System.out.println("headers " + sessionResp);

//        System.out.println("body " + authResponse.body());
//        System.out.println("raw " + authResponse.raw());
//        System.out.println(authResponse.headers());

    }

}
