import java.util.Scanner;
import java.util.Date;

public class PetshopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Agendar serviço");
            System.out.println("2. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            if (opcao == 1) {
                System.out.print("Nome do animal: ");
                String nomeAnimal = scanner.nextLine();

                System.out.print("Espécie: ");
                String especieAnimal = scanner.nextLine();

                System.out.print("Raça: ");
                String racaAnimal = scanner.nextLine();

                System.out.print("Data de Nascimento: ");
                String dataNascimentoAnimal = scanner.nextLine();

                System.out.print("Nome do Proprietário: ");
                String proprietarioAnimal = scanner.nextLine();

                Animal animal = new Animal(nomeAnimal, especieAnimal, racaAnimal, dataNascimentoAnimal, proprietarioAnimal);

                String horarioAgendamento;
                Date dataDesejada;

                while (true) {
                    System.out.print("Data do agendamento (dd/MM/yyyy): ");
                    String dataAgendamento = scanner.nextLine();

                    System.out.print("Horário do agendamento (HH:mm): ");
                    horarioAgendamento = scanner.nextLine();

                    dataDesejada = new Date(dataAgendamento); // Substitua pela data desejada

                    boolean horarioDisponivel = Agenda.verificarDisponibilidade(dataDesejada, horarioAgendamento);

                    if (horarioDisponivel) {
                        break; // Saia do loop interno de seleção de horário
                    } else {
                        System.out.println("Horário já foi ocupado por outra reserva. Escolha outro horário.");
                    }
                }

                System.out.println("Escolha o serviço:");
                System.out.println("1. Banho (R$25.0)");
                System.out.println("2. Tosa (R$30.0)");
                System.out.println("3. Consulta Veterinária (R$50.0)");

                int escolhaServico = scanner.nextInt();
                Servico servicoDesejado;

                switch (escolhaServico) {
                    case 1:
                        servicoDesejado = new Banho();
                        break;
                    case 2:
                        servicoDesejado = new Tosa();
                        break;
                    case 3:
                        servicoDesejado = new ConsultaVeterinaria();
                        break;
                    default:
                        System.out.println("Opção inválida. Agendamento cancelado.");
                        continue;
                }

                Agenda novoAgendamento = new Agenda(animal, servicoDesejado, dataDesejada, horarioAgendamento);

                if (Agenda.verificarDisponibilidade(dataDesejada, horarioAgendamento)) {
                    Agenda.adicionarAgendamento(novoAgendamento);
                    System.out.println("Agendamento realizado com sucesso!");
                } else {
                    System.out.println("Horário já foi ocupado por outra reserva. Agendamento cancelado.");
                }
            } else if (opcao == 2) {
                System.out.println("Saindo do sistema.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
