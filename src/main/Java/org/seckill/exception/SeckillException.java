package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by Dennis_zhou on 2017/7/18.
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
