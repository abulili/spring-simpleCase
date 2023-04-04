package org.example.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {
    @Before("execution(public * org.example.DAO.EmployeeDaoAccessService.*(..))")
    public void EmployeeDaoB(JoinPoint jp) {
        String method = jp.getSignature().getName();
        System.out.println("进入到" + method + "方法");
    }
    @AfterReturning(value = "execution(public * org.example.DAO.EmployeeDaoAccessService.*(..))", returning = "result")
    public void EmployeeDaoA(JoinPoint jp, Object result){
        String method = jp.getSignature().getName();
        System.out.println(method + "方法结束");
    }

    @Before("execution(public * org.example.DAO.LocationDaoAccessService.*(..))")
    public void LocationDaoB(JoinPoint jp) {
        String method = jp.getSignature().getName();
        System.out.println("进入到" + method + "方法");
    }
    @AfterReturning(value = "execution(public * org.example.DAO.LocationDaoAccessService.*(..))", returning = "result")
    public void LocationDaoA(JoinPoint jp, Object result){
        String method = jp.getSignature().getName();
        System.out.println(method + "方法结束");
    }

    @Before("execution(public * org.example.DAO.UserDaoAccessService.*(..))")
    public void UserDaoB(JoinPoint jp) {
        String method = jp.getSignature().getName();
        System.out.println("进入到" + method + "方法");
    }
    @AfterReturning(value = "execution(public * org.example.DAO.UserDaoAccessService.*(..))", returning = "result")
    public void EUserDaoA(JoinPoint jp, Object result){
        String method = jp.getSignature().getName();
        System.out.println(method + "方法结束");
    }
}
