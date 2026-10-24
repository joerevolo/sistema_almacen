-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.46 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sistema_almacen
CREATE DATABASE IF NOT EXISTS `sistema_almacen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema_almacen`;

-- Volcando estructura para tabla sistema_almacen.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1250 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_almacen.empleados: ~6 rows (aproximadamente)
INSERT INTO `empleados` (`id`, `nombre`, `edad`, `categoria`, `fecha_creacion`, `fecha_actualizacion`) VALUES
	(1240, 'joe', 30, 'JUNIOR', '2026-10-21 21:23:40', '2026-10-21 21:46:00'),
	(1241, 'milagros', 21, 'JUNIOR', '2026-10-21 21:23:40', '2026-10-21 21:23:40'),
	(1245, 'a', 21, 'JUNIOR', '2026-10-21 21:23:40', '2026-10-21 21:23:40'),
	(1246, 'w', 40, 'SENIOR', '2026-10-21 21:23:40', '2026-10-21 21:23:40'),
	(1247, 'p', 30, 'SENIOR', '2026-10-21 21:45:31', '2026-10-21 21:45:31'),
	(1249, 'master', 40, 'SENIOR', '2026-10-21 21:50:01', '2026-10-21 21:50:01');

-- Volcando estructura para tabla sistema_almacen.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pasword` varchar(255) NOT NULL,
  `rol` varchar(20) DEFAULT 'user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla sistema_almacen.usuarios: ~2 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `nombre`, `email`, `pasword`, `rol`) VALUES
	(1, 'administrador', 'admin@papas.com', 'admin123', 'admin'),
	(2, 'prueba', 'prueba@papas.com', '1234', 'USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
