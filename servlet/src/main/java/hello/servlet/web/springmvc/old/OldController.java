package hello.servlet.web.springmvc.old;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldControllerRequest");

        // 논리 이름만 넣어서 리턴, 스프링 부트 설정으로 물리 이름으로 resolving
        // 직접 Bean으로 설정 해준 resolver가 우선 설정되지만, spring boot 설정으로 대체해서 사용한다.
        return new ModelAndView("new-form");
    }
}
