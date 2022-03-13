package com.example.demo.models;
import com.example.demo.dao.ScenesDAO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScenesConverter implements Converter<String, Scenes>{
    private final ScenesDAO scenesDAO;

    public ScenesConverter(ScenesDAO scenesDAO) {
        this.scenesDAO = scenesDAO;
    }

    @Override
    public Scenes convert(String id) {
        System.out.println("I get id here: " + id);

        int parseId = Integer.parseInt(id);
        List<Scenes> scenes = scenesDAO.getScenes();

        int index = parseId - 1;
        return scenes.get(index);
    }
}
