package com.example.petstore;

import org.aspectj.lang.annotation.After;

//@Aspect
//@Component
public class HomeAdvice {

    static int pageView = 0; // 페이지 조회 수
    
    // pageView getter method
    public static int getPageView(){ 
        return pageView; 
    }
    
    // com.example.petstore.PetApplication 아래에 있는 메서드가 실행될 때 마다 조회수 1 증가  
    @After("execution(* com.example.petstore.PetApplication.*(..))")
    public void after(){
        System.out.println("--- page view :  " + (++pageView));
    }

}
