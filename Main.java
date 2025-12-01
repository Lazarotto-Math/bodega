import java.util.Scanner;

public class Main{
    public static void main(String args[]){

        //criação da bodega
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da sua bodega: ");
        String nomeBodega = sc.nextLine();
        System.out.println("Digite o CNPJ da sua bodega: ");
        String cnpj = sc.nextLine();
        Bodega bodega = new Bodega(nomeBodega, cnpj);

        //menu de funcionamento
        int barFuncionando = 1;
        while(barFuncionando>0){   
            System.out.println("\nBem vindo!\nSelecione uma opcao:\n1.Cadastrar Bebidas\n2.Lista de Bebidas\n3.Comprar Bebida\n4.Vender Bebida\n5.Cadastrar Cliente \n6.Listar Clientes\n0.Sair");
            int opcao = sc.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Encerrando o sistema...");
                    barFuncionando=0;
                    break;

                case 1: // cadastrar bebidas
                    System.out.println("--- Cadastro de Bebida ---");
                    System.out.println("Digite o nome da Bebida: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println("Digite quantos ML essa bebida possui: ");
                    int ml = sc.nextInt();
                    System.out.println("Digite o preco da bebida: ");
                    double preco = sc.nextDouble();
                    System.out.println("A bebida e alcoolica? (S/N) ");
                    sc.nextLine();
                    String alc = sc.nextLine();
                    
                    if(alc.equalsIgnoreCase("S")){
                        System.out.println("Digite o teor alcoolico: ");
                        double teor = sc.nextDouble();
                        Alcoolicas b = new Alcoolicas(0, nome, ml, preco, teor);
                        bodega.cadastraBebida(b);
                    } else if(alc.equalsIgnoreCase("N")){
                        naoAlcoolicas nb = new naoAlcoolicas(0, nome, ml, preco); 
                        bodega.cadastraBebida(nb);
                    } else {
                        System.out.println("Opcao invalida. Bebida nao cadastrada.");
                        break;
                    }
                    System.out.println("Bebida cadastrada com sucesso!");
                    break;
                    
                case 2: //listar bebidas
                    bodega.listaBebidas();
                    break;

                case 3: //comprar bebidas
                    System.out.println("--- Compra de Bebida ---");
                    bodega.listaBebidas();
                    System.out.println("Qual ID da bebida para compra?");
                    int idCompra = sc.nextInt();
                    System.out.println("Quantas Un você quer comprar?");
                    int qtdCompra = sc.nextInt();
                    
                    if (idCompra >= 0 && idCompra < bodega.getQtdBebidas() && bodega.bebidas[idCompra] != null) {
                        bodega.bebidas[idCompra].compraBebida(bodega.bebidas, idCompra, qtdCompra);
                    } else {
                        System.out.println("ID de bebida invalido. Tente novamente.");
                    }
                    break;

                case 4: // Vender bebidas
                    System.out.println("--- Venda de Bebida ---");
                    
                    if (bodega.getQtdBebidas() == 0) {
                        System.out.println("Nao ha bebidas cadastradas para venda.");
                        break;
                    }
                    
                    bodega.listaBebidas();
                    System.out.println("Qual ID da bebida para venda?");
                    int idVenda = sc.nextInt();
                    
                    if (idVenda < 0 || idVenda >= bodega.getQtdBebidas() || bodega.bebidas[idVenda] == null) {
                        System.out.println("ID de bebida invalido. Tente novamente.");
                        break;
                    }
                    
                    System.out.println("Quantas Un você quer vender?");
                    int qtdVenda = sc.nextInt();

                    if (bodega.getQtdClientes() == 0) {
                        System.out.println("Nao ha clientes cadastrados. Cadastre um cliente primeiro (Opcao 5).");
                        break;
                    }
                    
                    bodega.listaClientes();
                    System.out.println("Qual ID do cliente para a venda?");
                    int idCliente = sc.nextInt();
                    
                    if (idCliente < 0 || idCliente >= bodega.getQtdClientes() || bodega.clientes[idCliente] == null) {
                        System.out.println("ID de cliente invalido. Tente novamente.");
                        break;
                    }
                    
                    Clientes clienteSelecionado = bodega.clientes[idCliente];
                    bodega.bebidas[idVenda].vendeBebida(bodega.bebidas, idVenda, qtdVenda, clienteSelecionado);
                    break;

                case 5: // Cadastrar cliente
                    System.out.println("--- Cadastro de Cliente ---");
                    System.out.println("Digite o nome do Cliente: ");
                    sc.nextLine();
                    String nomeCliente = sc.nextLine();
                    System.out.println("Digite o CPF do Cliente: ");
                    String cpfCliente = sc.nextLine();
                    System.out.println("Cliente e maior de idade? (S/N) ");
                    String maiorStr = sc.nextLine();
                    boolean maior = maiorStr.equalsIgnoreCase("S");
                    System.out.println("Pode vender fiado? (S/N) ");
                    String fiadoStr = sc.nextLine();
                    boolean fiado = fiadoStr.equalsIgnoreCase("S");

                    Clientes novoCliente = new Clientes(0, nomeCliente, cpfCliente, maior, fiado);
                    bodega.cadastraCliente(novoCliente);
                    break;

                case 6: // Listar clientes
                    bodega.listaClientes();
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        
        }

        sc.close();
    }
}