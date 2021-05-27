CREATE TABLE `locations` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`slug` varchar(60) NOT NULL UNIQUE,
`designation` varchar(60) NOT NULL,
`address` varchar(255) NOT NULL,
`locality_id` int(11) NOT NULL,
`website` varchar(255) DEFAULT NULL,
`phone` varchar(30) DEFAULT NULL,
PRIMARY KEY(id)
);

--
-- Index pour la table `locations`
--
ALTER TABLE `locations`
    ADD KEY `locations_locality_id_22dd0b44_fk_localities_id` (`locality_id`);

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
    ADD CONSTRAINT `locations_locality_id_22dd0b44_fk_localities_id` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`id`);
