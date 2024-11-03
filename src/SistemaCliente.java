import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCliente {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Sistema de Gerenciamento de Clientes ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Buscar Cliente por ID");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome o enter

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void cadastrarCliente() {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consome o enter
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(id, nome, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void atualizarCliente() {
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consome o enter

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            System.out.print("Novo nome (deixe vazio para manter o atual): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) cliente.setNome(nome);

            System.out.print("Novo e-mail (deixe vazio para manter o atual): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) cliente.setEmail(email);

            System.out.print("Novo telefone (deixe vazio para manter o atual): ");
            String telefone = scanner.nextLine();
            if (!telefone.isEmpty()) cliente.setTelefone(telefone);

            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removerCliente() {
        System.out.print("Digite o ID do cliente que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consome o enter

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void buscarCliente() {
        System.out.print("Digite o ID do cliente que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consome o enter

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Cliente encontrarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}