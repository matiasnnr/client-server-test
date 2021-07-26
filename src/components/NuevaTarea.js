import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { crearTarea } from '../reducers/tareaReducer'
import tareaService from '../services/tareas'

const NuevaTarea = () => {
  const dispatch = useDispatch()
  const [descripcion, setDescripcion] = useState('')

  const agregarTarea = async (event) => {
    event.preventDefault()

    if (!descripcion) return window.alert('El input de agregar tarea no puede estar vacío.')

    const { result } = await tareaService.crearTarea(descripcion)
    dispatch(crearTarea(result))
    setDescripcion('')
  }

  return (
    <form onSubmit={agregarTarea}>
      <input
        data-testid="nueva"
        placeholder="Escribe aquí..."
        name="tarea"
        value={descripcion}
        onChange={({ target }) => setDescripcion(target.value)} />
      <button type="submit">agregar tarea</button>
    </form>
  )
}

export default NuevaTarea