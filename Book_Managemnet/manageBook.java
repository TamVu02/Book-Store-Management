package bookstore_projectcsd301;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.*;

public class manageBook {

    private static final Logger logger
            = Logger.getLogger(manageBook.class.getPackage().getName());

    book header;

    book nullNode;

    public manageBook() {
        nullNode = new book();
        nullNode.color = 0;
        nullNode.left = null;
        nullNode.right = null;
        header = nullNode;
    }

    public void leftRotate(book x) {
        book y = x.right;
        x.right = y.left;
        if (y.left != nullNode) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.header = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(book x) {
        book y = x.left;
        x.left = y.right;
        if (y.right != nullNode) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.header = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void insertFixup(book z) {
        while (z.parent.color == 1) {
            if (z.parent == z.parent.parent.left) { //z.parent is the left child

                book y = z.parent.parent.right; //uncle of z

                if (y.color == 1) { //case 1
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else { //case2 or case3
                    if (z == z.parent.right) { //case2
                        z = z.parent; //marked z.parent as new z
                        leftRotate(z);
                    }
                    //case3
                    z.parent.color = 0; //made parent black
                    z.parent.parent.color = 1; //made parent red
                    rightRotate(z.parent.parent);
                }
            } else { //z.parent is the right child
                book y = z.parent.parent.left; //uncle of z

                if (y.color == 1) {
                    z.parent.color = 0;
                    y.color = 0;
                    z.parent.parent.color = 1;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent; //marked z.parent as new z
                        rightRotate(z);
                    }
                    z.parent.color = 0; //made parent black
                    z.parent.parent.color = 1; //made parent red
                    leftRotate(z.parent.parent);
                }
            }
            if (z == header) {
                break;
            }
        }
        this.header.color = 0;
    }

    public void insert(bookData key) {
        book node = new book();
        node.parent = null;
        node.data = key;
        node.left = nullNode;
        node.right = nullNode;
        node.color = 1;

        book y = null;
        book x = this.header;

        while (x.data != null) {
            y = x;
            if (node.data.getBookID() < x.data.getBookID()) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            header = node;
        } else if (node.data.getBookID() < y.data.getBookID()) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }
        insertFixup(node);
    }

    public void printTree() {
        printHelper(this.header, "", true);
    }

    public void printHelper(book header, String indent, boolean last) {
        if (header.data != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            String sColor = header.color == 1 ? "RED" : "BLACK";
            System.out.println(header.data.getBookID() + "(" + sColor + ")");
            printHelper(header.left, indent, false);
            printHelper(header.right, indent, true);
        }
    }

    public void inorder(book n) {
        if (n.data != null) {
            inorder(n.left);
            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
            inorder(n.right);
        }
    }

    public ArrayList<bookData> inorderGUI(book n) {
        ArrayList<bookData> inorder = new ArrayList();
        inorderAddArray(inorder, n);
        return inorder;
    }

    void inorderAddArray(ArrayList<bookData> inorder, book n) {
        if (n.data != null) {
//            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
            inorderAddArray(inorder, n.left);
            inorder.add(n.data);
            inorderAddArray(inorder, n.right);
        }
    }

    public book getBookTree() {
        //add book to bookTree (if empty)
        manageBook managingBook = new manageBook();
        book bookTree = new book(new bookData(0));
        //deserialize the bookRBTree.ser file
        try (
                InputStream file = new FileInputStream("bookRBTree.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);) {
            //deserialize the bookRBTree
            bookTree = (book) input.readObject();
            System.out.println("Success retrieve book tree from bookRBTree.dat");
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Cannot perform input. Object type 'book' not found.", ex);
        } catch (IOException ex) {
            //write to file bookRBTree if empty
            String line;
            String splitBy = ",";
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //open csv file
            try {
                InputStream inputStream = new FileInputStream("dataBook.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                line = reader.readLine();
                //read each line
                while ((line = reader.readLine()) != null) {
                    bookData bookDatas = new bookData();
                    String[] datas = line.split(splitBy);
                    if (datas.length != 12 || line.startsWith("bookID")) {
                        continue;
                    }
                    //set data to book object
                    bookDatas.setBookID(Integer.parseInt(datas[0]));
                    bookDatas.setTitle(datas[1]);
                    bookDatas.setAuthors(datas[2]);
                    bookDatas.setNumPage(Integer.parseInt(datas[7]));
                    bookDatas.setAvgRating(Double.parseDouble(datas[3]));
                    try {
                        bookDatas.setPublicDate(formatter.parse(datas[10]));
                    } catch (ParseException e) {
                        System.out.println("Date doesn't exist");
                    }
                    bookDatas.setPublisher(datas[11]);
                    managingBook.insert(bookDatas);
                }
                //write book tree to file.ser
                try {
                    FileOutputStream fileOut = new FileOutputStream("bookRBTree.dat", true);
                    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(fileOut));
                    bookTree = (book) managingBook.header;
                    //managingBook.printHelper(bookTree, "  ", true);
                    //managingBook.printTree();
                    out.writeObject(bookTree);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in bookRBTree.dat");
                } catch (IOException ii) {
                    logger.log(Level.SEVERE, "Cannot perform output.", ii);
                }
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(BookStore_mainMenu.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(BookStore_mainMenu.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return bookTree;
    }

    public book addBookToTree(book bookTree) {
        manageBook managingBook = new manageBook();
        managingBook.header = bookTree;
        Scanner sc = new Scanner(System.in);
        getInput enterInput = new getInput();
        bookData newBook = new bookData();
        System.out.println("----- Adding book -----");

        //enter book ID
        System.out.print("Enter book's ID: ");
        int bookID;
        do {
            bookID = enterInput.getInteger("Book's ID", 0, Integer.MAX_VALUE);
        } while (checkIdExist(bookTree, bookID));
        newBook.setBookID(bookID);

        //enter book's title
        System.out.print("Enter book's title: ");
        String bookTitle = sc.nextLine();
        newBook.setTitle(bookTitle);

        //enter book's authors
        System.out.print("Enter book's author: ");
        String bookAuthor = sc.nextLine();
        newBook.setAuthors(bookAuthor);

        //enter book's number of total pages
        System.out.print("Enter book's number of total pages: ");
        int bookPages = enterInput.getInteger("Number of pages", 0, Integer.MAX_VALUE);
        newBook.setNumPage(bookPages);

        //enter book's average rating
        System.out.print("Enter book's average rating: ");
        double bookRating = enterInput.getDouble("Book's rating", 0, Double.MAX_VALUE);
        newBook.setAvgRating(bookRating);

        //enter book's public date
        System.out.print("Enter book's public date: ");
        Date bookPublicDate = enterInput.getDate("Public date");
        newBook.setPublicDate(bookPublicDate);
        //enter book's publisher
        System.out.print("Enter book's publisher: ");
        String bookPublisher = sc.nextLine();
        newBook.setPublisher(bookPublisher);

        //add new book to tree
        managingBook.insert(newBook);
        return managingBook.header;
    }

    public book delBookFromTree(book bookTree) {
        getInput input = new getInput();
        manageBook managing = new manageBook();
        managing.header = bookTree;
        System.out.print("Enter book's ID for deletion: ");
        int delID = input.getInteger("Book's ID", 0, Integer.MAX_VALUE);
        book result = searchBookFromTree(bookTree, delID);
        if (result.data == null) {
            System.out.println("Can't find book with ID " + delID + " for deletion");
        } else {
            managing.delBookFromTree(managing.header, delID);
        }
        return managing.header;
    }

    public void delBookFromTree(book node, int key) {
        book z = nullNode;
        book x, y;
        z = searchBookFromTree(node, key);
        if (z.data == null) {
            System.out.println("Book with ID " + key + " does not exitst in the store");
            return;
        }
        y = z;
        int yOriginalColor = y.color;
        if (z.left.data == null) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right.data == null) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    private void fixDelete(book x) {
        book s;
        while (x != header && x.color == 0) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = header;
                }
            } else {
                s = x.parent.left;
                if (s.color == 1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.right.color == 0 && s.right.color == 0) {
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }

                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = header;
                }
            }
        }
        x.color = 0;
    }

    private void rbTransplant(book u, book v) {
        if (u.parent == null) {
            header = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    public book minimum(book node) {
        while (node.left.data != null) {
            node = node.left;
        }
        return node;
    }

    public void searchBookFromTree(book bookTree) {
        getInput input = new getInput();
        System.out.print("Enter book's ID for searching: ");
        int searchID = input.getInteger("Book's ID", 0, Integer.MAX_VALUE);
        book result = searchBookFromTree(bookTree, searchID);
        if (result.data == null) {
            System.out.println("Can't find book with ID " + searchID);
        } else {
            System.out.println("Result: ");
            System.out.println(result.data.toString());
        }

    }

    public book searchBookFromTree(book bookTree, int bookID) {
        book result = new book();
        while (bookTree.data != null) {
            if (bookID == bookTree.data.getBookID()) {
                result = bookTree;
                break;
            }
            if (bookID < bookTree.data.getBookID()) {
                bookTree = bookTree.left;
            } else {
                bookTree = bookTree.right;
            }
        }
        return result;
    }

    book updateBookFromTree(book bookTree) {
        Scanner sc = new Scanner(System.in);
        getInput input = new getInput();
        display display = new display();
        System.out.print("Enter book's ID for update: ");
        int bookID = input.getInteger("BookID", 0, Integer.MAX_VALUE);
        book result = searchBookFromTree(bookTree, bookID);
        if (result.data == null) {
            System.out.println("Can't find book with ID " + bookID + " for update");
        } else {
            display.displayFeature();
            int option = input.getInteger("Feature option", 1, 7);
            switch (option) {
                //update book's ID
                case 1:
                    System.out.print("Enter new book's ID: ");
                    int newBookID;
                    do {
                        newBookID = input.getInteger("New book's ID", 0, Integer.MAX_VALUE);
                    } while (checkIdExist(bookTree, newBookID));
                    result.data.setBookID(newBookID);
                    break;

                //update book's title
                case 2:
                    System.out.print("Enter new book's title: ");
                    String newBookTitle = sc.nextLine();
                    result.data.setTitle(newBookTitle);
                    break;

                //update book's author
                case 3:
                    System.out.print("Enter new book's author: ");
                    String newBookAuthor = sc.nextLine();
                    result.data.setAuthors(newBookAuthor);
                    break;

                //update book's number of pages
                case 4:
                    System.out.print("Enter new book's total number of pages: ");
                    int newBookPages = input.getInteger("New book's number of pages", 0, Integer.MAX_VALUE);
                    result.data.setNumPage(newBookPages);
                    break;

                //update book's average rating
                case 5:
                    System.out.print("Enter new book's average rating: ");
                    double newBookRating = input.getDouble("New book's average rating", 0, Double.MAX_VALUE);
                    result.data.setAvgRating(newBookRating);
                    break;

                //update book's publication's date
                case 6:
                    System.out.print("Enter new book's publication's date: ");
                    Date newBookDate = input.getDate("New book's publication date");
                    result.data.setPublicDate(newBookDate);
                    break;

                //update book's publisher
                case 7:
                    System.out.print("Enter new book's publisher: ");
                    String newBookPub = sc.nextLine();
                    result.data.setPublisher(newBookPub);
                    break;
            }
        }
        return bookTree;
    }

    public void updateTree(book bookTree) {
        try {
            FileOutputStream fileOut = new FileOutputStream("bookRBTree.dat");
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(fileOut));
            out.writeObject(bookTree);
            out.close();
            fileOut.close();
            System.out.println("Updated data is saved in bookRBTree.dat");
        } catch (IOException ii) {
            logger.log(Level.SEVERE, "Cannot perform output.", ii);
        }
    }

    void postorder(book n) {
        if (n.data != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
        }
    }

    public ArrayList<bookData> postorderGUI(book n) {
        ArrayList<bookData> postorder = new ArrayList();
        postorderAddArray(postorder, n);
        return postorder;
    }

    void postorderAddArray(ArrayList<bookData> postorder, book n) {
        if (n.data != null) {
//            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
            postorderAddArray(postorder, n.left);
            postorderAddArray(postorder, n.right);
            postorder.add(n.data);
        }
    }

    void bfs(book bookTree) {

    }

    void preorder(book n) {
        if (n.data != null) {
            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
            preorder(n.left);
            preorder(n.right);
        }
    }

    public ArrayList<bookData> preorderGUI(book n) {
        ArrayList<bookData> preorder = new ArrayList();
        preorderAddArray(preorder, n);
        return preorder;
    }

    void preorderAddArray(ArrayList<bookData> preorder, book n) {
        if (n.data != null) {
//            System.out.println("BookID: " + n.data.getBookID() + " - Color: " + n.color);
            preorder.add(n.data);
            preorderAddArray(preorder, n.left);
            preorderAddArray(preorder, n.right);
        }
    }

    public boolean checkIdExist(book bookTree, int bookID) {
        if (searchBookFromTree(bookTree, bookID).data != null) {
            System.out.println("Book's ID " + bookID + " has already existed ! Please try-again");
            return true;
        }
        return false;
    }

    public boolean checkDuplicate(book bookTree, int bookID) {
        if (searchBookFromTree(bookTree, bookID).data != null) {
//            System.out.println("Book's ID " + bookID + " has already existed ! Please try-again");
            return true;
        }
        return false;
    }

    public boolean checkDuplicateUpdate(book bookTree, int bookID, int newBookID) {
        if (searchBookFromTree(bookTree, newBookID).data != null) {
            if (bookID != newBookID) {
                return true;
            }
        }
        return false;
    }

    public book getHeader() {
        return header;
    }

    public void setHeader(book header) {
        this.header = header;
    }

}
