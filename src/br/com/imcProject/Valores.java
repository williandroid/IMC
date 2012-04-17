package br.com.imcProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Valores extends Activity 
{

	
	
	
    public void onCreate(Bundle savedInstanceState) 
    {
     	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valores);
        
        Intent a = getIntent();
    	String peso = a.getStringExtra("atributoPeso");
    	String altura = a.getStringExtra("atributoAltura");
    	String imc = a.getStringExtra("resultadoIMC");
        
        //tvCondicao = (TextView) findViewById(R.texto.condicao);
        TextView tvPeso = (TextView) findViewById(R.id.tvPeso);
        TextView tvAltura = (TextView) findViewById(R.id.tvAltura);
        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        
        tvPeso.setText(peso);
        tvAltura.setText(altura);
        tvResultado.setText(imc);
    }
}
