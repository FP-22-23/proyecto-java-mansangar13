package fp.pokemon.test;

import fp.pokemon.ContenedorPokemon;
import fp.pokemon.FactoriaPokemon;

public class FactoriaPokemonTest {
	public static void main(String[] args) {
		testContenedorPokemon();
	}
	
	private static void testContenedorPokemon() {
		System.out.println("Test FactoriaPokemon");
		ContenedorPokemon pokemons = FactoriaPokemon.leerPokemon("./data/pokemon.csv");
		System.out.println("Pokemons: " + pokemons);
		
	}
	
}

	