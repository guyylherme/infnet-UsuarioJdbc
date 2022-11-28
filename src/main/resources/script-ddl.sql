create
    database infnetPedidoJDBC;
use
    infnetPedidoJDBC;

create table Usuario(
    id   int not null primary key auto_increment,
    nome varchar(80),
    sobrenome varchar(80),
    idade  integer,
    nascimento varchar(20)
);