package org.seckill.exception;

/**
 * 重复秒杀异常(运行期异常)
 * Created by Dennis_zhou on 2017/7/18.
 */
public class RepeatKillException extends RuntimeException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message,Throwable cause) {
        super(message,cause);
    }
}
