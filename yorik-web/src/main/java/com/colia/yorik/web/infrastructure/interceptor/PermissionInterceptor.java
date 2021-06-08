package com.colia.yorik.web.infrastructure.interceptor;

import com.colia.yorik.dao.entity.SysUser;
import com.colia.yorik.support.infrastructure.exception.BizProcessException;
import com.colia.yorik.support.interfaces.annotation.PermissionLimit;
import com.colia.yorik.web.interfaces.user.facade.UserFacade;
import com.colia.yorik.web.interfaces.user.facade.impl.UserFacadeImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截
 *
 * @Author colia
 * @Date 2021/1/5
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Resource
    private UserFacadeImpl loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // if need login
        boolean needLogin = false;
        boolean needAdminUser = false;
        HandlerMethod method = (HandlerMethod) handler;
        PermissionLimit permission = method.getMethodAnnotation(PermissionLimit.class);

        if (permission != null) {
            needLogin = permission.limit();
            needAdminUser = permission.adminUser();
        }

        if (needLogin) {
            SysUser loginUser = loginService.ifLogin(request, response);
            if (loginUser == null) {
//                response.setStatus(302);
//                response.setHeader("location", request.getContextPath() + "/toLogin");
                throw
                        new BizProcessException("用户未登录");
//                return false;
            }
//            if (needAdminuser && loginUser.getRole() != 1) {
//                throw new RuntimeException(I18nUtil.getString("system_permission_limit"));
//            }
            request.setAttribute(UserFacadeImpl.LOGIN_IDENTITY_KEY, loginUser);
        }

        return true;
    }

}
