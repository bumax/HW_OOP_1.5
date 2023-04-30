import model.*;
import model.custom_data.Email;

public class Main {
    public static void main(String[] args) throws Exception {

        CsvParse cp = new CsvParse("C:\\Users\\user\\Desktop\\GB\\test_data2.csv");
        //XMLParse cp = new XMLParse("C:\\Users\\user\\Desktop\\GB\\test_data.xml");


        User[] usr = new User[cp.count()];
        int cnt = 0;
        for (User us: cp){
            System.out.println(us.getLastName().getData());
            usr[cnt++] = us;
        }

        //CsvExporter xe = new CsvExporter("C:\\Users\\user\\Desktop\\GB\\test_data2.csv");
        //XMLExporter xe = new XMLExporter("C:\\Users\\user\\Desktop\\GB\\test_data.xml");
        //xe.export(usr);
        //System.out.println(cp);
    }
}