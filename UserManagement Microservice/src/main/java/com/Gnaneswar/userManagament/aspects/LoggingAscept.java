package com.Gnaneswar.userManagament.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAscept {
//	
//	@Before("execution(* com.Gnaneswar.userManagament.service.*.*(..))")
//    public void logBefore() {
//       System.out.println("You login sucessfully");
//    }
	
	
//	@Around("execution(* com.Gnaneswar.userManagament.service.*.*(..))")
//    public Object logAround(ProceedingJoinPoint jp) throws Throwable {
//       System.out.println("You login sucessfully");
//       Object obj=jp.proceed();
//       
//       System.out.println("Method called Succesfully");
//       return obj;
//       
//    }
	
	
	//designators for point Cut
	
	
	//within   // executes for all functions present in the particula class
//	@Before("within(com.Gnaneswar.userManagament.service.UserManagementService)")
//  public void logBefore() {
//     System.out.println("within method called");
//  }

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void pointCutDeclared() {
		
	}
	
	@Before("pointCutDeclared()")
	  public void logBeforewithAnnotatedDesignation() {
	     System.out.println("Annotation method called");
	  }
}
