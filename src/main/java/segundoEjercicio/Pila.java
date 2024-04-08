package segundoEjercicio;


public class Pila {

    public static class Persona {
        private int codigo;
        private String nombre;
        private int telefono;
        private int edad;

        public Persona(int codigo, String nombre, int telefono, int edad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.telefono = telefono;
            this.edad = edad;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getTelefono() {
            return telefono;
        }

        public int getEdad() {
            return edad;
        }
    }
    class Nodo {
        Persona informacion;
        Nodo siguiente;
    }

    private Nodo raiz;
    private int tamano;

    public Pila() {
        raiz = null;
        tamano = 0;
    }

    public void insertar(Persona persona) {
        Nodo nuevo = new Nodo();
        nuevo.informacion = persona;
        if (raiz == null) {
            nuevo.siguiente = null;
            raiz = nuevo;
        } else {
            nuevo.siguiente = raiz;
            raiz = nuevo;
        }
        tamano++;
    }

    public void imprimir() {
        Nodo record = raiz;
        System.out.println("Los elementos de la lista son:");
        while (record != null) {
            System.out.println("(" + record.informacion.getCodigo() +
                    ", " + record.informacion.getNombre() +
                    ", " + record.informacion.getTelefono() +
                    ", " + record.informacion.getEdad() + ")");
            record = record.siguiente;
        }
    }

    public void extraer() {
        if (raiz != null) {
            raiz = raiz.siguiente;
            tamano--;
        }
    }

    public int contarElementos() {
        return tamano;
    }

    public static void main(String[] ar) {
        Pila pila1 = new Pila();

        Persona persona1 = new Persona(1010, "Pedro", 123456, 15);
        Persona persona2 = new Persona(1011, "María", 654321, 21);
        Persona persona3 = new Persona(1012, "Daniela", 321654, 25);
        Persona persona4 = new Persona(1013, "Carlos", 456321, 30);

        pila1.insertar(persona1);
        pila1.insertar(persona2);
        pila1.insertar(persona3);
        pila1.insertar(persona4);
        pila1.imprimir();

        System.out.println("\nEliminamos un elemento de la pila:");
        pila1.extraer();
        pila1.imprimir();

        System.out.println("\nEl número de elementos restantes en la pila es: " + pila1.contarElementos());
    }
}