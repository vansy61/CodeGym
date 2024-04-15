import java.util.Scanner;

public class Main {
    private static final String[] MAIN_MENU_ITEMS = {
            "1. Thêm mới sinh viên",
            "2. Xóa sinh viên",
            "3. Sửa sinh viên",
            "4. Tìm kiếm sinh viên theo ID",
            "5. Tìm kiếm sinh viên theo tên",
            "6. Học viên có điểm trung bình lớn nhất",
            "7. Hiển thị tất cả",
            "0. Thoát"
    };

    public static void main(String[] args) {
        while(true) {
            for(String item : MAIN_MENU_ITEMS) {
                System.out.println(item);
            }

            Scanner input = new Scanner(System.in);
            int selected_menu = input.nextInt();

            switch (selected_menu) {
                case 0:
                    return;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    System.out.println("Không hợp lệ, vui lòng chọn lại!");
            }

        }
    }
}