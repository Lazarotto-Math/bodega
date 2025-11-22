private class Alcoolicas extends Bebidas{
    double teorAlcoolico;


    public void compraBebida(Bebidas[] bebidas, int id, int qtd){ //ver se todods esses parametros sao necessarios
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
        if(cliente.getMaiorDeIdade() == true){
            for(int i = 0; i<bebidas.length; i++){ //incluir questao de ser maior de idade p alcoolica
                if(bebidas[i].getId() == id){
                    estq = 
                    if(bebidas[i].qtdEstoque >= qtd){
                        bebidas[i].qtdEstoque -= qtd;
                    }
                } else{
                    System.out.println("Nos temos apenas: " + bebidas[i].getQtdEstoque() + " unidade(s) em estoque amigao.")
                }
            } 
        } else{
            System.out.println("Voce ainda e muito novo amigao, volte daqui alguns anos...");
        } 
    }
    
    public void imprimeBebida(){
        System.out.println("ID: "+this.id+" / Nome: "+this.nome+" / ML: "+this.ml+" / Preco: "+this.preco+" / Qtd Estoque: "+this.qtdEstoque+" / Teor Alcoolico: "+ this.teorAlcoolico);
    }    
}