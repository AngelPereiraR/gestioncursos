-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-12-2022 a las 16:23:01
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
  `id` int(11) DEFAULT NULL,
  `idcurso` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

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
(30, 'Curso para aprender Java', '2022-12-31', '2022-12-01', 3, 'Java', NULL),
(31, 'Curso para aprender Python', '2023-01-31', '2023-01-01', 2, 'Python', NULL),
(33, 'Curso para aprender Laravel', '2023-02-28', '2023-02-01', 5, 'Laravel', NULL);

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
(34);

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `idnoticia` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `idadministrador` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `enabled`, `password`, `role`, `apellidos`, `foto`, `nombre`) VALUES
(1, 'admin@gmail.com', b'1', '$2a$10$aZp/pscdhzHU2Wsiv1mGceTSkpFxs.QBZozjBmeSv1zAoi.k2jqGu', 'ROLE_ADMIN', NULL, NULL, NULL),
(28, 'pepa@gmail.com', b'1', '$2a$10$1IjZ9GkRBb0WgBnBd6fQ/.DRryk8rMiiL2EHfN7Cv1MhUXTUMMj1u', 'ROLE_ALUMNO', 'Romero', 'http:www.url.com', 'Pepa'),
(27, 'paco@gmail.com', b'0', '$2a$10$ewOPkXymrKdk9jf6Mt8tJ./4unLIpibKXAZTqVzlnWfBOdgP604Ti', 'ROLE_ALUMNO', 'García', 'http:www.url.com', 'Paco'),
(26, 'pepe@gmail.com', b'1', '$2a$10$1aMjD7akQxrJu7j9KFdtTeNaTePCVOyYb0M4Yq0LxyuHaQtkHDGre', 'ROLE_ALUMNO', 'Gómez', 'http:www.url.com', 'Pepe'),
(21, 'maria@gmail.com', b'1', '$2a$10$3iwQ0urH.CU12ohogGq.VuaQLzhpHIv9iATMwgNiaR0A/q0iC0UXy', 'ROLE_PROFESOR', 'Rodríguez', NULL, 'María'),
(23, 'pedro@gmail.com', b'1', '$2a$10$EukE5g8AOQDZP8MzMLlMNOg3r/DaVipbAHtv..6BBogZ51mYQ00g.', 'ROLE_PROFESOR', 'Pereira', NULL, 'Pedro'),
(25, 'manuel@gmail.com', b'1', '$2a$10$LvrGPTINTcQ8AXfAHc3lNuIn0OYvCmJlHXd5s45OoWoddffKU1.uS', 'ROLE_PROFESOR', 'Mellado', NULL, 'Manuel');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idcomentario`),
  ADD KEY `FKqfm6rdu9qcdamfo9srf4q9kg6` (`id`),
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
