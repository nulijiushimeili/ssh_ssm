package filter;


import org.hibernate.Session;
import util.HibernateUtil;

import javax.servlet.*;
import java.io.IOException;


//@WebFilter(urlPattern = "/*")
public class OpenSessionInViewFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();

            chain.doFilter(req,resp);



        }catch(Exception e){
            e.printStackTrace();
        }finally{
            HibernateUtil.close(session);
        }

    }

    @Override
    public void destroy() {

    }
}
