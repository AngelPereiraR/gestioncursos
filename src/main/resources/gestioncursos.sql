-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 16-01-2023 a las 13:00:42
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestioncursos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `alumno` int(11) DEFAULT NULL,
  `idcurso` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`idcomentario`, `comentario`, `alumno`, `idcurso`) VALUES
(15, 'Buen curso donde aprender Python', 11, 5),
(16, 'Me ha encantado el curso', 11, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_fin` varchar(255) DEFAULT NULL,
  `fecha_inicio` varchar(255) DEFAULT NULL,
  `nivel` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idcurso`, `descripcion`, `fecha_fin`, `fecha_inicio`, `nivel`, `nombre`, `id`) VALUES
(4, 'Curso para aprender Java', '2023-01-31', '2023-01-01', 8, 'Java', 2),
(5, 'Curso para aprender Python', '2023-01-15', '2023-01-05', 7, 'Python', 3),
(8, 'Curso para aprender Laravel', '2023-01-15', '2023-01-01', 3, 'Laravel', 2),
(9, 'Curso para aprender Flutter', '2023-02-08', '2023-01-31', 8, 'Flutter', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `idmatricula` int(11) NOT NULL,
  `valoracion` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `idcurso` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`idmatricula`, `valoracion`, `id`, `idcurso`) VALUES
(14, 7, 11, 5),
(17, 0, 11, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `idnoticia` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_creacion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `idadministrador` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`idnoticia`, `descripcion`, `fecha_creacion`, `imagen`, `titulo`, `idadministrador`) VALUES
(6, 'Esta es la primera noticia', '2023-01-16', 'http://localhost:8080/imgs/2020-mayo-el-periodico-xavi-savin-b6a18975-2a47-4c8b-92b0-ab18b21cd3f6.jpg', 'Primera Noticia', 1),
(7, 'Esta es la segunda noticia', '2023-01-07', 'http://localhost:8080/imgs/fotonoticia_20220225004313_1200.jpg', 'Segunda Noticia', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `email`, `enabled`, `foto`, `nombre`, `password`, `role`) VALUES
(1, '', 'admin@gmail.com', b'0', '', '', '$2a$10$iX3FmXNX52NyN4RgkkGEhumm.B8oTdIXB0P5OuNOgK5du1IoNEBv2', 'ROLE_ADMIN'),
(2, 'Gómez', 'pepe@gmail.com', b'1', NULL, 'Pepe', '$2a$10$CAcQvSYfsfUAl4zWu3LveeS9wtHczevEA7NfAX9gshkQq5/P/xxq2', 'ROLE_PROFESOR'),
(3, 'Pereira', 'angel@gmail.com', b'1', NULL, 'Angel', '$2a$10$4sCyyIipl.HWv0M1P4jLbuAd38vUqhXaC9wbHLw9x3LY9NrE3YG8u', 'ROLE_PROFESOR'),
(10, 'García', 'paco@gmail.com', b'1', '', 'Paco', '$2a$10$i8y3dkl7WSoTm91RUQsN9ubnGQQe6qvibEK/Yjeg1vJFWphtO79CW', 'ROLE_ALUMNO'),
(11, 'Mellado', 'pedro@gmail.com', b'0', '', 'Pedro', '$2a$10$QN07onDonKBiBzEbWjiC5uanR9aF/8RrQ.9qm4qty2PMQelfDlC7K', 'ROLE_ALUMNO'),
(12, 'Rodríguez', 'maria@gmail.com', b'1', '', 'María', '$2a$10$03fvFPDS/hkuuif61H5NZuqBQeFcc13Unnjyrs5FcQGfedUx50TVK', 'ROLE_ALUMNO'),
(13, 'Romero', 'manuel@gmail.com', b'0', '', 'Manuel', '$2a$10$CpdyJrlora/xdAXVL7afYu1jUkG5pzuS2chVyGRgZaWxnzUpURnN6', 'ROLE_ALUMNO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idcomentario`),
  ADD KEY `FKh077qhhmgt2l9nd1kj7fwe8hf` (`alumno`),
  ADD KEY `FKsnu5vylks0rctei8d0j7b10mr` (`idcurso`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idcurso`),
  ADD KEY `FK20w2sugcoegkmxum9sg1h8pup` (`id`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`idmatricula`),
  ADD KEY `FKpt7vn4pa9garp2g381j0erwfv` (`id`),
  ADD KEY `FKdnrnlikga866xl14lj3kvqdno` (`idcurso`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`idnoticia`),
  ADD KEY `FKby8mt7tbkni8yenol6mkd65f8` (`idadministrador`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
