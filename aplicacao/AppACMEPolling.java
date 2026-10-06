package aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import dados.*;

public class AppACMEPolling{
    private Scanner entrada;
    private PrintStream saidaPadrao = System.out;  
    private final String nomeArquivoEntrada = "pollingin.txt";  // entrada de dados
    private final String nomeArquivoSaida = "pollingout.txt";  // saida de dados
    private CadastroPartidos cadastroPartido;
    private CadastroCandidato cadastroCandidato;
    private CadastroLocalidades cadastroLocalidade;
    private CadastroVotos cadastroVoto;

    public AppACMEPolling() {
        redirecionaEntrada();
        redirecionaSaida();
        entrada = new Scanner(System.in);
        cadastroPartido = new CadastroPartidos();
        cadastroLocalidade = new CadastroLocalidades();
        cadastroCandidato = new CadastroCandidato();
    }

    public void executa() {
        System.out.println("ACMEPolling -- Trabalho 1 de POO");

        //cadastro partidos
        System.out.println("Cadastro de Partidos");
        while (true) {
        System.out.println("Diga o codigo(numero) do partido: ");
        int codigo = entrada.nextInt();
        if (codigo == -1) {
        break;
    }
    entrada.nextLine();
    System.out.println("Diga o nome: ");
    String nomePartido = entrada.nextLine();
    Partido partido = new Partido(codigo, nomePartido);
    cadastroPartido.cadastra(partido); }

        //cadastro localidades
        System.out.println("Cadastro de Localidades: ");
        while (true) {
    System.out.println("Diga o CEP: ");
    String cep = entrada.next();
    if (cep.equals("-1")) {
        break;
    }
    System.out.println("Diga o nome: ");
    String nomeLocalidade = entrada.next();
    System.out.println("Quantidade de eleitores: ");
    long qtdEleitores = entrada.nextLong();
    System.out.println("Diga o tipo da localidade: ");
    String tipoAux = entrada.next();
    TipoLocalidade tipo;
    if (tipoAux.equals("NACIONAL")) { tipo = TipoLocalidade.NACIONAL; } 
    else if (tipoAux.equals("ESTADUAL")) { tipo = TipoLocalidade.ESTADUAL; }
    else { tipo = TipoLocalidade.MUNICIPAL;  }
    Localidade localidade = new Localidade(cep, nomeLocalidade, qtdEleitores, tipo); //tem algo de errado aqui
    cadastroLocalidade.cadastra(localidade); }

    //cadastro presidente
        System.out.println("Cadastro de Presidente");
        while (true) {
        System.out.println("Diga o numero: ");
        int numero = entrada.nextInt();
        if (numero == -1) {
        break;
    }
    entrada.nextLine();
    System.out.println("Diga o nome: ");
    String nomePresidente = entrada.nextLine();
    System.out.println("Diga o partido: ");
    System.out.println("Diga a localidade: ");
    System.out.println("Diga o patrimonio: ");
    double patrimonio = entrada.nextDouble();
    Presidente presidente = new Presidente(numero, nomePresidente, patrimonio);
    cadastroCandidato.cadastraPresidente(presidente); }

    //cadastro governador
        System.out.println("Cadastro de Governador");
        while (true) {
        System.out.println("Diga a idade: ");
        int idade = entrada.nextInt();
        if (idade == -1) {
        break;
    }
    entrada.nextLine();
    System.out.println("Diga o nome: ");
    String nomeGovernador = entrada.nextLine();
    System.out.println("Diga a escolaridade: ");
    String escolaridade = entrada.nextLine();
    Governador governador = new Governador(idade, nomeGovernador, escolaridade);
    cadastroCandidato.cadastraGovernador(governador); }

    //cadastro voto
       System.out.println("Cadastro de Votos");
       while (true) {
    System.out.println("Diga o id do voto: ");
    int id = entrada.nextInt();
    if (id == -1) {
        break;
    }
    entrada.nextLine();
    System.out.println("Diga a hora do voto: ");
    String hora = entrada.nextLine();
    System.out.println("Diga o nome do candidato: ");
    String nomeCandidato = entrada.nextLine();
    System.out.println("Diga o CEP da localidade: ");
    String cep = entrada.nextLine();
    System.out.println("Diga o voto: ");
     Voto voto = new Voto(id, hora, candidato, localidade);
    cadastroVoto.cadastra(voto); }

    //consulta candidato por numero
    System.out.println("Consultar candidato por numero: ");
    System.out.println("Digite um numero: ");
    int numero = entrada.nextInt();
    entrada.nextLine();
    cadastroCandidato.consultaCandidato(numero);

    //mostrar candidatos de um partido
    System.out.println("Consultar candidatos de um partido: ");
    System.out.println("Digite o codigo do partido: ");
    int codigoPartido = entrada.nextInt();
    entrada.nextLine();
    cadastroCandidato.consultaCandidatosPartido(codigoPartido);

    //eleito por cep
    //mostrar partido com mais votos
    //mostrar partido com mais eleitos

} 
}

private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        entrada.useLocale(Locale.ENGLISH);
    }

private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
    }

    private void restauraEntrada() {
        entrada = new Scanner(System.in);
    }

    private void restauraSaida() {
        System.setOut(saidaPadrao);
    }

}