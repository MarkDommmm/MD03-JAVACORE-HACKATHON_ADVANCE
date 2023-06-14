package Exam_Advance;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        // Constructor mặc định
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter,
                Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bài hát (4 ký tự, bắt đầu bằng S): ");
        songId = scanner.nextLine();

        System.out.print("Nhập tên bài hát: ");
        songName = scanner.nextLine();

        System.out.print("Nhập mô tả bài hát: ");
        descriptions = scanner.nextLine();

        // Nhập danh sách ca sĩ
        System.out.println("Danh sách ca sĩ:");
        // Gọi phương thức để hiển thị danh sách ca sĩ

        // Nhập id ca sĩ
        System.out.print("Nhập id ca sĩ: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        // Gọi phương thức để lấy ca sĩ từ danh sách theo id

        // Kiểm tra xem ca sĩ có tồn tại không
        if (singer == null) {
            System.out.println("Ca sĩ không tồn tại. Vui lòng thêm ca sĩ trước.");
            // Gọi phương thức để thêm ca sĩ
        }

        System.out.print("Nhập người sáng tác: ");
        songWriter = scanner.nextLine();

        // Thời gian tạo là thời gian hệ thống
        createdDate = new Date();

        System.out.print("Nhập trạng thái bài hát (true/false): ");
        songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả bài hát: " + descriptions);
        System.out.println("Ca sĩ: " + singer.getSingerName());
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái bài hát: " + songStatus);
    }
}
