package manager;

import io.Input;

public interface GetInfoable {
    default int getInfoIsInt(String title) {
        int value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Input.getInt();
        }while (value < 1);
        return value;
    }

    default String getInfoIsString(String title) {
        String value;
        do {
            System.out.println("Vui lòng nhập " + title + ": ");
            value = Input.getText();
        }while (value.isEmpty());
        return value;
    }
}
