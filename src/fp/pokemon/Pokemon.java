package fp.pokemon;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import fp.common.Tipo;
import fp.utiles.*;

public class Pokemon {
	
	private Integer numberP;
	private String name;
	private Tipo type1;
	private Tipo type2;
	private LocalDateTime fA;
	private Integer HP;
	private Integer Attack;
	private Integer Defense;
	private Integer SpAtk;
	private Integer SpDef;
	private Integer Speed;
	private Integer Stage;
	private Boolean Legendary;
	private List<String> abilities;
	

	
	public Pokemon(Integer numberP, String name, Tipo type1, Tipo type2, LocalDateTime fA, Integer HP, Integer Attack,
	 Integer Defense ,Integer SpAtk, Integer SpDef,Integer Speed,Integer Stage, Boolean Legendary, List<String> abilities) {
		Checkers.check("¡Las fecha de aparicion de los pokemon deben estar entre el 1 de enero de 1996 a las 00:00:00 y el 1 de enero de 2023 a las 00:00:00!", 
				fA.isAfter(LocalDateTime.of(1996, 1, 1, 00, 00, 00)) && fA.isBefore(LocalDateTime.of(2023, 1, 1, 00, 00, 00)));
		Checkers.check("¡Un pokemon debe estar entre los 1010 totales que existen!",  numberP > 0 && numberP <= 1010);
		//Checkers.check("Las estadisticas de un pokemon nunca pueden ser negativas o 0", HP > 0 && Attack > 0 && Defense > 0 && SpAtk > 0 && SpDef > 0 && Speed > 0  );
		Checkers.check("¡El nombre de un pokemon nunca puede estar vacío!", name != ""  );
		
	
		this.numberP = numberP;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.fA = fA;
		this.HP = HP;
		this.Attack = Attack;
		this.Defense = Defense;
		this.SpAtk = SpAtk;
		this.SpDef = SpDef;
		this.Speed = Speed;
		this.Stage = Stage;
		this.Legendary = Legendary;
		this.abilities = abilities;
		
		}
	
	


	public Pokemon(String name, Tipo type1, Tipo type2, Integer stage) {
		Checkers.check("El nombre de un pokemon nunca puede estar vacío", name != ""  );
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		Stage = stage;
	}




	//GETTERS Y SETTERS
	public Integer getNumberP() {
		return numberP;
	}


	public void setNumberP(Integer numberP) {
		Checkers.check("Un pokemon debe estar entre los 1010 totales que existen",  numberP > 0 && numberP <= 1010);
		this.numberP = numberP;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		Checkers.check("El nombre de un pokemon nunca puede estar vacío", name != ""  );
		this.name = name;
	}


	public Tipo getType1() {
		return type1;
	}


	public void setType1(Tipo type1) {
		this.type1 = type1;
	}


	public Tipo getType2() {
		return type2;
	}


	public void setType2(Tipo type2) {
		this.type2 = type2;
	}


	public LocalDateTime getfA() {
		return fA;
	}


	public void setfA(LocalDateTime fA) {
		Checkers.check("Las fechar de aparicion de los pokemon deben estar entre el 1 de enero de 1996 a las 00:00:00 y el 1 de enero de 2023 a las 00:00:00", 
				fA.isAfter(LocalDateTime.of(1996, 1, 1, 00, 00, 00)) && fA.isBefore(LocalDateTime.of(2023, 1, 1, 00, 00, 00)));
		this.fA = fA;
	}


	public Integer getHP() {
		return HP;
	}


	public void setHP(Integer hP) {
		HP = hP;
	}


	public Integer getAttack() {
		return Attack;
	}


	public void setAttack(Integer attack) {
		Attack = attack;
	}


	public Integer getDefense() {
		return Defense;
	}


	public void setDefense(Integer defense) {
		Defense = defense;
	}


	public Integer getSpAtk() {
		return SpAtk;
	}


	public void setSpAtk(Integer spAtk) {
		SpAtk = spAtk;
	}


	public Integer getSpDef() {
		return SpDef;
	}


	public void setSpDef(Integer spDef) {
		SpDef = spDef;
	}


	public Integer getSpeed() {
		return Speed;
	}


	public void setSpeed(Integer speed) {
		Speed = speed;
	}


	public Integer getStage() {
		return Stage;
	}


	public void setStage(Integer stage) {
		Stage = stage;
	}


	public Boolean getLegendary() {
		return Legendary;
	}


	public void setLegendary(Boolean legendary) {
		Legendary = legendary;
	}


	public List<String> getAbilities() {
		return abilities;
	}


	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	
	//Propiedad derivada
	
	public int getTotalStats() {
		return (this.HP+this.Attack+this.Defense+this.SpAtk+this.SpDef+this.Speed);
	}
	
	
	public Boolean getIsPseudoLegendary() {
		if (this.Legendary == true) {
			return false;
		}else if (getTotalStats() >= 600) {
			return true;
		}else {
			return false;
		}
		
	}

	//TO STRING
	public String toString() {
		return "Pokemon [numberP=" + numberP + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", fA=" + fA
				+ ", HP=" + HP + ", Attack=" + Attack + ", Defense=" + Defense + ", SpAtk=" + SpAtk + ", SpDef=" + SpDef
				+ ", Speed=" + Speed + ", Stage=" + Stage + ", Legendary=" + Legendary + ", abilities=" + abilities
				+ ", TotalStats=" + getTotalStats() + ", IsPseudoLegendary=" + getIsPseudoLegendary() + "]";
	}

	//EQUALS
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(Attack, other.Attack) && Objects.equals(Defense, other.Defense)
				&& Objects.equals(HP, other.HP) && Objects.equals(Legendary, other.Legendary)
				&& Objects.equals(SpAtk, other.SpAtk) && Objects.equals(SpDef, other.SpDef)
				&& Objects.equals(Speed, other.Speed) && Objects.equals(Stage, other.Stage)
				&& Objects.equals(abilities, other.abilities) && Objects.equals(fA, other.fA)
				&& Objects.equals(name, other.name) && Objects.equals(numberP, other.numberP) && type1 == other.type1
				&& type2 == other.type2;
	}
	
	
	public int compareTo(Pokemon p) {
		int r;
		if (p == null) {
			throw new NullPointerException();
		}
 	    r = this.getNumberP().compareTo(p.getNumberP());
	       if(r == 0) {
	   		r = this.getName().compareTo(p.getName());
	       }
		return r;
	}
	
	
	
	
	
	
}

