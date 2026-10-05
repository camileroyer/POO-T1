package aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import dados.CadastroLocalidades;
import dados.CadastroVotos;

public class AppACMEPolling{
    private Scanner entrada;
    private PrintStream saidaPadrao = System.out;  
    private final String nomeArquivoEntrada = "pollingin.txt";  // entrada de dados
    private final String nomeArquivoSaida = "pollingout.txt";  // saida de dados
    private CadastroPartidos cadastroPartido;
    private CadastroLocalidades cadastroLocalidade;
    private CadastroVotos cadastroVoto;

    public AppACMEPolling() {
        redirecionaEntrada();
        redirecionaSaida();
        entrada = new Scanner(System.in);
        cadastroPartido = new CadastroPartidos();
        cadastroLocalidade = new CadastroLocalidades();
    }

    public void executa() {
        System.out.println("ACMEPolling -- Trabalho 1 de POO");

        do {
            System.out.println("Cadastro de Partidos");
            System.out.println("Diga o codigo(numero) do partido: ");
            int codigo = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Diga o nome: ");
            String nomePartido = entrada.nextLine();
            Partido partido = new Partido(codigo, nomePartido);
            cadastroPartido.cadastra(partido);
        } while (codigo != -1);

        do {
            System.out.println("Cadastro de Localidades");
            System.out.println("Diga o CEP: ");
            int cep = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Diga o nome: ");
            String nomeLocalidade = entrada.nextLine();
            System.out.println("Quantidade de eleitores: ");
            long qtdEleitores = entrada.nextLong();
            Localidade localidade = new Localidade(cep, nomeLocalidade, qtdEleitores);
            cadastroLocalidade.cadastra(localidade);
        } while (cep != -1);

        //cadastra candidato presidencia

        //cadastra candidato governador

        do {
            
        } while (id != -1);
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