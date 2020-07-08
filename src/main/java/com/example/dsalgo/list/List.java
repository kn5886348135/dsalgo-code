package com.example.dsalgo.list;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    java.util.List<E> subList(int fromIndex, int toIndex);

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    void add(int index, E element);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean remove(Object o);

    E remove(int index);

    boolean removeAll(Collection<?> c);

    E set(int index, E element);

    boolean containsAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    int indexOf(Object o);

    int lastIndexOf(Object o);

    default void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final ListIterator<E> li = this.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }

    default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
}
