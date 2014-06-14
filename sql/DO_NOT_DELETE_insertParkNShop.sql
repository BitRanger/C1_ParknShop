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
INSERT INTO `c1_parknshop`.`ps_item` (`id_shop`, `id_category`, `name`, `introduction`, `price`, `url_picture`, `count_purchase`, `count_favourite`, `count_click`, `vote`, `time_created`) VALUES ('1', '1', 'Apple MacBook Pro �䱸 Retina ��ʾ�� ME865 CH/A 13.3Ӣ��ʼǱ�����(13.3/2.4GHZ/8GB/256GB FLASH)', '��Ҫ����
13 Ӣ����͵� Retina ��ʾ��ӵ�� 2560 x 1600 �ֱ��ʣ�15 Ӣ����͵� Retina ��ʾ��ӵ�� 2880 x 1800 �ֱ���
���Ĵ�˫�� Intel Core i5��13 Ӣ����ͣ����ĺ� Intel Core i7��15 Ӣ����ͣ�������
13 Ӣ����ʹ��� Intel Iris Graphics ͼ�δ�������15 Ӣ����ʹ��� Intel Iris Pro Graphics ͼ�δ������� Iris Pro ��ȫ�� NVIDIA GeForce GT 750M ͼ�δ�����
���� 9 Сʱ��13 Ӣ����ͣ��� 8 Сʱ��15 Ӣ����ͣ��ĵ��ʹ��ʱ���
����������
802.11ac Wi-Fi
���� Thunderbolt 2 �˿ڣ������Ӹ������豸���Կ���������ٶȴ������ݡ�
���� USB 3 �˿ڣ��� USB 2 �豸���ݣ��� HDMI �˿�
FaceTime HD ��������ͷ
���� Pages��Numbers��Keynote��iPhoto��iMovie��GarageBand
OS X Mavericks���˲�����Ƚ�����ϵͳ��', '9888.00', '41JTBoB4j7L._AA160_.jpg', '4', '4', '4', '5','2014/6/7 20:49');
INSERT INTO `c1_parknshop`.`ps_item` (`id_shop`, `id_category`, `name`, `introduction`, `price`, `url_picture`, `count_purchase`, `count_favourite`, `count_click`, `vote`, `time_created`) VALUES ('1', '1', 'ThinkPad X240-20AL001-HCD(����)12.5Ӣ��ʼǱ�����(i3-4010U 4G 1TB ���� ָ��ʶ�� ����ͷ 6о��� win8ϵͳ)', 'ThinkPad X240Ϊ��Ӧ�µı仯��Ϊ�����Я���������Ϊ���㡰��һ�������������� Ӧ�˶��� 
X240����ȫ�µ��Ĵ�����Ӣ�ض��������������һ���ٶ�����11%�������˿Ƽ�Ϊ�������׿Խ���������ܡ�
X240��Ļ180�㿪�ϵ���ƿ��������û���������Ե�ʹ��ȫ�µ�TrackPad�����һ','4826.00','41qlRzTtkPL._AA160_.jpg',100, 100, 2000, 5,'2014/6/7 20:49');
