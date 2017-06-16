package org.ncmao.domain;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public static synchronized Singleton getInstance(){
        if (singleton == null) {
            return new Singleton();
        }
        return singleton;
    }
}

//public class Singleton {
//    private static final Singleton singleton = new Singleton();
//
//    private Singleton() {
//
//    }
//    public static Singleton getInstance(){
//        return singleton;
//    }
//}

//public class Singleton {
//    private Singleton() {
//
//    }
//
//    private static class  SingletonFactory {
//        private static final Singleton singleton= new Singleton();
//    }
//    public static synchronized Singleton getInstance(){
//        return SingletonFactory.singleton;
//    }
//}

