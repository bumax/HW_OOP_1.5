package model;

import model.base.CustomData;
import model.base.Exporter;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class CsvExporter extends Exporter {

    public CsvExporter(String filename) {
        this.filename = filename;
    }

    private String filename;
    @Override
    public void export(User[] data) throws IOException {
        StringBuilder output = new StringBuilder();
        for (User user : data) {
            output.append(user.getLastName().getData());
            output.append(";");
            output.append(user.getFirstName().getData());
            output.append(";");
            output.append(user.getPhone().getData());
            output.append(";");
            output.append(user.getDescription());
            output.append(";");
            output.append(buildCD(user.getCustomData()));
            output.append("\n");
        }

        PrintWriter file = new PrintWriter(filename, "Cp1251");
        //BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        //writer.write(output.toString());
       // writer.close();
        file.println(output.toString());
        file.close();
    }

    private String buildCD(Map<String, CustomData> cd) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (String key : cd.keySet()) {
            res.append(cd.get(key).getClass().getSimpleName());
            res.append(":");
            res.append(cd.get(key).getDataName());
            res.append(":");
            res.append(cd.get(key).getData().toString());
            if (i++ + 1 != cd.size())
                res.append("+");
        }
        return res.toString();
    }
}
