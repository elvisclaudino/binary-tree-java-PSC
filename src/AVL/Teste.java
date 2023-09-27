package AVL;

public class Teste {
    public static void main(String[] args) {
        ArvoreAVL<Integer> arvore = new ArvoreAVL<>(); // Cria uma nova árvore AVL

        arvore.inserir(10); // Insere elementos na árvore
        arvore.inserir(8);
        arvore.inserir(17);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(15);
        arvore.inserir(20);

        System.out.println("Árvore AVL:"); // Imprime a árvore AVL
        arvore.imprimir(); // Chama o método de impressão
    }
}
