-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2014-09-25 23:27:21
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rms`
--

-- --------------------------------------------------------

--
-- 表的结构 `guest`
--

CREATE TABLE IF NOT EXISTS `guest` (
  `GuestName` varchar(255) NOT NULL,
  `Course` varchar(255) NOT NULL,
  `Price` decimal(64,3) NOT NULL,
  `TableNumber` int(255) NOT NULL,
  `Waiter` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `CustName` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Time` varchar(255) NOT NULL,
  `GroupSize` int(255) NOT NULL,
  `Waiter` varchar(255) DEFAULT NULL,
  `TableNumber` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tables`
--

CREATE TABLE IF NOT EXISTS `tables` (
  `TableSize` int(255) NOT NULL,
  `AvailableNumber` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `waiter`
--

CREATE TABLE IF NOT EXISTS `waiter` (
  `WaiterName` varchar(255) NOT NULL,
  `Capability` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
