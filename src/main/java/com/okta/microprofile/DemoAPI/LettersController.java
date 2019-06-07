package com.okta.microprofile.DemoAPI;

import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/letters")
@Singleton
public class LettersController {

    private ArrayList<String> letters = new ArrayList<String>(Arrays.asList("A", "B", "C"));

    @GET
    @Produces("text/plain")
    public String letters() {
        return String.join(", ", letters);
    }

    @POST
    @RolesAllowed({"Everyone"})
    @Consumes("text/plain")
    public String addLetter(String newLetter) {
        String trimmed = newLetter.trim();
        this.letters.add(trimmed);
        return "Letter '" + trimmed + "' added!";
    }

}
