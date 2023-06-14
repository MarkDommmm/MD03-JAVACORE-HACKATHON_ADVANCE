package Service;

import Exam_Advance.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SongService {
    private List<Song> songs;

    public SongService() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void updateSong(Song song) {
        // Tìm kiếm bài hát trong danh sách theo songId và cập nhật thông tin
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(song.getSongId())) {
                songs.set(i, song);
                break;
            }
        }
    }

    public void deleteSong(String songId) {
        // Tìm kiếm bài hát trong danh sách theo songId và xóa
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(songId)) {
                songs.remove(i);
                break;
            }
        }
    }

    public Song findSongById(String songId) {
        // Tìm kiếm bài hát trong danh sách theo songId
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                return song;
            }
        }
        return null;
    }

    public List<Song> getAllSongs() {
        return songs;
    }

    public boolean validateSong(Song song) {
        // Kiểm tra dữ liệu hợp lệ
        if (song.getSongName() == null || song.getSongName().isEmpty()) {
            return false;
        }

        if (song.getSinger() == null) {
            return false;
        }

        if (song.getSongWriter() == null || song.getSongWriter().isEmpty()) {
            return false;
        }

        return true;
    }

    public List<Song> getLatestSongs(int count) {
        // Sort songs based on their created date in descending order
        Collections.sort(songs, (s1, s2) -> s2.getCreatedDate().compareTo(s1.getCreatedDate()));

        // Get the first 'count' songs from the sorted list
        int numSongs = Math.min(count, songs.size());
        return songs.subList(0, numSongs);
    }

    public List<Song> searchSongByArtistOrGenre(String keyword) {
        List<Song> searchResults = new ArrayList<>();


        for (Song song : songs) {
            String artistName = song.getSongName();


            if (artistName.equalsIgnoreCase(keyword)) {
                searchResults.add(song);
            }
        }

        return searchResults;
    }
}
