package by.universe.servlet;

import by.universe.entity.User;
import by.universe.entity.messages.Comment;
import by.universe.entity.messages.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if ((boolean) req.getSession().getAttribute("currentUserFlag")) {
            user = (User) req.getSession().getAttribute("currentUser");
        } else {
            user = (User) req.getSession().getAttribute("user");
        }

        if (req.getParameter("post") != null && req.getParameter("post").equals("post")) {
            user.getPosts().add(new Post(currentUser.getFirstName() + " " + currentUser.getLastName(),
                    req.getParameter("postText"), LocalDateTime.now().toString()));
            resp.sendRedirect("/user.jsp");
        }

        for (Post post: currentUser.getPosts()) {
            if (req.getParameter("delete") != null && post.getId() == Integer.parseInt(req.getParameter("delete"))) {
                user.getPosts().remove(post);
                resp.sendRedirect("/user.jsp");
            }
        }

        for (Post post: user.getPosts()) {
            if (req.getParameter("comment") != null && post.getId() == Integer.parseInt(req.getParameter("comment"))) {
                post.getComments().add(new Comment(currentUser.getFirstName() + " " + currentUser.getLastName(),
                        req.getParameter("commentText"), LocalDateTime.now().toString()));
                resp.sendRedirect("/user.jsp");
            }
        }
    }
}
