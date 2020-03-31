package com.exercise.reactive.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.netty.http.server.HttpServerRequest
import javax.servlet.http.HttpServletRequest

/**
 *  Created by linc on 2020/2/26.
 */
@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(request:HttpServletRequest):String{
        return "hello"
    }
}