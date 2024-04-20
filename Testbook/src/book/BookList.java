package book;

/**
 * @ProjectName: Testbook
 * @Package: book
 * @ClassName: BookList
 * @author: Yxb
 * @Description: 书架
 * @Date: 2024/4/20 11:34
 * @Version: 1.0
 */
public class BookList {

    private Book[] books;

    private int usedSize;//记录当前书架上 实际存放书的 数量

    public BookList(){
        this.books = new Book[10];
        //放好书

    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook(int pos){
        return books[pos];
    }

    public void setBook(int pos,Book book){
        books[pos] = book;
    }
}