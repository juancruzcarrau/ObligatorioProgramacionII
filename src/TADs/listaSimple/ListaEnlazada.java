package TADs.listaSimple;

import TADs.Lista;

import TADs.heap.*;

public class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {

    private Nodo<T> first;
    private Nodo<T> last;
    private int size = 0;

    public ListaEnlazada() {
        this.first = null;
        this.last = null;
    }

    public int posicionFromValue (T value) throws NullPointerException {
        int pos = 1;

        if (first.getValue() == value) {
            return 1;
        }

        else if (last.getValue() == value) {
            return size;
        }

        else {
            Nodo<T> temp = first;
            while(temp.getValue() != value) {
                pos++;
                if (pos == size + 1) {
                    throw new NullPointerException();
                }
                temp = temp.getNextValue();
            }
        }

        return pos;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 1; i < size + 1; i++) {
            str = str + "Elemento " + i + ": " + get(i).getValue() + "." + "\n";
        }
        return str;
    }

    @Override
    public void add(T value) {
        Nodo<T> newNodo = new Nodo<T>(value);

        if (this.first == null && this.last == null) {
            this.first = newNodo;
            this.last = newNodo;
        }

        else {
            this.last.setNextValue(newNodo);
            this.last = newNodo;
        }

        size++;
    }

    @Override
    public void remove(int position) throws IndexOutOfBoundsException {

        if (size == 0 || position > size || position < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        else {

            if (position == 1) {
                if (size == 1) {
                    first = null;
                    last = null;
                }
                else {
                    first = first.getNextValue();
                }
            }

            else if (position == size) {
                Nodo<T> test = first;
                int i = 1;
                while (i != position - 1) {
                    test = test.getNextValue();
                    i += 1;
                }
                last = test;
            }

            else {
                Nodo<T> temp = first;
                int i = 1;
                while (i != position - 1) {
                    temp = temp.getNextValue();
                    i += 1;
                }
                temp.setNextValue(temp.getNextValue().getNextValue()); // ENLAZO EL ANTERIOR CON EL SIGUIENTE
            }
        }
        size--;
    }

    @Override
    public Nodo<T> get(int position) throws IndexOutOfBoundsException {
        if (position <= 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }

        else if (position == 1) {
            return first;
        }

        else if (position == size) {
            return last;
        }

        else {

            Nodo<T> temp = first;
            int i = 1;

            while (i != position) {
                temp = temp.getNextValue();
                i++;
            }

            return temp;
        }

    }

    @Override
    public Boolean find(T value) {

        if (first.getValue() == value) {
            return true;
        }

        else {
            Nodo<T> temp = first;
            int i = 1;

            while (temp.getValue() != value) {
                i++;

                if (i == size + 1) {
                    return false;
                }

                temp = temp.getNextValue();
            }

            return true;
        }
    }

    public void addFirst (T value) {
        Nodo<T> newNodo = new Nodo<T>(value);

        if (size == 0) {
            last = newNodo;
        }

        else {
            newNodo.setNextValue(first);
        }

        first = newNodo;
        size++;
    }

    public void addLast (T value) {
        Nodo<T> newNodo = new Nodo<T>(value);
        add(value);
    }

    public int size() {
        return size;
    }

    public void BubbleSort () {
        // EN EL MEJOR DE LOS CASOS ES DE ORDEN N. EN EL PEOR ES N2.
        // ES MAS EFICIENTE QUE OTROS ALGORITMOS PORQUE SOLAMENTE SE RESERVAN ESPACIOS TEMPORALES PARA NODOS.

        for (int i = 1; i < size + 1; i++) {
            int count = 0;
            for (int j = 1; j < size-i-1; j++){

                if (first.getValue().compareTo(this.get(2).getValue()) > 0) {
                    T temp1 = first.getValue();
                    T temp2 = this.get(2).getValue();

                    first.setValue(temp2);
                    this.get(2).setValue(temp1);
                    count = 1;
                }

                if (this.get(size-1).getValue().compareTo(last.getValue()) > 0){
                    T temp1 = this.get(size-1).getValue();
                    T temp2 = last.getValue();

                    this.get(size-1).setValue(temp2);
                    last.setValue(temp1);
                    count = 1;
                }

                else {
                    T elem1 = this.get(j).getValue();
                    T elem2 = this.get(j+1).getValue();
                    if (elem1.compareTo(elem2) > 0) {
                        this.get(j-1).setNextValue(get(j+1));
                        this.get(j+1).setNextValue(get(j));
                        this.get(j).setNextValue(get(j+2));
                        count = 1;
                    }
                }

                if (count == 1) { // O SEA QUE ENTRO A ALGUNO DE LOS IF (HUBO SWAP(S))
                    return; // TERMINO EL METODO
                }

            }
        }
    }

    public void trasposicionParImpar () {
        for (int i = 1; i < size + 1; i++) {
            int count1 = 0;
            for (int j = 1; j < size-i-1; j=j+2){

                if (first.getValue().compareTo(this.get(2).getValue()) > 0) {
                    T temp1 = first.getValue();
                    T temp2 = this.get(2).getValue();

                    first.setValue(temp2);
                    this.get(2).setValue(temp1);
                    count1 = 1;
                }

                if (this.get(size-1).getValue().compareTo(last.getValue()) > 0){
                    T temp1 = this.get(size-1).getValue();
                    T temp2 = last.getValue();

                    this.get(size-1).setValue(temp2);
                    last.setValue(temp1);
                    count1 = 1;
                }

                else {
                    T elem1 = this.get(j).getValue();
                    T elem2 = this.get(j+1).getValue();
                    if (elem1.compareTo(elem2) > 0) {
                        this.get(j-1).setNextValue(get(j+1));
                        this.get(j+1).setNextValue(get(j));
                        this.get(j).setNextValue(get(j+2));
                        count1 = 1;
                    }
                }

                if (count1 == 1) { // O SEA QUE ENTRO A ALGUNO DE LOS IF (HUBO SWAP(S))
                    return; // TERMINO EL METODO
                }

            }

            int count2 = 0;
            for (int j = 2; j < size-i-1; j=j+2){

                if (first.getValue().compareTo(this.get(2).getValue()) > 0) {
                    T temp1 = first.getValue();
                    T temp2 = this.get(2).getValue();

                    first.setValue(temp2);
                    this.get(2).setValue(temp1);
                    count2 = 1;
                }

                if (this.get(size-1).getValue().compareTo(last.getValue()) > 0){
                    T temp1 = this.get(size-1).getValue();
                    T temp2 = last.getValue();

                    this.get(size-1).setValue(temp2);
                    last.setValue(temp1);
                    count2 = 1;
                }

                else {
                    T elem1 = this.get(j).getValue();
                    T elem2 = this.get(j+1).getValue();
                    if (elem1.compareTo(elem2) > 0) {
                        this.get(j-1).setNextValue(get(j+1));
                        this.get(j+1).setNextValue(get(j));
                        this.get(j).setNextValue(get(j+2));
                        count2 = 1;
                    }
                }

                if (count2 == 1) { // O SEA QUE ENTRO A ALGUNO DE LOS IF (HUBO SWAP(S))
                    return; // TERMINO EL METODO
                }

            }

        }
    }

    public void swap (int position1, int position2) {
        if (position1 <= 0 || position2 <= 0 || position1 > size || position2 > size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            T temp1 = this.get(position1).getValue();
            this.get(position1).setValue(this.get(position2).getValue());
            this.get(position2).setValue(temp1);
        }
    }

    public void ordenarPorSeleccion() {
        // mejor caso: N, peor caso: N2
        // es mejor con pocos elementos dado su BigO
        for (int i = 1; i < this.size; i++) {

            T temp = this.get(i).getValue();

            for (int j = i + 1; j < this.size + 1; j++) {
                if (temp.compareTo(this.get(j).getValue()) > 0) {
                    this.swap(i,j);
                }
            }

        }
    }

    public void ordenarPorInsercion() {
        // mejor caso: N, peor caso: N2
        for (int i = 2; i < this.size + 1; i++) {

            T temp = this.get(i).getValue();

            for (int j = 1; j < i; j++) {
                while (this.get(j).getValue().compareTo(temp) > 0) {
                    this.swap(i,j);
                }
            }

        }
    }

    public ListaEnlazada<T> heapSort(int orden) { // tipo 1: descendente (heap maximo), tipo 2: ascendente (min)
        // mejor caso: BigO(n)
        // peor caso: BigO(nlogn)

        try {
            HeapImpl<T> heap = new HeapImpl<>(this.size(), orden);
            ListaEnlazada<T> sorted = new ListaEnlazada<>();


            for (int i = 1; i < this.size() + 1; i++) {
                heap.insert(this.get(i).getValue());
            }

            for (int i = 0; i < this.size(); i++) {
                T temp = heap.delete();
                sorted.add(temp);
            }

            return sorted;
        }

        catch (EmptyHeapException e) {
            System.out.println("Estructura vacia");
        }

        return null;

    }

    public void addSorted (T value) {
        add(value);
        ordenarPorInsercion();
    }

    public void visualizar () {
        for (int i = 1; i < this.size + 1; i++) {
            int posicion = (Integer) this.get(i).getValue();
            System.out.println(this.get(posicion).toString());
        }
    }

    public void exchange (T value, int dir) throws IndexOutOfBoundsException, NullPointerException { // DIR POR DIRECCION
        int pos = posicionFromValue(value);

        if (dir != -1 && dir != 1) {
            throw new IndexOutOfBoundsException();
        }
        else if (! find(value)) {
            throw new NullPointerException();
        }

        else if (pos == 1 && dir == -1) {
            throw new NullPointerException();
        }

        else if (pos == 1 && dir == 1) {
            T temp1 = first.getValue();
            T temp2 = get(2).getValue();

            first.setValue(temp2);
            get(2).setValue(temp1);
        }

        else if (pos == 2 && dir == -1) {
            T temp1 = first.getValue();
            T temp2 = get(2).getValue();

            first.setValue(temp2);
            get(2).setValue(temp1);
        }

        else if (pos == size && dir == 1) {
            throw new NullPointerException();
        }

        else if (pos == size && dir == -1) {
            T temp1 = get(size-1).getValue();
            T temp2 = last.getValue();

            get(size-1).setValue(temp2);
            last.setValue(temp1);
        }

        else if (pos == size-1 && dir == 1) {
            T temp1 = get(size-1).getValue();
            T temp2 = last.getValue();

            get(size-1).setValue(temp2);
            last.setValue(temp1);
        }

        else {
            if (dir == 1) {
                T temp1 = get(pos).getValue();
                T temp2 = get(pos + 1).getValue();

                get(pos).setValue(temp2);
                get(pos + 1).setValue(temp1);
            }

            if (dir == -1) {
                T temp1 = get(pos - 1).getValue();
                T temp2 = get(pos).getValue();

                get(pos - 1).setValue(temp2);
                get(pos).setValue(temp1);
            }

        }
    }

    public ListaEnlazada<T> both (ListaEnlazada<T> lista) {
        ListaEnlazada<T> total = new ListaEnlazada<T>();

        for (int i = 1; i < size() + 1; i++) {
            for (int j = 1; j < lista.size() + 1; j++){
                if (get(i).getValue() == lista.get(j).getValue()) {
                    total.add(get(i).getValue());
                }
            }
        }
        return total;
    }

    public ListaEnlazada<T> notBoth (ListaEnlazada<T> lista) {
        ListaEnlazada<T> total = new ListaEnlazada<T>();

        for (int i = 1; i < size + 1; i++){ // AGREGO TODOS LOS DE UNA QUE NO ESTEN EN LA OTRA
            int temp = 0;

            for (int j = 1; j < lista.size() + 1; j++) {
                if (get(i).getValue() != lista.get(j).getValue()) {
                    temp++;
                }
            }
            if (temp == size) {
                total.add(get(i).getValue());
            }

        }

        for (int i = 1; i < lista.size + 1; i++){ // AGREGO TODOS LOS DE LA OTRA QUE NO ESTAN EN LA PRIMERA
            int temp = 0;

            for (int j = 1; j < size + 1; j++) {
                if (lista.get(i).getValue() != get(j).getValue()) {
                    temp++;
                }
            }
            if (temp == size) {
                total.add(lista.get(i).getValue());
            }

        }
        return total;
    }

    public ListaEnlazada<Integer> listaPositivos() {             // EJERCICIO 11)a
        ListaEnlazada<Integer> positivos = new ListaEnlazada<Integer>();
        for (int i = 1; i < size() + 1; i++) {
            if ((Integer) get(i).getValue() >= 0) {
                positivos.add((Integer) get(i).getValue());
            }
        }
        return positivos;
    }

    public void eliminarNodosPositivos() {              // EJERCICIO 11)b
        while ((Integer) first.getValue() >= 0) {
            remove(1);
        }
        for (int i = 1; i < size() + 1; i++) {
            if ((Integer) get(i).getValue() >= 0) {
                remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> test = new ListaEnlazada<>();
        test.add(24);
        test.add(23);
        test.add(28);
        test.add(27);

        System.out.println(test.toString());
        ListaEnlazada<Integer> lista = test.heapSort(2);
        System.out.println(lista.toString());

        //ListaEnlazada<Integer> test2 = new ListaEnlazada<>();
        //test2.add(2);
        //test2.add(3);
        //test2.add(27);

        //System.out.println(test.notBoth(test2).toString());

        //System.out.println(test.toString());
        //test.eliminarNodosPositivos();
        //System.out.println(test.toString());

        //test.exchange(27,1);
        //ListaEnlazada<Integer> test2 = new ListaEnlazada<>();
        //test.add(24);
        //test.add(23);
        //test.add(25);

        //System.out.println(test.both(test2).size);
        //System.out.println(test.both(test2).toString());

        //test.exchange(23,-1);

        //System.out.println(test.find(23));
        //System.out.println(test.first.getValue());
        //test.remove(1);
        //System.out.println(test.first.getValue());
        //System.out.println(test.find(24));
        //System.out.println(test.size());
        //System.out.println(test.find(24));
    }

}