-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2014-11-06 20:27:16
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
  `TableNumber` int(255) DEFAULT NULL,
  `TableSize` int(255) DEFAULT NULL,
  `Date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `reservation`
--

INSERT INTO `reservation` (`CustName`, `Phone`, `Time`, `GroupSize`, `Waiter`, `TableNumber`, `TableSize`, `Date`) VALUES
('tim', '1234567890', 'Lunch', 4, 'null', 0, 4, 'Nov 19, 2014'),
('ben', '1234567890', 'Lunch', 8, 'Josh', 0, 8, 'Nov 26, 2014');

-- --------------------------------------------------------

--
-- 表的结构 `tables`
--

CREATE TABLE IF NOT EXISTS `tables` (
  `TableSize` int(255) NOT NULL,
  `AvailableNumber` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `tables`
--

INSERT INTO `tables` (`TableSize`, `AvailableNumber`) VALUES
(2, 6),
(4, 6),
(8, 4);

-- --------------------------------------------------------

--
-- 表的结构 `waiter`
--

CREATE TABLE IF NOT EXISTS `waiter` (
  `WaiterName` varchar(255) NOT NULL,
  `Capability` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `waiter`
--

INSERT INTO `waiter` (`WaiterName`, `Capability`) VALUES
('David', 3),
('Tom', 3),
('Josh', 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
