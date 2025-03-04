package org.example.aspects;

public aspect DummyAspect {

    pointcut callForDummyBean():
             call(* org.example.pojo.*.*());


 after() : callForDummyBean() {
        System.out.println("I am POJO aspect");
    }

}