package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().setAttribute("currentUserFlag", false);

        if (user.equals(req.getSession().getAttribute("currentUser"))) {
            user = (User) req.getSession().getAttribute("currentUser");
            req.getSession().setAttribute("currentUserFlag", true);
        }

        req.getSession().setAttribute("userFirstName", user.getFirstName());
        req.getSession().setAttribute("userLastName", user.getLastName());
        req.getSession().setAttribute("userBirthday", user.getBirthday());
        req.getSession().setAttribute("userCountry", user.getCountry());
        req.getSession().setAttribute("userCity", user.getCity());
        req.getSession().setAttribute("userPosts", user.getPosts());
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
