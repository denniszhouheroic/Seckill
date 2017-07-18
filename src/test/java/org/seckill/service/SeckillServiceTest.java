package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dennis_zhou on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring/Spring-dao.xml",
                        "classpath:Spring/Spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

   /* @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }*/

   //测试代码完整逻辑，注意可重复执行
   @Test
   public void testSeckillLogic() throws Exception {
       long id = 1001L;
       Exposer exposer = seckillService.exportSeckillUrl(id);
       if(exposer.isExposer()) {
           logger.info("exposer={}",exposer);
           long phone = 18158869008L;
           String md5 = exposer.getMd5();
           try{
               SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
           }catch (RepeatKillException e) {
                logger.error(e.getMessage());
           }catch (SeckillCloseException e) {
               logger.error(e.getMessage());
           }
       } else {
           //秒杀未开启
           logger.warn("exposer={}",exposer);
       }
   }

    /*@Test
    public void executeSeckill() throws Exception {
        long id = 1000L;
        long phone = 18158869007L;
        String md5 = "ee64599f9f4bb993067b997105ed362a";
        try {
            SeckillExecution exception = seckillService.executeSeckill(id, phone, md5);
            logger.info("result={}", exception);
        }catch (RepeatKillException e) {
            logger.error(e.getMessage());
        }catch (SeckillCloseException e) {
            logger.error(e.getMessage());
        }
    }*/

}