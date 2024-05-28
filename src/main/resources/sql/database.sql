-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.16 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for shoe
CREATE DATABASE IF NOT EXISTS `shoe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shoe`;

-- Dumping structure for table shoe.bien_the_giay
CREATE TABLE IF NOT EXISTS `bien_the_giay` (
  `id_bien_the_giay` int(11) NOT NULL AUTO_INCREMENT,
  `gia_ban` decimal(38,2) DEFAULT NULL,
  `gia_nhap` decimal(38,2) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ma` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  `id_giay` int(11) DEFAULT NULL,
  `id_kich_thuoc` int(11) DEFAULT NULL,
  `id_mau_sac` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bien_the_giay`),
  KEY `FK3p09daj604sfawd68n8e0tt` (`id_giay`),
  KEY `FKs21dfvbkeqdvmu8scs6flbnea` (`id_kich_thuoc`),
  KEY `FKfuymec0spwosimphlsfmxpt7w` (`id_mau_sac`),
  CONSTRAINT `FK3p09daj604sfawd68n8e0tt` FOREIGN KEY (`id_giay`) REFERENCES `giay` (`id_giay`),
  CONSTRAINT `FKfuymec0spwosimphlsfmxpt7w` FOREIGN KEY (`id_mau_sac`) REFERENCES `mau_sac` (`id_mau_sac`),
  CONSTRAINT `FKs21dfvbkeqdvmu8scs6flbnea` FOREIGN KEY (`id_kich_thuoc`) REFERENCES `kich_thuoc` (`id_kich_thuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`bien_the_giay` (`gia_ban`, `gia_nhap`, `ma`, `trang_thai`, `id_giay`, `id_kich_thuoc`, `id_mau_sac`) VALUES ('3000000', '2700000', 'BT1', '0', '1', '1', '1');
INSERT INTO `shoe`.`bien_the_giay` (`gia_ban`, `gia_nhap`, `ma`, `trang_thai`, `id_giay`, `id_kich_thuoc`, `id_mau_sac`) VALUES ('3000000', '2700000', 'BT2', '0', '2', '1', '2');
INSERT INTO `shoe`.`bien_the_giay` (`gia_ban`, `gia_nhap`, `ma`, `trang_thai`, `id_giay`, `id_kich_thuoc`, `id_mau_sac`) VALUES ('3000000', '2700000', 'BT3', '0', '1', '1', '2');

-- Data exporting was unselected.

-- Dumping structure for table shoe.chat_lieu
CREATE TABLE IF NOT EXISTS `chat_lieu` (
  `id_day_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_day_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data

INSERT INTO `shoe`.`chat_lieu` (`ma`, `ten`, `trang_thai`) VALUES ('CL1', 'da', '0');
INSERT INTO `shoe`.`chat_lieu` (`ma`, `ten`, `trang_thai`) VALUES ('CL2', 'da bò', '0');
INSERT INTO `shoe`.`chat_lieu` (`ma`, `ten`, `trang_thai`) VALUES ('CL3', 'da tổng hợp', '0');
INSERT INTO `shoe`.`chat_lieu` (`ma`, `ten`, `trang_thai`) VALUES ('CL3', 'da cá sấu', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.co_giay
CREATE TABLE IF NOT EXISTS `co_giay` (
  `id_co_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_co_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`co_giay` (`ma`, `ten`, `trang_thai`) VALUES ('C1', 'cổ thấp', '0');
INSERT INTO `shoe`.`co_giay` (`ma`, `ten`, `trang_thai`) VALUES ('C2', 'cổ cao', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.day_giay
CREATE TABLE IF NOT EXISTS `day_giay` (
  `id_day_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mau_sac` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_day_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`day_giay` (`ma`, `mau_sac`, `ngay_tao`, `ten`, `trang_thai`) VALUES ('DG1', 'trắng', '2024-05-28', 'dây giày nike trắng', '0');
INSERT INTO `shoe`.`day_giay` (`ma`, `mau_sac`, `ngay_tao`, `ten`, `trang_thai`) VALUES ('DG2', 'đen', '2024-05-28', 'dây giày nike', '0');
INSERT INTO `shoe`.`day_giay` (`ma`, `mau_sac`, `ngay_tao`, `ten`, `trang_thai`) VALUES ('DG3', 'Xanh', '2024-05-28', 'dây giày adidas', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.de_giay
CREATE TABLE IF NOT EXISTS `de_giay` (
  `id_de_giay` int(11) NOT NULL AUTO_INCREMENT,
  `chat_lieu` varchar(255) DEFAULT NULL,
  `ma` varchar(255) DEFAULT NULL,
  `mau_sac` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_de_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`de_giay` (`chat_lieu`, `ma`, `mau_sac`, `ten`, `trang_thai`) VALUES ('nhựa', 'D2', 'trắng', 'đế nhựa', '0');
INSERT INTO `shoe`.`de_giay` (`chat_lieu`, `ma`, `mau_sac`, `ten`, `trang_thai`) VALUES ('cao su', 'D1', 'trắng', 'đế cao su', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.giay
CREATE TABLE IF NOT EXISTS `giay` (
  `id_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_san_xuat` date DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  `id_chat_lieu` int(11) DEFAULT NULL,
  `id_co_giay` int(11) DEFAULT NULL,
  `id_day_giay` int(11) DEFAULT NULL,
  `id_de_giay` int(11) DEFAULT NULL,
  `id_lot_giay` int(11) DEFAULT NULL,
  `id_mui_giay` int(11) DEFAULT NULL,
  `id_thuong_hieu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_giay`),
  KEY `FKouje7irxtafngfarws1hfn5ge` (`id_chat_lieu`),
  KEY `FKqs95hw55fd7kwvf97vdvl57bq` (`id_co_giay`),
  KEY `FKe16ex9nev3ab62nj6a7ixosnm` (`id_day_giay`),
  KEY `FKssaiv44by85b3ynmyuvysgv35` (`id_de_giay`),
  KEY `FKrjnnfemv3vtkxgr1kenwm5cnh` (`id_lot_giay`),
  KEY `FK655fr1908kubfbx66ci547qrp` (`id_mui_giay`),
  KEY `FK2culisjkr80ppgi7oyaou5ru8` (`id_thuong_hieu`),
  CONSTRAINT `FK2culisjkr80ppgi7oyaou5ru8` FOREIGN KEY (`id_thuong_hieu`) REFERENCES `thuong_hieu` (`id_thuong_hieu`),
  CONSTRAINT `FK655fr1908kubfbx66ci547qrp` FOREIGN KEY (`id_mui_giay`) REFERENCES `mui_giay` (`id_mui_giay`),
  CONSTRAINT `FKe16ex9nev3ab62nj6a7ixosnm` FOREIGN KEY (`id_day_giay`) REFERENCES `day_giay` (`id_day_giay`),
  CONSTRAINT `FKouje7irxtafngfarws1hfn5ge` FOREIGN KEY (`id_chat_lieu`) REFERENCES `chat_lieu` (`id_day_giay`),
  CONSTRAINT `FKqs95hw55fd7kwvf97vdvl57bq` FOREIGN KEY (`id_co_giay`) REFERENCES `co_giay` (`id_co_giay`),
  CONSTRAINT `FKrjnnfemv3vtkxgr1kenwm5cnh` FOREIGN KEY (`id_lot_giay`) REFERENCES `lot_giay` (`id_lot_giay`),
  CONSTRAINT `FKssaiv44by85b3ynmyuvysgv35` FOREIGN KEY (`id_de_giay`) REFERENCES `de_giay` (`id_de_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`giay` (`ma`, `ngay_san_xuat`, `so_luong`, `ten`, `trang_thai`, `id_chat_lieu`, `id_co_giay`, `id_day_giay`, `id_de_giay`, `id_lot_giay`, `id_mui_giay`, `id_thuong_hieu`) VALUES ('G1', '2024-05-28', '50', 'nike force one', '0', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `shoe`.`giay` (`ma`, `ngay_san_xuat`, `so_luong`, `ten`, `trang_thai`, `id_chat_lieu`, `id_co_giay`, `id_day_giay`, `id_de_giay`, `id_lot_giay`, `id_mui_giay`, `id_thuong_hieu`) VALUES ('G2', '2024-05-28', '50', 'nike force one hight', '0', '1', '2', '1', '1', '1', '1', '1');
INSERT INTO `shoe`.`giay` (`ma`, `ngay_san_xuat`, `so_luong`, `ten`, `trang_thai`, `id_chat_lieu`, `id_co_giay`, `id_day_giay`, `id_de_giay`, `id_lot_giay`, `id_mui_giay`, `id_thuong_hieu`) VALUES ('G3', '2024-05-28', '50', 'adidas', '0', '1', '1', '2', '1', '2', '1', '2');
INSERT INTO `shoe`.`giay` (`ma`, `ngay_san_xuat`, `so_luong`, `ten`, `trang_thai`, `id_chat_lieu`, `id_co_giay`, `id_day_giay`, `id_de_giay`, `id_lot_giay`, `id_mui_giay`, `id_thuong_hieu`) VALUES ('G4', '2024-05-28', '30', 'jordan hight full while', '0', '3', '2', '1', '1', '3', '1', '3');

-- Data exporting was unselected.

-- Dumping structure for table shoe.gio_hang
CREATE TABLE IF NOT EXISTS `gio_hang` (
  `id_gio_hang` bigint(20) NOT NULL AUTO_INCREMENT,
  `trang_thai` int(11) DEFAULT '0',
  `id_giay` int(11) DEFAULT NULL,
  `id_khach_hang` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_gio_hang`),
  KEY `FKifvj9rd364jv3w261wu1s659y` (`id_giay`),
  KEY `FK6c8iirgeg8qcwpq1oa9noxshw` (`id_khach_hang`),
  CONSTRAINT `FK6c8iirgeg8qcwpq1oa9noxshw` FOREIGN KEY (`id_khach_hang`) REFERENCES `khach_hang` (`id_khach_hang`),
  CONSTRAINT `FKifvj9rd364jv3w261wu1s659y` FOREIGN KEY (`id_giay`) REFERENCES `giay` (`id_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.hash_tag
CREATE TABLE IF NOT EXISTS `hash_tag` (
  `id_hash_tag` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_hash_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.hash_tag_chi_tiet
CREATE TABLE IF NOT EXISTS `hash_tag_chi_tiet` (
  `id_hash_tag_chi_tiet` int(11) NOT NULL AUTO_INCREMENT,
  `ngay_tao` date DEFAULT NULL,
  `id_giay` int(11) DEFAULT NULL,
  `id_hash_tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_hash_tag_chi_tiet`),
  KEY `FKm9fo8pt3vcna1edrh2r93gvd8` (`id_giay`),
  KEY `FK7d7pf4cordq628l2hs2j5bjbi` (`id_hash_tag`),
  CONSTRAINT `FK7d7pf4cordq628l2hs2j5bjbi` FOREIGN KEY (`id_hash_tag`) REFERENCES `hash_tag` (`id_hash_tag`),
  CONSTRAINT `FKm9fo8pt3vcna1edrh2r93gvd8` FOREIGN KEY (`id_giay`) REFERENCES `giay` (`id_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.hinh_anh
CREATE TABLE IF NOT EXISTS `hinh_anh` (
  `id_hinh_anh` int(11) NOT NULL AUTO_INCREMENT,
  `base64_img` text,
  `uu_tien` int(11) DEFAULT NULL,
  `id_giay` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_hinh_anh`),
  KEY `FK311nmjjx49nvqdit0pg7hffax` (`id_giay`),
  CONSTRAINT `FK311nmjjx49nvqdit0pg7hffax` FOREIGN KEY (`id_giay`) REFERENCES `giay` (`id_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.hoa_don
CREATE TABLE IF NOT EXISTS `hoa_don` (
  `id_hoa_don` bigint(20) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) NOT NULL,
  `kieu_thanh_toan` int(11) DEFAULT NULL,
  `ma_hoa_don` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_giao` datetime(6) DEFAULT NULL,
  `ngay_thanh_toan` datetime(6) DEFAULT NULL,
  `payment_amount` decimal(38,2) DEFAULT NULL,
  `phi_van_chuyen` decimal(10,0) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  `id_khach_hang` bigint(20) DEFAULT NULL,
  `id_nhan_vien` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_hoa_don`),
  KEY `FKrygimdf5nr1g2t6u03gvtr1te` (`id_khach_hang`),
  KEY `FKkuxkrkgq8yftm4d8d7o0w6nbv` (`id_nhan_vien`),
  CONSTRAINT `FKkuxkrkgq8yftm4d8d7o0w6nbv` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhan_vien` (`id_nhan_vien`),
  CONSTRAINT `FKrygimdf5nr1g2t6u03gvtr1te` FOREIGN KEY (`id_khach_hang`) REFERENCES `khach_hang` (`id_khach_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.hoa_don_chi_tiet
CREATE TABLE IF NOT EXISTS `hoa_don_chi_tiet` (
  `id_hdct` int(11) NOT NULL AUTO_INCREMENT,
  `gia` decimal(38,2) DEFAULT NULL,
  `gia_goc` decimal(38,2) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  `id_bien_the_giay` int(11) DEFAULT NULL,
  `id_hoa_don` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_hdct`),
  KEY `FK6vb5qrxqp8w24r2m722fdupxn` (`id_bien_the_giay`),
  KEY `FK5adopt864mjisuy5xmgmy8iun` (`id_hoa_don`),
  CONSTRAINT `FK5adopt864mjisuy5xmgmy8iun` FOREIGN KEY (`id_hoa_don`) REFERENCES `hoa_don` (`id_hoa_don`),
  CONSTRAINT `FK6vb5qrxqp8w24r2m722fdupxn` FOREIGN KEY (`id_bien_the_giay`) REFERENCES `bien_the_giay` (`id_bien_the_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table shoe.khach_hang
CREATE TABLE IF NOT EXISTS `khach_hang` (
  `id_khach_hang` bigint(20) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `gioi_tinh` int(11) DEFAULT NULL,
  `ho` varchar(50) DEFAULT NULL,
  `ma_kh` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_khach_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`khach_hang` (`dia_chi`, `email`, `gioi_tinh`, `ho`, `ma_kh`, `ngay_sinh`, `sdt`, `ten`, `trang_thai`) VALUES ('Quảng Ninh', 'vuchitrieu2003@gmail.com', '1', 'vũ', 'KH1', '2003-12-30', '0982145133', 'triều', '0');
INSERT INTO `shoe`.`khach_hang` (`dia_chi`, `email`, `gioi_tinh`, `ho`, `ma_kh`, `ngay_sinh`, `sdt`, `ten`, `trang_thai`) VALUES ('Qảng Ninh', 'bienvuchi3103@gmail.com', '1', 'vũ', 'KH2', '2000-03-31', '09999999999', 'biển', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.kich_thuoc
CREATE TABLE IF NOT EXISTS `kich_thuoc` (
  `id_kich_thuoc` int(11) NOT NULL AUTO_INCREMENT,
  `chieu_dai` int(11) DEFAULT NULL,
  `chieu_rong` int(11) DEFAULT NULL,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_kich_thuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`kich_thuoc` (`chieu_dai`, `chieu_rong`, `ma`, `ten`, `trang_thai`) VALUES ('15', '5', 'KT1', 'S', '0');
-- Data exporting was unselected.

-- Dumping structure for table shoe.lot_giay
CREATE TABLE IF NOT EXISTS `lot_giay` (
  `id_lot_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_lot_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`lot_giay` (`ma`, `ten`, `trang_thai`) VALUES ('L1', 'Lót nike', '0');
INSERT INTO `shoe`.`lot_giay` (`ma`, `ten`, `trang_thai`) VALUES ('L2', 'Lót adidas', '0');
INSERT INTO `shoe`.`lot_giay` (`ma`, `ten`, `trang_thai`) VALUES ('L3', 'Lót Jordan', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.mau_sac
CREATE TABLE IF NOT EXISTS `mau_sac` (
  `id_mau_sac` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_mau_sac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`mau_sac` (`ma`, `ten`, `trang_thai`) VALUES ('MS1', 'Đen', '0');
INSERT INTO `shoe`.`mau_sac` (`ma`, `ten`, `trang_thai`) VALUES ('MS2', 'Đỏ', '0');
-- Data exporting was unselected.

-- Dumping structure for table shoe.mui_giay
CREATE TABLE IF NOT EXISTS `mui_giay` (
  `id_mui_giay` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_mui_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`mui_giay` (`ma`, `ten`, `trang_thai`) VALUES ('M1', 'mũi da', '0');
-- Data exporting was unselected.

-- Dumping structure for table shoe.nhan_vien
CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `id_nhan_vien` bigint(20) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(120) NOT NULL,
  `gioi_tinh` int(11) NOT NULL,
  `ho` varchar(50) NOT NULL,
  `ma_nhan_vien` varchar(255) NOT NULL,
  `ngay_sinh` date NOT NULL,
  `sdt` varchar(20) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`nhan_vien` (`dia_chi`, `email`, `gioi_tinh`, `ho`, `ma_nhan_vien`, `ngay_sinh`, `sdt`, `ten`, `trang_thai`) VALUES ('HN', 'gaucute764@gmail.com', '0', 'nguyễn', 'NV1', '2003-10-10', '08989898988', 'A', '0');

-- Data exporting was unselected.

-- Dumping structure for table shoe.thuong_hieu
CREATE TABLE IF NOT EXISTS `thuong_hieu` (
  `id_thuong_hieu` int(11) NOT NULL AUTO_INCREMENT,
  `ma` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT '0',
  PRIMARY KEY (`id_thuong_hieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- data
INSERT INTO `shoe`.`thuong_hieu` (`ma`, `ten`, `trang_thai`) VALUES ('TH1', 'nike', '0');
INSERT INTO `shoe`.`thuong_hieu` (`ma`, `ten`, `trang_thai`) VALUES ('TH2', 'adidas', '0');
INSERT INTO `shoe`.`thuong_hieu` (`ma`, `ten`, `trang_thai`) VALUES ('TH3', 'jordan', '0');

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
