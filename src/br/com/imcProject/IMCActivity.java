package br.com.imcProject;


import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class IMCActivity extends Activity {
	
	//variaveis
	TextView tvCondicao;
	EditText etPeso, etAltura, etResultado;
	float pesoFloat, alturaFloat, resultadoFloat;
	String texto;
	Button btCalcular;

	Intent a = new Intent();
	
    @Override
    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //conversão
        tvCondicao = (TextView) findViewById(R.texto.condicao);
        etPeso = (EditText) findViewById(R.entrada.peso);
        etAltura = (EditText) findViewById(R.entrada.altura);
        etResultado = (EditText) findViewById(R.saida.resultado);
        a.setClass(this, Valores.class);
    }
    public void Calcular(View v)
    {
				

				
				//Ligação do float com a String do form
				pesoFloat = Float.parseFloat(etPeso.getText().toString());
				alturaFloat = Float.parseFloat(etAltura.getText().toString());	
				
				//calculo do IMC
				resultadoFloat = pesoFloat / (alturaFloat * alturaFloat);	
				
				
				String pesoParam = etPeso.getText().toString();
				String alturaParam = etAltura.getText().toString();				
				
				//metodo set, para setar o valor que estar em float na String				
				etResultado.setText(String.valueOf(resultadoFloat));
				
				//conversão dos campos TextView para String
				String resultadoParam = etResultado.getText().toString();
						
				
				a.putExtra("atributoPeso", pesoParam);
				a.putExtra("atributoAltura", alturaParam);
				a.putExtra("atributoIMC", resultadoParam);
				
			    startActivity(a);
				

				
				/* //condições
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
				} */
				

				
				
			}



 }
