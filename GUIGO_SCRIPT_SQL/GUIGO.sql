--
-- Database: `GUIGO`
--

-- --------------------------------------------------------

--
-- Table structure for table `TbCulturas`
--

CREATE DATABASE GUIGO
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE GUIGO;

CREATE TABLE TbCulturas (
  codCultura int NOT NULL,
  nomeCultura varchar(15) NOT NULL,
  variedade varchar(15) NOT NULL,
  cicloEmDias int NOT NULL,
  diasGerminacao int NOT NULL,
  diasBercario int NOT NULL,
  diasEngorda int NOT NULL
) ENGINE = InnoDB;

--
-- Dumping data for table `TbCulturas`
--

INSERT INTO TbCulturas (codCultura, nomeCultura, variedade, cicloEmDias, diasGerminacao, diasBercario, diasEngorda) VALUES
(1, '1', '1', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `TbDataRealTime`
--

CREATE TABLE TbDataRealTime (
  dataRT timestamp not null,
  temperatura float not null,
  umidade float not null,
  luminosidade float not null,
  ph float not null,
  o2Dissolvido float not null,
  condutividadeElet float not null
) ENGINE = InnoDB;

-- --------------------------------------------------------

--
-- Table structure for table `TbUsuario`
--

CREATE TABLE TbUsuario (
  codUsuario int NOT NULL,
  nomeUsuario varchar(45) NOT NULL,
  foneUsuario varchar(15) NOT NULL,
  emailUsuario varchar(100) NOT NULL,
  loginUsuario varchar(15) NOT NULL,
  senhaUsuario varchar(15) NOT NULL,
  tipoUsuario int NOT NULL
) ENGINE = InnoDB;

--
-- Dumping data for table `TbUsuario`
--

INSERT INTO TbUsuario (codUsuario, nomeUsuario, foneUsuario, emailUsuario, loginUsuario, senhaUsuario, tipoUsuario) VALUES
(1, 'banana', '9999999', 'dasdasdasdasd', 'banana', '1234', 3),
(4, 'Alexandre', '99-9 9999 9999', 'jsbahsbdh', 'bessa', '123', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `TbCulturas`
--
ALTER TABLE TbCulturas
  ADD PRIMARY KEY (codCultura);

--
-- Indexes for table `TbDataRealTime`
--
ALTER TABLE TbDataRealTime
  ADD PRIMARY KEY (dataRT);

--
-- Indexes for table `TbUsuario`
--
ALTER TABLE TbUsuario
  ADD PRIMARY KEY (codUsuario);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `TbCulturas`
--
ALTER TABLE TbCulturas
  MODIFY codCultura int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 4;

--
-- AUTO_INCREMENT for table `TbUsuario`
--
ALTER TABLE TbUsuario
  MODIFY codUsuario int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 5;
COMMIT;