package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("currentUserId", currentUser.getId());
        req.getSession().setAttribute("currentUserRole", currentUser.getRole());

        if (currentUser.getLastName() == null) {
            req.getSession().setAttribute("currentUserLastName", "");
        } else {
            req.getSession().setAttribute("currentUserLastName", currentUser.getLastName());
        }

        if (currentUser.getLastName() == null) {
            req.getSession().setAttribute("currentUserBirthday", "");
        } else {
            req.getSession().setAttribute("currentUserBirthday", currentUser.getBirthday());
        }

        if (currentUser.getLastName() == null) {
            req.getSession().setAttribute("currentUserCountry", "");
        } else {
            req.getSession().setAttribute("currentUserCountry", currentUser.getCountry());
        }

        if (currentUser.getLastName() == null) {
            req.getSession().setAttribute("currentUserCity", "");
        } else {
            req.getSession().setAttribute("currentUserCity", currentUser.getCity());
        }
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/profile.jsp");
    }
}
