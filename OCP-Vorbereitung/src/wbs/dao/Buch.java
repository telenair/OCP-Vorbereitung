package wbs.dao;

import java.io.Serializable;

public class Buch implements Serializable {

	private static final long serialVersionUID = 1L;
	private String isbn;
	private String autor;
	private String titel;
	private double preis;
	
	public String getIsbn() {
		return isbn;
	}
	public String getAutor() {
		return autor;
	}
	public String getTitel() {
		return titel;
	}
	public double getPreis() {
		return preis;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	@Override
	public String toString() {
		return titel+ " von " + autor +  " kostet " + preis + " und ist bestellbar unter " + isbn ;
		
	}
	
	
	
}
