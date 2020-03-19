package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class FibonacciController {

    val counter = AtomicLong()

    @GetMapping("/fibonacci")
    // max Long value with 100% accuracy: 78
    fun fibonacci(@RequestParam(value = "n", defaultValue = "0") n: Int): FibonacciResponse {
        if (n < 0) {
            return FibonacciResponse(counter.incrementAndGet(), FibonacciResponseStatus.ERROR_INVALID_INPUT, 0)
        }

        if (n > 78) {
            return FibonacciResponse(counter.incrementAndGet(), FibonacciResponseStatus.ERROR_MAXIMUM_VALUE_EXCEEDED, 0)
        }

        return FibonacciResponse(counter.incrementAndGet(), FibonacciResponseStatus.OK, calculateFibonacci(n))
    }

    private fun calculateFibonacci(n: Int): Long {
        if (n < 2) {
            return n.toLong()
        }

        var prev1 = 0L
        var prev2 = 1L

        for (i in 1 until n - 1) {
            var aux = prev2
            prev2 += prev1
            prev1 = aux
        }

        return prev1 + prev2
    } // time: O(n), space: O(1)
}