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
            System.out.println("Bem vindo!\nSelecione uma opcao:\n1.Cadastrar Bebidas\n2.Lista de Bebidas\n3.Comprar Bebida\n4.Vender Bebida\n5.Cadastrar Cliente \n6.Listar Clientes\n0.Sair");
            int opcao = sc.nextInt();
            switch (opcao){
                case 0:
                    System.out.println("Encerrando o sistema...");
                    barFuncionando=0;
                    break;
                case 1: // cadastrar bebidas
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
                    if(alc.equals("S") || alc.equals("s")){
                        System.out.println("Digite o teor alcoolico: ");
                        double teor = sc.nextDouble();
                        Alcoolicas b = new Alcoolicas(0, nome, ml, preco, teor);
                        bodega.cadastraBebida(b);
                    } if(alc.equals("N") || alc.equals("n")){
                        naoAlcoolicas nb = new naoAlcoolicas(0, nome, ml, preco);
                        bodega.cadastraBebida(nb);
                    }
                        System.out.println("Bebida cadastrada com sucesso!");
                        break;
                    
                case 2: //listar bebidas
                    bodega.listaBebidas();
                    break;

                case 3: //comprar bebidas
                    System.out.println("Qual ID da bebida para compra?");
                    int id = sc.nextInt();
                    System.out.println("Quantas Un você quer comprar?");
                    int qtd = sc.nextInt();
                    bodega.bebidas[id].compraBebida(bodega.bebidas, id, qtd);
                    System.out.println("Bebida comprada com sucesso!");
                    break;

                case 4: // Vender bebidas
                    break;

            }

        
        }

        sc.close();
    }
}