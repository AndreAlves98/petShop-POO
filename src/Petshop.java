import RegraPetShop.Agendamento;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {
    // CORREÇÃO: Adicionado 'final' pois essas variáveis não mudam de referência
    private final Scanner input = new Scanner(System.in);
    private final ArrayList<Agendamento> agenda = new ArrayList<>();

    public static void main(String[] args) {
        Petshop pet = new Petshop();
        pet.exibirMenu();
    }

    public void exibirMenu() {
        // CORREÇÃO: Removido '= 0' (redundante)
        int opcao;

        do {
            for (int i = 0; i < 3; i++) System.out.println();

            System.out.println("#################################################");
            System.out.println("#            NENO BOLACHÃO DA BISLAU            #");
            System.out.println("#              SERVIÇOS DE PETSHOP              #");
            System.out.println("#################################################");
            System.out.println("*===============================================*");
            System.out.println("* MENU PRINCIPAL:                               *");
            System.out.println("*-----------------------------------------------*");
            System.out.println("* [1]  (+) NOVO AGENDAMENTO                     *");
            System.out.println("* [2]  (=) IMPRIMIR COMPROVANTE (Por ID)        *");
            System.out.println("* [3]  (?) CONSULTAR AGENDA GERAL               *");
            System.out.println("* [4]  (*) EDITAR AGENDAMENTO                   *");
            System.out.println("* [5]  (X) SAIR DO SISTEMA                      *");
            System.out.println("*===============================================*");
            System.out.print("  *>>> Digite o número da opção: ");

            // Validação contra letras
            if (input.hasNextInt()) {
                opcao = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                opcao = 0;
            }

            switch (opcao) {
                case 1 -> novoAgendamento();
                case 2 -> imprimirComprovante();
                case 3 -> consultarAgenda();
                case 4 -> editarAgendamento();
                case 5 -> System.out.println("Fechando o PetShop... Até amanhã!");
                default -> System.out.println(">>> Opção inválida! Tente Novamente.");
            }

        } while (opcao != 5);
        input.close();
    }

    public void novoAgendamento() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");

        String tutor;
        while (true) {
            System.out.print("Nome do Tutor: ");
            tutor = input.nextLine();

            if (tutor.matches(".*[^a-zA-Z\\sÀ-ÿ].*")) {
                System.out.println("Erro: O nome não pode conter números e nem caracteres especiais. Tente novamente.");
            } else {
                break;
            }
        }

        String petEst;
        while (true) {
            System.out.print("Nome do Pet: ");
            petEst = input.nextLine();

            if (petEst.matches(".*[^a-zA-Z\\sÀ-ÿ].*")) {
                System.out.println("Erro: O nome não pode conter números e nem caracteres especiais. Tente novamente.");
            } else {
                break;
            }
        }

        // CORREÇÃO: Removido '= ""' (redundante)
        String idade;
        while(true) {
            System.out.print("Idade do Pet: ");
            String entrada = input.nextLine();

            if (entrada.matches("\\d+")) {
                idade = entrada;
                break;
            } else {
                System.out.println("Erro: Digite apenas números para a idade.");
            }
        }

        // CORREÇÃO: Removido '= ""' (redundante)
        String data;
        while (true) {
            System.out.print("Data do Serviço (ex: 25/12/2026): ");
            String dataInput = input.nextLine();

            if (dataInput.matches("\\d{2}/\\d{2}/\\d{4}")) {
                data = dataInput;
                break;
            } else {
                System.out.println("Formato Inválido! Use o formato (ex: 25/12/2026)");
            }
        }

        // CORREÇÃO: Removido '= ""' (redundante)
        String hora;
        while (true) {
            System.out.print("Hora do Serviço (ex: 14:00): ");
            String entrada = input.nextLine();

            if (entrada.matches("\\d{2}:\\d{2}")) {
                hora = entrada;
                break;
            } else {
                System.out.println("Formato Inválido! Use o formato 00:00");
            }
        }

        // MENU DE OPÇÕES
        String servicoSelecionado = "";
        double valorServico = 0.0;
        boolean servicoValido = false;

        while (!servicoValido) {
            System.out.println("\n==================================");
            System.out.println("|       SELECIONE O SERVIÇO      |");
            System.out.println("==================================");
            System.out.println("| [1] Banho Simples (R$ 45,00)   |");
            System.out.println("| [2] Banho + Tosa  (R$ 80,00)   |");
            System.out.println("| [3] Tosa Completa (R$ 120,00)  |");
            System.out.println("| [4] Consulta Vet  (R$ 150,00)  |");
            System.out.println("==================================");
            System.out.print(">>> Escolha uma opção: ");

            int opcaoServico = 0;
            if (input.hasNextInt()) {
                opcaoServico = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
            }

            switch (opcaoServico) {
                case 1 -> {
                    servicoSelecionado = "Banho Simples";
                    valorServico = 45.00;
                    servicoValido = true;
                }
                case 2 -> {
                    servicoSelecionado = "Banho + Tosa";
                    valorServico = 80.00;
                    servicoValido = true;
                }
                case 3 -> {
                    servicoSelecionado = "Tosa Completa";
                    valorServico = 120.00;
                    servicoValido = true;
                }
                case 4 -> {
                    servicoSelecionado = "Consulta Vet";
                    valorServico = 150.00;
                    servicoValido = true;
                }
                default -> System.out.println(">>> Opção inválida! Escolha entre 1 e 4.");
            }
        }

        String pagamentoSelecionado = "";
        boolean pagamentoValido = false;

        while (!pagamentoValido) {
            System.out.println("\n==================================");
            System.out.println("|       FORMA DE PAGAMENTO       |");
            System.out.println("==================================");
            System.out.println("| [1] Pix (Instantâneo)          |");
            System.out.println("| [2] Cartão de Débito           |");
            System.out.println("| [3] Cartão de Crédito          |");
            System.out.println("| [4] Dinheiro                   |");
            System.out.println("==================================");
            System.out.print(">>> Escolha como pagar: ");

            int opcaoPag = 0;
            if(input.hasNextInt()) {
                opcaoPag = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
            }

            switch (opcaoPag) {
                case 1 -> {
                    pagamentoSelecionado = "PIX";
                    pagamentoValido = true;
                }
                case 2 -> {
                    pagamentoSelecionado = "DÉBITO";
                    pagamentoValido = true;
                }
                case 3 -> {
                    pagamentoSelecionado = "CRÉDITO";
                    pagamentoValido = true;
                }
                case 4 -> {
                    pagamentoSelecionado = "DINHEIRO";
                    pagamentoValido = true;
                }
                default -> System.out.println(">>> Opção inválida! Escolha entre 1 e 4.");
            }
        }

        // CONSTRUTOR
        Agendamento novoAgendamento = new Agendamento(tutor, petEst, idade, data, hora, servicoSelecionado, valorServico, pagamentoSelecionado);
        agenda.add(novoAgendamento);

        System.out.print("Agendando");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Error no timer");
        }

        System.out.println("\n\nAgendamento realizado com Sucesso! 🤘");

        int idNovo = agenda.size() - 1;

        // exibir no console
        novoAgendamento.exibirComprovante(idNovo);

        System.out.print("Deseja gerar o PDF do comprovante? (S/N): ");
        String resposta = input.nextLine();

        if(resposta.equalsIgnoreCase("S")) {
            gerarComprovantePDF(novoAgendamento, idNovo);
        }
        System.out.println("Pressione ENTER para voltar ao menu...");
        input.nextLine();
    }

    // IMPRIMIR COMPROVANTE
    public void imprimirComprovante() {
        if (agenda.isEmpty()) {
            System.out.println("\n A agenda está vázia!");
            return;
        }

        System.out.print("\nDigite o ID do agendamento para imprimir: ");
        if (input.hasNextInt()) {
            int id = input.nextInt();
            input.nextLine();

            if (id >= 0 && id < agenda.size()) {
                agenda.get(id).exibirComprovante(id);
            } else {
                System.out.println(">>> Erro: ID não encontrado!");
            }
        } else {
            input.nextLine();
            System.out.println(">>> Digite um número válido.");
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }

    public void consultarAgenda() {
        System.out.println("\n--- AGENDA COMPLETA ---");
        if (agenda.isEmpty()) {
            System.out.println("Nenhum cliente agendado.");
        } else {
            for (int i = 0; i < agenda.size(); i++) {
                Agendamento a = agenda.get(i);
                System.out.printf("ID [%d] - | TUTOR: %s | NOME PET: %s | IDADE: %s Anos | Data: %s | HORA: %s | SERVIÇO: %s \n",
                        i,
                        a.getTutor(),
                        a.getPetEst(),
                        a.getIdade(),
                        a.getdata(),
                        a.gethora(),
                        a.getServico());
            }
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }

    public void editarAgendamento() {
        System.out.println("\nQual ID deseja alterar? ");
        if (!input.hasNextInt()) {
            input.nextLine();
            System.out.println("ID Inválido.");
            return;
        }

        int id = input.nextInt();
        input.nextLine();

        if(id >= 0 && id< agenda.size()) {
            Agendamento a = agenda.get(id);

            System.out.println("--- EDITANDO: " + a.getTutor() + " ---");
            System.out.println("[1] Mudar Data");
            System.out.println("[2] Mudar Horário");
            System.out.print("Escolha uma opção: ");

            int tipoEdicao = input.nextInt();
            input.nextLine();

            switch(tipoEdicao) {
                case 1 -> {
                    System.out.println("Data Atual: " + a.getdata());
                    System.out.print("Nova Data: ");
                    String novaData = input.nextLine();
                    a.setData(novaData);
                }
                case 2 -> {
                    System.out.println("Hora Atual: " + a.gethora());
                    System.out.print("Novo Horário: ");
                    String novaHora = input.nextLine();
                    a.setHora(novaHora);
                }
                default -> System.out.println("Opção inválida.");
            }
            System.out.println(">>> Atualizado com Sucesso!");
        } else {
            System.out.println(">>> ID inválido.");
        }
        System.out.println("Pressione ENTER para continuar...");
        input.nextLine();
    }

    public void gerarComprovantePDF(Agendamento agendamento, int id) {
        Document document = new Document();

        // Nome do arquivo: Ex: "Comprovante_Agendamento_0.pdf"
        String nomeArquivo = "Comprovante_Agendamento_" + id + ".pdf";

        try {
            // cria o arquivo fisico no computador
            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo));

            document.open();

            document.add(new Paragraph("========================================="));
            document.add(new Paragraph("      NENO BOLACHÃO DA BISLAU - PETSHOP"));
            document.add(new Paragraph("========================================="));
            document.add(new Paragraph(" ")); // Pula linha

            document.add(new Paragraph("ID DO AGENDAMENTO: " + id));
            document.add(new Paragraph("TUTOR: " + agendamento.getTutor()));
            document.add(new Paragraph("PET: " + agendamento.getPetEst() + " (" + agendamento.getIdade() + " anos)"));
            document.add(new Paragraph("-----------------------------------------"));
            document.add(new Paragraph("DATA: " + agendamento.getdata()));
            document.add(new Paragraph("HORA: " + agendamento.gethora()));
            document.add(new Paragraph("SERVIÇO: " + agendamento.getServico()));
            document.add(new Paragraph("-----------------------------------------"));
            document.add(new Paragraph("FORMA DE PAGAMENTO: " + agendamento.getFormaPagamento()));
            document.add(new Paragraph("VALOR TOTAL: R$ " + agendamento.getValor()));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Obrigado pela preferência!"));

            System.out.println(">>> PDF Gerado com sucesso: " + nomeArquivo);
        } catch (DocumentException | IOException e) {
            System.err.println("Erro ao gerar PDF: " + e.getMessage());
        } finally {
            if(document.isOpen()) {
                document.close();
            }
        }
    }
}