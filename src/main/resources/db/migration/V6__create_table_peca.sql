CREATE TABLE `peca` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `codigo` varchar(25) NOT NULL,
 `descricao` varchar(40) NOT NULL,
 `preco` NUMERIC(10,3),
 `diametro` NUMERIC(10, 3),
 `data_cadastro` datetime(6) NOT NULL,
 `status` enum("PENDENTE", "ORCADA", "APROVADA", "CANCELADA") DEFAULT "PENDENTE"
);