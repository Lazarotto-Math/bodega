public abstract class Bebidas{
    private int id;
    private String nome;
    private int ml;
    private double preco;
    private int qtdEstoque;
  
    public void bebida(int id, String nome, int ml, double preco, int qtdEstoque){
        this.id = id;
        this.nome = nome;
        this.ml = ml;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public void imprimeBebida(){
        System.out.println("ID: "+this.id+" / Nome: "+this.nome+" / ML: "+this.ml+" / Preco: "+this.preco+" / Qtd Estoque: "+this.qtdEstoque);
    }

    public void compraBebida(Bebidas[] bebidas, int id, int qtd){
        for(int i = 0; i<bebidas.length; i++){
            if(bebidas[i].id == this.id)
        }
    }

    public void vendeBebida(Bebidas[] bebidas, int id, int qtd, Clientes cliente){
        for(int i = 0; i<bebidas.length; i++){
            if(bebidas[i].id; )        
        
    }
    
    
}