package br.com.imcProject;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Ficheiros extends ListActivity
{
	 ArrayList<HashMap<String,String>> lista = new ArrayList<HashMap<String,String>>();
	 ArrayList<Resultado> calculoArray = new ArrayList<Resultado>();
	 
	  public void onCreate(Bundle savedInstanceState) 
	  {
	        super.onCreate(savedInstanceState);
			  BuscaEcarregaDados();
			  String[] from = new String[]{"data", "imc"};
			  int [] to = new int[]{android.R.id.text1, android.R.id.text2}; 
			  int layoutNativo = android.R.layout.two_line_list_item;
			  setListAdapter(new SimpleAdapter(this, lista, layoutNativo, from, to));
	                
	  }

	  protected void onListItemClick(ListView lView, View v, int posicao, long id) 
	  {
			super.onListItemClick(lView, v, posicao, id);
				Resultado result = calculoArray.get(posicao);
				SqlLite.Mensagem("Willian", "_id: "+result._id()+"\n"+
								 "Peso: " +result.getPeso()+"\n"+
								 "Altura: " +result.getAltura()+"\n", this);			
		}	
		
	  
	  public void BuscaEcarregaDados()
	  {
		  calculoArray = SqlLite.busca(this);
		  int count = 0;
		  while(count < calculoArray.size())
		  {
			Resultado result = calculoArray.get(count);
			HashMap<String,String> item  = new HashMap<String,String>();
			
			item.put("autor", SqlLite.NOME_AUTOR);
			item.put("data", String.valueOf(result.getData()));
			item.put("peso", String.valueOf(result.getPeso()));
			item.put("altura", String.valueOf(result.getAltura()));
			item.put("imc", String.valueOf(result.getImc()));
			lista.add(item);
			count ++;
		  }
	
	  }
}
