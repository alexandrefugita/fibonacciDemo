package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests(@Autowired val restTemplate: TestRestTemplate) {

	@Test
	fun assertRegularValue() {
		val entity = restTemplate.getForEntity<String>("/fibonacci?n=1")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains("\"value\":1")
	}

	@Test
	fun assertNegativeValue() {
		val entity = restTemplate.getForEntity<String>("/fibonacci?n=-1")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains("\"status\":\"ERROR_INVALID_INPUT\"")
	}

	@Test
	fun assertMaximumValue() {
		val entity = restTemplate.getForEntity<String>("/fibonacci?n=79")
		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains("\"status\":\"ERROR_MAXIMUM_VALUE_EXCEEDED\"")
	}
}
