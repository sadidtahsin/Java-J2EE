-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 02, 2016 at 07:16 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aiub_club`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `u_comments` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`comment_id`, `user_id`, `event_id`, `date`, `u_comments`) VALUES
(1, 2, 1, '2016-08-26', 'dfsdfs '),
(2, 2, 2, '2016-08-27', 'sdf\r\njkds\r\ndjfbskd nbksajbf'),
(3, 3, 2, '2016-08-30', 'NIce'),
(4, 3, 2, '2016-08-30', 'Lets Discuss'),
(5, 2, 2, '2016-08-31', 'hghhfh'),
(6, 15, 2, '2016-08-31', 'gghgh hghj'),
(7, 2, 3, '2016-08-31', 'dfg'),
(8, 2, 6, '2016-08-31', 'vnvv'),
(9, 2, 7, '2016-08-31', 'jbk\r\nlkhkj'),
(10, 2, 8, '2016-08-31', 'hvhjv'),
(11, 2, 2, '2016-08-31', 'vgvgvgv'),
(12, 18, 2, '2016-08-31', 'hello world');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `event_id` int(10) NOT NULL,
  `event_title` varchar(222) NOT NULL,
  `details` varchar(999) NOT NULL,
  `event_creation_date` date NOT NULL,
  `event_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`event_id`, `event_title`, `details`, `event_creation_date`, `event_date`) VALUES
(2, 'AIUB', 'hff vgch vjv vj mnhj', '2016-08-31', '2016-08-31'),
(6, 'Camp lou', 'dasa', '2016-08-24', '2016-08-27'),
(7, 'Cyber Games', 'Welcome to all', '2016-08-30', '2016-09-29'),
(8, 'Home Alone', 'He l,hi ', '2016-08-30', '2016-09-15'),
(9, 'project submission', 'atp1', '2016-08-31', '2016-08-31');

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `task_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `task_detail` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`task_id`, `user_id`, `event_id`, `task_detail`) VALUES
(1, 2, 1, 'asdas bjh\r\nhjdjshfdj \r\n\r\njfbjsd\r\n1.sd\r\n2.fs'),
(2, 4, 1, 'hdhsjfvhjsdvf'),
(3, 5, 1, 'ashdjasvdhav'),
(4, 1, 1, 'hdshdg'),
(5, 13, 1, 'dsvdsjhvfdsj'),
(6, 15, 1, 'hsjjas'),
(7, 5, 6, 'dsfdfdsf'),
(8, 2, 2, 'gamer'),
(9, 3, 2, 'dfdfdf'),
(10, 3, 3, 'sadas'),
(11, 4, 3, 'sdasdas'),
(12, 3, 6, 'dsfds'),
(13, 4, 6, 'fdfsfsdfdse er'),
(14, 15, 6, 'erwv gg'),
(15, 16, 2, 'sdfdsf'),
(16, 15, 8, 'dfs'),
(17, 16, 8, 'dsfs'),
(18, 2, 3, 'vbcbv'),
(19, 2, 7, 'bcchg'),
(20, 2, 8, 'ccvh'),
(21, 18, 3, 'task 1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(22) NOT NULL,
  `name` varchar(222) NOT NULL,
  `user_name` varchar(222) NOT NULL,
  `password` varchar(222) NOT NULL,
  `phone` int(22) NOT NULL,
  `address` varchar(222) NOT NULL,
  `user_type` varchar(22) NOT NULL,
  `user_status` varchar(22) NOT NULL,
  `email` varchar(222) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `user_name`, `password`, `phone`, `address`, `user_type`, `user_status`, `email`) VALUES
(1, 'Sadid', 'tamim.tm', '1', 121212, 'sadsadc asdsada', 'admin', 'active', 'ss@m.com'),
(2, 'Tahsin', 'tamim', '1', 343422, '2424ccc sdasdas', 'member', 'active', 'th@c.com'),
(3, 'robin', 'robin', '1', 32131, 'dsf sfs fdsf ', 'member', 'active', 'r@r.com'),
(4, 'asif', 'asif', '1', 1212, 'dfsdfs', 'member', 'active', 'czc'),
(5, 'nahid', 'nahid', '1', 3232, 'sada', 'member', 'active', 'sda'),
(6, 'sdsa', 'sdasdasdasda', 'dasdsadas', 1112121, 'sdasdasdas', 'member', 'inactive', 'dasdsd'),
(13, 'nmcbd', 'sss', '1', 224, 'cbsd bns c nmsd', 'member', 'inactive', 'cnmbsc@cbd'),
(14, 'sgdagj', 'hsdgj', 'gdh12121', 12112, 'jgfgsuyddfuy', 'member', 'inactive', 'scvashvhvc@csdcv'),
(15, 'Nahidur Nahid', 'nahid136', '1', 1736714233, 'House no.48, dhaka housing, Adabor 1, Shyamoli,', 'member', 'active', 'nahid_nahidur@yahoo.com'),
(16, 'test', 'tesr', '1', 44444, 'hcufy', 'member', 'active', 'fgg@fg'),
(17, 'ROBIN', 'r', '1', 1213, 'sddfds', 'member', 'active', 'sdas@fsd'),
(18, 'ROBIN1', 'rolo', '1', 232323, 'asfsf3232', 'member', 'active', 'sali@gm'),
(19, 'atp', '4567', '123', 5445552, 'fttfuh66vv', 'member', 'inactive', 'fgfg@hh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`task_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `event_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(22) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
