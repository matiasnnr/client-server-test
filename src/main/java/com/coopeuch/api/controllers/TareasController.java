package com.coopeuch.api.controllers;

import com.coopeuch.api.models.requests.CrearTareaRequestModel;
import com.coopeuch.api.models.responses.ResponseObject;
import com.coopeuch.api.services.TareaServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    TareaServiceInterface tareaServiceInterface;

    @GetMapping
    public ResponseEntity<ResponseObject> listarTareas() {
        return tareaServiceInterface.listarTareas();
    }

    @PostMapping
    public ResponseEntity<ResponseObject> crearTarea(@RequestBody CrearTareaRequestModel crearTareaRequestModel) {
        return tareaServiceInterface.crearTarea(crearTareaRequestModel);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseObject> actualizarTarea(@RequestBody CrearTareaRequestModel crearTareaRequestModel,
            @PathVariable long id) {
        return tareaServiceInterface.actualizarTarea(crearTareaRequestModel, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseObject> eliminarTarea(@PathVariable long id) {
        return tareaServiceInterface.eliminarTarea(id);
    }

}