import React from 'react'
import Tarea from './Tarea'

const Tareas = ({ tareas, dispatch }) => {
  return (
    <div className="task__list">
      <h4 data-testid="count">Lista de Tareas ({tareas.length})</h4>
      <ul>
        {tareas.map(tarea =>
          <Tarea
            key={tarea.id}
            tarea={tarea}
            dispatch={dispatch}
          />
        )}
      </ul>
    </div>
  )
}

export default Tareas