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
import com.springBookDB.springBookDB.bean.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveController {


    @Autowired
    private BookService bookService;
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
    private NoteService noteService;




    @PostMapping("/removeuser")
    public String removeUser(@RequestParam(name = "username") String username){
        User userToRemove = userService.findByUsername(username);
        userService.removeUser(userToRemove);
        return "redirect:/users";
    }

    @PostMapping("/removenote")
    public String removeNote (@RequestParam(name = "noteid")String note){
        Integer noteId = Integer.parseInt(note);
        Note noteToRemove = noteService.findById(noteId);
        noteService.removeNote(noteToRemove);
        return "redirect:/notes";
    }

    @PostMapping("/removepublisher")
    public String removePublisher (@RequestParam(name = "publishername")String publisher){
        Publisher publisherToRemove = publisherService.findByName(publisher);
        publisherService.removePublisher(publisherToRemove);

        return "redirect:/books";
    }
    @PostMapping("/removebookimg")
    public String removeBookImg (@RequestParam(name = "bookimgname")String imgName){
        BookImg bookImgToRemove = bookImgService.findByName(imgName);
        bookImgService.removeBookImg(bookImgToRemove);

        return "redirect:/books";
    }
    @PostMapping("/removeauthor")
    public String removeAuthor (@RequestParam(name = "authorname")String authorName){
        Author authorToRemove = authorService.findByName(authorName);
        authorService.removeAuthor(authorToRemove);

        return "redirect:/books";
    }
    @PostMapping("/removegenre")
    public String removeGenre (@RequestParam(name = "genrename")String genreName){
        Genre genreToRemove = genreService.findByName(genreName);
        genreService.removeGenre(genreToRemove);

        return "redirect:/books";
    }
    @PostMapping("/removebook")
    public String removeBook(@RequestParam(name = "booktitle") String bookTitle ){
        Book bookToRemove = bookService.findByName(bookTitle);
        bookService.removeBook(bookToRemove);

        return "redirect:/books";
    }
}
