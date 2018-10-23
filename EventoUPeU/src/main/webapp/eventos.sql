-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2018 a las 16:47:40
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eventos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idAsistencia` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idEvento` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `companhia` varchar(40) NOT NULL,
  `fechahora` varchar(20) NOT NULL,
  `ofline` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`idAsistencia`, `idPersona`, `idUsuario`, `idEvento`, `codigo`, `nombres`, `companhia`, `fechahora`, `ofline`) VALUES
(1, 2, 1, 1, '200410564', 'David Mamani  x', 'UPeU', '2018-10-16', 'no'),
(4, 2, 1, 2, 'N:54876598\r', 'ORG:company Inc.\r', 'ORG:company Inc.\r', '2018-10-23', 'no'),
(5, 2, 1, 2, 'N:43631917\r', 'ORG:company Inc.\r', 'ORG:company Inc.\r', '2018-10-23', 'no'),
(6, 2, 1, 2, 'N:43631917\r', 'ORG:company Inc.\r', 'ORG:company Inc.\r', '2018-10-23', 'no'),
(7, 2, 1, 2, 'N:54876598\r', 'ORG:company Inc.\r', 'ORG:company Inc.\r', '2018-10-23', 'no');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `horainicio` varchar(8) NOT NULL,
  `horafin` varchar(8) NOT NULL,
  `nombreevento` varchar(40) NOT NULL,
  `lugarevento` varchar(40) NOT NULL,
  `tiempotolerancia` varchar(6) NOT NULL,
  `estado` varchar(5) NOT NULL,
  `longitud` decimal(10,0) NOT NULL,
  `latitud` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`idEvento`, `fecha`, `horainicio`, `horafin`, `nombreevento`, `lugarevento`, `tiempotolerancia`, `estado`, `longitud`, `latitud`) VALUES
(1, '2018-09-13', '', '10:00', 'Cultura', 'Paraninfo', '15', '1', '0', '0'),
(2, '2018-10-23', '10:00', '12:00', 'Cultura', 'Paraninfo', '15', '1', '0', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `idMensajes` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `numeroenvio` varchar(10) NOT NULL,
  `numerorecepcion` varchar(10) NOT NULL,
  `mensajeentregado` varchar(60) NOT NULL,
  `tipomensaje` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `dnicodigo` varchar(8) NOT NULL,
  `email` varchar(40) NOT NULL,
  `numerocelular` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `nombres`, `apellidos`, `dnicodigo`, `email`, `numerocelular`) VALUES
(1, 'Dario', 'Gonzales Perez', '43631917', 'dario@gmail.com', '951782520'),
(2, 'Elias', 'Peredo Ramirez', '54876598', 'elias@gmail.com', '9782014');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantmensaje`
--

CREATE TABLE `plantmensaje` (
  `idPlantmensaje` int(11) NOT NULL,
  `tipomensaje` varchar(10) NOT NULL,
  `mensajeprevio` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(30) NOT NULL,
  `estadousuario` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `idPersona`, `usuario`, `clave`, `estadousuario`) VALUES
(1, 1, 'dario', '123456', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idAsistencia`),
  ADD KEY `evento_asistencia_fk` (`idEvento`),
  ADD KEY `persona_asistencia_fk` (`idPersona`),
  ADD KEY `usuario_asistencia_fk` (`idUsuario`);

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`idEvento`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`idMensajes`),
  ADD KEY `persona_mensajes_fk` (`idPersona`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `plantmensaje`
--
ALTER TABLE `plantmensaje`
  ADD PRIMARY KEY (`idPlantmensaje`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `persona_usuario_fk` (`idPersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `idAsistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `plantmensaje`
--
ALTER TABLE `plantmensaje`
  MODIFY `idPlantmensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `evento_asistencia_fk` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `persona_asistencia_fk` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuario_asistencia_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `persona_mensajes_fk` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `persona_usuario_fk` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
