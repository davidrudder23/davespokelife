package mypoke.login;

import java.rmi.RemoteException;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pokegoapi.exceptions.LoginFailedException;
import com.pokegoapi.exceptions.RemoteServerException;
import com.pokegoapi.util.Log;

@RestController
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/url", method=RequestMethod.GET)
	public ResponseEntity<String> getLoginURL(HttpServletResponse response) {		
		return new ResponseEntity<String>(loginService.getLoginURL(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/refresh", method=RequestMethod.POST)
	public ResponseEntity<String> getRefreshToken(RefreshDTO refreshToken) {
		try {
			return new ResponseEntity<String>(loginService.login(refreshToken.getRefreshToken()), HttpStatus.OK);
		} catch (LoginFailedException e) {
			Log.i("Login Exception", "Could not login", e);
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		} catch (RemoteServerException e) {
			Log.i("Remote Exception", "Could not login", e);
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> login(AuthDTO loginDTO) {
		try {
			return new ResponseEntity<String>(loginService.login(loginDTO.getAuthCode()), HttpStatus.OK);
		} catch (LoginFailedException e) {
			Log.i("Login Exception", "Could not login", e);
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		} catch (RemoteServerException e) {
			Log.i("Remote Exception", "Could not login", e);
			return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}
