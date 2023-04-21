package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/web")
@RequiredArgsConstructor
public class WebController {
    private final WebService webService;

    @GetMapping("/checkIpv6Support")
    public Boolean checkIpv6Support(@RequestParam(value = "siteAddress") String siteAddress){
        return webService.checkIpv6(siteAddress);
    }
}
