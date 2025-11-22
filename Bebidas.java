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

    public void setQtdEstoque(qtd){
        this.qtdEstoque = qtd;
    }

    public abstract void imprimeBebida();
    public abstract void compraBebida(Bebidas[] bebidas, int id, int qtd); //ver se todods esses parametros sao necessarios
    public abstract void vendeBebida(Bebidas[] bebidas, int id, int qtd, Clientes cliente);
}