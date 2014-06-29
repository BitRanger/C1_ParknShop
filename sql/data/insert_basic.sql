SET FOREIGN_KEY_CHECKS=0; 

truncate `c1_parknshop`.`r_tag_item`;
truncate `c1_parknshop`.`ps_tag`;
truncate `c1_parknshop`.`ps_item`;
truncate `c1_parknshop`.`ps_item_info`;
truncate `c1_parknshop`.`ps_category`;

truncate `c1_parknshop`.`ps_promot_item`;

truncate `c1_parknshop`.`ps_notice_seller`;
truncate `c1_parknshop`.`ps_seller_acc`;
truncate `c1_parknshop`.`ps_shop`;
truncate `c1_parknshop`.`ps_seller`;

truncate `c1_parknshop`.`r_order_item`;
truncate `c1_parknshop`.`ps_order`;
truncate `c1_parknshop`.`ps_order_log`;

truncate `c1_parknshop`.`ps_notice_customer`;
truncate `c1_parknshop`.`cart_customer_item`;
truncate `c1_parknshop`.`customer_favourite_item`;
truncate `c1_parknshop`.`ps_customer`;


truncate `c1_parknshop`.`ps_admin_acc`;
truncate `c1_parknshop`.`ps_notice_admin`;
truncate `c1_parknshop`.`ps_administrator`;


truncate `c1_parknshop`.`ps_key_value`;
truncate `c1_parknshop`.`ps_config_val`;
truncate `c1_parknshop`.`ps_config_key`;

SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('TV& Home Theater'); -- 1
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Computers & Tablets');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Cell Phones'); -- 3
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Cameras & Camcorders');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Audio');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Car Electronics & GPS'); -- 6
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Video, Games, Movies & Music');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Health, Fitness & Sports');
INSERT INTO `c1_parknshop`.`ps_category` (`name`) VALUES ('Home & Office'); -- 9


INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`) 
				VALUES ('BossGao', '123', '33323232323@qq.com', '123', '0');

INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`) 
				VALUES ('DoubleWen', '345', 'ewrfnsdjkfn@163.com', '123', '0');

INSERT INTO `c1_parknshop`.`ps_seller` (`nickname`, `person_id_num`, `email`, `password`, `status`) 
				VALUES ('Mr.AJ', '789', 'MRAJ@nwpu.com', '123', '0');



INSERT INTO `c1_parknshop`.`ps_administrator` (`email`, `name`, `password`) 
					VALUES ('admin@parknshop.com', 'Super', 'admin');


INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('1', 'Welcome Electronic', '0', 'Come and buy', '4');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('1', 'Baby shopping', '0', 'lovely baby', '4.8');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('1', 'Nike Profession', '0', 'all nike is here', '4.0');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('1', 'Nice Taste', '0', 'attract you ', '3.5');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('2', 'Reading Ocean', '0', 'find whatever', '5.0');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
				VALUES ('2', 'Computer Shopping', '0', 'co', '3.4');

INSERT INTO `c1_parknshop`.`ps_shop` (`id_seller`, `name`, `status`, `introduction`, `vote`) 
			VALUES ('3', 'LiNing', '0', 'anything is possible', '4.8');


insert into `c1_parknshop`.`ps_customer`(`nickname`, `email`, `password`, `gender`)
			values("tester", "test@test.com", "test123", 1)