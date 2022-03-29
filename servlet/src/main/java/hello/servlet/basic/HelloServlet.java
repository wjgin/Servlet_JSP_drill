package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // servlet에서 쿼리 파라미터를 가져오기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // respone
        // header 정보
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // http 바디에 삽입
        response.getWriter().write("hello " + username);
    }
}
