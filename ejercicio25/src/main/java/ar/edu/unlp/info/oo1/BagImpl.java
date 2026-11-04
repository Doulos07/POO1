package ar.edu.unlp.info.oo1;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    /*
    a. Beneficios de usar AbstractCollection:Evita reescribir código repetitivo.
        Al extender AbstractCollection y proveer métodos básicos como iterator() y size(),
        se obtienen gratis implementaciones por defecto de otros métodos de la interfaz Collection.

    b. Ventajas de componer con un Map:Eficiencia en tiempo de ejecución.
        Permite consultar la cantidad de ocurrencias de un elemento, agregarlo o quitarlo en tiempo constante O(1)
        promedio (si se usa HashMap), en lugar de iterar una lista contando repeticiones.

    c. ¿Extender un Map en lugar de componerlo?
        Fallo de diseño. Un Bag es una Collection, no un Map.
        Si BagImpl extendiera de HashMap, expondría métodos como keySet(), values(), o put(K, V)
        que no tienen sentido semántico para una simple bolsa de elementos, violando el principio de encapsulamiento
        y el Principio de Sustitución de Liskov.

    d. Utilidad de un objeto Bag (Multiconjunto):
        Es sumamente útil en escenarios donde importa la frecuencia de elementos pero no su orden.
        Casos típicos incluyen carritos de compras (3 manzanas, 2 peras),
        procesamiento de textos (conteo de palabras en un documento), y generación de histogramas o sistemas de inventario.
    * */

    Map<T, Integer> elements;

    public BagImpl() {
        // TODO Completar con la instanciación adecuada
        // this.elements = ....
    }

    @Override
    public boolean add(T element) {
        // TODO Completar con la implementación correspondiente
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        // TODO Completar con la implementación correspondiente
        return 0;
    }

    @Override
    public void removeOccurrence(T element) {
        // TODO Completar con la implementación correspondiente
    }

    @Override
    public void removeAll(T element) {
        // TODO Completar con la implementación correspondiente
    }

    @Override
    public int size() {
        // TODO Completar con la implementación correspondiente
       return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
