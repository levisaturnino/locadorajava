-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 26, 2016 at 10:53 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `locadora`
--

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `cod_categoria` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`cod_categoria`, `descricao`) VALUES
(1, 'Aventura'),
(2, 'Ação'),
(3, 'Comédia'),
(4, 'Aventura'),
(5, 'Ação'),
(6, 'Comédia'),
(7, 'Aventura'),
(8, 'Ação'),
(9, 'Comédia'),
(10, 'Aventura'),
(11, 'Ação'),
(12, 'Comédia'),
(13, 'Aventura'),
(14, 'Ação'),
(15, 'Comédia'),
(16, 'Aventura'),
(17, 'Ação'),
(18, 'Comédia'),
(19, 'Aventura'),
(20, 'Ação'),
(21, 'Comédia');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `nome`, `telefone`, `celular`, `email`) VALUES
(1, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(2, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(3, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(4, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(5, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(6, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br'),
(7, 'Fulano Solaris', '(47) 3333-7777', '(47) 1111-2222', 'solaris@javapro.com.br');

-- --------------------------------------------------------

--
-- Table structure for table `endereco`
--

CREATE TABLE `endereco` (
  `cod_cliente` int(11) NOT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` char(2) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `complemento` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `endereco`
--

INSERT INTO `endereco` (`cod_cliente`, `rua`, `numero`, `bairro`, `cidade`, `estado`, `cep`, `complemento`) VALUES
(1, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(2, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(3, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(4, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(5, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(6, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa'),
(7, 'Av. Principal', 1, 'centro', 'Joinville', 'SC', '89999-999', 'casa');

-- --------------------------------------------------------

--
-- Table structure for table `filme`
--

CREATE TABLE `filme` (
  `cod_filme` int(11) NOT NULL,
  `cod_categoria` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `ano` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `filme`
--

INSERT INTO `filme` (`cod_filme`, `cod_categoria`, `descricao`, `ano`) VALUES
(1, 1, 'Senhor dos Anéis', '2001-12-19'),
(2, 2, 'Transformes', '2007-07-20'),
(3, 3, 'Ghostbusters', '1985-02-01'),
(4, 1, 'Senhor dos Anéis', '2001-12-19'),
(5, 2, 'Transformes', '2007-07-20'),
(6, 3, 'Ghostbusters', '1985-02-01'),
(7, 1, 'Senhor dos Anéis', '2001-12-19'),
(8, 2, 'Transformes', '2007-07-20'),
(9, 3, 'Ghostbusters', '1985-02-01'),
(10, 1, 'Senhor dos Anéis', '2001-12-19'),
(11, 2, 'Transformes', '2007-07-20'),
(12, 3, 'Ghostbusters', '1985-02-01'),
(13, 1, 'Senhor dos Anéis', '2001-12-19'),
(14, 2, 'Transformes', '2007-07-20'),
(15, 3, 'Ghostbusters', '1985-02-01'),
(16, 1, 'Senhor dos Anéis', '2001-12-19'),
(17, 2, 'Transformes', '2007-07-20'),
(18, 3, 'Ghostbusters', '1985-02-01'),
(19, 1, 'Senhor dos Anéis', '2001-12-19'),
(20, 2, 'Transformes', '2007-07-20'),
(21, 3, 'Ghostbusters', '1985-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `locacao`
--

CREATE TABLE `locacao` (
  `cod_locacao` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_midia` int(11) NOT NULL,
  `data_emprestimo` date DEFAULT NULL,
  `hora_emprestimo` time DEFAULT NULL,
  `data_devolucao` date DEFAULT NULL,
  `obs` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `locacao`
--

INSERT INTO `locacao` (`cod_locacao`, `cod_cliente`, `cod_midia`, `data_emprestimo`, `hora_emprestimo`, `data_devolucao`, `obs`) VALUES
(1, 4, 2, NULL, NULL, NULL, 'Devolucao final de semana'),
(2, 5, 2, NULL, NULL, '2016-09-26', 'Devolucao final de semana'),
(3, 6, 2, '2016-09-26', '10:27:35', '2016-09-26', 'Devolucao final de semana'),
(4, 7, 2, '2016-09-26', '10:32:13', '2016-09-26', 'Devolucao final de semana');

-- --------------------------------------------------------

--
-- Table structure for table `midia`
--

CREATE TABLE `midia` (
  `cod_midia` int(11) NOT NULL,
  `cod_filme` int(11) NOT NULL,
  `inutilizada` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `midia`
--

INSERT INTO `midia` (`cod_midia`, `cod_filme`, `inutilizada`) VALUES
(1, 1, 'N'),
(2, 2, 'N'),
(3, 3, 'N'),
(4, 1, 'N'),
(5, 2, 'N'),
(6, 3, 'N'),
(7, 1, 'N'),
(8, 2, 'N'),
(9, 3, 'N'),
(10, 1, 'N'),
(11, 2, 'N'),
(12, 3, 'N'),
(13, 1, 'N'),
(14, 2, 'N'),
(15, 3, 'N'),
(16, 1, 'N'),
(17, 2, 'N'),
(18, 3, 'N'),
(19, 1, 'N'),
(20, 2, 'N'),
(21, 3, 'N');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indexes for table `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`cod_filme`),
  ADD KEY `cod_categoria` (`cod_categoria`);

--
-- Indexes for table `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`cod_locacao`,`cod_cliente`,`cod_midia`),
  ADD KEY `fk_locadora_cliente` (`cod_cliente`),
  ADD KEY `fk_locadora_midia` (`cod_midia`);

--
-- Indexes for table `midia`
--
ALTER TABLE `midia`
  ADD PRIMARY KEY (`cod_midia`),
  ADD KEY `cod_filme` (`cod_filme`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `cod_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `filme`
--
ALTER TABLE `filme`
  MODIFY `cod_filme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `locacao`
--
ALTER TABLE `locacao`
  MODIFY `cod_locacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `midia`
--
ALTER TABLE `midia`
  MODIFY `cod_midia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `fk_endereco_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `filme`
--
ALTER TABLE `filme`
  ADD CONSTRAINT `fk_filme_categoria` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`cod_categoria`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `fk_locadora_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_locadora_midia` FOREIGN KEY (`cod_midia`) REFERENCES `midia` (`cod_midia`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `midia`
--
ALTER TABLE `midia`
  ADD CONSTRAINT `fk_midia_filme` FOREIGN KEY (`cod_filme`) REFERENCES `filme` (`cod_filme`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
