package example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class TokenHandler {

    public static String DEFAULT_TOKEN_NAME = "TOKEN";

    // 验证表单token值和session中的token值是否一致
    @SuppressWarnings("unchecked")
    public static boolean validToken(HttpServletRequest request) {
        String inputToken = getInputToken(request);

        if (inputToken == null) {
            System.out.println("令牌是不是有效的。inputtoken是空的");
            return false;
        }

        HttpSession session = request.getSession();
        String tokenMap = (String) session.getAttribute(DEFAULT_TOKEN_NAME);
        if (tokenMap == null) {
            System.out.println("token is not valid!sessionToken is NULL");
            return false;
        }
        String sessionToken = tokenMap;
        if (!inputToken.equals(sessionToken)) {
            System.out.println("token is not valid!inputToken='" + inputToken + "',sessionToken = '" + sessionToken + "'");
            return false;
        }
        session.removeAttribute(DEFAULT_TOKEN_NAME);
        return true;
    }

    // 获取表单中token值
    @SuppressWarnings("unchecked")
    public static String getInputToken(HttpServletRequest request) {
        Map params = request.getParameterMap();
        System.out.println(request.getSession().getAttribute("TOKEN"));
        if (!params.containsKey(DEFAULT_TOKEN_NAME)) {
            System.out.println("无法找到令牌名称参数。");
            return null;
        }

        String[] tokens = (String[]) (String[]) params.get(DEFAULT_TOKEN_NAME);

        if ((tokens == null) || (tokens.length < 1)) {
            return null;
        }
        String temp = tokens[0];
        return temp;
    }

}
