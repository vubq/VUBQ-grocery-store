package com.vubq.grocerystore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootForwardingController {

    @GetMapping("/")
    public String forwardToIndex() {
        return "forward:/index.html";
    }
}
