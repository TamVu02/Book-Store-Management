package bookstore_projectcsd301;

public class display {

    void displayMainMenu() {
        System.out.println("\n");
        System.out.print("----- Main menu -----\n"
                + "1. Insert book to bookTree\n"
                + "2. Delete book from bookTree\n"
                + "3. Search book from bookTree\n"
                + "4. Update book from bookTree\n"
                + "5. Traverse book from bookTree\n"
                + "6. Display tree\n"
                + "0. Exit\n"
                + "Your choice: ");
    }

    void displayTraverseOption() {
        System.out.println("\n");
        System.out.print("----- Traverse Option -----\n"
                + "1. In-order traverse\n"
                + "2. Post-order traverse\n"
                + "3. Pre-order traverse\n"
                + "4. Breadth-first traverse\n"
                + "Your choice: ");
    }
    
    void displayFeature(){
        System.out.println("\n");
        System.out.print("----- Update Feature -----\n"
                + "1. Book's ID\n"
                + "2. Book's title\n"
                + "3. Book's author\n"
                + "4. Book's total number of pages\n"
                + "5. Book's average rating\n"
                + "6. Book's publication's date\n"
                + "7. Book's publisher\n"
                + "Your choice: ");
    }

}
