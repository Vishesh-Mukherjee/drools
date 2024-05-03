package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cat;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/automatic")
    public void automaticRun(@RequestBody Cat cat) {
        demoService.process(cat);
    }

    @PostMapping("/manual")
    public void manualRun() {
        Cat cat = new Cat("foo", "bar");
        demoService.process(cat);
    }

}
