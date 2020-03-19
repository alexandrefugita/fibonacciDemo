package com.example.demo

enum class FibonacciResponseStatus { OK, ERROR }

data class FibonacciResponse(val id: Long, val status:FibonacciResponseStatus, val value: Long) {
}