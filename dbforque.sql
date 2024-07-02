/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 8.0.30 : Database - dbforque
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbforque` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `dbforque`;

/*Table structure for table `tblcustomer` */

DROP TABLE IF EXISTS `tblcustomer`;

CREATE TABLE `tblcustomer` (
  `idCustomer` int NOT NULL AUTO_INCREMENT,
  `namaCustomer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nomorHpCustomer` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `emailCustomer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamatCustomer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `passwordCustomer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusAktif` enum('Aktif','Inaktif') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`idCustomer`),
  UNIQUE KEY `UNIQUE` (`nomorHpCustomer`,`emailCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblcustomer` */

insert  into `tblcustomer`(`idCustomer`,`namaCustomer`,`nomorHpCustomer`,`emailCustomer`,`alamatCustomer`,`passwordCustomer`,`statusAktif`) values 
(1,'seto','777777777777','ss@gmail.com','tanggerang','seto69','Aktif'),
(2,'ngawi','888888888888','ha@gmail.com','tanggerang','depok22','Aktif'),
(3,'afif','237647362732','afif@gmail.com','','afif123','Aktif'),
(5,'fahri','827162736212','fahri@gmail.com','','fahri123','Aktif');

/*Table structure for table `tblkaryawan` */

DROP TABLE IF EXISTS `tblkaryawan`;

CREATE TABLE `tblkaryawan` (
  `idKaryawan` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuKaryawan` timestamp NOT NULL,
  `namaKaryawan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nomorHpKaryawan` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `emailKaryawan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jobdeskKaryawan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamatKaryawan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusTerverifikasi` enum('Terverifikasi','Verified') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusAktif` enum('Aktif','Inaktif') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idKaryawan`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMitraKaryawan` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblkaryawan` */

insert  into `tblkaryawan`(`idKaryawan`,`idMitra`,`waktuKaryawan`,`namaKaryawan`,`nomorHpKaryawan`,`emailKaryawan`,`jobdeskKaryawan`,`alamatKaryawan`,`statusTerverifikasi`,`statusAktif`) values 
(2,5,'2024-06-13 23:06:03','jujun','222222222222','r@gmail.com','KASIR','jakarta','Terverifikasi','Aktif'),
(4,5,'2024-06-14 14:40:34','zaki','242424242424','zaki@gmail.com','Operator Mesin','kelapa dua','Terverifikasi','Aktif'),
(6,5,'2024-06-28 00:10:40','asep','928382812834','asep2@gmail.com','Teknisi Mesin','sukabumi','Verified','Aktif');

/*Table structure for table `tblmeja` */

DROP TABLE IF EXISTS `tblmeja`;

CREATE TABLE `tblmeja` (
  `idMeja` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuMeja` timestamp NOT NULL,
  `nomorMeja` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jenisMeja` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsiMeja` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusMeja` enum('Ready','Used') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idMeja`),
  UNIQUE KEY `UNIQUE` (`nomorMeja`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMeja` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblmeja` */

insert  into `tblmeja`(`idMeja`,`idMitra`,`waktuMeja`,`nomorMeja`,`jenisMeja`,`deskripsiMeja`,`statusMeja`) values 
(1,5,'2024-06-13 22:55:56','a23','VIP','untuk 4 orang','Ready'),
(2,5,'2024-06-19 08:32:18','a1','Non Reguler','aman aza','Ready'),
(3,5,'2024-06-19 08:32:33','a2','VIP','aman','Ready'),
(4,5,'2024-06-19 10:44:17','a3','VIP','paket bucin','Ready');

/*Table structure for table `tblmenucoffe` */

DROP TABLE IF EXISTS `tblmenucoffe`;

CREATE TABLE `tblmenucoffe` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuMenu` timestamp NOT NULL,
  `namaMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlahMenu` int NOT NULL,
  `hargaMenu` int NOT NULL,
  `deskripsiMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusMenu` enum('Ready','Sold') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idMenu`),
  UNIQUE KEY `UNIQUE` (`namaMenu`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMenuCoffe` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblmenucoffe` */

insert  into `tblmenucoffe`(`idMenu`,`idMitra`,`waktuMenu`,`namaMenu`,`jumlahMenu`,`hargaMenu`,`deskripsiMenu`,`statusMenu`) values 
(3,5,'2024-06-18 02:35:22','amerikano',2,20000,'paket seto','Ready'),
(4,5,'2024-06-19 10:43:01','kapal api',2,2000,'aman aza','Ready'),
(5,5,'2024-06-26 06:45:01','Espresso',5,12000,'paket melek','Ready'),
(6,5,'2024-06-26 06:45:32','Cappucino+',6,20000,'paket ganteng','Ready'),
(7,5,'2024-06-26 06:46:08','latte art',6,23000,'paket jaksel','Ready');

/*Table structure for table `tblmenumakanan` */

DROP TABLE IF EXISTS `tblmenumakanan`;

CREATE TABLE `tblmenumakanan` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuMenu` timestamp NOT NULL,
  `namaMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlahMenu` int NOT NULL,
  `hargaMenu` int NOT NULL,
  `deskripsiMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusMenu` enum('Ready','Sold') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idMenu`),
  UNIQUE KEY `UNIQUE` (`namaMenu`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMenuMakanan` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblmenumakanan` */

insert  into `tblmenumakanan`(`idMenu`,`idMitra`,`waktuMenu`,`namaMenu`,`jumlahMenu`,`hargaMenu`,`deskripsiMenu`,`statusMenu`) values 
(3,5,'2024-06-14 01:05:34','Nasi Guyang',6,30000,'paket guyang full','Ready'),
(4,5,'2024-06-14 01:07:16','Seblak',4,5000,'mantap slurr','Ready'),
(11,5,'2024-06-14 03:59:12','bakso',2,2000,'aman','Ready'),
(12,5,'2024-06-14 13:29:26','Nasi Zaki',8,20000,'paket zaki','Ready'),
(14,5,'2024-06-16 17:14:57','nasi mantap',2,2000,'paket mantap','Ready');

/*Table structure for table `tblmenunoncoffe` */

DROP TABLE IF EXISTS `tblmenunoncoffe`;

CREATE TABLE `tblmenunoncoffe` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuMenu` timestamp NOT NULL,
  `namaMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlahMenu` int NOT NULL,
  `hargaMenu` int NOT NULL,
  `deskripsiMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusMenu` enum('Ready','Sold') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idMenu`),
  UNIQUE KEY `UNIQUE` (`namaMenu`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMitraNonCoffe` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblmenunoncoffe` */

insert  into `tblmenunoncoffe`(`idMenu`,`idMitra`,`waktuMenu`,`namaMenu`,`jumlahMenu`,`hargaMenu`,`deskripsiMenu`,`statusMenu`) values 
(2,5,'2024-06-14 01:14:39','TEH MANIS',8,5000,'PAKET MANIS','Ready'),
(3,5,'2024-06-14 01:16:33','JUS MANGGA',2,30000,'paket mangga','Ready'),
(4,5,'2024-06-26 06:46:43','Air putih',30,5000,'paket hemat','Ready'),
(5,5,'2024-06-26 06:47:20','Matcha ',24,28000,'paket Matcha sihh','Ready'),
(6,5,'2024-06-26 06:48:03','Jus pete',23,20000,'paket huhaa','Ready'),
(7,5,'2024-06-26 06:48:22','jus naga bonar',23,20000,'paket bonar','Ready');

/*Table structure for table `tblmitra` */

DROP TABLE IF EXISTS `tblmitra`;

CREATE TABLE `tblmitra` (
  `idMitra` int NOT NULL AUTO_INCREMENT,
  `namaMitra` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nomorHpMitra` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `emailMitra` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamatMitra` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `passwordMitra` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusTerverifikasi` enum('Terverifikasi','Verified') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusAktif` enum('Aktif','Inaktif') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idMitra`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblmitra` */

insert  into `tblmitra`(`idMitra`,`namaMitra`,`nomorHpMitra`,`emailMitra`,`alamatMitra`,`passwordMitra`,`statusTerverifikasi`,`statusAktif`) values 
(5,'forque depok','888888888888','s@gmail.com','sawangan123','sawangan','Terverifikasi','Aktif'),
(6,'-','-','-','-','-','Terverifikasi','Inaktif'),
(7,'jaja','33213321232','jaja@gmail.com','','jaja123','Terverifikasi','Aktif'),
(8,'rizky','089539908896','rizky@gmail.com','','iki123','Verified','Aktif');

/*Table structure for table `tblorderbahan` */

DROP TABLE IF EXISTS `tblorderbahan`;

CREATE TABLE `tblorderbahan` (
  `idOrder` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuOrder` timestamp NOT NULL,
  `bahanOrder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ptOrder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsiOrder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `alamatOrder` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlahOrder` int NOT NULL,
  `hargaOrder` int NOT NULL,
  `statusOrder` enum('Diproses','Selesai') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idOrderMitra` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblorderbahan` */

insert  into `tblorderbahan`(`idOrder`,`idMitra`,`waktuOrder`,`bahanOrder`,`ptOrder`,`deskripsiOrder`,`alamatOrder`,`jumlahOrder`,`hargaOrder`,`statusOrder`) values 
(2,5,'2024-06-16 02:26:31','Telur','PT NGAWI','amana za','depok',2,1000,'Selesai'),
(3,5,'2024-06-18 02:36:06','Telur','PT NGAWI','aman','deppok',2,1000,'Selesai'),
(4,5,'2024-06-19 08:42:41','Telur','PT NGAWI','manan','amanan',2,1000,'Selesai'),
(5,5,'2024-06-19 09:15:37','Telur','PT NGAWI','aman','depok',2,1000,'Selesai'),
(6,5,'2024-06-19 09:16:44','Beras','PT RUSDI','aman','depok',100,2000,'Diproses'),
(7,5,'2024-06-19 10:47:32','Telur','PT RUSDI','dipacking dengan aman','jakarta',10,1000,'Diproses');

/*Table structure for table `tblpromo` */

DROP TABLE IF EXISTS `tblpromo`;

CREATE TABLE `tblpromo` (
  `idPromo` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuPromo` timestamp NOT NULL,
  `namaPromo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `namaMenu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jumlahPromo` int NOT NULL,
  `hargaPromo` int NOT NULL,
  `deskripsiPromo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `statusPromo` enum('Ready','Sold') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idPromo`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idPromoMitra` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblpromo` */

insert  into `tblpromo`(`idPromo`,`idMitra`,`waktuPromo`,`namaPromo`,`namaMenu`,`jumlahPromo`,`hargaPromo`,`deskripsiPromo`,`statusPromo`) values 
(10,5,'2024-06-25 05:01:00','promo nasi','Nasi Guyang',3,30000,'promo pake juli','Ready'),
(15,5,'2024-06-25 06:33:53','coffe','amerikano',2,2000,'aman aza','Ready'),
(17,5,'2024-06-25 06:56:31','TEH MANIS','TEH MANIS',45,2000,'paket manis','Ready');

/*Table structure for table `tblsaldomitra` */

DROP TABLE IF EXISTS `tblsaldomitra`;

CREATE TABLE `tblsaldomitra` (
  `idSaldoMitra` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `saldoMitra` int NOT NULL,
  PRIMARY KEY (`idSaldoMitra`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idSaldoMitra` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tblsaldomitra` */

insert  into `tblsaldomitra`(`idSaldoMitra`,`idMitra`,`saldoMitra`) values 
(1,5,312014),
(2,6,4),
(3,7,0),
(4,8,0);

/*Table structure for table `tbltransaksi` */

DROP TABLE IF EXISTS `tbltransaksi`;

CREATE TABLE `tbltransaksi` (
  `idTransaksi` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `waktuTransaksi` timestamp NOT NULL,
  `namaTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `makananTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `coffeTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nonCoffeTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `jumlahMakanan` int DEFAULT NULL,
  `jumlahCoffe` int DEFAULT NULL,
  `jumlahNonCoffe` int DEFAULT NULL,
  `hargaMakanan` int DEFAULT NULL,
  `hargaCoffe` int DEFAULT NULL,
  `hargaNonCoffe` int DEFAULT NULL,
  `promoTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mejaTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsiTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `hargaTransaksi` int NOT NULL,
  `hargaPromo` int DEFAULT NULL,
  `bayarTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `uangTransaksi` int NOT NULL,
  `kembalianTransaksi` int NOT NULL,
  `statusTransaksi` enum('Diproses','Selesai') COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idTransaksi`),
  KEY `KEY` (`idMitra`),
  CONSTRAINT `idMitraTransaksi` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tbltransaksi` */

insert  into `tbltransaksi`(`idTransaksi`,`idMitra`,`waktuTransaksi`,`namaTransaksi`,`makananTransaksi`,`coffeTransaksi`,`nonCoffeTransaksi`,`jumlahMakanan`,`jumlahCoffe`,`jumlahNonCoffe`,`hargaMakanan`,`hargaCoffe`,`hargaNonCoffe`,`promoTransaksi`,`mejaTransaksi`,`deskripsiTransaksi`,`hargaTransaksi`,`hargaPromo`,`bayarTransaksi`,`uangTransaksi`,`kembalianTransaksi`,`statusTransaksi`) values 
(3,5,'2024-06-26 05:03:20','Rizky','Nasi Guyang','amerikano','TEH MANIS',1,1,1,30000,20000,5000,'promo nasi','a23','Pedas, Pakai Gula',25000,NULL,'CASH',0,0,'Selesai'),
(4,5,'2024-06-26 07:00:35','zaki','Nasi Guyang','-','-',2,0,0,60000,0,0,'promo nasi','a23','paket upm',60000,NULL,'DANA',0,0,'Selesai'),
(5,5,'2024-06-27 00:45:55','iki','bakso','-','-',1,0,0,2000,0,0,'-','a3','pedas',2000,NULL,'MANDIRI',0,0,'Selesai'),
(6,5,'2024-06-27 00:46:36','zaki','Seblak','-','-',2,0,0,10000,0,0,'promo pedas','a23','pedas',4000,NULL,'DANA',0,0,'Selesai'),
(7,5,'2024-06-27 01:12:06','iki','Nasi Guyang','-','-',2,0,0,60000,0,0,'promo nasi','a1','pedas',30000,NULL,'CASH',0,0,'Diproses'),
(8,5,'2024-07-02 04:23:39','zaki','nasi mantap','-','TEH MANIS',3,0,6,6000,0,30000,'-','a23','aman',36000,NULL,'OVO',0,0,'Diproses'),
(9,5,'2024-06-28 01:57:29','richard','Nasi Zaki','amerikano','TEH MANIS',1,1,1,20000,20000,5000,'coffe','a3','aman aza',43000,NULL,'MANDIRI',0,0,'Selesai'),
(10,5,'2024-07-02 09:27:11','jujus','Nasi Guyang','amerikano','-',2,1,0,30000,20000,0,'promo nasi','a23','pedas',50000,20000,'CASH',60000,10000,'Diproses');

/*Table structure for table `tbltransaksionline` */

DROP TABLE IF EXISTS `tbltransaksionline`;

CREATE TABLE `tbltransaksionline` (
  `idTransaksi` int NOT NULL AUTO_INCREMENT,
  `idMitra` int NOT NULL,
  `idCustomer` int NOT NULL,
  `waktuTransaksi` timestamp NOT NULL,
  `makananTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `coffeTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nonCoffeTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `jumlahMakanan` int DEFAULT NULL,
  `JumlahCoffe` int DEFAULT NULL,
  `jumlahNonCoffe` int DEFAULT NULL,
  `hargaMakanan` int DEFAULT NULL,
  `hargaCoffe` int DEFAULT NULL,
  `hargaNonCoffe` int DEFAULT NULL,
  `promoTransaksi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mejaTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsiTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hargaTransaksi` int NOT NULL,
  `hargaPromo` int DEFAULT NULL,
  `bayarTransaksi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `uangTransaksi` int NOT NULL,
  `kembalianTransaksi` int NOT NULL,
  `statusTransaksi` enum('Diproses','Selesai') COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idTransaksi`),
  KEY `idCustomerTransaksiOnline` (`idCustomer`),
  KEY `KEY` (`idMitra`,`idCustomer`),
  CONSTRAINT `idCustomerTransaksiOnline` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idMitrTransaksiOnline` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `tbltransaksionline` */

insert  into `tbltransaksionline`(`idTransaksi`,`idMitra`,`idCustomer`,`waktuTransaksi`,`makananTransaksi`,`coffeTransaksi`,`nonCoffeTransaksi`,`jumlahMakanan`,`JumlahCoffe`,`jumlahNonCoffe`,`hargaMakanan`,`hargaCoffe`,`hargaNonCoffe`,`promoTransaksi`,`mejaTransaksi`,`deskripsiTransaksi`,`hargaTransaksi`,`hargaPromo`,`bayarTransaksi`,`uangTransaksi`,`kembalianTransaksi`,`statusTransaksi`) values 
(1,5,1,'2024-07-02 12:58:41','Nasi Guyang','amerikano','TEH MANIS',1,1,1,30000,20000,5000,'promo nasi','a23','adsads',25000,30000,'CASH',30000,5000,'Diproses'),
(2,5,1,'2024-07-02 15:15:55','Nasi Guyang','amerikano','TEH MANIS',1,1,1,30000,20000,5000,'promo nasi','a3','aman aza',25000,30000,'CASH',30000,5000,'Diproses'),
(3,5,1,'2024-07-02 12:24:44','Nasi Guyang','amerikano','TEH MANIS',1,1,1,30000,20000,5000,'promo nasi','a23','sadasd',25000,30000,'CASH',30000,5000,'Diproses');

/* Trigger structure for table `tblmitra` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `insertSaldoMitra` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `insertSaldoMitra` AFTER INSERT ON `tblmitra` FOR EACH ROW BEGIN
    
    INSERT INTO `dbforque`.`tblsaldomitra` VALUES(NULL, NEW.idMitra, 0);
    END */$$


DELIMITER ;

/*Table structure for table `vwallcustomer` */

DROP TABLE IF EXISTS `vwallcustomer`;

/*!50001 DROP VIEW IF EXISTS `vwallcustomer` */;
/*!50001 DROP TABLE IF EXISTS `vwallcustomer` */;

/*!50001 CREATE TABLE  `vwallcustomer`(
 `idCustomer` int ,
 `namaCustomer` varchar(255) ,
 `nomorHpCustomer` char(12) ,
 `emailCustomer` varchar(255) ,
 `alamatCustomer` varchar(255) ,
 `passwordCustomer` varchar(255) ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vwallmeja` */

DROP TABLE IF EXISTS `vwallmeja`;

/*!50001 DROP VIEW IF EXISTS `vwallmeja` */;
/*!50001 DROP TABLE IF EXISTS `vwallmeja` */;

/*!50001 CREATE TABLE  `vwallmeja`(
 `idMeja` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuMeja` timestamp ,
 `nomorMeja` varchar(255) ,
 `jenisMeja` varchar(255) ,
 `deskripsiMeja` varchar(255) ,
 `statusMeja` enum('Ready','Used') 
)*/;

/*Table structure for table `vwallmejaready` */

DROP TABLE IF EXISTS `vwallmejaready`;

/*!50001 DROP VIEW IF EXISTS `vwallmejaready` */;
/*!50001 DROP TABLE IF EXISTS `vwallmejaready` */;

/*!50001 CREATE TABLE  `vwallmejaready`(
 `idMeja` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuMeja` timestamp ,
 `nomorMeja` varchar(255) ,
 `jenisMeja` varchar(255) ,
 `deskripsiMeja` varchar(255) ,
 `statusMeja` enum('Ready','Used') 
)*/;

/*Table structure for table `vwallmenucoffe` */

DROP TABLE IF EXISTS `vwallmenucoffe`;

/*!50001 DROP VIEW IF EXISTS `vwallmenucoffe` */;
/*!50001 DROP TABLE IF EXISTS `vwallmenucoffe` */;

/*!50001 CREATE TABLE  `vwallmenucoffe`(
 `idMenu` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuMenu` timestamp ,
 `namaMenu` varchar(255) ,
 `jumlahMenu` int ,
 `hargaMenu` int ,
 `deskripsiMenu` varchar(255) ,
 `statusMenu` enum('Ready','Sold') 
)*/;

/*Table structure for table `vwallmenumakanan` */

DROP TABLE IF EXISTS `vwallmenumakanan`;

/*!50001 DROP VIEW IF EXISTS `vwallmenumakanan` */;
/*!50001 DROP TABLE IF EXISTS `vwallmenumakanan` */;

/*!50001 CREATE TABLE  `vwallmenumakanan`(
 `idMenu` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuMenu` timestamp ,
 `namaMenu` varchar(255) ,
 `jumlahMenu` int ,
 `hargaMenu` int ,
 `deskripsiMenu` varchar(255) ,
 `statusMenu` enum('Ready','Sold') 
)*/;

/*Table structure for table `vwallmenunoncoffe` */

DROP TABLE IF EXISTS `vwallmenunoncoffe`;

/*!50001 DROP VIEW IF EXISTS `vwallmenunoncoffe` */;
/*!50001 DROP TABLE IF EXISTS `vwallmenunoncoffe` */;

/*!50001 CREATE TABLE  `vwallmenunoncoffe`(
 `idMenu` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuMenu` timestamp ,
 `namaMenu` varchar(255) ,
 `jumlahMenu` int ,
 `hargaMenu` int ,
 `deskripsiMenu` varchar(255) ,
 `statusMenu` enum('Ready','Sold') 
)*/;

/*Table structure for table `vwallmitra` */

DROP TABLE IF EXISTS `vwallmitra`;

/*!50001 DROP VIEW IF EXISTS `vwallmitra` */;
/*!50001 DROP TABLE IF EXISTS `vwallmitra` */;

/*!50001 CREATE TABLE  `vwallmitra`(
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `nomorHpMitra` char(12) ,
 `emailMitra` varchar(255) ,
 `alamatMitra` varchar(255) ,
 `passwordMitra` varchar(255) ,
 `statusTerverifikasi` enum('Terverifikasi','Verified') ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vwallpromo` */

DROP TABLE IF EXISTS `vwallpromo`;

/*!50001 DROP VIEW IF EXISTS `vwallpromo` */;
/*!50001 DROP TABLE IF EXISTS `vwallpromo` */;

/*!50001 CREATE TABLE  `vwallpromo`(
 `idPromo` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuPromo` timestamp ,
 `namaPromo` varchar(255) ,
 `namaMenu` varchar(255) ,
 `jumlahPromo` int ,
 `hargaPromo` int ,
 `deskripsiPromo` varchar(255) ,
 `statusPromo` enum('Ready','Sold') 
)*/;

/*Table structure for table `vwkaryawanterverifikasi` */

DROP TABLE IF EXISTS `vwkaryawanterverifikasi`;

/*!50001 DROP VIEW IF EXISTS `vwkaryawanterverifikasi` */;
/*!50001 DROP TABLE IF EXISTS `vwkaryawanterverifikasi` */;

/*!50001 CREATE TABLE  `vwkaryawanterverifikasi`(
 `idKaryawan` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuKaryawan` timestamp ,
 `namaKaryawan` varchar(255) ,
 `nomorHpKaryawan` char(12) ,
 `emailKaryawan` varchar(255) ,
 `jobdeskKaryawan` varchar(255) ,
 `alamatKaryawan` varchar(255) ,
 `statusTerverifikasi` enum('Terverifikasi','Verified') ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vwkaryawanverified` */

DROP TABLE IF EXISTS `vwkaryawanverified`;

/*!50001 DROP VIEW IF EXISTS `vwkaryawanverified` */;
/*!50001 DROP TABLE IF EXISTS `vwkaryawanverified` */;

/*!50001 CREATE TABLE  `vwkaryawanverified`(
 `idKaryawan` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuKaryawan` timestamp ,
 `namaKaryawan` varchar(255) ,
 `nomorHpKaryawan` char(12) ,
 `emailKaryawan` varchar(255) ,
 `jobdeskKaryawan` varchar(255) ,
 `alamatKaryawan` varchar(255) ,
 `statusTerverifikasi` enum('Terverifikasi','Verified') ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vwmitraterverifikasi` */

DROP TABLE IF EXISTS `vwmitraterverifikasi`;

/*!50001 DROP VIEW IF EXISTS `vwmitraterverifikasi` */;
/*!50001 DROP TABLE IF EXISTS `vwmitraterverifikasi` */;

/*!50001 CREATE TABLE  `vwmitraterverifikasi`(
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `nomorHpMitra` char(12) ,
 `emailMitra` varchar(255) ,
 `alamatMitra` varchar(255) ,
 `passwordMitra` varchar(255) ,
 `statusTerverifikasi` enum('Terverifikasi','Verified') ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vwmitraverified` */

DROP TABLE IF EXISTS `vwmitraverified`;

/*!50001 DROP VIEW IF EXISTS `vwmitraverified` */;
/*!50001 DROP TABLE IF EXISTS `vwmitraverified` */;

/*!50001 CREATE TABLE  `vwmitraverified`(
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `nomorHpMitra` char(12) ,
 `emailMitra` varchar(255) ,
 `alamatMitra` varchar(255) ,
 `passwordMitra` varchar(255) ,
 `statusTerverifikasi` enum('Terverifikasi','Verified') ,
 `statusAktif` enum('Aktif','Inaktif') 
)*/;

/*Table structure for table `vworderbahandiproses` */

DROP TABLE IF EXISTS `vworderbahandiproses`;

/*!50001 DROP VIEW IF EXISTS `vworderbahandiproses` */;
/*!50001 DROP TABLE IF EXISTS `vworderbahandiproses` */;

/*!50001 CREATE TABLE  `vworderbahandiproses`(
 `idOrder` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuOrder` timestamp ,
 `bahanOrder` varchar(255) ,
 `ptOrder` varchar(255) ,
 `deskripsiOrder` varchar(255) ,
 `alamatOrder` varchar(255) ,
 `jumlahOrder` int ,
 `hargaOrder` int ,
 `statusOrder` enum('Diproses','Selesai') 
)*/;

/*Table structure for table `vworderbahanselesai` */

DROP TABLE IF EXISTS `vworderbahanselesai`;

/*!50001 DROP VIEW IF EXISTS `vworderbahanselesai` */;
/*!50001 DROP TABLE IF EXISTS `vworderbahanselesai` */;

/*!50001 CREATE TABLE  `vworderbahanselesai`(
 `idOrder` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuOrder` timestamp ,
 `bahanOrder` varchar(255) ,
 `ptOrder` varchar(255) ,
 `deskripsiOrder` varchar(255) ,
 `alamatOrder` varchar(255) ,
 `jumlahOrder` int ,
 `hargaOrder` int ,
 `statusOrder` enum('Diproses','Selesai') 
)*/;

/*Table structure for table `vwsaldomitra` */

DROP TABLE IF EXISTS `vwsaldomitra`;

/*!50001 DROP VIEW IF EXISTS `vwsaldomitra` */;
/*!50001 DROP TABLE IF EXISTS `vwsaldomitra` */;

/*!50001 CREATE TABLE  `vwsaldomitra`(
 `idSaldoMitra` int ,
 `idMitra` int ,
 `saldoMitra` int 
)*/;

/*Table structure for table `vwtransaksidiproses` */

DROP TABLE IF EXISTS `vwtransaksidiproses`;

/*!50001 DROP VIEW IF EXISTS `vwtransaksidiproses` */;
/*!50001 DROP TABLE IF EXISTS `vwtransaksidiproses` */;

/*!50001 CREATE TABLE  `vwtransaksidiproses`(
 `idTransaksi` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuTransaksi` timestamp ,
 `namaTransaksi` varchar(255) ,
 `makananTransaksi` varchar(255) ,
 `coffeTransaksi` varchar(255) ,
 `nonCoffeTransaksi` varchar(255) ,
 `jumlahMakanan` int ,
 `jumlahCoffe` int ,
 `jumlahNonCoffe` int ,
 `hargaMakanan` int ,
 `hargaCoffe` int ,
 `hargaNonCoffe` int ,
 `promoTransaksi` varchar(255) ,
 `mejaTransaksi` varchar(255) ,
 `deskripsiTransaksi` varchar(255) ,
 `hargaTransaksi` int ,
 `hargaPromo` int ,
 `bayarTransaksi` varchar(255) ,
 `uangTransaksi` int ,
 `kembalianTransaksi` int ,
 `statusTransaksi` enum('Diproses','Selesai') 
)*/;

/*Table structure for table `vwtransaksionlinediproses` */

DROP TABLE IF EXISTS `vwtransaksionlinediproses`;

/*!50001 DROP VIEW IF EXISTS `vwtransaksionlinediproses` */;
/*!50001 DROP TABLE IF EXISTS `vwtransaksionlinediproses` */;

/*!50001 CREATE TABLE  `vwtransaksionlinediproses`(
 `idTransaksi` int ,
 `idMitra` int ,
 `idCustomer` int ,
 `namaMitra` varchar(255) ,
 `namaCustomer` varchar(255) ,
 `waktuTransaksi` timestamp ,
 `makananTransaksi` varchar(255) ,
 `coffeTransaksi` varchar(255) ,
 `nonCoffeTransaksi` varchar(255) ,
 `jumlahMakanan` int ,
 `JumlahCoffe` int ,
 `jumlahNonCoffe` int ,
 `hargaMakanan` int ,
 `hargaCoffe` int ,
 `hargaNonCoffe` int ,
 `promoTransaksi` varchar(255) ,
 `mejaTransaksi` varchar(255) ,
 `deskripsiTransaksi` varchar(255) ,
 `hargaTransaksi` int ,
 `hargaPromo` int ,
 `bayarTransaksi` varchar(255) ,
 `uangTransaksi` int ,
 `kembalianTransaksi` int ,
 `statusTransaksi` enum('Diproses','Selesai') 
)*/;

/*Table structure for table `vwtransaksionlineselesai` */

DROP TABLE IF EXISTS `vwtransaksionlineselesai`;

/*!50001 DROP VIEW IF EXISTS `vwtransaksionlineselesai` */;
/*!50001 DROP TABLE IF EXISTS `vwtransaksionlineselesai` */;

/*!50001 CREATE TABLE  `vwtransaksionlineselesai`(
 `idTransaksi` int ,
 `idMitra` int ,
 `idCustomer` int ,
 `namaMitra` varchar(255) ,
 `namaCustomer` varchar(255) ,
 `waktuTransaksi` timestamp ,
 `makananTransaksi` varchar(255) ,
 `coffeTransaksi` varchar(255) ,
 `nonCoffeTransaksi` varchar(255) ,
 `jumlahMakanan` int ,
 `JumlahCoffe` int ,
 `jumlahNonCoffe` int ,
 `hargaMakanan` int ,
 `hargaCoffe` int ,
 `hargaNonCoffe` int ,
 `promoTransaksi` varchar(255) ,
 `mejaTransaksi` varchar(255) ,
 `deskripsiTransaksi` varchar(255) ,
 `hargaTransaksi` int ,
 `hargaPromo` int ,
 `bayarTransaksi` varchar(255) ,
 `uangTransaksi` int ,
 `kembalianTransaksi` int ,
 `statusTransaksi` enum('Diproses','Selesai') 
)*/;

/*Table structure for table `vwtransaksiselesai` */

DROP TABLE IF EXISTS `vwtransaksiselesai`;

/*!50001 DROP VIEW IF EXISTS `vwtransaksiselesai` */;
/*!50001 DROP TABLE IF EXISTS `vwtransaksiselesai` */;

/*!50001 CREATE TABLE  `vwtransaksiselesai`(
 `idTransaksi` int ,
 `idMitra` int ,
 `namaMitra` varchar(255) ,
 `waktuTransaksi` timestamp ,
 `namaTransaksi` varchar(255) ,
 `makananTransaksi` varchar(255) ,
 `coffeTransaksi` varchar(255) ,
 `nonCoffeTransaksi` varchar(255) ,
 `jumlahMakanan` int ,
 `jumlahCoffe` int ,
 `jumlahNonCoffe` int ,
 `hargaMakanan` int ,
 `hargaCoffe` int ,
 `hargaNonCoffe` int ,
 `promoTransaksi` varchar(255) ,
 `mejaTransaksi` varchar(255) ,
 `deskripsiTransaksi` varchar(255) ,
 `hargaTransaksi` int ,
 `hargaPromo` int ,
 `bayarTransaksi` varchar(255) ,
 `uangTransaksi` int ,
 `kembalianTransaksi` int ,
 `statusTransaksi` enum('Diproses','Selesai') 
)*/;

/*View structure for view vwallcustomer */

/*!50001 DROP TABLE IF EXISTS `vwallcustomer` */;
/*!50001 DROP VIEW IF EXISTS `vwallcustomer` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallcustomer` AS select `tblcustomer`.`idCustomer` AS `idCustomer`,`tblcustomer`.`namaCustomer` AS `namaCustomer`,`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`tblcustomer`.`emailCustomer` AS `emailCustomer`,`tblcustomer`.`alamatCustomer` AS `alamatCustomer`,`tblcustomer`.`passwordCustomer` AS `passwordCustomer`,`tblcustomer`.`statusAktif` AS `statusAktif` from `tblcustomer` */;

/*View structure for view vwallmeja */

/*!50001 DROP TABLE IF EXISTS `vwallmeja` */;
/*!50001 DROP VIEW IF EXISTS `vwallmeja` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmeja` AS select `tblmeja`.`idMeja` AS `idMeja`,`tblmeja`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmeja`.`waktuMeja` AS `waktuMeja`,`tblmeja`.`nomorMeja` AS `nomorMeja`,`tblmeja`.`jenisMeja` AS `jenisMeja`,`tblmeja`.`deskripsiMeja` AS `deskripsiMeja`,`tblmeja`.`statusMeja` AS `statusMeja` from (`tblmeja` join `tblmitra` on((`tblmeja`.`idMitra` = `tblmitra`.`idMitra`))) */;

/*View structure for view vwallmejaready */

/*!50001 DROP TABLE IF EXISTS `vwallmejaready` */;
/*!50001 DROP VIEW IF EXISTS `vwallmejaready` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmejaready` AS select `tblmeja`.`idMeja` AS `idMeja`,`tblmeja`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmeja`.`waktuMeja` AS `waktuMeja`,`tblmeja`.`nomorMeja` AS `nomorMeja`,`tblmeja`.`jenisMeja` AS `jenisMeja`,`tblmeja`.`deskripsiMeja` AS `deskripsiMeja`,`tblmeja`.`statusMeja` AS `statusMeja` from (`tblmeja` join `tblmitra` on((`tblmeja`.`idMitra` = `tblmitra`.`idMitra`))) where (`tblmeja`.`statusMeja` = 'Ready') */;

/*View structure for view vwallmenucoffe */

/*!50001 DROP TABLE IF EXISTS `vwallmenucoffe` */;
/*!50001 DROP VIEW IF EXISTS `vwallmenucoffe` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmenucoffe` AS select `tblmenucoffe`.`idMenu` AS `idMenu`,`tblmenucoffe`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmenucoffe`.`waktuMenu` AS `waktuMenu`,`tblmenucoffe`.`namaMenu` AS `namaMenu`,`tblmenucoffe`.`jumlahMenu` AS `jumlahMenu`,`tblmenucoffe`.`hargaMenu` AS `hargaMenu`,`tblmenucoffe`.`deskripsiMenu` AS `deskripsiMenu`,`tblmenucoffe`.`statusMenu` AS `statusMenu` from (`tblmenucoffe` join `tblmitra` on((`tblmenucoffe`.`idMitra` = `tblmitra`.`idMitra`))) */;

/*View structure for view vwallmenumakanan */

/*!50001 DROP TABLE IF EXISTS `vwallmenumakanan` */;
/*!50001 DROP VIEW IF EXISTS `vwallmenumakanan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmenumakanan` AS select `tblmenumakanan`.`idMenu` AS `idMenu`,`tblmenumakanan`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmenumakanan`.`waktuMenu` AS `waktuMenu`,`tblmenumakanan`.`namaMenu` AS `namaMenu`,`tblmenumakanan`.`jumlahMenu` AS `jumlahMenu`,`tblmenumakanan`.`hargaMenu` AS `hargaMenu`,`tblmenumakanan`.`deskripsiMenu` AS `deskripsiMenu`,`tblmenumakanan`.`statusMenu` AS `statusMenu` from (`tblmenumakanan` join `tblmitra` on((`tblmenumakanan`.`idMitra` = `tblmitra`.`idMitra`))) */;

/*View structure for view vwallmenunoncoffe */

/*!50001 DROP TABLE IF EXISTS `vwallmenunoncoffe` */;
/*!50001 DROP VIEW IF EXISTS `vwallmenunoncoffe` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmenunoncoffe` AS select `tblmenunoncoffe`.`idMenu` AS `idMenu`,`tblmenunoncoffe`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmenunoncoffe`.`waktuMenu` AS `waktuMenu`,`tblmenunoncoffe`.`namaMenu` AS `namaMenu`,`tblmenunoncoffe`.`jumlahMenu` AS `jumlahMenu`,`tblmenunoncoffe`.`hargaMenu` AS `hargaMenu`,`tblmenunoncoffe`.`deskripsiMenu` AS `deskripsiMenu`,`tblmenunoncoffe`.`statusMenu` AS `statusMenu` from (`tblmenunoncoffe` join `tblmitra` on((`tblmenunoncoffe`.`idMitra` = `tblmitra`.`idMitra`))) */;

/*View structure for view vwallmitra */

/*!50001 DROP TABLE IF EXISTS `vwallmitra` */;
/*!50001 DROP VIEW IF EXISTS `vwallmitra` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmitra` AS select `tblmitra`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmitra`.`nomorHpMitra` AS `nomorHpMitra`,`tblmitra`.`emailMitra` AS `emailMitra`,`tblmitra`.`alamatMitra` AS `alamatMitra`,`tblmitra`.`passwordMitra` AS `passwordMitra`,`tblmitra`.`statusTerverifikasi` AS `statusTerverifikasi`,`tblmitra`.`statusAktif` AS `statusAktif` from `tblmitra` */;

/*View structure for view vwallpromo */

/*!50001 DROP TABLE IF EXISTS `vwallpromo` */;
/*!50001 DROP VIEW IF EXISTS `vwallpromo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallpromo` AS select `tblpromo`.`idPromo` AS `idPromo`,`tblpromo`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblpromo`.`waktuPromo` AS `waktuPromo`,`tblpromo`.`namaPromo` AS `namaPromo`,`tblpromo`.`namaMenu` AS `namaMenu`,`tblpromo`.`jumlahPromo` AS `jumlahPromo`,`tblpromo`.`hargaPromo` AS `hargaPromo`,`tblpromo`.`deskripsiPromo` AS `deskripsiPromo`,`tblpromo`.`statusPromo` AS `statusPromo` from (`tblpromo` join `tblmitra` on((`tblpromo`.`idMitra` = `tblmitra`.`idMitra`))) */;

/*View structure for view vwkaryawanterverifikasi */

/*!50001 DROP TABLE IF EXISTS `vwkaryawanterverifikasi` */;
/*!50001 DROP VIEW IF EXISTS `vwkaryawanterverifikasi` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwkaryawanterverifikasi` AS select `tblkaryawan`.`idKaryawan` AS `idKaryawan`,`tblkaryawan`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblkaryawan`.`waktuKaryawan` AS `waktuKaryawan`,`tblkaryawan`.`namaKaryawan` AS `namaKaryawan`,`tblkaryawan`.`nomorHpKaryawan` AS `nomorHpKaryawan`,`tblkaryawan`.`emailKaryawan` AS `emailKaryawan`,`tblkaryawan`.`jobdeskKaryawan` AS `jobdeskKaryawan`,`tblkaryawan`.`alamatKaryawan` AS `alamatKaryawan`,`tblkaryawan`.`statusTerverifikasi` AS `statusTerverifikasi`,`tblkaryawan`.`statusAktif` AS `statusAktif` from (`tblkaryawan` join `tblmitra` on((`tblkaryawan`.`idMitra` = `tblmitra`.`idMitra`))) where ((`tblkaryawan`.`statusAktif` = 'Aktif') and (`tblkaryawan`.`statusTerverifikasi` = 'Terverifikasi')) */;

/*View structure for view vwkaryawanverified */

/*!50001 DROP TABLE IF EXISTS `vwkaryawanverified` */;
/*!50001 DROP VIEW IF EXISTS `vwkaryawanverified` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwkaryawanverified` AS select `tblkaryawan`.`idKaryawan` AS `idKaryawan`,`tblkaryawan`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblkaryawan`.`waktuKaryawan` AS `waktuKaryawan`,`tblkaryawan`.`namaKaryawan` AS `namaKaryawan`,`tblkaryawan`.`nomorHpKaryawan` AS `nomorHpKaryawan`,`tblkaryawan`.`emailKaryawan` AS `emailKaryawan`,`tblkaryawan`.`jobdeskKaryawan` AS `jobdeskKaryawan`,`tblkaryawan`.`alamatKaryawan` AS `alamatKaryawan`,`tblkaryawan`.`statusTerverifikasi` AS `statusTerverifikasi`,`tblkaryawan`.`statusAktif` AS `statusAktif` from (`tblkaryawan` join `tblmitra` on((`tblkaryawan`.`idMitra` = `tblmitra`.`idMitra`))) where ((`tblkaryawan`.`statusAktif` = 'Aktif') and (`tblkaryawan`.`statusTerverifikasi` = 'Verified')) */;

/*View structure for view vwmitraterverifikasi */

/*!50001 DROP TABLE IF EXISTS `vwmitraterverifikasi` */;
/*!50001 DROP VIEW IF EXISTS `vwmitraterverifikasi` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitraterverifikasi` AS select `tblmitra`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmitra`.`nomorHpMitra` AS `nomorHpMitra`,`tblmitra`.`emailMitra` AS `emailMitra`,`tblmitra`.`alamatMitra` AS `alamatMitra`,`tblmitra`.`passwordMitra` AS `passwordMitra`,`tblmitra`.`statusTerverifikasi` AS `statusTerverifikasi`,`tblmitra`.`statusAktif` AS `statusAktif` from `tblmitra` where ((`tblmitra`.`statusAktif` = 'Aktif') and (`tblmitra`.`statusTerverifikasi` = 'Terverifikasi')) */;

/*View structure for view vwmitraverified */

/*!50001 DROP TABLE IF EXISTS `vwmitraverified` */;
/*!50001 DROP VIEW IF EXISTS `vwmitraverified` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitraverified` AS select `tblmitra`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblmitra`.`nomorHpMitra` AS `nomorHpMitra`,`tblmitra`.`emailMitra` AS `emailMitra`,`tblmitra`.`alamatMitra` AS `alamatMitra`,`tblmitra`.`passwordMitra` AS `passwordMitra`,`tblmitra`.`statusTerverifikasi` AS `statusTerverifikasi`,`tblmitra`.`statusAktif` AS `statusAktif` from `tblmitra` where ((`tblmitra`.`statusAktif` = 'Aktif') and (`tblmitra`.`statusTerverifikasi` = 'Verified')) */;

/*View structure for view vworderbahandiproses */

/*!50001 DROP TABLE IF EXISTS `vworderbahandiproses` */;
/*!50001 DROP VIEW IF EXISTS `vworderbahandiproses` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vworderbahandiproses` AS select `tblorderbahan`.`idOrder` AS `idOrder`,`tblorderbahan`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblorderbahan`.`waktuOrder` AS `waktuOrder`,`tblorderbahan`.`bahanOrder` AS `bahanOrder`,`tblorderbahan`.`ptOrder` AS `ptOrder`,`tblorderbahan`.`deskripsiOrder` AS `deskripsiOrder`,`tblorderbahan`.`alamatOrder` AS `alamatOrder`,`tblorderbahan`.`jumlahOrder` AS `jumlahOrder`,`tblorderbahan`.`hargaOrder` AS `hargaOrder`,`tblorderbahan`.`statusOrder` AS `statusOrder` from (`tblorderbahan` join `tblmitra` on((`tblorderbahan`.`idMitra` = `tblmitra`.`idMitra`))) where (`tblorderbahan`.`statusOrder` = 'Diproses') */;

/*View structure for view vworderbahanselesai */

/*!50001 DROP TABLE IF EXISTS `vworderbahanselesai` */;
/*!50001 DROP VIEW IF EXISTS `vworderbahanselesai` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vworderbahanselesai` AS select `tblorderbahan`.`idOrder` AS `idOrder`,`tblorderbahan`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblorderbahan`.`waktuOrder` AS `waktuOrder`,`tblorderbahan`.`bahanOrder` AS `bahanOrder`,`tblorderbahan`.`ptOrder` AS `ptOrder`,`tblorderbahan`.`deskripsiOrder` AS `deskripsiOrder`,`tblorderbahan`.`alamatOrder` AS `alamatOrder`,`tblorderbahan`.`jumlahOrder` AS `jumlahOrder`,`tblorderbahan`.`hargaOrder` AS `hargaOrder`,`tblorderbahan`.`statusOrder` AS `statusOrder` from (`tblorderbahan` join `tblmitra` on((`tblorderbahan`.`idMitra` = `tblmitra`.`idMitra`))) where (`tblorderbahan`.`statusOrder` = 'Selesai') */;

/*View structure for view vwsaldomitra */

/*!50001 DROP TABLE IF EXISTS `vwsaldomitra` */;
/*!50001 DROP VIEW IF EXISTS `vwsaldomitra` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwsaldomitra` AS select `tblsaldomitra`.`idSaldoMitra` AS `idSaldoMitra`,`tblsaldomitra`.`idMitra` AS `idMitra`,`tblsaldomitra`.`saldoMitra` AS `saldoMitra` from `tblsaldomitra` */;

/*View structure for view vwtransaksidiproses */

/*!50001 DROP TABLE IF EXISTS `vwtransaksidiproses` */;
/*!50001 DROP VIEW IF EXISTS `vwtransaksidiproses` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwtransaksidiproses` AS select `tbltransaksi`.`idTransaksi` AS `idTransaksi`,`tbltransaksi`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tbltransaksi`.`waktuTransaksi` AS `waktuTransaksi`,`tbltransaksi`.`namaTransaksi` AS `namaTransaksi`,`tbltransaksi`.`makananTransaksi` AS `makananTransaksi`,`tbltransaksi`.`coffeTransaksi` AS `coffeTransaksi`,`tbltransaksi`.`nonCoffeTransaksi` AS `nonCoffeTransaksi`,`tbltransaksi`.`jumlahMakanan` AS `jumlahMakanan`,`tbltransaksi`.`jumlahCoffe` AS `jumlahCoffe`,`tbltransaksi`.`jumlahNonCoffe` AS `jumlahNonCoffe`,`tbltransaksi`.`hargaMakanan` AS `hargaMakanan`,`tbltransaksi`.`hargaCoffe` AS `hargaCoffe`,`tbltransaksi`.`hargaNonCoffe` AS `hargaNonCoffe`,`tbltransaksi`.`promoTransaksi` AS `promoTransaksi`,`tbltransaksi`.`mejaTransaksi` AS `mejaTransaksi`,`tbltransaksi`.`deskripsiTransaksi` AS `deskripsiTransaksi`,`tbltransaksi`.`hargaTransaksi` AS `hargaTransaksi`,`tbltransaksi`.`hargaPromo` AS `hargaPromo`,`tbltransaksi`.`bayarTransaksi` AS `bayarTransaksi`,`tbltransaksi`.`uangTransaksi` AS `uangTransaksi`,`tbltransaksi`.`kembalianTransaksi` AS `kembalianTransaksi`,`tbltransaksi`.`statusTransaksi` AS `statusTransaksi` from (`tbltransaksi` join `tblmitra` on((`tbltransaksi`.`idMitra` = `tblmitra`.`idMitra`))) where (`tbltransaksi`.`statusTransaksi` = 'Diproses') */;

/*View structure for view vwtransaksionlinediproses */

/*!50001 DROP TABLE IF EXISTS `vwtransaksionlinediproses` */;
/*!50001 DROP VIEW IF EXISTS `vwtransaksionlinediproses` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwtransaksionlinediproses` AS select `tbltransaksionline`.`idTransaksi` AS `idTransaksi`,`tbltransaksionline`.`idMitra` AS `idMitra`,`tbltransaksionline`.`idCustomer` AS `idCustomer`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblcustomer`.`namaCustomer` AS `namaCustomer`,`tbltransaksionline`.`waktuTransaksi` AS `waktuTransaksi`,`tbltransaksionline`.`makananTransaksi` AS `makananTransaksi`,`tbltransaksionline`.`coffeTransaksi` AS `coffeTransaksi`,`tbltransaksionline`.`nonCoffeTransaksi` AS `nonCoffeTransaksi`,`tbltransaksionline`.`jumlahMakanan` AS `jumlahMakanan`,`tbltransaksionline`.`JumlahCoffe` AS `JumlahCoffe`,`tbltransaksionline`.`jumlahNonCoffe` AS `jumlahNonCoffe`,`tbltransaksionline`.`hargaMakanan` AS `hargaMakanan`,`tbltransaksionline`.`hargaCoffe` AS `hargaCoffe`,`tbltransaksionline`.`hargaNonCoffe` AS `hargaNonCoffe`,`tbltransaksionline`.`promoTransaksi` AS `promoTransaksi`,`tbltransaksionline`.`mejaTransaksi` AS `mejaTransaksi`,`tbltransaksionline`.`deskripsiTransaksi` AS `deskripsiTransaksi`,`tbltransaksionline`.`hargaTransaksi` AS `hargaTransaksi`,`tbltransaksionline`.`hargaPromo` AS `hargaPromo`,`tbltransaksionline`.`bayarTransaksi` AS `bayarTransaksi`,`tbltransaksionline`.`uangTransaksi` AS `uangTransaksi`,`tbltransaksionline`.`kembalianTransaksi` AS `kembalianTransaksi`,`tbltransaksionline`.`statusTransaksi` AS `statusTransaksi` from ((`tbltransaksionline` join `tblcustomer` on((`tbltransaksionline`.`idCustomer` = `tblcustomer`.`idCustomer`))) join `tblmitra` on((`tbltransaksionline`.`idMitra` = `tblmitra`.`idMitra`))) where (`tbltransaksionline`.`statusTransaksi` = 'Diproses') */;

/*View structure for view vwtransaksionlineselesai */

/*!50001 DROP TABLE IF EXISTS `vwtransaksionlineselesai` */;
/*!50001 DROP VIEW IF EXISTS `vwtransaksionlineselesai` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwtransaksionlineselesai` AS select `tbltransaksionline`.`idTransaksi` AS `idTransaksi`,`tbltransaksionline`.`idMitra` AS `idMitra`,`tbltransaksionline`.`idCustomer` AS `idCustomer`,`tblmitra`.`namaMitra` AS `namaMitra`,`tblcustomer`.`namaCustomer` AS `namaCustomer`,`tbltransaksionline`.`waktuTransaksi` AS `waktuTransaksi`,`tbltransaksionline`.`makananTransaksi` AS `makananTransaksi`,`tbltransaksionline`.`coffeTransaksi` AS `coffeTransaksi`,`tbltransaksionline`.`nonCoffeTransaksi` AS `nonCoffeTransaksi`,`tbltransaksionline`.`jumlahMakanan` AS `jumlahMakanan`,`tbltransaksionline`.`JumlahCoffe` AS `JumlahCoffe`,`tbltransaksionline`.`jumlahNonCoffe` AS `jumlahNonCoffe`,`tbltransaksionline`.`hargaMakanan` AS `hargaMakanan`,`tbltransaksionline`.`hargaCoffe` AS `hargaCoffe`,`tbltransaksionline`.`hargaNonCoffe` AS `hargaNonCoffe`,`tbltransaksionline`.`promoTransaksi` AS `promoTransaksi`,`tbltransaksionline`.`mejaTransaksi` AS `mejaTransaksi`,`tbltransaksionline`.`deskripsiTransaksi` AS `deskripsiTransaksi`,`tbltransaksionline`.`hargaTransaksi` AS `hargaTransaksi`,`tbltransaksionline`.`hargaPromo` AS `hargaPromo`,`tbltransaksionline`.`bayarTransaksi` AS `bayarTransaksi`,`tbltransaksionline`.`uangTransaksi` AS `uangTransaksi`,`tbltransaksionline`.`kembalianTransaksi` AS `kembalianTransaksi`,`tbltransaksionline`.`statusTransaksi` AS `statusTransaksi` from ((`tbltransaksionline` join `tblcustomer` on((`tbltransaksionline`.`idCustomer` = `tblcustomer`.`idCustomer`))) join `tblmitra` on((`tbltransaksionline`.`idMitra` = `tblmitra`.`idMitra`))) where (`tbltransaksionline`.`statusTransaksi` = 'Selesai') */;

/*View structure for view vwtransaksiselesai */

/*!50001 DROP TABLE IF EXISTS `vwtransaksiselesai` */;
/*!50001 DROP VIEW IF EXISTS `vwtransaksiselesai` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwtransaksiselesai` AS select `tbltransaksi`.`idTransaksi` AS `idTransaksi`,`tbltransaksi`.`idMitra` AS `idMitra`,`tblmitra`.`namaMitra` AS `namaMitra`,`tbltransaksi`.`waktuTransaksi` AS `waktuTransaksi`,`tbltransaksi`.`namaTransaksi` AS `namaTransaksi`,`tbltransaksi`.`makananTransaksi` AS `makananTransaksi`,`tbltransaksi`.`coffeTransaksi` AS `coffeTransaksi`,`tbltransaksi`.`nonCoffeTransaksi` AS `nonCoffeTransaksi`,`tbltransaksi`.`jumlahMakanan` AS `jumlahMakanan`,`tbltransaksi`.`jumlahCoffe` AS `jumlahCoffe`,`tbltransaksi`.`jumlahNonCoffe` AS `jumlahNonCoffe`,`tbltransaksi`.`hargaMakanan` AS `hargaMakanan`,`tbltransaksi`.`hargaCoffe` AS `hargaCoffe`,`tbltransaksi`.`hargaNonCoffe` AS `hargaNonCoffe`,`tbltransaksi`.`promoTransaksi` AS `promoTransaksi`,`tbltransaksi`.`mejaTransaksi` AS `mejaTransaksi`,`tbltransaksi`.`deskripsiTransaksi` AS `deskripsiTransaksi`,`tbltransaksi`.`hargaTransaksi` AS `hargaTransaksi`,`tbltransaksi`.`hargaPromo` AS `hargaPromo`,`tbltransaksi`.`bayarTransaksi` AS `bayarTransaksi`,`tbltransaksi`.`uangTransaksi` AS `uangTransaksi`,`tbltransaksi`.`kembalianTransaksi` AS `kembalianTransaksi`,`tbltransaksi`.`statusTransaksi` AS `statusTransaksi` from (`tbltransaksi` join `tblmitra` on((`tbltransaksi`.`idMitra` = `tblmitra`.`idMitra`))) where (`tbltransaksi`.`statusTransaksi` = 'Selesai') */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
