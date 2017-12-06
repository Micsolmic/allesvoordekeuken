package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FoodArtikel extends Artikel {

	private static final long serialVersionUID = 1L;	
	int houdbaarheid;
	
	
	protected FoodArtikel(){}
	
	
	
	public FoodArtikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs, int houdbaarheid) {
		super(naam, aankoopprijs, verkoopprijs);
		this.houdbaarheid = houdbaarheid;

		}
	
	
	
	
}





