package com.service;

import com.database.ChatEntity;
import com.database.ChatUserEntity;
import com.repository.AdminRepository;
import com.repository.ChatRepository;
import com.repository.ChatUserRepository;
import com.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatUserRepository chatUserRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, ChatUserRepository chatUserRepository, FilmRepository filmRepository) {
        this.chatRepository = chatRepository;
        this.chatUserRepository = chatUserRepository;
        this.filmRepository = filmRepository;
    }

    public String returnSetMes() {
        try {
            Date date = new Date();
            chatRepository.newMessege(1, 1, "Cool", 1, date);
//            chatRepository.save(new ChatEntity(1,2,"cool",1,date));
            return "ok";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public List<String> returnMessageContent() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            List<String> mes = new LinkedList<>();
            List<ChatEntity> entities = chatRepository.findAllByFilmIdIsLikeOrderByCreateDateAsc(1);
            for (ChatEntity entity : entities) {
                mes.add(dateFormat.format(entity.getCreateDate()));
                mes.add(entity.getMsg());
                if (mes.size() > 20) return mes;
            }
            return mes;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String checkUserInChat() {
        try {
            if (chatRepository.findAllByUserUsId(1).size() > 0) chatRepository.addUser(1, 1, 1);
            return "User added to chat";
        } catch (NullPointerException ex) {
            return "Error, user not added";
        }
    }

    public String addNewChat() {
        try {
            chatUserRepository.newChatToUser(1, 1, 1);
            return "User added chat";
        } catch (NullPointerException ex) {
            return "Error, user not added";
        }
    }

    public String findAllChatsForUser() {
        try {
            List<ChatUserEntity> chatUserEntities = chatUserRepository.findChatUserEntitiesByIdUsLike(1);
            StringBuilder chatNames = new StringBuilder();
            for (ChatUserEntity chatUserEntity : chatUserEntities) {
                chatNames.append("  Chat Name:  ")
                        .append(filmRepository.findById(chatRepository.findById(chatUserEntity.getId()).getFilmId()).getName());
            }
            return String.valueOf(chatNames);
        } catch (NullPointerException ex) {
            return "Ошибка, пользователь не добавлен";
        }
    }

    public String findChatForFilm() {
        try {
            List<ChatEntity> chatEntities = chatRepository.findAll();
            int film_id = 1;
            ChatEntity chatInfo;
            for (int i = 0; i < chatEntities.size(); i++) {
                if (chatEntities.get(i).getFilmId() == film_id) {
                    chatInfo = chatEntities.get(i);
                }
            }
            return "Find chat Entity for film";
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
