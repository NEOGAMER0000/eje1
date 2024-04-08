package primerEjercicio;

public class Cola {
    class Nodo {
        int informacion;
        Nodo siguiente;
    }
    private Nodo raiz, ultimo;
    private int cantidadPares;
    private int sumaElementos;
    private int ultimoElemento;
    private int cantidadElementos;
    Cola() {
        raiz = null;
        ultimo = null;
        cantidadPares = 0;
        sumaElementos = 0;
        ultimoElemento = 0;
        cantidadElementos = 0;
    }
    boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    void insertar(int info) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.informacion = info;
        nuevo.siguiente = null;
        if (vacia()) {
            raiz = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        if (info % 2 == 0) {
            cantidadPares++;
        }
        sumaElementos += info;
        ultimoElemento = info;
        cantidadElementos++;
    }

    public void mostrar() {
        Nodo reco = raiz;
        System.out.println("Elementos de la cola:");
        while (reco != null) {
            System.out.print(reco.informacion + " ");
            reco = reco.siguiente;
        }
        System.out.println();
    }

    public void mostrarResultados() {
        System.out.println("Los datos de la cola son:");
        mostrar();
        System.out.println("La cantidad de números pares es: " + cantidadPares);
        double promedio = (double) sumaElementos / cantidadElementos;
        System.out.printf("El promedio es: %.2f%n", promedio);
        System.out.println("El último dato de la cola es: " + ultimoElemento);
    }

    public static void main(String[] ar) {
        Cola c1 = new Cola();
        c1.insertar(7);
        c1.insertar(5);
        c1.insertar(3);
        c1.insertar(6);
        c1.insertar(2);
        c1.insertar(9);
        c1.mostrarResultados();
    }
}

