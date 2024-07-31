package com.vssekorin.viridez.web.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tech")
class TechController {

    @GetMapping("/status/")
    fun status(): ResponseEntity<String> = ResponseEntity.ok("ok")

    @GetMapping("/thread/")
    fun thread(): ResponseEntity<String> = ResponseEntity.ok(Thread.currentThread().toString())
}
