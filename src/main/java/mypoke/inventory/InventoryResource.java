package mypoke.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pokegoapi.api.PokemonGo;
import com.pokegoapi.api.inventory.Inventories;
import com.pokegoapi.util.Log;

import mypoke.pokemon.PokemonDTO;
import okhttp3.OkHttpClient;

@RestController
@RequestMapping("/inventory")
public class InventoryResource {
	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value="/pokemon", method=RequestMethod.GET)
	public ResponseEntity<List<PokemonDTO>> getPokemon(@RequestHeader(value="token") String refreshToken) {
		try {
			List<PokemonDTO> pokeMonDTOs = inventoryService.getPokemons(refreshToken);
			return new ResponseEntity<List<PokemonDTO>>(pokeMonDTOs, HttpStatus.OK);
		} catch (Exception e) {
			Log.w("Get inventory", e);
			return new ResponseEntity<List<PokemonDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
