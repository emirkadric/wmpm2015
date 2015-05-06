package com.workflow2015.common.test.impl;

import com.workflow2015.service.impl.ServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Created by Dominik Heigl on 5/6/15.
 */
@Service
public class DepTest implements CommandLineRunner {
    private final ServiceApplication serviceApplication;

    @Autowired
    public DepTest(ServiceApplication serviceApplication) {
        this.serviceApplication = serviceApplication;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.serviceApplication.test();
    }
}
