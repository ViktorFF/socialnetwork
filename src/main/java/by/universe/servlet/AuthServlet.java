package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User currentUser = new User(login, password);
        for (User user : (List<User>) getServletContext().getAttribute("userList")) {
            if (user.equals(currentUser) && user.getPassword().equals(currentUser.getPassword())) {
                req.getSession().setAttribute("currentUser", user);
                req.getSession().setAttribute("currentUserFirstName", user.getFirstName());
                req.getSession().setAttribute("currentUserLogin", user.getLogin());
                req.getSession().setAttribute("currentUserPassword", user.getPassword());
                req.getRequestDispatcher("/mainPage.jsp").forward(req, resp);
            }
        }
        resp.sendRedirect("/auth.jsp");
    }
}
