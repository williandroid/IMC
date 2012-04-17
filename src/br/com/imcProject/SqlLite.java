package br.com.imcProject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SqlLite 
{
	private SQLiteDatabase banco = null;
	private final String NOME_BANCO = "androidimc";
	private final String NOME_TABELA = "historico";
	
	public SqlLite(Context ctx)
	{
		//banco = new SQLiteDatabase():
		banco = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		banco.execSQL("CREATE TABLE IF NOT EXISTS "+ NOME_TABELA + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"autor TEXT NOT NULL, data TEXT NOT NULL, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL)");
		
	}
	
	public void inserir(String autor, String data, Float peso, Float altura, Float imc)
	{
		banco.execSQL("INSERT INTO " + NOME_TABELA + " (autor, data, peso, altura, imc) VALUES ("+ autor + ", "+ data +
				", "+ peso + ", "+ altura + ", "+imc+")");
	}
	
	public void  busca(String autor)
	{
		String[] coluna = new String[]{"_id", "autor"," data", "peso", "altura","imc"};
		Cursor resposta = banco.query(NOME_TABELA, coluna, selection, selectionArgs, groupBy, having, orderBy)
	}
}
