package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {} , age = {}", username, age);

        response.getWriter().write("yes");
    }

    @ResponseBody // View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String username , // == request.getParameter("username") 과 똑같은 기능을 한다.
            @RequestParam("age") int memberAge) {

        log.info("username = {} , age = {}", username, memberAge);
        return "ok";
    }

    @ResponseBody // View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username , // == request.getParameter("username") 과 똑같은 기능을 한다.
            @RequestParam int age) {

        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @ResponseBody // View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username , int age) {  // @RequestParam을 생략 가능하다 , 하지만 생략은 많이 하지 않는다.
        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username ,
            @RequestParam(required = false) Integer age) { // Integer에는 null의 값이 들어갈 수 있으므로 , required = false로 하려면 int -> Integer로 변환

        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true , defaultValue = "guest") String username ,
            @RequestParam(required = false , defaultValue = "-1") int age) {

        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam MultiValueMap<String , Object> paramMap) {
        log.info("username = {} , age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);

        log.info("username = {} , age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}" , helloData);


        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2( HelloData helloData) { // @ModelAttribute도 생략 가능하다.
        log.info("username = {} , age = {}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}" , helloData);
        return "ok";
    }
}
