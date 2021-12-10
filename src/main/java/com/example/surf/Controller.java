package com.example.surf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
    @Autowired
    private Service surfService;
}
