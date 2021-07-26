import React, { useState } from 'react'
import tareaService from '../services/tareas'
import { actualizarTarea as updateTask, eliminarTarea as deleteTask } from '../reducers/tareaReducer'

const Tarea = ({ tarea, dispatch }) => {
    const [isDisabled, setIsDisabled] = useState(true)
    const [descripcion, setDescripcion] = useState(tarea.descripcion)
    const [vigente, setVigente] = useState(tarea.vigente)


    const editarTarea = async () => {

        if (!descripcion) return window.alert('El input de editar tarea no puede estar vacío.')

        if (!isDisabled && tarea.descripcion === descripcion && tarea.vigente === vigente) {
            return window.alert('Para editar una tarea su descripción o vigencia deben tener modificaciones.')
        }

        setIsDisabled(!isDisabled)

        // si no está deshabilitado es porque está editando y al dar click debería enviar los datos al servidor
        if (!isDisabled) {
            tarea.descripcion = descripcion
            tarea.vigente = vigente
            console.log(`tarea`, tarea)
            const { result } = await tareaService.actualizarTarea(tarea)
            console.log(`result`, result)
            dispatch(updateTask(result))
        }

    }

    const eliminarTarea = async () => {
        await tareaService.eliminarTarea(tarea.id)
        dispatch(deleteTask(tarea))
    }

    return (
        <li>
            <input
                placeholder="Escribe aquí..."
                data-testid="editar"
                style={{ outline: `${isDisabled && 'none'}`, border: `${isDisabled ? 'none' : '1px dashed black'}` }}
                type="text"
                value={descripcion}
                onChange={({ target }) => setDescripcion(target.value)}
                disabled={isDisabled} />
            <input
                disabled={isDisabled}
                type="checkbox"
                id="tarea"
                name="tarea"
                defaultChecked={tarea.vigente}
                onChange={({ target }) => {
                    setVigente(target.checked)
                }}
            />
            <label>vigente</label><br></br>
            <button data-testid="boton-editar" onClick={editarTarea}>{isDisabled ? 'habilitar edición' : 'editar tarea'}</button>
            <button onClick={eliminarTarea}>eliminar tarea</button>
        </li>
    )
}

export default Tarea