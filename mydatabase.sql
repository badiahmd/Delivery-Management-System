-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2015 at 10:17 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `membership_createmember`
--

CREATE TABLE IF NOT EXISTS `membership_createmember` (
  `MemberID` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PhoneNumber` varchar(50) NOT NULL,
  `EmailAddress` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `MembershipType` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membership_createmember`
--

INSERT INTO `membership_createmember` (`MemberID`, `Name`, `PhoneNumber`, `EmailAddress`, `Address`, `MembershipType`) VALUES
(14, 'Moie', '6832473', 'badi@yahoo.com', 'endah regal b-22-3', 'GOLD'),
(15, 'waaaa', '8762795', 'waaaaaa@gamasa.com', 'wedeh', 'GOLD'),
(16, '', '', '', '', 'GOLD');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `PaymentID` int(10) NOT NULL,
  `DeliveryNumber` int(10) NOT NULL,
  `MemberID` int(10) NOT NULL,
  `Service` varchar(50) NOT NULL,
  `AmmountPaid` double DEFAULT NULL,
  `AmmountCollected` double DEFAULT NULL,
  `LastPaid` date DEFAULT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`PaymentID`, `DeliveryNumber`, `MemberID`, `Service`, `AmmountPaid`, `AmmountCollected`, `LastPaid`, `Status`) VALUES
(11, 23, 14, 'DeliveryOrder', 1275, 1275, '2015-11-29', 'PAID'),
(12, 24, 14, 'DeliveryOrder', 153, 0, NULL, 'NOT PAID');

-- --------------------------------------------------------

--
-- Table structure for table `price`
--

CREATE TABLE IF NOT EXISTS `price` (
  `ID` int(11) NOT NULL,
  `MembershipType` varchar(50) NOT NULL,
  `DiscountRates` double NOT NULL,
  `MembershipPrice` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `price`
--

INSERT INTO `price` (`ID`, `MembershipType`, `DiscountRates`, `MembershipPrice`) VALUES
(1, 'Basic', 0.05, 100),
(2, 'Premium', 0.1, 200),
(3, 'Gold', 0.15, 300);

-- --------------------------------------------------------

--
-- Table structure for table `standingorder_membership`
--

CREATE TABLE IF NOT EXISTS `standingorder_membership` (
  `MemberID` int(50) NOT NULL,
  `DeliveryNumber` int(50) NOT NULL,
  `RecipientName` varchar(50) NOT NULL,
  `RecipientPhone` varchar(50) NOT NULL,
  `RecipientAddress` varchar(100) NOT NULL,
  `ItemDescription` varchar(100) NOT NULL,
  `ItemWeightage` double NOT NULL,
  `DeliveryStatus` varchar(50) NOT NULL,
  `DeliveryDate` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `standingorder_membership`
--

INSERT INTO `standingorder_membership` (`MemberID`, `DeliveryNumber`, `RecipientName`, `RecipientPhone`, `RecipientAddress`, `ItemDescription`, `ItemWeightage`, `DeliveryStatus`, `DeliveryDate`) VALUES
(14, 24, 'smaug', '964325743', 'dfasg312', 'fdasfdda', 12, 'ON-HOLD', '2015-11-11');

-- --------------------------------------------------------

--
-- Table structure for table `standingorder_walkin`
--

CREATE TABLE IF NOT EXISTS `standingorder_walkin` (
  `DeliveryNumber` int(50) NOT NULL,
  `CustomerName` varchar(50) NOT NULL,
  `CustomerPhone` varchar(50) NOT NULL,
  `CustomerAddress` varchar(100) NOT NULL,
  `RecipientName` varchar(50) NOT NULL,
  `RecipientPhone` varchar(50) NOT NULL,
  `RecipientAddress` varchar(100) NOT NULL,
  `Item` varchar(50) NOT NULL,
  `Weight` double NOT NULL,
  `Status` varchar(100) NOT NULL,
  `DeliveryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `USERNAME` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `TYPE` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USERNAME`, `PASSWORD`, `TYPE`) VALUES
('admin', 'admin123', 'ADMIN'),
('clerk', 'clerk123', 'CLERK'),
('manager', 'manager123', 'MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `weightrates`
--

CREATE TABLE IF NOT EXISTS `weightrates` (
  `Category` varchar(50) NOT NULL,
  `Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weightrates`
--

INSERT INTO `weightrates` (`Category`, `Price`) VALUES
('HEAVYWEIGHT', 15),
('LIGHTWEIGHT', 3.5),
('LIGHT_HEAVYWEIGHT', 12),
('MIDDLEWEIGHT', 9),
('STANDARD_WEIGHT', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `membership_createmember`
--
ALTER TABLE `membership_createmember`
  ADD PRIMARY KEY (`MemberID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `price`
--
ALTER TABLE `price`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `standingorder_membership`
--
ALTER TABLE `standingorder_membership`
  ADD PRIMARY KEY (`DeliveryNumber`);

--
-- Indexes for table `standingorder_walkin`
--
ALTER TABLE `standingorder_walkin`
  ADD PRIMARY KEY (`DeliveryNumber`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USERNAME`);

--
-- Indexes for table `weightrates`
--
ALTER TABLE `weightrates`
  ADD PRIMARY KEY (`Category`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `membership_createmember`
--
ALTER TABLE `membership_createmember`
  MODIFY `MemberID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `price`
--
ALTER TABLE `price`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `standingorder_membership`
--
ALTER TABLE `standingorder_membership`
  MODIFY `DeliveryNumber` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `standingorder_walkin`
--
ALTER TABLE `standingorder_walkin`
  MODIFY `DeliveryNumber` int(50) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
