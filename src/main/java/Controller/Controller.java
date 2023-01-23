package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Controller","/Adicionar","/Home","/Listar","/salvarContato","/Remover", "/Editar", "/Edita"})
public class Controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	Contato contato = new Contato();
    Banco banco = new Banco();
	
    public Controller() 
    {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		
		if(action.equals("/Adicionar"))
		{
			Adicionar(request, response);
		}
		else
		{
			if(action.equals("/salvarContato"))
			{
				salvarContato(request, response);
			}
			
			else if(action.equals("/Home"))
			{
				Home(request, response);
				return;
			}
			
			else if(action.equals("/Listar"))
			{
				contato(request,response);
				Listar(request, response);
			}
			
			else if(action.equals("/Remover"))
			{
				dadosContatoRemover(request,response);
				Remover(request,response);
			}
			
			else if(action.equals("/Editar"))
			{				
				dadosEditarContato(request, response);
				editarContato(request, response);
			}
			
			else if(action.equals("/Edita"))
			{			
				editarContato2(request, response);
			}
		
			else
			{
				response.sendRedirect(action);
			}
		}
	}
	
	protected void contato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Contato> lista = banco.listarContatos();
		request.setAttribute("contato", lista);
	}
	
	protected void Adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("Adicionar.jsp");
	}
	
	protected void salvarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Contato contato = new Contato();
		
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		banco.salvarNovoContato(contato);
		
		response.sendRedirect("Home.jsp");
	}
	
	protected void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("Home.jsp");
	}
	
	protected void Listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		banco.selecionarContato(contato);
		request.setAttribute("Id", contato.getId());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("Lista.jsp");
		rd.forward(request, response);
	}

	protected void dadosContatoRemover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		contato.setId(request.getParameter("Id"));
		banco.selecionarContato(contato);
		request.setAttribute("Id", contato.getId());
	}
	
	protected void Remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		contato.setId(request.getParameter("Id"));
		banco.deletarContato(contato);
		response.sendRedirect("Listar");
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);
		return;
	}
	
	protected void editarContato2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		contato.setId(request.getParameter("Id"));
		contato.setNome(request.getParameter("Nome"));
		contato.setFone(request.getParameter("Telefone"));
		contato.setEmail(request.getParameter("Email"));
		banco.editarContato(contato);
		RequestDispatcher rd = request.getRequestDispatcher("Listar");
		rd.forward(request, response);
		
	}

	protected void dadosEditarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		contato.setId(request.getParameter("Id"));
		banco.selecionarContato(contato);
		request.setAttribute("Id", contato.getId());
		request.setAttribute("Nome", contato.getNome());
		request.setAttribute("Telefone", contato.getFone());
		request.setAttribute("Email", contato.getEmail());
	}
}
