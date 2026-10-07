package aplicacao;

import dados.*; //puxa tudo
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class AppACMEPolling{
    private Scanner entrada;
    private PrintStream saidaPadrao = System.out;
    private final String nomeArquivoEntrada = "pollingin.txt"; //entrada de dados
    private final String nomeArquivoSaida = "pollingout.txt"; //saida de dados
    private CadastroPartidos cadastroPartido;
    private CadastroCandidato cadastroCandidato;
    private CadastroLocalidades cadastroLocalidade;
    private CadastroVotos cadastroVoto;

    public AppACMEPolling() {
        redirecionaEntrada();
        redirecionaSaida();
        cadastroPartido = new CadastroPartidos();
        cadastroLocalidade = new CadastroLocalidades();
        cadastroCandidato = new CadastroCandidato();
        cadastroVoto = new CadastroVotos();
    }

    public void executa() {
        //vou ter que tirar esses sysout

        // cadastrao partidos
        while (true) {
            int codigo = entrada.nextInt();
            entrada.nextLine();
            if (codigo == -1) { break; }
            String nomePartido = entrada.nextLine();
            Partido partido = new Partido(codigo, nomePartido);
            if (cadastroPartido.busca(codigo) != null) {
                System.out.println("1: ERRO - partido repetido.");
            } else {
                cadastroPartido.cadastra(partido);
                System.out.println("1: " + partido.getDescricao());
            }
        }

        // cadastro localidades
        while (true) {
            String cep = entrada.nextLine();
            if (cep.equals("-1")) { break; }
            String nomeLocalidade = entrada.nextLine();
            long qtdEleitores = entrada.nextLong();
            entrada.nextLine();
            String tipoAux = entrada.nextLine(); //tapa buraco, tem que pensar em algo melhor
            TipoLocalidade tipo = null;
            if (tipoAux.equals("NACIONAL")) { tipo = TipoLocalidade.NACIONAL; }
            else if (tipoAux.equals("ESTADUAL")) { tipo = TipoLocalidade.ESTADUAL; }
            else if (tipoAux.equals("MUNICIPAL")) { tipo = TipoLocalidade.MUNICIPAL; }

            if (cadastroLocalidade.busca(cep) != null) {
                System.out.println("2: ERRO - localidade repetida.");
            } else if (tipo == null) {
                System.out.println("2: ERRO - tipo de localidade incorreto.");
            } else {
                Localidade localidade = new Localidade(cep, nomeLocalidade, qtdEleitores, tipo);
                cadastroLocalidade.cadastra(localidade);
                System.out.println("2: " + localidade.getDescricao());
            }
        }

        // cadastro presidente
        while (true) {
            int numero = entrada.nextInt();
            entrada.nextLine();
            if (numero == -1) { break; }
            String nomePresidente = entrada.nextLine();
            int codigoPartido = entrada.nextInt();
            entrada.nextLine();
            String cep = entrada.nextLine();
            double patrimonio = Double.parseDouble(entrada.nextLine());
            Partido partido = cadastroPartido.busca(codigoPartido);
            Localidade localidade = cadastroLocalidade.busca(cep);

            if (cadastroCandidato.existeNumero(numero)) {
                System.out.println("3: ERRO - candidato repetido."); }
            else if (partido == null) {
                System.out.println("3: ERRO - partido incorreto."); }
            else if (localidade == null) {
                System.out.println("3: ERRO - localidade incorreta."); }
            else {
                Presidente presidente = new Presidente(numero, nomePresidente, partido, localidade, patrimonio);
                cadastroCandidato.cadastraPresidente(presidente);
                System.out.println("3: " + presidente.getDescricao());
            }
        }

        // cadastro governador
        while (true) {
            int numero = entrada.nextInt();
            entrada.nextLine();
            if (numero == -1) break;
            String nomeGovernador = entrada.nextLine();
            int codigoPartido = entrada.nextInt();
            entrada.nextLine();
            String cep = entrada.nextLine();
            String escolaridade = entrada.nextLine();
            Partido partido = cadastroPartido.busca(codigoPartido);
            Localidade localidade = cadastroLocalidade.busca(cep);

            if (cadastroCandidato.existeNumero(numero)) {
                System.out.println("4: ERRO - candidato repetido."); }
            else if (partido == null) { 
                System.out.println("4: ERRO - partido incorreto."); }
            else if (localidade == null){
                System.out.println("4: ERRO - localidade incorreta."); }
            else {
                Governador governador = new Governador(numero, nomeGovernador, partido, localidade, escolaridade);
                cadastroCandidato.cadastraGovernador(governador);
                System.out.println("4: " + governador.getDescricao());
            }
        }

        // cadastro voto
        while (true) {
            int id = entrada.nextInt();
            entrada.nextLine();
            if (id == -1) { break; }
            int hora = entrada.nextInt();
            entrada.nextLine();
            int numeroCandidato = entrada.nextInt();
            entrada.nextLine();
            String cep = entrada.nextLine();
            Candidato candidato = cadastroCandidato.busca(numeroCandidato);
            Localidade localidade = cadastroLocalidade.busca(cep);

            if (cadastroVoto.existeId(id)) {
                System.out.println("5: ERRO - id repetido."); }
            else if (hora < 8 && hora > 17) {
                System.out.println("5: ERRO - hora incorreta."); }
            else if (candidato == null) {
                System.out.println("5: ERRO - candidato incorreto."); }
            else if (localidade == null) {
                System.out.println("5: ERRO - localidade incorreta."); }
            else if (!candidato.getLocalidade().getCep().equals(localidade.getCep())) {
                System.out.println("5: ERRO - localidade do candidato incorreta."); }
            else {
                Voto voto = new Voto(id, hora, candidato, localidade);
                cadastroVoto.cadastra(voto);
                System.out.println("5: " + voto.getDescricao());
            }
        }

        // consulta candidato
        int numero = entrada.nextInt();
        entrada.nextLine();
        cadastroCandidato.consultaCandidato(numero);

        // candidatos de um partido
        int codigoPartido = entrada.nextInt();
        entrada.nextLine();
        if (cadastroPartido.busca(codigoPartido) == null) {
            System.out.println("7: ERRO - partido inexistente."); }
        else {
            cadastroCandidato.consultaCandidatosPartido(codigoPartido); }

        // eleito por cep
        String cep = entrada.nextLine();
        Localidade localidade = cadastroLocalidade.busca(cep);
        if (localidade == null) {
            System.out.println("8: ERRO - localidade inexistente.");
        } else {
            boolean temCandidato = false;
            for (Presidente p : cadastroCandidato.getPresidentes()){
                if (p.getLocalidade().getCep().equals(cep)) {
                    temCandidato = true; } }
            for (Governador g : cadastroCandidato.getGovernadores()){
             if (g.getLocalidade().getCep().equals(cep)) {
                temCandidato = true; } }
            Candidato eleito = cadastroCandidato.mostraEleito(cep, cadastroVoto);
            if (!temCandidato){
                 System.out.println("8: nenhum candidato cadastrado."); }
            else if (eleito == null) {
                System.out.println("8: nenhum candidato eleito."); }
            else {
                System.out.println("8: " + eleito.getNumero() + " - " + eleito.getNome() + " - " + cadastroVoto.contaVotos(eleito)); }
        }

        // partido com mais votos
        if (cadastroPartido.getPartidos().isEmpty()) {
            System.out.println("9: ERRO - nenhum partido cadastrado.");
        } else {
            Partido maior = null;
            int maiorVotos = 0;
            for (Partido p : cadastroPartido.getPartidos()) {
                int votos = cadastroVoto.contaVotos(p);
                if (votos > maiorVotos) {
                    maiorVotos = votos;
                    maior = p;
                } }
            if (maior == null) {
                System.out.println("9: nenhum partido com votos."); }
            else {
                System.out.println("9: " + maior.getDescricao() + " - " + maiorVotos); }
        }

        // partido com mais eleitos
        if (cadastroPartido.getPartidos().isEmpty()) {
            System.out.println("10: ERRO - nenhum partido cadastrado.");
        } else {
            Partido maior = null;
            int maiorEleitos = 0;
            for (Partido p : cadastroPartido.getPartidos()) {
                int eleitos = 0;
                for (Localidade l : cadastroLocalidade.getLocalidades()) {
                    Candidato eleito = cadastroCandidato.mostraEleito(l.getCep(), cadastroVoto);
                    if (eleito != null && eleito.getPartido().getCodigo() == p.getCodigo()) {
                        eleitos++; }
                }
                if (eleitos > maiorEleitos) {
                    maiorEleitos = eleitos;
                    maior = p;
                }
            }
            if (maior == null) {
                System.out.println("10: nenhum partido com eleitos."); }
            else { 
                System.out.println("10: " + maior.getDescricao() + " - " + maiorEleitos); }
        }

        restauraEntrada();
        restauraSaida();
    }

    //codigo do sor
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

    private void restauraEntrada() { entrada = new Scanner(System.in); }
    private void restauraSaida() { System.setOut(saidaPadrao); }
}
