import React, { useEffect } from 'react'
import NuevaTarea from './components/NuevaTarea'
import Tareas from './components/Tareas'
import tareaService from './services/tareas'
import { inicializarTareas } from './reducers/tareaReducer'
import { useDispatch } from 'react-redux'

const App = () => {
  const dispatch = useDispatch()
  useEffect(() => {
    tareaService
      .obtenerTareas().then(data => dispatch(inicializarTareas(data.result)))
  }, [dispatch])

  return (
    <div>
      <NuevaTarea />
      <Tareas />
    </div>
  )
}

export default App