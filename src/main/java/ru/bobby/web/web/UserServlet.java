package ru.bobby.web.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("userList.jsp");

        LOG.trace("trace redirect");
        LOG.debug("debug redirect");
        LOG.info("info redirect");
        LOG.warn("warn redirect");
        LOG.error("error redirect");
    }
}
