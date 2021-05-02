package com.ms.api.root.msapicore.tableinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Welcome {

    @Autowired
    TableInfoRepository tableInfoRepository;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String greeting(HttpServletRequest request) {
        //test change2
        return "Hi! i am up at host/port : "+ request.getRequestURL().toString();
    }


}
