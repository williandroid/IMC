package br.com.imcProject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuPrincipal extends ListActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final String[] itens = new String[] {"Calculo IMC", "Ficheiros", "Sair"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView lView, View v, int posicao, long id) {
		super.onListItemClick(lView, v, posicao, id);
		
		if(posicao == 0)
		{
			finish();
			Intent z = new Intent(this, IMCActivity.class);
			startActivity(z); 
		}else if(posicao == 1)
		{
			finish();
			Intent j = new Intent(this, Ficheiros.class);
			startActivity(j); 
		}else if(posicao == 2)
		{
			finish();
		}
		
	}
	
}
