package com.coopeuch.api.utils;

import com.coopeuch.api.models.requests.TareaRequestModel;

import org.springframework.stereotype.Component;

@Component
public class Helpers {
    public Boolean datosValidos(TareaRequestModel tarea) {
        if ((tarea.getDescripcion() != null && tarea.getVigente() != null) && (tarea.getDescripcion().length() > 0)
                && (tarea.getVigente().equals(true) || tarea.getVigente().equals(false))) {
            return true;
        }
        return false;
    }
}
