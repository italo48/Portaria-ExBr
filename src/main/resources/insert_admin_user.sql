INSERT INTO role (papel) VALUES ('ROLE_ADMIN');
INSERT INTO role (papel) VALUES ('ROLE_USER');

INSERT INTO soldado (batalhao, login, nome, nome_de_guerra, numero, senha)

	VALUES ('Hashiras', 'it', 'Ítalo', 'Hashira da Computação', 1, '$2a$10$yfA05mSRe6pNcQD2Wj1uzOyvKqZaX6YHmI2ffgB.umGe1v/Tym5Ea');
	-- a senha eh: aaa123
	
INSERT INTO soldados_role(soldado_id, role_id) VALUES(1, 'ROLE_ADMIN');