-- 整个项目的数据库脚本
-- 开始创建一个数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;
-- 创建秒杀数据库表
create TABLE seckill(
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` VARCHAR(20) NOT NULL COMMENT '商品名称',
  `number` INT NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL DEFAULT  current_timestamp() COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(seckill_id),
  key idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 设置初始的自增Id AUTO_INCREMENT=1000 从1000开始
-- 初始化数据
INSERT INTO
  seckill(name, number,start_time,end_time)
VALUES
  ('1000元秒杀iPhone7 Plus',100,'2017-07-01 00:00:00','2017-07-02 00:00:00'),
  ('500元秒杀ipad pro',200,'2017-07-01 00:00:00','2017-07-02 00:00:00'),
  ('300元秒杀xiaomi6',300,'2017-07-01 00:00:00','2017-07-02 00:00:00'),
  ('200元秒杀诺基亚',400,'2017-07-01 00:00:00','2017-07-02 00:00:00');


-- 秒杀成功明细表
-- 用户登录认证相关的信息
CREATE TABLE success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品ID',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标识：-1无效 0成功 1已付款',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  -- 联合主键
  PRIMARY KEY (seckill_id,user_phone),
  KEY idx_create_time(create_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

