package be.vdab.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FoodArtikel extends Artikel {

	private static final long serialVersionUID = 1L;	
	int houdbaarheid;
	
}