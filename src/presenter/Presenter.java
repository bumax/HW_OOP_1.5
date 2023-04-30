package presenter;

import model.Model;
import model.User;
import model.base.CustomData;
import model.custom_data.Name;
import view.View;

public class Presenter {
    public Presenter() {

    }

    public void mainMenu() {
        int cmd = 0;
        do {
            view.mainMenu();
            cmd = view.getIntValue("команду");
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
                        , new CustomData[]{new Name("Отчество", view.getStrValue("отчество"))})));
                break;
                
        }


    }


    private Model model = new Model();
    private View view = new View();


}
