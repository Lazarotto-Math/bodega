import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bodega{
    public String nome;
    public String CNPJ;
    public Bebidas[] bebidas = new Bebidas[30];
    public Clientes[] clientes = new Clientes[30];
    private int qtdClientes;
    private int qtdBebidas;

    Bodega(String nome, String CNPJ){
        this.nome=nome;
        this.CNPJ=CNPJ;
    }

    public void cadastraCliente(Clientes c){
        if(qtdClientes < clientes.length){
            c.setId(qtdClientes); 
            clientes[qtdClientes] = c;
            qtdClientes ++;
            System.out.println("Cliente cadastrado com ID: " + c.getId());
        } else{
            System.out.println("A bodega esta lotada de clientes!");
        }
    }

    public void cadastraBebida(Bebidas b){
        if(qtdBebidas < bebidas.length){
            b.setId(qtdBebidas); 
            bebidas[qtdBebidas] = b;
            qtdBebidas ++;
            System.out.println("Bebida cadastrada com ID: " + b.getId());
        } else{
            System.out.println("O estoque esta cheio!");
        }        
    }

    public void listaBebidas(){
        if(qtdBebidas == 0){
            System.out.println("Estoque de bebidas vazio.");
            return;
        }
        System.out.println("--- Listagem do estoque total do Bar (" + qtdBebidas + " itens) ---");
        for(int i = 0; i<qtdBebidas; i++){
            if(bebidas[i] != null) {
                bebidas[i].imprimeBebida();
            }
        }
    }

    public void listaClientes(){
        if(qtdClientes == 0){
            System.out.println("Lista de clientes vazia.");
            return;
        }
        System.out.println("--- Listagem da clientela do Bar (" + qtdClientes + " clientes) ---");
        for(int i = 0; i<qtdClientes; i++){
            if(clientes[i] != null) {
                clientes[i].imprimeCliente();
            }
        }
    }

    public void salvarDados() {
        String arquivoNome = "dados_bodega.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoNome))) {
            
            // 1. Salva os dados da própria Bodega
            writer.write(this.nome + ";" + this.CNPJ);
            writer.newLine();

            // 2. Salva os Clientes
            writer.write(String.valueOf(this.qtdClientes));
            writer.newLine();

            for (int i = 0; i < this.qtdClientes; i++) {
                Clientes c = this.clientes[i];
                if (c != null) {
                    String linhaCliente = c.getId() + ";" + 
                                        c.getNome() + ";" + 
                                        c.getCPF() + ";" + 
                                        c.getMaiorDeIdade() + ";" + 
                                        c.getPodeVenderFiado();
                    writer.write(linhaCliente);
                    writer.newLine();
                }
            }

            // 3. Salva as Bebidas
            writer.write(String.valueOf(this.qtdBebidas));
            writer.newLine();

            for (int i = 0; i < this.qtdBebidas; i++) {
                Bebidas b = this.bebidas[i];
                // Formato: TIPO;ID;Nome;ML;Preco;Estoque
                if (b != null) {
                    if (b instanceof Alcoolicas) {
                        writer.write("ALC;" + 
                                    b.getId() + ";" + 
                                    b.getNome() + ";" + 
                                    b.getMl() + ";" + 
                                    b.getPreco() + ";" + 
                                    b.getQtdEstoque() + ";" + 
                                    ((Alcoolicas) b).getTeorAlcoolico());
                    } else {
                        writer.write("NAO;" + 
                                    b.getId() + ";" + 
                                    b.getNome() + ";" + 
                                    b.getMl() + ";" + 
                                    b.getPreco() + ";" + 
                                    b.getQtdEstoque());
                    }
                    writer.newLine();
                }
            }

            System.out.println("Dados salvos com sucesso no arquivo '" + arquivoNome + "'!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void sair(){
    }

    public int getQtdBebidas(){
        return qtdBebidas;    
    }

    public int getQtdClientes(){
        return qtdClientes;    
    }
}