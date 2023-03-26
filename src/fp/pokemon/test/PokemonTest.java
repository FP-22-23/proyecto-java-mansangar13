package fp.pokemon.test;

import fp.common.Tipo;
import fp.pokemon.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PokemonTest {

	public static void main(String[] args) {
		
		List<String> abilities1 = new ArrayList<String>();
		abilities1.add("Overgrow");
		abilities1.add("Chlorophyll");
		
		
		List<String> abilities2 = new ArrayList<String>();
		abilities2.add("Synchronize");
		
		
		List<String> abilities3 = new ArrayList<String>();
		abilities3.add("Inner Focus");
		abilities3.add("Multiscale");
		
		
		Pokemon Bulbasaur = new Pokemon(1,"Bulbasaur",Tipo.GRASS, Tipo.POISON, LocalDateTime.of(1999, 11, 19, 0, 3, 41), 45, 49 ,49, 65, 65, 45, 1, false, abilities1);
		
		
		
		Pokemon Mew = new Pokemon(151,"Mew",Tipo.PSYCHIC, Tipo.NT2, LocalDateTime.of(2002, 1, 13, 19, 14, 43),100, 100, 100, 100, 100, 100, 1, true, abilities2);
		
		
		Pokemon Dragonite = new Pokemon(149,"Dragonite",Tipo.DRAGON, Tipo.FLYING, LocalDateTime.of(2002, 12, 8, 13, 26, 53), 91, 134 ,95, 100, 100, 80, 1, false, abilities3);
		
		System.out.println("To String");
		System.out.println(Bulbasaur.toString());
		System.out.println(Mew.toString());
		System.out.println(Dragonite.toString());
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		System.out.println("GETTERS");
		System.out.println("El número en la pokedex de " + Bulbasaur.getName() + " es " + Bulbasaur.getNumberP());
		System.out.println("Los tipos de " + Dragonite.getName() + " son " + Dragonite.getType1() + " y " + Dragonite.getType2());
		System.out.println("La primera fecha de aparicion de " + Mew.getName() + " fuen en la fecha:  " + Mew.getfA());
		System.out.println(Dragonite.getName() + " tiene un total de " + Dragonite.getTotalStats() + " puntos de stats. ¿Es pseudolegendario? " + Dragonite.getIsPseudoLegendary());
		System.out.println("¿Es " + Mew.getName() + " un pokemon legendario? " + Mew.getLegendary());
		System.out.println("Las habilidades de " + Bulbasaur.getName() + " son: " + Bulbasaur.getAbilities());
		
		//Seters (Aunque no tenga sentido modificar los parametros de un pokemon, usaré los setters para comprobar las restricciones)
		//Bulbasaur.setName("");
		//Dragonite.setfA(LocalDateTime.of(1900, 1, 13, 19, 14, 43));
		//Mew.setNumberP(0);
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		
		//EQUALS
		System.out.println("EQUALS");
		System.out.println("¿Son iguales " + Bulbasaur.getName()+ " y " + Dragonite.getName() +"?");
		if (Bulbasaur.equals(Dragonite)) {
			System.out.println("Son dos pokemon iguales");
		}else{
			System.out.println("Son diferentes");
		}
		
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("-----------------------------------------------------------");
		
		//COMPARE TO
		System.out.println("COMPARE TO");
		
		int r = Bulbasaur.compareTo(Dragonite);
	    if(r == 0) {
			System.out.println("Los pokemon son los mismos");
		} 
		else if(r > 0) {
			System.out.println("El pokemon " + Bulbasaur.getName() + " va despues en la pokédex que " + Dragonite.getName());
		}
		else
			System.out.println("El pokemon " + Bulbasaur.getName() + " va antes en la pokédex que " + Dragonite.getName());
		}
		
	

		
	

	}


