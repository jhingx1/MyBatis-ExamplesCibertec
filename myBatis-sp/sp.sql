DROP TABLE IF EXISTS notas;

CREATE TABLE notas (
    idalumno int(11) NOT NULL AUTO_INCREMENT,
    alumno varchar(50) NOT NULL,
    nota1 smallint(6) NOT NULL,
    nota2 smallint(6) NOT NULL,
    nota3 smallint(6) NOT NULL,
    comentario varchar(50) DEFAULT NULL,

    PRIMARY KEY (idalumno),
    UNIQUE KEY IDX_notas_1 (alumno)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO notas(alumno, nota1, nota2, nota3, comentario) 
    VALUES ('Carmen Pacheco', 15, 17, 15, 'alumna aplicada');
INSERT INTO notas(alumno, nota1, nota2, nota3, comentario) 
    VALUES ('Jorge Risco', 13, 14, 13, NULL);
INSERT INTO notas(alumno, nota1, nota2, nota3, comentario) 
    VALUES ('Victor Balta', 17, 18, 19, 'alumno que llega tarde');
INSERT INTO notas(alumno, nota1, nota2, nota3, comentario) 
    VALUES ('Carla Ramirez', 15, 16, 16, '');
INSERT INTO notas(alumno, nota1, nota2, nota3, comentario) 
    VALUES ('Jenny Andia', 16, 17, 18, 'a veces llega temprano');


# procedimientos almacenados
DELIMITER $$
DROP PROCEDURE IF EXISTS sp_delete$$
CREATE PROCEDURE sp_delete(pidalumno INT)
BEGIN
    DELETE FROM notas
    WHERE idalumno=pidalumno;
END
$$

DROP PROCEDURE IF EXISTS sp_get$$
CREATE PROCEDURE sp_get(pidalumno INT)
BEGIN
      SELECT idalumno,alumno,nota1,nota2,nota3,comentario
      FROM notas
      WHERE idalumno=pidalumno;
END;
$$

DROP PROCEDURE IF EXISTS sp_insert$$
CREATE PROCEDURE sp_insert(
    palumno varchar(50),
    pnota1 SMALLINT,
    pnota2 SMALLINT,
    pnota3 SMALLINT,
    pcomentario varchar(50))
BEGIN
	INSERT INTO notas(alumno,nota1,nota2,nota3,comentario)
        VALUES(palumno,pnota1,pnota2,pnota3,pcomentario);
END;
$$

DROP PROCEDURE IF EXISTS sp_promedio$$
CREATE PROCEDURE sp_promedio(
	pidalumno INT,
	OUT palumno varchar(50),
	OUT ppromedio DOUBLE
)
BEGIN
	SELECT ROUND((nota1+nota2+nota3)/3,2) INTO ppromedio
            FROM notas WHERE idalumno=pidalumno;
	SELECT alumno INTO palumno
            FROM notas WHERE idalumno=pidalumno;
END;
$$

DROP PROCEDURE IF EXISTS sp_query$$
CREATE PROCEDURE sp_query()
BEGIN
        SELECT idalumno,alumno,nota1,nota2,nota3,comentario 
        FROM notas;
END;
$$

DROP PROCEDURE IF EXISTS sp_update$$
CREATE PROCEDURE sp_update(
	pidalumno INT,
        palumno varchar(50),
	pnota1 SMALLINT,
  	pnota2 SMALLINT,
  	pnota3 SMALLINT,
  	pcomentario varchar(50)
)
BEGIN
	UPDATE notas SET
        alumno=palumno,
        nota1=pnota1,
        nota2=pnota2,
        nota3=pnota3,
        comentario=pcomentario
        WHERE idalumno=pidalumno;
END;
$$

DELIMITER ;


