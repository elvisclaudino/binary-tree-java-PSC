package ABB;

public class NoABB<T> {
    private T elemento;
    private NoABB<T> proximo;
    private NoABB<T> anterior;

    public NoABB(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public NoABB(T elemento, NoABB<T> proximo, NoABB<T> anterior) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public T getElemento() {
        return this.elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoABB<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(NoABB<T> proximo) {
        this.proximo = proximo;
    }

    public NoABB<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoABB<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                ", anterior=" + anterior +
                '}';
    }
}
