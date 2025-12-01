public abstract class Bebidas{
    private int id;
    private String nome;
    private int ml;
    private double preco;
    private int qtdEstoque;
  
    public Bebidas(int id, String nome, int ml, double preco){
        this.id = id;
        this.nome = nome;
        this.ml = ml;
        this.preco = preco;
    }

    public Bebidas(){
        this.id = 0;
        this.nome = "Bebida";
        this.ml = 0;
        this.preco = 0.0;
        this.qtdEstoque = 0;
    }

    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getMl(){
        return this.ml;
    }

    public double getPreco(){
        return this.preco;
    }
    
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }

    public void setQtdEstoque(int qtd){
        this.qtdEstoque = qtd;
    }

    public void setId(int id){
        this.id = id;
    }

    // Método para imprimir a bebida
    public void imprimeBebida(){ 
        System.out.println("ID: "+this.getId()+" / Nome: "+this.getNome()+" / ML: "+this.getMl()+" / Preco: "+this.getPreco()+" / Qtd Estoque: "+this.getQtdEstoque());
    } 

    // Implementação de compraBebida: Encontra e atualiza o estoque
    public void compraBebida(Bebidas[] bebidas, int id, int qtd){
        boolean encontrada = false;
        for(int i = 0; i<bebidas.length; i++){
            // Checamos se o objeto existe antes de chamar getId()
            if(bebidas[i] != null && bebidas[i].getId() == id){
                int estq = bebidas[i].getQtdEstoque();
                estq += qtd;
                bebidas[i].setQtdEstoque(estq);
                encontrada = true;
                System.out.println("Compra realizada. Novo estoque: " + bebidas[i].getQtdEstoque() + " unidades.");
                break; // Sai do loop
            }
        }
        if(!encontrada){
            System.out.println("Sinto muito, essa bebida nao foi encontrada, cara...");
        }
    }
    
    // Método abstrato: A lógica de venda (com validação de idade) será implementada nas subclasses
    public abstract void vendeBebida(Bebidas[] bebidas, int idBebida, int qtd, Clientes cliente);
}