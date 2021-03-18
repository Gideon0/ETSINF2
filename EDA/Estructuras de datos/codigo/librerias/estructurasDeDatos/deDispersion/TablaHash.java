package librerias.estructurasDeDatos.deDispersion;

import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.lineales.LEGListaPI;
import librerias.estructurasDeDatos.modelos.ListaPI;

public class TablaHash<V,C> implements Map<C,V> {
    protected NodeHash<C,V> elArray []; //CUBETAS
    protected int talla;

    @SuppressWarnings("unchecked")
    public TablaHash(int numCubetas) {
        elArray = new NodeHash[numCubetas];
        talla = 0;
    }

    private int f_hash(C clave) {
        int valor_hash = clave.hashCode();
        if (valor_hash < 0)
            valor_hash = - valor_hash;
        return valor_hash % elArray.length;
    }

    @SuppressWarnings("unchecked")
    public V insertar(C clave, V valor) {
        V res = null;
        int cub = f_hash(clave);

        NodeHash<C,V> aux = elArray[cub];

        while(aux != null && !clave.equals(aux.clave))
            aux = aux.sig;

        if (aux == null) {
            elArray[cub] = new NodeHash(clave,valor,elArray[cub]);
            talla++;
        }
        else {
            res = aux.valor;
            aux.valor = valor;
        }
        return res;
    }

    public V eliminar(C clave) {
        int cub = f_hash(clave);
        V res = null;

        NodeHash<C,V> aux = elArray[cub];
        NodeHash<C,V> aux_ant = null;
        while(aux != null && !clave.equals(aux.clave)){
            aux_ant = aux;
            aux = aux.sig;
        }
        if (aux != null){
            res = aux.valor;
            if (aux_ant == null)
                elArray[cub] = aux.sig;
            else
                aux_ant.sig = aux.sig;
            talla --;
        }
        return res;
    }

    public V recuperar(C clave) {
        int cub = f_hash(clave);

        NodeHash<C,V> aux = elArray[cub];
        while(aux != null && !clave.equals(aux.clave))
            aux = aux.sig;
        
        if (aux == null)
            return null;
        return aux.valor;
    }

    public boolean esVacia() {
        return talla == 0;
    }

    public int talla() {
        return talla;
    }

    public ListaPI<C> claves() {
        ListaPI<C> lista = new LEGListaPI<C>();

        for (int cub = 0; cub < elArray.length; cub++) {
            NodeHash<C,V> aux = elArray[cub];
            while (aux != null) {
                lista.insertar(aux.clave);
                aux = aux.sig;
            }
        }
        return lista;
    }
    
    public float factor_carga(){
        return talla / (float) elArray.length; 
    }

    public float varianza(){
        float media = factor_carga();
        float suma = 0;

        for (int cub = 0; cub < elArray.length; cub++){
            NodeHash<C,V> aux = elArray[cub];
            int cont = 0;
            while(aux != null){
                cont++;
                aux = aux.sig;
            }
            suma += (cont - media) *(cont -media); 
        }
        return suma/elArray.length;
    }
    
    @SuppressWarnings("unchecked")
    private void rehasing(){
        NodeHash<C,V> old[] = elArray;
        
        elArray = new NodeHash[elArray.length * 2];
        talla = 0;

        for (int cub = 0; cub < old.length; cub++){
            NodeHash<C,V> aux = old[cub];
            while (aux != null){
                insertar(aux.clave, aux.valor);
                aux = aux.sig;
            }
        }
    }
}
