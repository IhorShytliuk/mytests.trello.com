package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Auth;
import com.trello.ui.core.BrowserFactory;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class TryBrowser extends BrowserFactory {

    TrelloRestClient client = new TrelloRestClient();


    @Test
    public void asdasd() throws IOException {
//        driver().get("https://trello.com");

        Auth auth = new Auth();
        Response<Auth> authResponse = client.loginService.auth(auth).execute();

        System.out.println("resp" + authResponse.toString());
        System.out.println("body" + authResponse.body());
        System.out.println("raw" + authResponse.raw());
//        System.out.println(authResponse.headers());

    }

}
