package hello.springmvc.requestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody   // return 값을 HTTP message body에 넣어줌 -> @Controller에 의해서 view를 찾지 않음
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            // parameter name과 변수명이 같다면 (name="parameter") 생략 가능
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    // String, int, Interger 같은 단순 타입의 parameter 이름과 변수명이 같다면 @RequestParam 생략 가능
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 파라미터의 필수 값 지정
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired
            (
             @RequestParam(required = true) String username,    // 기본 값: True -> 파라미터로 들어오지 않으면 400 오류
             @RequestParam(required = false) Integer age    //  false 설정 시 파라미터값이 들어오지 않을 수 있음 -> null -> 기본형 (primitive) int x Integer o
            ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault
            (
                    // 값이 없을 경우, defaultValue를 사용, -> required가 필요치 않음
                    // 주의: null과 빈 문자열 ""은 다르지만, defaultValue 는 둘 다 처리해줌 (null 과 "" 모두 defaultValue 로 치환)
                    @RequestParam(required = true, defaultValue = "guest") String username,
                    @RequestParam(required = false, defaultValue = "-1") int age
            ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    // 동일한 이름의 parameter가 들어온다면, @MultiValueMap을 사용할 수 있다. -> 특별한 경우가 아니면 잘 사용하지 않는다.
    public String requestParamMap (@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
