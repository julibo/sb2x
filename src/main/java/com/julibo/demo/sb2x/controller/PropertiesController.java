package com.julibo.demo.sb2x.controller;

import com.julibo.demo.sb2x.config.MyProperties1;
import com.julibo.demo.sb2x.config.MyProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author carson
 * @date 2019-11-22
 */
@RestController
@RequestMapping("/properties")
public class PropertiesController {

    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties1 myProperties1;

    private final MyProperties2 myProperties2;

    @Autowired
    public PropertiesController(MyProperties1 myProperties1, MyProperties2 myProperties2) {
        this.myProperties1 = myProperties1;
        this.myProperties2 = myProperties2;
    }

    @GetMapping("/1")
    public MyProperties1 myProperties1() {
        log.info("=================================================================================================");
        log.info(myProperties1.toString());
        log.info("=================================================================================================");
        return myProperties1;
    }

    @GetMapping("/2")
    public MyProperties2 myProperties2() {
        log.info("=================================================================================================");
        log.info(myProperties2.toString());
        log.info("=================================================================================================");
        return myProperties2;
    }


}
