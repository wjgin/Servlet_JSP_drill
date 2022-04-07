package hello.springmvc.basic;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestAPI를 작성할 때, 사용, HTTP message body에 return 을 그대로 반영, @Controller는 view 이름으로 return
@RestController
// @Slf4j lombok의 logger 생성 annotation
public class LogTestController {

    private final  Logger log = LoggerFactory.getLogger(getClass());   // getClass == LogTestController.class (현재 클래스)

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring";

        // logger level을 지정할 수 있음. 위로 갈 수록 높은 심각도
        // boot 설정으로 특정 level의 하위 부분만 확인할 수 있음.
        log.trace(" trace log = " + name); // 스타일은 출력되지 않는 로그여도 미리 문자열 연산이 일어나 리소스에 영향을 미치므로 사용하지 않음
        log.trace(" trace log = {}", name);
        log.debug(" debug log = {}", name);
        log.info(" info log = {}", name);
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);

        return "ok";    //@RestController 로 인해서 view name이 아닌 message body의 데이터
    }

}
