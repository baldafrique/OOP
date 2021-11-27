package com.example.petstore;

import org.aspectj.lang.annotation.After;

//@Aspect
//@Component
public class HomeAdvice {

    static int pageView = 0;
    public static int getPageView(){
        return pageView;
    }
    
    @After("execution(* com.example.petstore.PetApplication.*(..))")
    public void after(){
        System.out.println("--- page view :  " + (++pageView));
    }

}
