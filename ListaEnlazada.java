package ejer1;
import java.util.Scanner;

class ListaEnlazada<AnyType> {

	   // Nodo Inicial
	   private Nodo<AnyType> primero;
	   private int tam; // número de elementos de la lista

	   // Constructor de la clase
	   public ListaEnlazada () {
	      this.primero = null;
	      this.tam = 0;
	   }

	   private static class Nodo<AnyType> {
	      private AnyType valor;
	      private Nodo<AnyType> siguiente;

	      public Nodo ( AnyType valor ) {
	         this.valor = valor;
	         this.siguiente = null;
	      }

	      public void setSiguiente (Nodo<AnyType> sig) {
	         this.siguiente = sig;
	      }

	      public void setValor (AnyType valor) {
	    	   this.valor = valor;
	    	}


	      public AnyType getValor () {
	         return this.valor;
	      }

	      public Nodo<AnyType> getSiguiente () {
	         return this.siguiente;
	      }
	   }

	   public void agregarAlFinal(AnyType valor) {
		   Nodo<AnyType> nuevoNodo = new Nodo<>(valor);
		   // Si la lista está vacía, establecemos el nuevo nodo como el nodo inicial de la lista
		   if (this.primero == null) {
		      this.primero = nuevoNodo;
		   } else {
		      // Si la lista no está vacía, recorremos la lista hasta llegar al último nodo
		      Nodo<AnyType> ultimoNodo = this.primero;
		      while (ultimoNodo.getSiguiente() != null) {
		         ultimoNodo = ultimoNodo.getSiguiente();
		      }
		      // Establecemos el nuevo nodo como el siguiente nodo del último nodo
		      ultimoNodo.setSiguiente(nuevoNodo);
		   }
		   // Incrementamos el tamaño de la lista
		   this.tam++;
		}

		public void invertir() {
		   // Establecemos tres variables de tipo Nodo: "anterior", "actual" y "siguiente"
		   Nodo<AnyType> anterior = null;
		   Nodo<AnyType> actual = this.primero;
		   Nodo<AnyType> siguiente = null;

		   // En un ciclo while, mientras "actual" no sea null...
		   while (actual != null) {
		      // Establecemos la variable "siguiente" como el siguiente nodo de "actual"
		      siguiente = actual.getSiguiente();
		      // Establecemos el siguiente nodo de "actual" como "anterior"
		      actual.setSiguiente(anterior);
		      // Establecemos "anterior" como "actual"
		      anterior = actual;
		      // Establecemos "actual" como "siguiente"
		      actual = siguiente;
		   }
		   // Establecemos el nodo inicial de la lista como "anterior"
		   this.primero = anterior;
		}

	   public static void main(String[] args) {
		   ListaEnlazada<Integer> lista = new ListaEnlazada<>();

		   try (// Leemos la lista de enteros por pantalla
		Scanner scanner = new Scanner(System.in)) {
			   System.out.println("Ingresa una lista de enteros (separados por espacios): ");
			String linea = scanner.nextLine();
			   String[] elementos = linea.split(" ");

			   // Agregamos cada elemento a la lista enlazada
			   for (String elemento : elementos) {
			      lista.agregarAlFinal(Integer.parseInt(elemento));
			   }
		}
		   // Invertimos la lista enlazada y la imprimimos
		   lista.invertir();
		   System.out.println("Lista invertida: ");
		   Nodo<Integer> nodoActual = lista.primero;
		   while (nodoActual != null) {
		      System.out.print(nodoActual.getValor() + " ");
		      nodoActual = nodoActual.getSiguiente();
		   }
		}

}