package AVL;

public class NoAVL<T> {
    private T elemento;
    private NoAVL<T> proximo;
    private NoAVL<T> anterior;
    private int altura;

    public NoAVL(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
        this.altura = 1;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoAVL<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoAVL<T> proximo) {
        this.proximo = proximo;
    }

    public NoAVL<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoAVL<T> anterior) {
        this.anterior = anterior;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "NoAVL{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                ", anterior=" + anterior +
                ", altura=" + altura +
                '}';
    }
}
