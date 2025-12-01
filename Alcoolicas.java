class Alcoolicas extends Bebidas{
    private double teorAlcoolico;

    Alcoolicas(int id, String nome, int ml, double preco, double teorAlcoolico){
        super(id, nome, ml, preco);        
        this.teorAlcoolico = teorAlcoolico;
    }


    @Override
    public void vendeBebida(Bebidas[] bebidas, int id, int qtd, Clientes cliente){
        if(cliente.getMaiorDeIdade() == true){
            int estq;
            for(int i = 0; i<bebidas.length; i++){
                if(bebidas[i].getId() == id){
                    estq = bebidas[i].getQtdEstoque();
                    if(estq >= qtd){
                        estq -= qtd;
                        bebidas[i].setQtdEstoque(estq);
                    }
                } else{
                    System.out.println("Nos temos apenas: " + bebidas[i].getQtdEstoque() + " unidade(s) em estoque amigao.");
                }
            } 
        } else{
            System.out.println("Voce ainda e muito novo amigao, volte daqui alguns anos...");
        } 
    }

    @Override
    public void imprimeBebida(){
        System.out.println("ID: "+this.getId()+" / Nome: "+this.getNome()+" / ML: "+this.getMl()+" / Preco: "+this.getPreco()+" / Qtd Estoque: "+this.getQtdEstoque()+" / Teor Alcoolico: "+ this.teorAlcoolico);
    }    
}