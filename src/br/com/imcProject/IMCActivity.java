package br.com.imcProject;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IMCActivity extends Activity {
    /** Called when the activity is first created. */
	//variaveis
	EditText etPeso, etAltura, etResultado;
	float pesoFloat, alturaFloat, resultadoFloat;
	Button btCalcular;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //conversão
        etPeso = (EditText) findViewById(R.entrada.peso);
        etAltura = (EditText) findViewById(R.entrada.altura);
        etResultado = (EditText) findViewById(R.saida.resultado);
        btCalcular = (Button) findViewById(R.calculo.btCalculo);
        
        btCalcular.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				//Ligação do float com a String do form
				pesoFloat = Float.parseFloat(etPeso.getText().toString());
				alturaFloat = Float.parseFloat(etAltura.getText().toString());
				
				//calculo do IMC
				resultadoFloat = pesoFloat / (alturaFloat * alturaFloat);
				
								
				//metodo set, para setar o valor que estar em float na String
				
				etResultado.setText(String.valueOf(resultadoFloat));
							
				
			}
		});



    }
}