package ABB;

public class Teste {
    public static void main (String[] args) {
        ArvoreABB<Integer> arvore = new ArvoreABB<>(); // Cria uma nova árvore binária de busca

        arvore.inserir(10); // Insere elementos na árvore
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(12);
        arvore.inserir(18);
        arvore.inserir(19);
        arvore.inserir(17);
        arvore.inserir(6);
        arvore.inserir(9);

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

        System.out.println("Árvore binária de busca:"); // Imprime a árvore binária de busca
        arvore.imprimir(); // Chama o método de impressão
    }
}
