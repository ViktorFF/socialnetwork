package by.universe.servlet;

import by.universe.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class FieldChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fieldChange = req.getParameter("fieldChange");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("fieldChange", fieldChange);
        req.setAttribute("birthdayFlag", false);
        switch (fieldChange) {
            case "firstName":
                req.getSession().setAttribute("oldValue", currentUser.getFirstName());
                break;
            case "lastName":
                req.getSession().setAttribute("oldValue", currentUser.getLastName());
                break;
            case "birthday":
                req.getSession().setAttribute("oldValue", currentUser.getBirthday());
                req.setAttribute("birthdayFlag", true);
                break;
            case "country":
                req.getSession().setAttribute("oldValue", currentUser.getCountry());
                break;
            case "city":
                req.getSession().setAttribute("oldValue", currentUser.getCity());
                break;
            case "login":
                req.getSession().setAttribute("oldValue", currentUser.getLogin());
                break;
            case "password":
                req.getSession().setAttribute("oldValue", currentUser.getPassword());
                break;
        }
        req.getServletContext().getRequestDispatcher("/fieldChange.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fieldChange = (String) req.getSession().getAttribute("fieldChange");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        switch (fieldChange) {
            case "firstName":
                currentUser.setFirstName(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserFirstName", currentUser.getFirstName());
                break;
            case "lastName":
                currentUser.setLastName(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserLastName", currentUser.getLastName());
                break;
            case "birthday":
                currentUser.setBirthday(req.getParameter("date") + " " + req.getParameter("month") +
                        " " + req.getParameter("year"));
                req.getSession().setAttribute("currentUserBirthday", currentUser.getBirthday());
                break;
            case "country":
                currentUser.setCountry(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserCountry", currentUser.getCountry());
                break;
            case "city":
                currentUser.setCity(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserCity", currentUser.getCity());
                break;
            case "login":
                currentUser.setLogin(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserLogin", currentUser.getLogin());
                break;
            case "password":
                currentUser.setPassword(req.getParameter("newValue"));
                req.getSession().setAttribute("currentUserPassword", currentUser.getPassword());
                break;
        }
        resp.sendRedirect("/profile.jsp");
    }
}
