package br.com.imcProject;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SqlLite 
{
	
	static final String NOME_BANCO = "androidimc";
	static final String NOME_TABELA = "historico";
	static final String NOME_AUTOR = "willian";
	static final String DATA_INSERCAO = "25";
	static SQLiteDatabase banco;
	
	
	//Metodo que cria o banco e a tabela
	public static void criarBanco(Context ctx)
	{
		//banco = new SQLiteDatabase()
		try
		{
			banco = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);		
		}
		catch(SQLException e)
		{
			Mensagem("Erro no Banco", "Não foi possivel criar o BD", ctx);
		}
			
	}
	
	public static void criarTabela(Context ctx)
	{
		try{
				banco.execSQL("CREATE TABLE IF NOT EXISTS "+ NOME_TABELA + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
				" autor TEXT, data TEXT, peso REAL NOT NULL, altura REAL NOT NULL, imc REAL NOT NULL)");				
			}
			catch(SQLException e)
			{
				Mensagem("Erro no Banco", "Não foi possivel criar o BD", ctx);
			}
		}	
	
	
	
	//Realiza Busca
	public static ArrayList<Resultado> busca(Context ctx)
	{
		criarBanco(ctx);
		criarTabela(ctx);
			ArrayList<Resultado> busca = new ArrayList<Resultado>();
			Cursor resposta = banco.query(NOME_TABELA, new String[] {"_id",  "data", "peso", "altura", "imc"},
					"autor=?", new String[]{NOME_AUTOR}, null, null, null);
			if (resposta.getCount()> 0)
			{
				int count = 0;
				resposta.moveToFirst();
				while(count < resposta.getCount())
				{
					Resultado result = new Resultado();
					result.setAutor(resposta.getString(1));
					result.setData(resposta.getString(2));
					result.setPeso(resposta.getFloat(3));
					result.setAltura(resposta.getFloat(4));
					result.setImc(resposta.getFloat(5));
					busca.add(result);
					resposta.moveToNext();
					count++;
				}	
				resposta.close();
				banco.close();
			}
			
			return busca;
	   }
		
	
	//Inseri dados nos capos da tabela	
	public static void inserir(Context ctx, Float peso, Float altura, Float imc)
	{
		criarBanco(ctx);
		criarTabela(ctx);
		try
		{
			banco.execSQL("INSERT INTO " + NOME_TABELA + " (autor, data, peso, altura, imc) VALUES ('"+ NOME_AUTOR +"', '" + DATA_INSERCAO + "','" + peso +
					"','" + altura + "','"+ imc + "')");
			
			Mensagem("STATUS REGISTRO", "Registro Gravado com Sucesso", ctx);
		}
		catch(SQLException e)
		{
			Mensagem("STATUS REGISTRO", "Não foi possivel Gravar no BD", ctx);
		}
		finally
		{
			banco.close();
		}
	}

	
	public static void Mensagem(String tituloAlerta, String mensagemAlerta, Context ctx)
	{
		AlertDialog.Builder Mensagem = new AlertDialog.Builder(ctx);
		Mensagem.setTitle(tituloAlerta);
		Mensagem.setMessage(mensagemAlerta);
		Mensagem.setNeutralButton("Ok", null);
		Mensagem.show();
	}
	
}
