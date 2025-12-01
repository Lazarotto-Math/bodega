class naoAlcoolicas extends Bebidas{

    naoAlcoolicas(int id, String nome, int ml, double preco){
        super(id, nome, ml, preco);        
    }
  
    @Override
    public void vendeBebida(Bebidas[] bebidas, int idBebida, int qtd, Clientes cliente){

        boolean vendida = false;
        for(int i = 0; i<bebidas.length; i++){
            if(bebidas[i] != null && bebidas[i].getId() == idBebida){
                int estq = bebidas[i].getQtdEstoque();
                
                if(estq >= qtd){
                    estq -= qtd;
                    bebidas[i].setQtdEstoque(estq);
                    System.out.println("Venda de bebida nao-alcoolica realizada com sucesso para o(a) " + cliente.getNome() + "!");
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
    }
}