package manager;

import product.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public interface Storageable<E> {
    default List<E> readDb(File[] files) {
        List<E> list = new ArrayList<>();
        if (files == null) {
            return list;
        }
        System.out.println("Đang Đọc dữ liệu từ database, vui lòng chờ...");
        for (File file : files) {
            System.out.print("Đọc:" + file.getName());
            FileInputStream is = null;
            ObjectInputStream ois = null;
            try {
                is = new FileInputStream(file);
                ois = new ObjectInputStream(is);
                E object = (E) ois.readObject();
                list.add(object);
                System.out.print(" - Thành công!\n");
            }catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println(" - Thất bại!\n");
                file.deleteOnExit();
            }finally {
                try {
                    if (ois!= null) {
                        ois.close();
                    }
                    if (is!= null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Đọc dữ liệu hoàn tất!\n");
        return list;
    }

    void saveDb(E object);
}
