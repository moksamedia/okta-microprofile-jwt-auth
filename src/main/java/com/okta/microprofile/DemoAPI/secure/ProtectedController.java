package com.okta.microprofile.DemoAPI.secure;

import org.eclipse.microprofile.jwt.Claim;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

/**
 *
 */
@Path("/protected")
@RequestScoped
public class ProtectedController {

    @Inject
    @Claim("groups")
    private Set<String> groups;

    @Inject
    @Claim("sub")
    private String subject;

    @GET
    @RolesAllowed({"Admin", "Everyone"})
    public String getJWTBasedValue() {
        return this.subject + ": " + this.groups.toString();
    }
    
}
                            