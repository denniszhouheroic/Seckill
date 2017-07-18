package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Created by Dennis_zhou on 2017/7/18.
 */
public class SeckillCloseException extends RuntimeException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
