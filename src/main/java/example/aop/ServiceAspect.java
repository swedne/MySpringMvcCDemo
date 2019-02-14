package example.aop;

import org.aopalliance.intercept.Joinpoint;

import javax.servlet.http.HttpServletResponse;

public class ServiceAspect {
    public void logRespond(HttpServletResponse response) {
        System.out.print("response=" + response.getStatus());
    }
}
