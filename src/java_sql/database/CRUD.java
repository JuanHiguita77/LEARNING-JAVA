package database;

import java.util.List;

public interface CRUD
{
    //Pasamos los datos que nos llegan, se usa objetos para generalizar
    public Object insert(Object object);

    public List<Object> findAll();

    public boolean update(Object object);

    public void delete(Object object);
}
