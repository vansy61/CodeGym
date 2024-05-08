package manager;

import io.Input;

import java.util.ArrayList;
import java.util.List;

public interface ShowListable<E> {
    default void showList(List<E> list) {
        int position = 0;
        int perPage = 5;

        while (true) {
            for (int i = position; i < position + perPage; i++) {
                if(i >= list.size()) {
                    return;
                }
                System.out.println(list.get(i));
            }
            position += perPage;
            System.out.println("Vui lòng bấm enter để xem tiếp, nhập q để thoát!");
            String select = Input.getText();
            if(select.equalsIgnoreCase("q")) {
                return;
            }
        }
    }
}
