package cn.umr.exception;

/**
 * 自定义异常类
 * @author UMR丶晨哥
 * @version 1.0
 * @date 2018/12/10 16:39
 */
public class CustomException extends Exception{

    public CustomException(String message) {
        super(message);
    }
}
