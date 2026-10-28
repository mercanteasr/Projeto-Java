// Ricardo Augusto Scalada Mercante RA: a2865483

public class Principal {
    public static void main(String[] args){
        Controle ctl = new Controle();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n|== MENU PRINCIPAL==|");
            System.out.println("1) Cadastre CLientes/Itens");
            System.out.println("2) Registre uma venda");
            System.out.println("3) Listar Itens/Clientes/Vendas");
            System.out.println("0) Sair");
            int opcao = ctl.lerInt("Opção: ");

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
                case 1:
                    ctl.cadastrar();
                    break;
                case 2:
                    ctl.registrarVenda();
                    break;
                case 3:
                    ctl.listar();
                    break;
                default:
                    System.out.println("Digite um numero correspondente ao menu acima!");
                    break;
            }
        }

    }
}
