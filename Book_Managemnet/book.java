package bookstore_projectcsd301;

import java.io.Serializable;

public class book implements Serializable {

    public bookData data;
    book parent;
    book left;
    book right;
    int color;

    public book() {
    }

    public book(bookData theData) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.data = theData;
        this.color = 1;
    }

    @Override
    public String toString() {
        return "book{" + "data=" + data.getBookID() + ", parent=" + parent.data.getBookID() + ", left=" + left.data.getBookID() + ", right=" + right.data.getBookID() + ", color=" + color + '}';
    }

}
