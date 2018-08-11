-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2018 at 06:56 PM
-- Server version: 5.7.20-log
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vote`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidates`
--

CREATE TABLE `candidates` (
  `candidatename` varchar(15) NOT NULL,
  `symbol` varchar(10) NOT NULL,
  `counting` int(11) NOT NULL,
  `candidateid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidates`
--

INSERT INTO `candidates` (`candidatename`, `symbol`, `counting`, `candidateid`) VALUES
('Harry', 'harry', 0, 1),
('Bean', 'bean', 0, 2),
('Pirate', 'pirate', 0, 3),
('Avatar', 'avatar', 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `votelist`
--

CREATE TABLE `votelist` (
  `votername` varchar(15) NOT NULL,
  `voterid` varchar(15) NOT NULL,
  `aadharnum` bigint(20) NOT NULL,
  `voted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `votelist`
--

INSERT INTO `votelist` (`votername`, `voterid`, `aadharnum`, `voted`) VALUES
('BatMan', 'batman22', 143221341234, 0),
('IronMan', 'ironman33', 123443211432, 0),
('SpiderMan', 'spiderman11', 431243213214, 0),
('SuperMan', 'superman44', 142331422413, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidates`
--
ALTER TABLE `candidates`
  ADD PRIMARY KEY (`candidateid`),
  ADD UNIQUE KEY `symbuniq` (`symbol`);

--
-- Indexes for table `votelist`
--
ALTER TABLE `votelist`
  ADD PRIMARY KEY (`voterid`),
  ADD UNIQUE KEY `aadharuniq` (`aadharnum`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
