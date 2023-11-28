package io.hyun.backend.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getMethod().equals("POST") || req.getMethod().equals("PUT") || req.getMethod().equals("DELETE")){
            System.out.println("POST요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);
            System.out.println("filter1");

            if(headerAuth.equals("hello")){
                chain.doFilter(req, res);
            }else{
                PrintWriter out = res.getWriter();
                out.println("No access");
            }
        } else if (req.getMethod().equals("GET")) {
            System.out.println("GET 요청됨");
            chain.doFilter(req, res);
        }




    }
}
