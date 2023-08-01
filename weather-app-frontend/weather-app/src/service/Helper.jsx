import axios from 'axios'


const BASE_URL = 'http://localhost:8080/weather-app/api/v1/'

export const RestAxios = axios.create({
    baseURL : BASE_URL
})