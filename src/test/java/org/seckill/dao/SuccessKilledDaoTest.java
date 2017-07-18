package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Dennis_zhou on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring/Spring-dao.xml"})
public class SuccessKilledDaoTest {

    //注入Dao实现依赖
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKill() throws Exception {
        /**
         * 这里再次执行insert时返回的insertCount为0表示没有再插入，
         * 这里是sql中联合主键起到的作用，详细sql查看scherma.sql文件
         */
        long id = 1001L;
        long phone = 18158869007L;
        int insertCount = successKilledDao.insertSuccessKill(id,phone);
        System.out.println("insertCount = " + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long phone = 18158869007L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}