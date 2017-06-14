CREATE DATABASE `laps_db_new` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `department` (
  `departmentid` varchar(15) NOT NULL,
  `managerid` varchar(15) NOT NULL,
  PRIMARY KEY (`departmentid`),
  KEY `mfk_idx` (`managerid`),
  CONSTRAINT `mfk` FOREIGN KEY (`managerid`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
  `employeeid` varchar(15) NOT NULL,
  `managerid` varchar(15) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `annualleaveremaining` varchar(45) DEFAULT NULL,
  `medicalleaveremaining` varchar(45) DEFAULT NULL,
  `compensationleaveremaining` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `leaveevent` (
  `leaveeventid` int(11) NOT NULL AUTO_INCREMENT,
  `leaveid` int(11) DEFAULT NULL,
  `timestamp` date DEFAULT NULL,
  `eventtype` varchar(20) DEFAULT NULL,
  `eventby` varchar(30) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`leaveeventid`),
  KEY `cfk_idx` (`leaveid`),
  CONSTRAINT `cfk` FOREIGN KEY (`leaveid`) REFERENCES `leavel` (`leaveid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

CREATE TABLE `leavel` (
  `leaveid` int(11) NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(15) DEFAULT NULL,
  `leavename` varchar(45) DEFAULT NULL,
  `organiser` varchar(45) DEFAULT NULL,
  `fromdate` date DEFAULT NULL,
  `todate` date DEFAULT NULL,
  `justification` varchar(100) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  `comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`leaveid`),
  KEY `efk_idx` (`employeeid`),
  CONSTRAINT `efk1` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `roleid` varchar(15) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `annualleave` varchar(45) NOT NULL,
  `medicalleave` varchar(45) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `userid` varchar(15) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `employeeid` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `efk_idx` (`employeeid`),
  CONSTRAINT `efk` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userrole` (
  `roleid` varchar(15) NOT NULL,
  `userid` varchar(15) NOT NULL,
  PRIMARY KEY (`roleid`,`userid`),
  KEY `ufk` (`userid`),
  CONSTRAINT `rfk` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ufk` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



