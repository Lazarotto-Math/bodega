public class Bodega{
    public String nome;
    public String CNPJ;
    public Bebidas[] bebidas = new Bebidas[30];
    public Clientes[] clientes = new Clientes[30];
    private int qtdClientes;
    private int qtdBebidas;

    Bodega(String nome, String CNPJ){
        this.nome=nome;
        this.CNPJ=CNPJ;
    }

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
            b.setId(qtdBebidas+1);
            bebidas[qtdBebidas] = b;
            qtdBebidas ++;
        } else{
            System.out.println("O estoque esta cheio!");
        }        
    }

    public void listaBebidas(){
        System.out.println("Listagem do estoque total do Bar: ");
        for(int i = 0; i<qtdBebidas; i++){
            bebidas[i].imprimeBebida();
        }
    }

    public void listaClientes(){
        System.out.println("Listagem da clientela do Bar: ");
        for(int i = 0; i<qtdClientes; i++){
            clientes[i].imprimeCliente();
        }
    }

    public void salvarDados(){
        
    }

    public void sair(){
    }

    public int getQtdBebidas(){
        return qtdBebidas;    
    }

    public int getQtdClientes(){
        return qtdClientes;    
    }
}