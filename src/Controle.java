// Ricardo Augusto Scalada Mercante RA: a2865483

import java.util.ArrayList;

public class Controle {

    // ==================== ATRIBUTOS ====================

    private Leitura l = new Leitura();

    private ArrayList<ItemFarmacia> itens;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;

    // ==================== CONSTRUTOR ====================

    public Controle() {
        this.itens = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    // ==================== MENUS ====================

    public void cadastrar(){
        System.out.println("\n== MENU DE CADASTRO== ");
        System.out.println("1) Cadastro Cliente");
        System.out.println("2) Cadastro Item");
        System.out.println("0) Voltar (Menu)");
        int opcao = lerInt("Opção: ");

        switch (opcao){
            case 0:
                System.out.println("Retornando...");
                return;
            case 1:
                cadCliente();
                break;
            case 2:
                cadItem();
                break;
            default:
                System.out.println("Digite um numero correspondente ao menu acima!");
                break;
        }
    }

    public void listar(){
        System.out.println("\n== MENU DE ESCOLHA DE LISTAS == ");
        System.out.println("1) Clientes");
        System.out.println("2) Itens");
        System.out.println("3) Vendas");
        System.out.println("0) Voltar (Menu)");
        int opcao = lerInt("Opção: ");

        switch (opcao){
            case 0:
                System.out.println("Retornando...");
                return;
            case 1:
                listarClientes();
                break;
            case 2:
                listarItens();
                break;
            case 3:
                listarVendas();
                break;
            default:
                System.out.println("Digite um numero correspondente ao menu acima!");
                break;
        }
    }

    // ==================== CADASTROS ====================

    private void cadItem(){
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
        int op = lerInt("Opção: ");
        switch (op) {
            case 1:
                rem = new Remedio();
                System.out.println("\n== CADASTRO REMEDIO ==");
                preencherComum(rem);
                rem.setDosagem(l.entDados("Dosagem (ex: 500mg): "));
                rem.setPrincipioAtivo(l.entDados("Principio Ativo (ex: dipirona, paracetamol): "));
                itens.add(rem);
                System.out.println("Remedio cadastrado com sucesso!");
                break;
            case 2:
                con = new Controlado();
                System.out.println("\n== CADASTRO REMEDIO CONTROLADO ==");
                preencherComum(con);
                con.setDosagem(l.entDados("Dosagem (ex: 500mg): "));
                con.setPrincipioAtivo(l.entDados("Principio Ativo (ex: dipirona, paracetamol): "));
                con.setTarja(l.entDados("Tarja (ex: vermelha/preta): "));
                itens.add(con);
                System.out.println("Remedio Controlado cadastrado com sucesso!");
                break;
            case 3:
                cos = new Cosmetico();
                System.out.println("\n== CADASTRO COSMETICO == ");
                preencherComum(cos);
                cos.setFragrancia(l.entDados("Fragrancia (ex: lavanda, sem perfume): "));
                cos.setTipoPele(l.entDados("Tipo de pele (ex: oleosa/seca/mista/normal): "));
                itens.add(cos);
                System.out.println("Cosmetico cadastrado com sucesso!");
                break;
            case 4:
                hig = new Higiene();
                System.out.println("\n== CADASTRO HIGIENE ==");
                preencherComum(hig);
                hig.setPublicoAlvo(l.entDados("Publico Alvo (ex: infantil/idoso/adulto): "));
                hig.setUnidadesPorPacote(lerQuantidade("Unidades por Pacote (número inteiro, ex: 12): "));
                itens.add(hig);
                System.out.println("Item de Higiene cadastrado com sucesso!");
                break;
            case 5:
                apm = new AparelhoMedico();
                System.out.println("\n== CADASTRO APARELHO MEDICO ==");
                preencherComum(apm);
                apm.setGarantiaMeses(lerQuantidade("Garantia em Meses (número inteiro, ex: 12): "));
                apm.setVoltagem(l.entDados("Voltagem (ex: 110V/220V/bivolt): "));
                itens.add(apm);
                System.out.println("Aparelho Medico cadastrado com sucesso!");
                break;
            default:
                System.out.println("Digite um numero correspondente ao menu acima!");
                break;
        }
    }

    // preenche os dados que todo item tem (herdados de ItemFarmacia)
    private void preencherComum(ItemFarmacia item) {
        item.setNome(l.entDados("Nome do Item: "));
        item.setMarca(l.entDados("Marca Item: "));
        item.setPreco(lerPreco("Preço (ex: 5.99, use ponto): "));
        item.setQtdEstoque(lerQuantidade("Quantidade Estoque Item (número inteiro, ex: 12): "));
    }

    private void cadCliente() {
        Cliente cl = new Cliente();
        System.out.println("\n== CADASTRO CLIENTES ==");
        cl.setNome(l.entDados("Nome do Cliente: "));
        cl.setCpf(l.entDados("CPF do Cliente (ex: 111.222.333-44): "));
        cl.setTelefone(l.entDados("Telefone do Cliente (ex: 43 99999-9999): "));
        clientes.add(cl);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // ==================== VENDA ====================

    public void registrarVenda() {
        if (clientes.isEmpty() || itens.isEmpty()) {
            System.out.println("Cadastre pelo menos um cliente e um item antes de registrar uma venda");
            return; // sai do metodo
        }
        try {
            Venda ven = new Venda();
            listarClientes();
            ven.setCliente(clientes.get(lerPosicao("\nNumero do Cliente: ", clientes.size())));
            listarItens();
            ven.setItem(itens.get(lerPosicao("\nNumero do Item: ", itens.size())));
            ven.setQuantidade(lerQuantidade("Quantidade (Numero inteiro): "));
            verEstoque(ven.getItem(), ven.getQuantidade());

            // so remedio controlado precisa de receita
            if (ven.getItem() instanceof Controlado) {
                Controlado con = (Controlado) ven.getItem();
                String aReceita = l.entDados("Apresentou receita? (S/N): ");
                con.setReceitaApresentada(aReceita.equalsIgnoreCase("S"));
                verReceita(con);
            }
            // so chega aqui se passou nas duas verificacoes
            ven.getItem().setQtdEstoque(ven.getItem().getQtdEstoque() - ven.getQuantidade()); //Reflexividade
            vendas.add(ven);
            double desc = lerDesconto("Desconto em % (ex: 10 para 10%): ");
            System.out.format("Total com Desconto: %.2f%n", ven.calcTotal(desc));
        }
        catch (EstoqueInsuficienteException eie) {
            System.out.println(eie.getMessage());
        }
        catch (ReceitaObrigatoriaException roe) {
            System.out.println(roe.getMessage());
        }
    }

    // lanca excecao se o estoque nao tiver a quantidade pedida
    private void verEstoque(ItemFarmacia item, int qtd) throws EstoqueInsuficienteException {
        if (item.getQtdEstoque() < qtd) {
            throw new EstoqueInsuficienteException();
        }
    }

    // lanca excecao se a receita do controlado nao foi apresentada
    private void verReceita(Controlado con) throws ReceitaObrigatoriaException {
        if (!con.isReceitaApresentada()) {
            throw new ReceitaObrigatoriaException();
        }
    }

    // ==================== RELATORIOS ====================

    private void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Cadastre um item antes de ver a lista de itens");
            return; // sai do metodo
        }
        System.out.println("\n== LISTA DE ITENS ==");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println("\nItem numero " + (i + 1));
            System.out.println(itens.get(i).toString()+"\n");
        }
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Cadastre um cliente antes de ver a lista de clientes");
            return; // sai do metodo
        }
        System.out.println("\n== LISTA DE CLIENTES ==");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("\nCliente numero " + (i + 1));
            System.out.println("NOME: " + clientes.get(i).getNome());
            System.out.println("CPF: " + clientes.get(i).getCpf());
            System.out.println("TELEFONE: " + clientes.get(i).getTelefone());
        }
    }

    private void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Registre uma venda antes de ver a lista de vendas");
            return; // sai do metodo
        }
        System.out.println("\n== LISTA DE VENDAS ==");
        for (int i = 0; i < vendas.size(); i++) {
            System.out.println("\nVenda numero: " + (i + 1));
            System.out.println("Nome Cliente: " + vendas.get(i).getCliente().getNome()); //Reflexividade
            System.out.println("Item: " + vendas.get(i).getItem().getNome()); //Reflexividade
            System.out.println("Quantidade de Itens vendidos: " + vendas.get(i).getQuantidade());
            System.out.format("Total da venda: %.2f%n", vendas.get(i).calcTotal());
        }
    }

    // ==================== LEITURA COM TRATAMENTO ====================

    // le um inteiro; se digitar letra, pergunta de novo
    public int lerInt(String rotulo) {
        while (true) {
            try {
                return Integer.parseInt(l.entDados(rotulo));
            } catch (NumberFormatException nfe) {
                System.out.println("Valor invalido, digite apenas numeros!");
            }
        }
    }

    // le um numero com casas decimais; se digitar letra, pergunta de novo
    private double lerDouble(String rotulo) {
        while (true) {
            try {
                return Double.parseDouble(l.entDados(rotulo));
            } catch (NumberFormatException nfe) {
                System.out.println("Valor invalido, digite apenas numeros!");
            }
        }
    }

    // le o numero mostrado na lista e devolve a posicao no ArrayList
    private int lerPosicao(String rotulo, int tamanho){
        while (true){
            int posCI = lerInt(rotulo);
            if(posCI >= 1 && posCI <= tamanho){
                return posCI - 1; // a tela comeca em 1, a lista comeca em 0
            }else{
                System.out.println("Numero invalido");
            }
        }
    }

    // le um inteiro maior que 0
    private int lerQuantidade(String rotulo){
        while (true){
            int qtdCI = lerInt(rotulo);
            if(qtdCI > 0){
                return qtdCI;
            }else{
                System.out.println("deve ser maior que 0");
            }
        }
    }

    // le um preco maior que 0
    private double lerPreco(String rotulo){
        while (true){
            double precoCI = lerDouble(rotulo);
            if(precoCI > 0){
                return precoCI;
            }else{
                System.out.println("deve ser maior que 0");
            }
        }
    }

    // le um desconto entre 0 e 100
    private double lerDesconto(String rotulo){
        while (true){
            double descCI = lerDouble(rotulo);
            if(descCI >= 0 && descCI <= 100){
                return descCI;
            }else{
                System.out.println("deve ser de 0 a 100");
            }
        }
    }
}