import React from 'react'
import { createStore, combineReducers } from 'redux'
import { Provider } from 'react-redux'
import { render, fireEvent, waitFor, act } from '@testing-library/react'
import tareaReducer from '../reducers/tareaReducer'
import '@testing-library/jest-dom/extend-expect'
import tareaService from '../services/tareas'
import App from '../App'

const reducer = combineReducers({
    tareas: tareaReducer
})
function renderWithRedux(
    component,
    store = createStore(reducer)
) {
    return {
        ...render(<Provider store={store}>{component}</Provider>)
    }
}

describe('Testeando Tareas App', () => {

    it('Render de App', () => {
        const { getByTestId } = renderWithRedux(<App />)
        expect(getByTestId('count')).toHaveTextContent('Lista de Tareas (0)')
    })

    it('Agregamos un texto al input de agregar tarea', () => {
        const { getByTestId } = renderWithRedux(<App />)
        const input = getByTestId('nueva')
        fireEvent.change(input, {
            target: { value: 'Texto para agregar una nueva tarea' }
        })
        expect(input.value).toBe('Texto para agregar una nueva tarea')
    })

    it('Agregamos una nueva tarea a Redux', async () => {
        const state = []
        const action = {
            type: 'NUEVA_TAREA',
            data: {
                id: 1,
                descripcion: 'Intentando agregar una nueva tarea',
                fechaCreacion: new Date(),
                vigente: true
            }
        }

        const nuevoEstado = tareaReducer(state, action)

        expect(nuevoEstado.length).toBe(1)
        expect(nuevoEstado).toContainEqual(action.data)
    })

    it('Eliminar todas las tareas', async () => {
        const { getByText, getByTestId } = renderWithRedux(<App />)

        await waitFor(() => expect(getByTestId('count')).toHaveTextContent('Lista de Tareas (1)'))

        fireEvent.click(getByText('limpiar tareas'))

        await waitFor(() => expect(getByTestId('count')).toHaveTextContent('Lista de Tareas (0)'))
    })

    it('Nueva Tarea en Base de Datos y Redux', async () => {
        // nos aseguramos de limpiar la bd
        await tareaService.eliminarTodo()

        const { getByText, getByTestId } = renderWithRedux(<App />)

        const input = getByTestId('nueva')

        fireEvent.change(input, {
            target: { value: 'Listando una nueva tarea' }
        })

        fireEvent.click(getByText('agregar tarea'))

        await waitFor(() => expect(getByTestId('count')).toHaveTextContent('Lista de Tareas (1)'))
    })
})