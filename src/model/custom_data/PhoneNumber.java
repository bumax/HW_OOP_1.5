package model.custom_data;

import model.base.CustomData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber extends CustomData<String> {
    public PhoneNumber(String dataName, String data) throws Exception {
        super(dataName, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[\\+80]{1}[0-9\\-\\s\\(\\)\\#]{3,30}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
