package primerEjercicio;

import java.util.*;

public class Lista {
    class Nodo {
        int informacion;
        Nodo siguiente;
    }
    private Nodo raiz;
    private int cantidad;
    private int suma;
    private int ultimo;

    public Lista() {
        raiz = null;
        cantidad = 0;
        suma = 0;
        ultimo = 0;
    }

    public void insertar(int x) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.informacion = x;
        if (raiz == null) {
            nuevo.siguiente = null;
            raiz = nuevo;
        } else {
            nuevo.siguiente = raiz;
            raiz = nuevo;
        }
        cantidad++;
        suma += x;
        ultimo = x;
    }

    public void imprimir() {
        Nodo record = raiz;
        System.out.println("Los datos de la lista son:");
        while (record != null) {
            System.out.print(record.informacion + ",");
            record = record.siguiente;
        }
        System.out.println();
    }

    public int contarPares() {
        int pares = 0;
        Nodo record = raiz;
        while (record != null) {
            if (record.informacion % 2 == 0) {
                pares++;
            }
            record = record.siguiente;
        }
        return pares;
    }

    public double promedio() {
        return (double) suma / cantidad;
    }

    public int ultimoDato() {
        return ultimo;
    }

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        Lista lista1 = new Lista();

        System.out.print("Ingrese la cantidad de elementos a insertar: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el elemento " + i + ": ");
            int elemento = sc.nextInt();
            lista1.insertar(elemento);
        }

        lista1.imprimir();
        System.out.println("La cantidad de números pares es: " + lista1.contarPares());
        System.out.printf("El promedio es: %.2f\n", lista1.promedio());
        System.out.println("El último dato de la lista es: " + lista1.ultimoDato());
    }
}
