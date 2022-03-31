package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);  // 200을 직접 적는 것보다

        // [response-header] 없는 정보는 tomcat이 자동 생성
        response.setHeader("Content-type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효
        response.setHeader("Pragma", "no-cache");
        response.setHeader("My-header", "hello");   // 직접 임의의 헤더 생성

        PrintWriter writer = response.getWriter();
        // [response-header 편의 메서드]
        // content(response);
        cookie(response);
        writer.println("ok");

        redirect(response); // 리다이렉트

    }

    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response){
        // 헤더에 직접 작성도 가능
        // response.setHeader("Set-Cookie", "myCookie=good;Max-Age=600");
        Cookie cookie = new Cookie("MyCookie", "good");
        cookie.setMaxAge(600);  // 600초
        response.addCookie(cookie);
    }


    // 리다이렉트하기
    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code: 302
        // Location: /basic/hello-form.html
        // response.setStatus(HttpServletResponse.SC_FOUND);   // 302
        // response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
