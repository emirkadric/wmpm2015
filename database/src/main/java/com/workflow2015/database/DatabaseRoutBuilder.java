package com.workflow2015.database;

import com.workflow2015.database.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

/**
 * Created by Dominik Heigl on 6/11/15.
 */
@Component
public class DatabaseRoutBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("restlet:http://localhost:" + 49081 + "/user?restletMethod=put")
                .unmarshal().json(JsonLibrary.Gson, User.class)
                .to("jpa:User");
    }
}
