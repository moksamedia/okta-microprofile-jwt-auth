package com.okta.microprofile.DemoAPI;

import javax.inject.Singleton;
import javax.ws.rs.*;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }
}
