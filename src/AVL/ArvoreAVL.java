package AVL;

public class ArvoreAVL<T extends Comparable<T>> {
    private NoAVL<T> raiz; // Nó raiz da árvore

    public void inserir(T elemento) { // Insere um elemento na árvore
        this.raiz = inserirRecursivo(raiz, elemento); // Chama o método recursivo de inserção
    }

    private NoAVL<T> inserirRecursivo(NoAVL<T> no, T elemento) {
        if (no == null) {
            return new NoAVL<>(elemento); // Se o nó for nulo, cria um novo nó com o elemento
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

    private int obterAltura(NoAVL<T> no) {
        return (no == null) ? 0 : no.getAltura(); // Retorna a altura do nó
    }

    private int obterFatorBalanceamento(NoAVL<T> no) {
        if(no == null) {
            return 0; // Se o nó for nulo, retorna 0
        }

        return obterAltura(no.getAnterior()) - obterAltura(no.getProximo()); // Retorna o fator de balanceamento do nó
    }

    private NoAVL<T> rotacaoDireita(NoAVL<T> y) {
        NoAVL<T> x = y.getAnterior(); // Nó x recebe o nó anterior de y
        NoAVL<T> T2 = x.getAnterior(); // Nó T2 recebe o nó anterior de x

        x.setProximo(y); // O nó x passa a ser o nó anterior de y
        y.setAnterior(T2); // O nó y passa a ser o nó anterior de T2

        y.setAltura(1 + Math.max(obterAltura(y.getAnterior()), obterAltura(y.getProximo()))); // Atualiza a altura de y
        x.setAltura(1 + Math.max(obterAltura(x.getAnterior()), obterAltura(x.getProximo()))); // Atualiza a altura de x

        return x; // Retorna o nó x
    }

    private NoAVL<T> rotacaoEsquerda(NoAVL<T> x) {
        NoAVL<T> y = x.getProximo(); // Nó y recebe o nó próximo de x
        NoAVL<T> T2 = y.getAnterior(); // Nó T2 recebe o nó anterior de y

        y.setAnterior(x); // O nó y passa a ser o nó anterior de x
        x.setProximo(T2); // O nó x passa a ser o nó anterior de T2

        x.setAltura(1 + Math.max(obterAltura(x.getAnterior()), obterAltura(x.getProximo()))); // Atualiza a altura de x
        y.setAltura(1 + Math.max(obterAltura(y.getAnterior()), obterAltura(y.getProximo()))); // Atualiza a altura de y

        return y; // Retorna o nó y
    }

    public boolean buscar(T elemento) {
        return buscarRecursivo(raiz, elemento); // Chama o método recursivo de busca
    }

    private boolean buscarRecursivo(NoAVL<T> no, T elemento) { // Método recursivo de busca
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

    public void imprimir() {
        imprimirRecursivo(raiz, 0); // Chama o método recursivo de impressão
    }

    private void imprimirRecursivo(NoAVL<T> no, int nivel) { // Método recursivo de impressão
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
