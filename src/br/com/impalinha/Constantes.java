package br.com.impalinha;

public class Constantes {

	public static final String PERMISSION_ADMIN = "ImpCash.admin";
	public static final String COMMAND_NAME = "cash";
	public static final String KEYS_PATH = "Keys.";
	public static final String PREFIXO = "§f[§6§lZoneCash§f] §6» ";

	public static final String COMANDO_VERMAIS = "?";
	public static final String COMANDO_MOSTRARCASH = "mostrar";
	public static final String MENSAGEM_USO_CORRETO_MOSTRAR = "§cUse o formato correto! Ex:. /cash mostrar [Jogador]";
	public static final String COMANDO_ATIVAR = "ativar";
	public static final String MENSAGEM_ZONECASH_ATIVADO = "§aZoneCash ativado com sucesso.";
	public static final String MENSAGEM_CODIGO_INVALIDO = "§cEsse código é invalido.";
	public static final String MENSAGEM_USO_CORRETO_ATIVAR = "§cUso correto: /cash ativar [Codigo]";
	public static final String COMANDOS_ENVIAR = "enviar";
	public static final String MENSAGEM_NAO_POSSUI_SALDO = "§cVocê nao possui saldo o suficiente.";
	public static final String USO_CORRETO_ENVIAR = "§cUse o formato correto! Ex:. /cash enviar HadyMan 250";
	public static final String COMANDO_GERAR = "gerar";
	public static final String MENSAGEM_USO_CORRETO_GERAR = "§cUse o formato correto! Ex:. /cash gerar 250.00 15";
	public static final String COMANDO_SET = "set";
	public static final String MENSAGEM_USO_CORRETO_SET = "§cUse o formato correto! Ex:. /cash set [Jogador] [Quantidade]";
	public static final String COMANDO_REMOVE = "remove";
	public static final String MENSAGEM_USO_CORRETO_REMOVE = "§cUse o formato correto! Ex:. /cash remove [Jogador] [Quantidade]";
	public static final String MENSAGEM_USO_CORRETO_ADD = "§cUse o formato correto! Ex:. /cash add [Jogador] [Quantidade]";
	public static final String COMANDO_ADD = "add";
	public static final String[] LETRAS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "y", "x", "z"};
	public static final int[] NUMEROS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final String VALOR = ".Valor";
	public static final String DATA_EXPIRA = ".Data-Expira";
	public static final String INSERT_QUERY = "INSERT INTO `ImpCash`(`Player`, `Amount`) VALUES (?,?)";
	public static final String ERRO_CRIAR_JOGADOR = "§COps... tivemos um erro ao tentar criar o jogador na tabela.";
	public static final String QUERY_SELECT_AMOUNT = "SELECT `Amount` FROM `ImpCash` WHERE `Player` = ?";
	public static final String AMOUNT = "Amount";
	public static final String UPDATE_AMOUNT_QUERY = "UPDATE `ImpCash` SET `Amount` = ? WHERE `Player` = ?";
	public static final String SELECT_ALL_QUERY = "SELECT * FROM `ImpCash` WHERE `Player` = ?";
	public static final String MYSQL_IP_ANDRESS = "Mysql.ip-andress";
	public static final String MYSQL_USER = "Mysql.user";
	public static final String MYSQL_PASSWORD = "Mysql.password";
	public static final String JDBC_MYSQL = "jdbc:mysql://";
	public static final String SQL_10440256 = ":3306/s203_ImpCash";
	public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `ImpCash`(`Player` VARCHAR(64), `Amount` DOUBLE)";
	public static final String TABELA_CARREGADA = "§aTabela carregada com sucesso.";
	public static final String ERRO_AO_CARREGAR_TABELA = "§cErro ao carregar tabela.";
	public static final String PLUGIN_INICIADO = "§aO plugin foi iniciado com sucesso.";
	public static final String PLUGIN_FINALIZADO = "§cO plugin foi terminado com sucesso.";

}
