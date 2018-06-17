package struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class HelloInterceptor extends AbstractInterceptor {

    //计算拦截器执行的时间
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        long start = System.currentTimeMillis();
        String result = invocation.invoke();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);
        return result;
    }
}
