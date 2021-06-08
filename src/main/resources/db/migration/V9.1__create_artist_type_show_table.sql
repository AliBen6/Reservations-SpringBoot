--
-- Structure de la table `artist_type_show`
--
CREATE TABLE `artist_type_show` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`artist_type_id` int(11) NOT NULL,
`show_id` int(11) NOT NULL,
PRIMARY KEY(id)
);

--
-- Index pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
    ADD KEY `IDX_9F6421FED0C1FC64` (`show_id`);

ALTER TABLE `artist_type_show`
    ADD KEY `IDX_9F6421FE7203D2A4` (`artist_type_id`);

--
-- Contraintes pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
    ADD CONSTRAINT `FK_9F6421FE7203D2A4` FOREIGN KEY (`artist_type_id`) REFERENCES `artist_type` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE `artist_type_show`
    ADD CONSTRAINT `FK_9F6421FED0C1FC64` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;