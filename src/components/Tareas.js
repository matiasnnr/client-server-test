import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import Tarea from './Tarea'

const Tareas = () => {
  const dispatch = useDispatch()
  const tareas = useSelector(({ tareas }) => tareas);

  return (
    <ul>
      {tareas.map(tarea =>
        <Tarea
          key={tarea.id}
          tarea={tarea}
          dispatch={dispatch}
        />
      )}
    </ul>
  )
}

export default Tareas