import RegraPetShop.Agendamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Agendamento> agenda = new ArrayList<>();

    public static void main(String[] args) {
        Petshop pet = new Petshop();
        pet.exibirMenu();
    }


    public void exibirMenu() {
        int opcao = 0;

        do {
            for (int i = 0; i < 3; i++) System.out.println();

            System.out.println("#################################################");
            System.out.println("#            NENO BOLACHÃO DA BISLAU            #");
            System.out.println("#              SERVIÇOS DE PETSHOP              #");
            System.out.println("#################################################");
            //  System.out.printf("* TOTAL AGENDADO: %-17d*\n"                       );
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

            //Validação contra letras
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

        System.out.print("Nome do Tutor: ");
        String tutor = input.nextLine();

        System.out.print("Nome do Pet: ");
        String petEst = input.nextLine();


        System.out.print("Idade do Pet: ");
        String idade = "";

        if (input.hasNextInt()) {
            int valorIdade = input.nextInt();
            input.nextLine();
            idade = String.valueOf(valorIdade);
        } else {
            input.nextLine();
        }


        String data = "";
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

        String hora = "";
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

        //MENU DE OPÇÕES

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



        //CONSTRUTUTOR
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
        novoAgendamento.exibirComprovante(idNovo);

        System.out.println("Pressione ENTER para voltar ao menu...");
        input.nextLine();
    }



    //IMPRIMIR COMPROVANTE
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



        //aqui começa
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

    //Fim da Classe
}