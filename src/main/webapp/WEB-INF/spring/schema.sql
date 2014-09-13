DROP TABLE IF EXISTS profanity;
DROP TABLE IF EXISTS word_list;
DROP TABLE IF EXISTS profanity_word_list;

CREATE TABLE profanity (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(128) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE word_list (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(128) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE profanity_word_list (
  word_list_id int(11) unsigned NOT NULL,
  profanity_id int(11) unsigned NOT NULL,
  PRIMARY KEY (word_list_id,profanity_id),
  CONSTRAINT fk_profanity FOREIGN KEY (profanity_id) REFERENCES profanity (id),
  CONSTRAINT fk_word_list FOREIGN KEY (word_list_id) REFERENCES word_list (id)
);