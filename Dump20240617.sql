CREATE DATABASE  IF NOT EXISTS `modaurbana` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `modaurbana`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: modaurbana
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `id_carrinho` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto_carrinho` varchar(255) DEFAULT NULL,
  `valor_produto_carrinho` float(8,2) DEFAULT NULL,
  `imagem_produto_carrinho` longblob DEFAULT NULL,
  `descricao_produto_carrinho` varchar(255) DEFAULT NULL,
  `quantidade_carrinho` int(11) DEFAULT NULL,
  `tamanho_id3` int(11) DEFAULT NULL,
  `produto_id3` int(11) DEFAULT NULL,
  `categoria_id3` int(11) DEFAULT NULL,
  `total` float(8,2) DEFAULT NULL,
  `total_produtos` float(8,3) DEFAULT NULL,
  `usuario_id3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carrinho`),
  KEY `categoria_id3` (`categoria_id3`),
  KEY `usuario_id3` (`usuario_id3`),
  KEY `tamanho_id3` (`tamanho_id3`),
  KEY `produto_id3` (`produto_id3`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`categoria_id3`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `carrinho_ibfk_2` FOREIGN KEY (`usuario_id3`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `carrinho_ibfk_3` FOREIGN KEY (`tamanho_id3`) REFERENCES `tamanho` (`id_tamanho`),
  CONSTRAINT `carrinho_ibfk_4` FOREIGN KEY (`produto_id3`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Camiseta'),(2,'Camisa'),(3,'Calça'),(4,'Jaqueta'),(5,'Bermuda');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecos` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id1` int(11) DEFAULT NULL,
  `rua` varchar(75) NOT NULL,
  `numero` int(11) NOT NULL,
  `cep` char(9) NOT NULL,
  `complemento` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `usuario_id1` (`usuario_id1`),
  CONSTRAINT `enderecos_ibfk_1` FOREIGN KEY (`usuario_id1`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` VALUES (1,1,'Nome da Rua',123,'12345-678','Complemento Exemplo');
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id2` int(11) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `pedidos_produtos_id` int(11) DEFAULT NULL,
  `status_entrega` enum('Em andamento','Entregue') DEFAULT 'Em andamento',
  `metodo_pagamento` enum('pix','debito','credito') NOT NULL,
  `data_pedido` datetime DEFAULT NULL,
  `data_prevista` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `usuario_id2` (`usuario_id2`),
  KEY `endereco_id` (`endereco_id`),
  KEY `pedidos_produtos_id` (`pedidos_produtos_id`),
  CONSTRAINT `endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id_endereco`),
  CONSTRAINT `pedidos_produtos_id` FOREIGN KEY (`pedidos_produtos_id`) REFERENCES `pedidos_produtos` (`id_pedidosProdutos`),
  CONSTRAINT `usuario_id2` FOREIGN KEY (`usuario_id2`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_produtos`
--

DROP TABLE IF EXISTS `pedidos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos_produtos` (
  `id_pedidosProdutos` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produtos_pedidos` varchar(255) DEFAULT NULL,
  `valor_pedidos_produtos` float(8,2) DEFAULT NULL,
  `imagem_pedidos_produtos` longblob DEFAULT NULL,
  `descricao_pedidos_produtos` varchar(255) DEFAULT NULL,
  `quantidade_pedidos_produtos` int(11) DEFAULT NULL,
  `tamanho_id4` int(11) DEFAULT NULL,
  `produto_id4` int(11) DEFAULT NULL,
  `usuario_id4` int(11) DEFAULT NULL,
  `categoria_id4` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedidosProdutos`),
  KEY `produto_id4` (`produto_id4`),
  KEY `tamanho_id4` (`tamanho_id4`),
  KEY `categoria_id4` (`categoria_id4`),
  CONSTRAINT `categoria_id4` FOREIGN KEY (`categoria_id4`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `produto_id4` FOREIGN KEY (`produto_id4`) REFERENCES `produtos` (`id_produto`),
  CONSTRAINT `tamanho_id4` FOREIGN KEY (`tamanho_id4`) REFERENCES `tamanho` (`id_tamanho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_produtos`
--

LOCK TABLES `pedidos_produtos` WRITE;
/*!40000 ALTER TABLE `pedidos_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) DEFAULT NULL,
  `nome_produto` varchar(255) DEFAULT NULL,
  `imagem` longblob DEFAULT NULL,
  `imagem1` longblob DEFAULT NULL,
  `imagem2` longblob DEFAULT NULL,
  `imagem3` longblob DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `tamanho_id` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `tamanho_id` (`tamanho_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`tamanho_id`) REFERENCES `tamanho` (`id_tamanho`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,1,'Camiseta','assets/camisetaBrancaImagem1.jpg','assets/camisetaBrancaImagem1.jpg','assets/imagem2CamisetaBranca.jpg','assets/imagem3CamisetaPreta.jpg','Camisetas de algodao',1,20,20.00),(2,1,'Camiseta','assets/camisetaBrancaImagem1.jpg','assets/camisetaBrancaImagem1.jpg','assets/imagem2CamisetaBranca.jpg','assets/imagem3CamisetaPreta.jpg','Camisetas de algodao',1,20,20.00),(3,1,'Camiseta','assets/camisetaBrancaImagem1.jpg','assets/camisetaBrancaImagem1.jpg','assets/imagem2CamisetaBranca.jpg','assets/imagem3CamisetaPreta.jpg','Camisetas de algodao',1,20,20.00),(4,2,'Camisa','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',4,50,50.00),(5,2,'Camisa','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',1,50,50.00),(6,2,'Camisa','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',3,50,50.00),(7,3,'Calça','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',2,50,50.00),(8,3,'Calça','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',1,50,50.00),(9,3,'Calça','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',3,50,50.00),(10,4,'Jaqueta','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',1,50,50.00),(11,4,'Jaqueta','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',2,50,50.00),(12,4,'Jaqueta','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',4,50,50.00),(13,5,'Bermuda','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',4,50,50.00),(14,5,'Bermuda','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',3,50,50.00),(15,5,'Bermuda','assets/jaquetaJeans.jpg',NULL,NULL,NULL,'Jaqueta Jeans',1,50,50.00);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamanho`
--

DROP TABLE IF EXISTS `tamanho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tamanho` (
  `id_tamanho` int(11) NOT NULL AUTO_INCREMENT,
  `tamanho_produto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tamanho`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamanho`
--

LOCK TABLES `tamanho` WRITE;
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` VALUES (1,'GG'),(2,'G'),(3,'M'),(4,'P');
/*!40000 ALTER TABLE `tamanho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(155) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `telefone` char(15) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `cpf` char(15) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario` (`usuario`,`cpf`,`telefone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin','admin','43 1234-5678',NULL,'123.456.789-10');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'modaurbana'
--

--
-- Dumping routines for database 'modaurbana'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-17 17:28:20
