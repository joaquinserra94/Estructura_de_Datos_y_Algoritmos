package ejer2;
import java.util.ArrayList;
import java.util.Scanner;

interface Cola<E>
{
 void encolar(E x);
 void desencolar();
 E frente(); // devolver el frente de la cola
 boolean estaVacia();
 void convertirVacia();
 int numElem();
 String toString(); // para poder imprimir la cola comenzando con el frente de la cola
} 



interface Pila<E> {
	// Método para apilar (agregar) un elemento a la pila
    void apilar(E x);
    
    // Método para desapilar (eliminar) el elemento del tope de la pila
    void desapilar();

    // Método para obtener el elemento del tope de la pila sin eliminarlo
    E tope();

    // Método para determinar si la pila está vacía
    boolean estaVacia();

    // Método para vaciar la pila
    void convertirVacia();

    // Método para obtener el número de elementos de la pila
    int numElem();

    // Método para obtener los elementos de la pila en forma de ArrayList
    ArrayList<E> toArrayList();
}



class PilaArrayList<E> implements Pila<E> {
	
	// ArrayList para almacenar los elementos de la pila
    private ArrayList<E> elementos;

    // Constructor de la clase
    public PilaArrayList() {
        elementos = new ArrayList<>();
    }

    // Método para apilar (agregar) un elemento a la pila
    public void apilar(E x) {
        elementos.add(x);
    }

    // Método para desapilar (eliminar) el elemento del tope de la pila
    public void desapilar() {
        elementos.remove(elementos.size() - 1);
    }

    // Método para obtener el elemento del tope de la pila sin eliminarlo
    public E tope() {
        return elementos.get(elementos.size() - 1);
    }

    // Método para determinar si la pila está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Método para vaciar la pila
    public void convertirVacia() {
        elementos.clear();
    }

    // Método para obtener el número de elementos de la pila
    public int numElem() {
        return elementos.size();
    }

    // Método para obtener los elementos de la pila en forma de ArrayList
    public ArrayList<E> toArrayList() {
        return elementos;
    }
}



public class ColaConDosPilas<E> implements Cola<E> {
	  private Pila<E> pila1;
	  private Pila<E> pila2;

	  public ColaConDosPilas() {
	    // Usamos ArrayList para implementar las pilas
	    pila1 = new PilaArrayList<>();
	    pila2 = new PilaArrayList<>();
	  }

	  public void encolar(E x) {
	    // O(1)
	    // Desempilamos todos los elementos de la pila1 y los empilamos en la pila2
	    // O(n), donde n es el número de elementos en la pila1
	    while (!pila1.estaVacia()) {
	      pila2.apilar(pila1.tope());
	      pila1.desapilar();
	    }
	    // O(1)
	    // Agregamos el nuevo elemento en la pila1
	    pila1.apilar(x);
	    // O(n), donde n es el número de elementos en la pila2
	    // Desempilamos todos los elementos de la pila2 y los empilamos en la pila1
	    while (!pila2.estaVacia()) {
	      pila1.apilar(pila2.tope());
	      pila2.desapilar();
	    }
	  }

	  public void desencolar() {
	    // O(1)
	    // Desempilamos el elemento del tope de la pila1
	    pila1.desapilar();
	  }

	  public E frente() {
	    // O(1)
	    // El elemento del tope de la pila1 es el frente de la cola
	    return pila1.tope();
	  }

	  public boolean estaVacia() {
	    // O(1)
	    // La cola está vacía si la pila1 está vacía
	    return pila1.estaVacia();
	  }

	  public void convertirVacia() {
	    // O(n), donde n es el número de elementos en la pila1
	    // Vaciamos la pila1
	    while (!pila1.estaVacia()) {
	      pila1.desapilar();
	    }
	  }

	  public int numElem() {
	    // O(1)
	    // Devolvemos el número de elementos de la pila1
	    return pila1.numElem();
	  }

	  public String toString() {
	    // O(n), donde n es el número de elementos en la pila1
	    // Creamos una cadena con los elementos de la pila1, comenzando por el tope
	    StringBuilder sb = new StringBuilder();
	    Pila<E> temp = new PilaArrayList<>();
	    while (!pila1.estaVacia()) {
	    	E elem = pila1.tope();
	    	sb.append(elem).append(" ");
	    	temp.apilar(elem);
	    	pila1.desapilar();
	    	}
	    	// O(n), donde n es el número de elementos en la pila temp
	    	// Devolvemos los elementos a la pila1
	    	while (!temp.estaVacia()) {
	    	pila1.apilar(temp.tope());
	    	temp.desapilar();
	    	}
	    	// O(1)
	    	return sb.toString();
	    	
	  }
	    	
	  
	  
    public static void main(String[] args) {
        // Creamos una cola de String
        Cola<String> cola = new ColaConDosPilas<String>();

        Scanner sc = new Scanner(System.in);

        // Leemos por consola los elementos de la cola
        System.out.println("Ingresa los elementos de la cola (separados por espacios):");
        String[] elementos = sc.nextLine().split(" ");

        // Encolamos cada elemento en la cola
        for (String elemento : elementos) {
            cola.encolar(elemento);
        }

        // Imprimimos el estado de la cola
        System.out.println("Estado de la cola:");
        System.out.println(cola);

        // Desencolamos el primer elemento de la cola
        cola.desencolar();
        System.out.println("Desencolamos el primer elemento:");
        System.out.println(cola);

        // Obtenemos el frente de la cola
        String frente = cola.frente();
        System.out.println("El frente de la cola es: " + frente);

        // Comprobamos si la cola está vacía
        if (cola.estaVacia()) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("La cola no está vacía");
        }

        // Vaciamos la cola
        cola.convertirVacia();
        System.out.println("Vaciamos la cola");
        System.out.println(cola);

        // Cerramos el Scanner
        sc.close();
    }
}
