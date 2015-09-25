package progIV.forum.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import prog4.forum.models.Usuario;
import prog4.forum.models.UsuarioManager;
import prog4.forum.models.UsuarioManagerImpl;

/**
 *
 * @author Manu
 */
@WebServlet(name = "ValidacaoUsuario", urlPatterns = {"/usuario/cadastro"})
public class ValidacaoUsuario extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastroUsuario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("senha"));
        
        UsuarioManager manager;
        manager = new UsuarioManagerImpl();
        manager.cadastrar(usuario);
    }

    

}
