package com.myproject.admin.securityComponent;

import cn.hutool.json.JSONUtil;
import com.myproject.admin.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义返回结果：未登录或登录过期
 * Created by macro on 2018/5/14.
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // 首先会经过JwtAuthenticationTokenFilter过滤器，将传过来的request里面的token信息解析
    // 如果没有传token就直接报未登录，也就是会跳到这里来，假如token信息正确，就不会经过这里
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // 但为啥我登录操作,也会报暂未登录,请重新登录(将unauthrozed改为failed)
        response.getWriter().println(JSONUtil.parse(CommonResult.failed(authException.getMessage())));
        response.getWriter().flush();
    }
}
