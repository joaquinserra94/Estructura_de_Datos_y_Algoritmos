//Hacer un método de la clase BinarySearchTree que cuente las hojas de un árbol binario de búsqueda

public class BinarySearchTree {
    private BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int x) {
        root = insert(x, root);
    }

    private BinaryNode insert(int x, BinaryNode t) {
        if (t == null)
            t = new BinaryNode(x);
        else if (x < t.element)
            t.left = insert(x, t.left);
        else if (x > t.element)
            t.right = insert(x, t.right);
        else
            ; // Duplicate; do nothing
        return t;
    }

    public void remove(int x) {
        root = remove(x, root);
    }

    private BinaryNode remove(int x, BinaryNode t) {
        if (t == null)
            return t; // Item not found; do nothing
        if (x < t.element)
            t.left = remove(x, t.left);
        else if (x > t.element)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    public int findMin() {
        if (isEmpty())
            throw new UnderflowException();
        return findMin(root).element;
    }

    private BinaryNode findMin(BinaryNode t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    public int findMax() {
        if (isEmpty())
            throw new UnderflowException();
        return findMax(root).element;
    }

    private BinaryNode findMax(BinaryNode t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    public boolean contains(int x) {
        return contains(x, root);
    }

    private boolean contains(int x, BinaryNode t) {
        if (t == null)
            return false;
        if (x < t.element)
            return contains(x, t.left);
        else if (x > t.element)
            return contains(x, t.right);
        else
            return true;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(BinaryNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public int contarHojas() {
        return contarHojas(root);
    }

    private int contarHojas(BinaryNode t) {
        if (t == null)
            return 0;
        if (t.left == null && t.right == null)
            return 1;
        return contarHojas(t.left) + contarHojas(t.right);
    }

    private static class BinaryNode {
        int element;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(int theElement) {
            element = theElement;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Insertando " + NUMS + " elementos");
        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);
        System.out.println("Contando las hojas");
        System.out.println("Hay " + t.contarHojas() + " hojas");
    }
}

// Path: UnderflowException.java

public class UnderflowException extends RuntimeException {
    public UnderflowException() {
        super();
    }

    public UnderflowException(String message) {
        super(message);
    }
}

// Path: recursividad.java

public class recursividad {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Insertando " + NUMS + " elementos");
        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);
        System.out.println("Contando las hojas");
        System.out.println("Hay " + t.contarHojas() + " hojas");
    }
}

// Path: UnderflowException.java

public class UnderflowException extends RuntimeException {
    public UnderflowException() {
        super();
    }

    public UnderflowException(String message) {
        super(message);
    }
}

// Path: recursividad.java

public class recursividad {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Insertando " + NUMS + " elementos");
        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);
        System.out.println("Contando las hojas");
        System.out.println("Hay " + t.contarHojas() + " hojas");
    }
}

// Path: UnderflowException.java

public class UnderflowException extends RuntimeException {
    public UnderflowException() {
        super();
    }

    public UnderflowException(String message) {
        super(message);
    }
}

// Path: recursividad.java

public class recursividad {
    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        final int NUMS = 4000;
        final int GAP = 37;

        System.out.println("Insertando " + NUMS + " elementos");
        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);
        System.out.println("Contando las hojas");
        System.out.println("Hay " + t.contarHojas() + " hojas");
    }
}
