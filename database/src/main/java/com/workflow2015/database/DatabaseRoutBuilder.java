package com.workflow2015.database;

import com.workflow2015.database.model.User;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        from("file:./?fileName=users.csv&noop=true")
                .unmarshal().csv().
                process(exchange -> {
                    @SuppressWarnings("unchecked")
                    List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
                    List<User> users = new ArrayList<>();
                    for (List<String> line : data) {
                        User user = new User();
                        user.setFirstname(line.get(0).trim());
                        user.setLastname(line.get(1).trim());
                        user.setEmail(line.get(2).trim());
                        user.setSubscribed(Boolean.getBoolean(line.get(3).trim()));
                        users.add(user);
                    }
                    exchange.getIn().setBody(users, List.class);
                })
                .to("jpa:User");
    }
}
