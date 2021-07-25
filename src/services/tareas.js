import axios from 'axios'

const baseUrl = 'http://localhost:8080/tareas'

const obtenerTareas = async () => {
  const response = await axios.get(baseUrl)
  return response.data
}

const crearTarea = async (descripcion) => {
  const object = { descripcion, vigente: true }
  const response = await axios.post(baseUrl, object)
  return response.data
}

const actualizarTarea = async (tarea) => {
  const response = await axios.put(`${baseUrl}/${tarea.id}`, tarea)
  return response.data
}

const eliminarTarea = async (id) => {
  const response = await axios.delete(`${baseUrl}/${id}`)
  return response.data
}

const eliminarTodo = async () => {
  try {
    await axios.delete(`${baseUrl}/limpiar`)
    return true
  } catch (error) {
    console.log(`error`, error)
    return false
  }
}

// eslint-disable-next-line import/no-anonymous-default-export
export default { obtenerTareas, crearTarea, actualizarTarea, eliminarTarea, eliminarTodo }