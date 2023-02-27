import axios from 'axios';
import { LOGIN_USER, LOGOUT_USER } from './types';
export function loginUser(dataToSubmit) {
    const request = axios.post('http://10.0.2.2:8080/auth/login', dataToSubmit)
     .then(response => response.data)
     .catch(error => console.log(error))

    return {
        type: LOGIN_USER,
        payload: request
    }
}

export function logoutUser() {
    return {
        type: LOGOUT_USER,
        payload: []
    }
}