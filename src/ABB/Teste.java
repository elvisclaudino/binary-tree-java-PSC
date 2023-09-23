package ABB;

public class Teste {
    public static void main (String[] args) {
        ArvoreABB<Integer> arvore = new ArvoreABB<>();

        arvore.inserir(10);
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

        int valorBuscado = 12;
        boolean resultadoBusca = arvore.buscar(valorBuscado);
        if (resultadoBusca) {
            System.out.println("O valor " + valorBuscado + " foi encontrado na árvore.");
        } else {
            System.out.println("O valor " + valorBuscado + " não foi encontrado na árvore.");
        }

//        int valorRemovido = 15;
//        arvore.remover(valorRemovido);
//        System.out.println("O valor " + valorRemovido + " foi removido da árvore.");

        System.out.println("Árvore binária de busca:");
        arvore.imprimir();
    }
}
