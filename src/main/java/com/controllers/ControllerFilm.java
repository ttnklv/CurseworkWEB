package com.controllers;

import com.service.ChatService;
import com.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerFilm {

    private final FilmService filmService;
    private final ChatService chatService;

    @Autowired
    public ControllerFilm(FilmService filmService, ChatService chatService) {
        this.filmService = filmService;
        this.chatService = chatService;
    }

    @GetMapping("/getPopularFilms")
    String getFilms() {
        String info = filmService.getInfoForPopular();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }

    @GetMapping("/getChatForFilm")
    String getChatForFilm() {
        String chat = chatService.findChatForFilm();
        if (chat == null)
            return "DataBase mistake";
        else return chat;
    }

    @GetMapping("/getMainInfoOfTehFilm")
    String getInfoFilm() {
        String info = filmService.findMainInfoForTheFilm();
        if (info == null)
            return "DataBase mistake";
        else return info;
    }
}
