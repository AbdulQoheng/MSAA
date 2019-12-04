-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 04, 2019 at 01:14 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `msaa_aplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `absen`
--

CREATE TABLE `absen` (
  `no_absen` int(11) NOT NULL,
  `bulan` varchar(20) DEFAULT NULL,
  `Hadir` int(11) DEFAULT NULL,
  `alpha` int(11) NOT NULL,
  `izin` int(11) NOT NULL,
  `sakit` int(11) NOT NULL,
  `kelastakl` varchar(2) NOT NULL,
  `no_tingkattak` int(11) NOT NULL,
  `no_Takl` int(11) NOT NULL,
  `nim_mhs` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absen`
--

INSERT INTO `absen` (`no_absen`, `bulan`, `Hadir`, `alpha`, `izin`, `sakit`, `kelastakl`, `no_tingkattak`, `no_Takl`, `nim_mhs`) VALUES
(3, 'Februari', 25, 4, 4, 2, 'A', 1, 1, 122),
(5, 'Maret', 29, 1, 0, 0, 'A', 1, 1, 122),
(6, 'April', 27, 1, 2, 0, 'A', 1, 1, 122),
(7, 'Mei', 26, 1, 3, 0, 'A', 1, 1, 122),
(8, 'Juni', 28, 1, 1, 0, 'A', 1, 1, 122),
(9, 'Juni', 28, 1, 1, 0, 'A', 1, 1, 122),
(10, 'Juli', 14, 15, 1, 0, 'A', 1, 1, 122);

-- --------------------------------------------------------

--
-- Table structure for table `acount_musyrifah`
--

CREATE TABLE `acount_musyrifah` (
  `userid` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kode_mab` varchar(5) NOT NULL,
  `id_devisi` int(11) NOT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `acount_musyrifah`
--

INSERT INTO `acount_musyrifah` (`userid`, `nama`, `kode_mab`, `id_devisi`, `password`) VALUES
('1234', 'qoheng', 'mba1', 2, 'jenengku'),
('123456', 'ihhiiiiii', 'mba1', 2, 'alksdjflk'),
('1234565', 'lkjhgf', 'mba3', 2, 'lkjhgfd'),
('18650051', 'qohar', 'mba3', 2, 'Ubudiah');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `user` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`user`, `password`) VALUES
('admin', 'pass');

-- --------------------------------------------------------

--
-- Table structure for table `devisi`
--

CREATE TABLE `devisi` (
  `id_devisi` int(11) NOT NULL,
  `nama_devisi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devisi`
--

INSERT INTO `devisi` (`id_devisi`, `nama_devisi`) VALUES
(2, 'Ubudiah');

-- --------------------------------------------------------

--
-- Table structure for table `fakultas`
--

CREATE TABLE `fakultas` (
  `kode_fak` varchar(5) NOT NULL,
  `nama_fak` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fakultas`
--

INSERT INTO `fakultas` (`kode_fak`, `nama_fak`) VALUES
('Fak1', 'EKONOMI'),
('fak2', 'SAINTEK'),
('hhgf', 'PSIKOLOG');

-- --------------------------------------------------------

--
-- Table structure for table `jurusan`
--

CREATE TABLE `jurusan` (
  `kode_jur` varchar(5) NOT NULL,
  `nama_jur` varchar(20) DEFAULT NULL,
  `kode_fak` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jurusan`
--

INSERT INTO `jurusan` (`kode_jur`, `nama_jur`, `kode_fak`) VALUES
('123', 'TI', 'fak2');

-- --------------------------------------------------------

--
-- Table structure for table `mabna`
--

CREATE TABLE `mabna` (
  `kode_mab` varchar(5) NOT NULL,
  `nama_mab` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mabna`
--

INSERT INTO `mabna` (`kode_mab`, `nama_mab`) VALUES
('mba1', 'ghazali'),
('mba3', 'kholdun');

-- --------------------------------------------------------

--
-- Table structure for table `mahasantri`
--

CREATE TABLE `mahasantri` (
  `nim_mahasantri` int(10) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `kode_jur` varchar(5) NOT NULL,
  `kode_mab` varchar(5) DEFAULT NULL,
  `lantai` int(3) DEFAULT NULL,
  `kamar` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasantri`
--

INSERT INTO `mahasantri` (`nim_mahasantri`, `nama`, `kode_jur`, `kode_mab`, `lantai`, `kamar`) VALUES
(13, 'asdfa', '123', 'mba1', 3, 12),
(14, 'jyhtgr', '123', 'mba3', 2, 20),
(15, 'asfd', '123', 'mba3', 2, 12),
(16, 'asdfa', '123', 'mba3', 1, 32),
(17, 'qwte', '123', 'mba3', 2, 16),
(18, 'hwgra', '123', 'mba3', 2, 17),
(19, 'jyhtgr', '123', 'mba3', 1, 15),
(20, '5wyea', '123', 'mba3', 2, 21),
(21, 'jeth', '123', 'mba3', 4, 20),
(22, 'ertg', '123', 'mba3', 2, 12),
(122, 'erfgh', '123', 'mba1', 2, 23),
(324, 'fngbdfv', '123', 'mba3', 3, 14),
(666, 'werth', '123', NULL, 2, 23),
(1111, 'wergh', '123', 'mba3', 2, 24),
(1234, 'iyowes', '123', 'mba1', 3, 17);

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `no_nilai` int(11) NOT NULL,
  `jenis` varchar(5) DEFAULT NULL,
  `nilai` int(11) DEFAULT NULL,
  `no_Takl` int(11) NOT NULL,
  `no_tingkattakl` int(11) NOT NULL,
  `kelastakl` varchar(11) NOT NULL,
  `nim_mhs` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`no_nilai`, `jenis`, `nilai`, `no_Takl`, `no_tingkattakl`, `kelastakl`, `nim_mhs`) VALUES
(1, 'UTS', 80, 1, 1, 'A', 122),
(2, 'UAS', 70, 1, 1, 'A', 122);

-- --------------------------------------------------------

--
-- Table structure for table `tahsin`
--

CREATE TABLE `tahsin` (
  `no_tahsin` int(11) NOT NULL,
  `bulan` varchar(20) DEFAULT NULL,
  `juz` int(2) DEFAULT NULL,
  `surat` int(3) DEFAULT NULL,
  `ayat` int(5) DEFAULT NULL,
  `nim_mhs` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tahsin`
--

INSERT INTO `tahsin` (`no_tahsin`, `bulan`, `juz`, `surat`, `ayat`, `nim_mhs`) VALUES
(1, 'Januari', 2, 12, 1, 122),
(2, 'Februari', 5, 12, 122, 122);

-- --------------------------------------------------------

--
-- Table structure for table `taklim`
--

CREATE TABLE `taklim` (
  `no_Takl` int(11) NOT NULL,
  `namaTakl` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taklim`
--

INSERT INTO `taklim` (`no_Takl`, `namaTakl`) VALUES
(1, 'al quran');

-- --------------------------------------------------------

--
-- Table structure for table `tingakTaklim`
--

CREATE TABLE `tingakTaklim` (
  `no_tingkattak` int(11) NOT NULL,
  `namatingkat` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tingakTaklim`
--

INSERT INTO `tingakTaklim` (`no_tingkattak`, `namatingkat`) VALUES
(1, 'asasi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absen`
--
ALTER TABLE `absen`
  ADD PRIMARY KEY (`no_absen`),
  ADD KEY `no_Takl` (`no_Takl`),
  ADD KEY `nim_mhs` (`nim_mhs`),
  ADD KEY `no_tingkattak` (`no_tingkattak`);

--
-- Indexes for table `acount_musyrifah`
--
ALTER TABLE `acount_musyrifah`
  ADD PRIMARY KEY (`userid`),
  ADD KEY `kode_mab` (`kode_mab`),
  ADD KEY `acount_musyrifah_ibfk_2` (`id_devisi`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`user`);

--
-- Indexes for table `devisi`
--
ALTER TABLE `devisi`
  ADD PRIMARY KEY (`id_devisi`);

--
-- Indexes for table `fakultas`
--
ALTER TABLE `fakultas`
  ADD PRIMARY KEY (`kode_fak`);

--
-- Indexes for table `jurusan`
--
ALTER TABLE `jurusan`
  ADD PRIMARY KEY (`kode_jur`),
  ADD KEY `jurusan_ibfk_1` (`kode_fak`);

--
-- Indexes for table `mabna`
--
ALTER TABLE `mabna`
  ADD PRIMARY KEY (`kode_mab`);

--
-- Indexes for table `mahasantri`
--
ALTER TABLE `mahasantri`
  ADD PRIMARY KEY (`nim_mahasantri`),
  ADD KEY `fk_kodemabana` (`kode_mab`),
  ADD KEY `fk_kodejur` (`kode_jur`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`no_nilai`),
  ADD KEY `fk_nim_mhs` (`nim_mhs`),
  ADD KEY `no_tingkattakl` (`no_tingkattakl`),
  ADD KEY `no_Takl` (`no_Takl`);

--
-- Indexes for table `tahsin`
--
ALTER TABLE `tahsin`
  ADD PRIMARY KEY (`no_tahsin`),
  ADD KEY `nim_mhs` (`nim_mhs`);

--
-- Indexes for table `taklim`
--
ALTER TABLE `taklim`
  ADD PRIMARY KEY (`no_Takl`);

--
-- Indexes for table `tingakTaklim`
--
ALTER TABLE `tingakTaklim`
  ADD PRIMARY KEY (`no_tingkattak`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absen`
--
ALTER TABLE `absen`
  MODIFY `no_absen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `devisi`
--
ALTER TABLE `devisi`
  MODIFY `id_devisi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `no_nilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tahsin`
--
ALTER TABLE `tahsin`
  MODIFY `no_tahsin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `taklim`
--
ALTER TABLE `taklim`
  MODIFY `no_Takl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tingakTaklim`
--
ALTER TABLE `tingakTaklim`
  MODIFY `no_tingkattak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absen`
--
ALTER TABLE `absen`
  ADD CONSTRAINT `absen_ibfk_1` FOREIGN KEY (`no_Takl`) REFERENCES `taklim` (`no_Takl`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absen_ibfk_2` FOREIGN KEY (`nim_mhs`) REFERENCES `mahasantri` (`nim_mahasantri`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absen_ibfk_3` FOREIGN KEY (`no_tingkattak`) REFERENCES `tingakTaklim` (`no_tingkattak`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `acount_musyrifah`
--
ALTER TABLE `acount_musyrifah`
  ADD CONSTRAINT `acount_musyrifah_ibfk_1` FOREIGN KEY (`kode_mab`) REFERENCES `mabna` (`kode_mab`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `acount_musyrifah_ibfk_2` FOREIGN KEY (`id_devisi`) REFERENCES `devisi` (`id_devisi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `jurusan`
--
ALTER TABLE `jurusan`
  ADD CONSTRAINT `jurusan_ibfk_1` FOREIGN KEY (`kode_fak`) REFERENCES `fakultas` (`kode_fak`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mahasantri`
--
ALTER TABLE `mahasantri`
  ADD CONSTRAINT `fk_kodejur` FOREIGN KEY (`kode_jur`) REFERENCES `jurusan` (`kode_jur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kodemabana` FOREIGN KEY (`kode_mab`) REFERENCES `mabna` (`kode_mab`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `fk_nim_mhs` FOREIGN KEY (`nim_mhs`) REFERENCES `mahasantri` (`nim_mahasantri`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`no_tingkattakl`) REFERENCES `tingakTaklim` (`no_tingkattak`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_3` FOREIGN KEY (`no_Takl`) REFERENCES `taklim` (`no_Takl`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tahsin`
--
ALTER TABLE `tahsin`
  ADD CONSTRAINT `tahsin_ibfk_1` FOREIGN KEY (`nim_mhs`) REFERENCES `mahasantri` (`nim_mahasantri`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
