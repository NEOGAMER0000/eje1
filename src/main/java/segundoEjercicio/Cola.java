package segundoEjercicio;


class Persona {
    int codigo;
    String nombre;
    String telefono;
    int edad;

    Persona(int codigo, String nombre, String telefono, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "(" + codigo + ", " + nombre + ", " + telefono + ", " + edad + ")";
    }
}

public class Cola {
    class Nodo {
        Persona persona;
        Nodo siguiente;
    }

    private Nodo raiz, ultimo;
    private int tamano;

    Cola() {
        raiz = null;
        ultimo = null;
        tamano = 0;
    }

    boolean vacia() {
        return raiz == null;
    }

    void insertar(Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.persona = persona;
        nuevo.siguiente = null;
        if (vacia()) {
            raiz = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamano++;
    }

    Persona extraer() {
        if (!vacia()) {
            Persona persona = raiz.persona;
            if (raiz == ultimo) {
                raiz = null;
                ultimo = null;
            } else {
                raiz = raiz.siguiente;
            }
            tamano--;
            return persona;
        } else {
            return null;
        }
    }

    public void mostrar() {
        Nodo reco = raiz;
        System.out.println("Los elementos de la lista son:");
        while (reco != null) {
            System.out.print(reco.persona + ", ");
            reco = reco.siguiente;
        }
        System.out.println();
    }

    public int contar() {
        return tamano;
    }

    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.insertar(new Persona(1010, "Pedro", "123456", 15));
        cola.insertar(new Persona(1011, "María", "654321", 21));
        cola.insertar(new Persona(1012, "Daniela", "321654", 25));
        cola.insertar(new Persona(1013, "Carlos", "456321", 30));

        cola.mostrar();
        Persona personaEliminada = cola.extraer();
        System.out.println("Se ha eliminado el elemento " + personaEliminada + ".");
        cola.mostrar();

        int tamanoActual = cola.contar();
        System.out.println("Hay " + tamanoActual + " elementos en la lista.");
    }
}
