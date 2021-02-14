
DROP TABLE IF EXISTS perfilpermissao;
DROP TABLE IF EXISTS transferencia;
DROP TABLE IF EXISTS veiculo;
DROP TABLE IF EXISTS carro;
DROP TABLE IF EXISTS permissao;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS pessoa;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS marca;
DROP TABLE IF EXISTS categoria;

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY UNIQUE,
    nome VARCHAR(150),
    sobrenome VARCHAR(150),
    email VARCHAR(150) UNIQUE,
    logradouro VARCHAR(150),
    CEP VARCHAR(15),
    complemento VARCHAR(50),
    idcidade SERIAL,
    documento VARCHAR(21) UNIQUE,
    idusuario SERIAL
);

CREATE TABLE transferencia(
	id SERIAL PRIMARY KEY,
	idVeiculo SERIAL,
	dataT timestamp,
	valor float,
	idOrigem SERIAL,
	idDestino SERIAL,
	UNIQUE(id)
);

CREATE TABLE marca(
	id SERIAL PRIMARY KEY,
	descricao varchar(50),
	UNIQUE(id)
);

CREATE TABLE carro(
	id SERIAL PRIMARY KEY,
	descricao varchar(50),
	idMarca SERIAL,
	UNIQUE(id)
);

CREATE TABLE veiculo(
	id SERIAL PRIMARY KEY,
	renavam varchar(30),
	chassi varchar(30),
	anofabricacao varchar(10),
	anomodelo varchar(10),
	combustivel varchar(20),
	cor varchar(20),
	placa varchar(15) UNIQUE,
	idPessoa SERIAL,
	idCarro SERIAL,
	UNIQUE(id)
);


CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY UNIQUE,
    nome VARCHAR(150),
    sobrenome VARCHAR(150),
    email VARCHAR(150) UNIQUE,
    descricao VARCHAR(150),
    logradouro VARCHAR(150),
    CEP VARCHAR(15),
    complemento VARCHAR(50),
    idcidade SERIAL,
    documento VARCHAR(21) UNIQUE,
    idusuario SERIAL
);

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    login VARCHAR(150),
    tipoperfil SERIAL,
    senha VARCHAR(150),
    UNIQUE(login)
);

CREATE TABLE perfil (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150),
    descricao VARCHAR(150)
);

CREATE TABLE perfilpermissao (
    id SERIAL PRIMARY KEY,
    idpermissao SERIAL,
    idperfil SERIAL
);

CREATE TABLE permissao (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(150)
);



 
ALTER TABLE pessoa ADD CONSTRAINT FK_pessoa_1
    FOREIGN KEY (idusuario)
    REFERENCES usuario (id);
 
ALTER TABLE pessoa ADD CONSTRAINT FK_pessoa_2
    FOREIGN KEY (idcidade)
    REFERENCES cidade (id);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_1
    FOREIGN KEY (idusuario)
    REFERENCES usuario (id);
 
ALTER TABLE funcionario ADD CONSTRAINT FK_funcionario_2
    FOREIGN KEY (idcidade)
    REFERENCES cidade (id);
 
ALTER TABLE usuario ADD CONSTRAINT FK_usuario_1
    FOREIGN KEY (tipoperfil)
    REFERENCES perfil (id);
 
ALTER TABLE perfilpermissao ADD CONSTRAINT FK_perfilpermissao_1
    FOREIGN KEY (idpermissao)
    REFERENCES permissao (id);
 
ALTER TABLE perfilpermissao ADD CONSTRAINT FK_perfilpermissao_2
    FOREIGN KEY (idperfil)
    REFERENCES perfil (id);
 
ALTER TABLE transferencia ADD CONSTRAINT FK_transferencia_1
    FOREIGN KEY (idOrigem)
    REFERENCES pessoa (id);

ALTER TABLE transferencia ADD CONSTRAINT FK_transferencia_2
    FOREIGN KEY (idDestino)
    REFERENCES pessoa (id);

ALTER TABLE transferencia ADD CONSTRAINT FK_transferencia_3
    FOREIGN KEY (idVeiculo)
    REFERENCES veiculo (id);

ALTER TABLE carro ADD CONSTRAINT FK_carro_1
    FOREIGN KEY (idMarca)
    REFERENCES marca (id);
	
ALTER TABLE veiculo ADD CONSTRAINT FK_veiculo_1
    FOREIGN KEY (idCarro)
    REFERENCES carro (id);
 
 ALTER TABLE veiculo ADD CONSTRAINT FK_veiculo_2
    FOREIGN KEY (idPessoa)
    REFERENCES pessoa (id);

    /* -------------------------INSERTS----------------------*/
	
	insert into marca(descricao) values ('ford'),('hyundai'),('citroen'),('bmw'),('mercedes');
	insert into carro(descricao,idMarca) values ('mustang',1),('ka',1),('ecoesport',1),('edge',1),('territory',1),('azera',2),('elantra',2),('creta',2),('hb20',2),('santa fe',2),
	('cactus',3),('aircross',3),('lounge',3),('c3',3),('jumpy',3),('x3',4),('x4',4),('x5',4),('x6',4),('z4',4),('CLA',5),
	('GLB',5),('GLE',5),('CLA',5),('CLS',5);
	
    insert into permissao (descricao) values('ISADMIN'),('READ_EMPLOYEE'),('WRITE_EMPLOYEE'),('READ_SOMETHING'),('WRITE_SOMETHING'),('READ_SOMETIMES');

    insert into perfil (nome,descricao) values ('GERENTE GERAL','GERENCIAMENTO GERAL'),('SUB GERENTE GERAL','ABAIXO DA GERENCIA GERAL'),('ATENDENTE','ATENDENTE FISICO'),
    ('AUXILIAR TECNICO','ASPIRANTE A ATENDENTE'),('GERENTE1','GERENTE1'),('GERENTE2','GERENTE2'),('GERENTE3','GERENTE3'),
    ('GERENTE4','GERENTE4'),('GERENTE5','GERENTE5'),('GERENTE6','GERENTE6'),('GERENTE7','GERENTE7'),
    ('GERENTE8','GERENTE8'), ('USUARIO COMUM','PESSOA');

    insert into perfilpermissao (idpermissao,idperfil)values (1,1),(1,2),(2,3),(2,4),(3,5),(3,6),(4,7),(4,8),(5,9),(5,10),(6,11),(6,12),
    (3,1),(3,2),(4,3),(4,4),(5,5),(5,6),(6,7),(6,8),(1,9),(1,10),(2,11),(2,12), (6,13);



    /* inserts usuarios funcionario*/
    INSERT INTO "usuario" (login,tipoperfil,senha) VALUES ('22867','5','TIE25YNC6TF'),('83562','3','XQW91ZAG0II'),('58116','11','NSC94VWC9CU'),
    ('03160','7','CIP72KGQ4QD'),('73794','6','NOU85HEV3OC'),('61216','11','EVK86RTU2TI'),('93146','9','JMH26IYF5XT'),
    ('54578','12','ZEY88AIS3PY'),('76655','6','LKL23MEF3FO'),('62247','12','STN70APC1GB'),('97101','11','NHB66OYK4ZS'),
    ('36506','4','FIW38NUI2QI'),('82523','5','WSY62AOY4NI'),('66481','7','ODT63WVH0GJ'),('06874','5','FNS43JJC4GT'),
    ('05730','6','BPN36TMC2UL'),('42521','6','VXB61RWN1KF'),('80642','3','JFD82JUB8KN'),('39384','2','HCW66XKQ6MU'),
    ('36784','9','XOM03BHU2WU'),('80363','4','HJY36BCA3UT'),('64583','12','KVQ08CDF5UJ'),('56089','3','PKW41FWR5ZN'),
    ('84153','11','NZK67QEG9NH'),('06494','10','DMS71AXX2JR'),('79227','10','VAT52VAT0MQ'),('33309','11','TER84RJP9ZX'),
    ('32892','12','IFR84LJL0PT'),('75982','3','FGO03KXW9VS'),('64277','2','ZDM73ANQ9UJ'),('07366','11','TLB88IOY9GU'),
    ('45136','11','GGY16YOX4GF'),('80459','6','TXM83ZRM1KI'),('57275','3','MUQ27ILS8HI'),('06294','1','IXG98EWG0JA'),
    ('97768','7','OTD76NVR4GF'),('71516','7','XRH64TTH1KB'),('80592','5','GZP22EQJ3EX'),('43710','9','QZX58KRU2BA'),
    ('64550','12','NZT72SDC9EM'),('95794','12','DFM71XDK4GC'),('99915','11','KMH51ZPJ3IN'),('70855','1','LNO66TSQ4LN'),
    ('81816','3','MCS75ZHT0PR'),('38880','10','IPF35INH2DN'),('61178','1','NQM17BRF3RV'),('72587','9','CEG36XIR6HE'),
    ('83459','5','CLG35BXG7VM'),('28460','4','ZBJ57OFS1VF'),('94112','1','EIM46SHI5FL'),('14824','3','DNI59IHF0XS'),
    ('64569','10','NUV11EIG5GB'),('37321','7','EOR17FEW9SL'),('71760','4','CNH24PVB1RH'),('50926','2','PST46BTF1JC'),
    ('38648','10','UQA82GUB3CX'),('96632','4','VZP48VEC4PG'),('75455','11','LXJ18THX5WP'),('29379','3','SNT91ONQ8EZ'),
    ('95593','8','JBO25SXQ4OM'),('30824','5','PUC68UFF4KG'),('97218','1','QUE35WTD9VZ'),('76429','5','QRT49NEB2RZ'),
    ('21675','1','DMN90GWE5DL'),('62898','5','SHY64ORU5OI'),('53282','8','BJC08MRW2UR'),('17637','6','HPZ47PHR1KU'),
    ('93579','11','KQQ30WCQ4EK'),('21377','12','GQJ25MAI4XS'),('68716','11','KBG42WHA9QV'),('29587','6','WPD03FWN7EQ'),
    ('31385','9','OAC83YCJ5WY'),('11284','2','GIH03HHT1XI'),('56123','3','EBJ87LDC5EB'),('62897','2','XDZ29EFG5HA'),
    ('54427','2','BJX82WVW5MB'),('03744','12','GAO38XBQ5TV'),('65474','2','ZBI30FKB3NE'),('99089','4','AIX07RBQ7XD'),
    ('45729','8','ZBH30JBK7PC'),('36352','1','FGB92DGR7EG'),('91798','7','CSD44MOU9BV'),('07600','8','LMQ56XQW1YE'),
    ('34979','9','QGB97ONY6BV'),('09325','9','PXP15SUN4RV'),('88956','7','WZJ07MDR7NB'),('89246','8','KZF42AJT3ME'),
    ('78650','10','MNZ17CIG0HH'),('54311','8','AIP14VPF6GV'),('82545','9','LDE74GVR7HN'),('97241','3','XFG67XUM6IZ'),
    ('30425','8','ERK15ZCY8TX'),('55436','5','WWG54XKK8XJ'),('03241','1','YPJ24WHR2FF'),('71180','5','RCN47KWL3UX'),
    ('39052','2','ELD20WSE9II'),('05031','1','KLQ33ZCF9XA'),('71668','9','UCR75CDF7RR'),('30515','12','CEQ31HTV1OP'),('62651','2','SZQ54YPI7UD');
    /* inserts usuarios clientes*/
    INSERT INTO "usuario" (login,tipoperfil,senha) VALUES ('60699','13','JI15YFX2YC'),('55416','13','DC21LER0SW'),('39915','13','SN14TCQ5SI'),
    ('09439','13','YY16EFI2VJ'),('85671','13','IL44SLD1GX'),('63690','13','KF81EJN6DO'),('23813','13','OO95VBO5HR'),('07946','13','BU75GEK3SJ'),
    ('31272','13','OD88TLJ1LS'),('57288','13','ZA07WOH5FQ'),('12806','13','GD46VIS9TG'),('90895','13','TZ96JMD4TH'),('54663','13','CA03ZYD6OB'),
    ('06130','13','DD31WYK0VI'),('90924','13','JH18REE3WS'),('96298','13','XW34CZL6OK'),('99254','13','MD14FRS9MC'),('07290','13','MM39RNB9TF'),
    ('23925','13','TH57AOL1DH'),('14205','13','XW93HPG9QW'),('81527','13','FI36CQA3DO'),('55686','13','SJ22BQR7WQ'),('92367','13','BM06AHZ9WB'),
    ('89400','13','HO33CGP1SD'),('51340','13','GP87ECQ5UW'),('43816','13','NC32BXK8IW'),('19723','13','SP16RLE5HU'),('10137','13','VV64DDA5II'),
    ('82006','13','QL83TCZ2JE'),('49590','13','CK24JHT8GM'),('77747','13','PB24KZA5UN'),('36362','13','PO11FRV1QJ'),('84924','13','VB30CPL6KM'),
    ('88294','13','EP38NQM3LX'),('95083','13','DX16GPX2IA'),('04989','13','BF01MEC8UD'),('97262','13','LQ73JUF0LK'),('26442','13','PK34BXI8LP'),
    ('28342','13','WJ28FPQ4DJ'),('37188','13','UE91BAG5KG'),('21635','13','JA83YTG4AL'),('58165','13','YG62IKS2RC'),('06186','13','XT06ENJ5ZW'),
    ('62205','13','NI56ZBE8FI'),('43739','13','CB84BXA1PM'),('97431','13','UK24JJS0UU'),('69915','13','FQ02NWD4QK'),('15752','13','NB49MAD9HW'),
    ('83226','13','QY97TVI3YV'),('63805','13','OB77YHV5EM');


    INSERT INTO "pessoa" (nome,sobrenome,email,logradouro,CEP,complemento,idcidade,documento,idusuario) VALUES 
    ('Kathleen','Love','accumsan@nec.org','Ap #220-8107 Dui. Avenue','57223-599','apartamento','892','87585785339',101),
    ('Benjamin','Stone','pede@mattisornarelectus.co.uk','Ap #240-9167 Quisque Rd.','42012-079','residencial','1489','46629872441',102),
    ('Priscilla','Cole','lorem.ac.risus@sed.edu','Ap #183-7285 Nunc Avenue','73948-893','casa','893','90481169336',103),
    ('Kai','Cleveland','Morbi@Nam.edu','5066 Nisi. St.','68950-024','residencial','394','05709814965',104),
    ('Hedda','Hodges','metus.urna.convallis@fringillaestMauris.net','P.O. Box 948, 1925 Lobortis Av.','38946-783','apartamento','1535','15208531036',105),
    ('Cheyenne','Tucker','tristique.senectus@metusAeneansed.co.uk','Ap #114-8210 Turpis Rd.','19811-873','condominio','267','33872263216',106),
    ('Paloma','Alvarado','Cras.eu.tellus@Maurisnon.edu','502-9881 Dapibus Ave','65503-977','apartamento','871','72245404041',107),
    ('Kylee','Carrillo','malesuada.vel.convallis@litora.ca','494-8641 A, Rd.','74812-895','casa','380','95315061555',108),
    ('Jocelyn','Burris','Praesent.interdum@dis.edu','Ap #448-4014 Nunc Ave','88007-062','residencial','746','46939074500',109),
    ('Dante','Bowen','consectetuer@at.edu','P.O. Box 807, 3937 Pellentesque. Street','54132-096','casa','140','01921221368',110),
    ('Isaiah','French','tempus@ultricesposuerecubilia.co.uk','597-5458 Rhoncus. Road','75742-527','condominio','448','66651836977',111),
    ('Idona','Ball','mus.Proin@egestas.com','P.O. Box 822, 1395 Integer Avenue','78279-179','residencial','159','79747335696',112),
    ('Dacey','Johns','Nulla.eget@nibhsitamet.ca','P.O. Box 512, 8388 Nulla St.','76595-601','condominio','1356','04548686038',113),
    ('Honorato','Charles','lectus.quis@vel.net','Ap #450-3147 Vitae St.','46933-625','condominio','797','88024357654',114),
    ('Dean','Flores','nec@odioAliquam.com','Ap #578-6093 Iaculis, Av.','86289-975','apartamento','1318','68244059468',115),
    ('Uriah','Rich','dapibus.rutrum.justo@malesuadaid.org','589-3307 Adipiscing. Rd.','32931-084','apartamento','1249','54456370568',116),
    ('Kylynn','York','auctor.nunc.nulla@ipsumdolor.org','P.O. Box 602, 1232 Tincidunt Rd.','69886-014','apartamento','92','62743618858',117),
    ('Paul','Farrell','commodo.hendrerit.Donec@ligulaAeneangravida.edu','505-9093 Orci Street','80582-027','residencial','1190','03759909954',118),
    ('Zorita','Conway','posuere.at@felis.ca','676-177 Nec Road','80317-041','condominio','692','06599096277',119),
    ('Charde','Thomas','sed.pede@ornareplacerat.net','7101 Curabitur Rd.','30270-051','condominio','891','92504019437',120),
    ('Paki','Frye','mauris@imperdietornare.com','Ap #148-9817 Id Road','53675-718','casa','10','33412050976',121),
    ('Hanae','Briggs','orci.lobortis.augue@pellentesqueeget.edu','Ap #762-2329 A, Av.','34972-630','apartamento','1365','18656731523',122),
    ('Adena','Banks','luctus.sit.amet@risusQuisque.co.uk','8611 Elit Ave','71892-837','condominio','840','80724409377',123),
    ('Sade','Francis','semper.auctor@velturpis.co.uk','Ap #837-6161 Velit. St.','76375-553','residencial','429','46866689537',124),
    ('Camilla','Adkins','sagittis.Duis.gravida@et.edu','Ap #679-5341 Eget Street','12070-285','condominio','118','96177884477',125),
    ('Athena','Spence','ac@NullafacilisiSed.com','5964 In St.','63454-230','casa','1019','16987390521',126),
    ('Marcia','Jones','diam@tellus.org','9785 Consequat Street','72611-444','casa','151','26189157689',127),
    ('Ross','Knapp','at.augue@sedtortor.com','367 Turpis. Ave','36072-157','residencial','975','80392688456',128),
    ('Adele','Erickson','pharetra.Nam.ac@loremvitaeodio.ca','402-215 Molestie St.','37826-460','casa','1285','07176691309',129),
    ('Rama','Walker','rutrum.lorem@elitpharetraut.ca','P.O. Box 917, 8321 Mattis St.','98559-267','apartamento','203','90787529548',130),
    ('Quynn','Stanton','eget.massa@tempus.edu','289 Sed Rd.','63763-160','apartamento','1523','44015413662',131),
    ('Oprah','Eaton','Cras.sed@dolorelitpellentesque.net','Ap #966-7069 Nonummy St.','87594-516','apartamento','96','83916644070',132),
    ('Doris','Fernandez','non.enim@urnaconvallis.com','P.O. Box 724, 6446 Luctus Street','35433-296','residencial','383','37814204886',133),
    ('Blaze','Ortega','magna.Phasellus.dolor@lectus.edu','Ap #145-4442 Odio St.','98619-018','apartamento','730','61879167109',134),
    ('Alexis','Rios','odio.Nam@lobortisrisusIn.org','P.O. Box 790, 1104 Dolor. Ave','12848-516','apartamento','1283','23116639390',135),
    ('Melyssa','Mcmillan','tellus@justo.org','404-4725 Cursus Street','53444-311','casa','203','60806789850',136),
    ('Maxwell','Stanton','quis@felisullamcorperviverra.co.uk','Ap #920-7963 Auctor St.','74006-599','residencial','101','57820581999',137),
    ('Olga','Hunt','at.lacus@primisin.edu','3782 Lorem St.','47220-129','condominio','1344','92047580918',138),
    ('Donovan','Brock','Vivamus.euismod.urna@lacinia.com','7895 Ultricies Rd.','18886-011','casa','735','20929801910',139),
    ('Lyle','Holder','vulputate@consectetuer.com','6250 Tristique Av.','45718-320','casa','159','70179153872',140),
    ('Bianca','Norton','tincidunt.dui@antelectus.edu','512-7425 Pede St.','85827-297','residencial','965','06792335207',141),
    ('Christen','Sears','nibh.vulputate@ametdiameu.co.uk','803-670 Vitae, Av.','87129-608','condominio','1150','29359062240',142),
    ('Jillian','Pruitt','imperdiet.ullamcorper@nequepellentesque.co.uk','583-4349 Bibendum Av.','13124-671','apartamento','204','25633885229',143),
    ('Clare','Witt','nec@elementumsem.com','321-5934 Lacus. St.','48287-232','residencial','1519','72461880045',144),
    ('Courtney','Mclean','lobortis@sitametmetus.co.uk','566-6195 Pretium Avenue','90096-073','residencial','1294','41168862625',145),
    ('Dakota','Aguilar','sociis.natoque@Integereu.edu','6089 In Road','03911-070','condominio','155','49011013577',146),
    ('Zahir','Mccormick','convallis.convallis.dolor@Fuscefermentum.co.uk','P.O. Box 242, 4487 Mattis Street','19949-140','condominio','1015','80680775904',147),
    ('Wyatt','Walls','blandit.Nam.nulla@maurisipsumporta.com','5227 Vel, St.','77632-976','casa','1549','44757981617',148),
    ('Cheyenne','Mcdonald','amet.nulla@adipiscingelitAliquam.ca','Ap #594-1328 Risus. Street','48121-263','apartamento','951','97032288815',149),
    ('Melodie','England','est@posuereatvelit.edu','Ap #365-2524 Phasellus Av.','21157-859','residencial','1126','79433795075',150);
    
 



    INSERT INTO "funcionario" (nome,sobrenome,email,logradouro,CEP,idcidade,documento,idusuario) 
    VALUES ('Adrian','Flynn','Cras.dolor@eget.net','P.O. Box 830, 2159 Amet, Avenue','72231-475','2285','LKBOV62CSH5WZ',1),
    ('Honorato','Petersen','orci@idmagna.co.uk','3520 Sit Avenue','45426-641','3010','DKSYF74EDM6IQ',2),
    ('Rinah','Ferrell','risus.In.mi@vellectusCum.co.uk','9134 Mollis. Street','22159-979','2509','BLDCT64BNP9YG',3),
    ('Naomi','Hester','Donec.at@Nullasemper.org','933-6978 Orci Rd.','15779-205','2786','CNELO18MQP7IJ',4),
    ('Orlando','Snider','tristique@iaculisquis.com','Ap #870-7888 Scelerisque Ave','55797-320','2084','MKQPF41GAR5DF',5),
    ('Valentine','Ewing','elementum@purusaccumsaninterdum.ca','Ap #114-9727 Pharetra, Avenue','95941-157','2765','YJWVH97DJB1GP',6),
    ('Sloane','Stuart','Nullam@consequatlectussit.org','188-590 Nonummy Street','98705-382','2889','NCXQH94JDI3VD',7),
    ('Raymond','Grimes','et.magna@nasceturridiculusmus.net','673-5421 Faucibus Avenue','07364-143','2969','DQQNS58QKO0AA',8),
    ('Buckminster','Wynn','placerat.velit@posuereenimnisl.com','Ap #347-1862 Duis Rd.','56230-078','3058','MYSDB07DUA1ZO',9),
    ('Chava','Thompson','a.nunc.In@risusDonecegestas.net','Ap #807-9606 Aliquam St.','20116-419','2864','OHOVT42LGF9NU',10),
    ('Aspen','Beard','interdum@Sednuncest.edu','2088 Montes, Street','16562-833','3344','RPHKA62CTS4MW',11),
    ('Madison','Guthrie','dolor@CraspellentesqueSed.com','392-9021 Ipsum. St.','30699-737','2474','HPPMA88PIC7JC',12),
    ('Shafira','Adams','enim.Mauris@anteblanditviverra.org','P.O. Box 771, 6850 Phasellus Rd.','55350-560','2991','YWCSB27CID3VZ',13),
    ('Paloma','Bernard','nec.ante@tinciduntadipiscingMauris.edu','9327 Tempus Street','52698-223','2387','DYWKQ97RFZ8SK',14),
    ('Jolie','Gregory','at.augue.id@pulvinar.ca','632-1888 Fermentum Rd.','36430-481','2577','DGMIR31NWS6DL',15),
    ('Wilma','Holden','eget@molestie.org','919-5813 Lacus. Street','13920-716','2197','PKTMX76WLJ8EQ',16),
    ('Louis','Fernandez','dolor.quam.elementum@Donecelementum.org','P.O. Box 874, 8484 Per Street','45228-575','2224','MOHGI52WYL3BR',17),
    ('Ulla','Holland','elit.Curabitur@tempus.co.uk','P.O. Box 453, 7455 Duis St.','32318-092','3083','WYDGX08VSC3AI',18),
    ('Raymond','Oconnor','ullamcorper.Duis@vitae.com','P.O. Box 595, 9386 Ultricies Road','80187-997','3250','CZEAZ90KME7WU',19),
    ('Joshua','Pacheco','placerat.eget.venenatis@etpedeNunc.co.uk','8869 Quam Rd.','29601-312','2328','OJCFP13VQX1EY',20),
    ('Joel','Duran','vel.arcu@Quisquefringillaeuismod.com','P.O. Box 341, 9772 Ipsum. Rd.','63185-830','2401','IFJEA97LXG2CQ',21),
    ('Chancellor','Norman','sem.eget.massa@pede.co.uk','P.O. Box 159, 6998 Etiam Road','59758-929','2188','HEDGM43ROU0WA',22),
    ('Hilary','Lynch','Pellentesque.ultricies.dignissim@mattisCraseget.co.uk','Ap #226-1820 Imperdiet Rd.','91738-011','2447','OBVPT29UWX6KC',23),
    ('Neil','Cummings','Nullam.velit.dui@famesacturpis.com','P.O. Box 129, 7087 Magna Rd.','38027-231','3134','FGUEF87IDG6AJ',24),
    ('Macaulay','Mathews','dui.augue@adipiscingelit.co.uk','706-5923 Donec Street','85111-982','3192','ZVLPM85EJZ2WB',25),
    ('Rana','Rowe','erat.in@aodiosemper.net','Ap #462-6629 Elit. St.','15544-818','2654','SCNGS88DJW7PT',26),
    ('Herrod','Gomez','malesuada.fringilla@Curae.co.uk','P.O. Box 440, 2140 Auctor Av.','27008-532','3116','XWYTJ40NFC9TR',27),
    ('Jacob','Carver','et.magnis@elit.org','448-3913 Rutrum. Av.','87247-240','3280','CXIGU09HSU3NQ',28),
    ('Zephr','Riddle','orci.quis.lectus@velpedeblandit.edu','P.O. Box 655, 3522 Eu, Ave','00711-566','3401','SJULO49TKW8DZ',29),
    ('Nola','Glover','scelerisque.mollis@NullafacilisisSuspendisse.co.uk','Ap #414-9154 Metus St.','24286-738','2340','VUQSG60VLI1YI',30),
    ('Stephen','Stanton','non.quam.Pellentesque@sodalesatvelit.net','Ap #397-2711 Vel, Road','52160-728','2905','LMQFC11TOV4XK',31),
    ('Jermaine','Blake','egestas@vitaeodio.net','7984 Etiam Av.','94406-729','2764','RPTKM37UZR2RX',32),
    ('Julian','Mcintyre','placerat.velit.Quisque@Donec.com','P.O. Box 241, 6044 Integer Rd.','95770-799','3247','URNLI56MME9BL',33),
    ('Autumn','Mccray','ligula.Aliquam@tinciduntorciquis.edu','P.O. Box 277, 7664 Nulla Av.','74898-250','2152','VJXTR78XOP4KV',34),
    ('Patricia','Gibbs','risus.Nunc@non.ca','P.O. Box 775, 9730 Semper Rd.','79807-102','2469','LPSES51GZQ6EN',35),
    ('Sybill','Ryan','at@cursusa.ca','P.O. Box 997, 8110 Dui Rd.','31843-961','3363','LTZXZ69EGP7XV',36),
    ('Arthur','Navarro','pharetra@sagittisDuisgravida.org','Ap #394-2623 Quis, Av.','50162-325','2464','SNFZX95THT5DH',37),
    ('Harriet','Doyle','blandit.Nam@eratVivamusnisi.com','P.O. Box 610, 8590 Neque Av.','31657-179','2785','GOUKT02JDM5AE',38),
    ('Hilary','Buck','Donec@dui.ca','P.O. Box 262, 6310 Aliquam Ave','72239-510','2697','VXJBX02GCJ0HG',39),
    ('Uriel','Orr','Mauris.quis@Aeneaneget.edu','Ap #692-7373 Ac Avenue','92717-343','3332','JLHWZ61VXA1QF',40),
    ('Kermit','Hinton','urna@liberoduinec.edu','P.O. Box 208, 4228 Etiam St.','31316-516','2720','LNIWL14CQE6WB',41),
    ('Ria','Wood','varius@necurna.edu','Ap #692-9345 Sit St.','21454-933','2637','MXCAX04GQK6AL',42),
    ('Winifred','Crosby','facilisis@vitae.net','Ap #244-2594 Donec St.','12598-963','2210','FUALR78HSB7KL',43),
    ('Brenden','Boyer','Integer.eu.lacus@metusAliquam.net','4931 Aliquam Avenue','80353-233','3411','DGIKB06NTL0IR',44),
    ('Wanda','Brennan','et.rutrum.eu@interdumligula.org','P.O. Box 247, 2624 Fringilla, Av.','17536-757','3013','QPHWS80FJZ5RC',45),
    ('Mollie','Conrad','commodo.at@Fuscealiquet.net','P.O. Box 939, 6257 Diam. Ave','85943-783','3030','BODMF09PER9FF',46),
    ('Eugenia','Greer','id@imperdietnon.net','6460 Aliquet Rd.','12034-461','2211','OSRVY54NFH7ZV',47),
    ('Kim','Burns','neque.Nullam@montesnascetur.co.uk','4547 Tempus, Rd.','47495-831','3076','OVZAT94ARW4GO',48),
    ('Mara','Oconnor','sodales@consequatlectussit.ca','Ap #427-4958 Aliquam Street','18785-539','2622','CKEKL16OHE6PY',49),
    ('Cailin','Alvarez','id@Praesent.edu','P.O. Box 717, 8317 Viverra. Avenue','12357-471','2759','IIPRV30VTN3FK',50),
    ('Germane','Oneil','mi@convallisestvitae.net','Ap #409-8442 Pellentesque, Rd.','48082-918','2577','JUWDL45CYC8KX',51),
    ('Devin','Whitley','nec.urna@fringillamilacinia.ca','5416 Cras St.','72485-334','2018','KGTDN75NHM1GT',52),
    ('Lunea','Cobb','lacus@utmi.co.uk','3571 Cras Rd.','50619-599','2429','FWSPJ58XQJ3ZU',53),
    ('Camille','Mccullough','blandit.viverra@dapibus.edu','8348 Lorem St.','25959-099','2317','KPEGD91WXQ4HK',54),
    ('Xerxes','Roberson','lorem.ipsum.sodales@ataugueid.org','Ap #634-4054 Sagittis St.','91731-614','2432','HEBKY02EXR1YT',55),
    ('Leroy','Meadows','justo@suscipitnonummyFusce.co.uk','Ap #265-4806 Eget Street','86546-424','2647','UPTNK38FOD1NO',56),
    ('David','Murphy','neque.sed.dictum@ut.com','371-9915 Elit. Avenue','01438-269','3103','LCGJP09EZL0UV',57),
    ('Sloane','Key','lobortis.risus.In@nequeIn.edu','P.O. Box 282, 8668 Accumsan St.','47478-506','3226','OLTBZ66LNW5QA',58),
    ('Lucian','Cabrera','Quisque.varius.Nam@Nullatempor.edu','6347 Odio. St.','83974-019','2100','RQNZB49VEM9PQ',59),
    ('Shannon','Shepard','tempus@enim.edu','179-5126 Ante Rd.','31953-861','2481','LFFHC26QGB2ZJ',60),
    ('Nyssa','Sims','Curabitur.egestas@laciniaSed.net','6656 Rhoncus. Road','20505-719','2667','SNTSD50BZA0FQ',61),
    ('Mia','Haynes','tincidunt.aliquam.arcu@magnaSuspendisse.net','2919 Tristique Av.','74795-076','2596','NSMEJ33PZR6TE',62),
    ('Oscar','Brock','neque.et@sem.org','6670 Dapibus Rd.','29375-686','2670','NMHPS54ZQD0AG',63),
    ('Miriam','Parrish','Donec.sollicitudin@Proinvel.com','4554 Porttitor Rd.','84986-550','2365','TPDFU26YIL3SM',64),
    ('Sarah','Bentley','a@congueturpisIn.com','Ap #564-9043 Nulla Street','90223-615','2233','DZSIH68YRE2PA',65),
    ('Reed','Lucas','et.malesuada@pharetrautpharetra.co.uk','906-4796 Etiam Street','05791-947','3179','MBWKH44LJK4WE',66),
    ('Caleb','Petersen','ante@ametdiam.co.uk','361-8318 Nunc Av.','38656-014','2961','IIREN39EGS7TI',67),
    ('Christopher','Key','mauris.erat.eget@lectusquismassa.com','7862 Eget Road','71850-636','2132','USMZH97IQY5VC',68),
    ('Zoe','Parrish','molestie@Donecelementumlorem.net','P.O. Box 640, 3510 Elementum Street','10782-192','2253','PRDLN61LGB5YY',69),
    ('Channing','Silva','Sed.et@fringillaornare.org','2712 Leo, St.','14642-467','2003','TZTTH87FIN0ZU',70),
    ('Declan','Chase','est@Nullaegetmetus.ca','Ap #277-9013 Euismod Rd.','09615-173','2421','RBCAT12FZL8CM',71),
    ('Clementine','Blankenship','interdum.feugiat@necdiamDuis.net','Ap #515-9942 Tincidunt. Avenue','38586-674','2682','QELNG24SGE8WZ',72),
    ('Austin','Flores','interdum.Sed@Morbimetus.com','572-4858 Fames Avenue','04735-276','2201','RZTDY86QEX4BI',73),
    ('Maite','Wheeler','lacus.Quisque.purus@turpisnonenim.edu','657-9207 Quisque St.','39339-808','2040','AIWFG88OSI2MV',74),
    ('Stuart','Gay','non.nisi.Aenean@Vestibulumante.com','373-5816 Aenean Rd.','23292-605','3405','RCCXF14DVX8CY',75),
    ('Burke','Nicholson','Duis@gravida.net','P.O. Box 784, 7548 Non St.','05597-939','2055','GOYSS83MRW7ED',76),
    ('Ryan','Kennedy','Mauris.eu.turpis@Sedcongueelit.edu','P.O. Box 802, 5391 Quis St.','97741-578','2282','LISAG07TYU7GP',77),
    ('Castor','Berry','malesuada.vel.venenatis@Lorem.org','Ap #647-2383 Sit Ave','99173-134','2904','PAMXO59AYM4XM',78),
    ('Abigail','Townsend','imperdiet.erat@ultricies.com','632-9156 Mauris Road','79364-963','2333','GOGTV79DKW6UP',79),
    ('Kenyon','Mcmillan','a.feugiat.tellus@porta.net','2574 Metus St.','34439-282','3113','QWWAN25JQL4JY',80),
    ('Brett','Conrad','nibh.sit.amet@euismodac.net','784-6222 Lacinia. Avenue','99802-299','3048','WMDYA14IUP6JJ',81),
    ('Keaton','Livingston','ut@tortor.co.uk','375-2296 Metus. Rd.','99319-751','3348','IRATN83KOW5VS',82),
    ('Hiram','Spencer','interdum.ligula@eu.net','P.O. Box 266, 5046 Nullam Rd.','17204-766','3397','KIGPV28UST1DB',83),
    ('Clark','Haney','non.massa.non@neque.ca','Ap #472-4911 Est Av.','20846-241','2078','ZBVES77FQZ4ZI',84),
    ('Avram','Pate','aliquam@aliquetodioEtiam.edu','148-5100 Auctor Av.','92242-587','2726','DOTGR28DDQ9BD',85),
    ('McKenzie','Simon','turpis.nec@sitametante.net','321-7349 Odio. Ave','76257-572','2573','DTUDP17PMU3MV',86),
    ('Alea','Nash','libero@rutrumnon.ca','Ap #588-7990 Quis, Road','31244-068','2574','DTRYZ08PWG1KP',87),
    ('Tobias','Griffin','nec.eleifend.non@augueeutellus.edu','Ap #211-6301 Sit Road','58672-991','2974','WSLKE85ZQY0JU',88),
    ('Jonas','Hayden','Mauris.eu.turpis@egetvolutpat.ca','1222 Quis Rd.','34439-543','2190','BOWYR78BBV4PQ',89),
    ('Gannon','Oconnor','vehicula@egestasrhoncus.org','Ap #613-9226 Consectetuer Ave','17167-746','2074','ZHXCI43QPI4KL',90),
    ('Sigourney','Hendricks','Integer.urna.Vivamus@volutpatornarefacilisis.net','P.O. Box 541, 6398 Tellus. St.','24726-377','3270','JDEXA68BFI0ZL',91),
    ('Brenna','Dodson','Sed.eget.lacus@Cumsociisnatoque.org','Ap #921-2755 Tempor St.','66009-317','2031','KLOVF12QIH8WR',92),
    ('Martin','Pitts','aliquet.metus@arcuimperdietullamcorper.edu','Ap #224-1541 Felis Road','99685-110','2167','CUOXG29XFZ5ON',93),
    ('Thane','Barker','sapien.Aenean.massa@egestas.edu','P.O. Box 467, 2446 Eu Avenue','37991-753','2460','HCBYX35DLT3WN',94),
    ('Leroy','Ray','at.risus@doloregestas.ca','P.O. Box 312, 6007 Aliquet. Road','19376-331','3003','YKBQG18CTF9BD',95),
    ('Devin','Calhoun','velit.Sed@ullamcorper.net','109-2965 Nulla Ave','48051-091','2104','XLMCF28MUO1KB',96),
    ('Holmes','Garrison','Nullam.velit@auctorodio.co.uk','P.O. Box 513, 6636 In Ave','69457-143','3299','FYUMS40TGS1VR',97),
    ('Tamekah','Sharp','lobortis.tellus@MaurisnullaInteger.ca','P.O. Box 740, 2777 Lorem Street','18379-439','2916','ZRQZW88AUU8NA',98),
    ('Jerry','Strong','neque.sed@Nullatincidunt.com','9436 Risus. Ave','80221-481','2578','JGAVK95SPF8EY',99),
    ('Walter','Farrell','semper.rutrum.Fusce@liberoInteger.co.uk','Ap #909-7282 Etiam Avenue','12803-382','3370','ZIPFL94ZUV5IA',100);


INSERT INTO "veiculo" (renavam,chassi,anofabricacao,anomodelo,combustivel,cor,placa,idPessoa,idCarro) VALUES 
('44609582799','16890610 0535','2016','2017','flex','verde','RKE2534','42','7'),
('67816544599','16840607 5823','2016','2017','flex','azul','PJA5479','2','23'),
('02792712299','16151122 5995','2016','2017','gasolina','laranja','HRM1419','18','23'),
('92651193699','16741002 9172','2016','2017','flex','laranja','WSB4494','17','6'),
('12836031499','16780311 0381','2016','2017','gasolina','verde','KWJ3235','11','9'),
('80357878299','16110703 7648','2016','2017','alcool','verde','DMV9350','11','9'),
('31209155899','16900211 1632','2016','2017','flex','azul','SPZ0986','35','11'),
('99429035399','16240614 5462','2016','2017','flex','verde','CXM9512','17','10'),
('60454385199','16060111 9456','2016','2017','gasolina','verde','SYL0128','18','19'),
('27795016499','16890804 2255','2016','2017','alcool','cinza','LFJ4327','40','12'),
('76884912699','16960804 2504','2016','2017','alcool','amarelo','QLM7546','34','22')
,('14341452399','16180216 7229','2016','2017','flex','azul','OSX0318','2','22'),
('46203866299','16101004 6660','2016','2017','alcool','roxo','STX0626','37','19'),
('99313996099','16591004 2448','2016','2017','alcool','amarelo','KFD0288','31','19'),
('95889151999','16970718 1476','2016','2017','gasolina','cinza','MRS2833','30','1'),
('48647644599','16741210 7604','2016','2017','gasolina','roxo','NKE1498','30','14'),
('66275525499','16520120 5316','2016','2017','alcool','cinza','OTO4458','33','7'),
('04537229599','16190517 4775','2016','2017','flex','verde','QSB6174','19','23'),
('42649792499','16350914 2703','2016','2017','flex','roxo','EQG5694','41','1'),
('25627202799','16101119 4998','2016','2017','gasolina','azul','GBF4564','16','12'),
('53728212699','16410823 6516','2016','2017','flex','verde','XZD4333','27','10'),
('52747936299','16201209 6190','2016','2017','alcool','amarelo','CQM7593','13','8'),
('08885215799','16021227 8113','2016','2017','gasolina','verde','WUU4869','47','11'),
('94937519699','16701014 2821','2016','2017','flex','roxo','WUI6595','36','1'),
('74724516999','16671102 4874','2016','2017','gasolina','vermelho','SLK6462','43','17'),
('29516036399','16001109 1105','2016','2017','alcool','cinza','ISH7110','6','13'),
('88719650599','16311001 4630','2016','2017','flex','azul','TLF0819','7','9'),
('56649512299','16290330 9868','2016','2017','flex','roxo','VVZ1393','7','4'),
('02619380899','16970605 7669','2016','2017','alcool','verde','ZSO6548','36','1'),
('34703018699','16451016 0320','2016','2017','alcool','amarelo','AOJ6890','29','3'),
('40396869399','16410427 3232','2016','2017','alcool','cinza','LTM6535','30','2'),
('06949754899','16210606 0748','2016','2017','gasolina','laranja','NYC6750','22','9'),
('17695061199','16470727 5840','2016','2017','alcool','azul','WWA1871','8','7'),
('65585876699','16000814 0972','2016','2017','flex','azul','DNM8662','50','2'),
('68678547599','16060430 4089','2016','2017','flex','amarelo','SPT0368','41','24'),
('59844608599','16240304 1896','2016','2017','flex','azul','PMO8519','17','25'),
('50233628499','16460110 5267','2016','2017','alcool','roxo','HRY9047','39','13'),
('80269595399','16470207 7951','2016','2017','flex','roxo','QPW2866','15','24'),
('82504499599','16780912 5391','2016','2017','gasolina','verde','BAV5817','25','8'),
('48775262599','16820204 4387','2016','2017','flex','cinza','BQL6349','13','13'),
('38581546899','16841012 3189','2016','2017','flex','verde','KLF9296','9','11'),
('06433951999','16640320 6409','2016','2017','flex','verde','JVH4056','37','4'),
('72692296799','16320629 0284','2016','2017','alcool','vermelho','SWY5022','26','19'),
('77396803399','16910723 4057','2016','2017','alcool','cinza','ZTC3028','10','10'),
('60491978499','16980710 4444','2016','2017','gasolina','amarelo','SHU7341','32','24'),
('50228117499','16201010 8849','2016','2017','gasolina','roxo','OID6466','16','12'),
('46414579599','16200329 0976','2016','2017','gasolina','laranja','YUO3454','11','1'),
('54944522699','16090214 9624','2016','2017','flex','roxo','SSZ6043','40','2'),
('04361240399','16040309 5730','2016','2017','flex','vermelho','AOQ0964','41','23'),
('66752741999','16070928 2362','2016','2017','flex','azul','NXY0892','36','21');

insert into transferencia (idVeiculo,dataT,valor,idOrigem,idDestino) values 
(50,'20200618 10:34:09 AM',22000,41,36),
(49,'20200618 11:34:09 AM',300000,40,41),(48,'20200619 10:34:09 AM',203000,11,40),(47,'20200619 11:34:09 AM',400000,16,11),
(46,'20200620 10:34:09 AM',15000,32,16),(45,'20200620 11:34:09 AM',1078890,10,32),(44,'20200621 06:34:09 AM',777989,26,10);

