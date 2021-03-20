package librerias.estructurasDeDatos.deDispersion;

public class NodeHash<C,V> {
    C clave;
    V valor;
    NodeHash<C,V> sig;

    public NodeHash(C clave, V valor, NodeHash<C,V> sig) {
        this.clave = clave;
        this.valor = valor;
        this.sig = sig;
    }
}
