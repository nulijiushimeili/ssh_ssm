package springMVC.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:        nulijiushimeili
 * DateTime:      2018-08-25 15:39
 * Description:
 */
public class HelloController extends AbstractController {
    protected ModelAndView handleRequestInternal(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("hello spring mvc ... ");
        return null;
    }
}
