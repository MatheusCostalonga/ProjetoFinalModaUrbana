-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: modaurbana
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinho` (
  `id_carrinho` int NOT NULL AUTO_INCREMENT,
  `nome_produto_carrinho` varchar(255) DEFAULT NULL,
  `valor_produto_carrinho` float(8,2) DEFAULT NULL,
  `imagem_produto_carrinho` longblob,
  `descricao_produto_carrinho` varchar(255) DEFAULT NULL,
  `quantidade_carrinho` int DEFAULT NULL,
  `tamanho_id3` int DEFAULT NULL,
  `produto_id3` int DEFAULT NULL,
  `categoria_id3` int DEFAULT NULL,
  `total` float(8,2) DEFAULT NULL,
  `total_produtos` float(8,3) DEFAULT NULL,
  `usuario_id3` int DEFAULT NULL,
  PRIMARY KEY (`id_carrinho`),
  KEY `categoria_id3` (`categoria_id3`),
  KEY `usuario_id3` (`usuario_id3`),
  KEY `tamanho_id3` (`tamanho_id3`),
  KEY `produto_id3` (`produto_id3`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`categoria_id3`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `carrinho_ibfk_2` FOREIGN KEY (`usuario_id3`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `carrinho_ibfk_3` FOREIGN KEY (`tamanho_id3`) REFERENCES `tamanho` (`id_tamanho`),
  CONSTRAINT `carrinho_ibfk_4` FOREIGN KEY (`produto_id3`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoriapedidosproduto`
--

DROP TABLE IF EXISTS `categoriapedidosproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoriapedidosproduto` (
  `id_categoriaPedidosProduto` int NOT NULL AUTO_INCREMENT,
  `categoriaId` int DEFAULT NULL,
  `pedidosClienteId` int DEFAULT NULL,
  PRIMARY KEY (`id_categoriaPedidosProduto`),
  KEY `categoriaId` (`categoriaId`),
  KEY `pedidosClienteId` (`pedidosClienteId`),
  CONSTRAINT `categoriapedidosproduto_ibfk_1` FOREIGN KEY (`categoriaId`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `categoriapedidosproduto_ibfk_2` FOREIGN KEY (`pedidosClienteId`) REFERENCES `pedidos_cliente` (`id_pedidosCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriapedidosproduto`
--

LOCK TABLES `categoriapedidosproduto` WRITE;
/*!40000 ALTER TABLE `categoriapedidosproduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoriapedidosproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enderecos` (
  `id_endereco` int NOT NULL AUTO_INCREMENT,
  `usuario_id1` int DEFAULT NULL,
  `rua` varchar(75) NOT NULL,
  `numero` int NOT NULL,
  `cep` char(9) NOT NULL,
  `complemento` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `usuario_id1` (`usuario_id1`),
  CONSTRAINT `enderecos_ibfk_1` FOREIGN KEY (`usuario_id1`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `pedidos_adm`
--

DROP TABLE IF EXISTS `pedidos_adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_adm` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `usuario_id2` int DEFAULT NULL,
  `endereco_id` int DEFAULT NULL,
  `pedidos_clientes_id` int DEFAULT NULL,
  `status_entrega` enum('Pendente','Em andamento','Entregue') DEFAULT 'Pendente',
  `metodo_pagamento` enum('pix','debito','credito') NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `usuario_id2` (`usuario_id2`),
  KEY `endereco_id` (`endereco_id`),
  KEY `pedidos_clientes_id` (`pedidos_clientes_id`),
  CONSTRAINT `endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id_endereco`),
  CONSTRAINT `pedidos_clientes_id` FOREIGN KEY (`pedidos_clientes_id`) REFERENCES `pedidos_cliente` (`id_pedidosCliente`),
  CONSTRAINT `usuario_id2` FOREIGN KEY (`usuario_id2`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_adm`
--

LOCK TABLES `pedidos_adm` WRITE;
/*!40000 ALTER TABLE `pedidos_adm` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_adm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_cliente`
--

DROP TABLE IF EXISTS `pedidos_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos_cliente` (
  `id_pedidosCliente` int NOT NULL AUTO_INCREMENT,
  `nome_produtos_pedidos` varchar(255) DEFAULT NULL,
  `valor_pedidos_produtos` float(8,2) DEFAULT NULL,
  `imagem_pedidos_produtos` longblob,
  `descricao_pedidos_produtos` varchar(255) DEFAULT NULL,
  `quantidade_pedidos_produtos` int DEFAULT NULL,
  `data_pedido` datetime DEFAULT NULL,
  `tamanho_id4` int DEFAULT NULL,
  `produto_id4` int DEFAULT NULL,
  `usuario_id4` int DEFAULT NULL,
  `categoria_id4` int DEFAULT NULL,
  PRIMARY KEY (`id_pedidosCliente`),
  KEY `categoria_id4` (`categoria_id4`),
  KEY `usuario_id4` (`usuario_id4`),
  KEY `tamanho_id4` (`tamanho_id4`),
  KEY `produto_id4` (`produto_id4`),
  CONSTRAINT `pedidos_cliente_ibfk_1` FOREIGN KEY (`categoria_id4`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `pedidos_cliente_ibfk_2` FOREIGN KEY (`usuario_id4`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `pedidos_cliente_ibfk_3` FOREIGN KEY (`tamanho_id4`) REFERENCES `tamanho` (`id_tamanho`),
  CONSTRAINT `pedidos_cliente_ibfk_4` FOREIGN KEY (`produto_id4`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_cliente`
--

LOCK TABLES `pedidos_cliente` WRITE;
/*!40000 ALTER TABLE `pedidos_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidosendereco`
--

DROP TABLE IF EXISTS `pedidosendereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidosendereco` (
  `id_pedidosEndereco` int NOT NULL AUTO_INCREMENT,
  `pedidosAdmId` int DEFAULT NULL,
  `enderecoId` int DEFAULT NULL,
  PRIMARY KEY (`id_pedidosEndereco`),
  KEY `pedidosAdmId` (`pedidosAdmId`),
  KEY `enderecoId` (`enderecoId`),
  CONSTRAINT `pedidosendereco_ibfk_1` FOREIGN KEY (`pedidosAdmId`) REFERENCES `pedidos_adm` (`id_pedido`),
  CONSTRAINT `pedidosendereco_ibfk_2` FOREIGN KEY (`enderecoId`) REFERENCES `enderecos` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidosendereco`
--

LOCK TABLES `pedidosendereco` WRITE;
/*!40000 ALTER TABLE `pedidosendereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidosendereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtopedidoscliente`
--

DROP TABLE IF EXISTS `produtopedidoscliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtopedidoscliente` (
  `id_produtoPedidosProduto` int NOT NULL AUTO_INCREMENT,
  `categoriaId` int DEFAULT NULL,
  `pedidosClienteId` int DEFAULT NULL,
  PRIMARY KEY (`id_produtoPedidosProduto`),
  KEY `categoriaId` (`categoriaId`),
  KEY `pedidosClienteId` (`pedidosClienteId`),
  CONSTRAINT `produtopedidoscliente_ibfk_1` FOREIGN KEY (`categoriaId`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `produtopedidoscliente_ibfk_2` FOREIGN KEY (`pedidosClienteId`) REFERENCES `pedidos_cliente` (`id_pedidosCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtopedidoscliente`
--

LOCK TABLES `produtopedidoscliente` WRITE;
/*!40000 ALTER TABLE `produtopedidoscliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtopedidoscliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produto` int NOT NULL AUTO_INCREMENT,
  `categoria_id` int DEFAULT NULL,
  `nome_produto` varchar(255) DEFAULT NULL,
  `imagem` longblob,
  `descricao` varchar(255) DEFAULT NULL,
  `tamanho_id` int DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `valor` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `tamanho_id` (`tamanho_id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`tamanho_id`) REFERENCES `tamanho` (`id_tamanho`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,1,'Camiseta Branca',_binary 'assets/CamisetaBranca.jpg','Camiseta Branca de algodão',1,20,20.00),(2,1,'Camiseta Preta',_binary 'assets/CamisetaPreta.jpg','Camiseta Preta de Seda',1,20,20.00),(3,1,'Camiseta Azul',_binary 'assets/CamisetaAzul.jpg','Camisetas de Poliéster',1,20,20.00),(4,1,'Camiseta Cinza',_binary 'assets/CamisetaCinza.jpg','Camisetas de Elastano',1,20,20.00),(5,1,'Camiseta Vermelha',_binary 'assets/CamisetaVermelha.jpg','Camisetas de Nylon',1,20,20.00),(6,2,'Camisa Vermelha',_binary 'assets/CamisaVermelha.jpg','Camisa de Nylon',4,50,50.00),(7,2,'Camisa Preta',_binary 'assets/CamisaPreta.jpg','Camisa de algodão',4,50,50.00),(8,2,'Camisa Branca',_binary 'assets/CamisaBranca.jpg','Camisa de Seda',4,50,50.00),(9,2,'Camisa Azul',_binary 'assets/CamisaAzul.jpg','Camisa de Poliéster',1,50,50.00),(10,2,'Camisa Cinza',_binary 'assets/CamisaCinza.jpg','Camisa de Elastano',3,50,50.00),(11,3,'Calça Jeans Azul',_binary 'assets/CalcaJeansAzul.jpg','Calça Jeans ',2,50,50.00),(12,3,'Calça Jeans Clara',_binary 'assets/CalcaJeansClara.jpg','Calça Jeans Clara',2,50,50.00),(13,3,'Calça Jeans Escuro',_binary 'assets/CalcaJeansEscuro.jpg','Calça Jeans Escuro',2,50,50.00),(14,3,'Calça Khelf Moleton',_binary 'assets/CalcaKhelfMoleton.jpg','Calça Khelf Moleton',1,50,50.00),(15,3,'Calça Jeans',_binary 'assets/CalcaJeans.jpg','Calca Jeans',3,50,50.00),(16,4,'Jaqueta Cinza',_binary 'assets/JaquetaCinza.jpg','Jaqueta Jeans Cinza',1,50,50.00),(17,4,'Jaqueta Clara',_binary 'assets/JaquetaClara.jpg','Jaqueta Jeans Clara',2,50,50.00),(18,4,'Jaqueta Escura',_binary 'assets/JaquetaEscura.jpg','Jaqueta Jeans Escura',4,50,50.00),(19,4,'Jaqueta Jeans',_binary 'assets/JaquetaJeans.jpg','Jaqueta Jeans',4,50,50.00),(20,4,'Jaqueta de lã',_binary 'assets/JaquetaLa.jpg','Jaqueta Jeans com lã',4,50,50.00),(21,5,'Bermuda Rasgada',_binary 'assets/BermudaRasgada.jpg','Bermuda Rasgada',4,50,50.00),(22,5,'Bermuda Escura',_binary 'assets/BermudaEscura.jpg','Bermuda Escura',3,50,50.00),(23,5,'Bermuda Cordao',_binary 'assets/BermudaCordao.jpg','Bermuda Cordão',3,50,50.00),(24,5,'Bermuda Clara',_binary 'assets/BermudaClara.jpg','Bermuda Clara',3,50,50.00),(25,5,'Bermuda Branca',_binary 'assets/BermudaBranca.jpg','Bermuda Branca',1,50,50.00);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamanho`
--

DROP TABLE IF EXISTS `tamanho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tamanho` (
  `id_tamanho` int NOT NULL AUTO_INCREMENT,
  `tamanho_produto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tamanho`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `tamanhocarrinho`
--

DROP TABLE IF EXISTS `tamanhocarrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tamanhocarrinho` (
  `id_tamanhoCarrinho` int NOT NULL AUTO_INCREMENT,
  `tamanhoId` int DEFAULT NULL,
  `carrinhoId` int DEFAULT NULL,
  PRIMARY KEY (`id_tamanhoCarrinho`),
  KEY `tamanhoId` (`tamanhoId`),
  KEY `carrinhoId` (`carrinhoId`),
  CONSTRAINT `tamanhocarrinho_ibfk_1` FOREIGN KEY (`tamanhoId`) REFERENCES `tamanho` (`id_tamanho`),
  CONSTRAINT `tamanhocarrinho_ibfk_2` FOREIGN KEY (`carrinhoId`) REFERENCES `carrinho` (`id_carrinho`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamanhocarrinho`
--

LOCK TABLES `tamanhocarrinho` WRITE;
/*!40000 ALTER TABLE `tamanhocarrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `tamanhocarrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(155) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `telefone` char(15) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `cpf` char(15) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario` (`usuario`,`cpf`,`telefone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2024-06-22  1:19:22
