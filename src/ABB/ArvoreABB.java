package ABB;

import EstrutaArvore.Arvore;
import EstrutaArvore.No;

public class ArvoreABB<T extends Comparable<T>> extends Arvore<T> {
    public ArvoreABB() {
        super();
    }

    @Override
    public void inserir(T elemento) {
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

    @Override
    public void remover(T elemento) {
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
}
