package com.springBookDB.springBookDB.controller.action;

import com.springBookDB.springBookDB.bean.book.author.entity.Author;
import com.springBookDB.springBookDB.bean.book.author.service.AuthorService;
import com.springBookDB.springBookDB.bean.book.bookimg.entity.BookImg;
import com.springBookDB.springBookDB.bean.book.bookimg.serivce.BookImgService;
import com.springBookDB.springBookDB.bean.book.entity.Book;
import com.springBookDB.springBookDB.bean.book.genre.entity.Genre;
import com.springBookDB.springBookDB.bean.book.genre.service.GenreService;
import com.springBookDB.springBookDB.bean.book.publisher.entity.Publisher;
import com.springBookDB.springBookDB.bean.book.publisher.service.PublisherService;
import com.springBookDB.springBookDB.bean.book.service.BookService;
import com.springBookDB.springBookDB.bean.user.entity.User;
import com.springBookDB.springBookDB.bean.user.note.entity.Note;
import com.springBookDB.springBookDB.bean.user.note.service.NoteService;
import com.springBookDB.springBookDB.bean.user.note.status.entity.Status;
import com.springBookDB.springBookDB.bean.user.note.status.service.StatusService;
import com.springBookDB.springBookDB.bean.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AddController {


    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookImgService bookImgService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @PostMapping("/addnote")
    public String addNote (Authentication authentication, @RequestParam(name="notetext") String noteText
                            ,@RequestParam(name = "notetitle")String noteTitle,@RequestParam(name ="books" )String book,@RequestParam(name = "statusradio") String status){

        String userInSessionName = authentication.getName();
        User user = userService.findByUsername(userInSessionName);
        Integer bookValue = Integer.parseInt(book);
        Book bookToSet = bookService.findById(bookValue);
        Integer statusValue = Integer.parseInt(status);
        Status statusToSet = statusService.findById(statusValue);



        Note noteToAdd = new Note();
        noteToAdd.setUserId(user);
        noteToAdd.setNoteText(noteText);
        noteToAdd.setNoteTitle(noteTitle);
        noteToAdd.setBookId(bookToSet);
        noteToAdd.setStatusId(statusToSet);
        noteService.saveNote(noteToAdd);

        return "redirect:/notes";
    }
    @PostMapping("/addpublisher")
    public String addPublisher(@RequestParam(name = "publishername")String publisherName){
        Publisher publisherToAdd = new Publisher();

        publisherToAdd.setPublisherName(publisherName);
        publisherService.savePublisher(publisherToAdd);

        return "redirect:/books";

    }
    @PostMapping("/addbookimg")
    public String addBookImg (@RequestParam(name = "bookimgname")String imgName,@RequestParam(name = "bookimgurl")String url){
        BookImg bookImgToAdd = new BookImg();

        bookImgToAdd.setBookImgName(imgName);
        bookImgToAdd.setImgPath(url);
        bookImgService.saveBookImg(bookImgToAdd);


        return "redirect:/books";
    }
    @PostMapping("/addauthor")
    public  String addAuthor (@RequestParam(name = "authorname")String authorName,@RequestParam(name = "authorsurname")String authorSurname){
        Author authorToAdd = new Author();

        authorToAdd.setAuthorName(authorName);
        authorToAdd.setAuthorSurname(authorSurname);
        authorService.saveAuthor(authorToAdd);

        return "redirect:/books";
    }
    @PostMapping("/addgenre")
    public String addGenre (@RequestParam(name = "genrename")String genreName){
        Genre genreToAdd = new Genre();

        genreToAdd.setGenreName(genreName);
        genreService.saveGenre(genreToAdd);


        return "redirect:/books";
    }

    @PostMapping("/addbook")
    public String addBook (@RequestParam(name = "booktitle")String bookTitle,@RequestParam(name = "bookpages")String bookPages,@RequestParam(name = "bookrating")String bookRating,
                           @RequestParam(name = "bookdate")String bookDate,@RequestParam(name = "bookgenrename")String bookGenreName,@RequestParam(name = "bookpublisherid") String publisherId,
                           @RequestParam(name = "bookimgid") String bookImgId,@RequestParam(name = "authorname")String authorName,@RequestParam(name = "bookinfo") String bookInfo ){

        BigDecimal bookRatingAdd =BigDecimal.valueOf(Double.parseDouble(bookRating));
        Integer bookPagesAdd = Integer.parseInt(bookPages);
        LocalDate dateAdd = LocalDate.parse(bookDate);
        List<Genre> genreToAdd = genreService.findGenresByGenreName(bookGenreName);
        Integer publisherIdFind = Integer.parseInt(publisherId);
        Publisher publisherToAdd = publisherService.findById(publisherIdFind);
        Integer bookImgIdFind = Integer.parseInt(bookImgId);
        BookImg bookImgToAdd = bookImgService.findById(bookImgIdFind);
        List<Author> authorToAdd = authorService.findAuthorsByAuthorName(authorName);




        Book bookToAdd = new Book();


        bookToAdd.setBookTitle(bookTitle);
        bookToAdd.setBookPages(bookPagesAdd);
        bookToAdd.setBookRating(bookRatingAdd);
        bookToAdd.setBookPublicationDate(dateAdd);
        bookToAdd.setGenreList(genreToAdd);
        bookToAdd.setPublisherId(publisherToAdd);
        bookToAdd.setBookImgId(bookImgToAdd);
        bookToAdd.setAuthorList(authorToAdd);
        bookToAdd.setBookInfo(bookInfo);
        bookService.saveBook(bookToAdd);

        return "redirect:/books";
    }

}
