package presenter;

import model.Model;
import model.User;
import model.base.CustomData;
import model.custom_data.Email;
import model.custom_data.Name;
import view.View;

import java.io.FileNotFoundException;

public class Presenter {
    public Presenter() throws FileNotFoundException {
        model = new Model();
        view = new View();
        model.importCSV("test_data.csv");
    }

    public void mainMenu() throws Exception {
        int cmd = 0;
        do {
            view.mainMenu();
            cmd = view.getIntValue("команду");
            selectCmd(cmd);
        } while (cmd != 0);
    }

    private void selectCmd(int command) throws Exception {
        switch (command) {
            case 1:
                view.showAllData(model.toString());
                break;
            case 2:
                view.addContact(model.addContact(new User(view.getStrValue("имя")
                        , view.getStrValue("фамилию")
                        , view.getStrValue("номер телефона")
                        , view.getStrValue("Комментарий")
                        , new CustomData[]{new Name("Отчество", view.getStrValue("отчество"))
                        , new Email("Электропочта", view.getStrValue("электронный адрес"))})));
                break;
            case 3:
                view.removeContact(model.removeContact(view.getStrValue("номер телефона")));
                break;
            case 4:
                view.editContact(model.updateContact(view.getStrValue("номер телефона обновляемого контакта"),
                        new User(view.getStrValue("имя")
                        , view.getStrValue("фамилию")
                        , view.getStrValue("номер телефона")
                        , view.getStrValue("Комментарий")
                        , new CustomData[]{new Name("Отчество", view.getStrValue("отчество"))
                        , new Email("Электропочта", view.getStrValue("электронный адрес"))})));
                break;
            case 5:
                view.findContact(model.findContact(view.getStrValue("номер телефона")));
                break;
            case 6:
                model.importCSV(view.getStrValue("имя CSV файла для импорта"));
                view.importData();
                break;
            case 7:
                model.importXML(view.getStrValue("имя XML файла для импорта"));
                view.importData();
                break;
            case 8:
                model.exportCSV(view.getStrValue("имя CSV файла для экспорта"));
                view.exportData();
                break;
            case 9:
                model.exportXML(view.getStrValue("имя XML файла для экспорта"));
                view.exportData();
                break;
        }


    }


    private Model model;
    private View view;


}
