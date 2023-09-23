package ABB;

import Nó.No;

public class ArvoreABB<T extends Comparable<T>> {
    private No<T> raiz;

    public ArvoreABB() {
        this.raiz = null;
    }

    public void inserir(T elemento) {
        this.raiz = inserirRecursivo(raiz, elemento);
    }

    private No<T> inserirRecursivo(No<T> no, T elemento) {
        if(no == null) {
            return new No<>(elemento);
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(inserirRecursivo(no.getAnterior(), elemento));
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(inserirRecursivo(no.getProximo(), elemento));
        }

        return no;
    }

    public boolean buscar(T elemento) {
        return buscarRecursivo(raiz, elemento);
    }

    private boolean buscarRecursivo(No<T> no, T elemento) {
        if (no == null) {
            return false;
        }

        if (elemento.compareTo(no.getElemento()) == 0) {
            return true;
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            return buscarRecursivo(no.getAnterior(), elemento);
        } else {
            return buscarRecursivo(no.getProximo(), elemento);
        }
    }

    public void remover(T elemento) {
        this.raiz = removerRecursivo(raiz, elemento);
    }

    private No<T> removerRecursivo(No<T> no, T elemento) {
        if (no == null) {
            return no;
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(removerRecursivo(no.getAnterior(), elemento));
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(removerRecursivo(no.getProximo(), elemento));
        } else {
            if (no.getAnterior() == null) {
                return no.getProximo();
            } else if (no.getProximo() == null) {
                return no.getAnterior();
            }

            no.setElemento(encontrarMenorElemento(no.getProximo()));

            no.setProximo(removerRecursivo(no.getProximo(), no.getElemento()));
        }

        return no;
    }

    private T encontrarMenorElemento(No<T> no) {
        if (no.getAnterior() == null) {
            return no.getElemento();
        }

        return encontrarMenorElemento(no.getAnterior());
    }

    public void imprimir() {
        imprimirRecursivo(raiz, 0);
    }

    private void imprimirRecursivo(No<T> no, int nivel) {
        if (no == null) {
            return;
        }

        imprimirRecursivo(no.getProximo(), nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("   "); // Ajuste o número de espaços conforme a profundidade desejada
        }

        System.out.println(no.getElemento());

        imprimirRecursivo(no.getAnterior(), nivel + 1);
    }
}
