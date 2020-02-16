package com.exercise.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by linc on 2019/5/14.
 */
@Service
public class Demo {

    public void demo1(){
        Flux<Integer> flux=Flux.just(1,2,3,4,6);
        flux.subscribe(System.out::print,System.out::print,()->System.out.println("hello completed"));
    }
}
