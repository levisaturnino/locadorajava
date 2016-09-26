-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 26, 2016 at 11:31 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comercio`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `cod_categoria` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`cod_categoria`, `descricao`) VALUES
(1, 'Utilidades'),
(2, 'Geral');

-- --------------------------------------------------------

--
-- Table structure for table `categoria_produto`
--

CREATE TABLE `categoria_produto` (
  `cod_categoria` int(11) NOT NULL,
  `cod_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_produto`
--

INSERT INTO `categoria_produto` (`cod_categoria`, `cod_produto`) VALUES
(1, 1),
(1, 3),
(1, 2),
(2, 1),
(2, 3),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

CREATE TABLE `produto` (
  `cod_produto` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `preco` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produto`
--

INSERT INTO `produto` (`cod_produto`, `descricao`, `preco`) VALUES
(1, 'Bicicleta', '356.83'),
(2, 'Televisão', '19.99'),
(3, 'DVD', '195.60');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Indexes for table `categoria_produto`
--
ALTER TABLE `categoria_produto`
  ADD KEY `cod_categoria` (`cod_categoria`),
  ADD KEY `cod_produto` (`cod_produto`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`cod_produto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `cod_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `categoria_produto`
--
ALTER TABLE `categoria_produto`
  ADD CONSTRAINT `fk_categoria_produto_categoria` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_categoria_produto_produto` FOREIGN KEY (`cod_produto`) REFERENCES `produto` (`cod_produto`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
