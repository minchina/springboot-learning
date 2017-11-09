package org.ncmao;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxjavaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RxjavaTest.class);

    @Test
    public void shouldTest1() {
        Observable<String> observable = Observable.just("Hello", "World");

        Action1<String> onNextAction = LOGGER::info;
        Action1<Throwable> onErrorAction = throwable -> System.out.println(throwable.toString());
        Action0 onCompletedAction = () -> LOGGER.info("Done");
        observable.subscribe(onNextAction, onErrorAction);
//        observable.subscribe(createObserver());
    }

    private Observer<String> createObserver() {


        return new Observer<String>() {
            @Override
            public void onCompleted() {
                LOGGER.info("Done");
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.error(throwable.toString());
            }

            @Override
            public void onNext(String s) {
                LOGGER.info(s);
            }
        };
    }

}
