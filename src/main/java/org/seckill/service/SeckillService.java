package org.seckill.service;

import org.seckill.entity.Seckill;

import java.util.List;

/*业务接口：站在“使用者”角度设计接口
* 三个方面：方法定义粒度，参数简单，返回类型
* */
public interface SeckillService {
    /*查询所有的秒杀记录*/
    List<Seckill> getSeckillList();
    /*查询单个的秒杀记录*/
    Seckill getById(long seckillId);
    /*秒杀时间开始时输出秒杀的接口，否则输出系统时间和秒杀时间用来做比较*/
    void exportSeckillUrl(long seckillId);
}
