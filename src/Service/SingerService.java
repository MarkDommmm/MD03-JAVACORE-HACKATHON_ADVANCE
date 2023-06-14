package Service;

import Exam_Advance.Singer;

import java.util.ArrayList;
import java.util.List;


public class SingerService {
    private List<Singer> singers;

    public SingerService() {
        singers = new ArrayList<>();
    }

    public void addSinger(Singer singer) {
        singers.add(singer);
    }

    public void updateSinger(Singer singer) {
        // Tìm kiếm ca sĩ trong danh sách theo singerId và cập nhật thông tin
        for (int i = 0; i < singers.size(); i++) {
            if (singers.get(i).getSingerId() == singer.getSingerId()) {
                singers.set(i, singer);
                break;
            }
        }
    }

    public void deleteSinger(int singerId) {
        // Tìm kiếm ca sĩ trong danh sách theo singerId và xóa
        for (int i = 0; i < singers.size(); i++) {
            if (singers.get(i).getSingerId() == singerId) {
                singers.remove(i);
                break;
            }
        }
    }

    public Singer findSingerById(int singerId) {
        // Tìm kiếm ca sĩ trong danh sách theo singerId
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                return singer;
            }
        }
        return null;
    }

    public List<Singer> getAllSingers() {
        return singers;
    }

    public boolean validateSinger(Singer singer) {
        // Kiểm tra dữ liệu hợp lệ
        if (singer.getSingerName() == null || singer.getSingerName().isEmpty()) {
            return false;
        }

        if (singer.getAge() <= 0) {
            return false;
        }

        if (singer.getNationality() == null || singer.getNationality().isEmpty()) {
            return false;
        }

        if (singer.getGenre() == null || singer.getGenre().isEmpty()) {
            return false;
        }

        return true;
    }
}
