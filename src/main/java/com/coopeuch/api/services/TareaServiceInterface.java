package com.coopeuch.api.services;

import com.coopeuch.api.models.requests.TareaRequestModel;
import com.coopeuch.api.models.responses.OperationStatusModel;
import com.coopeuch.api.models.responses.TareaResponseObject;
import com.coopeuch.api.models.responses.TareasResponseObject;

import org.springframework.http.ResponseEntity;

public interface TareaServiceInterface {
    public ResponseEntity<TareasResponseObject> listarTareas();

    public ResponseEntity<TareaResponseObject> crearTarea(TareaRequestModel tareaRequestModel);

    public ResponseEntity<TareaResponseObject> actualizarTarea(TareaRequestModel tareaRequestModel, long id);

    public OperationStatusModel eliminarTarea(long id);
}
