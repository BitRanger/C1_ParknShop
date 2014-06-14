DELETE FROM `c1_parknshop`.`ps_item`;
DELETE FROM `c1_parknshop`.`ps_shop`;
DELETE FROM `c1_parknshop`.`ps_seller`;
DELETE FROM `c1_parknshop`.`ps_category`;
ALTER TABLE `c1_parknshop`.`ps_seller` AUTO_INCREMENT = 1;
ALTER TABLE `c1_parknshop`.`ps_item` AUTO_INCREMENT = 1;
ALTER TABLE `c1_parknshop`.`ps_shop` AUTO_INCREMENT = 1;
ALTER TABLE `c1_parknshop`.`ps_category` AUTO_INCREMENT = 1;

INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`, `time_created`) VALUES ('BossGao', '123', '33323232323@qq.com', '123', '0', '2011-2-3');
INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`, `time_created`) VALUES ('DoubleWen', '345', 'ewrfnsdjkfn@163.com', '123', '0', '2013-5-6');
INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`, `time_created`) VALUES ('Mr.AJ', '789', 'MRAJ@nwpu.com', '123', '0', '2014-5-24');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('1', 'Welcome Electronic', '0', 'Come and buy', '2012-2-3', '4');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('1', 'Baby shopping', '0', 'lovely baby', '2012-2-3', '4.8');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('1', 'Nike Profession', '0', 'all nike is here', '2012-2-3', '4.0');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('1', 'Nice Taste', '0', 'attract you ', '2013-4-24', '3.5');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('2', 'Reading Ocean', '0', 'find whatever', '2013-4-5', '5.0');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('2', 'Computer Shopping', '0', 'co', '2012-2-3', '3.4');
INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `time_created`, `vote`) VALUES ('3', 'LiNing', '0', 'anything is possible', '2014-4-5', '4.8');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('ELECTRONICS');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('MEN');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('WOMEN');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('BABY&KIDS');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('BOOKS&MEDIA');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('FOOD');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('HOME&KITCHEN');
INSERT INTO `c1_parknshop`.`ps_item` (`id_shop`, `id_category`, `name`, `introduction`, `price`, `url_picture`, `count_purchase`, `count_favourite`, `count_click`, `vote`, `time_created`) VALUES ('1', '1', 'Apple MacBook Pro 配备 Retina 显示屏 ME865 CH/A 13.3英寸笔记本电脑(13.3/2.4GHZ/8GB/256GB FLASH)', '主要功能
13 英寸机型的 Retina 显示屏拥有 2560 x 1600 分辨率，15 英寸机型的 Retina 显示屏拥有 2880 x 1800 分辨率
第四代双核 Intel Core i5（13 英寸机型）和四核 Intel Core i7（15 英寸机型）处理器
13 英寸机型搭载 Intel Iris Graphics 图形处理器，15 英寸机型搭载 Intel Iris Pro Graphics 图形处理器或 Iris Pro 与全新 NVIDIA GeForce GT 750M 图形处理器
长达 9 小时（13 英寸机型）或 8 小时（15 英寸机型）的电池使用时间①
更快的闪存②
802.11ac Wi-Fi
两个 Thunderbolt 2 端口，可连接高性能设备并以快如闪电的速度传输数据。
两个 USB 3 端口（与 USB 2 设备兼容）和 HDMI 端口
FaceTime HD 高清摄像头
内置 Pages、Numbers、Keynote、iPhoto、iMovie、GarageBand
OS X Mavericks，了不起的先进操作系统。', '9888.00', '41JTBoB4j7L._AA160_.jpg', '4', '4', '4', '5','2014/6/7 20:49');
INSERT INTO `c1_parknshop`.`ps_item` (`id_shop`, `id_category`, `name`, `introduction`, `price`, `url_picture`, `count_purchase`, `count_favourite`, `count_click`, `vote`, `time_created`) VALUES ('1', '1', 'ThinkPad X240-20AL001-HCD(联想)12.5英寸笔记本电脑(i3-4010U 4G 1TB 蓝牙 指纹识别 摄像头 6芯电池 win8系统)', 'ThinkPad X240为适应新的变化，为满足便携商务的需求，为满足“另一种声音”的需求 应运而生 
X240搭载全新第四代智能英特尔酷睿处理器，较上一代速度提升11%，更多尖端科技为你带来更卓越的娱乐性能。
X240屏幕180°开合的设计可以满足用户更多灵活性的使用全新的TrackPad五键合一','4826.00','41qlRzTtkPL._AA160_.jpg',100, 100, 2000, 5,'2014/6/7 20:49');
