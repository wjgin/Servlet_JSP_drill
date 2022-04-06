package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Component
 * @RequestMapping
 * spring의 RequestHandlerAdapter는 spring Bean으로 등록되어있는 것 중 class 레벨에 @Controller 혹은 @RequestMapping 중에 존재하는지 확인한다.
 * @Controller가 두 annotation의 사용을 포괄 할 수 있기에 @Controller만 사용하는 방식을 쓴다.
 */


@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
