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
import com.springBookDB.springBookDB.bean.user.privilege.entity.Privilege;
import com.springBookDB.springBookDB.bean.user.privilege.service.PrivilegeService;
import com.springBookDB.springBookDB.bean.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller
public class EditController {
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookImgService bookImgService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private UserService userService;
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private BookService bookService;



    @PostMapping("/edituser")
    public String editUser (@RequestParam(name = "userid") String userid,@RequestParam(name="username") String username,@RequestParam(name = "email") String email,@RequestParam(name="privilegeradio") String privilegeid){
        Integer privilegeId = Integer.parseInt(privilegeid);
        Privilege privilege = privilegeService.findById(privilegeId);

        Integer userId = Integer.parseInt(userid);

        User userToEdit = userService.findById(userId);
        userToEdit.setUsername(username);
        userToEdit.setUserEmail(email);
        userToEdit.setPrivilegeId(privilege);
        userService.saveUser(userToEdit);

        return "redirect:/users";
    }

    @PostMapping("/editnote")
    public String editNote (Authentication authentication, Model model,@RequestParam(name = "noteid")String note,@RequestParam(name = "notetitle")String noteTitle,
                            @RequestParam(name = "notetext")String noteText,@RequestParam(name = "statusradio") String status,@RequestParam(name ="books" )String book){

        String userInSessionName = authentication.getName();
        User userPrivilegeToGet = userService.findByUsername(userInSessionName);

        if(userPrivilegeToGet.getPrivilegeId().getPrivilegeName().equalsIgnoreCase("Admin")){
            Integer noteId = Integer.parseInt(note);
            Note noteToEdit = noteService.findById(noteId);


            noteToEdit.setNoteTitle(noteTitle);
            noteToEdit.setNoteText(noteText);
            noteService.saveNote(noteToEdit);

            model.addAttribute("books",book);
            return "redirect:/notes";
        }else{
            Integer noteId = Integer.parseInt(note);
            Integer statusValue = Integer.parseInt(status);
            Status statusToEdit = statusService.findById(statusValue);
            Integer bookValue = Integer.parseInt(book);
            Book bookToEdit = bookService.findById(bookValue);



            Note noteToEdit = noteService.findById(noteId);
            noteToEdit.setNoteTitle(noteTitle);
            noteToEdit.setNoteText(noteText);
            noteToEdit.setStatusId(statusToEdit);
            noteToEdit.setBookId(bookToEdit);
            noteService.saveNote(noteToEdit);
            return "redirect:/notes";

        }
    }

    @PostMapping("/editpublisher")
    public String editPublisher (@RequestParam(name = "publishername")String publisher,@RequestParam(name = "publisherid")String publisherId){
        Integer publisherIdToFind = Integer.parseInt(publisherId);
        Publisher publisherToEdit = publisherService.findById(publisherIdToFind);

        publisherToEdit.setPublisherName(publisher);
        publisherService.savePublisher(publisherToEdit);


        return "redirect:/books";
    }
    @PostMapping("/editbookimg")
    public String editBookImg (@RequestParam(name = "bookimgname")String imgName,@RequestParam(name = "bookimgurl")String url, @RequestParam(name = "bookimgid")String imgId){
        Integer bookImgIdToFind = Integer.parseInt(imgId);
        BookImg bookImgToEdit = bookImgService.findById(bookImgIdToFind);

        bookImgToEdit.setBookImgName(imgName);
        bookImgToEdit.setImgPath(url);
        bookImgService.saveBookImg(bookImgToEdit);


        return "redirect:/books";
    }
    @PostMapping("/editauthor")
    public String editAuthor (@RequestParam(name = "authorname")String authorName,@RequestParam(name = "authorsurname")String authorSurname,@RequestParam(name = "authorid")String authorId){
        Integer authorToFind = Integer.parseInt(authorId);
        Author authorToEdit = authorService.findById(authorToFind);

        authorToEdit.setAuthorName(authorName);
        authorToEdit.setAuthorSurname(authorSurname);
        authorService.saveAuthor(authorToEdit);

     return "redirect:/books";
    }
    @PostMapping("/editgenre")
    public String editGenre (@RequestParam(name = "genrename" )String genreName,@RequestParam(name = "genreid" )String genreId){
        Integer genreToFind = Integer.parseInt(genreId);
        Genre genreToEdit = genreService.findById(genreToFind);

        genreToEdit.setGenreName(genreName);
        genreService.saveGenre(genreToEdit);

        return "redirect:/books";
    }
    @PostMapping("/editbook")
    public String editBook (@RequestParam(name = "booktitle")String bookTitle,@RequestParam(name = "bookpages")String bookPages,@RequestParam(name = "bookrating")String bookRating,
                            @RequestParam(name = "bookdate")String bookDate,@RequestParam(name = "bookgenrename")String bookGenreName,@RequestParam(name = "bookpublisherid") String publisherId,
                            @RequestParam(name = "bookimgid") String bookImgId,@RequestParam(name = "authorname")String authorName,@RequestParam(name = "bookinfo") String bookInfo,
                            @RequestParam(name = "bookid")String bookId){

        Integer bookToFind = Integer.parseInt(bookId);
        Book bookToEdit = bookService.findById(bookToFind);

        BigDecimal bookRatingEdit =BigDecimal.valueOf(Double.parseDouble(bookRating));
        Integer bookPagesToEdit = Integer.parseInt(bookPages);
        LocalDate dateEdit = LocalDate.parse(bookDate);
        List<Genre> genreToEdit = genreService.findGenresByGenreName(bookGenreName);
        Integer publisherIdFind = Integer.parseInt(publisherId);
        Publisher publisherToEdit = publisherService.findById(publisherIdFind);
        Integer bookImgIdFind = Integer.parseInt(bookImgId);
        BookImg bookImgToEdit = bookImgService.findById(bookImgIdFind);
        List<Author> authorToEdit = authorService.findAuthorsByAuthorName(authorName);



        bookToEdit.setBookTitle(bookTitle);
        bookToEdit.setBookPages(bookPagesToEdit);
        bookToEdit.setBookRating(bookRatingEdit);
        bookToEdit.setBookPublicationDate(dateEdit);
        bookToEdit.setGenreList(genreToEdit);
        bookToEdit.setPublisherId(publisherToEdit);
        bookToEdit.setBookImgId(bookImgToEdit);
        bookToEdit.setAuthorList(authorToEdit);
        bookToEdit.setBookInfo(bookInfo);
        bookService.saveBook(bookToEdit);

        return "redirect:/books";
    }
}
