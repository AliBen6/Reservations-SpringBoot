CREATE TABLE `locations` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `slug` varchar(60) NOT NULL UNIQUE,
                             `designation` varchar(60) NOT NULL,
                             `address` varchar(255) NOT NULL,
                             `locality_id` int(11) NOT NULL,
                             `website` varchar(255) DEFAULT NULL,
                             `phone` varchar(30) DEFAULT NULL,
                             PRIMARY KEY(id)
)

--
-- Index pour la table `locations`