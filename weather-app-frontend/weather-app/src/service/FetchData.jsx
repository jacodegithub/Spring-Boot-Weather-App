import { toast } from "react-toastify"
import { RestAxios } from "./Helper"

// const getWeatherDetails = async (city) => { 
//     try {
//         console.log('fetching data', city)
//         const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=3b7a61b69fcba80c3efdeb434adb36d6`)
//         const data = await response.json()

//         console.log('weather data', data)
//     }catch(error) {
//         console.error('error fetching data', error)
//     }
// }

// export default getWeatherDetails

const getWeatherDetails = async(city) => {
    return RestAxios.get(`${city}`)
    .then(response => response.data)
    .catch(error => { toast.error('internal_server_error')})
}

export default getWeatherDetails