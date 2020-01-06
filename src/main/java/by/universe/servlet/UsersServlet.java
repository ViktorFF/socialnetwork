package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, User> userMap =(Map<String, User>) req.getServletContext().getAttribute("userMap");
        req.getServletContext().setAttribute("users", userMap.values());
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, User> userMap = (Map<String, User>) req.getServletContext().getAttribute("userMap");
        req.getSession().setAttribute("user", userMap.get(req.getParameter("user")));
        resp.sendRedirect("/user");
    }
}
