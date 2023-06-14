

import Controller.SingerController;
import Controller.SongController;

import java.util.Scanner;

public class MusicManagement {
    private SingerController singerController;
    private SongController songController;
    private Scanner scanner;

    public MusicManagement() {
        singerController = new SingerController();
        songController = new SongController();
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("************************MUSIC-MANAGEMENT*************************");
        System.out.println("1. Quản lý ca sĩ ");
        System.out.println("2. Quản lý bài hát ");
        System.out.println("3. Tìm kiếm bài hát ");
        System.out.println("4. Thoát ");
        System.out.print("Chọn 1-4: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                displaySingerManagementMenu();
                break;
            case 2:
                displaySongManagementMenu();
                break;
            case 3:
                displaySearchManagementMenu();
                break;
            case 4:
                System.out.println("Đã thoát khỏi chương trình");
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                displayMainMenu();
                break;
        }
    }

    public void displaySingerManagementMenu() {
        System.out.println("**********************SINGER-MANAGEMENT*************************");
        System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
        System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
        System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
        System.out.println("4. Xóa ca sĩ theo mã id");
        System.out.println("5. Thoát");
        System.out.print("Chọn 1-5: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                singerController.addSinger();
                break;
            case 2:
                singerController.displayAllSingers();
                break;
            case 3:
                singerController.updateSinger();
                break;
            case 4:
                singerController.deleteSinger();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                displaySingerManagementMenu();
                break;
        }

        displaySingerManagementMenu();
    }

    public void displaySongManagementMenu() {
        System.out.println("**********************SONG-MANAGEMENT*************************");
        System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới");
        System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
        System.out.println("3. Thay đổi thông tin bài hát theo mã id");
        System.out.println("4. Xóa bài hát theo mã id");
        System.out.println("5. Thoát");
        System.out.print("Chọn 1-5: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                songController.addSong();
                break;
            case 2:
                songController.displayAllSongs();
                break;
            case 3:
                songController.updateSong();
                break;
            case 4:
                songController.deleteSong();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                displaySongManagementMenu();
                break;
        }

        displaySongManagementMenu();
    }

    public void displaySearchManagementMenu() {
        System.out.println("*********************SEARCH-MANAGEMENT************************");
        System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
        System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
        System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
        System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất");
        System.out.println("5. Thoát");
        System.out.print("Chọn 1-5: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
//               Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại
                songController.searchSongByArtistOrGenre();
                break;
            case 2:
//                Tìm kiếm ca sĩ theo tên hoặc thể loại
                break;
            case 3:
//               Hiển thị danh sách bài hát theo thứ tự tên tăng dần
                break;
            case 4:
//                Hiển thị 10 bài hát được đăng mới nhất
                songController.displayLatestSongs();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
                displaySearchManagementMenu();
                break;
        }

        displaySearchManagementMenu();
    }

    public static void main(String[] args) {
        MusicManagement musicManagement = new MusicManagement();
        musicManagement.displayMainMenu();
    }
}
