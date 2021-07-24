package com.coopeuch.api.services;

import com.coopeuch.api.models.requests.CrearTareaRequestModel;
import com.coopeuch.api.models.responses.ResponseObject;

import org.springframework.http.ResponseEntity;

public interface TareaServiceInterface {
    public ResponseEntity<ResponseObject> listarTareas();

    public ResponseEntity<ResponseObject> crearTarea(CrearTareaRequestModel crearTareaRequestModel);

    public ResponseEntity<ResponseObject> actualizarTarea(CrearTareaRequestModel crearTareaRequestModel, long id);

    public ResponseEntity<ResponseObject> eliminarTarea(long id);
}
