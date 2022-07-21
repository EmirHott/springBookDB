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
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookImgService bookImgService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private StatusService statusService;


    @PostMapping("/search")
    public String toSearchView(@RequestParam(name = "text") String text, Model model){
        List<Book> bookList = bookService.findBookThatContainsInTitle(text);
        model.addAttribute("findedbooks",bookList);
        return "/usersearchview";
    }
    @PostMapping("/usersearch")
    public String searchUsersAdminForm (@RequestParam(name = "finduser") String findUser, Model model){
        User user = userService.findByUsername(findUser);
        List<User> users = userService.getAllUsers();
        model.addAttribute("userlist",users);
        model.addAttribute("findeduser",user);
        return "/adminuserview";
    }

    @PostMapping("/notesearch")
    public String searchNotes (@RequestParam (name="findnote") String findNote, Model model , Authentication authentication){

        String userInSessionName = authentication.getName();
        User userName = userService.findByUsername(userInSessionName);

        if(userName.getPrivilegeId().getPrivilegeName().equalsIgnoreCase("Admin")){
            Integer noteId = Integer.parseInt(findNote);
            Note note = noteService.findById(noteId);
            List<Note> noteList = noteService.getAllNote();
            List<Note> allNoteList = noteService.getAllNote();
            List<Status> statusList = statusService.getAllStatus();

            model.addAttribute("statuslist",statusList);
            model.addAttribute("notelist",noteList);
            model.addAttribute("findednote",note);
            model.addAttribute("notes",allNoteList);

            return "/adminnoteview";
        }else {
            User user = userService.findByUsername(userName.getUsername());
            List<Note> notes = (List<Note>) noteService.findByUserId(user);
            Note note = noteService.findByTitle(findNote);
            List <Book> books = bookService.getAllBook();
            List<Status> statusList = statusService.getAllStatus();
            model.addAttribute("statuslist",statusList);
            model.addAttribute("booklist",books);
            model.addAttribute("findednote", note);
            model.addAttribute("notelist",notes);
            return "/usernoteview";
        }

    }
    @PostMapping("/genresearch")
    public String searchGenre (@RequestParam (name = "findgenre")String genre,Model model){
        Genre genreToFind = genreService.findByName(genre);
        List<Publisher> publisherList = publisherService.getAllPublisher();
        List<BookImg> bookImgList = bookImgService.getAllBookImg();
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllUGenre();
        List<Book> bookList = bookService.getAllBook();

        model.addAttribute("booklist",bookList);
        model.addAttribute("findedgenre",genreToFind);
        model.addAttribute("genrelist", genreList);
        model.addAttribute("authorlist",authorList);
        model.addAttribute("bookimglist",bookImgList);
        model.addAttribute("publisherlist",publisherList);
        return "/adminbookview";
    }

    @PostMapping("/publishersearch")
    public String searchPublisher (@RequestParam(name = "findpublisher")String publisher, Model model){
        Publisher publisherToFind = publisherService.findByName(publisher);
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
        model.addAttribute("findedpublisher", publisherToFind);

        return "/adminbookview";
    }

    @PostMapping("/bookimgsearch")
    public String searchBookImg (@RequestParam(name = "findbookimg") String bookImg, Model model){
        BookImg bookImgToFind = bookImgService.findByName(bookImg);
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
        model.addAttribute("findedbookimg",bookImgToFind);
        return "/adminbookview";
    }
    @PostMapping("/authorsearch")
    public String searchAuthor (@RequestParam(name = "findauthor")String author,Model model){

        Author authorToFind = authorService.findByName(author);
        List<Publisher> publisherList = publisherService.getAllPublisher();
        List<BookImg> bookImgList = bookImgService.getAllBookImg();
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllUGenre();
        List<Book> bookList = bookService.getAllBook();

        model.addAttribute("booklist",bookList);
        model.addAttribute("genrelist", genreList);
        model.addAttribute("findedauthor",authorToFind);
        model.addAttribute("authorlist",authorList);
        model.addAttribute("bookimglist",bookImgList);
        model.addAttribute("publisherlist",publisherList);
        return "/adminbookview";
    }
    @PostMapping("/booksearch")
    public String searchBook (@RequestParam(name = "findbook")String book,Model model){
        Book bookToFind = bookService.findByName(book);
        List<Publisher> publisherList = publisherService.getAllPublisher();
        List<BookImg> bookImgList = bookImgService.getAllBookImg();
        List<Author> authorList = authorService.getAllAuthors();
        List<Genre> genreList = genreService.getAllUGenre();
        List<Book> bookList = bookService.getAllBook();

        model.addAttribute("findedbook",bookToFind);
        model.addAttribute("booklist",bookList);
        model.addAttribute("genrelist", genreList);
        model.addAttribute("authorlist",authorList);
        model.addAttribute("bookimglist",bookImgList);
        model.addAttribute("publisherlist",publisherList);
        return "/adminbookview";
    }
}
