
package fp.pokemon;

import java.time.LocalDateTime;
import java.util.List;

public record Pkm(Integer numberP, String name, Tipo type1, Tipo type2, LocalDateTime fA, Integer HP,
 Integer Attack, Integer Defense, Integer SpAtk, Integer SpDef, Integer Speed,
 Integer Stage, Boolean Legendary, List<String> abilities) {
	
	

}
