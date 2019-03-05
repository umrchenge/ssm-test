package cn.umr.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author UMR丶晨哥
 * @version 1.0
 * @date 2018/12/10 16:49
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        CustomException customException = null;
        if (e instanceof CustomException)
        {
            customException = (CustomException)e;
        }else {
            customException = new CustomException("未知错误");
        }

        String message = customException.getMessage();

        //模型和视图
        ModelAndView modelAndView = new ModelAndView();
        //设置错误信息
        modelAndView.addObject("message",message);
        //设置错误信息显示的页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
