package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();   // 요청 url
        ControllerV3 controller = controllerMap.get(url); // 요청 url에 맞는 컨트롤러
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);   // 없을 경우 404
            return;
        }

        Map<String, String> paramMap = createParamMap(request); // request param을 map으로 변경
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); // 논리 이름
        MyView view = viewResolver(viewName);   // 논리 이름을 구체이름으로 변환(resolving)
        view.render(mv.getModel(), request, response);     // 렌더링
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> viewMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName ->
                        viewMap.put(paramName, request.getParameter(paramName)));
        return viewMap;
    }
}
