-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2018 a las 15:01:55
-- Versión del servidor: 5.7.9
-- Versión de PHP: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hemofiliappdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libretavirtual`
--

DROP TABLE IF EXISTS `libretavirtual`;
CREATE TABLE IF NOT EXISTS `libretavirtual` (
  `idUsuario` int(11) NOT NULL,
  `FechaInfusion` date NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Lote1` varchar(20) NOT NULL,
  `FechaVencimiento1` date NOT NULL,
  `Potencia1` int(11) NOT NULL,
  `Lote2` varchar(20) DEFAULT NULL,
  `FechaVencimiento2` date DEFAULT NULL,
  `Potencia2` int(11) DEFAULT NULL,
  `Unidades` int(11) NOT NULL,
  `ProfilaxisDemanda` varchar(25) NOT NULL,
  `Motivo` varchar(200) DEFAULT NULL,
  `Observaciones` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libretavirtual`
--

INSERT INTO `libretavirtual` (`idUsuario`, `FechaInfusion`, `Marca`, `Lote1`, `FechaVencimiento1`, `Potencia1`, `Lote2`, `FechaVencimiento2`, `Potencia2`, `Unidades`, `ProfilaxisDemanda`, `Motivo`, `Observaciones`) VALUES
(0, '2000-02-03', 'Pochi', '2000', '2020-02-02', 2000, NULL, NULL, NULL, 1500, 'Profilaxis', NULL, NULL),
(0, '2018-04-04', 'bujhgfdfs', '45', '2018-02-04', 554, '48', '2018-02-06', 784, 35, 'Profilaxis', 'Me tocaba', 'Todo bien'),
(1, '2018-06-20', 'xyntha', '234', '2018-07-26', 544, NULL, NULL, NULL, 34, 'Profilaxis', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Mail` varchar(30) NOT NULL,
  `NombreApellido` varchar(80) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `NumLegajo` int(11) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Provincia` varchar(100) NOT NULL,
  `ObraSocial` varchar(100) NOT NULL,
  `Contraseña` varchar(30) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Mail`, `NombreApellido`, `FechaNacimiento`, `NumLegajo`, `Direccion`, `Provincia`, `ObraSocial`, `Contraseña`) VALUES
(1, 'brian@hola.com', 'Roni', '1996-05-28', 2739, 'hola 1234', 'Buenos aires', 'osde', 'cholo'),
(2, 'leo@guivi', 'toco', '2017-08-01', 23434, 'ort 123', 'buenos aires', 'medicus', 'lololo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
