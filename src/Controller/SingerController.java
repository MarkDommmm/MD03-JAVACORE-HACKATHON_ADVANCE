package Controller;

import Exam_Advance.Singer;
import Service.SingerService;

import java.util.Scanner;

public class SingerController {
    private SingerService singerService;
    private Scanner scanner;

    public SingerController() {
        singerService = new SingerService();
        scanner = new Scanner(System.in);
    }

    public void addSinger() {
        Singer singer = new Singer();

        System.out.print("Nhập tên ca sĩ: ");
        singer.setSingerName(scanner.nextLine());

        System.out.print("Nhập tuổi: ");
        singer.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập quốc tịch: ");
        singer.setNationality(scanner.nextLine());

        System.out.print("Nhập giới tính (true/false): ");
        singer.setGender(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Nhập thể loại: ");
        singer.setGenre(scanner.nextLine());

        if (singerService.validateSinger(singer)) {
            singerService.addSinger(singer);
            System.out.println("Thêm ca sĩ thành công");
        } else {
            System.out.println("Dữ liệu không hợp lệ. Không thể thêm ca sĩ");
        }
    }

    public void updateSinger() {
        System.out.print("Nhập ID ca sĩ cần cập nhật: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        Singer singer = singerService.findSingerById(singerId);
        if (singer != null) {
            System.out.print("Nhập tên ca sĩ: ");
            singer.setSingerName(scanner.nextLine());

            System.out.print("Nhập tuổi: ");
            singer.setAge(Integer.parseInt(scanner.nextLine()));

            System.out.print("Nhập quốc tịch: ");
            singer.setNationality(scanner.nextLine());

            System.out.print("Nhập giới tính (true/false): ");
            singer.setGender(Boolean.parseBoolean(scanner.nextLine()));

            System.out.print("Nhập thể loại: ");
            singer.setGenre(scanner.nextLine());

            if (singerService.validateSinger(singer)) {
                singerService.updateSinger(singer);
                System.out.println("Cập nhật thông tin ca sĩ thành công");
            } else {
                System.out.println("Dữ liệu không hợp lệ. Không thể cập nhật thông tin ca sĩ");
            }
        } else {
            System.out.println("Không tìm thấy ca sĩ có ID " + singerId);
        }
    }

    public void deleteSinger() {
        System.out.print("Nhập ID ca sĩ cần xóa: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        Singer singer = singerService.findSingerById(singerId);
        if (singer != null) {
            singerService.deleteSinger(singerId);
            System.out.println("Xóa ca sĩ thành công");
        } else {
            System.out.println("Không tìm thấy ca sĩ có ID " + singerId);
        }
    }

    public void displayAllSingers() {
        System.out.println("Danh sách ca sĩ:");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-15s | %-6s | %-20s%n",
                "ID", "Tên ca sĩ", "Tuổi", "Quốc tịch", "Giới tính", "Thể loại");
        System.out.println("----------------------------------------------------");

        for (Singer singer : singerService.getAllSingers()) {
            System.out.printf("%-10d | %-20s | %-10d | %-15s | %-6s | %-20s%n",
                    singer.getSingerId(), singer.getSingerName(), singer.getAge(),
                    singer.getNationality(), (singer.isGender() ? "Nam" : "Nữ"), singer.getGenre());
        }

        System.out.println("----------------------------------------------------");
    }
}
