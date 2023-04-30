package model;

import model.base.CustomData;
import model.custom_data.Name;
import model.custom_data.PhoneNumber;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class User {
    public User(String firstName, String lastName, String phone, String description, CustomData[] customData) throws Exception {
        this.firstName = new Name("Имя", firstName);
        this.lastName = new Name("Фамилия", lastName);
        this.phone = new PhoneNumber("Номер телефона", phone);
        this.date = LocalDateTime.now();
        this.description = description;
        for (CustomData cd : customData) {
            this.customData.put(cd.getDataName(), cd);
        }
    }

    /**
     * Имя
     */
    private Name firstName;
    /**
     * Фамилия
     */
    private Name lastName;
    /**
     * Номер телефона
     */
    private PhoneNumber phone;
    /**
     * Дата добавления/изменения контакта
     */
    private LocalDateTime date;
    /**
     * Описание
     */
    private String description;
    /**
     * Дополнительные поля
     */
    private Map<String, CustomData> customData = new HashMap<>();


    public Name getFirstName() {
        return firstName;
    }

    public Name getLastName() {
        return lastName;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, CustomData> getCustomData() {
        return customData;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Фамилия = ");
        out.append(lastName.getData());
        out.append(", Имя = ");
        out.append(firstName.getData());
        out.append(", Номер телефона = ");
        out.append(phone.getData());
        out.append(", Комментарий = ");
        out.append(description);
        for (String ks_cs :customData.keySet()) {
            out.append(", " + ks_cs + " = ");
            out.append(customData.get(ks_cs).getData().toString());
        }
        return out.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        // 2 контакта равны, если у них одинаковые номера телефонов и одно и то же время добавления
        return this.phone.getData().equals(((User) obj).phone.getData()) && this.date == ((User) obj).date;
    }
}
