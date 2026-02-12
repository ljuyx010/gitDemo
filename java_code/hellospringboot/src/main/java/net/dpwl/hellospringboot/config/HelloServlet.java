package net.dpwl.hellospringboot.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/11 10:50
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
//@WebFilter
//@WebListener
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.getWriter().write("hello servlet");
    }
}
