package hello.springmvc.response;

import hello.springmvc.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
// 주로 @ResponseBody를 함께 같이 사용하므로 @RestController 를 자주씀
public class ResponseBodyController {

    @RequestMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    // ResponseEntity 리턴
    @RequestMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);   // (message, HttpStatus code)
    }

    @ResponseBody
    @RequestMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    // @ResponseBody 사용시 상태 코드를 넣지 못하는 것을 해결 -> 정적인 상태코드 -> 동적인 코드가 필요할 시 ResponseEntity 사용
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/response-body-json-v2")
    public HelloData responseJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello");
        helloData.setAge(20);
        return helloData;
    }
}
