package br.com.imcProject;

public class Resultado {
	
	private int _id;
	private String autor;
	private String data;
	private Float peso;
	private Float altura;
	private Float imc;
	
	public int _id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public Float getImc() {
		return imc;
	}
	public void setImc(Float imc) {
		this.imc = imc;
	}
}
