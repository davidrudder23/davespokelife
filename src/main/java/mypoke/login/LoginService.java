package mypoke.login;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.pokegoapi.auth.GoogleUserCredentialProvider;
import com.pokegoapi.exceptions.LoginFailedException;
import com.pokegoapi.exceptions.RemoteServerException;
import com.pokegoapi.util.Log;

import okhttp3.OkHttpClient;

@Component
public class LoginService {
	
	private static final String CLIENT_ID="29080880872-qbf5vtdduu3rshutsn68rjhm3geemfem.apps.googleusercontent.com";
	private static final String CLIENT_SECRET="YC9LgvLQWEImCJE5dGRdDz0n";
	
	private static final String AUTH="1/4v3mFlxpIRn-pOLPndjBduIi0zjLVAzEf5LHYi9tcmg";

	public String getLoginURL() {
		return GoogleUserCredentialProvider.LOGIN_URL;
	}
	
	public String login(String authCode) throws LoginFailedException, RemoteServerException {
		OkHttpClient okHttpClient = new OkHttpClient();
		GoogleUserCredentialProvider credentialProvider = new GoogleUserCredentialProvider(okHttpClient);
		Log.i("Login", "authCode="+authCode);
		credentialProvider.login(authCode);
		
		return credentialProvider.getRefreshToken();
	}
	
	public String refresh(String refreshToken) throws LoginFailedException, RemoteServerException {
		OkHttpClient okHttpClient = new OkHttpClient();
		GoogleUserCredentialProvider credentialProvider = new GoogleUserCredentialProvider(okHttpClient);
		Log.i("Refresh Token", "refreshToken="+refreshToken);
		credentialProvider.refreshToken(refreshToken);
		
		return credentialProvider.getRefreshToken();
	}
}
