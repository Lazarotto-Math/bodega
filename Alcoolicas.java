class Alcoolicas extends Bebidas{
    private double teorAlcoolico;

    Alcoolicas(int id, String nome, int ml, double preco, double teorAlcoolico){
        super(id, nome, ml, preco);        
        this.teorAlcoolico = teorAlcoolico;
    }


    @Override
    public void vendeBebida(Bebidas[] bebidas, int idBebida, int qtd, Clientes cliente){
        // 2.3.1. [cite_start]Alcoólicas: só podem ser vendidas para clientes com idade igual ou superior a 18 anos. [cite: 30]
        if(cliente.getMaiorDeIdade() == true){
            
            // Busca a bebida pelo ID
            boolean vendida = false;
            for(int i = 0; i<bebidas.length; i++){
                // Checa se a posição não é nula e se o ID corresponde
                if(bebidas[i] != null && bebidas[i].getId() == idBebida){
                    int estq = bebidas[i].getQtdEstoque();
                    
                    if(estq >= qtd){
                        estq -= qtd;
                        bebidas[i].setQtdEstoque(estq);
                        System.out.println("Venda de bebida alcoolica realizada com sucesso para o(a) " + cliente.getNome() + "!");
                        System.out.println("Novo estoque da bebida ID " + idBebida + ": " + bebidas[i].getQtdEstoque() + " unidades.");
                        vendida = true;
                        break; // Sai do loop após a venda
                    } else{
                        System.out.println("Nos temos apenas: " + bebidas[i].getQtdEstoque() + " unidade(s) em estoque amigao.");
                        vendida = true;
                        break; // Sai do loop após a verificação de estoque
                    }
                }
            }
            if(!vendida){
                System.out.println("Bebida com ID " + idBebida + " nao encontrada.");
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