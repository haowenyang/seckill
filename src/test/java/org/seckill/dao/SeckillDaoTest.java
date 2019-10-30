package org.seckill.dao;


import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;


/*
* 单元测试 首先配置spring和junit整合，为了junit启动时加载springIOC容器
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现类依赖
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int update  = seckillDao.reduceNumber(1000L,killTime);
        System.out.println(update);
    }

    @Test
    public void queryById() {
        /*1000元秒杀iphone
        Seckill{seckillId=1000,
        name='1000元秒杀iphone',
        number=100,
        startTime='Sun Nov 01 00:00:00 GMT+08:00 2015',
        endTime='Mon Nov 02 00:00:00 GMT+08:00 2015',
        createTime='Fri Oct 25 09:33:15 GMT+08:00 2019'}*/
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        /*Seckill{seckillId=1000, name='1000元秒杀iphone', number=100, startTime='Sun Nov 01 00:00:00 GMT+08:00 2015', endTime='Mon Nov 02 00:00:00 GMT+08:00 2015', createTime='Fri Oct 25 09:33:15 GMT+08:00 2019'}
        Seckill{seckillId=1001, name='100元秒杀iphone', number=200, startTime='Thu Oct 01 00:00:00 GMT+08:00 2015', endTime='Fri Oct 02 00:00:00 GMT+08:00 2015', createTime='Fri Oct 25 09:33:15 GMT+08:00 2019'}
        Seckill{seckillId=1002, name='500元秒杀iphone', number=150, startTime='Thu Nov 05 00:00:00 GMT+08:00 2015', endTime='Fri Nov 06 00:00:00 GMT+08:00 2015', createTime='Fri Oct 25 09:33:15 GMT+08:00 2019'}
        Seckill{seckillId=1003, name='1元秒杀iphone', number=10, startTime='Wed Nov 11 00:00:00 GMT+08:00 2015', endTime='Thu Nov 12 00:00:00 GMT+08:00 2015', createTime='Fri Oct 25 09:33:15 GMT+08:00 2019'}
*/
        List<Seckill> list = seckillDao.queryAll(0,100);
        for (Seckill seckill:list) {
            System.out.println(seckill);
        }
    }

    @Test
    public void killByProcedure() {
    }
}