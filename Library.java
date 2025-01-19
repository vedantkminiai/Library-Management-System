import java.util.*;
import java.time.LocalTime;

//constructor initializes book object since it's abstract
public abstract class Library {
    private String title;
    private String author;
    private int year;
    private int genre;
    private LocalTime time;
    private boolean available;
    
    public Library(String userTitle, String userAuthor, int userYear, int userGenre, LocalTime userTime) {
        title = userTitle;
        author = userAuthor;
        year = userYear;
        genre = userGenre;
        time = userTime;
    }
    
//Getter methods    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getGenre() {
        return genre;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public abstract boolean getAvailable();
    
    public void changeTime(LocalTime newTime) {
        time = newTime;
    }
    
}
