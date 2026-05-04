package comercioEletronico.userInterface;
import comercioEletronico.dao.*;
import comercioEletronico.model.*;

import java.util.Scanner;

public class UI {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static Cliente cliente;
    private static CategoriaDAO categoriaDAO = new CategoriaDAO();
    private static Categoria categoria;
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static Produto produto;
    private static VendaDAO vendaDAO = new VendaDAO();
    private static Venda venda;
    private static VendaItemDAO vendaItemDAO = new VendaItemDAO();
    private static VendaItem vendaItem;
    private static Scanner scanner = new Scanner(System.in);
    private static int idGenerator;
    private static int id;

    public static void menu() {
        clienteDAO.abrir();
        categoriaDAO.abrir();
        produtoDAO.abrir();
        vendaDAO.abrir();
        vendaItemDAO.abrir();
        int codigo = -1;
        do {
            try {

                System.out.println();
                System.out.println("""
                        === MENU ===
                    1 - Inserir Cliente
                    2 - Listar Clientes
                    3 - Atualizar Cliente
                    4 - Remover Cliente
                    
                    5 - Inserir Categoria
                    6 - Listar Categorias
                    7 - Atualizar Categoria
                    8 - Remover Categoria
                    
                    9 - Inserir Produto
                    10 - Listar Produtos
                    11 - Atualizar Produto
                    12 - Remover Produto
                    
                    13 - Realizar Venda
                    14 - Listar Vendas
                    
                    0 - Sair
                    """);
                System.out.print("Digite uma opção: ");
                codigo = scanner.nextInt();
                scanner.nextLine(); // limpeza de buffer

                switch (codigo) {
                    case 0:
                        System.out.println("Saindo...");
                        break;

                    case 1:
                        System.out.println("=== CADASTRO DE CLIENTE ===");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        cliente = new Cliente(nome, email, telefone);

                        idGenerator = 0;
                        for (Cliente objeto : UI.clienteDAO.listar()) {
                            if (objeto.getId() > idGenerator) {
                                idGenerator = objeto.getId();
                            }
                        }
                        cliente.setId(idGenerator + 1);
                        UI.clienteDAO.inserir(cliente);
                        break;

                    case 2:
                        if (UI.clienteDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum cliente registrado!");
                            continue;
                        }
                        for (Cliente objeto : UI.clienteDAO.listar()) {
                            System.out.println(objeto);
                        }
                        break;

                    case 3:
                        if (UI.clienteDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum cliente registrado!");
                            continue;
                        }

                        System.out.print("Insira o ID do cliente a ser atualizado: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        cliente = UI.clienteDAO.listarId(id);

                        if (cliente == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        System.out.print("Informe o novo nome: ");
                        String nomeNovo = scanner.nextLine();

                        System.out.print("Informe o novo email: ");
                        String emailNovo = scanner.nextLine();

                        System.out.print(" Informe o novo telefone: ");
                        String telefoneNovo = scanner.nextLine();

                        UI.clienteDAO.atualizar(cliente, nomeNovo, emailNovo, telefoneNovo);
                        break;

                    case 4:
                        if (UI.clienteDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum cliente registrado!");
                            continue;
                        }

                        System.out.print("Insira o ID do cliente a ser removido: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        cliente = UI.clienteDAO.listarId(id);

                        if (cliente == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        UI.clienteDAO.excluir(cliente);
                        break;

                    case 5:
                        System.out.println("=== CADASTRO DE CATEGORIA ===");
                        System.out.print("Descrição: ");
                        String descricaoCategoria = scanner.nextLine();

                        categoria = new Categoria(descricaoCategoria);

                        idGenerator = 0;
                        for (Categoria objeto : UI.categoriaDAO.listar()) {
                            if (objeto.getId() > idGenerator) {
                                idGenerator = objeto.getId();
                            }
                        }
                        categoria.setId(idGenerator + 1);
                        UI.categoriaDAO.inserir(categoria);
                        break;

                    case 6:
                        if (UI.categoriaDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhuma categoria registrada!");
                            continue;
                        }
                        for (Categoria objeto : UI.categoriaDAO.listar()) {
                            System.out.println(objeto);
                        }
                        break;

                    case 7:
                        if (UI.categoriaDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhuma categoria registrada!");
                            continue;
                        }

                        System.out.print("Insira o ID da categoria a ser atualizada: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        categoria = UI.categoriaDAO.listarId(id);

                        if (categoria == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        System.out.print("Informe a nova descrição: ");
                        String descricaoNova = scanner.nextLine();
                        UI.categoriaDAO.atualizar(categoria, descricaoNova);
                        break;

                    case 8:
                        if (UI.categoriaDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhuma categoria registrada!");
                            continue;
                        }

                        System.out.print("Insira o ID da categoria a ser removida: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        categoria = UI.categoriaDAO.listarId(id);

                        if (categoria == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        UI.categoriaDAO.excluir(categoria);
                        break;

                    case 9:
                        System.out.println("=== CADASTRO DE PRODUTO ===");
                        if (UI.categoriaDAO.listar().isEmpty()) {
                            System.out.println("Primeiro insira uma categoria!");
                            continue;
                        }

                        System.out.print("Insira a ID correspondente a categoria deste produto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();

                        categoria = UI.categoriaDAO.listarId(id);

                        if (categoria == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        System.out.print("Descrição: ");
                        String descricaoProduto = scanner.nextLine();
                        System.out.print("Preço: ");
                        double precoProduto = scanner.nextDouble();
                        System.out.print("Estoque: ");
                        int estoqueProduto = scanner.nextInt();

                        idGenerator = 0;
                        for (Produto objeto : UI.produtoDAO.listar()) {
                            if (objeto.getId() > idGenerator) {
                                idGenerator = objeto.getId();
                            }
                        }

                        produto = new Produto(descricaoProduto, precoProduto, estoqueProduto, categoria);
                        produto.setId(idGenerator + 1);
                        UI.produtoDAO.inserir(produto);
                        break;

                    case 10:
                        if (UI.produtoDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum produto registrado!");
                            continue;
                        }
                        for (Produto objeto : UI.produtoDAO.listar()) {
                            System.out.println(objeto);
                        }
                        break;

                    case 11:
                        if (UI.produtoDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum produto registrado!");
                            continue;
                        }

                        System.out.print("Insira a ID do produto a ser atualizado: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        produto = UI.produtoDAO.listarId(id);

                        if (produto == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        System.out.print("Informe a ID da nova categoria: ");
                        int idCategoriaNova = scanner.nextInt();
                        scanner.nextLine();
                        categoria = UI.categoriaDAO.listarId(idCategoriaNova);

                        if (categoria == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        System.out.print("Informe a nova descrição do produto: ");
                        String descNova = scanner.nextLine();
                        System.out.print("Informe o novo preço do produto: ");
                        double precoNovo = scanner.nextDouble();
                        System.out.print("Informe a nova quantidade em estoque: ");
                        int estoqueNovo = scanner.nextInt();
                        scanner.nextLine();

                        UI.produtoDAO.atualizar(produto, descNova, precoNovo, estoqueNovo, categoria);

                        break;

                    case 12:
                        if (UI.produtoDAO.listar().isEmpty()) {
                            System.out.println("Ainda não há nenhum produto registrado!");
                            continue;
                        }

                        System.out.print("Insira o ID do produto a ser removido: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        produto = UI.produtoDAO.listarId(id);

                        if (produto == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        UI.produtoDAO.excluir(produto);
                        break;

                    case 13:
                        System.out.println();
                        System.out.println("=== CADASTRO DE VENDA ===");
                        if (UI.clienteDAO.listar().isEmpty()) {
                            System.out.println("Para realizar uma venda, é necessário ter o cadastro de pelo menos um cliente!");
                            continue;
                        }

                        System.out.print("Insira a ID correspondente ao cliente para esta venda: ");
                        id = scanner.nextInt();
                        scanner.nextLine();

                        cliente = UI.clienteDAO.listarId(id);

                        if (cliente == null) {
                            System.out.println("Insira uma ID válida!");
                            continue;
                        }

                        venda = new Venda(cliente);

                        idGenerator = 0;
                        for (Venda venda : UI.vendaDAO.listar()) {
                            if (venda.getId() > idGenerator) {
                                idGenerator = venda.getId();
                            }
                        }
                        venda.setId(idGenerator + 1);

                        int codigoVenda = -1;

                        do {
                            try {
                                System.out.println();
                                System.out.println("""
                                === CADASTRO DE ITEM ===
                                1 - Inserir Item
                                2 - Listar Itens
                                3 - Atualizar Item
                                4 - Remover Item
                                
                                0 - Encerrar carrinho
                                """);
                                System.out.print("Digite uma opção: ");
                                codigoVenda = scanner.nextInt();
                                scanner.nextLine();

                                switch (codigoVenda) {
                                    case 0:
                                        System.out.println("Carrinho encerrado!");
                                        venda.setCarrinho(true);
                                        UI.vendaDAO.inserir(venda);
                                        break;

                                    case 1:
                                        System.out.println("Escolha um produto para ser adicionado: ");

                                        for (Produto produto : UI.produtoDAO.listar()) {
                                            System.out.println(produto);
                                        }
                                        System.out.print("Insira a ID do produto: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        produto = UI.produtoDAO.listarId(id);

                                        if (produto == null) {
                                            System.out.println("Insira uma ID válida!");
                                            continue;
                                        }

                                        System.out.print("Insira a quantidade de itens: ");
                                        int qtdItens = scanner.nextInt();
                                        scanner.nextLine();

                                        idGenerator = 0;
                                        for (VendaItem item : UI.vendaItemDAO.listar()) {
                                            if (item.getId() > idGenerator) {
                                                idGenerator = item.getId();
                                            }
                                        }
                                        vendaItem = new VendaItem(qtdItens, produto); // instancia a vendaItem
                                        vendaItem.setIdVenda(venda.getId()); // atribui o ID da venda ao vendaIem
                                        vendaItem.setId(idGenerator + 1);
                                        venda.setTotal(venda.getTotal() + vendaItem.getPreco()); // subtotal da venda
                                        UI.vendaItemDAO.inserir(vendaItem);
                                        UI.produtoDAO.salvar();
                                        break;

                                    case 2:
                                        if (UI.vendaItemDAO.listar().isEmpty()) {
                                            System.out.println("Ainda não há nenhum item registrado!");
                                            continue;
                                        }

                                        for (VendaItem item : UI.vendaItemDAO.listar()) {
                                            if (venda.getId() == item.getIdVenda()) {
                                                System.out.println(item);
                                            }
                                        }

                                        System.out.println("Subtotal: R$" + venda.getTotal());
                                        break;

                                    case 3:
                                        if (UI.vendaItemDAO.listar().isEmpty()) {
                                            System.out.println("Ainda não há nenhum item registrado!");
                                            continue;
                                        }

                                        System.out.print("Insira a ID do item a ser atualizado: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        vendaItem = UI.vendaItemDAO.listarId(id);

                                        if (vendaItem == null || vendaItem.getIdVenda() != venda.getId()) {
                                            System.out.println("Insira uma ID válida!");
                                            continue;
                                        }

                                        System.out.print("Informe o novo produto: ");

                                        System.out.println("Produtos: ");

                                        for (Produto produto : UI.produtoDAO.listar()) {
                                            System.out.println(produto);
                                        }

                                        System.out.println();
                                        System.out.print("Insira a ID do novo produto: ");
                                        int idNovoProduto = scanner.nextInt();
                                        scanner.nextLine();

                                        produto = UI.produtoDAO.listarId(idNovoProduto);

                                        if (produto == null) {
                                            System.out.println("Insira uma ID válida!");
                                            continue;
                                        }

                                        System.out.print("Insira a nova quantidade: ");
                                        int novaQtdItens = scanner.nextInt();
                                        scanner.nextLine();

                                        Produto produtoAntigo = vendaItem.getProduto(); // backup do produto anterior
                                        int qtdAntiga = vendaItem.getQuantidade(); // backup da quantidade em estoque
                                        double precoAntigo = vendaItem.getPreco(); // backup do preço para ajustar na venda

                                        int estoqueDisponivel = produto.getEstoque(); // estoque do produto atual

                                        if (produto.getId() == produtoAntigo.getId()) {
                                            estoqueDisponivel += qtdAntiga;
                                        }

                                        if (novaQtdItens <= 0 || novaQtdItens > estoqueDisponivel) { // camada dupla de segurança
                                            System.out.println("Quantidade inválida ou estoque insuficiente para essa alteração!");
                                            continue;
                                        }

                                        produtoAntigo.setEstoque(produtoAntigo.getEstoque() + qtdAntiga);

                                        UI.vendaItemDAO.atualizar(vendaItem, novaQtdItens, produto);
                                        UI.produtoDAO.salvar();
                                        venda.setTotal(venda.getTotal() - precoAntigo + vendaItem.getPreco());
                                        System.out.println("Item atualizado com sucesso!");
                                        break;

                                    case 4:
                                        if (UI.vendaItemDAO.listar().isEmpty()) {
                                            System.out.println("Ainda não há nenhum item registrado!");
                                            continue;
                                        }

                                        System.out.print("Insira a ID do item a ser removido: ");
                                        id = scanner.nextInt();
                                        scanner.nextLine();

                                        vendaItem = UI.vendaItemDAO.listarId(id);

                                        if (vendaItem == null || vendaItem.getIdVenda() != venda.getId()) {
                                            System.out.println("Insira uma ID válida!");
                                            continue;
                                        }

                                        produto = vendaItem.getProduto(); // pega o produto atual da venda
                                        produto.setEstoque(produto.getEstoque() + vendaItem.getQuantidade()); // devolve o estoque
                                        venda.setTotal(venda.getTotal() - vendaItem.getPreco()); // atualiza o preço
                                        UI.vendaItemDAO.excluir(vendaItem);
                                        UI.produtoDAO.salvar();
                                        System.out.println("Item removido com sucesso!");
                                        break;

                                    default:
                                        System.out.println("Insira uma opção válida!");
                                }

                            } catch (IllegalArgumentException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                                System.out.println("Operação cancelada, tente novamente!");
                            }

                        } while (codigoVenda != 0);
                        break;

                    case 14:
                        if (UI.vendaDAO.listar().isEmpty()) {
                            System.out.println("Ainda não foi registrada nenhuma venda!");
                            continue;
                        }

                        for (Venda objeto : vendaDAO.listar()) {
                            System.out.println(objeto);
                        }
                        break;

                    default:
                        System.out.println("Insira uma opção válida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println("Operação cancelada, tente novamente!");
            }
        } while (codigo != 0);
    }
}