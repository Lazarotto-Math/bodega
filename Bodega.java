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
            c.setId(qtdClientes); 
            clientes[qtdClientes] = c;
            qtdClientes ++;
            System.out.println("Cliente cadastrado com ID: " + c.getId());
        } else{
            System.out.println("A bodega esta lotada de clientes!");
        }
    }

    public void cadastraBebida(Bebidas b){
        if(qtdBebidas < bebidas.length){
            b.setId(qtdBebidas); 
            bebidas[qtdBebidas] = b;
            qtdBebidas ++;
            System.out.println("Bebida cadastrada com ID: " + b.getId());
        } else{
            System.out.println("O estoque esta cheio!");
        }        
    }

    public void listaBebidas(){
        if(qtdBebidas == 0){
            System.out.println("Estoque de bebidas vazio.");
            return;
        }
        System.out.println("--- Listagem do estoque total do Bar (" + qtdBebidas + " itens) ---");
        for(int i = 0; i<qtdBebidas; i++){
            if(bebidas[i] != null) {
                bebidas[i].imprimeBebida();
            }
        }
    }

    public void listaClientes(){
        if(qtdClientes == 0){
            System.out.println("Lista de clientes vazia.");
            return;
        }
        System.out.println("--- Listagem da clientela do Bar (" + qtdClientes + " clientes) ---");
        for(int i = 0; i<qtdClientes; i++){
            if(clientes[i] != null) {
                clientes[i].imprimeCliente();
            }
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