package EstrutaArvore;

public class Arvore<T extends Comparable<T>> implements Metodos<T>{
    protected No<T> raiz; // Nó raiz da árvore

    public Arvore() {
        this.raiz = null; // Inicializa a árvore com a raiz nula
    }

    @Override
    public void inserir(T elemento) {
    }

    @Override
    public boolean buscar(T elemento) { // Busca um elemento na árvore
        return buscarRecursivo(raiz, elemento); // Chama o método recursivo de busca
    }

    private boolean buscarRecursivo(No<T> no, T elemento) { // Método recursivo de busca
        if (no == null) {
            return false; // Se o nó for nulo, retorna falso
        }

        if (elemento.compareTo(no.getElemento()) == 0) {
            return true; // Se o elemento for igual ao elemento do nó, retorna verdadeiro
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            return buscarRecursivo(no.getAnterior(), elemento); // Se o elemento for menor que o elemento do nó, busca na subárvore esquerda
        } else {
            return buscarRecursivo(no.getProximo(), elemento); // Se o elemento for maior que o elemento do nó, busca na subárvore direita
        }
    }

    @Override
    public void remover(T elemento) {
    }

    protected T encontrarMenorElemento(No<T> no) { // Encontra o menor elemento de uma subárvore
        if (no.getAnterior() == null) {
            return no.getElemento(); // Se o nó não tiver subárvore esquerda, retorna o elemento do nó
        }

        return encontrarMenorElemento(no.getAnterior()); // Se o nó tiver subárvore esquerda, busca na subárvore esquerda
    }

    @Override
    public void imprimir() { // Imprime a árvore
        imprimirRecursivo(raiz, 0); // Chama o método recursivo de impressão
    }

    private void imprimirRecursivo(No<T> no, int nivel) { // Método recursivo de impressão
        if (no == null) {
            return; // Se o nó for nulo, retorna
        }

        imprimirRecursivo(no.getProximo(), nivel + 1); // Imprime a subárvore direita

        for (int i = 0; i < nivel; i++) {
            System.out.print("     "); // Imprime a quantidade de espaços de acordo com o nível
        }
        System.out.println(no.getElemento()); // Imprime o elemento do nó

        imprimirRecursivo(no.getAnterior(), nivel + 1); // Imprime a subárvore esquerda
    }
}
