package br.com.imcProject;

import java.util.ArrayList;

public class Autor 
{
	private String nome;
	
	private ArrayList<Resultado> Ficheiros = new ArrayList<Resultado>();
	
	public ArrayList<Resultado> getHistorico() {
		return Ficheiros;
	}

	public void setHistorico(Resultado result) {
		this.Ficheiros.add(result);	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
