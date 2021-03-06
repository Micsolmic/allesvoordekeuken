package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Korting;


@Entity
@Table(name="artikels")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="soort")
public class Artikel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;
	
	@ElementCollection
	@CollectionTable (name="kortingen", joinColumns = @JoinColumn(name="artikelid"))
	@OrderBy("vanafAantal")
	Set<Korting> kortingen;
	
	
	
	protected Artikel() {/*def constructor needed for JPA*/}
	
	public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
		
		setNaam(naam);
		setAankoopprijs(aankoopprijs);
		setVerkoopprijs(verkoopprijs);
		kortingen = new LinkedHashSet<>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		if(naam != null && ! naam.isEmpty()) {
			
			this.naam = naam;
			
		}else {
			
			throw new IllegalArgumentException("naam moet ingevuld");
			
		}
	}
	
	
	public BigDecimal getAankoopprijs() {
		return aankoopprijs;
	}
	public void setAankoopprijs(BigDecimal aankoopprijs) {
if(aankoopprijs.compareTo(BigDecimal.ZERO) > 0) {
			
			this.aankoopprijs = aankoopprijs;
			
		}else {
			
			throw new IllegalArgumentException("aankoopprijs moet groter dan 0");
			
		}
	}
	public BigDecimal getVerkoopprijs() {
		return verkoopprijs;
	}
	public void setVerkoopprijs(BigDecimal verkoopprijs) {
if(aankoopprijs.compareTo(BigDecimal.ZERO) > 0) {
			
			this.verkoopprijs = verkoopprijs;
			
		}else {
			
			throw new IllegalArgumentException("verkoopprijs moet groter dan 0");
			
		}
	}
	
	
	public Set<Korting> getKortingen(){
		return kortingen;		
	}
	
	public int compareTo(Artikel art) {
		
		return this.getNaam().compareTo(art.getNaam());
		
	}
	
}
