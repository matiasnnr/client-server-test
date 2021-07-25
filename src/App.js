import React, { useEffect } from 'react'
import NuevaTarea from './components/NuevaTarea'
import Tareas from './components/Tareas'
import EliminarTodo from './components/EliminarTodo'
import tareaService from './services/tareas'
import { inicializarTareas } from './reducers/tareaReducer'
import { useDispatch, useSelector } from 'react-redux'

const App = () => {
  const dispatch = useDispatch()
  const tareas = useSelector(({ tareas }) => tareas);

  useEffect(() => {
    tareaService
      .obtenerTareas().then(data => dispatch(inicializarTareas(data.result)))
  }, [dispatch])

  return (
    <div>
      <div className="header__actions">
        <NuevaTarea />
        <EliminarTodo size={tareas.length} />
      </div>
      <Tareas tareas={tareas} dispatch={dispatch} />
    </div>
  )
}

export default App