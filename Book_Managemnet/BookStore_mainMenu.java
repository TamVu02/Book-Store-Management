package bookstore_projectcsd301;

public class BookStore_mainMenu {

    public static void main(String[] args) {
        //get book tree from bookRBTree.dat
        manageBook managing = new manageBook();
        book bookTree = managing.getBookTree();
        int choice;
        getInput enterInput = new getInput();
        display display = new display();
        while (true) {
            display.displayMainMenu();
            //user enter option
            choice = enterInput.getInteger("choice", 0, 6);
            switch (choice) {
                //insert to booktree
                case 1:
                    bookTree = managing.addBookToTree(bookTree);
                    break;

                //delete book from tree
                case 2:
                    bookTree = managing.delBookFromTree(bookTree);
                    break;

                //search from booktree
                case 3:
                    managing.searchBookFromTree(bookTree);
                    break;

                //update a book from booktree
                case 4:
                    bookTree = managing.updateBookFromTree(bookTree);
                    break;

                //display booktree
                case 5:
                    display.displayTraverseOption();
                    int displayChoice = enterInput.getInteger("Display option", 1, 4);
                    switch (displayChoice) {
                        //inorder traverse
                        case 1:
                            managing.inorder(bookTree);
                            break;

                        //postorder traverse
                        case 2:
                            managing.postorder(bookTree);
                            break;

                        //preorder traverse
                        case 3:
                            managing.preorder(bookTree);
                            break;

                        //breadth-first traverse
                        case 4:
                            managing.bfs(bookTree);
                            break;
                    }
                    break;

                //display tree
                case 6:
                    managing.printHelper(bookTree, " ", true);
                    break;

                //exit from program and save change to bookRBTree.dat
                case 0:
                    managing.updateTree(bookTree);
                    System.exit(0);
                    break;

            }

        }

    }

}
