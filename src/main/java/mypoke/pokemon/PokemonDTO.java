package mypoke.pokemon;

public class PokemonDTO {

	String nickName;
	String species;
	Double ivPercent;
	Integer ivAttack;
	Integer ivDefense;
	Integer ivStamina;
	String type1;
	String type2;
	String move1;
	String move2;
	Integer combatPoints;
	Integer hitPoints;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Double getIvPercent() {
		return ivPercent;
	}

	public void setIvPercent(Double ivPercent) {
		this.ivPercent = ivPercent;
	}

	public Integer getIvAttack() {
		return ivAttack;
	}

	public void setIvAttack(Integer ivAttack) {
		this.ivAttack = ivAttack;
	}

	public Integer getIvDefense() {
		return ivDefense;
	}

	public void setIvDefense(Integer ivDefense) {
		this.ivDefense = ivDefense;
	}

	public Integer getIvStamina() {
		return ivStamina;
	}

	public void setIvStamina(Integer ivStamina) {
		this.ivStamina = ivStamina;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getMove1() {
		return move1;
	}

	public void setMove1(String move1) {
		this.move1 = move1;
	}

	public String getMove2() {
		return move2;
	}

	public void setMove2(String move2) {
		this.move2 = move2;
	}

	public Integer getCombatPoints() {
		return combatPoints;
	}

	public void setCombatPoints(Integer combatPoints) {
		this.combatPoints = combatPoints;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

}
