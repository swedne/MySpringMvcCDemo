package example.aop;

import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletResponse;

public class ServiceAspect {
    public void logRespond(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        for (Object param:params) {
            if(param instanceof HttpServletResponse){
                System.out.print("response=" + ((HttpServletResponse) param).getStatus());
            }
        }
    }
}
