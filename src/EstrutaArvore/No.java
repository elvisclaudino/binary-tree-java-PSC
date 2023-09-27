package EstrutaArvore;
public class No<T> {
    private T elemento;
    private No<T> proximo;
    private No<T> anterior;
    private int altura;

    public No(T elemento) {
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

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
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
