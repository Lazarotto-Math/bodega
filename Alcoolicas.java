class Alcoolicas extends Bebidas{
    private double teorAlcoolico;

    Alcoolicas(int id, String nome, int ml, double preco, double teorAlcoolico){
        super(id, nome, ml, preco);        
        this.teorAlcoolico = teorAlcoolico;
    }


    @Override
    public void vendeBebida(Bebidas[] bebidas, int idBebida, int qtd, Clientes cliente){
        // só pode vender para maiores de 18 anos
        if(cliente.getMaiorDeIdade() == true){
            
            boolean vendida = false;
            for(int i = 0; i<bebidas.length; i++){
                if(bebidas[i] != null && bebidas[i].getId() == idBebida){
                    int estq = bebidas[i].getQtdEstoque();
                    
                    if(estq >= qtd){
                        estq -= qtd;
                        bebidas[i].setQtdEstoque(estq);
                        System.out.println("Venda de bebida alcoolica realizada com sucesso para o(a) " + cliente.getNome() + "!");
                        System.out.println("Novo estoque da bebida ID " + idBebida + ": " + bebidas[i].getQtdEstoque() + " unidades.");
                        vendida = true;
                        break;
                    } else{
                        System.out.println("Nos temos apenas: " + bebidas[i].getQtdEstoque() + " unidade(s) em estoque amigao.");
                        vendida = true;
                        break;
                    }
                }
            }
            if(!vendida){
                System.out.println("Bebida com ID " + idBebida + " nao encontrada.");
            }
        } else{
            System.out.println("Cliente muito novo, volte daqui alguns anos...");
        } 
    }

    @Override
    public void imprimeBebida(){
        System.out.println("ID: "+this.getId()+" / Nome: "+this.getNome()+" / ML: "+this.getMl()+" / Preco: "+this.getPreco()+" / Qtd Estoque: "+this.getQtdEstoque()+" / Teor Alcoolico: "+ this.teorAlcoolico);
    }    

    public double getTeorAlcoolico() {
    return this.teorAlcoolico;
    }
}
