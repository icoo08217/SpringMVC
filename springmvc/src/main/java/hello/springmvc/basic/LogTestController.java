package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // Controller 와 차이점을 알자. rest 는 rest API 의 rest이다.
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass()); ---> @Slf4j 하나로 가능하다.

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name); // 이제는 이렇게 찍으면 안된다.

        // log를 찍을 때 Level을 설정할 수 있다.
        log.trace("trace log = {}" , name); // 로컬 서버
        log.debug("debug log = {}" , name); // 개발 서버
        log.info(" info log = {}", name); // 운영 서버
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);

        return "ok";
    }
}
