package dev.quilla.springmvcboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {

        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request, @RequestParam("num1") int num1, @RequestParam("num2") int num2) {

        int result = num1 + num2;

        HttpSession session = request.getSession();
        session.setAttribute("result", result);

        return "result.jsp";
    }
}
