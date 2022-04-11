package br.com.meli.interfaces;

public interface CRUD<T,V> {
    boolean create(V object);
    T read();
    T read(String object);
    void update(V object);
    boolean delete(String object);



}
