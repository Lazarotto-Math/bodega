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
        String statusIdade = this.maiorDeIdade ? "Sim" : "Nao";
        String statusFiado = this.fiado ? "Sim" : "Nao";
        System.out.println("Id: " + this.id + " / Nome: " + this.nome + " / CPF: " + this.CPF + " / Maior de idade: " + statusIdade + " / Pode vender fiado: " + statusFiado);
    }

    public boolean getMaiorDeIdade(){
        return this.maiorDeIdade;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getId(){
        return this.id;
    }
    public String getCPF() {
    return this.CPF;
    }

    public boolean getPodeVenderFiado() {
        return this.fiado;
    }
}