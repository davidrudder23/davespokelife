package mypoke.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pokegoapi.api.PokemonGo;
import com.pokegoapi.api.inventory.Inventories;
import com.pokegoapi.api.inventory.PokeBank;
import com.pokegoapi.api.pokemon.Pokemon;
import com.pokegoapi.auth.GoogleUserCredentialProvider;
import com.pokegoapi.exceptions.LoginFailedException;
import com.pokegoapi.exceptions.RemoteServerException;
import com.pokegoapi.util.Log;

import mypoke.pokemon.PokemonDTO;
import okhttp3.OkHttpClient;

@Component
public class InventoryService {

	public List<PokemonDTO> getPokemons(String refreshToken) throws LoginFailedException, RemoteServerException {
		OkHttpClient okHttpClient = new OkHttpClient();
		GoogleUserCredentialProvider credentialProvider = new GoogleUserCredentialProvider(okHttpClient, refreshToken);
		
		PokemonGo pokemonGo = new PokemonGo(credentialProvider, okHttpClient);
		Inventories inventories = pokemonGo.getInventories();
		Log.d("Inventories", "Got "+inventories.getPokebank().getPokemons().size()+" pokemons");
		
		PokeBank bank = inventories.getPokebank();
		List<Pokemon> pokemons = bank.getPokemons();
		List<PokemonDTO> pokemonDTOs = new ArrayList<>();
		for (Pokemon pokemon: pokemons) {
			PokemonDTO pokemonDTO = new PokemonDTO();
			pokemonDTO.setNickName(pokemon.getNickname());
			pokemonDTO.setSpecies(pokemon.getPokemonId().toString());
			pokemonDTO.setCombatPoints(pokemon.getCp());
			pokemonDTO.setHitPoints(pokemon.getStamina());
			pokemonDTO.setIvPercent(pokemon.getIvRatio());
			pokemonDTO.setIvAttack(pokemon.getIndividualAttack());
			pokemonDTO.setIvDefense(pokemon.getIndividualDefense());
			pokemonDTO.setIvStamina(pokemon.getIndividualStamina());
			pokemonDTO.setMove1(pokemon.getMove1().name());
			pokemonDTO.setMove2(pokemon.getMove2().name());
			pokemonDTO.setType1(pokemon.getMeta().getType1().name());
			pokemonDTO.setType2(pokemon.getMeta().getType2().name());
			
			pokemonDTOs.add(pokemonDTO);
		}
		return pokemonDTOs;
	}
}
