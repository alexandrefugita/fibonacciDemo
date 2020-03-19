package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FibonacciController {

    @GetMapping("/fib")
    fun fibonacci(@RequestParam(value = "n", defaultValue = "0") n: Int): String {
        if (n < 2) {
            return n.toString()
        }

        var prev1 = 0
        var prev2 = 1

        for (i in 1 until n - 1) {
            var aux = prev2
            prev2 += prev1
            prev1 = aux
        }

        var result = prev1 + prev2

        println("chegou no fim")
        return result.toString()
    }
}