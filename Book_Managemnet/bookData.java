package bookstore_projectcsd301;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bookData implements Serializable{

    int bookID;
    String title;
    String authors;
    int numPage;
    double avgRating;
    Date publicDate;
    String publisher;

    public bookData() {
    }

    public bookData(int bookID) {
        this.bookID = bookID;
    }
    
    public bookData(int bookID, String title, String authors, int numPage, double avgRating, Date publicDate, String publisher) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.numPage = numPage;
        this.avgRating = avgRating;
        this.publicDate = publicDate;
        this.publisher = publisher;
    }
    public bookData(int bookID, String title, String authors, int numPage, double avgRating, Date publicDate, String publisher, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.numPage = numPage;
        this.avgRating = avgRating;
        this.publicDate = publicDate;
        this.publisher = publisher;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        String toPrint = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            toPrint = format.format(publicDate);
        } catch (Exception e) {
        }
        
        return "bookData{" + "bookID=" + bookID + ", title=" + title + ", authors=" + authors + ", numPage=" + numPage + ", avgRating=" + avgRating + ", publicDate=" + toPrint + ", publisher=" + publisher + '}';
    }

}
