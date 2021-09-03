package com.demo.sse;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class SseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseDemoApplication.class, args);
	}

	@GetMapping(value="/")
	public String hello() {
		return "Hello world!";
	}
	

	@GetMapping(value = "/timestamps", produces = { MediaType.TEXT_EVENT_STREAM_VALUE })
	public Flux<Stamp> getAppEventStream(@RequestParam(required=false, defaultValue = "3") int d) {
		return Mono.fromCallable(Stamp::now).delaySubscription(Duration.ofSeconds(d)).repeat();
	}

}
