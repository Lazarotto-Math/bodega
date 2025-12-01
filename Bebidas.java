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

    public void imprimeBebida(){
        System.out.println("ID: "+this.getId()+" / Nome: "+this.getNome()+" / ML: "+this.getMl()+" / Preco: "+this.getPreco()+" / Qtd Estoque: "+this.getQtdEstoque());
    } 

    public void compraBebida(Bebidas[] bebidas, int id, int qtd){
        int estq;
        for(int i = 0; i<bebidas.length; i++){
            if(bebidas[i].getId()== id){
                estq = bebidas[i].getQtdEstoque();
                estq += qtd;
                bebidas[i].setQtdEstoque(estq);
            }
            else{
                System.out.println("Sinto muito, essa bebida nao foi encontrada, cara...");

            }
        }
    }
    
    public void vendeBebida(Bebidas[] bebidas, int id, int qtd, Clientes cliente){
        //não vamos usar o cliente no Não Alcoolicas, mas por padrão, deixaremos com, já que precisa no alcoolica
        int estq;
        for(int i = 0; i<bebidas.length; i++){
            estq = bebidas[i].getQtdEstoque();
            if(estq >= qtd){
                estq -= qtd;
                bebidas[i].setQtdEstoque(estq);
            }
        } 
    }
}