-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2023 at 09:30 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `automotive2`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `DealerID` int(11) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `From` varchar(255) NOT NULL,
  `DealerPhone` varchar(255) NOT NULL,
  `DealerMail` varchar(255) NOT NULL,
  `TotalSales` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`DealerID`, `Brand`, `From`, `DealerPhone`, `DealerMail`, `TotalSales`) VALUES
(1, 'Acura', 'Pakistan', '0876542134', 'akbar@gmail.com', 133),
(9, 'BMW', 'Italy', '082227391283', 'Momo@gmail.com', 13),
(2, 'Ferrari', 'Swiss', '09723142123', 'CarMaker18@gmail.com', 26),
(3, 'Honda', 'Japan', '081279567199', 'satoru@gmail.com', 214),
(4, 'Hyundai', 'Japan', '0777231382', 'Hidoki@gmail.com', 57),
(5, 'Lamborghini', 'Italy', '08775671234', 'richman23@gmail.com', 15),
(10, 'Lexus', 'America', '0812766283112', 'TonyS@gmail.com', 22),
(12, 'Mitsubishi', 'Japan', '064512391278', 'Jordony@gmail.com', 55),
(11, 'Subaru', 'Kenya', '09923127642', 'Zambic@gmail.com', 44),
(6, 'Tesla', 'America', '0897123478', 'Elon@gmail.com', 122),
(7, 'Toyota', 'Japan', '08771291872', 'Tokamo@gmail.com', 321),
(8, 'Wuling', 'Japan', '0882339125', 'Nokaru@gmail.com', 88);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `cID` int(11) NOT NULL,
  `Fuel` varchar(50) NOT NULL,
  `Brand` varchar(255) DEFAULT NULL,
  `Model` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `EngineSize` int(11) DEFAULT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`cID`, `Fuel`, `Brand`, `Model`, `Price`, `EngineSize`, `Stock`) VALUES
(2, 'Pertamina', 'Honda', 'BRV', 42000, 3, 155),
(3, 'Pertalite', 'Honda', 'CRV', 43500, 3, 15),
(4, 'Pertamax Turbo', 'Lamborghini', 'Aventador', 325000, 12, 22),
(5, 'Premium', 'Ferrari', 'Speedsz', 275000, 7, 14),
(7, 'Pertamax Turbo', 'Acura', 'AcuNos', 33000, 7, 117),
(8, 'Premium', 'Toyota', 'Avanza', 25500, 4, 32),
(9, 'Pertamax Turbo', 'Tesla', 'ZapCar', 75500, 9, 55),
(10, 'Premium', 'Tesla', 'ThunderBlast', 55600, 5, 22),
(11, 'Pertamax Turbo', 'Toyota', 'Supra', 65000, 6, 50),
(12, 'Pertamax', 'Toyota', 'Zenix', 40000, 4, 70),
(13, 'Pertamax Turbo', 'Lexus', 'RX300', 72000, 6, 42),
(14, 'Pertamax Turbo', 'Lexus', 'NX300', 66000, 4, 50),
(15, 'Pertamax Turbo', 'Lexus', 'LC500', 80000, 8, 30),
(16, 'Pertamax', 'Subaru', 'Forester', 38000, 4, 100),
(17, 'Pertamax', 'Subaru', 'XV', 37500, 4, 90),
(18, 'Pertamax Turbo', 'Subaru', 'BRZ', 45000, 4, 85),
(19, 'Pertamax Turbo', 'Lexus', 'NX300', 66000, 4, 50),
(20, 'Pertamax Turbo', 'BMW', 'X3', 70000, 4, 60),
(21, 'Pertamax Turbo', 'BMW', 'X3 Xdrive', 76000, 4, 55),
(22, 'Pertamax Turbo', 'BMW', '240i', 72000, 6, 40),
(23, 'Pertamina Dex', 'BMW', 'X5 40d', 74000, 6, 56),
(24, 'Pertamina Dex', 'BMW', '530', 71000, 6, 45),
(25, 'Electric', 'BMW', 'ix', 85000, 0, 30),
(26, 'Pertamax Turbo', 'BMW', '220i', 72000, 4, 40),
(27, 'Pertamax', 'BMW', 'X1', 42000, 3, 100),
(28, 'Pertamax', 'Mitsubishi', 'Xpander', 18000, 4, 150),
(29, 'Pertamax', 'Mitsubishi', 'Xpander Cross', 19000, 4, 140),
(30, 'Pertamina Dex', 'Mitsubishi', 'Pajero', 48000, 6, 108),
(31, 'Pertamina Dex', 'Toyota', 'Innova Reborn', 38500, 4, 75),
(32, 'Pertamina Dex', 'Toyota', 'Fortuner', 40000, 6, 73),
(33, 'Pertamax', 'Honda', 'BRV', 19000, 4, 165),
(34, 'Pertamax', 'Honda', 'WRV', 19500, 4, 130),
(35, 'Pertamax Turbo', 'Honda', 'CRV', 34500, 4, 122),
(36, 'Electric', 'Tesla', 'Model 3', 80000, 0, 64);

-- --------------------------------------------------------

--
-- Table structure for table `carprefs`
--

CREATE TABLE `carprefs` (
  `CarPreference` varchar(255) NOT NULL,
  `BudgetBelow` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `custID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Pin` varchar(255) NOT NULL,
  `CarPreference` varchar(255) DEFAULT NULL,
  `Job` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`custID`, `Username`, `Pin`, `CarPreference`, `Job`) VALUES
(1, 'Andrean', 'Hasan', 'Practical Car', 'Admin'),
(2, 'Dio', 'Jandro', 'Performance Car', 'Customer'),
(4, 'a', 'andrean', 'Practical Car', 'Customer'),
(5, 'b', 'babayo', 'Practical Car', 'Admin'),
(6, 'aa', 'a', 'Practical Car', 'Customer'),
(7, 'bb', 'b', 'Practical Car', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `fuel`
--

CREATE TABLE `fuel` (
  `Fuel` varchar(50) NOT NULL,
  `Price` int(11) DEFAULT NULL,
  `CO2Emmision` int(11) NOT NULL,
  `Octane` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fuel`
--

INSERT INTO `fuel` (`Fuel`, `Price`, `CO2Emmision`, `Octane`) VALUES
('Electric', 4200, 0, 0),
('Pertalite', 3200, 200, 89),
('Pertamax', 1300, 155, 96),
('Pertamax Turbo', 320, 188, 92),
('Pertamina', 2500, 155, 94),
('Pertamina Dex', 2200, 177, 95),
('Premium', 120, 321, 85);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `CustID` int(11) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Model` varchar(255) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`CustID`, `Date`, `Brand`, `Model`, `Price`) VALUES
(6, '16/01/2023 22:04:58', 'Acura', 'AcuNos', 33000),
(6, '16/01/2023 22:12:55', 'Honda', 'BRV', 42000),
(6, '16/01/2023 22:13:14', 'Acura', 'AcuNos', 33000),
(2, '16/01/2023 22:16:12', 'Acura', 'AcuNos', 33000),
(6, '16/01/2023 22:17:21', 'Acura', 'AcuNos', 33000),
(6, '16/01/2023 22:17:26', 'Lamborghini', 'Aventador', 325000),
(4, '17/01/2023 00:17:44', 'Acura', 'AcuNos', 33000),
(4, '17/01/2023 00:18:19', 'Acura', 'AcuNos', 33000),
(4, '17/01/2023 00:18:59', 'Acura', 'AcuNos', 33000),
(4, '17/01/2023 00:19:05', 'Acura', 'AcuNos', 33000),
(4, '17/01/2023 00:19:13', 'Acura', 'AcuNos', 33000),
(4, '19/01/2023 11:25:53', 'Acura', 'AcuNos', 33000),
(4, '19/01/2023 11:26:41', 'Acura', 'AcuNos', 33000),
(4, '19/01/2023 11:26:51', 'Acura', 'AcuNos', 33000),
(4, '21/01/2023 20:37:11', 'Acura', 'AcuNos', 33000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`Brand`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`cID`),
  ADD KEY `fk_car_fuel` (`Fuel`),
  ADD KEY `fk_car_brand` (`Brand`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`custID`);

--
-- Indexes for table `fuel`
--
ALTER TABLE `fuel`
  ADD PRIMARY KEY (`Fuel`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `fk_car_brand` FOREIGN KEY (`Brand`) REFERENCES `brand` (`Brand`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_car_fuel` FOREIGN KEY (`Fuel`) REFERENCES `fuel` (`Fuel`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
