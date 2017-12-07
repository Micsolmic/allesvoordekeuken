package be.vdab.valueobjects;

import java.math.BigDecimal;

import javax.persistence.Embeddable;


@Embeddable
public class Korting {

	
	int vanafAantal;
	BigDecimal kortingsPercentage;
	
	
	protected Korting() {}
	
	
	public Korting(int vanaf, BigDecimal percentage) {
		
		vanafAantal = vanaf;
		kortingsPercentage = percentage;
		
	}
	
	public int getVanafAantal() {
		return vanafAantal;
	}
	
	public BigDecimal getKortingsPercentage() {
		return kortingsPercentage;
	}
	
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Korting) ) {return false;}
		if(((Korting) obj).vanafAantal == this.vanafAantal && ((Korting) obj).kortingsPercentage.compareTo(this.kortingsPercentage)== 0){
			
			return true;
		}
		
		return false;
	}
	
	public int hashCode() {
		
		return (vanafAantal^2 + kortingsPercentage.intValue()^2) % 7;
	}
	
}
