package org.example.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Ohlos {

    @Pointcut("execution(* org.example.pojo.*.*())")
    public void scopeS() {}

    @After("scopeS()")
    public void afterAction() {
        System.out.println("LLLL");
    }

}
