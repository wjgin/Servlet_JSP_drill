package hello.servlet.web.frontController.v1;

import hello.servlet.web.frontController.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontController.v1.controller.MemberListController;
import hello.servlet.web.frontController.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    Map<String, ControllerV1> controllerMap = new HashMap<>();


    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();   // 요청 url
        ControllerV1 controllerV1 = controllerMap.get(url); // 요청 url에 맞는 컨트롤러
        if (controllerV1 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);   // 없을 경우 404
            return;
        }
        controllerV1.process(request, response);    // 컨트롤러의 로직 실행



    }
}
