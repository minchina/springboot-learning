package org.ncmao;

import org.junit.Test;
import org.ncmao.domain.Singleton;

public class SingletonTest {

    @Test
    public void canOnlyGetOneInstance(){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
