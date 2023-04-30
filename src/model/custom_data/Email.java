package model.custom_data;

import model.base.CustomData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends CustomData<String> {
    public Email(String dataName, String data) throws Exception {
        super(dataName, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[ёЁа-яА-Яa-zA-Z0-9\\._-]+@[ёЁа-яА-Яa-zA-Z0-9._-]+\\.[ёЁа-яА-Яa-zA-Z]{2,63}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
