package mypoke.inventory;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pokegoapi.api.inventory.Inventories;

import mypoke.pokemon.PokemonDTO;

public class InventoryServiceTest {

	public void testInventoryLogin()  {
		System.out.println("TEST INV");
		try {
			InventoryService inventoryService = new InventoryService();
			List<PokemonDTO> pokemonDTOs = inventoryService.getPokemons("4/7UZP42vjWq-xSXoLDtr82XNbBWAl6GLTE1Ot-fgygos");
			Assert.assertNotNull(pokemonDTOs);
		} catch (Exception anyExc) {
			anyExc.printStackTrace();
			Assert.assertTrue(anyExc.getMessage(), false);
		}
	}
}
