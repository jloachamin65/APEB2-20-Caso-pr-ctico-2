USE refugio
GO
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
--Generar esquema
IF NOT EXISTS(SELECT 1
FROM sys.schemas
WHERE name = 'refugio')
    BEGIN
      EXEC ('CREATE SCHEMA refugio')
    END
--Crear tabla tipo
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.tipo') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.tipo
      (id_tipo     int IDENTITY NOT NULL,
       codigo      varchar(10)  NOT NULL,
       nombre      varchar(50),
       descripcion varchar(200),
       CONSTRAINT [pk_tipo] PRIMARY KEY CLUSTERED
         (
          id_tipo ASC
           ))
    END

--Crear tabla raza
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.raza') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.raza
      (id_raza     int IDENTITY NOT NULL,
       codigo      varchar(10)  NOT NULL,
       nombre      varchar(50),
       descripcion varchar(100),
       id_tipo     int          NOT NULL,
       CONSTRAINT [pk_raza] PRIMARY KEY CLUSTERED
         (
          id_raza ASC
           ))
      ALTER TABLE [refugio].[raza] WITH CHECK ADD CONSTRAINT [fk_raza_tipo] FOREIGN KEY ([id_tipo])
        REFERENCES [refugio].[tipo] ([id_tipo])
    END
--Crear tabla color
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.color') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.color
      (id_color int IDENTITY NOT NULL,
       codigo   varchar(10)  NOT NULL,
       nombre   varchar(50),
       CONSTRAINT [pk_color] PRIMARY KEY CLUSTERED
         (
          id_color ASC
           ))
    END
--Crear tabla tamano
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.tamano') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.tamano
      (id_tamano int IDENTITY NOT NULL,
       codigo    varchar(10)  NOT NULL,
       nombre    varchar(50),
       CONSTRAINT [pk_tamano] PRIMARY KEY CLUSTERED
         (
          id_tamano ASC
           ))
    END
--Crear tabla situacion
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.situacion') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.situacion
      (id_situacion int IDENTITY NOT NULL,
       codigo       varchar(10)  NOT NULL,
       situacion    varchar(50),
       descripcion  varchar(100),
       CONSTRAINT [pk_situacion] PRIMARY KEY CLUSTERED
         (
          id_situacion ASC
           ))
    END
--Crear tabla estado
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.estado') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.estado
      (id_estado   int IDENTITY NOT NULL,
       codigo      varchar(10)  NOT NULL,
       estado      varchar(50),
       descripcion varchar(100),
       CONSTRAINT [pk_estado] PRIMARY KEY CLUSTERED
         (
          id_estado ASC
           ))
    END
--Crear tabla animal
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.animal') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.animal
      (id_animal    int IDENTITY NOT NULL,
       codigo       varchar(10)  NOT NULL,
       nombre       varchar(50),
       descripcion  varchar(100),
       id_raza      int          NOT NULL,
       id_color     int          NOT NULL,
       id_tamano    int          NOT NULL,
       id_situacion int          NOT NULL,
       id_estado    int          NOT NULL,
       CONSTRAINT [pk_animal] PRIMARY KEY CLUSTERED
         (
          id_animal ASC
           ))

      ALTER TABLE [refugio].[animal] WITH CHECK ADD CONSTRAINT [fk_animal_raza] FOREIGN KEY ([id_raza])
        REFERENCES [refugio].[raza] ([id_raza])

      ALTER TABLE [refugio].[animal] WITH CHECK ADD CONSTRAINT [fk_animal_color] FOREIGN KEY ([id_color])
        REFERENCES [refugio].[color] ([id_color])

      ALTER TABLE [refugio].[animal] WITH CHECK ADD CONSTRAINT [fk_animal_tamano] FOREIGN KEY ([id_tamano])
        REFERENCES [refugio].[tamano] ([id_tamano])

      ALTER TABLE [refugio].[animal] WITH CHECK ADD CONSTRAINT [fk_animal_situacion] FOREIGN KEY ([id_situacion])
        REFERENCES [refugio].[situacion] ([id_situacion])

      ALTER TABLE [refugio].[animal] WITH CHECK ADD CONSTRAINT [fk_animal_estado] FOREIGN KEY ([id_estado])
        REFERENCES [refugio].[estado] ([id_estado])
    END
--Crear tabla genero
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.genero') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.genero
      (id_genero int IDENTITY NOT NULL,
       codigo    char(1)      NOT NULL,
       nombre    varchar(50),
       CONSTRAINT [pk_genero] PRIMARY KEY CLUSTERED
         (
          id_genero ASC
           ))
    END
--Crear tabla persona
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.persona') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.persona
      (id_persona       int IDENTITY NOT NULL,
       nombre           varchar(100),
       apellido_paterno varchar(100),
       apellido_materno varchar(100),
       identificacion   varchar(13),
       fecha_nacimiento datetime,
       descripcion      varchar(100),
       correo           varchar(100),
       id_genero        int          NOT NULL,
       CONSTRAINT [pk_persona] PRIMARY KEY CLUSTERED
         (
          id_persona ASC
           ))

      ALTER TABLE [refugio].[persona] WITH CHECK ADD CONSTRAINT [fk_persona_genero] FOREIGN KEY ([id_genero])
        REFERENCES [refugio].[genero] ([id_genero])
    END
--Crear tabla direccion
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.direccion') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.direccion
      (id_direccion     int IDENTITY NOT NULL,
       calle_principal  varchar(100) NOT NULL,
       calle_secundaria varchar(100),
       numero_casa      varchar(20),
       celular          varchar(13),
       telefono         varchar(50),
       descripcion      varchar(100),
       id_persona       int          NOT NULL,
       CONSTRAINT [pk_direccion] PRIMARY KEY CLUSTERED
         (
          id_direccion ASC
           ))

      ALTER TABLE [refugio].[direccion] WITH CHECK ADD CONSTRAINT [fk_direccion_persona] FOREIGN KEY ([id_persona])
        REFERENCES [refugio].[persona] ([id_persona])
    END
--Crear tabla rol
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.rol') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.rol
      (id_rol      int IDENTITY NOT NULL,
       codigo      varchar(5)   NOT NULL,
       nombre      varchar(100),
       descripcion varchar(100),
       CONSTRAINT [pk_rol] PRIMARY KEY CLUSTERED
         (
          id_rol ASC
           ))
    END
--Crear tabla usuario
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.usuario') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.usuario
      (id_usuario int IDENTITY NOT NULL,
       usuario    varchar(50)  NOT NULL,
       clave      varchar(100),
       id_persona int          NOT NULL,
       id_rol     int          NOT NULL,
       CONSTRAINT [pk_usuario] PRIMARY KEY CLUSTERED
         (
          id_usuario ASC
           ))

      ALTER TABLE [refugio].[usuario] WITH CHECK ADD CONSTRAINT [fk_usuario_persona] FOREIGN KEY ([id_persona])
        REFERENCES [refugio].[persona] ([id_persona])
      ALTER TABLE [refugio].[usuario] WITH CHECK ADD CONSTRAINT [fk_usuario_rol] FOREIGN KEY ([id_rol])
        REFERENCES [refugio].[rol] ([id_rol])
    END
--Crear tabla empleado
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.empleado') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.empleado
      (id_empleado int IDENTITY NOT NULL,
       codigo      varchar(10)  NOT NULL,
       cargo       varchar(100),
       descripcion varchar(100),
	   id_persona int          NOT NULL,
       CONSTRAINT [pk_empleado] PRIMARY KEY CLUSTERED
         (
          id_empleado ASC
           ))
		ALTER TABLE [refugio].[empleado] WITH CHECK ADD CONSTRAINT [fk_empleado_persona] FOREIGN KEY ([id_persona])
        REFERENCES [refugio].[persona] ([id_persona])
    END
--Crear tabla horario
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.horario') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.horario
      (id_horario  int IDENTITY NOT NULL,
       codigo      varchar(10)  NOT NULL,
       fecha       datetime,
       hora        int,
       estado      char(1),
       descripcion varchar(100),
       CONSTRAINT [pk_horario] PRIMARY KEY CLUSTERED
         (
          id_horario ASC
           ))
    END
--Crear tabla empleado-horario
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.empleado_horario') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.empleado_horario
      (id_empleado_horario int IDENTITY NOT NULL,
       descripcion         varchar(100),
       estado              char(1),
       id_empleado         int          NOT NULL,
       id_horario          int          NOT NULL,
       CONSTRAINT [pk_empleado_horario] PRIMARY KEY CLUSTERED
         (
          id_empleado_horario ASC
           ))

      ALTER TABLE [refugio].[empleado_horario] WITH CHECK ADD CONSTRAINT [fk_empleado_horario_empleado] FOREIGN KEY ([id_empleado])
        REFERENCES [refugio].[empleado] ([id_empleado])
      ALTER TABLE [refugio].[empleado_horario] WITH CHECK ADD CONSTRAINT [fk_empleado_horario_horario] FOREIGN KEY ([id_horario])
        REFERENCES [refugio].[horario] ([id_horario])
    END
--Crear tabla cita
IF NOT EXISTS(SELECT 1
FROM dbo.sysobjects
WHERE id = OBJECT_ID(N'refugio.cita') AND
      OBJECTPROPERTY(id, N'IsUserTable') = 1)
    BEGIN
      CREATE TABLE refugio.cita
      (id_cita             int IDENTITY NOT NULL,
       codigo              varchar(10)  NOT NULL,
       fecha               datetime,
       estado              char(1),
       descripcion         varchar(100),
       id_usuario          int          NOT NULL,
       id_empleado_horario int          NOT NULL,
       id_animal           int          NOT NULL,
       CONSTRAINT [pk_cita] PRIMARY KEY CLUSTERED
         (
          id_cita ASC
           ))
      ALTER TABLE [refugio].[cita] WITH CHECK ADD CONSTRAINT [fk_cita_usuario] FOREIGN KEY ([id_usuario])
        REFERENCES [refugio].[usuario] ([id_usuario])
      ALTER TABLE [refugio].[cita] WITH CHECK ADD CONSTRAINT [fk_cita_empleado_horario] FOREIGN KEY ([id_empleado_horario])
        REFERENCES [refugio].[empleado_horario] ([id_empleado_horario])
      ALTER TABLE [refugio].[cita] WITH CHECK ADD CONSTRAINT [fk_cita_animal] FOREIGN KEY ([id_animal])
        REFERENCES [refugio].[animal] ([id_animal])
    END
