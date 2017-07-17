package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dennis_zhou on 2017/7/18.
 */

/**
 * 配置Spring和junit整合，junit启动时加载Spring IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:Spring/Spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {

    }

    @Test
    public void reduceNumber() throws Exception {

    }


}