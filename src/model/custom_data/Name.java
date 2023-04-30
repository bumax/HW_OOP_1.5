package model.custom_data;

import model.base.CustomData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name extends CustomData<String> {
    public Name(String dataName, String data) throws Exception {
        super(dataName, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[ёЁа-яА-Яa-zA-Z0-9\\s\\(\\)\\._-]{1,50}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
