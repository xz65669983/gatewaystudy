package com.example.zzc.demo123;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("getname")
    public String getname() {

        System.out.println("zzc他来了~");
        return "zzc";
    }
}
