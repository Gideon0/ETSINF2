package librerias.estructurasDeDatos.modelos;

public interface Map<C,V> {
    V insertar(C clave, V valor);
    V eliminar(C clave);
    V recuperar(C clave);
    boolean esVacia();
    int talla();
    ListaPI<C> claves();    
}
