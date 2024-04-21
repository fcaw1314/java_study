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
        this.books = new Book[3];
        //放好书
        this.books[0] = new Book("三国演义","罗贯中",20,"小说");
        this.books[1] = new Book("西游记","吴承恩",20,"小说");
        this.books[2] = new Book("斗罗大陆||绝世唐门","唐家三少",45,"小说");

        this.usedSize = 3;

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

    public Book[] getBooks() {
        return books;
    }
}