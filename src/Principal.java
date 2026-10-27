// Ricardo Augusto Scalada Mercante RA: a2865483

public class Principal {
    public static void main(String[] args){
        Controle ctl = new Controle();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n|== MENU PRINCIPAL==|");
            System.out.println("1) Cadastre um Item");
            System.out.println("2) Cadastre um Cliente");
            System.out.println("3) Registre uma venda");
            System.out.println("4) Listar Itens");
            System.out.println("5) Listar Clientes");
            System.out.println("6) Listar Vendas");
            System.out.println("0) Sair");
            int opcao = ctl.lerInt("Opção: ");

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
                case 1:
                    ctl.cadItem();
                    break;
                case 2:
                    ctl.cadCliente();
                    break;
                case 3:
                    ctl.registrarVenda();
                    break;
                case 4:
                    ctl.listarItens();
                    break;
                case 5:
                    ctl.listarClientes();
                    break;
                case 6:
                    ctl.listarVendas();
                    break;
                default:
                    System.out.println("Digite um numero correspondente ao menu acima!");
                    break;
            }
        }

    }
}
