public class BodegaDoNizo{
    public String nome;
    public String CNPJ;
    public Bebidas[] bebidas = new Bebidas[30];
    public Clientes[] clientes = new Clientes[30];
    private qtdClientes;
    private qtdBebidas;

    public void cadastraCliente(Clientes c){
        if(qtdClientes < clientes.length){
            clientes[qtdClientes] = c;
            qtdClientes ++;
        } else{
            System.out.println("A bodega esta lotada!");
        }
    }

    public void cadastraBebida(Bebidas b){
        if(qtdBebidas < bebidas.length){
            bebidas[qtdBebidas] = b;
            qtdBebidas ++;
        } else{
            System.out.println("O estoque esta cheio!");
        }        
    }

    public void listaBebidas(){
        System.out.println("Listagem do estoque total do Bar do Nizo Fissura: ")
        for(int i = 0; i<bebidas.length; i++){
            System.out.printf(i+1);
            System.out.printf(" - ");
            bebidas[i].imprimeBebida();
        }
    }

    public void listaClientes(){
        System.out.println("Listagem da clientela do Bar do Nizo Fissura: ")
        for(int i = 0; i<clientes.length; i++){
            System.out.printf(i+1);
            System.out.printf(" - ");
            clientes[i].imprimeCliente();
        }
    }

    public void salvarDados(){
        
    }

    public void sair(){
    }
}