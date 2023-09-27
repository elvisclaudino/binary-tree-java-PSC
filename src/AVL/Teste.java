package AVL;

public class Teste {
    public static void main(String[] args) {
        ArvoreAVL<Integer> arvore = new ArvoreAVL<>(); // Cria uma nova árvore AVL

        arvore.inserir(10); // Insere elementos na árvore
        arvore.inserir(8);
        arvore.inserir(17);
        arvore.inserir(7);
        arvore.inserir(9);
        arvore.inserir(15);
        arvore.inserir(20);

        System.out.println("Árvore AVL:"); // Imprime a árvore AVL
        arvore.imprimir(); // Chama o método de impressão

        int valorBuscado = 12; // Busca um elemento na árvore
        boolean resultadoBusca = arvore.buscar(valorBuscado); // Chama o método de busca
        if (resultadoBusca) {
            System.out.println("O valor " + valorBuscado + " foi encontrado na árvore."); // Se o resultado da busca for verdadeiro, o elemento foi encontrado
        } else {
            System.out.println("O valor " + valorBuscado + " não foi encontrado na árvore."); // Se o resultado da busca for falso, o elemento não foi encontrado
        }

        int valorRemovido = 15; // Remove um elemento da árvore
        arvore.remover(valorRemovido); // Chama o método de remoção
        System.out.println("O valor " + valorRemovido + " foi removido da árvore."); // Imprime o valor removido

        arvore.inserir(21);

        arvore.imprimir(); // Chama o método de impressão
    }
}
