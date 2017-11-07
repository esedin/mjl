package com.yard42;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ping")
public class PingResource
{
    @GET
    public String ping()
    {
        return "Java EE 8 works!";
    }
}
