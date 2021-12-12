package com.restapicall.controller;

import com.restapicall.model.UserInfo;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloRestController {

    /**
     * purpose : Worn the request mapping is done then all the statements  of sayHello gets executed
     */
    @RequestMapping(value="/hello")
    public String sayHello(){
        return "Hello Form BridgeLabz";
    }

    /**
     * @RequestParam : Mapping HTTP GET Request onto specific Handler Methods.
     *                 When mapping is done all statements of  sayHello method get executed
     *  curl : localhost:8080/getMessage?name=Ashish
     */
    @GetMapping(value="/getMessage")
    public String sayHello(@RequestParam(value = "name" )String name){
        return "Hello " + name + "Welcome To BridgeLabz";
    }

    /**
     * UC:3
     * Purpose : Use GET Request Method and pass name as path variable
     * @param name
     * @return
     * localhost:8080/param/Ashish%20Sahu
     */
    @GetMapping(value= "/param/{name}")
    public String sayHelloParam(@PathVariable String name){

        return "Hello " + name + " Welcome To BridgeLabz";
    }

    /**
     * UC: 4
     * @PostMapping : this annotation handle the post type of annotation
     * @RequestBody : is used to convert the body of HTTP request to java class object
     *http://localhost:8080/post?Content-type=json : URL request through POSTMAN
     * JSON:{
     *          "firstName":"Ashish",
     *          "lastName" : "Sahu"
     *
     *      }
     * O/P ; Hello Ashish Sahu Welcome To BeidgeLabz
     */
    @PostMapping("/post")
    public String sayHelloPost(@RequestBody UserInfo userInfo ){
        return "Hello " + userInfo.getFirstName() +" "+userInfo.getLastName() + " Welcome To BeidgeLabz";

    }

}
