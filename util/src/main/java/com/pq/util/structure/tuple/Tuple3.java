package com.pq.util.structure.tuple;

import java.util.Optional;

public class Tuple3<A, B, C> extends Tuple {
    private A a;
    private B b;
    private C c;

    Tuple3(A e, B t, C k) {
        this.a = e;
        this.b = t;
        this.c = k;
    }

    @Override
    public Optional<A> _1() {
        return Optional.of(a);
    }

    @Override
    public Optional<B> _2() {
        return Optional.of(b);
    }

    @Override
    public <C> Optional<C> _3() {
        return Optional.empty();
    }

    @Override
    public <D> Optional<D> _4() {
        return Optional.empty();
    }

    @Override
    public <E> Optional<E> _5() {
        return Optional.empty();
    }

    public static <A, B, C> Tuple3<A, B, C> of(A a, B b, C c) {
        return new Tuple3<A, B, C>(a, b, c);
    }

    @Override
    public String toString() {
        return "Tuple3{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
