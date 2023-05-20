package fp.pokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Tipo;


public class ContenedorPokemon {
	
	private List<Pokemon> pokemons;
	
	public ContenedorPokemon() {
		this.pokemons = new ArrayList<>();
	}
	
	public ContenedorPokemon(Stream<Pokemon> st) {
		this.pokemons = st.collect(Collectors.toList());
	}
	
	public Integer numPokemons() {
		return pokemons.size();	
		}
	
	public void añadirPokemon(Pokemon p) {          
		 pokemons.add(p);
	        
	    }
	 
	 public void añadirPokemons(List<Pokemon> nuevosPokemon) {
		 pokemons.addAll(nuevosPokemon);
	 }
	 
	 public void eliminarPokemon(Pokemon p) { 
	        if (!pokemons.contains(p)) {
	            throw new IllegalArgumentException("El pokemon no existe");
	        } else {
	        	pokemons.remove(p);
	        }
	    } 
	 
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorPokemon other = (ContenedorPokemon) obj;
		return Objects.equals(pokemons, other.pokemons);
	}

	
	public String toString() {
		return "ContenedorPokemon [pokemons=" + pokemons + "]";
	}
	
	// Nueva funcion sin streams
	public boolean existePokemon(String nombre) {
		for(Pokemon pokemon : this.pokemons) {
			if(pokemon.getName().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	//Antigua funcion con streams
	public boolean existePokemon2(String nombre) {
	    return pokemons.stream().anyMatch(pokemon -> pokemon.getName().equalsIgnoreCase(nombre));
	}
	
	public Integer cuentaPorTipo(Tipo tipo) {
		Integer res = 0;
		for(Pokemon pokemon: this.pokemons) {
			if(pokemon.getType1() == tipo || pokemon.getType2() == tipo) {
				res ++;
			}
		}
		
		return res;
	}
	
	//Funcion cuentaPorTipo hecha con streams
	
	public int cuentaPorTipo2(Tipo tipo) {
	    return (int) this.pokemons.stream()
	            .filter(pokemon -> pokemon.getType1() == tipo || pokemon.getType2() == tipo)
	            .count();
	}

	
	public List<Pokemon> filtraPorLegendario(){
		List<Pokemon> res = new LinkedList<>();
		for(Pokemon pokemon: this.pokemons) {
			if(pokemon.getLegendary() == true) {
				res.add(pokemon);
			}
		}
		return res;
	}
	
	// funcion filtraPorLegendario hecha con streams
	
	public List<Pokemon> filtraPorLegendario2() {
	    return this.pokemons.stream()
	            .filter(Pokemon::getLegendary)
	            .collect(Collectors.toList());
	}

	
	//Nueva funcion hecha sin streams
	public Map<Tipo, List<String>> agrupaPorTipo1(){
		Map<Tipo, List<String>> res = new HashMap<>();
		
		for(Pokemon pokemon: pokemons) {
			Tipo tipo = pokemon.getType1();
			String nombre = pokemon.getName();
			
			if(res.containsKey(tipo)) {
				res.get(tipo).add(nombre);
			} else {
				List<String> nombres = new ArrayList<>();
				nombres.add(nombre);
				res.put(tipo, nombres);
			}
		}
		return res;
	}
	
	//Antigua funcion hecha con streams
	public Map<Tipo, List<String>> agruparPorTipo2() {
		return pokemons.stream()
				.collect(Collectors.groupingBy(p -> p.getType1(),
					Collectors.mapping(Pokemon::getName, Collectors.toList())));
	}
	
	//Nueva funcion hecha con streams
	public Map<Tipo, Integer> acumularStatsPorTipo() {
	    Map<Tipo, Integer> res = new HashMap<>();

	    for (Pokemon pokemon : pokemons) {
	        Tipo tipo = pokemon.getType1();
	        int totalStats = pokemon.getTotalStats();

	        if (res.containsKey(tipo)) {
	            int currentTotalStats = res.get(tipo);
	            res.put(tipo, currentTotalStats + totalStats);
	        } else {
	            res.put(tipo, totalStats);
	        }
	    }

	    return res;
	}
	
	//Antigua funcion hecha con streams
	public Map<Tipo, Integer> acumularStatsPorTipo2() {
		return pokemons.stream()
				.collect(Collectors.groupingBy(Pokemon::getType1, Collectors.summingInt(Pokemon::getTotalStats)));
	}
	
	
	public Pokemon maximoVelocidadPokesLegendario() {
		
		return pokemons.stream()
				.filter(pokemon -> pokemon.getLegendary() == true)
				.max(Comparator.comparingInt(Pokemon::getSpeed))
				.orElse(null);
		
	}
	
	public List<String> ordenarDefensaPorTipo(Tipo tipo) {
	    return pokemons.stream()
	            .filter(pokemon -> pokemon.getType1() == tipo)
	            .sorted(Comparator.comparingInt(Pokemon::getDefense).reversed())
	            .map(pokemon -> pokemon.getName() + " - Defense: " + pokemon.getDefense())
	            .collect(Collectors.toList());
	}

	
	public Map<Tipo, List<String>> pokemonsPorTipo(){
        return pokemons.stream()
                .collect(Collectors.groupingBy(pokemon -> pokemon.getType1(),
                        Collectors.mapping(Pokemon::getName, Collectors.toList())));
	}
	
	public Map<Object, Object> mayorStatsPorAnyo() {
	    return pokemons.stream()
	            .collect(Collectors.groupingBy(
	                    pokemon -> pokemon.getfA().getYear(),
	                    Collectors.collectingAndThen(
	                            Collectors.maxBy(Comparator.comparingInt(pokemon -> pokemon.getTotalStats())),
	                            maxPokemon -> maxPokemon.map(Pokemon::getName).orElse(""))));
	}
	
	public SortedMap<String, Integer> habilidadesMasUsadas(int n) {
	    return pokemons.stream()
	            .flatMap(pokemon -> pokemon.getAbilities().stream())
	            .collect(Collectors.groupingBy(habilidad -> habilidad,
	            		TreeMap::new,Collectors.summingInt(habilidad -> 1)))
	            .entrySet()
	            .stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	            .limit(n)
	            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1, v2) -> v1,TreeMap::new));
	}
	
	public Map<String, Integer> legendarioMasFuerte() {
	    return pokemons.stream()
	            .filter(Pokemon::getLegendary)
	            .max(Comparator.comparingInt(Pokemon::getTotalStats))
	            .map(pokemon -> Collections.singletonMap(pokemon.getName(), pokemon.getTotalStats()))
	            .orElse(Collections.emptyMap());
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}