package fp.pokemon;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


import fp.common.Tipo;

public class FactoriaPokemon {
	
	public static Pokemon parsearPokemon(String linea) {
		String[] campos = linea.split(",");
		Integer numberP = Integer.parseInt(campos[0]);
		String name = campos[1];
		Tipo type1 = Tipo.valueOf(campos[2].toUpperCase());
		Tipo type2 = Tipo.valueOf(campos[3].toUpperCase());
		LocalDateTime fA = LocalDateTime.parse(campos[4],DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss"));
		Integer HP = Integer.parseInt(campos[5]);
		Integer Attack = Integer.parseInt(campos[6]);
		Integer Defense = Integer.parseInt(campos[7]);
		Integer SpAtk = Integer.parseInt(campos[8]);
		Integer SpDef = Integer.parseInt(campos[9]);
		Integer Speed = Integer.parseInt(campos[10]);
		Integer Stage = Integer.parseInt(campos[11]);
		Boolean Legendary = campos[12].equalsIgnoreCase("TRUE");
		List<String> abilities = Arrays.asList(campos[13].split(","));
		
		return new Pokemon(numberP, name, type1, type2, fA, HP,  Attack, Defense, SpAtk, SpDef, Speed, Stage, Legendary, abilities);
	}
	
	  public static ContenedorPokemon leerPokemon(String ruta){
		  
		  try {
			  ContenedorPokemon res = new ContenedorPokemon();
				Files.lines(Paths.get(ruta))
					.skip(1)
					.map(FactoriaPokemon::parsearPokemon)
					.forEach(p -> res.añadirPokemon(p));
				return res;
			} catch (IOException e) {
				System.out.println("No se ha encontrado el fichero " + ruta);
				e.printStackTrace();
				return null;
			}
		}

	
}
