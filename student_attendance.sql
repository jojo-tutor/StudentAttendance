-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2016 at 09:43 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `student_attendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
`id` int(11) NOT NULL,
  `stud_id` int(10) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `mi` varchar(1) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `picture` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `stud_id`, `fname`, `mi`, `lname`, `picture`) VALUES
(1, 1601000185, 'Josaphat', 'E', 'Tutor', '1601000185 - Josaphat Tutor.jpg'),
(2, 1601000276, 'Kennery', 'V', 'Romero', '1601000276 - Kennery Romero.jpg'),
(3, 1601000367, 'Reynan', 'A', 'Amoguis', '1601000367 - Reynan Amoguis.jpg'),
(4, 1601000458, 'Jonas', 'E', 'Olandria', '1601000458 - Jonas Olandria.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `student_logs`
--

CREATE TABLE IF NOT EXISTS `student_logs` (
`id` int(11) NOT NULL,
  `stud_id` int(10) NOT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `in_out` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `stud_id` (`stud_id`);

--
-- Indexes for table `student_logs`
--
ALTER TABLE `student_logs`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_stud_id` (`stud_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `student_logs`
--
ALTER TABLE `student_logs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_logs`
--
ALTER TABLE `student_logs`
ADD CONSTRAINT `fk_stud_id` FOREIGN KEY (`stud_id`) REFERENCES `student` (`stud_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
