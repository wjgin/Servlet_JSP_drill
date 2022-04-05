package hello.servlet.web.frontController.v4;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();   // 요청 url
        ControllerV4 controller = controllerMap.get(url); // 요청 url에 맞는 컨트롤러
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);   // 없을 경우 404
            return;
        }

        Map<String, String> paramMap = createParamMap(request); // request param을 map으로 변경
        Map<String, Object> model = new HashMap<>();    // model로 사용할 객체 추가

        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);   // 논리 이름을 구체이름으로 변환(resolving)
        view.render(model, request, response);     // 랜더링
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
