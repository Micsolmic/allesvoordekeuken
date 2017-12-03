package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="artikels")
public class Artikel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;
	
	
	protected Artikel() {/*def constructor needed for JPA*/}
	
	public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
		
		setNaam(naam);
		setAankoopprijs(aankoopprijs);
		setVerkoopprijs(verkoopprijs);
		
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
	
	
}
