package mypoke.login;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.pokegoapi.exceptions.LoginFailedException;
import com.pokegoapi.util.Log;

public class LoginServiceTest {


	@Test
	public void getLoginURLTest() {
		try {
			LoginService loginService = new LoginService();
			String url = loginService.getLoginURL();
			Assert.assertNotNull(url);
			Log.i("Google Auth URL", url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
}
