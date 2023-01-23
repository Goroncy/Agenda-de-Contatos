package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Banco 
{
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agenda_contatos?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "password";
	
	private Connection conectar() 
	{	
		Connection conexao = null;
		
		try
		{
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public void salvarNovoContato(Contato contato)
	{
		String create = "insert into contatos_agenda (Nome,Telefone,Email) values (?,?,?)";
		
		try
		{
			Connection conexao = conectar();
			
			PreparedStatement pst = conexao.prepareStatement(create);
			
			pst.setString(1,contato.getNome());
			pst.setString(2,contato.getFone());
			pst.setString(3,contato.getEmail());
			
			pst.executeUpdate();
			
			conexao.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<Contato> listarContatos() 
	{
		ArrayList<Contato> contatos = new ArrayList<>();
		
		String select = "select * from contatos_agenda order by Id";
		
		try 
		{
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(select);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) 
			{
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new Contato(id, nome, fone, email));
			}
			conexao.close();
			return contatos;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionarContato(Contato contato) 
	{
		String select1 = "select * from contatos_agenda where Id = ?";
		try 
		{
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(select1);
			
			pst.setString(1, contato.getId());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) 
			{
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			conexao.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void editarContato(Contato contato)
	{
		String update = "update contatos_agenda set Nome=?,Telefone=?,Email=? where Id=?";
		
		System.out.println("Informacoes a serem editadas:\n"+"Id->"+contato.getId()+"\nNome->"+contato.getNome()+"\nTelefone->"+contato.getFone()+"\nEmail->"+contato.getEmail());
		
		try 
		{
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(update);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			
			pst.executeUpdate();
			conexao.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void deletarContato(Contato contato) 
	{
		String delete = "delete from contatos_agenda where Id=?";
		
		System.out.println("Informacoes para o delete:\n"+"Id->"+contato.getId()+"\nNome->"+contato.getNome()+"\nTelefone->"+contato.getFone()+"\nEmail->"+contato.getEmail());

		try 
		{
			Connection conexao = conectar();
			PreparedStatement pst = conexao.prepareStatement(delete);
			
			pst.setString(1, contato.getId());
			
			pst.executeUpdate();
			conexao.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
