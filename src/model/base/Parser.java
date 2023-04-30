package model.base;

import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Parser implements Iterable<User> {
    public Parser(List<User> users) {
        this.users = users;
    }

    private ArrayList<User> parce(){
        return null;
    }

    /**
     * Возвращает массив импортированных пользователей
     *
     * @return
     */
    public User get(int index) {
        if (index < users.size())
            return users.get(index);
        return null;
    }

    ;
    /**
     * Массив с распарсеными данными
     */
    private List<User> users = new ArrayList<>();

    /**
     * Возвращает количество записей в источнике
     *
     * @return
     */
    public int count() {
        return users.size();
    }

    ;

    @Override
    public Iterator<User> iterator() {
        Iterator<User> it = new Iterator<>() {
            private int currIndex = 0;
            private int currSize = users.size();

            @Override
            public boolean hasNext() {
                return currIndex < currSize;
            }

            @Override
            public User next() {
                return users.get(currIndex++);
            }
        };
        return it;
    }
}
