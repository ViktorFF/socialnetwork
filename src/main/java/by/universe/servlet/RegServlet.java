package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        req.setAttribute("regError", false);
        req.setAttribute("regLoginError", false);

        if (firstName.equals("") || login.equals("") || password.equals("")) {
            req.setAttribute("regError", true);
            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        }


        Map<String, User> userMap = (Map<String, User>) req.getServletContext().getAttribute("userMap");
        for (String key: userMap.keySet()) {
            if (key.equals(login)) {
                req.setAttribute("regLoginError", true);
                req.getRequestDispatcher("/reg.jsp").forward(req, resp);
            }
        }
        if (!(boolean)req.getAttribute("regLoginError")){
            User newUser = new User(firstName, "", "", "", "", login, password);
            userMap.put(newUser.getLogin(), newUser);
            resp.sendRedirect("/index.jsp");
        }
    }
}
