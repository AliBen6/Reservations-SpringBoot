CREATE TABLE `shows` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`slug` varchar(60) NOT NULL UNIQUE,
`title` varchar(255) NOT NULL,
`description` longtext,
`poster_url` varchar(255) DEFAULT NULL,
`bookable` tinyint(1) NOT NULL,
`price` decimal(10,2) DEFAULT NULL,
`created_at` datetime(6) NOT NULL,
`updated_at` datetime(6) DEFAULT NULL,
`location_id` int(11) DEFAULT NULL,
PRIMARY KEY(id)
);

--
-- Index pour la table `shows`
--
ALTER TABLE `shows`
    ADD KEY `shows_location_id_a6832141_fk_locations_id` (`location_id`);

--
-- Contraintes pour la table `shows`
--
ALTER TABLE `shows`
    ADD CONSTRAINT `shows_location_id_a6832141_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);