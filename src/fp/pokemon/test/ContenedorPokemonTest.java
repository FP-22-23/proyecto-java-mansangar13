package fp.pokemon.test;

import java.util.ArrayList;
import java.util.List;

import fp.common.Tipo;

import fp.pokemon.ContenedorPokemon;
import fp.pokemon.FactoriaPokemon;
import fp.pokemon.Pokemon;


public class ContenedorPokemonTest {
	
	private static Pokemon p1 = FactoriaPokemon.parsearPokemon("200,Duxtox,Bug,Poison,2014-02-01 2:53:47,65,90,40,45,80,75,3,FALSE,Ataque Furia,Pin Misil,Picotazo Veneno");
	private static Pokemon p2 = FactoriaPokemon.parsearPokemon("250,Magmortar,Bug,Poison,2014-02-01 2:53:47,65,90,40,45,80,75,3,FALSE,Ataque Furia,Pin Misil,Picotazo Veneno");
	private static Pokemon p3 = FactoriaPokemon.parsearPokemon("300,Dewot,Bug,Poison,2014-02-01 2:53:47,65,90,40,45,80,75,3,FALSE,Ataque Furia,Pin Misil,Picotazo Veneno");
	
	private static ContenedorPokemon pokedex = FactoriaPokemon.leerPokemon("./data/pokemon.csv");
	
	
	public static void main(String[] args) {
		
		System.out.println(pokedex);
		testConstructor();
		testOperacionesBasicas();
		testExistePokemon();
		testCuentaPorTipo();
		testFiltraPorLegendario();
		testAgruparPorTipo1();
		testAcumularStatsPorTipo();
		testMaximoVelocidadPokesLegendarios();
		testOrdenarDefensaPorTipo();
		testPokemonsporTipo();
		testMayorStatsPorAnyo();
		testHabilidadesMasUsadas();
		testLegendarioMasFuertes();
	}
	
	private static void testConstructor() {
	System.out.println("Test del constructor del contenedor");
	ContenedorPokemon listaVacia = new ContenedorPokemon();
	System.out.println(listaVacia);
	
	}
	
	private static void testOperacionesBasicas() {
		ContenedorPokemon contenedor= new ContenedorPokemon();
		System.out.print("\nNumero de pokemons despues de crear el contenedor vacio: " + contenedor.numPokemons());
		contenedor.añadirPokemon(p1);
		System.out.print("\nNumero de pokemons despues de añadir un pokemon: " + contenedor.numPokemons());
		List<Pokemon> lista = new ArrayList<>();
		lista.add(p2);
		lista.add(p3);
		contenedor.añadirPokemons(lista);
		System.out.print("\nNumero de pokemons despues de añadir dos pokemons a la vez: " + contenedor.numPokemons());
		contenedor.eliminarPokemon(p1);
		System.out.print("\nNumero de pokemons despues de eliminar un pokemon: " + contenedor.numPokemons());
		System.out.println("\n--------------------------");
	}
	
	private static void testExistePokemon() {
		System.out.println("\nTest del metodo existePokemon (bucle)");
		System.out.println("Existe el pokemon Bulbasaur: " + pokedex.existePokemon("Bulbasaur"));
		System.out.println("Existe el pokemon Raikou: " +pokedex.existePokemon("Raikou"));
		System.out.println("--------------------------");
		System.out.println("\nTest del metodo existePokemon (stream)");
		System.out.println("Existe el pokemon Bulbasaur: " + pokedex.existePokemon2("Bulbasaur"));
		System.out.println("Existe el pokemon Raikou: " +pokedex.existePokemon2("Raikou"));
		System.out.println("--------------------------");
	}
	
	private static void testCuentaPorTipo() {
		Tipo t1 = Tipo.ICE;
		System.out.println("\nTest del metodo cuentaPorTipo (bucle)");
		System.out.println("Hay " + pokedex.cuentaPorTipo(t1) + " pokemons del tipo " + t1);
		System.out.println("--------------------------");
		System.out.println("\nTest del metodo cuentaPorTipo (stream)");
		System.out.println("Hay " + pokedex.cuentaPorTipo2(t1) + " pokemons del tipo " + t1);
		System.out.println("--------------------------");
	}
	
	private static void testFiltraPorLegendario() {
		System.out.println("\nTest del metodo filtraPorLegendario (bucle)");
		System.out.println(pokedex.filtraPorLegendario());
		System.out.println("--------------------------");
		System.out.println("\nTest del metodo filtraPorLegendario (stream)");
		System.out.println(pokedex.filtraPorLegendario());
		System.out.println("--------------------------");
	}
	
	private static void testAgruparPorTipo1() {
		System.out.println("\nTest del metodo agrupaPorTipo1");
		System.out.println(pokedex.agrupaPorTipo1());
		System.out.println("--------------------------");
	}
	
	private static void testAcumularStatsPorTipo() {
		System.out.println("\nTest del metodo acumularStatsPorTipo");
		System.out.println(pokedex.acumularStatsPorTipo());
		System.out.println("--------------------------");
	}
	
	private static void testMaximoVelocidadPokesLegendarios() {
		System.out.println("\nTest del metodo maximoAtaquePokesLegendario");
		System.out.println(pokedex.maximoVelocidadPokesLegendario());
		System.out.println("--------------------------");
	}
	
	private static void testOrdenarDefensaPorTipo() {
		Tipo t1 = Tipo.FIRE;
		System.out.println("\nTest del metodo ordenarDefensaPorTipo");
		System.out.println(pokedex.ordenarDefensaPorTipo(t1));
		System.out.println("--------------------------");
		
	}
	
	private static void testPokemonsporTipo() {
		System.out.println("\nTest del metodo pokemonsporTipo");
		System.out.println(pokedex.pokemonsPorTipo());
		System.out.println("--------------------------");
	}
	
	
	private static void testMayorStatsPorAnyo() {
		System.out.println("\nTest del metodo mayorStatsPorAnyo");
		System.out.println(pokedex.mayorStatsPorAnyo());
		System.out.println("--------------------------");
	}
	
	
	private static void testHabilidadesMasUsadas() {
		System.out.println("\nTest del metodo HabilidadesMasUsadas");
		System.out.println(pokedex.habilidadesMasUsadas(15));
		System.out.println("--------------------------");
	}
	
	private static void testLegendarioMasFuertes() {
		System.out.println("\nTest del metodo legendarioMasFuerte");
		System.out.println(pokedex.legendarioMasFuerte());
		System.out.println("--------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
		
		

		