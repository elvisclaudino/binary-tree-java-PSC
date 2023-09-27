package EstrutaArvore;

public interface Metodos<T> {
    public void inserir(T elemento);
    public boolean buscar(T elemento);
    public void remover(T elemento);
    public void imprimir();
}
