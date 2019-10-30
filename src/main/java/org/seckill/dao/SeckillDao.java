package org.seckill.dao;
import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {
    /* 减库存 */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
    /* 通过Id查看秒杀商品 */
    Seckill queryById(long seckillId);
    /* 根据偏移量查询秒杀商品列表  在这里使用Param来指定形参所对应的实参*/
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
    /*使用存储过程执行秒杀*/
    void killByProcedure(Map<String,Object> paramMap);
}
