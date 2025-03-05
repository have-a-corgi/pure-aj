package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DecoratorAspect {

    private final FinalAspect delegate = new FinalAspect();

    //Narrow scope
    @Pointcut("execution(* org.example.pojo.SmartPojo.*())")
    public void scopeB() {
    }

    @Before("scopeB()")
    public void action(JoinPoint jp) {
        delegate.action(jp);
    }
}
