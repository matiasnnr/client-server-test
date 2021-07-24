package com.coopeuch.api.services;

import com.coopeuch.api.entities.TareaEntity;
import com.coopeuch.api.models.requests.TareaRequestModel;
import com.coopeuch.api.models.responses.OperationStatusModel;
import com.coopeuch.api.models.responses.TareaResponseObject;
import com.coopeuch.api.models.responses.TareasResponseObject;
import com.coopeuch.api.repositories.TareaRepository;
import com.coopeuch.api.utils.Helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements TareaServiceInterface {

    @Autowired
    TareaRepository tareaRepository;

    @Autowired
    Helpers helper;

    @Override
    public ResponseEntity<TareasResponseObject> listarTareas() {

        TareasResponseObject responseObject = new TareasResponseObject();

        try {

            responseObject.setMessage("Se listaron las tareas correctamente.");
            responseObject.setResult(tareaRepository.findAllByOrderById());
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<TareaResponseObject> crearTarea(TareaRequestModel tareaRequestModel) {

        TareaResponseObject responseObject = new TareaResponseObject();

        try {

            if (!helper.datosValidos(tareaRequestModel)) {
                responseObject.setMessage(
                        "Los campos descripción y vigente no pueden estar vacios. Además, el campo vigente solo debe recibir valores booleanos (true o false).");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            TareaEntity nuevaTarea = new TareaEntity();
            nuevaTarea.setDescripcion(tareaRequestModel.getDescripcion());
            nuevaTarea.setVigente(tareaRequestModel.getVigente());

            responseObject.setMessage("Se creó la tarea correctamente.");
            responseObject.setResult(tareaRepository.save(nuevaTarea));
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<TareaResponseObject> actualizarTarea(TareaRequestModel tareaRequestModel, long id) {

        TareaResponseObject responseObject = new TareaResponseObject();

        try {

            TareaEntity tarea = tareaRepository.findById(id);

            // solo para comprobar que existe
            if (tarea == null) {
                responseObject.setMessage("La tarea que estás intentando actualizar no existe.");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            if (!helper.datosValidos(tareaRequestModel)) {
                responseObject.setMessage(
                        "Los campos descripción y vigente no pueden estar vacios. Además, el campo vigente solo debe recibir valores booleanos (true o false).");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            tarea.setDescripcion(tareaRequestModel.getDescripcion());
            tarea.setVigente(tareaRequestModel.getVigente());

            responseObject.setMessage("Se actualizó la tarea correctamente.");
            responseObject.setResult(tareaRepository.save(tarea));
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public OperationStatusModel eliminarTarea(long id) {

        OperationStatusModel operationStatusModel = new OperationStatusModel();
        operationStatusModel.setName("DELETE");

        try {

            TareaEntity tarea = tareaRepository.findById(id);

            // solo para comprobar que existe
            if (tarea == null) {
                operationStatusModel.setResult("La tarea que estás intentando actualizar no existe.");
                return operationStatusModel;
            }

            tareaRepository.deleteById(id);
            operationStatusModel.setResult("EXITOSO");
            return operationStatusModel;
        } catch (Exception e) {
            operationStatusModel.setResult("FALLIDO: " + e);
            return operationStatusModel;
        }

    }

}