package com.exercise.reactive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveApplicationTests {
    @Autowired
    Demo demo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() throws InterruptedException {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        StepVerifier.create(flux)
                .expectNext(1, 2, 3, 4, 5, 6)
                .expectComplete()
                .verify();


        StepVerifier.create(Flux.just("hello", "flux")
                .flatMap(s -> Flux.fromArray(s.split("")))
        .delayElements(Duration.ofMillis(1))
        .doOnNext(System.out::println)
        )
                .expectNextCount(9)
                .verifyComplete();


        CountDownLatch countDownLatch=new CountDownLatch(1);
        Flux.fromArray("hello flux i will over ride you".split(" "))
                .zipWith(Flux.interval(Duration.ofMillis(200)))
                .subscribe(t->System.out.println(t.getT2()+": " +t.getT1())
                ,null,() ->countDownLatch.countDown());
        countDownLatch.await(10, TimeUnit.SECONDS);

    }


}
