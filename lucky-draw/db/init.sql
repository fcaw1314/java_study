drop database if exists lucky_draw;
create database lucky_draw character set utf8mb4;

use lucky_draw;

drop table if exists user;
create table user(
                     id int primary key auto_increment,
                     username varchar(20) not null unique comment '用户账号',
                     password varchar(20) not null comment '密码',
                     nickname varchar(20) comment '用户昵称',
                     email varchar(50) comment '邮箱',
                     age int comment '年龄',
                     head varchar(255) comment '头像url',
                     create_time timestamp default NOW() comment '创建时间'
) comment '用户表';

drop table if exists setting;
create table setting(
                        id int primary key auto_increment,
                        user_id int not null comment '用户id',
                        batch_number int not null comment '每次抽奖人数',
                        create_time timestamp default NOW() comment '创建时间',
                        foreign key (user_id) references user(id)
) comment '抽奖设置';

drop table if exists award;
create table award(
                      id int primary key auto_increment,
                      name varchar(20) not null comment '奖项名称',
                      count int not null comment '奖项人数',
                      award varchar(20) not null comment '奖品',
                      setting_id int not null comment '抽奖设置id',
                      create_time timestamp default NOW() comment '创建时间',
                      foreign key (setting_id) references setting(id)
) comment '奖项';

drop table if exists member;
create table member(
                       id int primary key auto_increment,
                       name varchar(20) not null comment '姓名',
                       no varchar(20) not null comment '工号',
                       setting_id int not null comment '抽奖设置id',
                       create_time timestamp default NOW() comment '创建时间',
                       foreign key (setting_id) references setting(id)
) comment '抽奖人员';

drop table if exists record;
create table record(
                       id int primary key auto_increment,
                       member_id int not null comment '中奖人员id',
                       award_id int not null comment '中奖奖项id',
                       create_time timestamp default NOW() comment '创建时间',
                       foreign key (member_id) references member(id),
                       foreign key (award_id) references award(id)
) comment '中奖记录';



insert into user(id, username, password, nickname, email, age, head) values (1, 'yxb', '123', '派大星', '1111@163.com', 18, 'img/test-head.jpg');

## 数据字典：学生毕业年份
insert into setting(id, user_id, batch_number) values (1, 1, 63);

insert into award(name, count, award, setting_id) values ('特等奖', 1, '国内七日畅游', 1);
insert into award(name, count, award, setting_id) values ('一等奖', 1, '1w现金', 1);
insert into award(name, count, award, setting_id) values ('二等奖', 3, 'iphone15一台', 1);
insert into award(name, count, award, setting_id) values ('三等奖', 5, 'ipad一台', 1);
insert into award(name, count, award, setting_id) values ('励志奖', 10, '校长办公室一日游', 1);



## 数据字典：学生专业
insert into member(name, no, setting_id) values ('毕子威', 'no1', 1);
insert into member(name, no, setting_id) values ('曹聪俊', 'no2', 1);
insert into member(name, no, setting_id) values ('曹源', 'no3', 1);
insert into member(name, no, setting_id) values ('陈禹', 'no4', 1);
insert into member(name, no, setting_id) values ('谌鸿炜', 'no5', 1);
insert into member(name, no, setting_id) values ('戴云鹏', 'no6', 1);
insert into member(name, no, setting_id) values ('邓筱', 'no7', 1);
insert into member(name, no, setting_id) values ('董嘉欣', 'no8', 1);
insert into member(name, no, setting_id) values ('范子琦', 'no9', 1);
insert into member(name, no, setting_id) values ('符昊', 'no10', 1);
insert into member(name, no, setting_id) values ('高安政', 'no11', 1);
insert into member(name, no, setting_id) values ('高茗翔', 'no12', 1);
insert into member(name, no, setting_id) values ('古晓枫', 'no13', 1);
insert into member(name, no, setting_id) values ('韩笑', 'no14', 1);
insert into member(name, no, setting_id) values ('胡锦超', 'no15', 1);
insert into member(name, no, setting_id) values ('黄世炜', 'no16', 1);
insert into member(name, no, setting_id) values ('黄宇杰', 'no17', 1);
insert into member(name, no, setting_id) values ('江佳涛', 'no18', 1);
insert into member(name, no, setting_id) values ('赖健', 'no19', 1);
insert into member(name, no, setting_id) values ('兰鑫', 'no20', 1);
insert into member(name, no, setting_id) values ('李凤', 'no21', 1);
insert into member(name, no, setting_id) values ('李家琛', 'no22', 1);
insert into member(name, no, setting_id) values ('李嘉豪', 'no23', 1);
insert into member(name, no, setting_id) values ('李梅', 'no24', 1);
insert into member(name, no, setting_id) values ('李奇', 'no25', 1);
insert into member(name, no, setting_id) values ('李绅', 'no26', 1);
insert into member(name, no, setting_id) values ('李先胜', 'no27', 1);
insert into member(name, no, setting_id) values ('梁文娟', 'no28', 1);
insert into member(name, no, setting_id) values ('刘家苑', 'no29', 1);
insert into member(name, no, setting_id) values ('刘金华', 'no30', 1);
insert into member(name, no, setting_id) values ('刘绍南', 'no31', 1);
insert into member(name, no, setting_id) values ('刘姝莹', 'no32', 1);
insert into member(name, no, setting_id) values ('刘伟峰', 'no33', 1);
insert into member(name, no, setting_id) values ('刘旭', 'no34', 1);
insert into member(name, no, setting_id) values ('罗滨', 'no35', 1);
insert into member(name, no, setting_id) values ('罗君', 'no36', 1);
insert into member(name, no, setting_id) values ('隋心语', 'no37', 1);
insert into member(name, no, setting_id) values ('孙彩云', 'no38', 1);
insert into member(name, no, setting_id) values ('孙建东', 'no39', 1);
insert into member(name, no, setting_id) values ('王瑞琪', 'no40', 1);
insert into member(name, no, setting_id) values ('王熙文', 'no41', 1);
insert into member(name, no, setting_id) values ('王云', 'no42', 1);
insert into member(name, no, setting_id) values ('吴鑫龙', 'no43', 1);
insert into member(name, no, setting_id) values ('夏嘉宇', 'no44', 1);
insert into member(name, no, setting_id) values ('夏凌志', 'no45', 1);
insert into member(name, no, setting_id) values ('谢俊涛', 'no46', 1);
insert into member(name, no, setting_id) values ('谢志豪', 'no47', 1);
insert into member(name, no, setting_id) values ('杨佳旭', 'no48', 1);
insert into member(name, no, setting_id) values ('杨晓波', 'no49', 1);
insert into member(name, no, setting_id) values ('杨志明', 'no50', 1);
insert into member(name, no, setting_id) values ('余长乐', 'no51', 1);
insert into member(name, no, setting_id) values ('喻多福', 'no52', 1);
insert into member(name, no, setting_id) values ('占庆华', 'no53', 1);
insert into member(name, no, setting_id) values ('张俊鑫', 'no54', 1);
insert into member(name, no, setting_id) values ('张洋', 'no55', 1);
insert into member(name, no, setting_id) values ('张玉平', 'no56', 1);
insert into member(name, no, setting_id) values ('赵世钰', 'no57', 1);
insert into member(name, no, setting_id) values ('郑雅惠', 'no58', 1);
insert into member(name, no, setting_id) values ('周灵俊', 'no59', 1);
insert into member(name, no, setting_id) values ('周旭迎', 'no60', 1);
insert into member(name, no, setting_id) values ('周长威', 'no61', 1);
insert into member(name, no, setting_id) values ('史康康', 'no62', 1);
insert into member(name, no, setting_id) values ('李成', 'no63', 1);

-- 插入抽奖记录
-- insert into record(member_id, award_id) values(56, 1);
