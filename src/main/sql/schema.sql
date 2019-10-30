--数据库初始化脚本
--创建数据库
CREATE  DATABASE seckill;
--使用数据库
use seckill;
--创建秒杀数据库
CREATE TABLE seckill(
    `seckill_id` bigint not null AUTO_INCREMENT COMMENT '商品库存id',
    `name` varchar(120) not null COMMENT '商品名称',
    `number` int not null COMMENT '库存数量',
    `start_time` timestamp not null default '0000-00-00 00:00:00' COMMENT '开始时间',
    `end_time` timestamp not null default '0000-00-00 00:00:00' COMMENT '结束时间',
    `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
    primary key (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT = 1000 default  character set=utf8 COMMENT='秒杀库存表';
--初始化数据
insert into seckill(name,number,start_time,end_time) value
('1000元秒杀iphone',100,'2019-11-01 00:00:00','2019-11-02 00:00:00'),
('100元秒杀iphone',200,'2019-11-01 00:00:00','2019-11-02 00:00:00'),
('500元秒杀iphone',150,'2019-11-09 00:00:00','2019-11-06 00:00:00'),
('1元秒杀iphone',10,'2019-11-11 00:00:00','2019-11-12 00:00:00');

--秒杀成功明细表
--用户登录认证相关信息
create table success_killed(
`seckill_id` bigint not null comment '秒杀商品id',
`user_phone` bigint not null comment '用户手机号',
`state` int not null default -1 comment '状态显示：-1：无效， 0：成功， 1：付款',
`create_time` timestamp not null default current_timestamp COMMENT '创建时间',
 primary key (seckill_id,user_phone),
    key idx_create_time(create_time)
)ENGINE=InnoDB  default  character set=utf8 COMMENT='秒杀成功明细表';

--连接数据库的控制台
--mysql -uroot -p

