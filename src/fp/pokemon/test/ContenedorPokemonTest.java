package fp.pokemon.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
		System.out.println("\nTest del metodo existePokemon");
		System.out.println(pokedex.existePokemon("Bulbasaur"));
		System.out.println(pokedex.existePokemon("Raikou"));
		System.out.println("--------------------------");
	}
	
	private static void testCuentaPorTipo() {
		Tipo t1 = Tipo.ICE;
		System.out.println("\nTest del metodo cuentaPorTipo");
		System.out.println("Hay " + pokedex.cuentaPorTipo(t1) + " pokemons del tipo " + t1);
		System.out.println("--------------------------");
	}
	
	private static void testFiltraPorLegendario() {
		System.out.println("\nTest del metodo filtraPorLegendario");
		System.out.println(pokedex.filtraPorLegendario());
		System.out.println("--------------------------");
	}
	
	private static void testAgruparPorTipo1() {
		System.out.println("\nTest del metodo agrupaPorTipo1");
		System.out.println(pokedex.agruparPorTipo1());
		System.out.println("--------------------------");
	}
	
	private static void testAcumularStatsPorTipo() {
		System.out.println("\nTest del metodo acumularStatsPorTipo");
		System.out.println(pokedex.acumularStatsPorTipo());
		System.out.println("--------------------------");
	}
	
	

}
		
		

		