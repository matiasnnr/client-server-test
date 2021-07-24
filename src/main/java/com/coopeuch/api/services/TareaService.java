package com.coopeuch.api.services;

import com.coopeuch.api.entities.TareaEntity;
import com.coopeuch.api.models.requests.CrearTareaRequestModel;
import com.coopeuch.api.models.responses.ResponseObject;
import com.coopeuch.api.repositories.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements TareaServiceInterface {

    @Autowired
    TareaRepository tareaRepository;

    @Override
    public ResponseEntity<ResponseObject> listarTareas() {

        ResponseObject responseObject = new ResponseObject();

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
    public ResponseEntity<ResponseObject> crearTarea(CrearTareaRequestModel crearTareaRequestModel) {

        ResponseObject responseObject = new ResponseObject();

        try {

            if (!datosValidos(crearTareaRequestModel)) {
                responseObject.setMessage(
                        "Los campos descripción y vigente no pueden estar vacios. Además, el campo vigente solo debe recibir valores booleanos (true o false).");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            TareaEntity nuevaTarea = new TareaEntity();
            nuevaTarea.setDescripcion(crearTareaRequestModel.getDescripcion());
            nuevaTarea.setVigente(crearTareaRequestModel.getVigente());

            responseObject.setMessage("Se creó la tarea correctamente.");
            responseObject.setResult(tareaRepository.save(nuevaTarea));
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<ResponseObject> actualizarTarea(CrearTareaRequestModel crearTareaRequestModel, long id) {

        ResponseObject responseObject = new ResponseObject();

        try {

            TareaEntity tarea = tareaRepository.findById(id);

            // solo para comprobar que existe
            if (tarea == null) {
                responseObject.setMessage("La tarea que estás intentando actualizar no existe.");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            if (!datosValidos(crearTareaRequestModel)) {
                responseObject.setMessage(
                        "Los campos descripción y vigente no pueden estar vacios. Además, el campo vigente solo debe recibir valores booleanos (true o false).");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            tarea.setDescripcion(crearTareaRequestModel.getDescripcion());
            tarea.setVigente(crearTareaRequestModel.getVigente());

            responseObject.setMessage("Se actualizó la tarea correctamente.");
            responseObject.setResult(tareaRepository.save(tarea));
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<ResponseObject> eliminarTarea(long id) {

        ResponseObject responseObject = new ResponseObject();

        try {

            TareaEntity tarea = tareaRepository.findById(id);

            // solo para comprobar que existe
            if (tarea == null) {
                responseObject.setMessage("La tarea que estás intentando eliminar no existe.");
                return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
            }

            tareaRepository.deleteById(id);

            responseObject.setMessage("Se eliminó la tarea correctamente.");
            responseObject.setResult(id);
            return new ResponseEntity<>(responseObject, HttpStatus.OK);

        } catch (Exception e) {

            responseObject.setMessage("Error: " + e);
            return new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    public Boolean datosValidos(CrearTareaRequestModel tarea) {
        if ((tarea.getDescripcion() != null && tarea.getVigente() != null) && (tarea.getDescripcion().length() > 0)
                && (tarea.getVigente().equals(true) || tarea.getVigente().equals(false))) {
            return true;
        }
        return false;
    }

}