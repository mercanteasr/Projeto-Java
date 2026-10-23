import java.util.ArrayList;

public class Controle {
    // Inicialização de Objeto
    private Leitura l = new Leitura();

    private ArrayList<ItemFarmacia> itens;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;

    // Construtor
    public Controle(){
        this.itens = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    // Metodo auxiliar de cadItem
    public void preencherComum(ItemFarmacia item){
        item.setNome(l.entDados("Nome do Item: "));
        item.setMarca(l.entDados("Marca Item: "));
        item.setPreco(Double.parseDouble(l.entDados("Preço (ex: 5.99): ")));
        item.setQtdEstoque(Integer.parseInt(l.entDados("Quantidade Estoque Item: ")));
    }
    // Metodos
    public void cadItem(){
        Remedio rem;
        Controlado con;
        Cosmetico cos;
        Higiene hig;
        AparelhoMedico apm;

        System.out.println("\n== MENU DE ESCOLHA DE ITEM == ");
        System.out.println("1) Remedio");
        System.out.println("2) Remedio Controlado");
        System.out.println("3) Cosmetico");
        System.out.println("4) Higiene");
        System.out.println("5) Aparelho Medico");
        int op = Integer.parseInt(l.entDados("Opção: "));
        switch (op){
            case 1:
                rem = new Remedio();
                System.out.println("== CADASTRO REMEDIO ==");
                preencherComum(rem);
                rem.setDosagem(l.entDados("Dosagem (ex: 500mg): "));
                rem.setPrincipioAtivo(l.entDados("Principio Ativo: "));
                itens.add(rem);
                break;
            case 2:
                con = new Controlado();
                System.out.println("== CADASTRO REMEDIO CONTROLADO ==");
                preencherComum(con);
                con.setDosagem(l.entDados("Dosagem (ex: 500mg): "));
                con.setPrincipioAtivo(l.entDados("Principio Ativo: "));
                con.setTarja(l.entDados("Tarja (ex: vermelha/preta): "));
                itens.add(con);
                break;
            case 3:
                cos = new Cosmetico();
                System.out.println("== CADASTRO COSMETICO == ");
                preencherComum(cos);
                cos.setFragrancia(l.entDados("Fragrancia: "));
                cos.setTipoPele(l.entDados("Tipo de pele: "));
                itens.add(cos);
                break;
            case 4:
                hig = new Higiene();
                System.out.println("== CADASTRO HIGIENE ==");
                preencherComum(hig);
                hig.setPublicoAlvo(l.entDados("Publico Alvo (ex: infantil/idoso/adulto): "));
                hig.setUnidadesPorPacote(Integer.parseInt(l.entDados("Unidades por Pacote: ")));
                itens.add(hig);
                break;
            case 5:
                apm = new AparelhoMedico();
                System.out.println("== CADASTRO APARELHO MEDICO ==");
                preencherComum(apm);
                apm.setGarantiaMeses(Integer.parseInt(l.entDados("Garantia em Meses: ")));
                apm.setVoltagem(l.entDados("Voltagem: "));
                itens.add(apm);
                break;
            default:
                System.out.println("Digite um numero correspondente ao menu acima!");
                break;
        }
    }

    public void cadCliente(){
        Cliente cl = new Cliente();
        System.out.println("== CADASTRO CLIENTES ==");
        cl.setNome(l.entDados("Nome do Cliente: "));
        cl.setCpf(l.entDados("CPF do Cliente (ex: 111.222.333-44): "));
        cl.setTelefone(l.entDados("Telefone do Cliente (com DDD): "));
        clientes.add(cl);
    }

    public void registrarVenda(){

    }

    public void listarItens(){
        for(int i = 0; i < itens.size(); i++){
            System.out.println(itens.get(i).toString());
        }
    }

    public void listarClientes(){
        for(int i = 0; i < clientes.size(); i++){
            System.out.println("Cliente numero "+ (i + 1));
            System.out.println("NOME: "+clientes.get(i).getNome());
            System.out.println("CPF: "+clientes.get(i).getCpf());
            System.out.println("TELEFONE: "+clientes.get(i).getTelefone());
        }
    }

    public void listarVendas(){

    }
}
