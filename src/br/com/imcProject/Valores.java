package br.com.imcProject;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Valores extends Activity 
{
	float pesoFloat;
	float alturaFloat;
	float resultadoFloat;
	
	 final DecimalFormat formatoPeso = new DecimalFormat("00.0");
	 final DecimalFormat formatoAltura = new DecimalFormat("0.00");
	 final DecimalFormat formatoIMC = new DecimalFormat("00.00");
	
    public void onCreate(Bundle savedInstanceState) 
    {
     	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valores);
        
        Intent a = getIntent();
        
        //Puxando os valores da classe pai
        String peso = a.getStringExtra("atributoPeso");
    	String altura = a.getStringExtra("atributoAltura");
    	String imc = a.getStringExtra("atributoIMC");
    	
    	pesoFloat = Float.parseFloat(peso);
    	alturaFloat = Float.parseFloat(altura);
    	resultadoFloat = Float.parseFloat(imc);
    	
    	//Instanciando o objeto tvCondicao
    	TextView tvCondicao = (TextView) findViewById(R.id.tvCondicao);   
    	
    	//Condições do Imc
    	if (resultadoFloat < 18.5)
		{
			tvCondicao.setText("Você esta Abaixo do peso!");
		}
		
		else if (resultadoFloat >= 18.5 && resultadoFloat <= 24.9)
		{
			tvCondicao.setText("Parabéns Peso Normal!");
		}
		
		else if (resultadoFloat >= 25  && resultadoFloat <= 29.9)
		{
			tvCondicao.setText("Acima do Peso (SobrePeso)!");
		}
		
		else if (resultadoFloat >= 30  && resultadoFloat <= 34.9)
		{
			tvCondicao.setText("Obesidade Grau 1!");
		}
		
		else if (resultadoFloat >= 35  && resultadoFloat <= 39.9)
		{
			tvCondicao.setText("Obesidade Grau 2.!");
		}
		
		else if (resultadoFloat > 40)
		{
			tvCondicao.setText("Obesidade Grau 3!");
		}
		
		else 
		{
			tvCondicao.setText("Erro, entre com um valor!");
		} 
		
    	
    	//formatando os valores
    	peso = formatoPeso.format(pesoFloat);
    	altura = formatoAltura.format(alturaFloat);
    	imc = formatoIMC.format(resultadoFloat);
    	
    	
        //tvCondicao = (TextView) findViewById(R.texto.condicao);
        TextView tvPeso = (TextView) findViewById(R.id.tvPeso);
        TextView tvAltura = (TextView) findViewById(R.id.tvAltura);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        
        //colocando os valores dentro do TextView
        tvPeso.setText(peso);
        tvAltura.setText(altura);
        tvResultado.setText(imc);
        
        //Exibição
        tvAltura.setText("Altura: " + altura);
        tvPeso.setText("Peso: " + peso);
        tvResultado.setText("IMC: " + imc);
        
    }
    
}