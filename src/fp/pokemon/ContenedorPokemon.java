package fp.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
	
	
}