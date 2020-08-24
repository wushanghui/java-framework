package top.wushanghui.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wsh
 * @date 2020-08-24 16:17
 */
public class ReactorDemo {

    public static void main(String[] args) {
        //just 方法直接声明
        Flux.just(1,2,3,4).subscribe(System.out::print);
        System.out.println();
        Mono.just(1).subscribe(System.out::print);
        System.out.println();
        //其他的方法
        Integer[] array = {1,2,3,4};
        Flux<Integer> arrayFlux = Flux.fromArray(array);
        arrayFlux.subscribe(System.out::print);
        System.out.println();
        List<Integer> list = Arrays.asList(array);
        Flux<Integer> listFlux = Flux.fromIterable(list);
        listFlux.subscribe(System.out::print);
        System.out.println();
        Stream<Integer> stream = list.stream();
        Flux<Integer> streamFlux = Flux.fromStream(stream);
        streamFlux.subscribe(System.out::print);
    }
}
