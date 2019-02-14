package example.interceptor;

import example.bean.AbstractJsonObject;
import example.bean.SingleObject;
import example.entity.User;
import example.util.JackJsonUtils;
import example.util.ResponseUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(request.getRequestURL() + "?");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue()[0]);
            sb.append("&");
        }
        System.out.println("url=" + sb.substring(0, sb.length() - 1));
        if (request.getParameterValues("id") != null && request.getParameterValues("id").length > 0) {
            if (!TokenHandler.validToken(request)) {
                response.setStatus(300);
                AbstractJsonObject abstractJsonObject = new AbstractJsonObject();
                abstractJsonObject.setCode(300);
                abstractJsonObject.setMsg("Token不匹配");
                ResponseUtils.renderJson(response, JackJsonUtils.toJson(abstractJsonObject));
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
