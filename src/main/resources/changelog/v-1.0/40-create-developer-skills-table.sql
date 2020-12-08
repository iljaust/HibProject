CREATE TABLE IF NOT EXISTS `developers_skills ` (
`developer_id` INT NOT NULL,
`skill_id` INT NOT NULL,
INDEX `dev_idx` (`developer_id` ASC) VISIBLE,
INDEX `skill_idx` (`skill_id` ASC) VISIBLE,
CONSTRAINT `dev`
FOREIGN KEY (`developer_id`)
REFERENCES `myapp`.`developers` (`developers_id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `skill`
FOREIGN KEY (`skill_id`)
REFERENCES `myapp`.`skills` (`id`)
ON DELETE CASCADE
ON UPDATE CASCADE);