package ru.bobby.bio.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.bobby.bio.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by bobby on 03.05.2015.
 */
public class UserServlet extends HttpServlet {

    static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    private WebApplicationContext wac;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("redirect to userList");

        UserService userService = wac.getBean(UserService.class);
        req.setAttribute("userList", userService.getAll());
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);

    }
}
