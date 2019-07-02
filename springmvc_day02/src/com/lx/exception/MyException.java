package com.lx.exception;

/**
 * create by hekai  2019-06-24
 *
 * @desc  自定义异常
 */
public class MyException extends Exception{

    // 异常信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyException(String message) {
       this.message = message;
    }
}
