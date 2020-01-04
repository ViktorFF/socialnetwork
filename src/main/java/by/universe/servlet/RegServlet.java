package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (firstName.equals("") || login.equals("") || password.equals("")) {
            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        }

        User newUser = new User(firstName, login, password);
        List<User> userList = (List<User>) req.getServletContext().getAttribute("userList");
        for (User user: userList) {
            if (user.equals(newUser)) {
                req.getRequestDispatcher("/reg.jsp").forward(req, resp);
            }
        }
        userList.add(newUser);
        resp.sendRedirect("/index.jsp");
    }
}
