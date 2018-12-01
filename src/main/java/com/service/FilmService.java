package com.service;

import com.database.FilmEntity;
import com.database.FilmTagEntity;
import com.database.PostTagEntity;
import com.database.TagEntity;
import com.repository.FilmRepository;
import com.repository.FilmTagRepository;
import com.repository.PostTagRepository;
import com.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final TagRepository tagRepository;
    private final FilmTagRepository filmTagRepository;
    private final PostTagRepository postTagRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, TagRepository tagRepository,
                       FilmTagRepository filmTagRepository, PostTagRepository postTagRepository) {
        this.filmRepository = filmRepository;
        this.tagRepository = tagRepository;
        this.filmTagRepository = filmTagRepository;
        this.postTagRepository = postTagRepository;
    }

    public String getInfoForPopular() {
        try {
            int id_film;
            int count = 0;
            List<TagEntity> tagEntities = tagRepository.findAll();
            TreeMap<Integer, TagEntity> mapTag = new TreeMap<>();
            for (TagEntity tagEntity : tagEntities) {
                mapTag.put(tagEntity.getCount(), tagEntity);
            }
            StringBuilder info = new StringBuilder();

            for (int i = 0; i < mapTag.size(); i++) {
                List<FilmTagEntity> filmTagEntities = filmTagRepository.findAllByIdTag(mapTag.get(i).getId());
                for (int j = 0; j < filmTagEntities.size(); j++) {
                    count++;
                    id_film = filmTagEntities.get(i).getIdFilm();
                    info.append("Name: ")
                            .append(filmRepository.findById(id_film).getName())
                            .append("  Body: ").append(filmRepository.findById(id_film).getBody())
                            .append("  CashBox:  ").append(filmRepository.findById(id_film).getCashbox());
                    if (count > 50) return String.valueOf(info);
                }
            }

            return info.toString();
        } catch (NullPointerException ex) {
            return null;
        }
    }


    //check followers
    public String getInfoForUserNewsFeed() {
        try {
            int id_post;
            int count = 0;
            List<TagEntity> tagEntities = tagRepository.findAll();
            TreeMap<Integer, TagEntity> mapTag = new TreeMap<>();
            for (TagEntity tagEntity : tagEntities) {
                mapTag.put(tagEntity.getCount(), tagEntity);
            }
            StringBuilder info = new StringBuilder();

            for (int i = 0; i < mapTag.size(); i++) {
                List<PostTagEntity> postTagEntities = postTagRepository.findAllByIdTag(mapTag.get(i).getId());
                for (int j = 0; j < postTagEntities.size(); j++) {
                    count++;
                    id_post = postTagEntities.get(i).getIdPost();
                    info.append("Name: ")
                            .append(filmRepository.findById(id_post).getName())
                            .append("  Body: ").append(filmRepository.findById(id_post).getBody())
                            .append("  CashBox:  ").append(filmRepository.findById(id_post).getCashbox());
                    if (count > 50) return String.valueOf(info);
                }
            }

            return info.toString();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findMainInfoForTheFilm() {
        try {
            int film_id = 0;
            FilmEntity filmEntity = filmRepository.findById(film_id);
            return "Name:  " +filmEntity.getName() + "   Body:  " + filmEntity.getBody();
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
