class Clientes {
    private int id;
    private String nome;
    private String CPF;
    private boolean maiorDeIdade;
    private boolean fiado;

    Clientes(int id, String nome, String CPF, boolean maiorDeIdade, boolean fiado){
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.maiorDeIdade = maiorDeIdade;
        this.fiado = fiado;
    }

    public void imprimeCliente(){
        System.out.println("Id: " + this.id + " / Nome: " + this.nome + " / CPF: " + this.CPF + " / Maior de idade: " + this.maiorDeIdade + " / Pode vender fiado: " + this.fiado);
    }

    public boolean getMaiorDeIdade(){
        return this.maiorDeIdade;
    }
}