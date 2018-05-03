/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : bms

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 03/05/2018 11:17:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for add_table
-- ----------------------------
DROP TABLE IF EXISTS `add_table`;
CREATE TABLE `add_table`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `body` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `title` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `click` int(11) NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `tag` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `seoId` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `bannerImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `coverImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dic_item
-- ----------------------------
DROP TABLE IF EXISTS `dic_item`;
CREATE TABLE `dic_item`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `type_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `sort` int(255) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dic_item
-- ----------------------------
INSERT INTO `dic_item` VALUES ('industry', 'article', 'industry', '1', NULL, NULL);

-- ----------------------------
-- Table structure for dic_type
-- ----------------------------
DROP TABLE IF EXISTS `dic_type`;
CREATE TABLE `dic_type`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dic_type
-- ----------------------------
INSERT INTO `dic_type` VALUES ('article', NULL, NULL, 'for news');
INSERT INTO `dic_type` VALUES ('image', NULL, NULL, NULL);
INSERT INTO `dic_type` VALUES ('menu', NULL, NULL, NULL);
INSERT INTO `dic_type` VALUES ('product', NULL, NULL, NULL);
INSERT INTO `dic_type` VALUES ('project', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for global
-- ----------------------------
DROP TABLE IF EXISTS `global`;
CREATE TABLE `global`  (
  `id` varbinary(64) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `click` int(255) NULL DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `seoId` int(11) NULL DEFAULT NULL,
  `updateDate` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `coverImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `bannerImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `extends1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `extends2` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (1);

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名字',
  `originName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始名字',
  `alt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '未加载图片信息',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片类型',
  `relativePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相对路径',
  `absolutePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '绝对路径',
  `height` int(11) NULL DEFAULT NULL,
  `width` int(11) NULL DEFAULT NULL,
  `class1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `class3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('042a026184a547dca663399f7b395f44', NULL, 'android-hand.png', 'ea', 'dfas', '/upload-files//images/system/android-hand.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('08410b4865124d08ad6661717fcf8b3b', NULL, 'android-social-user.png', '', '', '/upload-files//images/system/android-social-user.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('098bf1e164984cc3b9c651d62721f1a2', NULL, 'android-storage.png', '', '', '/upload-files//images/product/android-storage.png', NULL, '/upload-files//images/product/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/product/', 512, 512, 'product', NULL, NULL);
INSERT INTO `images` VALUES ('0f2a1426f2ca4f0488d64340b3759182', NULL, 'logo.png', 'good', 'morning', '/upload-files//images/system/logo.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('11088058f0a347ac8091cea5c976f3ae', NULL, 'QQ图片20170919163710.jpg', 'what', 'the', '/upload-files//images/system/QQ图片20170919163710.jpg', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('1991caac9447455385ea2e86eb2a52d3', NULL, 'beaker.png', '', '', '/upload-files//images/system/beaker.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('21a7f5238ca44042b1644814cfa5e459', NULL, 'android-chat.png', '', '', '/upload-files//images/system/android-chat.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('242d153b133b47308c7be00c65328970', NULL, 'android-developer.png', '', '', '/upload-files//images/system/android-developer.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('25ff22a14e794d55a46f7f4902f23d11', NULL, 'android-dropdown.png', '', '', '/upload-files//images/info/android-dropdown.png', NULL, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', 512, 512, 'info', NULL, NULL);
INSERT INTO `images` VALUES ('29440fab063944ad880b87eff58a12a3', NULL, 'xbox.png', '', '', '/upload-files//images/system/xbox.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('2bf63f76863c4261bc6d492e9ad7f840', NULL, 'ccccc.png', '', '', '/upload-files/images/ckEditor/ccccc.png', NULL, '/upload-files/images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('41dabcca651f4016876b6612a0c5f239', NULL, 'android-display.png', '', '', '/upload-files//images/system/android-display.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('45d0973da464435181e291cbba50078b', NULL, 'android-data.png', '', '', '/upload-files//images/system/android-data.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('46e98410248e430d9559243012010ca8', NULL, 'alert.png', '', '', '/upload-files//images/ckEditor/alert.png', NULL, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('491039a307854ee0ad2878705f4c1031', NULL, 'android-camera.png', '', '', '/upload-files//images/system/android-camera.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('4ad76f41314545a59a0b414de8c55fa9', NULL, '0.jpg', '', '', '/upload-files/images/ckEditor/0.jpg', NULL, '/upload-files/images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('5d4fa0e897aa4696b56c6ef8ce81b9df', NULL, 'android-add-contact.png', '', '', '/upload-files//images/system/android-add-contact.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('63dd9ec756fa4d998e00e2aa7186674e', NULL, '00368.jpg', 'good', 'morning', '/upload-files//images/system/00368.jpg', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('6ba37980da3044f0ac433163a281a1b0', NULL, 'android-lightbulb.png', '', '', '/upload-files//images/system/android-lightbulb.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('7bb6b1d0b8bb44d2bfafea57681d929a', NULL, 'android-location.png', '', '', '/upload-files//images/system/android-location.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('7d7bb9aa6bbb4614ba31ec015c2765a4', NULL, 'android-send.png', '', '', '/upload-files//images/other/android-send.png', NULL, '/upload-files//images/other/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/other/', 512, 512, 'other', NULL, NULL);
INSERT INTO `images` VALUES ('7f2440f3896d42d0b8bf977e843e9930', NULL, 'android-search.png', '范德萨', '范德萨 ', '/upload-files//images/system/android-search.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('808a211999c84cecb6ed206888a50791', NULL, 'alert-circled.png', '', '', '/upload-files//images/system/alert-circled.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('845778fec53646dcab82ba6495388c51', NULL, 'android-archive.png', '', '', '/upload-files//images/system/android-archive.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('8ad72a3e245f42fc9cded397a1d114bb', NULL, 'android-call.png', '', '', '/upload-files//images/system/android-call.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('91f17c32fae046788e2b61bbb8e2b37e', NULL, 'android-add.png', '', '', '/upload-files//images/system/android-add.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('968074f2fc984327adc251e80d858310', NULL, 'android-arrow-forward.png', '', '', '/upload-files//images/system/android-arrow-forward.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('970f5eb2283549dbb771c388a0e04304', NULL, 'android-forums.png', '大方', '饿啊', '/upload-files//images/system/android-forums.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('9836ff5b9ae244ae894e3d27f63156fc', NULL, 'icon-social-google-plus.png', 'what', 'the', '/upload-files//images/system/icon-social-google-plus.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('9b090dd13094449f95414904b87f192f', NULL, 'android-sort.png', '', '', '/upload-files/images/system/android-sort.png', NULL, '/upload-files/images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('a4264e076c074880aadc0c3ecb281f0e', NULL, 'android-friends.png', '', '', '/upload-files//images/system/android-friends.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('a6d61e6d6cd9432a86eab9c192a67ffb', NULL, 'android-keypad.png', '', '', '/upload-files//images/system/android-keypad.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 512, 512, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('a9bd6d15bc8f4ccfb8a4650fab4cdebd', NULL, 'android-calendar.png', '', '', '/upload-files//images/info/android-calendar.png', NULL, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', 512, 512, 'info', NULL, NULL);
INSERT INTO `images` VALUES ('b37286494d3d4761b669295dd2ddb8e1', NULL, 'android-checkmark.png', '', '', '/upload-files//images/ckEditor/android-checkmark.png', NULL, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('b372a6a0cbd3418b8442b9dd94091be2', NULL, 'android-alarm.png', '', '', '/upload-files//images/system/android-alarm.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('b89982e7b75449e0a7383de055377ec5', NULL, 'android-settings.png', 'afdsfe', 'feadfsad', '/upload-files//images/system/android-settings.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('bb12125063cc4fc5ae99769887888e3c', NULL, 'android-battery.png', '', '', '/upload-files//images/system/android-battery.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('bbb1fa84ceae476e9ccce1da7ff73f0f', NULL, 'android-clock.png', '', '', '/upload-files//images/case/android-clock.png', NULL, '/upload-files//images/case/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/case/', 512, 512, 'case', NULL, NULL);
INSERT INTO `images` VALUES ('bf23284219d841dd9d52898685c712a0', NULL, 'android-earth.png', '', '', '/upload-files//images/system/android-earth.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('c260ab68a1164f15a85b56f63abda48f', NULL, 'android-remove.png', '', '', '/upload-files//images/other/android-remove.png', NULL, '/upload-files//images/other/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/other/', 512, 512, 'other', NULL, NULL);
INSERT INTO `images` VALUES ('dec229f715dd422bafee6ea89c201b20', NULL, 'android-more.png', '', '', '/upload-files//images/ckEditor/android-more.png', NULL, '/upload-files//images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('e16aa2531cd4429fa6231d8c70c6e6f5', NULL, 'android-book.png', '', '', '/upload-files//images/system/android-book.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);
INSERT INTO `images` VALUES ('e441f59f46ad4b359de30229052be56c', NULL, 'qays.jpg', '', '', '/upload-files/images/ckEditor/qays.jpg', NULL, '/upload-files/images/ckEditor/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/images/ckEditor/', 0, 0, 'ckEditor', NULL, NULL);
INSERT INTO `images` VALUES ('ec71916f02794e7fb73ce463a605456f', NULL, 'android-sort.png', '', '', '/upload-files//images/info/android-sort.png', NULL, '/upload-files//images/info/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/info/', 0, 0, 'info', NULL, NULL);
INSERT INTO `images` VALUES ('f28ed6581025418793fa11baf5b22ffe', NULL, 'android-share.png', '', '', '/upload-files//images/system/android-share.png', NULL, '/upload-files//images/system/', 'E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files//images/system/', 0, 0, 'system', NULL, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` varbinary(64) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `coverImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `bannerImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `tag` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `seoId` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `page` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `coverImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `bannerImg` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `seoId` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `class1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `class3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seo
-- ----------------------------
DROP TABLE IF EXISTS `seo`;
CREATE TABLE `seo`  (
  `id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `pageTitle` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `value` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `contents` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_table
-- ----------------------------
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dfbdbd0000', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dff9740001', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffa240002', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffabe0003', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffb570004', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffbfa0005', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffc960006', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffd270007', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffdcb0008', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffe480009', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323dffee5000a', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323e073fc000b', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323f2b72b000c', 'dfasfas');
INSERT INTO `test_table` VALUES ('402881eb6323df88016323feb22d000d', 'dfasfas');

SET FOREIGN_KEY_CHECKS = 1;
