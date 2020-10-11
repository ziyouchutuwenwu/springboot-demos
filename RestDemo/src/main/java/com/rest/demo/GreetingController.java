package com.rest.demo;

import com.rest.demo.except.CustomException01;
import com.rest.demo.except.CustomException02;
import com.rest.demo.response.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
     * curl "http://127.0.0.1:8080/greeting"
     */
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @RequestHeader HttpHeaders headers) {

        System.out.println(headers.get("User-Agent"));
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, name)
        );
    }

    /*
     * curl -d "name=aaa" -D - "http://127.0.0.1:8080/custom_header"
     */
    @RequestMapping(value = "/custom_header", method = RequestMethod.POST)
    public ResponseEntity<Greeting> greeting4(@RequestParam(value="name", defaultValue="World") String name) {

        Greeting greeting= new Greeting(counter.incrementAndGet(), String.format("Hello, %s!", name));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        return new ResponseEntity<>(greeting, responseHeaders, HttpStatus.OK);
    }

    /*
     * curl http://127.0.0.1:8080/only_post
     */
    @RequestMapping(value = "/only_post", method = RequestMethod.POST)
    public Greeting greeting1(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    /*
    * curl "http://127.0.0.1:8080/except1?raiseEx=true"
    * */
    @RequestMapping(value = "/except1")
    public BaseResponse exception1(@RequestParam(value="name", defaultValue="World") String name,
                                  @RequestParam(value="raiseEx", defaultValue="false") Boolean raiseEx) {
        if ( raiseEx ) {
            throw new CustomException01();
        }
        return BaseResponse.success("", new Greeting(1L, String.format("Hello, %s! This is greeting1", name)));
    }

    /*
    * curl "http://127.0.0.1:8080/except2?raiseEx=false"
    * */
    @RequestMapping(value = "/except2")
    public BaseResponse exception2(@RequestParam(value="name", defaultValue="World") String name,
                                  @RequestParam(value="raiseEx", defaultValue="false") Boolean raiseEx) {
        if ( raiseEx ) {
            throw new CustomException02();
        }
        return BaseResponse.success("", new Greeting(2L, String.format("Hello, %s! This is greeting2", name)));
    }

    /*
     * curl --header "Content-Type: application/json" -d '{"msg": "World"}' http://127.0.0.1:8080/body_json_post
     * curl --header "Content-Type: application/json" -d '{"msg": ""}' http://127.0.0.1:8080/body_json_post
     */
    @RequestMapping(value = "/body_json_post")
    public BaseResponse body_json_post(@Valid @RequestBody GreetingBodyRequest request) {
        return BaseResponse.success("", new GreetingResponse(counter.incrementAndGet(), String.format(template, request.getMsg())));
    }
}