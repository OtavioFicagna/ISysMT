CREATE TABLE `usuario` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `cidade` varchar(255) DEFAULT NULL,
 `nome` varchar(255) NOT NULL,
 `telefone` varchar(255) DEFAULT NULL,
 `role` enum("USER", "ADMIN") DEFAULT "USER",
 `email` varchar(255) NOT NULL UNIQUE,
 `senha` varchar(255) NOT NULL
);