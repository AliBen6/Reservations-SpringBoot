;              
CREATE USER IF NOT EXISTS "SA" SALT '91d50be3a4e42619' HASH '50c8709186a39ac029d096067b769a11f84be7a0df7d2152dfa2039e21e4848f' ADMIN;          
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_250B83C2_C175_478A_8D2B_0C52987F8E9B" START WITH 4 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_376578A3_D419_4D4C_A0AF_F6445A900BA6" START WITH 3 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_DB889D66_406F_4D24_83DF_0DDBF4D7B5D9" START WITH 17 BELONGS_TO_TABLE;
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_85B2455D_B038_4340_BDCD_8F61ACBE98DB" START WITH 22 BELONGS_TO_TABLE;
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_63DC5A57_6F92_4087_8CF8_B10C578C59A9" START WITH 5 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_BB5C41B2_BFF0_482B_9E9B_EA7144BF1338" START WITH 6 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_A52BA7E9_5F03_44D9_935B_E4F7722D1CCA" START WITH 23 BELONGS_TO_TABLE;
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_C2CE0E7C_95F9_48CD_86E0_91E7BD5C6AC7" START WITH 5 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_C64CE699_6F6D_46A2_884E_B0320E037188" START WITH 4 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_21C33F18_DC5B_4052_8BEB_EEBBBC0E381E" START WITH 5 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_C9C14297_DF3B_4534_9A1E_9E79757E2CF2" START WITH 7 BELONGS_TO_TABLE; 
CREATE SEQUENCE "public"."SYSTEM_SEQUENCE_F30AB077_BF01_4ABC_BEC8_240C414A0ED2" START WITH 4 BELONGS_TO_TABLE; 
CREATE CACHED TABLE "public"."flyway_schema_history"(
    "installed_rank" INT NOT NULL,
    "version" VARCHAR(50),
    "description" VARCHAR(200) NOT NULL,
    "type" VARCHAR(20) NOT NULL,
    "script" VARCHAR(1000) NOT NULL,
    "checksum" INT,
    "installed_by" VARCHAR(100) NOT NULL,
    "installed_on" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "execution_time" INT NOT NULL,
    "success" BOOLEAN NOT NULL
);         
ALTER TABLE "public"."flyway_schema_history" ADD CONSTRAINT "public"."flyway_schema_history_pk" PRIMARY KEY("installed_rank"); 
-- 23 +/- SELECT COUNT(*) FROM public.flyway_schema_history;   
INSERT INTO "public"."flyway_schema_history" VALUES
(-1, NULL, '<< Flyway Schema History table created >>', 'TABLE', '', NULL, 'SA', TIMESTAMP '2021-06-07 00:04:45.969754', 0, TRUE),
(1, '1.0', 'create artists table', 'SQL', 'V1.0__create_artists_table.sql', 1227042826, 'SA', TIMESTAMP '2021-06-07 00:04:45.998363', 3, TRUE),
(2, '1.1', 'insert artists table', 'SQL', 'V1.1__insert_artists_table.sql', -280175186, 'SA', TIMESTAMP '2021-06-07 00:04:46.012749', 2, TRUE),
(3, '2.0', 'create users table', 'SQL', 'V2.0__create_users_table.sql', 1428567000, 'SA', TIMESTAMP '2021-06-07 00:04:46.024463', 1, TRUE),
(4, '2.1', 'create types table', 'SQL', 'V2.1__create_types_table.sql', -778845535, 'SA', TIMESTAMP '2021-06-07 00:04:46.034697', 1, TRUE),
(5, '2.2', 'insert types table', 'SQL', 'V2.2__insert_types_table.sql', -126045216, 'SA', TIMESTAMP '2021-06-07 00:04:46.043413', 0, TRUE),
(6, '3.1', 'create localities table', 'SQL', 'V3.1__create_localities_table.sql', -1894273869, 'SA', TIMESTAMP '2021-06-07 00:04:46.051813', 0, TRUE),
(7, '3.2', 'insert localities table', 'SQL', 'V3.2__insert_localities_table.sql', 805785997, 'SA', TIMESTAMP '2021-06-07 00:04:46.059327', 0, TRUE),
(8, '4.1', 'create roles table', 'SQL', 'V4.1__create_roles_table.sql', -72790935, 'SA', TIMESTAMP '2021-06-07 00:04:46.06698', 1, TRUE),
(9, '4.2', 'insert roles table', 'SQL', 'V4.2__insert_roles_table.sql', -1235443438, 'SA', TIMESTAMP '2021-06-07 00:04:46.074904', 1, TRUE),
(10, '5.1', 'create locations table', 'SQL', 'V5.1__create_locations_table.sql', 880596497, 'SA', TIMESTAMP '2021-06-07 00:04:46.084671', 3, TRUE),
(11, '5.2', 'insert locations table', 'SQL', 'V5.2__insert_locations_table.sql', -1081051635, 'SA', TIMESTAMP '2021-06-07 00:04:46.094569', 1, TRUE),
(12, '6.1', 'create shows table', 'SQL', 'V6.1__create_shows_table.sql', -1591909358, 'SA', TIMESTAMP '2021-06-07 00:04:46.10342', 1, TRUE),
(13, '6.2', 'insert shows table', 'SQL', 'V6.2__insert_shows_table.sql', 586613049, 'SA', TIMESTAMP '2021-06-07 00:04:46.113952', 2, TRUE),
(14, '7.1', 'create representations table', 'SQL', 'V7.1__create_representations_table.sql', -1025625192, 'SA', TIMESTAMP '2021-06-07 00:04:46.123744', 3, TRUE),
(15, '7.2', 'insert artist type table', 'SQL', 'V7.2__insert_artist_type_table.sql', 1896858991, 'SA', TIMESTAMP '2021-06-07 00:04:46.131209', 0, TRUE),
(16, '8.1', 'create artist type table', 'SQL', 'V8.1__create_artist_type_table.sql', 555154270, 'SA', TIMESTAMP '2021-06-07 00:04:46.138862', 1, TRUE),
(17, '8.2', 'insert representations table', 'SQL', 'V8.2__insert_representations_table.sql', -1003207613, 'SA', TIMESTAMP '2021-06-07 00:04:46.146251', 2, TRUE),
(18, '9.1', 'create artist type show table', 'SQL', 'V9.1__create_artist_type_show_table.sql', -1135087978, 'SA', TIMESTAMP '2021-06-07 00:04:46.153301', 1, TRUE),
(19, '9.2', 'insert artist type show table', 'SQL', 'V9.2__insert_artist_type_show_table.sql', -31123080, 'SA', TIMESTAMP '2021-06-07 00:04:46.160397', 1, TRUE),
(20, '10.1', 'create role user table', 'SQL', 'V10.1__create_role_user_table.sql', 1978243942, 'SA', TIMESTAMP '2021-06-07 00:04:46.165991', 0, TRUE),
(21, '11.1', 'create user representation table', 'SQL', 'V11.1__create_user_representation_table.sql', 393115660, 'SA', TIMESTAMP '2021-06-07 00:04:46.171449', 0, TRUE),
(22, '12.1', 'create shows artist types', 'SQL', 'V12.1__create_shows_artist_types.sql', -1106632442, 'SA', TIMESTAMP '2021-06-07 19:31:44.559695', 5, TRUE);     
CREATE INDEX "public"."flyway_schema_history_s_idx" ON "public"."flyway_schema_history"("success");            
CREATE CACHED TABLE "public"."artists"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_DB889D66_406F_4D24_83DF_0DDBF4D7B5D9" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_DB889D66_406F_4D24_83DF_0DDBF4D7B5D9",
    "firstname" VARCHAR(60) NOT NULL,
    "lastname" VARCHAR(60) NOT NULL
);    
ALTER TABLE "public"."artists" ADD CONSTRAINT "public"."CONSTRAINT_D" PRIMARY KEY("id");       
-- 15 +/- SELECT COUNT(*) FROM public.artists; 
INSERT INTO "public"."artists" VALUES
(1, 'Daniel', 'Marcelin'),
(2, 'Philippe', 'Laurent'),
(3, 'Marius', 'Von Mayenburg'),
(4, 'Olivier', 'Boudon'),
(5, 'Anne Marie', 'Loop'),
(6, 'Pietro', 'Varasso'),
(7, 'Laurent', 'Caron'),
(8, STRINGDECODE('\u00c9lena'), 'Perez'),
(9, 'Guillaume', 'Alexandre'),
(10, 'Claude', 'Semal'),
(11, 'Laurence', 'Warin'),
(12, 'Pierre', 'Wayburn'),
(13, 'Gwendoline', 'Gauthier'),
(15, 'Alex', 'Garland'),
(16, 'Dana', 'Murray');  
CREATE CACHED TABLE "public"."users"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_250B83C2_C175_478A_8D2B_0C52987F8E9B" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_250B83C2_C175_478A_8D2B_0C52987F8E9B",
    "login" VARCHAR(30) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "firstname" VARCHAR(60) NOT NULL,
    "lastname" VARCHAR(60) NOT NULL,
    "email" VARCHAR(100) NOT NULL,
    "langue" VARCHAR(2) NOT NULL
);         
ALTER TABLE "public"."users" ADD CONSTRAINT "public"."CONSTRAINT_6" PRIMARY KEY("id");         
-- 3 +/- SELECT COUNT(*) FROM public.users;    
INSERT INTO "public"."users" VALUES
(1, 'administrator', '$2a$10$pYGPKP7hDpWH/mYxtyH7g.Egk/L2SXgnhILoNSJd7yb1PMAiy7Uxq', 'administrator', 'administrator', 'admin@hotmail.com', 'fr'),
(2, 'member', '$2a$10$gTpOPXA7TokZqasMeXxbeugHfPTVVI5k0SfVFki5mjRWWDIQU9ol.', 'member', 'member', 'member@hotmail.com', 'fr'),
(3, 'pepe', '$2a$10$kbOhJ6yKQk163hK3MB5AkuLU4nUnAPcmYDZCxbCiOCHGs9JyaW0Ym', 'pepe', 'pepe', 'pepe@hotmail.com', 'fr');   
CREATE CACHED TABLE "public"."types"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_C2CE0E7C_95F9_48CD_86E0_91E7BD5C6AC7" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_C2CE0E7C_95F9_48CD_86E0_91E7BD5C6AC7",
    "type" VARCHAR(30) NOT NULL
);
ALTER TABLE "public"."types" ADD CONSTRAINT "public"."CONSTRAINT_69" PRIMARY KEY("id");        
-- 4 +/- SELECT COUNT(*) FROM public.types;    
INSERT INTO "public"."types" VALUES
(1, 'auteur'),
(2, STRINGDECODE('sc\u00e9nographe')),
(3, STRINGDECODE('com\u00e9dien')),
(4, STRINGDECODE('R\u00e9alisateur'));           
CREATE CACHED TABLE "public"."localities"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_63DC5A57_6F92_4087_8CF8_B10C578C59A9" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_63DC5A57_6F92_4087_8CF8_B10C578C59A9",
    "postal_code" VARCHAR(6) NOT NULL,
    "locality" VARCHAR(60) NOT NULL
);
ALTER TABLE "public"."localities" ADD CONSTRAINT "public"."CONSTRAINT_4" PRIMARY KEY("id");    
-- 4 +/- SELECT COUNT(*) FROM public.localities;               
INSERT INTO "public"."localities" VALUES
(1, '1000', 'Bruxelles'),
(2, '1020', 'Laeken'),
(3, '1030', 'Schaerbeek'),
(4, '1170', 'Watermael-Boistfort');       
CREATE CACHED TABLE "public"."roles"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_F30AB077_BF01_4ABC_BEC8_240C414A0ED2" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_F30AB077_BF01_4ABC_BEC8_240C414A0ED2",
    "role" VARCHAR(30) NOT NULL
);
ALTER TABLE "public"."roles" ADD CONSTRAINT "public"."CONSTRAINT_67A" PRIMARY KEY("id");       
-- 3 +/- SELECT COUNT(*) FROM public.roles;    
INSERT INTO "public"."roles" VALUES
(1, 'admin'),
(2, 'member'),
(3, 'affiliate');             
CREATE CACHED TABLE "public"."locations"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_21C33F18_DC5B_4052_8BEB_EEBBBC0E381E" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_21C33F18_DC5B_4052_8BEB_EEBBBC0E381E",
    "slug" VARCHAR(60) NOT NULL,
    "designation" VARCHAR(60) NOT NULL,
    "address" VARCHAR(255) NOT NULL,
    "locality_id" INT NOT NULL,
    "website" VARCHAR(255) DEFAULT NULL,
    "phone" VARCHAR(30) DEFAULT NULL
);
ALTER TABLE "public"."locations" ADD CONSTRAINT "public"."CONSTRAINT_B8" PRIMARY KEY("id");    
-- 4 +/- SELECT COUNT(*) FROM public.locations;
INSERT INTO "public"."locations" VALUES
(1, 'espace-delvaux-la-venerie', STRINGDECODE('Espace Delvaux / La V\u00e9nerie'), STRINGDECODE('3 rue Grat\u00e8s'), 4, 'https://www.lavenerie.be', '+32 (0)2/663.85.50'),
(2, 'dexia-art-center', 'Dexia Art Center', '50 rue de l''Ecuyer', 1, NULL, NULL),
(3, 'la-samaritaine', 'La Samaritaine', '16 rue de la samaritaine', 1, 'http://www.lasamaritaine.be/', NULL),
(4, 'espace-magh', 'Espace Magh', STRINGDECODE('17 rue du Poin\u00e7on'), 1, 'http://www.espacemagh.be', '+32 (0)2/274.05.10');           
CREATE INDEX "public"."locations_locality_id_22dd0b44_fk_localities_id" ON "public"."locations"("locality_id");
CREATE CACHED TABLE "public"."shows"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_C9C14297_DF3B_4534_9A1E_9E79757E2CF2" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_C9C14297_DF3B_4534_9A1E_9E79757E2CF2",
    "slug" VARCHAR(60) NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "description" LONGTEXT,
    "poster_url" VARCHAR(255) DEFAULT NULL,
    "bookable" TINYINT NOT NULL,
    "price" DECIMAL(10, 2) DEFAULT NULL,
    "created_at" DATETIME(6) NOT NULL,
    "updated_at" DATETIME(6) DEFAULT NULL,
    "location_id" INT DEFAULT NULL
);     
ALTER TABLE "public"."shows" ADD CONSTRAINT "public"."CONSTRAINT_685" PRIMARY KEY("id");       
-- 6 +/- SELECT COUNT(*) FROM public.shows;    
INSERT INTO "public"."shows" VALUES
(1, 'ayiti', 'Ayiti', STRINGDECODE('Un homme est bloqu\u00e9 \u00e0 l\u2019a\u00e9roport.\\n Questionn\u00e9 par les douaniers, il doit alors justifier son identit\u00e9, et surtout prouver qu''il est ha\u00eftien \u2013 qu''est-ce qu''\u00eatre ha\u00eftien ?'), 'ayiti.jpg', 1, 9.00, TIMESTAMP '2020-04-21 19:08:44.583', NULL, 1),
(2, 'cible-mouvante', 'Cible mouvante', STRINGDECODE('Dans ce \u00ab thriller d\u2019anticipation \u00bb, des adultes semblent alimenter et v\u00e9hiculer une crainte f\u00e9roce envers les enfants \u00e2g\u00e9s entre 10 et 12 ans.'), 'cible.jpg', 1, 9.00, TIMESTAMP '2020-04-21 19:08:53.156', NULL, 2),
(3, 'ceci-nest-pas-un-chanteur-belge', 'Ceci n''est pas un chanteur belge', STRINGDECODE('Non peut-\u00eatre ?!\\nEntre Magritte (pour le surr\u00e9alisme comique) et Maigret (pour le r\u00e9alisme m\u00e9lancolique), ce dixi\u00e8me opus semalien propose quatorze nouvelles chansons m\u00eal\u00e9es \u00e0 de petits textes humoristiques et \u00e0 quelques fortes images po\u00e9tiques.'), 'claudebelgesaison220.jpg', 1, 5.50, TIMESTAMP '2020-04-21 19:08:53.189', TIMESTAMP '2020-04-21 19:08:53.189', NULL),
(4, 'manneke', STRINGDECODE('Manneke\u2026 !'), STRINGDECODE('A tour de r\u00f4le, Pierre se joue de ses oncles, tantes, grands-parents et surtout de sa m\u00e8re.'), 'wayburn.jpg', 1, 10.50, TIMESTAMP '2020-04-21 19:09:02.426', TIMESTAMP '2020-04-21 19:09:02.426', 3),
(5, 'navoli', 'Navoli', 'Un homme se retrouve tout seul apres un...', 'navoli.jpg', 1, 10.00, TIMESTAMP '2021-06-07 19:16:12.611415', NULL, 4),
(6, 'soul', 'Soul', STRINGDECODE('Passionn\u00e9 de jazz et professeur de musique dans un coll\u00e8ge, Joe Gardner a enfin l''opportunit\u00e9 de r\u00e9aliser son r\u00eave : jouer dans le meilleur club de jazz de New York.'), 'soul.jpg', 1, 25.00, TIMESTAMP '2021-06-08 16:02:11.496351', NULL, 1);      
CREATE INDEX "public"."shows_location_id_a6832141_fk_locations_id" ON "public"."shows"("location_id");         
CREATE CACHED TABLE "public"."representations"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_BB5C41B2_BFF0_482B_9E9B_EA7144BF1338" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_BB5C41B2_BFF0_482B_9E9B_EA7144BF1338",
    "show_id" INT NOT NULL,
    "location_id" INT DEFAULT NULL,
    "when" DATETIME(6) NOT NULL
);      
ALTER TABLE "public"."representations" ADD CONSTRAINT "public"."CONSTRAINT_2" PRIMARY KEY("id");               
-- 5 +/- SELECT COUNT(*) FROM public.representations;          
INSERT INTO "public"."representations" VALUES
(1, 1, 1, TIMESTAMP '2012-10-12 13:30:00'),
(2, 1, 2, TIMESTAMP '2012-10-12 20:30:00'),
(3, 2, NULL, TIMESTAMP '2012-10-02 20:30:00'),
(4, 3, NULL, TIMESTAMP '2012-10-16 20:30:00'),
(5, 5, 2, TIMESTAMP '2021-02-09 20:00:00');
CREATE INDEX "public"."representations_location_id_a6832141_fk_locations_id" ON "public"."representations"("location_id");     
CREATE INDEX "public"."representations_show_id_a6832141_fk_shows_id" ON "public"."representations"("show_id"); 
CREATE CACHED TABLE "public"."artist_type"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_85B2455D_B038_4340_BDCD_8F61ACBE98DB" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_85B2455D_B038_4340_BDCD_8F61ACBE98DB",
    "artist_id" INT NOT NULL,
    "type_id" INT NOT NULL
); 
ALTER TABLE "public"."artist_type" ADD CONSTRAINT "public"."CONSTRAINT_8" PRIMARY KEY("id");   
-- 21 +/- SELECT COUNT(*) FROM public.artist_type;             
INSERT INTO "public"."artist_type" VALUES
(1, 1, 1),
(2, 2, 1),
(3, 1, 2),
(4, 2, 2),
(5, 1, 3),
(6, 3, 1),
(7, 4, 2),
(8, 5, 3),
(9, 6, 3),
(10, 7, 3),
(11, 8, 3),
(12, 9, 3),
(13, 10, 1),
(14, 11, 2),
(15, 10, 3),
(16, 12, 1),
(17, 13, 1),
(18, 12, 3),
(19, 13, 3),
(20, 15, 1),
(21, 16, 4);          
CREATE INDEX "public"."artist_type_artist_id_ idx_3060d1b6b7970cf8_fk_artists_id" ON "public"."artist_type"("artist_id");      
CREATE INDEX "public"."artist_type_type_id_ idx_3060d1b6c54c8c93_fk_types_id" ON "public"."artist_type"("type_id");            
CREATE CACHED TABLE "public"."artist_type_show"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_A52BA7E9_5F03_44D9_935B_E4F7722D1CCA" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_A52BA7E9_5F03_44D9_935B_E4F7722D1CCA",
    "artist_type_id" INT NOT NULL,
    "show_id" INT NOT NULL
);       
ALTER TABLE "public"."artist_type_show" ADD CONSTRAINT "public"."CONSTRAINT_5" PRIMARY KEY("id");              
-- 22 +/- SELECT COUNT(*) FROM public.artist_type_show;        
INSERT INTO "public"."artist_type_show" VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 2),
(7, 7, 2),
(8, 8, 2),
(9, 9, 2),
(10, 10, 2),
(11, 11, 2),
(12, 12, 2),
(13, 13, 3),
(14, 14, 3),
(15, 15, 3),
(16, 4, 4),
(17, 16, 4),
(18, 17, 4),
(19, 18, 4),
(20, 19, 4),
(21, 20, 5),
(22, 21, 6);      
CREATE INDEX "public"."idx_9f6421fed0c1fc64" ON "public"."artist_type_show"("show_id");        
CREATE INDEX "public"."idx_9f6421fe7203d2a4" ON "public"."artist_type_show"("artist_type_id"); 
CREATE CACHED TABLE "public"."role_user"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_C64CE699_6F6D_46A2_884E_B0320E037188" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_C64CE699_6F6D_46A2_884E_B0320E037188",
    "role_id" INT NOT NULL,
    "user_id" INT NOT NULL
);     
ALTER TABLE "public"."role_user" ADD CONSTRAINT "public"."CONSTRAINT_1" PRIMARY KEY("id");     
-- 3 +/- SELECT COUNT(*) FROM public.role_user;
INSERT INTO "public"."role_user" VALUES
(1, 1, 1),
(2, 2, 2),
(3, 2, 3);       
CREATE CACHED TABLE "public"."user_representation"(
    "id" INT DEFAULT NEXT VALUE FOR "public"."SYSTEM_SEQUENCE_376578A3_D419_4D4C_A0AF_F6445A900BA6" NOT NULL NULL_TO_DEFAULT SEQUENCE "public"."SYSTEM_SEQUENCE_376578A3_D419_4D4C_A0AF_F6445A900BA6",
    "representation_id" INT NOT NULL,
    "user_id" INT NOT NULL
); 
ALTER TABLE "public"."user_representation" ADD CONSTRAINT "public"."CONSTRAINT_C" PRIMARY KEY("id");           
-- 1 +/- SELECT COUNT(*) FROM public.user_representation;      
INSERT INTO "public"."user_representation" VALUES
(1, 5, 3);   
ALTER TABLE "public"."roles" ADD CONSTRAINT "public"."CONSTRAINT_67" UNIQUE("role");           
ALTER TABLE "public"."shows" ADD CONSTRAINT "public"."CONSTRAINT_68" UNIQUE("slug");           
ALTER TABLE "public"."locations" ADD CONSTRAINT "public"."CONSTRAINT_B" UNIQUE("slug");        
ALTER TABLE "public"."artist_type" ADD CONSTRAINT "public"."artist_type_artist_id_ 3060d1b6b7970cf8_fk_artists_id" FOREIGN KEY("artist_id") REFERENCES "public"."artists"("id") ON UPDATE CASCADE NOCHECK;     
ALTER TABLE "public"."artist_type" ADD CONSTRAINT "public"."artist_type_type_id_ 3060d1b6c54c8c93 _fk_artists_id" FOREIGN KEY("type_id") REFERENCES "public"."types"("id") ON UPDATE CASCADE NOCHECK;          
ALTER TABLE "public"."artist_type_show" ADD CONSTRAINT "public"."fk_9f6421fed0c1fc64" FOREIGN KEY("show_id") REFERENCES "public"."shows"("id") ON UPDATE CASCADE NOCHECK;      
ALTER TABLE "public"."shows" ADD CONSTRAINT "public"."shows_location_id_a6832141_fk_locations_id" FOREIGN KEY("location_id") REFERENCES "public"."locations"("id") NOCHECK;    
ALTER TABLE "public"."representations" ADD CONSTRAINT "public"."representations_location_id_a6832141_fk_locations_id" FOREIGN KEY("location_id") REFERENCES "public"."locations"("id") ON UPDATE CASCADE NOCHECK;              
ALTER TABLE "public"."artist_type_show" ADD CONSTRAINT "public"."fk_9f6421fe7203d2a4" FOREIGN KEY("artist_type_id") REFERENCES "public"."artist_type"("id") ON UPDATE CASCADE NOCHECK;         
ALTER TABLE "public"."locations" ADD CONSTRAINT "public"."locations_locality_id_22dd0b44_fk_localities_id" FOREIGN KEY("locality_id") REFERENCES "public"."localities"("id") NOCHECK;          
ALTER TABLE "public"."representations" ADD CONSTRAINT "public"."representations_show_id_a6832141_fk_shows_id" FOREIGN KEY("show_id") REFERENCES "public"."shows"("id") ON UPDATE CASCADE NOCHECK;              
