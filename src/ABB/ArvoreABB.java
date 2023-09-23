package ABB;

import Nó.No;

public class ArvoreABB<T extends Comparable<T>> {
    private No<T> raiz; // Nó raiz da árvore

    public ArvoreABB() {
        this.raiz = null; // Inicializa a árvore com a raiz nula
    }

    public void inserir(T elemento) { // Insere um elemento na árvore
        this.raiz = inserirRecursivo(raiz, elemento); // Chama o método recursivo de inserção
    }

    private No<T> inserirRecursivo(No<T> no, T elemento) { // Método recursivo de inserção
        if(no == null) {
            return new No<>(elemento); // Se o nó for nulo, cria um novo nó com o elemento
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(inserirRecursivo(no.getAnterior(), elemento)); // Se o elemento for menor que o elemento do nó, insere na subárvore esquerda
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(inserirRecursivo(no.getProximo(), elemento)); // Se o elemento for maior que o elemento do nó, insere na subárvore direita
        }

        return no;
    }

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

    public void remover(T elemento) { // Remove um elemento da árvore
        this.raiz = removerRecursivo(raiz, elemento); // Chama o método recursivo de remoção
    }

    private No<T> removerRecursivo(No<T> no, T elemento) {
        if (no == null) {
            return no; // Se o nó for nulo, retorna nulo
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(removerRecursivo(no.getAnterior(), elemento)); // Se o elemento for menor que o elemento do nó, remove da subárvore esquerda
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(removerRecursivo(no.getProximo(), elemento)); // Se o elemento for maior que o elemento do nó, remove da subárvore direita
        } else {
            if (no.getAnterior() == null) {
                return no.getProximo(); // Se o nó não tiver subárvore esquerda, retorna a subárvore direita
            } else if (no.getProximo() == null) {
                return no.getAnterior(); // Se o nó não tiver subárvore direita, retorna a subárvore esquerda
            }

            no.setElemento(encontrarMenorElemento(no.getProximo())); // Se o nó tiver subárvore esquerda e direita, encontra o menor elemento da subárvore direita e substitui pelo elemento do nó

            no.setProximo(removerRecursivo(no.getProximo(), no.getElemento())); // Remove o menor elemento da subárvore direita
        }

        return no;
    }

    private T encontrarMenorElemento(No<T> no) { // Encontra o menor elemento de uma subárvore
        if (no.getAnterior() == null) {
            return no.getElemento(); // Se o nó não tiver subárvore esquerda, retorna o elemento do nó
        }

        return encontrarMenorElemento(no.getAnterior()); // Se o nó tiver subárvore esquerda, busca na subárvore esquerda
    }

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
