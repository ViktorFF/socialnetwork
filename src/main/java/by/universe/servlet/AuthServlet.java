package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        Map<String, User> userMap = (Map<String, User>) req.getServletContext().getAttribute("userMap");
        if (userMap.containsKey(login)) {
            if (password.equals(userMap.get(login).getPassword())) {
                User currentUser = userMap.get(login);
                req.getSession().setAttribute("currentUser", currentUser);
                req.getSession().setAttribute("currentUserId", currentUser.getId());
                req.getSession().setAttribute("currentUserRole", currentUser.getRole());
                req.getSession().setAttribute("currentUserFirstName", currentUser.getFirstName());
                req.getSession().setAttribute("currentUserLastName", currentUser.getLastName());
                req.getSession().setAttribute("currentUserBirthday", currentUser.getBirthday());
                req.getSession().setAttribute("currentUserCountry", currentUser.getCountry());
                req.getSession().setAttribute("currentUserCity", currentUser.getCity());
                req.getSession().setAttribute("currentUserLogin", currentUser.getLogin());
                req.getSession().setAttribute("currentUserPassword", currentUser.getPassword());
                resp.sendRedirect("/mainPage.jsp");
            } else {
                req.setAttribute("passwordError", true);
                req.getRequestDispatcher("/auth.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("loginError", true);
            req.getRequestDispatcher("/auth.jsp").forward(req, resp);
        }
    }
}
