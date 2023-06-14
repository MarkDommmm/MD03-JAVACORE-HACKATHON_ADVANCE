package Controller;

import Exam_Advance.Singer;
import Exam_Advance.Song;
import Service.SingerService;
import Service.SongService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class SongController {
    private SongService songService;
    private SingerService singerService;
    private Scanner scanner;

    public SongController() {
        songService = new SongService();
        singerService = new SingerService();
        scanner = new Scanner(System.in);
    }

    public void addSong() {
        Song song = new Song();

        System.out.print("Nhập ID bài hát: ");
        song.setSongId(scanner.nextLine());

        System.out.print("Nhập tên bài hát: ");
        song.setSongName(scanner.nextLine());

        System.out.print("Nhập mô tả bài hát: ");
        song.setDescriptions(scanner.nextLine());

        // Hiển thị danh sách ca sĩ để người dùng chọn
        System.out.println("Danh sách ca sĩ:");
        for (Singer singer : singerService.getAllSingers()) {
            System.out.println("ID ca sĩ: " + singer.getSingerId() + ", Tên ca sĩ: " + singer.getSingerName());
        }
        System.out.print("Nhập ID ca sĩ: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        Singer singer = singerService.findSingerById(singerId);
        if (singer != null) {
            song.setSinger(singer);
        } else {
            System.out.println("Không tìm thấy ca sĩ có ID " + singerId);
            return;
        }

        System.out.print("Nhập người sáng tác: ");
        song.setSongWriter(scanner.nextLine());

        if (songService.validateSong(song)) {
            songService.addSong(song);
            System.out.println("Thêm bài hát thành công");
        } else {
            System.out.println("Dữ liệu không hợp lệ. Không thể thêm bài hát");
        }
    }

    public void updateSong() {
        System.out.print("Nhập ID bài hát cần cập nhật: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            System.out.print("Nhập tên bài hát: ");
            song.setSongName(scanner.nextLine());

            System.out.print("Nhập mô tả bài hát: ");
            song.setDescriptions(scanner.nextLine());

            // Hiển thị danh sách ca sĩ để người dùng chọn
            System.out.println("Danh sách ca sĩ:");
            for (Singer singer : singerService.getAllSingers()) {
                System.out.println("ID ca sĩ: " + singer.getSingerId() + ", Tên ca sĩ: " + singer.getSingerName());
            }
            System.out.print("Nhập ID ca sĩ: ");
            int singerId = Integer.parseInt(scanner.nextLine());

            Singer singer = singerService.findSingerById(singerId);
            if (singer != null) {
                song.setSinger(singer);
            } else {
                System.out.println("Không tìm thấy ca sĩ có ID " + singerId);
                return;
            }

            System.out.print("Nhập người sáng tác: ");
            song.setSongWriter(scanner.nextLine());

            if (songService.validateSong(song)) {
                songService.updateSong(song);
                System.out.println("Cập nhật thông tin bài hát thành công");
            } else {
                System.out.println("Dữ liệu không hợp lệ. Không thể cập nhật thông tin bài hát");
            }
        } else {
            System.out.println("Không tìm thấy bài hát có ID " + songId);
        }
    }

    public void deleteSong() {
        System.out.print("Nhập ID bài hát cần xóa: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            songService.deleteSong(songId);
            System.out.println("Xóa bài hát thành công");
        } else {
            System.out.println("Không tìm thấy bài hát có ID " + songId);
        }
    }

    public void displayAllSongs() {
        System.out.println("Danh sách bài hát:");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-15s | %-10s | %-20s%n",
                "ID", "Tên bài hát", "Mô tả", "Ca sĩ", "Người sáng tác", "Ngày tạo");
        System.out.println("----------------------------------------------------");

        for (Song song : songService.getAllSongs()) {
            System.out.printf("%-10s | %-20s | %-10s | %-15s | %-10s | %-20s%n",
                    song.getSongId(), song.getSongName(), song.getDescriptions(),
                    song.getSinger().getSingerName(), song.getSongWriter(), song.getCreatedDate());
        }

        System.out.println("----------------------------------------------------");
    }

    public void displayLatestSongs() {
        List<Song> latestSongs = songService.getLatestSongs(10);

        if (!latestSongs.isEmpty()) {
            System.out.println("10 bài hát mới nhất:");
            System.out.println("----------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-15s%n", "ID", "Tên bài hát", "Ca sĩ");
            System.out.println("----------------------------------------------------");

            for (Song song : latestSongs) {
                System.out.printf("%-10s | %-20s | %-15s%n",
                        song.getSongId(), song.getSongName(), song.getSinger().getSingerName());
            }

            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Không có bài hát mới nào.");
        }
    }

    public void searchSongByArtistOrGenre() {
        System.out.println("tìm kiếm bài hát theo tên ca sỉ hoặc thể loại");
        System.out.println("Nhập tìm kiếm");
        String text = scanner.nextLine();
        List<Song> searchResult = songService.searchSongByArtistOrGenre(text);
        if (!searchResult.isEmpty()) {
            System.out.println("Kết quả tìm kiếm:");
            System.out.println("----------------------------------------------------");
            System.out.printf("%-10s | %-20s | %-15s%n", "ID", "Tên bài hát", "Ca sĩ");
            System.out.println("----------------------------------------------------");

            for (Song song : searchResult) {
                System.out.printf("%-10s | %-20s | %-15s%n",
                        song.getSongId(), song.getSongName(), song.getSinger().getSingerName());
            }
            System.out.println("----------------------------------------------------");
        } else {
            System.out.println("Không tìm thấy kết quả nào phù hợp.");
        }
    }
}

