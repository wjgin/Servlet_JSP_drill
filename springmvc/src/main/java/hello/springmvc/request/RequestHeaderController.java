package hello.springmvc.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
@Slf4j
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String header(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpMethod method,
            Locale locale,
            @RequestHeader MultiValueMap<String, String> multiValueMap,
            @RequestHeader("host") String host,
            @CookieValue(value = "myCookie", required = false) String cookie
    ) {
        log.info("request = {}", request);
        log.info("response = {}", response);
        log.info("HttpMethod = {}", method);
        log.info("Locale = {}", locale);
        log.info("MultiValueMap = {}", multiValueMap);
        log.info("Host ={}", host);
        log.info("Cookie = {}", cookie);

        return "ok";
    }
}
