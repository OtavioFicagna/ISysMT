CREATE TABLE `orcamento` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `tempo_fabricacao` NUMERIC(10,5),
 `preco_total` NUMERIC(10,3),
 `status` enum("PENDENTE", "ENVIADO", "APROVADO", "CANCELADO", "RECUSADO") DEFAULT "PENDENTE",
 `id_material` bigint NOT NULL,
 `id_peca` bigint NOT NULL,
 FOREIGN KEY (`id_material`) REFERENCES `material` (`id`),
 FOREIGN KEY (`id_peca`) REFERENCES `peca` (`id`)
);
