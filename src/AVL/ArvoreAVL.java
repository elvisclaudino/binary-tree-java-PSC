package AVL;

import EstrutaArvore.Arvore;
import EstrutaArvore.No;

public class ArvoreAVL<T extends Comparable<T>> extends Arvore<T> {
    public ArvoreAVL() {
        super(); // Chama o construtor da classe pai
    }

    @Override
    public void inserir(T elemento) {
        this.raiz = inserirRecursivo(raiz, elemento); // Chama o método recursivo de inserção
    }

    private No<T> inserirRecursivo(No<T> no, T elemento) {
        if (no == null) {
            return new No<>(elemento); // Se o nó for nulo, cria um novo nó com o elemento
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(inserirRecursivo(no.getAnterior(), elemento)); // Se o elemento for menor que o elemento do nó, insere na subárvore esquerda
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(inserirRecursivo(no.getProximo(), elemento)); // Se o elemento for maior que o elemento do nó, insere na subárvore direita
        } else {
            return no; // Se o elemento for igual ao elemento do nó, retorna o nó
        }

        no.setAltura(1 + Math.max(obterAltura(no.getAnterior()), obterAltura(no.getProximo()))); // Atualiza a altura do nó

        int fatorBalanceamento = obterFatorBalanceamento(no); // Calcula o fator de balanceamento do nó

        if(fatorBalanceamento > 1 && elemento.compareTo(no.getAnterior().getElemento()) < 0) {
            return rotacaoDireita(no); // Rotação simples à direita
        }

        if(fatorBalanceamento < -1 && elemento.compareTo(no.getProximo().getElemento()) > 0) {
            return rotacaoEsquerda(no); // Rotação simples à esquerda
        }

        if(fatorBalanceamento > 1 && elemento.compareTo(no.getAnterior().getElemento()) > 0) {
            no.setAnterior(rotacaoEsquerda(no.getAnterior())); // Rotação dupla à direita
            return rotacaoDireita(no);
        }

        if(fatorBalanceamento < -1 && elemento.compareTo(no.getProximo().getElemento()) < 0) {
            no.setProximo(rotacaoDireita(no.getProximo())); // Rotação dupla à esquerda
            return rotacaoEsquerda(no);
        }

        return no; // Retorna o nó
    }

    @Override
    public void remover(T elemento) {
        raiz = removerRecursivo(raiz, elemento); // Chama o método recursivo de remoção
    }

    private No<T> removerRecursivo(No<T> no, T elemento) {
        if (no == null) {
            return no; // Se o nó for nulo, retorna o nó
        }

        if (elemento.compareTo(no.getElemento()) < 0) {
            no.setAnterior(removerRecursivo(no.getAnterior(), elemento));
        } else if (elemento.compareTo(no.getElemento()) > 0) {
            no.setProximo(removerRecursivo(no.getProximo(), elemento));
        } else {
            if (no.getAnterior() == null || no.getProximo() == null) {
                No<T> temp = (no.getAnterior() != null) ? no.getAnterior() : no.getProximo(); // Se o nó tiver apenas um filho, o nó temporário recebe o filho

                if (temp == null) {
                    temp = no;
                    no = null; // Se o nó não tiver filhos, o nó temporário recebe o nó e o nó recebe nulo
                } else {
                    no.setElemento(temp.getElemento()); // Se o nó tiver apenas um filho, o elemento do nó recebe o elemento do nó temporário
                    no.setAnterior(null);
                    no.setProximo(null);
                }
            } else {
                No<T> temp = encontrarSucessorInOrder(no.getProximo());
                no.setElemento(temp.getElemento());
                no.setProximo(removerRecursivo(no.getProximo(), temp.getElemento()));
            }
        }

        if (no == null) {
            return no;
        }

        no.setAltura(1 + Math.max(obterAltura(no.getAnterior()), obterAltura(no.getProximo())));

        int fatorBalanceamento = obterFatorBalanceamento(no);

        if (fatorBalanceamento > 1 && obterFatorBalanceamento(no.getAnterior()) >= 0) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento > 1 && obterFatorBalanceamento(no.getAnterior()) < 0) {
            no.setAnterior(rotacaoEsquerda(no.getAnterior()));
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && obterFatorBalanceamento(no.getProximo()) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento < -1 && obterFatorBalanceamento(no.getProximo()) > 0) {
            no.setProximo(rotacaoDireita(no.getProximo()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private int obterFatorBalanceamento(No<T> no) {
        if(no == null) {
            return 0; // Se o nó for nulo, retorna 0
        }

        return obterAltura(no.getAnterior()) - obterAltura(no.getProximo()); // Retorna o fator de balanceamento do nó
    }

    private No<T> rotacaoDireita(No<T> y) {
        No<T> x = y.getAnterior(); // Nó x recebe o nó anterior de y
        No<T> T2 = x.getAnterior(); // Nó T2 recebe o nó anterior de x

        x.setProximo(y); // O nó x passa a ser o nó anterior de y
        y.setAnterior(T2); // O nó y passa a ser o nó anterior de T2

        y.setAltura(1 + Math.max(obterAltura(y.getAnterior()), obterAltura(y.getProximo()))); // Atualiza a altura de y
        x.setAltura(1 + Math.max(obterAltura(x.getAnterior()), obterAltura(x.getProximo()))); // Atualiza a altura de x

        return x; // Retorna o nó x
    }

    private No<T> rotacaoEsquerda(No<T> x) {
        No<T> y = x.getProximo(); // Nó y recebe o nó próximo de x
        No<T> T2 = y.getAnterior(); // Nó T2 recebe o nó anterior de y

        y.setAnterior(x); // O nó y passa a ser o nó anterior de x
        x.setProximo(T2); // O nó x passa a ser o nó anterior de T2

        x.setAltura(1 + Math.max(obterAltura(x.getAnterior()), obterAltura(x.getProximo()))); // Atualiza a altura de x
        y.setAltura(1 + Math.max(obterAltura(y.getAnterior()), obterAltura(y.getProximo()))); // Atualiza a altura de y

        return y; // Retorna o nó y
    }

    private No<T> encontrarSucessorInOrder(No<T> no) {
        while (no.getAnterior() != null) {
            no = no.getAnterior();
        }
        return no;
    }
}
