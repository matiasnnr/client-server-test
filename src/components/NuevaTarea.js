import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { crearTarea } from '../reducers/tareaReducer'
import tareaService from '../services/tareas'

const NuevaTarea = (props) => {
  const dispatch = useDispatch()
  const [descripcion, setDescripcion] = useState('')

  const agregarTarea = async (event) => {
    event.preventDefault()
    const { result } = await tareaService.crearTarea(descripcion)
    dispatch(crearTarea(result))
    setDescripcion('')
  }

  return (
    <form onSubmit={agregarTarea}>
      <input name="tarea" value={descripcion} onChange={({ target }) => setDescripcion(target.value)} />
      <button type="submit">agregar tarea</button>
    </form>
  )
}

export default NuevaTarea