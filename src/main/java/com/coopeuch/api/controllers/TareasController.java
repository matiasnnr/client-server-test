package com.coopeuch.api.controllers;

import com.coopeuch.api.models.requests.TareaRequestModel;
import com.coopeuch.api.models.responses.OperationStatusModel;
import com.coopeuch.api.models.responses.TareaResponseObject;
import com.coopeuch.api.models.responses.TareasResponseObject;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    TareaServiceInterface tareaServiceInterface;

    @GetMapping
    @ApiOperation("Retorna una lista con las tareas")
    public ResponseEntity<TareasResponseObject> listarTareas() {
        return tareaServiceInterface.listarTareas();
    }

    @PostMapping
    @ApiOperation("Permite crear una tarea")
    public ResponseEntity<TareaResponseObject> crearTarea(@RequestBody TareaRequestModel tareaRequestModel) {
        return tareaServiceInterface.crearTarea(tareaRequestModel);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation("Permite actualizar una tarea en base a su id")
    public ResponseEntity<TareaResponseObject> actualizarTarea(@RequestBody TareaRequestModel tareaRequestModel,
            @PathVariable long id) {
        return tareaServiceInterface.actualizarTarea(tareaRequestModel, id);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Permite eliminar una tarea en base a su id")
    public OperationStatusModel eliminarTarea(@PathVariable long id) {
        return tareaServiceInterface.eliminarTarea(id);
    }

    @DeleteMapping(path = "/limpiar")
    @ApiOperation("Permite eliminar todas las tareas para testear el frontend")
    public OperationStatusModel eliminarTodo() {
        return tareaServiceInterface.eliminarTodo();
    }

}