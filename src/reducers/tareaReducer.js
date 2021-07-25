const tareaReducer = (state = [], action) => {
  switch (action.type) {
    case 'NUEVA_TAREA':
      return [...state, action.data]

    case 'TAREAS_INICIALES':
      return action.data

    case 'ACTUALIZAR_TAREA':
      const estadoActualizado = state.map(tarea => tarea.id !== action.data.id ? tarea : action.data)
      return [...estadoActualizado]

    case 'ELIMINAR_TAREA':
      const nuevoEstado = state.filter(tarea => tarea.id !== action.data.id)
      return [...nuevoEstado]

    case 'ELIMINAR_TODO':
      return []

    default:
      return state
  }
}

export const crearTarea = (data) => {
  return {
    type: 'NUEVA_TAREA',
    data
  }
}

export const actualizarTarea = (data) => {
  return {
    type: 'ACTUALIZAR_TAREA',
    data
  }
}

export const eliminarTarea = (data) => {
  return {
    type: 'ELIMINAR_TAREA',
    data
  }
}

export const eliminarTodo = () => {
  return {
    type: 'ELIMINAR_TODO'
  }
}

export const inicializarTareas = (tareas) => {
  return {
    type: 'TAREAS_INICIALES',
    data: tareas,
  }
}

export default tareaReducer