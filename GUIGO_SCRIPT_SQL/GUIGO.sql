--
-- Database: `GUIGO`
--

-- --------------------------------------------------------

--
-- Table structure for table `TbCulturas`
--

CREATE DATABASE GUIGO;

USE GUIGO;

CREATE TABLE `TbCulturas` (
  `codCultura` int(11) NOT NULL,
  `nomeCultura` varchar(15) NOT NULL,
  `variedade` varchar(15) NOT NULL,
  `cicloEmDias` int(4) NOT NULL,
  `diasGerminacao` int(11) NOT NULL,
  `diasBercario` int(11) NOT NULL,
  `diasEngorda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TbCulturas`
--

INSERT INTO `TbCulturas` (`codCultura`, `nomeCultura`, `variedade`, `cicloEmDias`, `diasGerminacao`, `diasBercario`, `diasEngorda`) VALUES
(1, '1', '1', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `TbDataRealTime`
--

CREATE TABLE `TbDataRealTime` (
  `dataRT` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `temperatura` float NOT NULL,
  `UMIDADE` float NOT NULL,
  `LUMINOSIDADE` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TbUsuario`
--

CREATE TABLE `TbUsuario` (
  `codUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(45) NOT NULL,
  `foneUsuario` varchar(15) NOT NULL,
  `emailUsuario` varchar(100) NOT NULL,
  `loginUsuario` varchar(15) NOT NULL,
  `senhaUsuario` varchar(15) NOT NULL,
  `tipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `TbUsuario`
--

INSERT INTO `TbUsuario` (`codUsuario`, `nomeUsuario`, `foneUsuario`, `emailUsuario`, `loginUsuario`, `senhaUsuario`, `tipoUsuario`) VALUES
(1, 'banana', '9999999', 'dasdasdasdasd', 'banana', '1234', 3),
(4, 'Alexandre', '99-9 9999 9999', 'jsbahsbdh', 'bessa', '123', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `TbCulturas`
--
ALTER TABLE `TbCulturas`
  ADD PRIMARY KEY (`codCultura`);

--
-- Indexes for table `TbDataRealTime`
--
ALTER TABLE `TbDataRealTime`
  ADD PRIMARY KEY (`dataRT`);

--
-- Indexes for table `TbUsuario`
--
ALTER TABLE `TbUsuario`
  ADD PRIMARY KEY (`codUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `TbCulturas`
--
ALTER TABLE `TbCulturas`
  MODIFY `codCultura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `TbUsuario`
--
ALTER TABLE `TbUsuario`
  MODIFY `codUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
