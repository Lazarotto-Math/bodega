class naoAlcoolicas extends Bebidas{

    naoAlcoolicas(int id, String nome, int ml, double preco){
        super(id, nome, ml, preco);        
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