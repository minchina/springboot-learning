package org.ncmao;

import io.reactivex.Observable;
import org.junit.Test;

public class RxJavaTest {


    @Test
    public void test(){
        Observable.just("first", "second", "third")
                .subscribe(s -> System.out.println(s));

    }}
