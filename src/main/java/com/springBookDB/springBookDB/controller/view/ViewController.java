package com.springBookDB.springBookDB.controller.view;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ViewController {
    @Autowired
    private BookImgService bookImgService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PublisherService publisherService;



    @GetMapping("/toview")
    public String toFigureView(Authentication authentication, Model model){
        String userInSessionName = authentication.getName();
        User userPrivilegeToGet = userService.findByUsername(userInSessionName);

        if(userPrivilegeToGet.getPrivilegeId().getPrivilegeName().equalsIgnoreCase("Admin")){
            Book book = bookService.findBookByLastId();
            Integer bookId = book.getBookId();
            User user = userService.findUserByLastId();
            Integer userId = user.getUserId();
            Author author = authorService.findAuthorByLastId();
            Integer authorId = author.getAuthorId();
            Note note = noteService.findNoteByLastId();
            Integer noteId = note.getNoteId();
            Genre genre = genreService.findGenreByLastId();
            Integer genreId = genre.getGenreId();
            Publisher publisher = publisherService.findPublisherByLastId();
            Integer publisherId = publisher.getPublisherId();


            model.addAttribute("lastbook",bookId);
            model.addAttribute("lastuser",userId);
            model.addAttribute("lastauthor",authorId);
            model.addAttribute("lastnote",noteId);
            model.addAttribute("lastgenre",genreId);
            model.addAttribute("lastpublisher",publisherId);

            return "/adminhome";
        }else {

            List<Book> books = bookService.findFourBooks();

            model.addAttribute("fourbooks",books);

            return "/userhome";
        }
    }

    @GetMapping("/books")
    public String bookView (Authentication authentication,Model model){
        String userInSessionName = authentication.getName();
        User userPrivilegeToGet = userService.findByUsername(userInSessionName);

        if(userPrivilegeToGet.getPrivilegeId().getPrivilegeName().equalsIgnoreCase("Admin")){
            List<Publisher> publisherList = publisherService.getAllPublisher();
            List<BookImg> bookImgList = bookImgService.getAllBookImg();
            List<Author> authorList = authorService.getAllAuthors();
            List<Genre> genreList = genreService.getAllUGenre();
            List<Book> bookList = bookService.getAllBook();

            model.addAttribute("booklist",bookList);
            model.addAttribute("genrelist", genreList);
            model.addAttribute("authorlist",authorList);
            model.addAttribute("bookimglist",bookImgList);
            model.addAttribute("publisherlist",publisherList);
            return "/adminbookview";
        }else{
            List<Book> bookList = bookService.getAllBook();
            model.addAttribute("booklist",bookList);

            return "/userbookview";
        }

    }

    @GetMapping("/notes")
    public String noteView (Authentication authentication, Model model){
        String userInSessionName = authentication.getName();
        User userName = userService.findByUsername(userInSessionName);

        if(userName.getPrivilegeId().getPrivilegeName().equalsIgnoreCase("Admin")){
            List<Note> noteList = noteService.getAllNote();

            model.addAttribute("notes",noteList);
            return "/adminnoteview";
        }else {
            User user = userService.findByUsername(userName.getUsername());
            List<Note> notes = (List<Note>) noteService.findByUserId(user);
            List <Book> books = bookService.getAllBook();
            List<Status> statusList = statusService.getAllStatus();
            model.addAttribute("statuslist",statusList);
            model.addAttribute("booklist",books);
            model.addAttribute("notelist",notes);
            return "/usernoteview";
        }


    }
}
