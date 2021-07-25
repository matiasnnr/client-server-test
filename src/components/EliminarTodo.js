import React from 'react'
import { useDispatch } from 'react-redux'
import { eliminarTodo as deleteAll } from '../reducers/tareaReducer'
import tareaService from '../services/tareas'

const EliminarTodo = ({ size }) => {
    const dispatch = useDispatch()

    const eliminarTodo = async () => {
        await tareaService.eliminarTodo()
        dispatch(deleteAll())
    }

    if (!size) return null

    return (
        <button type="button" onClick={eliminarTodo}>limpiar tareas</button>
    )
}

export default EliminarTodo
