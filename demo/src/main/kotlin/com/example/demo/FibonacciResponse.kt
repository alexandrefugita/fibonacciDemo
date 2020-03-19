package com.example.demo

enum class FibonacciResponseStatus { OK, ERROR_INVALID_INPUT, ERROR_MAXIMUM_VALUE_EXCEEDED }

data class FibonacciResponse(val id: Long, val status:FibonacciResponseStatus, val value: Long) {
}